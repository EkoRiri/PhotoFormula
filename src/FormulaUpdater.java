import javax.swing.*;
import java.awt.event.*;
import java.awt.*;

import org.scilab.forge.jlatexmath.*;

import java.awt.image.BufferedImage;
import javax.swing.ImageIcon;

import static org.scilab.forge.jlatexmath.TeXFormula.registerExternalFont;

public class FormulaUpdater {
    protected static JTextField textField;
    private static JLabel formulaImageLabel;
    private static Color colorForeground = Color.BLACK;
    private static Color colorBackground = Color.WHITE;
    private static String fontStyle;

    public FormulaUpdater(JTextField textField, JLabel formulaImageLabel) {
        FormulaUpdater.textField = textField;
        FormulaUpdater.formulaImageLabel = formulaImageLabel;
        addFormulaInputKeyListener();
    }

    public static void setColorFormulaUpdaterForeground(Color colorForeground) {
        FormulaUpdater.colorForeground = colorForeground;
        updateFormulaImage(textField.getText());
    }

    public static void setColorFormulaUpdaterBackground(Color colorBackground) {
        FormulaUpdater.colorBackground = colorBackground;
        updateFormulaImage(textField.getText());
    }

    public static void setFontStyle(String fontStyle) {
        FormulaUpdater.fontStyle = fontStyle;
        updateFormulaImage(textField.getText());
    }

    private void addFormulaInputKeyListener() {
        textField.addKeyListener(new KeyAdapter() {
            private final Timer timer = new Timer(250, new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    updateFormulaImage(textField.getText());
                }
            });

            @Override
            public void keyTyped(KeyEvent e) {
                timer.restart();
            }
        });
    }

    protected static void updateFormulaImage(String formula) {
        try {
            registerExternalFont(Character.UnicodeBlock.BASIC_LATIN, fontStyle);
            registerExternalFont(Character.UnicodeBlock.CYRILLIC, fontStyle);

            TeXFormula teXFormula = new TeXFormula(formula);
            TeXIcon teXIcon = teXFormula.createTeXIcon(TeXConstants.STYLE_DISPLAY, 30);
            BufferedImage image = new BufferedImage(teXIcon.getIconWidth(), teXIcon.getIconHeight(), BufferedImage.TYPE_INT_ARGB);
            Graphics2D g2 = image.createGraphics();

            g2.setRenderingHint(RenderingHints.KEY_TEXT_ANTIALIASING, RenderingHints.VALUE_TEXT_ANTIALIAS_ON);

            g2.setColor(colorBackground);
            g2.fillRect(0, 0, teXIcon.getIconWidth(), teXIcon.getIconHeight());
            JLabel jl = new JLabel();
            jl.setForeground(colorForeground);
            teXIcon.paintIcon(jl, g2, 0, 0);

            ImageIcon formulaIcon = new ImageIcon(image);
            formulaImageLabel.setIcon(formulaIcon);
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
}
