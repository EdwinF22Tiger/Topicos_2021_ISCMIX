package sample.views;


import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.control.ToolBar;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.FileChooser;
import javafx.stage.Stage;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;


public class Encriptador extends Stage implements EventHandler<KeyEvent> {


    private Scene escena;
    private HBox hBox;
    private VBox vBox;
    private ToolBar tolMenu;
    private TextArea txtEntrada ;
    private TextArea txtSalida;
    private Button btnEncriptar;
    private Button btnAbrir;
    private Button btnLimpiar;
    private FileChooser fileChooser;
    private File archivo;
    private String texto = "";


    public Encriptador(){

        CrearUI();

        this.setTitle("Funcion de encriptacion con HASH");
        this.setScene(escena);
        this.show();
    }

    private void CrearUI() {
        vBox = new VBox();
        tolMenu = new ToolBar();
        btnAbrir = new Button();

        ImageView imv = new ImageView("sample/assets/icon_open.png");
        imv.setFitHeight(35);
        imv.setPreserveRatio(true);


        btnAbrir.setGraphic(imv);
        btnAbrir.setOnAction(event -> abrirArchivo());
        tolMenu.getItems().add(btnAbrir);

        hBox = new HBox();
        txtEntrada = new TextArea();
        txtEntrada.setOnKeyPressed(this);
        txtEntrada.setWrapText(true);
        // --
        txtSalida = new TextArea();
        txtSalida.setEditable(false);
        txtSalida.setWrapText(true);

        hBox.getChildren().addAll(txtEntrada, txtSalida);
        btnEncriptar = new Button("Encriptar entrada");
        btnEncriptar.setOnAction(event -> abrirArchivo());

        btnLimpiar = new Button("Limpiar");
        btnLimpiar.setOnAction(event -> limpiar());
        vBox.getChildren().addAll(tolMenu, hBox,btnEncriptar,btnLimpiar);
        escena = new Scene(vBox,600,300);
    }


    private void limpiar() {
        txtEntrada.clear();
        txtSalida.clear();
        texto = "";
    }

    private void abrirArchivo() {
        fileChooser = new FileChooser();
        fileChooser.setTitle("Buscar archivo : ");
        archivo = fileChooser.showOpenDialog(this);
        leerArchivo();
    }

    private void leerArchivo() {
        if (archivo != null) {
            FileReader fileReader = null;
            BufferedReader bufferedReader = null;
            try { fileReader = new FileReader(archivo);
                bufferedReader = new BufferedReader(fileReader);
                String linea = bufferedReader.readLine();
                while (linea != null) {
                    texto = texto + linea + "\n";
                    linea = bufferedReader.readLine();
                }

            } catch (Exception e) {
                System.out.println(e.toString());

            }  {
                try {
                    fileReader.close();
                    bufferedReader.close();
                    archivo = null;
                    txtEntrada.appendText(texto);
                    encriptarArchivo(texto);
                    texto="";

                } catch (Exception e2) {


                }
            }
        }
    }

    private void encriptarArchivo(String texto){

        texto = texto.toUpperCase();
        char[] caracteres = texto.toCharArray();

        for (char caracter : caracteres) {
            encriptaciones(caracter);
            encripBin(caracter);
        }
    }

    private void encriptaciones(char caracter){
        switch (caracter) {
            case 'A': txtSalida.appendText("97");break;
            case 'B': txtSalida.appendText("98");break;
            case 'C': txtSalida.appendText("99");break;
            case 'D': txtSalida.appendText("100");break;
            case 'E': txtSalida.appendText("101");break;
            case 'F': txtSalida.appendText("102");break;
            case 'G': txtSalida.appendText("103");break;
            case 'H': txtSalida.appendText("104");break;
            case 'I': txtSalida.appendText("105");break;
            case 'J': txtSalida.appendText("106");break;
            case 'K': txtSalida.appendText("107");break;
            case 'L': txtSalida.appendText("108");break;
            case 'M': txtSalida.appendText("109");break;
            case 'N': txtSalida.appendText("110");break;
            case 'Ñ': txtSalida.appendText("164");break;
            case 'O': txtSalida.appendText("111");break;
            case 'P': txtSalida.appendText("112");break;
            case 'Q': txtSalida.appendText("113");break;
            case 'R': txtSalida.appendText("114");break;
            case 'S': txtSalida.appendText("115");break;
            case 'T': txtSalida.appendText("116");break;
            case 'U': txtSalida.appendText("117");break;
            case 'V': txtSalida.appendText("118");break;
            case 'W': txtSalida.appendText("119");break;
            case 'X': txtSalida.appendText("120");break;
            case 'Y': txtSalida.appendText("121");break;
            case 'Z': txtSalida.appendText("122");break;
            case '\n': txtSalida.appendText("\n");break;
           // default: txtSalida.appendText("6f74726f206361726163746572");
        }
    }

