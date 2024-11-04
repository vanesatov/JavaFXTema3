package org.example.javafxtema3;

import javafx.beans.property.SimpleStringProperty;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import org.example.javafxtema3.models.Usuario;

import java.net.URL;
import java.time.LocalDateTime;
import java.util.ResourceBundle;

public class MainController implements Initializable {

    @FXML
    private TableColumn<Usuario, String> cPlataforma;
    @FXML
    private Button btnGuardar;
    @FXML
    private TableColumn<Usuario, String> cCorreo;
    @FXML
    private TableColumn<Usuario, String> cVersion;
    @FXML
    private Spinner<Integer> spinnerVersion;
    @FXML
    private TableColumn<Usuario, String> cAdministrador;
    @FXML
    private TableColumn<Usuario, String> cHoraFecha;
    @FXML
    private ChoiceBox<String> choicePlataforma;
    @FXML
    private TextField txtCorreo;
    @FXML
    private CheckBox ChcboxEsAdmin;
    @FXML
    private TableView<Usuario> table;

    @FXML
    protected void onHelloButtonClick() {
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

        spinnerVersion.setValueFactory(new SpinnerValueFactory.IntegerSpinnerValueFactory(1, 5, 1, 1));

        choicePlataforma.getItems().addAll("Windows", "Linux", "MacOs");

        cCorreo.setCellValueFactory((fila) -> {
            return new SimpleStringProperty(fila.getValue().getCorreo());
        });
        cPlataforma.setCellValueFactory((fila) -> {
            return new SimpleStringProperty(fila.getValue().getPlataforma());
        });
        cAdministrador.setCellValueFactory((fila) -> {
            return new SimpleStringProperty(fila.getValue().getAdmin()?"Si" : "No");
        });
        cVersion.setCellValueFactory((fila) -> {
            return new SimpleStringProperty(fila.getValue().getVersion().toString());
        });
        cHoraFecha.setCellValueFactory((fila) -> {
            return new SimpleStringProperty(fila.getValue().getHoraFecha().toString());
        });

        table.getSelectionModel().selectedItemProperty().addListener(
                (observable, oldValue, newValue) -> {
                    if (newValue != null) {
                        txtCorreo.setText(newValue.getCorreo());
                        choicePlataforma.setValue(newValue.getPlataforma());
                        ChcboxEsAdmin.setSelected(newValue.getAdmin());
                        spinnerVersion.getValueFactory().setValue(newValue.getVersion());
                    }
                }
        );
    }

    @FXML
    public void guardar(ActionEvent actionEvent) {

        Usuario u = new Usuario();
        u.setCorreo(txtCorreo.getText());
        u.setPlataforma(choicePlataforma.getValue());
        u.setAdmin(ChcboxEsAdmin.isSelected());
        u.setVersion(spinnerVersion.getValue());
        u.setHoraFecha(LocalDateTime.now());

        table.getItems().add(u);

    }


}