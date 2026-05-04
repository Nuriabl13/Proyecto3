package hlanz.programacion.controladores;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.RadioButton;
import javafx.scene.control.ToggleGroup;
import javafx.stage.Modality;
import javafx.stage.Stage;

public class FrmPrincipalControlador {

    @FXML
    private ToggleGroup grupoOpciones;

    @FXML
    private RadioButton optCriptoanalisis;

    @FXML
    private RadioButton optCriptografia;

    @FXML
    void onBtnAceptar(ActionEvent event) {

        try {
            Stage stage = new Stage();
            FXMLLoader loader;

            if (optCriptografia.isSelected()) {
                loader = new FXMLLoader(getClass().getResource("/hlanz/programacion/vistas/frmCriptografia.fxml"));
            } else {
                loader = new FXMLLoader(getClass().getResource("/hlanz/programacion/vistas/frmCriptoanalisis.fxml"));
            }

            Parent root = loader.load();

            stage.setScene(new Scene(root));
            stage.setTitle("Nueva ventana");

            stage.initModality(Modality.APPLICATION_MODAL);

            stage.showAndWait();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
