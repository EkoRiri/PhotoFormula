import javax.swing.*;
import java.awt.*;
import java.awt.Dimension;


public class CreateMyInterface {
    public static void MyInterFace() {
        JFrame frame = new JFrame("Photoformula");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(650, 650);

        Image icon = Toolkit.getDefaultToolkit().getImage("iconFx.png");
        frame.setIconImage(icon);

        JPanel panel = new JPanel();

        JLabel label1 = new JLabel("Введите формулу:");
        JTextField textFieldFormulaInput = new JTextField(20);
        textFieldFormulaInput.requestFocus();

        TextFieldUndoManager.addUndoFunctionality(textFieldFormulaInput);

        JLabel formulaImageLabel = new JLabel();

        Color colorForeground = new Color(0,0,0);
        Color colorBackground = new Color(238,238,238);

        JLabel colorChooser2Render = new JLabel("Выберите цвет шрифта или фона (Цвета по умолчанию - чёрный и светло-серый):");

        JButton buttonForegroundColor2Render = new JButton("Цвет шрифта");
        buttonForegroundColor2Render.setBackground(Color.LIGHT_GRAY);

        JButton buttonBackgroundColor2Render = new JButton("Цвет фона");
        buttonBackgroundColor2Render.setBackground(Color.LIGHT_GRAY);

        JLabel labelFontStyle = new JLabel("Выберите стиль шрифта():");
        JButton buttonFontStyle = new JButton("Стиль шрифта");
        buttonFontStyle.setBackground(Color.LIGHT_GRAY);
        JComboBox<String> comboBoxFontStyle = new JComboBox<>(GraphicsEnvironment.getLocalGraphicsEnvironment().getAvailableFontFamilyNames());
        FontItemListener fontItemListener = new FontItemListener(comboBoxFontStyle);
        comboBoxFontStyle.addItemListener(fontItemListener);

        FormulaUpdater formulaUpdater = new FormulaUpdater(textFieldFormulaInput, formulaImageLabel);

        FormulaUpdater.setColorFormulaUpdaterForeground(colorForeground);
        FormulaUpdater.setColorFormulaUpdaterBackground(colorBackground);
        LatexToImageConverter.setColorForeground2Render(colorForeground);
        LatexToImageConverter.setColorBackground2Render(colorBackground);

        JLabel label2 = new JLabel("Введите масштаб(100 рекомендовано):");
        JTextField textFieldScale = new JTextField(20);

        TextFieldUndoManager.addUndoFunctionality(textFieldScale);

        JLabel labelFormat = new JLabel("Выберите формат изображения:");

        String[] formats = {".png", ".jpg", ".jpeg", ".bmp"};
        JComboBox<String> formatComboBox = new JComboBox<>(formats);

        JButton renderButton = new JButton("Рендер");
        renderButton.setBackground(Color.PINK);
        renderButton.setForeground(Color.BLACK);

        JButton helpButton = new JButton("Справочник");
        helpButton.setBackground(Color.CYAN);
        helpButton.setForeground(Color.BLACK);

        JLabel label4 = new JLabel("Нажав на кнопку - в поле ввода формулы создаётся структура формулы выбранной кнопки:");

        JButton buttonFormula = new JButton("Формула");
        buttonFormula.setBackground(Color.WHITE);

        JButton buttonDivison = new JButton("Деление");
        buttonDivison.setBackground(Color.WHITE);

        JButton buttonSqrt = new JButton("Корень");
        buttonSqrt.setBackground(Color.WHITE);

        JButton buttonIndex = new JButton("Индекс");
        buttonIndex.setBackground(Color.WHITE);

        JButton buttonIntegral = new JButton("Интеграл");
        buttonIntegral.setBackground(Color.WHITE);

        JButton buttonMatrix = new JButton("Матрица");
        buttonMatrix.setBackground(Color.WHITE);

        JButton buttonSum = new JButton("Сумма");
        buttonSum.setBackground(Color.WHITE);

        JButton buttonProd = new JButton("Произведение");
        buttonProd.setBackground(Color.WHITE);

        JButton buttonCallout = new JButton("Выноска");
        buttonCallout.setBackground(Color.WHITE);

        updateColorScheme(panel, renderButton, helpButton, buttonFormula, buttonSqrt,
                buttonIndex, buttonIntegral, buttonMatrix, buttonSum, buttonProd, buttonCallout, buttonDivison);

        panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));
        panel.setAlignmentX(Component.CENTER_ALIGNMENT);

        JPanel formulaPanel = new JPanel();
        formulaPanel.setLayout(new GridLayout(2,1,1,1));
        label1.setHorizontalAlignment(SwingConstants.CENTER);
        formulaPanel.add(label1);
        formulaPanel.add(textFieldFormulaInput);
        panel.add(formulaPanel);

        panel.add(Box.createRigidArea(new Dimension(0, 10)));

        JPanel foPaIm = new JPanel();
        foPaIm.setLayout(new GridLayout(1,1,1,1));
        formulaImageLabel.setHorizontalAlignment(SwingConstants.CENTER);
        foPaIm.add(formulaImageLabel);
        panel.add(foPaIm);

        panel.add(Box.createRigidArea(new Dimension(0, 10)));

        JPanel colorChooser2RenderPanelText = new JPanel();
        colorChooser2RenderPanelText.setLayout(new FlowLayout(FlowLayout.CENTER));
        colorChooser2RenderPanelText.add(colorChooser2Render);
        panel.add(colorChooser2RenderPanelText);

        panel.add(Box.createRigidArea(new Dimension(0, 10)));

        JPanel colorChooser2RenderPanelButton = new JPanel();
        colorChooser2RenderPanelButton.setLayout(new GridLayout(1,2,1,1));
        colorChooser2RenderPanelButton.add(buttonForegroundColor2Render);
        colorChooser2RenderPanelButton.add(buttonBackgroundColor2Render);
        panel.add(colorChooser2RenderPanelButton);

        panel.add(Box.createRigidArea(new Dimension(0, 10)));

        JPanel panelFontStyle = new JPanel();
        panelFontStyle.setLayout(new GridLayout(2,3,1,1));
        JLabel labelEmptyFontStyle1 = new JLabel("");
        JLabel labelEmptyFontStyle2 = new JLabel("");
        JLabel labelEmptyFontStyle3 = new JLabel("");
        JLabel labelEmptyFontStyle4 = new JLabel("");
        labelFontStyle.setHorizontalAlignment(SwingConstants.CENTER);
        panelFontStyle.add(labelEmptyFontStyle1);
        panelFontStyle.add(labelFontStyle);
        panelFontStyle.add(labelEmptyFontStyle2);
        panelFontStyle.add(labelEmptyFontStyle3);
        panelFontStyle.add(comboBoxFontStyle);
        panelFontStyle.add(labelEmptyFontStyle4);
        panel.add(panelFontStyle);

        panel.add(Box.createRigidArea(new Dimension(0, 10)));

        JPanel scalePanel = new JPanel();
        scalePanel.setLayout(new GridLayout(2,1,1,1));
        label2.setHorizontalAlignment(SwingConstants.CENTER);
        scalePanel.add(label2);
        scalePanel.add(textFieldScale);
        panel.add(scalePanel);

        panel.add(Box.createRigidArea(new Dimension(0, 10)));

        JPanel formatPanel = new JPanel();
        formatPanel.setLayout(new GridLayout(2,3,1,1));
        JLabel labelEmptyformatPanel1 = new JLabel("");
        JLabel labelEmptyformatPanel2 = new JLabel("");
        JLabel labelEmptyformatPanel3 = new JLabel("");
        JLabel labelEmptyformatPanel4 = new JLabel("");
        formatPanel.add(labelEmptyformatPanel1);
        labelFormat.setHorizontalAlignment(SwingConstants.CENTER);
        formatPanel.add(labelFormat);
        formatPanel.add(labelEmptyformatPanel2);
        formatPanel.add(labelEmptyformatPanel3);
        formatPanel.add(formatComboBox);
        formatPanel.add(labelEmptyformatPanel4);
        panel.add(formatPanel);

        panel.add(Box.createRigidArea(new Dimension(0, 10)));

        JPanel buttonPanel = new JPanel();
        buttonPanel.setLayout(new GridLayout(2,1,1,1));
        buttonPanel.add(renderButton);
        buttonPanel.add(helpButton);
        panel.add(buttonPanel);

        panel.add(Box.createRigidArea(new Dimension(0, 10)));

        JPanel labelPanel = new JPanel();
        labelPanel.setLayout(new GridLayout(1,1,1,1));
        label4.setHorizontalAlignment(SwingConstants.CENTER);
        labelPanel.add(label4);
        panel.add(labelPanel);

        panel.add(Box.createRigidArea(new Dimension(0, 10)));

        JPanel structureButtonsPanel = new JPanel();
        structureButtonsPanel.setLayout(new GridLayout(3, 3, 5, 5));
        structureButtonsPanel.add(buttonFormula);
        structureButtonsPanel.add(buttonDivison);
        structureButtonsPanel.add(buttonSqrt);
        structureButtonsPanel.add(buttonIndex);
        structureButtonsPanel.add(buttonIntegral);
        structureButtonsPanel.add(buttonMatrix);
        structureButtonsPanel.add(buttonSum);
        structureButtonsPanel.add(buttonProd);
        structureButtonsPanel.add(buttonCallout);
        panel.add(structureButtonsPanel);

        SpecialButtons.buttonColorBackground(textFieldFormulaInput, buttonBackgroundColor2Render);
        SpecialButtons.buttonColorForeground(textFieldFormulaInput, buttonForegroundColor2Render);
        SpecialButtons.buttonToStartRender(renderButton, frame,textFieldFormulaInput,textFieldScale, formatComboBox);
        SpecialButtons.buttonToActivateHelper(helpButton);
        SpecialButtons.buttonTrigger(textFieldFormulaInput, buttonFormula, buttonDivison
                , buttonSqrt, buttonIndex, buttonIntegral, buttonMatrix, buttonSum, buttonProd, buttonCallout);

        frame.add(panel);

        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();

        int x = (screenSize.width - frame.getWidth()) / 2;
        int y = (screenSize.height - frame.getHeight()) / 2;

        frame.setLocation(x, y);

        frame.setVisible(true);
    }

    private static void updateColorScheme(JPanel panel, JButton renderButton, JButton helpButton,
                                          JButton buttonFormula, JButton buttonSqrt, JButton buttonIndex,
                                          JButton buttonIntegral, JButton buttonMatrix, JButton buttonSum,
                                          JButton buttonProd, JButton buttonCallout, JButton buttonDivison) {

        renderButton.setBackground(new Color(201, 71, 71));
        renderButton.setForeground(Color.WHITE);

        helpButton.setBackground(new Color(66, 179, 90));
        helpButton.setForeground(Color.WHITE);

        buttonFormula.setBackground(Color.LIGHT_GRAY);
        buttonSqrt.setBackground(Color.LIGHT_GRAY);
        buttonIndex.setBackground(Color.LIGHT_GRAY);
        buttonIntegral.setBackground(Color.LIGHT_GRAY);
        buttonMatrix.setBackground(Color.LIGHT_GRAY);
        buttonSum.setBackground(Color.LIGHT_GRAY);
        buttonProd.setBackground(Color.LIGHT_GRAY);
        buttonCallout.setBackground(Color.LIGHT_GRAY);
        buttonDivison.setBackground(Color.LIGHT_GRAY);

        panel.setBackground(Color.WHITE);
        panel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
    }

}
