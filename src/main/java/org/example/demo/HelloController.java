package org.example.demo;

import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;


import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import java.io.*;
import java.net.HttpURLConnection;
import java.net.URL;

public class HelloController {

    @FXML
    private TextField textinput;

    @FXML
    private ImageView img2;

    @FXML
    private Button soundbtn;

    @FXML
    private Button button2;
    //For Saving the image and show the image
    @FXML
    public void clickButton2() throws IOException {
        String id = textinput.getText();

        URL url = new URL("https://picsum.photos/id/" + id + "/300/300");
        HttpURLConnection connection = (HttpURLConnection) url.openConnection();
        connection.setRequestMethod("GET");
        connection.connect();
        InputStream in = connection.getInputStream();

        // Save the image to a file
        String filename = "src/Images/image_" + id + ".jpg";
        FileOutputStream fos = new FileOutputStream(filename);
        byte[] buffer = new byte[1024];
        int bytesRead;
        while ((bytesRead = in.read(buffer)) != -1) {
            fos.write(buffer, 0, bytesRead);
        }
        fos.close();
        in.close();


        File file = new File(filename);
        Image image = new Image(file.toURI().toString());
        img2.setImage(image);
    }

    //for playing a sound
    @FXML
    public void playSound() throws IOException {

        String hitNormal = ("src/Sound/phone.mp3");
        Media sound = new Media(new File(hitNormal).toURI().toString());
        MediaPlayer mediaPlayer = new MediaPlayer(sound);
        mediaPlayer.play();

    }








}