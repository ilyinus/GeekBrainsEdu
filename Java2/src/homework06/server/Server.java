package homework06.server;

import homework06.common.Connection;
import homework06.common.Message;
import homework06.common.MessageType;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.HashMap;
import java.util.Map;

public class Server {
    private static final int PORT = 8192;
    private static Map<String, Connection> clients = new HashMap<>();

    private static class Handler implements Runnable {
        private Socket socket;
        String userName = null;

        public Handler(Socket socket) {
            this.socket = socket;
        }

        @Override
        public void run() {

            try (Connection connection = new Connection(socket)) {
                userName = handShake(connection);
                sendBroadcastMessage(new Message(MessageType.SERVER_MESSAGE, "User " + userName + " has connected to chat"));
                mainLoop(connection);
            } catch (IOException | ClassNotFoundException e) {
                System.out.println("Lost user connection");
            }

            if (userName != null) {
                clients.remove(userName);
                System.out.println("User " + userName + " has disconnected");
                sendBroadcastMessage(new Message(MessageType.TEXT_MESSAGE, "User " + userName + " has left the chat"));
            }

        }

        private String handShake(Connection connection) throws IOException, ClassNotFoundException {
            Message request = new Message(MessageType.NAME_REQUEST);

            while (true) {

                connection.send(request);
                Message response = connection.receive();
                String text;

                if (response.getType() == MessageType.USER_NAME && !(text = response.getTextData()).isEmpty()) {
                    connection.send(new Message(MessageType.NAME_ACCEPTED, "Welcome to chat, dear " + text));
                    clients.put(text, connection);
                    System.out.println("User " + text + " has connected to chat");
                    return text;
                }

            }

        }

        private void sendBroadcastMessage(Message message) {
            clients.forEach((k, v) -> {
                if (!k.equals(userName)) {
                    try {
                        v.send(message);
                    } catch (IOException e) {
                        System.out.println("Error sending broadcast message to user " + k);
                    }
                }
            });
        }

        private void mainLoop(Connection connection) throws IOException, ClassNotFoundException {

            while (true) {

                Message message = connection.receive();

                if (message.getType() == MessageType.TEXT_MESSAGE) {
                    if (message.getTextData().equals("/end"))
                        break;
                    System.out.println("Message from user " + userName + ": " + message.getTextData());
                    sendBroadcastMessage(new Message(MessageType.TEXT_MESSAGE, userName + ": " + message.getTextData()));
                }

            }

        }

    }

    public static void main(String[] args) {

        Thread thread = new Thread(() -> {
            try (ServerSocket serverSocket = new ServerSocket(PORT)) {
                while (true) {
                    Thread clientHandler = new Thread(new Handler(serverSocket.accept()));
                    clientHandler.setDaemon(true);
                    clientHandler.start();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        });

        thread.setDaemon(true);
        thread.start();

        System.out.println("Server has been started");

        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))) {
            while (true) {
                String line = reader.readLine();

                if (line.equals("/stop"))
                    break;

                clients.forEach((k, v) -> {
                    try {
                        v.send(new Message(MessageType.SERVER_MESSAGE, line));
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                });

            }
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

}
