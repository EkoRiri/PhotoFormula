import javax.swing.*;

public class JButtonAndString {
    public JButton addButton;
    public String addText;

    public JButtonAndString(JButton addButton, String addText) {
        this.addButton = addButton;
        this.addText = addText;
    }

    public JButton getAddButton() {
        return addButton;
    }

    public void setAddButton(JButton addButton) {
        this.addButton = addButton;
    }

    public String getAddText() {
        return addText;
    }

    public void setAddText(String addText) {
        this.addText = addText;
    }
}
