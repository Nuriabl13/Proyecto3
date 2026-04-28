package hlanz.programacion;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class ProgramaCriptoAnalisis extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {
        FXMLLoader cargador = new FXMLLoader(ClassLoader.getSystemResource("frmCriptoanalisis.fxml"));
        try {
            Scene escena = new Scene(cargador.load());
            primaryStage.setScene(escena);
            primaryStage.setTitle("Hackeador de cifrados clásicos");
            primaryStage.show();
        } catch (IOException e) {
            System.out.println("Error al cargar la vista: "+e.getMessage());
        }
    }
}
