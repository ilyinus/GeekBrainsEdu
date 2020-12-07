package homework04;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

public class Controller {

    @FXML
    private TextArea members;

    @FXML
    private TextArea mainArea;

    @FXML
    private TextField msgField;

    public void sendMessage(ActionEvent actionEvent) {
        String msg = msgField.getText();
        if (!msg.isEmpty()) {
            mainArea.appendText(msg+ "\n");
            msgField.clear();
        }
    }
}
