/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Educamos;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.media.AudioClip;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

/**
 *
 * @author jedelmo
 */
public class Educamos extends Application {


    private double x = 0.00;
    private double y = 0.00;

    @Override
    public void start(Stage stage) throws Exception {
        play_audio();
        Parent root = FXMLLoader.load(getClass().getResource("Iniciosesion.fxml"));
        stage.initStyle(StageStyle.UNDECORATED);
        root.setOnMousePressed(mouseEvent -> {
            x = mouseEvent.getSceneX();
            y = mouseEvent.getSceneY();
        });
        root.setOnMouseDragged(mouseEvent -> {
            stage.setX(mouseEvent.getScreenX() - x);
            stage.setY(mouseEvent.getScreenY() - y);
        });
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.getIcons().add(new Image("imagen/logoeducamos.png"));
        stage.show();
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
        
    }

    private void play_audio() {
        AudioClip note = new AudioClip(this.getClass().getResource("audioinicio.wav").toString());
        note.play();
    }

}
