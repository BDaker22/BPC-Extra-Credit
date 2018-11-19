package extracredit;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;



public class ExtraCredit extends Application {
    
    @Override
    public void start(Stage primaryStage) {
        TextArea textDocument = new TextArea();
        
        BorderPane borderPane = new BorderPane();
        borderPane.setTop(StandardMenu.StandardMenuBar(textDocument, primaryStage)); //here we have the menu bar
        borderPane.setCenter(textDocument);
        
        Scene scene = new Scene(borderPane, 400, 400);
        
        primaryStage.setTitle("Text Editor - Untitled");
        primaryStage.setScene(scene);
        primaryStage.show();
    }
    
    public static void main(String[] args) {
        launch(args);
    }
    
}
