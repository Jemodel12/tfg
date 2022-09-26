/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Educamos;

import java.awt.Component;
import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;
import javafx.scene.media.AudioClip;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import javax.swing.JOptionPane;

/**
 * FXML Controller class
 *
 * @author jedelmo
 */
public class IniciosesionController implements Initializable {

    private double x = 0;
    private double y = 0;
    
    String usua= "jesus";
    String contrasena="1234";

    @FXML
    private Pane cerrar;
    @FXML
    private Button entrar;
    @FXML
    private AnchorPane iniciosesion;
    @FXML
    private ImageView educa;
    @FXML
    private Pane panelver;
    @FXML
    private Pane panelnover;
    @FXML
    private PasswordField contrasenanover;
    @FXML
    private TextField contrasenaver;
    @FXML
     private TextField usuario;
    @FXML
    private void vercontrasena(MouseEvent event) {
        panelnover.setVisible(true);
        contrasenaver.setVisible(true);
        panelver.setVisible(false);
        contrasenanover.setVisible(false);
        String nover= contrasenanover.getText();
        String ver= contrasenaver.getText();
        contrasenaver.setText(nover);
        contrasenanover.setText(ver);
    }
    @FXML
    private void novercontrasena(MouseEvent event) {
        panelnover.setVisible(false);
        contrasenaver.setVisible(false);
        panelver.setVisible(true);
        contrasenanover.setVisible(true);
        String nover= contrasenanover.getText();
        String ver= contrasenaver.getText();
        contrasenaver.setText(nover);
        contrasenanover.setText(ver);
    }

    @FXML
    private void cerrar(MouseEvent event) {
        if (event.getSource() == cerrar) {
            Platform.exit();
            System.exit(0);
        }
    }

    @FXML
    private void entrarayuda(MouseEvent event) throws IOException {
        jframe abrir = new jframe();
        abrir.setVisible(true);

    }

    @FXML
    private void entrar(MouseEvent event) throws IOException {
        String user = usuario.getText();
        String passwlook = contrasenanover.getText();
        String passw = contrasenaver.getText();
        if((user.equals(usua)&&passwlook.equals(contrasena))||(user.equals(usua)&&passw.equals(contrasena))){
            
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        Parent root = FXMLLoader.load(getClass().getResource("Portal.fxml"));
        Stage stage = new Stage();
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.initStyle(StageStyle.UNDECORATED);
        stage.setTitle("Portal de Educamos");
        stage.getIcons().add(new Image("imagen/logoeducamos.png"));
        root.setOnMousePressed(mouseEvent -> {
            x = mouseEvent.getSceneX();
            y = mouseEvent.getSceneY();
        });
        root.setOnMouseDragged(mouseEvent -> {
            stage.setX(mouseEvent.getScreenX() - x);
            stage.setY(mouseEvent.getScreenY() - y);
        });
        stage.show();
        Stage primaryStage = (Stage) iniciosesion.getScene().getWindow();
        primaryStage.hide();
        
        }//if

    }

    @FXML
    private void mini(MouseEvent event) {
        Stage s = (Stage) ((Node) event.getSource()).getScene().getWindow();
        s.setIconified(true);

    }

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
    }


    private Component getContentPane() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
