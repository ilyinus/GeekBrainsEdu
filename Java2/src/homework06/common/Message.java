package homework06.common;

import java.io.Serializable;

public class Message implements Serializable {
    private MessageType type;
    private String textData;

    public Message(MessageType type) {
        this.type = type;
        this.textData = null;
    }

    public Message(MessageType type, String textData) {
        this.type = type;
        this.textData = textData;
    }

    public MessageType getType() {
        return type;
    }

    public String getTextData() {
        return textData;
    }
}
