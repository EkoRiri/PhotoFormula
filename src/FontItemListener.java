import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import javax.swing.*;

public class FontItemListener implements ItemListener {
    private JComboBox<String> comboBox;

    public FontItemListener(JComboBox<String> comboBox) {
        this.comboBox = comboBox;
    }

    @Override
    public void itemStateChanged(ItemEvent e) {
        if (e.getStateChange() == ItemEvent.SELECTED) {
            String selectedFont = (String) comboBox.getSelectedItem();
            FormulaUpdater.setFontStyle(selectedFont);
            LatexToImageConverter.setFontStyle(selectedFont);
        }
    }
}
