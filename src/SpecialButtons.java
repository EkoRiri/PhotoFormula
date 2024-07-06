import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.util.ArrayList;
import java.util.List;

public class SpecialButtons {

    public static void buttonToStartRender(JButton renderButton, JFrame frame, JTextField textField1, JTextField textField2, JComboBox<String> formatComboBox) {
        renderButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JFileChooser fileChooser = new JFileChooser();
                int result = fileChooser.showSaveDialog(frame);
                if (result == JFileChooser.APPROVE_OPTION) {
                    File selectedFile = fileChooser.getSelectedFile();
                    String filePath = selectedFile.getAbsolutePath();
                    String selectedFormat = (String) formatComboBox.getSelectedItem();
                    LatexToImageConverter.renderInputText(textField1.getText(), textField2.getText(), filePath, selectedFormat);
                }
            }
        });
    }

    public static void buttonToActivateHelper(JButton helpButton) {
        helpButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                GuideForLaTeX.helperWithLaTeX();
            }
        });
    }

    public static void buttonTrigger(JTextField textField, JButton buttonAddFormula, JButton buttonAddDivison
            , JButton buttonAddSqrt, JButton buttonAddIndex, JButton buttonAddIntegral, JButton buttonAddMatrix
            , JButton buttonAddSum, JButton buttonAddProd, JButton buttonAddCallout) {

        List<JButtonAndString> listAddButtonAndAddText = new ArrayList<>(9);

        JButton[] tempButtons = {buttonAddFormula, buttonAddDivison, buttonAddSqrt, buttonAddIndex,
                buttonAddIntegral, buttonAddMatrix, buttonAddSum, buttonAddProd, buttonAddCallout};

        String[] tempTexts = {"$$", "\\frac{x}{y}", "\\sqrt[2]{x}", "_{index}",
                "\\int_{lower}^{upper} f(x)dx", "\\begin{matrix} a & b \\\\ c & d \\end{matrix}"
                , "\\sum_{lower}^{upper} a_{index}", "\\prod_{lower}^{upper} a_{index}", "\\begin{cases} x \\\\ y \\end{cases}"};

        for (int i = 0; i < tempButtons.length; i++) {
            listAddButtonAndAddText.add(new JButtonAndString(tempButtons[i], tempTexts[i]));
        }

        for (JButtonAndString buttons : listAddButtonAndAddText) {
            JButton button = buttons.getAddButton();
            String insertText = buttons.getAddText();
            button.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    textField.replaceSelection(null);
                    textField.replaceSelection(insertText);
                    textField.setCaretPosition(textField.getDocument().getLength());
                    textField.requestFocus();

                    FormulaUpdater.updateFormulaImage(textField.getText());
                }
            });
        }
    }

    public static void buttonColorForeground(JTextField textField, JButton button) {
        button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                Color selectedColor = colorChooser();

                if (selectedColor != null) {
                    Color colorForeground = new Color(selectedColor.getRed(),selectedColor.getGreen(),selectedColor.getBlue());
                    FormulaUpdater.setColorFormulaUpdaterForeground(colorForeground);
                    LatexToImageConverter.setColorForeground2Render(colorForeground);
                }

                textField.requestFocus();
            }
        });
    }

    public static void buttonColorBackground(JTextField textField, JButton button) {
        button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                Color selectedColor = colorChooser();

                if (selectedColor != null) {
                    Color colorBackground = new Color(selectedColor.getRed(),selectedColor.getGreen(),selectedColor.getBlue());
                    FormulaUpdater.setColorFormulaUpdaterBackground(colorBackground);
                    LatexToImageConverter.setColorBackground2Render(colorBackground);
                }

                textField.requestFocus();
            }
        });
    }

    public static Color colorChooser() {
        Image icon = Toolkit.getDefaultToolkit().getImage("iconColor.png");
        JColorChooser colorChooser = new JColorChooser();
        JDialog dialog = JColorChooser.createDialog(null, "Выберите цвет", true, colorChooser, null, null);
        dialog.setIconImage(icon);
        dialog.setVisible(true);
        return colorChooser.getColor();
    }
}