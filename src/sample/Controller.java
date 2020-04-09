package sample;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;

import java.net.URL;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.ResourceBundle;

public class Controller implements Initializable {

    @FXML
    private Label lbl_output;

    public void Write_data(String str){
        String current_time = (new SimpleDateFormat("HH:mm:ss").format(new Date()));
        lbl_output.setText(lbl_output.getText()+ "[" + current_time + " INFO]: " + str + "\n");
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        new ThreadManager(this).init();
    }
}
