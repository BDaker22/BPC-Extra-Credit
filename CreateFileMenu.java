package extracredit;

import dao.LineSequential;
import java.io.File;
import javafx.event.ActionEvent;
import javafx.print.PrinterJob;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuItem;
import javafx.scene.control.TextArea;
import javafx.stage.FileChooser;
import javafx.stage.Stage;

public class CreateFileMenu {

    static File file = null;

    static Menu FileMenu(TextArea textDocument, Stage aStage) {
        final Menu fileMenu = new Menu("File"); //Menu

        //Menu Items
        MenuItem clear = new MenuItem("New");
        MenuItem open = new MenuItem("Open");
        MenuItem save = new MenuItem("Save");
        MenuItem saveAs = new MenuItem("Save As");
        MenuItem close = new MenuItem("Close");
        MenuItem print = new MenuItem("Print");

        //Add Menu Items into File Menu
        fileMenu.getItems().add(clear);
        fileMenu.getItems().add(open);
        fileMenu.getItems().add(save);
        fileMenu.getItems().add(saveAs);
        fileMenu.getItems().add(close);
        fileMenu.getItems().add(print);

        clear.setOnAction((ActionEvent e) -> {
            aStage.setTitle("Text Editor - Untitled");
            textDocument.clear();
            file = null;
        });

        open.setOnAction((ActionEvent e) -> {
            FileChooser fileChooser = new FileChooser();
            fileChooser.getExtensionFilters().add(new FileChooser.ExtensionFilter("Text File", "*.txt")); //*.txt are only files that will show up
            file = fileChooser.showOpenDialog(aStage);//returns file we want to open
            if (file != null) {
                textDocument.clear();
                String inputLine;
                String fileStream = file.getName();
                aStage.setTitle("Text Editor - " + fileStream);
                LineSequential.open(file.getAbsolutePath(), fileStream, "input");

                //Loop through text Document, read a line, put it in
                while ((inputLine = LineSequential.read(fileStream)) != null) {
                    textDocument.appendText(inputLine + "\n"); //\n is CRLF
                }
                LineSequential.close(fileStream, "input");
            }
        });

        save.setOnAction((ActionEvent e) -> {
            if (file != null) {
                saveOperation(textDocument, aStage);
            } else {
                saveAsOperation(textDocument, aStage);
            }
        });

        saveAs.setOnAction((ActionEvent e) -> {
            saveAsOperation(textDocument, aStage);
        });

        close.setOnAction((ActionEvent e) -> {
            aStage.setTitle("TextEditor - Untitled");
            textDocument.clear();
            file = null;
        });
        
        print.setOnAction((ActionEvent e) -> {
            Stage printStage = new Stage();  
            
            PrinterJob printerJob = PrinterJob.createPrinterJob(); //create printer job object
        
        
            //create text object, fill with text from textArea
            
            
            
            //Show the page setup dialog
            printerJob.showPageSetupDialog(printStage);
        
            //Show the print dialog
            printerJob.showPrintDialog(printStage);
        
            //print the text object, thereby printing the text
            //printerJob.printPage(pageLayout, myPrint);
        
            //complete the printing process
        });
        
        return fileMenu;
    }

    static void saveAsOperation(TextArea textDocument, Stage primaryStage) {
        FileChooser fileChooser = new FileChooser();
        fileChooser.getExtensionFilters().add(new FileChooser.ExtensionFilter("Text File", "*.txt"));
        file = fileChooser.showSaveDialog(primaryStage);
        if (file != null) {
            saveOperation(textDocument, primaryStage);
        }
    }

    static void saveOperation(TextArea textDocument, Stage primaryStage) {
        String fileStream = file.getName();
        primaryStage.setTitle("Text Editor - " + fileStream);
        LineSequential.open(file.getAbsolutePath(), fileStream, "output");
        LineSequential.write(fileStream, textDocument.getText());
        LineSequential.close(fileStream, "output");
    }
}
