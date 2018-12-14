package View;

import Controller.Controller;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import Model.People;

public class PeopleTableView  {
    private TableView<People> tableView;
    private Controller controller;

    public PeopleTableView(Controller controller){
        this.controller=controller;

        MenuBar menuBar=new MenuBar();
        Menu menu=new Menu("Menu");

        MenuItem addMenuItem=new MenuItem("Add");
        MenuItem editMenuItem=new MenuItem("Edit");
        MenuItem deleteMenuItem=new MenuItem("Delete");
        MenuItem sortMenuItem=new MenuItem("Sort person + name");

        TextField personField = new TextField();
        personField.setPromptText("Person");

        TextField nameField = new TextField();
        nameField.setPromptText("Name");

        VBox vBox = new VBox();

        addMenuItem.setOnAction(e->{
            AddEditPeopleView addEditPersonView =new AddEditPeopleView(controller,true,null);
            update();
        });

        editMenuItem.setOnAction(e->{
            People people=tableView.getFocusModel().getFocusedItem();
            if(people==null){
                return;
            }
            AddEditPeopleView addEditPersonView=new AddEditPeopleView(controller,false,people);
            update();
        });

        deleteMenuItem.setOnAction(e->{
            People people=tableView.getFocusModel().getFocusedItem();
            if(people==null){
                return;
            }
            controller.deletePeople(people);
            update();
        });

        sortMenuItem.setOnAction(e->{
            tableView.getItems().clear();
            tableView.getItems().addAll(controller.sortNameTAndPerson(personField.getText(),nameField.getText()));
        });

        menu.getItems().addAll(addMenuItem,editMenuItem,deleteMenuItem,sortMenuItem);
        menuBar.getMenus().add(menu);

        TableColumn<People,String> personColumn=new TableColumn<>("Person");
        personColumn.setPrefWidth(150);
        personColumn.setCellValueFactory(new PropertyValueFactory<>("person"));

        TableColumn<People,String> nameTColumn=new TableColumn<>("Name Tovar");
        nameTColumn.setPrefWidth(150);
        nameTColumn.setCellValueFactory(new PropertyValueFactory<>("nameT"));

        TableColumn<People,String> nameColumn=new TableColumn<>("Name");
        nameColumn.setPrefWidth(150);
        nameColumn.setCellValueFactory(new PropertyValueFactory<>("name"));

        TableColumn<People,String> cityColumn=new TableColumn<>("City");
        cityColumn.setPrefWidth(100);
        cityColumn.setCellValueFactory(new PropertyValueFactory<>("city"));

        TableColumn<People,String> streetColumn=new TableColumn<>("Street");
        streetColumn.setPrefWidth(150);
        streetColumn.setCellValueFactory(new PropertyValueFactory<>("street"));

        TableColumn<People,Integer> houseColumn=new TableColumn<>("Home");
        houseColumn.setPrefWidth(100);
        houseColumn.setCellValueFactory(new PropertyValueFactory<>("home"));

        TableColumn<People,Integer> flatColumn=new TableColumn<>("Flat");
        flatColumn.setPrefWidth(150);
        flatColumn.setCellValueFactory(new PropertyValueFactory<>("flat"));

        TableColumn<People,String> numberColumn=new TableColumn<>("Number pasport");
        numberColumn.setPrefWidth(150);
        numberColumn.setCellValueFactory(new PropertyValueFactory<>("number"));

        TableColumn<People,String> seriesColumn=new TableColumn<>("Series pasport");
        seriesColumn.setPrefWidth(150);
        seriesColumn.setCellValueFactory(new PropertyValueFactory<>("series"));

        tableView=new TableView<>();
        tableView.getColumns().addAll(
                personColumn,
                nameTColumn,
                nameColumn,
                cityColumn,
                streetColumn,
                houseColumn,
                flatColumn,
                numberColumn,
                seriesColumn
        );

        vBox.getChildren().addAll(menuBar,personField,nameField,tableView);

        Stage stage = new Stage();
        stage.setTitle("People");

        Scene scene = new Scene(vBox);
        stage.setScene(scene);
        stage.show();
        update();
    }

    private void update(){
        tableView.getItems().clear();
        tableView.getItems().addAll(controller.getPeople());
    }

    public void alert(String message){
        Alert alert = new Alert(Alert.AlertType.ERROR);
        alert.setContentText(message);
        alert.showAndWait();
    }
}
