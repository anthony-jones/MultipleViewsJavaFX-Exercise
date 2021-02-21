package application;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class MultipleViews extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage window) throws Exception {
        //First Scene
        BorderPane layout1  = new BorderPane();
        layout1.setTop(new Label("First view!"));
        Button button1 = new Button("To the second view!");
        layout1.setCenter(button1);
        Scene first = new Scene(layout1);

        //Second Scene
        VBox layout2  = new VBox();
        Button button2 = new Button("To the third view!");
        layout2.getChildren().add(button2);
        layout2.getChildren().add(new Label("Second view!"));
        Scene second = new Scene(layout2);

        //Third Scene
        GridPane layout3 = new GridPane();
        layout3.add(new Label("Third view!"), 0, 0);
        Button button3 = new Button("To the first view!");
        layout3.add(button3, 1, 1);
        Scene third = new Scene(layout3);

        //Functionality of buttons
        button1.setOnAction((actionEvent -> {window.setScene(second);}));
        button2.setOnAction(actionEvent -> {window.setScene(third);});
        button3.setOnAction(actionEvent -> {window.setScene(first);});

        window.setScene(first);
        window.show();
    }
}
