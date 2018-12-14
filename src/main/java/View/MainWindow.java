package View;

import Controller.Controller;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
public class MainWindow {
    private Controller controller;
    private Stage stage;
    public MainWindow(){
        controller=new Controller();
        VBox vBox=new VBox();
        vBox.setAlignment(Pos.CENTER);
        vBox.setPadding(new Insets(15,30,15,30));

        Button peopleButton=new Button("PEOPLE");
        peopleButton.setPrefWidth(300);
        peopleButton.setOnAction(e->{
            PeopleTableView personTableView=new PeopleTableView(controller);
        });

        Button invoiceButton=new Button("INVOICE");
        invoiceButton.setPrefWidth(300);
        invoiceButton.setOnAction(e->{
            InvoiceTableView invoiceTableView=new InvoiceTableView(controller);
        });

        Button tovarButton=new Button("TOVAR");
        tovarButton.setPrefWidth(300);
        tovarButton.setOnAction(e->{
            TovarTableView tovarTableView=new TovarTableView(controller);
        });

        vBox.getChildren().addAll(peopleButton,invoiceButton,tovarButton);

        Scene scene=new Scene(vBox);
        stage=new Stage();
        stage.setTitle("Main");
        stage.setScene(scene);
        stage.showAndWait();
    }

}
