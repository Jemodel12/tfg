/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Educamos;

import java.awt.Desktop;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;
import javafx.application.Platform;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import javax.swing.JOptionPane;

/**
 * FXML Controller class
 *
 * @author jedelmo
 */
public class PortalController implements Initializable {

    @FXML
    private ImageView educaportal;
    @FXML
    private Pane secretaria;
    @FXML
    private Pane aprendizaje;
    @FXML
    private Pane paginaweb;
    @FXML
    private BorderPane portal;
    @FXML
    private Pane cerrar;
    @FXML
    private Pane cerrar1;
    @FXML
    private Label mensajemotivador;

    @FXML
    private void entorno(MouseEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("Entornoaprendizaje.fxml"));
        Stage stage = new Stage();
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.setTitle("Educamos");
        stage.getIcons().add(new Image("imagen/logoeducamos.png"));
        stage.show();
        Stage primaryStage = (Stage) portal.getScene().getWindow();
        primaryStage.hide();

    }

    @FXML
    private void paginaweb(MouseEvent event) throws IOException {
        try {

            Desktop.getDesktop().browse(new URI("https://aulasciclos2122.castillalamancha.es/"));

        } catch (URISyntaxException ex) {

            System.out.println(ex);

        } catch (IOException e) {

            System.out.println(e);

        }

    }

    @FXML
    private void secretaria(MouseEvent event) {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setHeaderText(null);
        alert.setTitle("Secretaría");
        alert.setContentText("En estos momentos Secretaría esta en mantenimiento");
        alert.showAndWait();

    }

    @FXML
    private void cerrar(MouseEvent event) {
        if (event.getSource() == cerrar) {
            Platform.exit();
            System.exit(0);
        }
    }

    @FXML
    private void mini(MouseEvent event) {
        Stage s = (Stage) ((Node) event.getSource()).getScene().getWindow();
        s.setIconified(true);

    }

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        ArrayList frases = new ArrayList();
        frases.add("    El exito es la suma de pequeños esfuerzos repetidos diá tras diá.");
        frases.add("        El aprendizaje es un tesoro que te seguirá allá donde vayas.");
        frases.add("          Un diá estarás en el lugar que siempre quisistes estar.");
        frases.add("                     No dejes de crecer, sigue avanzando.");
        frases.add("          Con esfuerzo y perseverancia podrás alcanzar tus metas.");
        frases.add("         Puedes lograr todo lo que te propongas, nada es imposible.");
        frases.add("                   Se constante y veras los frutos pronto.");
        frases.add("            Preguntaté si lo que estás haciendo hoy te acerca \n                al lugar en el que quieres estar mañana.");

        int alazar = (int) (Math.random() * 8);
        String fraseelegida = String.valueOf(frases.get(alazar));
        mensajemotivador.setText(fraseelegida);

    }

}
