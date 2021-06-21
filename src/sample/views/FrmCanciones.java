package sample.views;

import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import javafx.util.Callback;
import sample.components.CellCustome;
import sample.models.CancionesDAO;

public class FrmCanciones extends Stage {
    private TableView<CancionesDAO>tbvCanciones ;
    private Scene escena ;
    private VBox vbox;
    private HBox hbox ;
    private Button btnagregar;
    private CancionesDAO objCDAO;

    public FrmCanciones (){
        objCDAO = new CancionesDAO();
        CrearUI ();
        this.setTitle("GESTION DE CANCIONES ");
        this.setScene(escena);
        this.show();

    }

    private void CrearUI() {

        vbox= new VBox();

        tbvCanciones = new TableView<>();
        btnagregar = new Button("Agregar");
        btnagregar.setOnAction(event -> {
            new frmCancion(tbvCanciones,null);
        });
        vbox.getChildren().addAll(tbvCanciones,btnagregar);
        creartabla();
        escena = new Scene(vbox,500,250);
    }
    private void creartabla() {
        TableColumn<CancionesDAO, Integer> tbcIdCancion = new TableColumn<>("ID");
        tbcIdCancion.setCellValueFactory(new PropertyValueFactory<>("id_cancion"));

        TableColumn<CancionesDAO, String> tbcNomCancion = new TableColumn<>("Canción");
        tbcNomCancion.setCellValueFactory(new PropertyValueFactory<>("nombre_cancion"));

        TableColumn<CancionesDAO, Integer> tbcDuracion = new TableColumn<>("Duración");
        tbcDuracion.setCellValueFactory(new PropertyValueFactory<>("duracion"));

        TableColumn<CancionesDAO, String> tbcPortada = new TableColumn<>("Portada");
        tbcPortada.setCellValueFactory(new PropertyValueFactory<>("portada"));

        TableColumn<CancionesDAO, Integer> tbcAnio = new TableColumn<>("Año");
        tbcAnio.setCellValueFactory(new PropertyValueFactory<>("anio"));

        TableColumn<CancionesDAO, String> tbcLetra = new TableColumn<>("Letra");
        tbcLetra.setCellValueFactory(new PropertyValueFactory<>("letra"));

        TableColumn<CancionesDAO, String> tbcEditar = new TableColumn<>("Editar");
        tbcEditar.setCellFactory(
                new Callback<TableColumn<CancionesDAO, String>, TableCell<CancionesDAO, String>>() {
                    @Override
                    public TableCell<CancionesDAO, String> call(TableColumn<CancionesDAO, String> param) {
                        return new CellCustome(1);
                    }
                }
        );

        TableColumn<CancionesDAO, String> tbcBorrar = new TableColumn<>("Borrar");
        tbcBorrar.setCellFactory(
                new Callback<TableColumn<CancionesDAO, String>, TableCell<CancionesDAO, String>>() {
                    @Override
                    public TableCell<CancionesDAO, String> call(TableColumn<CancionesDAO, String> param) {
                        return new CellCustome(2);
                    }
                }
        );


        tbvCanciones.getColumns().addAll(tbcIdCancion,tbcNomCancion,tbcDuracion,tbcPortada,tbcAnio,tbcLetra,tbcEditar,tbcBorrar);
        tbvCanciones.setItems(objCDAO.SELECT());
    }
}