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
import java.util.ResourceBundle;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

/**
 *
 * @author jedelmo
 */
public class EntornoaprendizajeController implements Initializable {

    private double x = 0;
    private double y = 0;
    @FXML
    private BorderPane Entornos;
    @FXML
    private ImageView educa;
    @FXML
    private Pane notificacion;
    @FXML
    private Pane panelnotificacion;
    @FXML
    private Pane inicio;
    @FXML
    private Pane cuenta;
    @FXML
    private Pane asignatura;
    @FXML
    private Pane correo;
    @FXML
    private Pane calendario;
    @FXML
    private Pane panelasignatura;
    @FXML
    private Pane panelcorreo;
    @FXML
    private Pane panelcalendario;
    @FXML
    private Label labelinicio;
    @FXML
    private Label labelcuenta;
    @FXML
    private Label labelasignatura;
    @FXML
    private Label labelcorreo;
    @FXML
    private Label labelcalendario;
    @FXML
    private ImageView entornoaprendizaje;
    @FXML
    private TextField nombre;
    @FXML
    private TextField apellidos;
    @FXML
    private Pane panecambiardatos;
    @FXML
    private Pane paneaceptarcambios;
    @FXML
    private Pane asignaturacuadrado;
    @FXML
    private Pane panelasignaturacuadrado;
    @FXML
    private Pane asignaturalista;
    @FXML
    private Pane panelasignaturalista;
    @FXML
    private ListView<String> listaasignaturas;
    String[] asignaturas = {
        "biologia",
        "lengua",
        "matemáticas",
        "inglés",
        "física y quimica",
        "educación física"};
    @FXML
    private ListView<String> notificacioneslista;
    String[] notificacionesimportantes = {
        "Examen biologia día 19/03/2022",
        "Examen lengua día 16/03/2022",
        "Examen matemáticas día 01/03/2022",
        "Examen educación fisica día 12/04/2022",
        "Examen íngles día 31/04/2022",
        "Examen biologia día 29/05/2022"};
    @FXML
    private Pane enviarcorreo;
    @FXML
    private Pane botonenvio;
    @FXML
    private Pane modificarcorreo;
    @FXML
    private Pane botonmodifico;
    @FXML
    private ComboBox<String> profesores;
    @FXML
    private ComboBox<String> envioprofesores;
    @FXML
    private Pane botoneliminarcorreo;
    @FXML
    private TextField titulocorreo;
    @FXML
    private TextField titulocorreomodificar;
    @FXML
    private ListView<String> listacorreo;
    @FXML
    private AnchorPane panelinicio;
    @FXML
    private AnchorPane pasignatura;
    @FXML
    private AnchorPane pcorreo;
    @FXML
    private AnchorPane pcalendario;
    @FXML
    private AnchorPane panelcuenta;

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        profesores.getItems().addAll("Juan", "Jose Luis", "Emma", "Sebas", "Pepi");
        envioprofesores.getItems().addAll("Juan", "Jose Luis", "Emma", "Sebas", "Pepi");
        listaasignaturas.getItems().addAll(asignaturas);
        notificacioneslista.getItems().addAll(notificacionesimportantes);
        listaasignaturas.getSelectionModel().selectedItemProperty().addListener(new ChangeListener<String>() {
            @Override
            public void changed(ObservableValue<? extends String> observable, String oldValue, String newValue) {
                Alert alert = new Alert(Alert.AlertType.INFORMATION);
                alert.setHeaderText(null);
                alert.setTitle("Asignatura");
                alert.setContentText("Has entrado correctamente a la asignatura");
                alert.showAndWait();
            }

        });

    }

    @FXML
    private void modificar(MouseEvent event) throws Throwable {
        if (botonmodifico.isPressed()) {
            modificarcorreo.setVisible(false);
            enviarcorreo.setVisible(false);
            Alert alert = new Alert(Alert.AlertType.INFORMATION);

        } else {
            modificarcorreo.setVisible(true);
            enviarcorreo.setVisible(false);

        }
    }

    @FXML
    private void aceptarmificar(MouseEvent event) throws Throwable {
        listacorreo.getItems().add(titulocorreo.getText());
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setHeaderText(null);
        alert.setTitle("Modificado");
        alert.setContentText("El correo se ha modifica correctamente ");
        alert.showAndWait();
        modificarcorreo.setVisible(false);
    }

    @FXML
    private void enviar(MouseEvent event) throws Throwable {
        if (botonenvio.isPressed()) {
            enviarcorreo.setVisible(false);
            modificarcorreo.setVisible(false);

        } else {
            enviarcorreo.setVisible(true);
            modificarcorreo.setVisible(false);

        }
    }

    @FXML
    private void eliminarcorreo(MouseEvent event) throws Throwable {
        listacorreo.getItems().remove(titulocorreo.getText());
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setHeaderText(null);
        alert.setTitle("Eliminado");
        alert.setContentText("El correo se ha eliminado correctamente");
        alert.showAndWait();
        enviarcorreo.setVisible(false);
    }

    @FXML
    private void aceptarenvio(MouseEvent event) throws Throwable {
        listacorreo.getItems().add(titulocorreo.getText());
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setHeaderText(null);
        alert.setTitle("Enviado");
        alert.setContentText("El correo se ha enviado correctamente al profesor");
        alert.showAndWait();
        enviarcorreo.setVisible(false);
    }

    private void entroenasignatura(MouseEvent event) throws Throwable {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setHeaderText(null);
        alert.setTitle("Asignatura");
        alert.setContentText("Has entrado correctamente a la asignatura");
        alert.showAndWait();
    }

    @FXML
    private void entroenasignaturacuadrado(MouseEvent event) throws Throwable {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setHeaderText(null);
        alert.setTitle("Asignatura");
        alert.setContentText("Has entrado correctamente a la asignatura");
        alert.showAndWait();

        Parent root = FXMLLoader.load(getClass().getResource("Asignatura.fxml"));
        Stage stage = new Stage();
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.setTitle("Educamos");
        stage.getIcons().add(new Image("imagen/logoeducamos.png"));
        stage.show();
        Stage primaryStage = (Stage) Entornos.getScene().getWindow();
        primaryStage.hide();
    }

    @FXML
    private void asignaturavistacuadrado(MouseEvent event) throws Throwable {
        if (asignaturacuadrado.isPressed()) {
            panelasignaturacuadrado.setVisible(false);
            listaasignaturas.setVisible(true);
        } else {
            panelasignaturacuadrado.setVisible(true);
            listaasignaturas.setVisible(false);
        }
    }

    @FXML
    private void asignaturavistalista(MouseEvent event) throws Throwable {
        if (asignaturalista.isPressed()) {
            panelasignaturacuadrado.setVisible(true);
            listaasignaturas.setVisible(false);
        } else {
            panelasignaturacuadrado.setVisible(false);
            listaasignaturas.setVisible(true);
        }
    }

    @FXML
    private void cambiardatos(MouseEvent event) throws Throwable {
        if (panecambiardatos.isPressed()) {
            nombre.setEditable(false);
            apellidos.setEditable(false);
            paneaceptarcambios.setVisible(false);
        } else {
            nombre.setEditable(true);
            apellidos.setEditable(true);
            paneaceptarcambios.setVisible(true);
        }
    }

    @FXML
    private void aceptarcambiardatos(MouseEvent event) throws Throwable {
        if (panecambiardatos.isPressed()) {

            nombre.setEditable(true);
            apellidos.setEditable(true);
            paneaceptarcambios.setVisible(true);
        } else {
            nombre.setEditable(false);
            apellidos.setEditable(false);
            paneaceptarcambios.setVisible(false);
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setHeaderText(null);
            alert.setTitle("Valided de Nombre y Apellidos");
            alert.setContentText("Se validara el nombre y apellidos escritos antes de cambiarlo definitivamente en la base de datos");
            alert.showAndWait();
        }
    }

    @FXML
    private void accionnotificacion(MouseEvent event) throws Throwable {
        if (notificacion.isPressed()) {
            panelnotificacion.setVisible(false);
        } else {
            panelnotificacion.setVisible(true);
        }
    }

    @FXML
    private void visibleinicio(MouseEvent event) throws Throwable {
        if (inicio.isPressed()) {
            panelinicio.setVisible(false);
            labelinicio.setVisible(false);

        } else {
            panelinicio.setVisible(true);
            panelcuenta.setVisible(false);
            panelasignatura.setVisible(false);
            panelcorreo.setVisible(false);
            panelcalendario.setVisible(false);
            labelinicio.setVisible(true);
            labelcuenta.setVisible(false);
            labelasignatura.setVisible(false);
            labelcorreo.setVisible(false);
            labelcalendario.setVisible(false);
            panelnotificacion.setVisible(false);
        }
    }

    @FXML
    private void visiblecuenta(MouseEvent event) throws Throwable {
        if (cuenta.isPressed()) {
            panelcuenta.setVisible(false);
            labelcuenta.setVisible(false);

        } else {
            panelcuenta.setVisible(true);
            panelinicio.setVisible(false);
            panelasignatura.setVisible(false);
            panelcorreo.setVisible(false);
            panelcalendario.setVisible(false);
            labelcuenta.setVisible(true);
            labelinicio.setVisible(false);
            labelasignatura.setVisible(false);
            labelcorreo.setVisible(false);
            labelcalendario.setVisible(false);
            panelnotificacion.setVisible(false);
        }
    }

    @FXML
    private void visibleasignatura(MouseEvent event) throws Throwable {
        if (asignatura.isPressed()) {
            panelasignatura.setVisible(false);
            labelasignatura.setVisible(false);

        } else {
            panelasignatura.setVisible(true);
            panelinicio.setVisible(false);
            panelcuenta.setVisible(false);
            panelcorreo.setVisible(false);
            panelcalendario.setVisible(false);
            labelasignatura.setVisible(true);
            labelinicio.setVisible(false);
            labelcuenta.setVisible(false);
            labelcorreo.setVisible(false);
            labelcalendario.setVisible(false);
            panelnotificacion.setVisible(false);
        }
    }

    @FXML
    private void visiblecorreo(MouseEvent event) throws Throwable {
        if (correo.isPressed()) {
            panelcorreo.setVisible(false);
            labelcorreo.setVisible(false);
        } else {
            panelcorreo.setVisible(true);
            panelinicio.setVisible(false);
            panelcuenta.setVisible(false);
            panelasignatura.setVisible(false);
            panelcalendario.setVisible(false);
            labelcorreo.setVisible(true);
            labelinicio.setVisible(false);
            labelcuenta.setVisible(false);
            labelasignatura.setVisible(false);
            labelcalendario.setVisible(false);
            panelnotificacion.setVisible(false);

        }
    }

    @FXML
    private void visiblecalendario(MouseEvent event) throws Throwable {
        if (calendario.isPressed()) {
            panelcalendario.setVisible(false);
            labelcalendario.setVisible(false);

        } else {
            panelcalendario.setVisible(true);
            panelinicio.setVisible(false);
            panelcuenta.setVisible(false);
            panelasignatura.setVisible(false);
            panelcorreo.setVisible(false);
            labelcalendario.setVisible(true);
            labelinicio.setVisible(false);
            labelcuenta.setVisible(false);
            labelasignatura.setVisible(false);
            labelcorreo.setVisible(false);
            panelnotificacion.setVisible(false);

        }
    }

    @FXML
    private void cerrarnotificacion(MouseEvent event) throws Throwable {
        panelnotificacion.setVisible(false);

    }

    @FXML
    private void teams(MouseEvent event) throws IOException {
        try {

            Desktop.getDesktop().browse(new URI("https://teams.microsoft.com/"));

        } catch (URISyntaxException ex) {

            System.out.println(ex);

        } catch (IOException e) {

            System.out.println(e);

        }

    }

    @FXML
    private void office(MouseEvent event) throws IOException {
        try {

            Desktop.getDesktop().browse(new URI("https://www.office.com"));

        } catch (URISyntaxException ex) {

            System.out.println(ex);

        } catch (IOException e) {

            System.out.println(e);

        }

    }

    @FXML
    private void portal(MouseEvent event) throws IOException {

        Parent root = FXMLLoader.load(getClass().getResource("Portal.fxml"));
        Stage stage = new Stage();
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.setTitle("Inicio Educamos");
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
        Stage primaryStage = (Stage) entornoaprendizaje.getScene().getWindow();
        primaryStage.hide();

    }

}
