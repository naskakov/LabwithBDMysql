package View;

import Controller.Controller;
import Model.Invoice;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.util.Date;

public class InvoiceTableView  {
    private TableView<Invoice> tableView;
    private Controller controller;

    public InvoiceTableView(Controller controller){
        this.controller=controller;

        MenuBar menuBar=new MenuBar();
        Menu menu=new Menu("Menu");

        MenuItem addMenuItem=new MenuItem("Add");
        MenuItem editMenuItem=new MenuItem("Edit");
        MenuItem deleteMenuItem=new MenuItem("Delete");
        MenuItem sortNameTAndDateMenuItem=new MenuItem("Sort NameT + NameP");

        TextField nameTField = new TextField();
        nameTField.setPromptText("Name Tovar");

        TextField namePField = new TextField();
        namePField.setPromptText("Name Predpr");

        addMenuItem.setOnAction(e->{
            AddEditInvoiceView addEditInvoiceView=new AddEditInvoiceView(controller,true,null);
            update();
        });

        editMenuItem.setOnAction(e->{
            Invoice invoice=tableView.getFocusModel().getFocusedItem();
            if(invoice==null){
                return;
            }
            AddEditInvoiceView addEditServiceView =new AddEditInvoiceView(controller,false, invoice);
            update();
        });


        deleteMenuItem.setOnAction(e->{
            Invoice invoice=tableView.getFocusModel().getFocusedItem();
            if(invoice==null){
                return;
            }
            controller.deleteInvoice(invoice);
            update();
        });

        sortNameTAndDateMenuItem.setOnAction(e->{
            tableView.getItems().clear();
            tableView.getItems().addAll(controller.sortNameTAndDate(nameTField.getText(),namePField.getText()));
        });



        menu.getItems().addAll(addMenuItem,editMenuItem,deleteMenuItem,sortNameTAndDateMenuItem);
        menuBar.getMenus().add(menu);

        VBox vBox = new VBox();

        TableColumn<Invoice,Date> dateColumn=new TableColumn<>("Date");
        dateColumn.setPrefWidth(250);
        dateColumn.setCellValueFactory(new PropertyValueFactory<>("date"));

        TableColumn<Invoice,String> nameColumn=new TableColumn<>("Name");
        nameColumn.setPrefWidth(250);
        nameColumn.setCellValueFactory(new PropertyValueFactory<>("name"));

        TableColumn<Invoice,Float> sellingPriceColumn=new TableColumn<>("Selling Price");
        sellingPriceColumn.setPrefWidth(225);
        sellingPriceColumn.setCellValueFactory(new PropertyValueFactory<>("sellingPrice"));

        TableColumn<Invoice,Float> kolColumn=new TableColumn<>("Kol");
        kolColumn.setPrefWidth(225);
        kolColumn.setCellValueFactory(new PropertyValueFactory<>("kol"));

        TableColumn<Invoice,String> nameTColumn=new TableColumn<>("Name Tovar");
        nameTColumn.setPrefWidth(225);
        nameTColumn.setCellValueFactory(new PropertyValueFactory<>("nameT"));

        TableColumn<Invoice,String> namePColumn=new TableColumn<>("Name Predpr");
        namePColumn.setPrefWidth(225);
        namePColumn.setCellValueFactory(new PropertyValueFactory<>("nameP"));

        tableView=new TableView<>();
        tableView.getColumns().addAll(
                dateColumn,
                nameColumn,
                sellingPriceColumn,
                kolColumn,
                nameTColumn,
                namePColumn
        );


        vBox.getChildren().addAll(menuBar, nameTField,namePField, tableView);

        Stage stage = new Stage();
        stage.setTitle("Invoice");

        Scene scene = new Scene(vBox);
        stage.setScene(scene);
        stage.show();
        update();
    }

    private void update(){
        tableView.getItems().clear();
        tableView.getItems().addAll(controller.getInvoice());
    }
}
