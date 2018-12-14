package View;

import Controller.Controller;
import Model.InvoiceAndPeople;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

public class InvoiceAndPeopleTableView {
    private TableView<InvoiceAndPeople> tableView;

    public InvoiceAndPeopleTableView(Controller controller, String eqName) {

        Pane pane = new Pane();


        TableColumn<InvoiceAndPeople, String> nameColumn = new TableColumn<>("Name");
        nameColumn.setMinWidth(100.0);
        nameColumn.setCellValueFactory(new PropertyValueFactory<>("name"));

        TableColumn<InvoiceAndPeople,Float> priceColumn = new TableColumn<>("Selling Price");
        priceColumn.setMinWidth(120.0);
        priceColumn.setCellValueFactory(new PropertyValueFactory<>("selling_price"));

        TableColumn<InvoiceAndPeople,String> dateColumn = new TableColumn<>("Date");
        dateColumn.setMinWidth(200.0);
        dateColumn.setCellValueFactory(new PropertyValueFactory<>("date"));

        TableColumn<InvoiceAndPeople,String> cityColumn = new TableColumn<>("City");
        cityColumn.setMinWidth(100.0);
        cityColumn.setCellValueFactory(new PropertyValueFactory<>("city"));

        TableColumn<InvoiceAndPeople,String> streetColumn = new TableColumn<>("Street");
        streetColumn.setMinWidth(100.0);
        streetColumn.setCellValueFactory(new PropertyValueFactory<>("street"));

        TableColumn<InvoiceAndPeople,String> homeColumn = new TableColumn<>("Home");
        homeColumn.setMinWidth(100.0);
        homeColumn.setCellValueFactory(new PropertyValueFactory<>("home"));

        TableColumn<InvoiceAndPeople,String> flatColumn = new TableColumn<>("Flat");
        flatColumn.setMinWidth(100.0);
        flatColumn.setCellValueFactory(new PropertyValueFactory<>("flat"));

        tableView = new TableView<>();

        tableView.getColumns().addAll(
                nameColumn,
                priceColumn,
                dateColumn,
                cityColumn,
                streetColumn,
                homeColumn,
                flatColumn
        );

        //tableView.getItems().addAll(controller.sortPriceandDate(priceColumn.getText(),dateColumn.getText()));

        pane.getChildren().addAll(tableView);

        Stage stage = new Stage();
        stage.setTitle("Invoice and Adres");

        Scene scene = new Scene(pane);
        stage.setScene(scene);
        stage.show();
    }
}
