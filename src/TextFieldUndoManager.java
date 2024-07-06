import javax.swing.*;
import javax.swing.text.Document;
import javax.swing.undo.UndoManager;
import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;
import java.awt.Toolkit;

public class TextFieldUndoManager {
    public static void addUndoFunctionality(JTextField textField) {
        UndoManager undoManager = new UndoManager();
        Document doc = textField.getDocument();
        doc.addUndoableEditListener(undoManager);

        textField.getInputMap().put(KeyStroke.getKeyStroke(KeyEvent.VK_Z, Toolkit.getDefaultToolkit().getMenuShortcutKeyMaskEx()), "undo");
        textField.getActionMap().put("undo", new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (undoManager.canUndo()) {
                    undoManager.undo();
                }
            }
        });
    }
}

