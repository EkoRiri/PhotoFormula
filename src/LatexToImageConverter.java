import org.scilab.forge.jlatexmath.TeXConstants;
import org.scilab.forge.jlatexmath.TeXFormula;
import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import static org.scilab.forge.jlatexmath.TeXFormula.registerExternalFont;

public class LatexToImageConverter {
    private static Color colorForeground = Color.BLACK;
    private static Color colorBackground = Color.WHITE;
    private static String fontStyle;

    public static void setFontStyle(String fontStyle) {
        LatexToImageConverter.fontStyle = fontStyle;
    }

    public static void setColorForeground2Render(Color colorForeground) {
        LatexToImageConverter.colorForeground = colorForeground;
    }

    public static void setColorBackground2Render(Color colorBackground) {
        LatexToImageConverter.colorBackground = colorBackground;
    }

    public static boolean isAlpha(String name) {
        return name.matches("[0-9]+");
    }

    public static void renderInputText(String rtext, String scaleTextTemp, String fileName, String selectedFormat) {

        registerExternalFont(Character.UnicodeBlock.BASIC_LATIN, fontStyle);

        String latexFormula = rtext;

        int scaleText;

        if (scaleTextTemp.equals("") || scaleTextTemp == null || isAlpha(scaleTextTemp) == false) {
            scaleText = 100;
        } else {
            scaleText = Integer.parseInt(scaleTextTemp);
        }

        fileName = fileName + selectedFormat;

        TeXFormula formula = new TeXFormula(latexFormula);
        BufferedImage image = (BufferedImage) formula.createBufferedImage(TeXConstants.STYLE_DISPLAY, scaleText, colorForeground, colorBackground);

        try {
            ImageIO.write(image, selectedFormat.substring(1), new File(fileName));
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
