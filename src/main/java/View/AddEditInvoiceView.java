package View;

import Controller.Controller;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;
import Model.Invoice;
public class AddEditInvoiceView {
    private Controller controller;

    public AddEditInvoiceView(Controller controller, boolean addFlag, Invoice invoice){
        this.controller=controller;

        GridPane gridPane=new GridPane();
        gridPane.setPadding(new Insets(10,10,10,10));
        gridPane.setVgap(10);

        Label dateLabel=new Label("Date:");
        Label nameLabel=new Label("Name:");
        Label sellingPriceLabel=new Label("Selling Price:");
        Label kolLabel=new Label("Kol:");
        Label nameTLabel=new Label("Name Tovar:");
        Label namePLabel=new Label("Name Predpr:");

        gridPane.addColumn(0,
                dateLabel,
                nameLabel,
                sellingPriceLabel,
                kolLabel,
                nameTLabel,
                namePLabel
        );

        TextField dateField=new TextField();
        dateField.setPrefWidth(400);

        TextField nameField=new TextField();
        nameField.setPrefWidth(400);

        TextField sellingPriceField=new TextField();
        sellingPriceField.setPrefWidth(400);

        TextField kolField=new TextField();
        kolField.setPrefWidth(400);

        TextField nameTField=new TextField();
        nameTField.setPrefWidth(400);

        TextField namePField=new TextField();
        namePField.setPrefWidth(400);

        Stage stage = new Stage();
        Button button=new Button();

        if(addFlag) {
            button.setText("Add");
        }
        else{
            button.setText("Edit");
        }

        if(!addFlag){
            dateField.setText(invoice.getDate());
            nameField.setText(invoice.getName());
            sellingPriceField.setText(String.valueOf(invoice.getSellingPrice()));
            kolField.setText(String.valueOf(invoice.getKol()));
            nameTField.setText(invoice.getNameT());
            namePField.setText(invoice.getNameP());
        }

        button.setOnAction(e->{
            if (dateField.getText().isEmpty()|| nameField.getText().isEmpty()||
                    sellingPriceField.getText().isEmpty() || kolField.getText().isEmpty()
                    || nameTField.getText().isEmpty() || namePField.getText().isEmpty()){
                alert("Error! Field is empty");
            }

            Invoice newInvoice=new Invoice();

            newInvoice.setDate(dateField.getText());
            newInvoice.setName(nameField.getText());
            newInvoice.setSelling_price(Float.parseFloat(sellingPriceField.getText()));
            newInvoice.setKol(Long.parseLong(kolField.getText()));
            newInvoice.setNameT(nameTField.getText());
            newInvoice.setNameP(namePField.getText());

            if(addFlag) {
                controller.addInvoice(newInvoice);
            }
            else{
                controller.editInvoice(invoice,newInvoice);
            }
            stage.close();
        });

        gridPane.addColumn(1,
                dateField,
                nameField,
                sellingPriceField,
                kolField,
                nameTField,
                namePField,
                button
        );

        if(addFlag){
            stage.setTitle("Add");
        }
        else{
            stage.setTitle("Edit");

        }
        stage.setScene(new Scene(gridPane));
        stage.showAndWait();
    }

    private void alert(String message){
        Alert alert=new Alert(Alert.AlertType.ERROR);
        alert.setHeaderText(message);
        alert.showAndWait();
    }
}
