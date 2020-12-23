package chat.clientserver;

public enum CommandType {
    AUTH,
    AUTH_OK,
    AUTH_TIMEOUT,
    ERROR,
    PRIVATE_MESSAGE,
    PUBLIC_MESSAGE,

    INFO_MESSAGE,
    CLIENT_MESSAGE,

    END,
    UPDATE_USERS_LIST,
}
