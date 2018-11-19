package extracredit;

import javafx.event.ActionEvent;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuItem;
import javafx.scene.control.TextArea;
import javafx.scene.input.Clipboard;
import javafx.scene.input.ClipboardContent;


public class CreateEditMenu {
    
    static Menu EditMenu(TextArea textDocument){
        final Menu editMenu = new Menu("Edit");
        
        MenuItem copy = new MenuItem("Copy"); 
        MenuItem paste = new MenuItem("Paste");
        editMenu.getItems().add(copy);
        editMenu.getItems().add(paste);
        
        copy.setOnAction((ActionEvent e) -> {
            Clipboard clipboard = Clipboard.getSystemClipboard();
            ClipboardContent c1 = new ClipboardContent();
            if(textDocument.isFocused()){
                String textString = textDocument.getSelectedText(); //text has to be selected or else it takes everything
                if(textString != null){
                    c1.putString(textString); //put string we got from selected text into clipboard
                    clipboard.setContent(c1); //links content clipboard and clipboard
                }
            }
        });
        
        paste.setOnAction((ActionEvent e) -> {
            Clipboard clipboard = Clipboard.getSystemClipboard();
            if(clipboard.hasString()){
                textDocument.appendText(clipboard.getString());
            }
        });
        
        return editMenu;
    }
    
}
