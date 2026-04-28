package hlanz.programacion.controladores;

import hlanz.programacion.criptoanalisis.HackExito;
import hlanz.programacion.criptoanalisis.HackFracaso;
import hlanz.programacion.criptoanalisis.HackResult;
import hlanz.programacion.criptoanalisis.Hackeador;
import hlanz.programacion.criptoanalisis.cesar.HackeadorFactory;
import hlanz.programacion.criptografia.general.AlgoritmoCifrado;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.Spinner;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.stage.FileChooser;

import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.nio.file.Files;
import java.util.ResourceBundle;

public class FrmCriptoAnalisisControlador implements Initializable {

    @FXML
    private Button btnElegirArchivo;

    @FXML
    private Button btnHackear;

    @FXML
    private ComboBox<AlgoritmoCifrado> cmbCifrado;

    @FXML
    private Label lblAlgoritmo;

    @FXML
    private Label lblCifrado;

    @FXML
    private Label lblClave;

    @FXML
    private Label lblDescifrado;

    @FXML
    private Label lblIdioma;

    @FXML
    private Label lblResultado;

    @FXML
    private Label lblTolerancia;

    @FXML
    private Spinner<Integer> spTolerancia;

    @FXML
    private TextArea txtCifrado;

    @FXML
    private TextField txtClave;

    @FXML
    private TextArea txtDescifrado;

    @FXML
    private TextField txtIdioma;

    @FXML
    private TextField txtResultado;

    @FXML
    void btnElegirArchivoPulsado(ActionEvent event) {
        FileChooser selectorArchivos = new FileChooser();
        File archivo = selectorArchivos.showOpenDialog(null);
        if (archivo!=null){
            try {
                txtCifrado.setText(Files.readString(archivo.toPath()));
            } catch (IOException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    @FXML
    void btnHackearPulsado(ActionEvent event) {
        Hackeador hackeador = HackeadorFactory.getHackeador(cmbCifrado.getSelectionModel().getSelectedItem(),spTolerancia.getValue());
        HackResult result = hackeador.descifrar(txtCifrado.getText());
        if (result instanceof HackFracaso fracaso){
            txtIdioma.setText("No se ha podido hackear el texto "+fracaso.motivo());
        }else if (result instanceof HackExito exito){
            txtResultado.setText("Mensaje descifrado correctamente");
            txtDescifrado.setText(exito.textoDescifrado());
            txtClave.setText(exito.clve());
            txtIdioma.setText(exito.idioma().getNombre());
        }
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

        cmbCifrado.getItems().addAll(AlgoritmoCifrado.values());
    }
}


