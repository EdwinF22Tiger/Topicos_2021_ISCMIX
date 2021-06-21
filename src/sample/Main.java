package sample;

import javafx.application.Application;
import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Insets;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import javafx.stage.WindowEvent;
import sample.components.Corredor;
import sample.models.Conexion;
import sample.views.*;

public class Main extends Application implements EventHandler<WindowEvent> {

    private VBox vBox;
    private MenuBar mnbPrincipal;
    private Menu menCompetencia1, menCompetencia2, menCerrar;
    private MenuItem mitCalcu,mitRompeCabezas,mitEncriptar,mitTBCanciones ,MitCorredores,MiSocket ,mitSalir;
    private Scene escena;

    @Override
    public void start(Stage primaryStage) throws Exception{
        //Parent root = FXMLLoader.load(getClass().getResource("sample.fxml"));
        
        CrearMenu();

        primaryStage.addEventHandler(WindowEvent.WINDOW_CLOSE_REQUEST, this );

        primaryStage.setTitle("Proyecto de Clase TAP 2021");
        primaryStage.setScene(escena);
        primaryStage.setMaximized(true);
        primaryStage.show();
        // se abre la conexion
        Conexion.getConexion();

     /*   new Corredor("Darksidious").start();
        new Corredor("Yoda").start();
        new Corredor("DarthVader").start();
        new Corredor("kenobi").start();
        new Corredor("s3po").start();*/
    }

    private void CrearMenu() {
        vBox = new VBox();

        mnbPrincipal    = new MenuBar();
        menCompetencia1 = new Menu("Competencia 1");
        menCompetencia2 = new Menu("Compentencia 2");
        menCerrar       = new Menu("Cerrar");
        mnbPrincipal.getMenus().addAll(menCompetencia1,menCompetencia2,menCerrar);

        mitCalcu = new MenuItem("Calculadora");
        mitCalcu.setOnAction(event -> opcionesMenu(1));
        mitRompeCabezas = new MenuItem("Rompecabezas");
        mitRompeCabezas.setOnAction(event -> opcionesMenu(2));
        mitEncriptar = new MenuItem("Encriptador");
        mitEncriptar.setOnAction(event -> opcionesMenu(3));
        mitTBCanciones = new MenuItem("BDCanciones");
        mitTBCanciones.setOnAction(event -> opcionesMenu(4));
        menCompetencia1.getItems().addAll(mitCalcu,mitRompeCabezas,mitEncriptar,mitTBCanciones);
MitCorredores = new MenuItem("ejecucion de hilos ");
MitCorredores.setOnAction(event -> opcionesMenu(5));
menCompetencia2.getItems().addAll(MitCorredores);
MiSocket = new MenuItem("Client-Socket");
MiSocket.setOnAction(event -> opcionesMenu(6));
menCompetencia2.getItems().addAll(MiSocket);

        mitSalir  = new MenuItem("Salir");
        mitSalir.setOnAction(event -> { System.exit(0);});
        menCerrar.getItems().add(mitSalir);

        vBox.getChildren().add(mnbPrincipal);

        escena = new Scene(vBox, 300, 70);
        escena.getStylesheets().add(getClass().getResource("css/Styles.css").toExternalForm());
    }

    private void opcionesMenu(int opc) {
        switch(opc){
            case 1: new Calculadora(); break;
            case 2: new Rompecabezas(); break;
            case 3: new Encriptador(); break;
            case 4 : new FrmCanciones(); break;
            case 5: new Pista(); break;
            case 6 : new ClienteSocket().connectoserver();
        }
    }


    public static void main(String[] args) {
        launch(args);
    }



    @Override
    public void handle(WindowEvent event) {
        Alert ALERT = new Alert(Alert.AlertType.INFORMATION);
        ALERT.setTitle("gracias por usar la app ");
        ALERT.setHeaderText("mensaje de el sistema ");
        ALERT.setContentText("vuelva pornto");
        ALERT.showAndWait();

    }
}