    private void encriptacion(String caracter){
        switch (caracter){
            case "A": txtSalida.appendText("97");break;
            case "B": txtSalida.appendText("98");break;
            case "C": txtSalida.appendText("99");break;
            case "D": txtSalida.appendText("100");break;
            case "E": txtSalida.appendText("101");break;
            case "F": txtSalida.appendText("102");break;
            case "G": txtSalida.appendText("103");break;
            case "H": txtSalida.appendText("104");break;
            case "I": txtSalida.appendText("105");break;
            case "J": txtSalida.appendText("106");break;
            case "K": txtSalida.appendText("107");break;
            case "L": txtSalida.appendText("108");break;
            case "M": txtSalida.appendText("109");break;
            case "N": txtSalida.appendText("110");break;
            case "Ñ": txtSalida.appendText("164");break;
            case "O": txtSalida.appendText("111");break;
            case "P": txtSalida.appendText("112");break;
            case "Q": txtSalida.appendText("113");break;
            case "R": txtSalida.appendText("114");break;
            case "S": txtSalida.appendText("115");break;
            case "T": txtSalida.appendText("116");break;
            case "U": txtSalida.appendText("117");break;
            case "V": txtSalida.appendText("118");break;
            case "W": txtSalida.appendText("119");break;
            case "X": txtSalida.appendText("120");break;
            case "Y": txtSalida.appendText("121");break;
            case "Z": txtSalida.appendText("122");break;
            case "\n": txtSalida.appendText("\n");break;
           // default: txtSalida.appendText("6f74726f206361726163746572");
        }
    }

    private void encripBin(String texto){
        switch (texto){
            case "A": txtSalida.appendText("01100001");break;
            case "B": txtSalida.appendText("01100010");break;
            case "C": txtSalida.appendText("01100011");break;
            case "D": txtSalida.appendText("01100100");break;
            case "E": txtSalida.appendText("01100101");break;
            case "F": txtSalida.appendText("01100110");break;
            case "G": txtSalida.appendText("01100111");break;
            case "H": txtSalida.appendText("01101000");break;
            case "I": txtSalida.appendText("01101001");break;
            case "J": txtSalida.appendText("01101010");break;
            case "K": txtSalida.appendText("01101011");break;
            case "L": txtSalida.appendText("01101100");break;
            case "M": txtSalida.appendText("01101101");break;
            case "N": txtSalida.appendText("01101110");break;
            case "Ñ": txtSalida.appendText("01101001");break;
            case "O": txtSalida.appendText("01101111");break;
            case "P": txtSalida.appendText("01110000");break;
            case "Q": txtSalida.appendText("01110001");break;
            case "R": txtSalida.appendText("01110010");break;
            case "S": txtSalida.appendText("01110011");break;
            case "T": txtSalida.appendText("01110100");break;
            case "U": txtSalida.appendText("01110101");break;
            case "V": txtSalida.appendText("01110110");break;
            case "W": txtSalida.appendText("01110111");break;
            case "X": txtSalida.appendText("01111000");break;
            case "Y": txtSalida.appendText("01111001");break;
            case "Z": txtSalida.appendText("01111010");break;
            default: txtSalida.appendText("01101111011101000111001001101111");
        }
    }

    private void encripBin(char texto){
        switch (texto){
            case 'A':
                txtSalida.appendText("01100001");break;
            case 'B': txtSalida.appendText("01100010");break;
            case 'C': txtSalida.appendText("01100011");break;
            case 'D':txtSalida.appendText("01100100");break;
            case 'E': txtSalida.appendText("01100101");break;
            case 'F': txtSalida.appendText("01100110");break;
            case 'G': txtSalida.appendText("01100111");break;
            case 'H': txtSalida.appendText("01101000");break;
            case 'I': txtSalida.appendText("01101001");break;
            case 'J': txtSalida.appendText("01101010");break;
            case 'K':txtSalida.appendText("01101011");break;
            case 'L': txtSalida.appendText("01101100");break;
            case 'M': txtSalida.appendText("01101101");break;
            case 'N': txtSalida.appendText("01101110");break;
            case 'Ñ': txtSalida.appendText("01101001");break;
            case 'O': txtSalida.appendText("01101111");break;
            case 'P': txtSalida.appendText("01110000");break;
            case 'Q': txtSalida.appendText("01110001");break;
            case 'R': txtSalida.appendText("01110010");break;
            case 'S': txtSalida.appendText("01110011");break;
            case 'T': txtSalida.appendText("01110100");break;
            case 'U': txtSalida.appendText("01110101");break;
            case 'V': txtSalida.appendText("01110110");break;
            case 'W': txtSalida.appendText("01110111");break;
            case 'X': txtSalida.appendText("01111000");break;
            case 'Y': txtSalida.appendText("01111001") ;break;
            case 'Z': txtSalida.appendText("01111010");break;
            case '\n': txtSalida.appendText("\n");break;
            default: txtSalida.appendText("01101111011101000111001001101111");
        }
    }

    @Override
    public void handle(KeyEvent event) {
        encriptacion(event.getCode().toString());
        encripBin(event.getCode().toString());
    }
}
