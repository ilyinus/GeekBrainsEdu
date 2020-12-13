package homework06.client;

import homework06.common.Connection;
import homework06.common.Message;
import homework06.common.MessageType;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.Socket;

public class Client {
    private final String SERVER = "localhost";
    private final int PORT = 8192;
    private Connection connection;

    private class ServerThread implements Runnable {
        private Socket socket;

        public ServerThread(Socket socket) {
            this.socket = socket;
        }

        @Override
        public void run() {
            try (Connection connection = new Connection(socket)) {
                handShake(connection);
                Client.this.connection = connection;
                mainLoop(connection);
            } catch (IOException | ClassNotFoundException e) {
                System.out.println("Server closed remote connection");
            }
        }

        private void handShake(Connection connection) throws IOException, ClassNotFoundException {
            while (true) {

                Message message = connection.receive();

                if (message.getType() == MessageType.NAME_REQUEST) {
                    System.out.println("Enter your name");
                    BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
                    String userName = reader.readLine();
                    if (!userName.isEmpty()) {
                        connection.send(new Message(MessageType.USER_NAME, userName));
                    }
                } else if (message.getType() == MessageType.NAME_ACCEPTED) {
                    System.out.println(message.getTextData());
                    break;
                }

            }

            synchronized (Client.this) {
                Client.this.notify();
            }

        }

        private void mainLoop(Connection connection) throws IOException, ClassNotFoundException {

            while (true) {
                Message message = connection.receive();
                if (message.getType() == MessageType.TEXT_MESSAGE) {
                    System.out.println(message.getTextData());
                } else if (message.getType() == MessageType.SERVER_MESSAGE) {
                    System.out.println("Message from server: " + message.getTextData());
                }
            }

        }

    }

    public Client() {
        try (Socket socket = new Socket(SERVER, PORT)) {

            Thread serverThread = new Thread(new ServerThread(socket));
            serverThread.setDaemon(true);
            serverThread.start();

            synchronized (this) {
                this.wait();
            }

            clientLoop();

        } catch (IOException | InterruptedException e) {
            e.printStackTrace();
        }
    }

    private void clientLoop() {

        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))) {
            while (true) {
                String line = reader.readLine();
                connection.send(new Message(MessageType.TEXT_MESSAGE, line));
                if (line.equals("/end"))
                    break;
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    public static void main(String[] args) {
        new Client();
    }

}
