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
import Model.People;

public class AddEditPeopleView {

    public AddEditPeopleView(Controller controller, boolean addFlag, People people){
        GridPane gridPane=new GridPane();
        gridPane.setPadding(new Insets(10,10,10,10));
        gridPane.setVgap(10);

        Label personLabel=new Label("Person:");
        Label nameTLabel=new Label("Name Tovar:");
        Label nameLabel=new Label("Name:");
        Label cityLabel=new Label("City:");
        Label streetLabel=new Label("Street:");
        Label houseLabel=new Label("House:");
        Label flatLabel=new Label("Flat:");
        Label numberLabel=new Label("Number:");
        Label seriesLabel=new Label("Series:");

        gridPane.addColumn(0,
                personLabel,
                nameTLabel,
                nameLabel,
                cityLabel,
                streetLabel,
                houseLabel,
                flatLabel,
                numberLabel,
                seriesLabel
        );

        TextField personField=new TextField();
        personField.setPrefWidth(400);


        TextField nameTField=new TextField();
        nameTField.setPrefWidth(400);


        TextField nameField=new TextField();
        nameField.setPrefWidth(400);


        TextField cityField=new TextField();
        cityField.setPrefWidth(400);


        TextField streetField=new TextField();
        streetField.setPrefWidth(400);


        TextField homeField=new TextField();
        homeField.setPrefWidth(400);

        TextField flatField=new TextField();
        flatField.setPrefWidth(400);

        TextField numberField=new TextField();
        numberField.setPrefWidth(400);

        TextField seriesField=new TextField();
        seriesField.setPrefWidth(400);

        if(!addFlag){
            personField.setText(people.getPerson());
            nameTField.setText(people.getName());
            nameField.setText(people.getName());
            cityField.setText(people.getCity());
            streetField.setText(people.getStreet());
            homeField.setText(String.valueOf(people.getHome()));
            flatField.setText(String.valueOf(people.getFlat()));
            numberField.setText(people.getNumber());
            seriesField.setText(people.getSeries());
        }

        Stage stage = new Stage();
        Button button=new Button();

        button.setOnAction(e->{
            if(personField.getText().isEmpty() || nameTField.getText().isEmpty() || nameField.getText().isEmpty()
                    || cityField.getText().isEmpty() || streetField.getText().isEmpty()
                    || flatField.getText().isEmpty() || homeField.getText().isEmpty() || numberField.getText().isEmpty()
                    || seriesField.getText().isEmpty()){
                alert("Error! Field is empty");
            }

            People newPerson=new People();

            newPerson.setPerson(personField.getText());
            newPerson.setNameT(nameTField.getText());
            newPerson.setName(nameField.getText());
            newPerson.setCity(cityField.getText());
            newPerson.setStreet(streetField.getText());
            newPerson.setHome(Integer.parseInt(homeField.getText()));
            newPerson.setFlat(Integer.parseInt(flatField.getText()));
            newPerson.setNumber(numberField.getText());
            newPerson.setSeries(seriesField.getText());

            if(addFlag) {
                controller.addPeople(newPerson);
            }
            else{
                controller.editPeople(people,newPerson);
            }
            stage.close();
        });

        if(addFlag) {
            button.setText("Add person");
        }
        else{
            button.setText("Edit person");
        }

        gridPane.addColumn(1,
                personField,
                nameTField,
                nameField,
                cityField,
                streetField,
                homeField,
                flatField,
                numberField,
                seriesField,
                button
        );

        if(addFlag){
            stage.setTitle("Add");
        }
        else{
            stage.setTitle("Edit");

        }
        Scene scene = new Scene(gridPane);
        stage.setScene(scene);
        stage.showAndWait();
    }


    private void alert(String message){
        Alert alert=new Alert(Alert.AlertType.ERROR);
        alert.setHeaderText(message);
        alert.showAndWait();
    }
}
