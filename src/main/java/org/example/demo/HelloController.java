package org.example.demo;


import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import java.io.FileInputStream;
import java.io.FileNotFoundException;



public class HelloController {

    @FXML
    private Button clickme;

    @FXML
    private Label showtext;

    @FXML
    private TextField textinput;

    @FXML
    private ImageView imageid;

    @FXML
    public void clickButton(){
        String iss = textinput.getText();

        //getting text value from scenebuilder textfield  and store in javafx iss variable
        //getText() built in function

        showtext.setText(iss);
        //show the iss text in label showtext

        try {
            Image image = new Image(new FileInputStream("src/main/resources/cat.jpg"));
            imageid.setImage(image);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }


    }


}