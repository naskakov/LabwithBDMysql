package View;

import Controller.Controller;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;
import Model.Tovar;

public class AddEditTovarView {
    private Controller controller;

    public AddEditTovarView(Controller controller, boolean addFlag, Tovar tovar) {

        GridPane gridPane = new GridPane();
        gridPane.setVgap(10);
        gridPane.setPadding(new Insets(10, 10, 10, 10));

        Label kodLabel = new Label("Kod");
        Label nameTLabel = new Label("Name Tovar");
        Label categoryLabel = new Label("Category");

        Stage stage = new Stage();

        gridPane.addColumn(0,
                kodLabel,
                nameTLabel,
                categoryLabel
        );

        TextField kodField = new TextField();
        kodField.setPrefWidth(400);
        kodField.setPromptText("345");

        TextField nameTField = new TextField();
        nameTField.setPrefWidth(400);
        nameTField.setPromptText("safe");

        TextField categoryField = new TextField();
        categoryField.setPrefWidth(400);
        categoryField.setPromptText("industrial");

        Button button = new Button();
        button.setPrefWidth(100);

        if (!addFlag) {
            kodField.setText(String.valueOf(tovar.getKod()));
            nameTField.setText(tovar.getNameT());
            categoryField.setText(tovar.getCategory());
        }

        button.setOnAction(e -> {

            if (kodField.getText().isEmpty() || nameTField.getText().isEmpty() ||
                    categoryField.getText().isEmpty() ) {
                alert("Error! Field is empty");
            }

            Tovar newTovar = new Tovar();

            newTovar.setKod(Long.parseLong(nameTField.getText()));
            newTovar.setNameT(nameTField.getText());
            newTovar.setCategory(categoryField.getText());

            if (addFlag) {
                controller.addTovar(newTovar);
            } else {
                controller.editTovar(tovar, newTovar);
            }
            stage.close();
        });

        gridPane.addColumn(1,
                kodField,
                nameTField,
                categoryField,
                button
        );

        if (addFlag) {
            button.setText("Add");
        } else {
            button.setText("Edit");
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
