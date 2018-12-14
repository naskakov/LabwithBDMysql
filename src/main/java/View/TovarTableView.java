package View;

import Controller.Controller;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import Model.Tovar;

public class TovarTableView {
    private Controller controller;
    private TableView<Tovar> tableView;

    public TovarTableView(Controller controller){
        this.controller=controller;

        MenuBar menuBar=new MenuBar();
        Menu menu=new Menu("Menu");

        VBox vBox = new VBox();

        MenuItem addMenuItem=new MenuItem("Add");
        MenuItem editMenuItem=new MenuItem("Edit");
        MenuItem deleteMenuItem=new MenuItem("Delete");

        menu.getItems().addAll(addMenuItem,editMenuItem,deleteMenuItem);
        menuBar.getMenus().add(menu);

        addMenuItem.setOnAction(e->{
            AddEditTovarView addEditTovarView = new AddEditTovarView(controller,true,null);
            update();
        });

        editMenuItem.setOnAction(e->{
            Tovar tovar = tableView.getFocusModel().getFocusedItem();
            if(tovar==null){
                return;
            }
            AddEditTovarView addEditCallView = new AddEditTovarView(controller,false,tovar);
            update();
        });

        deleteMenuItem.setOnAction(e->{
            Tovar tovar=tableView.getFocusModel().getFocusedItem();
            if(tovar==null){
                return;
            }
            controller.deleteTovar(tovar);
            update();
        });

        TableColumn<Tovar,Integer> kodColumn=new TableColumn<>("Kod");
        kodColumn.setPrefWidth(250);
        kodColumn.setCellValueFactory(new PropertyValueFactory<>("kod"));

        TableColumn<Tovar,String> nameTColumn=new TableColumn<>("Name");
        nameTColumn.setPrefWidth(200);
        nameTColumn.setCellValueFactory(new PropertyValueFactory<>("nameT"));

        TableColumn<Tovar,String> categoryColumn=new TableColumn<>("Category");
        categoryColumn.setPrefWidth(200);
        categoryColumn.setCellValueFactory(new PropertyValueFactory<>("category"));

        tableView = new TableView<>();

        tableView.getColumns().addAll(
                kodColumn,
                nameTColumn,
                categoryColumn
        );

        vBox.getChildren().addAll(menuBar,tableView);

        Stage stage = new Stage();
        stage.setTitle("Tovar");

        Scene scene = new Scene(vBox);
        stage.setScene(scene);
        stage.show();
        update();
    }

    private void update(){
        tableView.getItems().clear();
        tableView.getItems().addAll(controller.getTovar());
    }

    public void alert(String message){
        Alert alert = new Alert(Alert.AlertType.ERROR);
        alert.setContentText(message);
        alert.showAndWait();
    }
}
