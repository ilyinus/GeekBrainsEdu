package chat.auth;

import chat.User;

import java.util.HashMap;
import java.util.Map;

public class BaseAuthService implements AuthService {

    private static final Map<User, String> USERS = new HashMap<>();

    static {
        USERS.put(new User("login1", "pass1", "Peter"), "Peter");
        USERS.put(new User("login2", "pass3", "Alexey"), "Alexey");
        USERS.put(new User("login3", "pass4", "Oleg"), "Oleg");
    }

    @Override
    public void start() {
        System.out.println("Auth service is running");
    }

    @Override
    public void stop() {
        System.out.println("Auth service has been stopped");
    }

    @Override
    public String getNickByLoginPass(String login, String password) {
        User requestedUser = new User(login, password, null);
        return USERS.get(requestedUser);
    }
}
