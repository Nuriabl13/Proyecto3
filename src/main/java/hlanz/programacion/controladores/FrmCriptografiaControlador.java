package hlanz.programacion.controladores;

import javafx.fxml.FXML;
import javafx.scene.control.*;

public class FrmCriptografiaControlador {

    @FXML
    private ComboBox<String> cmbCifrado;

    @FXML
    private TextField txtClave;

    @FXML
    private RadioButton optCifrar;

    @FXML
    private RadioButton optDescifrar;

    @FXML
    private TextArea txtEntrada;

    @FXML
    private TextArea txtSalida;

    @FXML
    private Button btnAccion;

    @FXML
    public void initialize() {
        // Rellenar combo
        cmbCifrado.getItems().addAll("Cesar", "Vigenere");

        // Selección por defecto
        optCifrar.setSelected(true);
        cmbCifrado.getSelectionModel().selectFirst();
    }

    @FXML
    void onBtnAccion() {

        String texto = txtEntrada.getText();
        String clave = txtClave.getText();
        String algoritmo = cmbCifrado.getValue();

        if (texto.isEmpty()) {
            txtSalida.setText("Introduce texto primero");
            return;
        }

        // 👇 Simulación (luego metes cifrado real)
        if (optCifrar.isSelected()) {
            txtSalida.setText("CIFRADO (" + algoritmo + "): " + texto);
        } else {
            txtSalida.setText("DESCIFRADO (" + algoritmo + "): " + texto);
        }
    }
}