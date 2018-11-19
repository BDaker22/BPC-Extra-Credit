package extracredit;

import javafx.scene.control.MenuBar;
import javafx.scene.control.TextArea;
import javafx.stage.Stage;

public class StandardMenu {

    static MenuBar StandardMenuBar(TextArea textDocument, Stage aStage) {
        MenuBar standardMenuBar = new MenuBar(); //Menu Bar

        standardMenuBar.getMenus().addAll(CreateFileMenu.FileMenu(textDocument, aStage));
        standardMenuBar.getMenus().addAll(CreateEditMenu.EditMenu(textDocument));
        
        
        return standardMenuBar;

    }
}
