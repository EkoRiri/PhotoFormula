import javax.swing.*;
import java.awt.*;

public class GuideForLaTeX {

    private static final String TEXT = " Формулы должны писаться в формате LaTeX.\n" +
            " LaTeX - это язык разметки, который часто используется для создания документов с математическими формулами.\n " +
            " Вот несколько примеров использования LaTeX для оформления формул (в случае, если не найдена нужная информация просьба обратиться к документации по LaTeX):\n" +
            "\n • Простая формула\n" +
            "\n" +
            " Для создания простой формулы, например, a^2 + b^2 = c^2, нужно написать следующий код:\n" +
            "\n" +
            " $a^2 + b^2 = c^2$\n" +
            "\n" +
            " Здесь символ ^ используется для возведения в степень, а символ $ используется для обозначения начала и конца формулы.\n" +
            "\n" +
            "\n" +
            " • Дробь\n" +
            "\n" +
            " Для создания дроби, например, \\frac{a}{b}, нужно написать следующий код:\n" +
            "\n" +
            " $\\frac{a}{b}$\n" +
            "\n" +
            " Здесь символ \\frac используется для создания дроби.\n" +
            "\n" +
            "\n" +
            " • Индексы и интегралы\n" +
            "\n" +
            " Для создания индексов и интегралов используются следующие символы:\n" +
            "\n" +
            " Индекс: _{index}\n" +
            " Интеграл: \\int_{lower}^{upper}\n" +
            "\n" +
            " Например, чтобы создать интеграл от a до b, написанный символами f(x), нужно написать следующий код:\n" +
            "\n" +
            " $\\int_a^b f(x)dx$\n" +
            "\n" +
            "\n" +
            " • Матрицы\n" +
            "\n" +
            " Для создания матриц используются следующие символы:\n" +
            "\n" +
            " Начало матрицы: \\begin{matrix}\n" +
            " Конец матрицы: \\end{matrix}\n" +
            " Разделитель столбцов: &\n" +
            " Разделитель строк: \\\n" +
            "\n" +
            " Например, чтобы создать матрицу 2x2 с элементами a, b, c, d, нужно написать следующий код:\n" +
            "\n" +
            " $\\begin{matrix} a & b \\\\ c & d \\end{matrix}$" +
            "\n\nДля создания символов греческого алфавита используются следующие команды:\n" +
            "\n" +
            "\n" +
            "• $\\alpha$: альфа\n" +
            "• $\\beta$: бета\n" +
            "• $\\gamma$: гамма\n" +
            "• $\\delta$: дельта\n" +
            "• $\\epsilon$: эпсилон\n" +
            "• $\\zeta$: зета\n" +
            "• $\\eta$: эта\n" +
            "• $\\theta$: тета\n" +
            "• $\\iota$: йота\n" +
            "• $\\kappa$: каппа\n" +
            "• $\\lambda$: лямбда\n" +
            "• $\\mu$: мю\n" +
            "• $\\nu$: ню\n" +
            "• $\\xi$: кси\n" +
            "• $\\pi$: пи\n" +
            "• $\\rho$: ро\n" +
            "• $\\sigma$: сигма\n" +
            "• $\\tau$: тау\n" +
            "• $\\upsilon$: ипсилон\n" +
            "• $\\phi$: фи\n" +
            "• $\\chi$: хи\n" +
            "• $\\psi$: пси\n" +
            "• $\\omega$: омега\n" +
            "\n" +
            "Например, чтобы создать символ гамма, нужно написать следующий код:\n" +
            "\n" +
            "$\\gamma$\n" +
            "\n" +
            "\n" +
            "• Корни\n" +
            "\n" +
            "Для создания корней используются следующие символы:\n" +
            "\n" +
            "\n" +
            "• \\sqrt: квадратный корень\n" +
            "• \\sqrt[n]: корень n-ой степени\n" +
            "\n" +
            "Например, чтобы создать корень квадратный из a, нужно написать следующий код:\n" +
            "\n" +
            "$\\sqrt{a}$\n" +
            "\n" +
            "\n" +
            "• Выносной текст\n" +
            "\n" +
            "Для создания выносного текста используется команда \\text{}. Например, чтобы создать формулу с выносным текстом \"если x > 0\", нужно написать следующий код:\n" +
            "\n" +
            "$f(x) = \\begin{cases} x^2, & \\text{если } x > 0 \\\\ 0, & \\text{если } x \\leq 0 \\end{cases}$\n" +
            "\n" +
            "\n" +
            "• Суммы и произведения\n" +
            "\n" +
            "Для создания сумм и произведений используются следующие символы:\n" +
            "\n" +
            "\n" +
            "• \\sum_{lower}^{upper}: сумма\n" +
            "• \\prod_{lower}^{upper}: произведение\n" +
            "\n" +
            "Например, чтобы создать сумму от i=1 до n с элементами a_i, нужно написать следующий код:\n" +
            "\n" +
            "$\\sum_{i=1}^{n} a_i$\n"+
            "\n\n Пример сложной конструкции в LaTeX:\n " +
            "$ i\\hbar\\frac{\\partial}{\\partial t} \\Psi(\\mathbf{r_1}, \\mathbf{r_2}, \\ldots, \\mathbf{r_N}, t) = \\left [ -\\frac{\\hbar^2}{2m_1}\\nabla_1^2 - \\frac{\\hbar^2}{2m_2}\\nabla_2^2 - \\ldots - \\frac{\\hbar^2}{2m_N}\\nabla_N^2 + V(\\mathbf{r_1}, \\mathbf{r_2}, \\ldots, \\mathbf{r_N}, t) \\right ] \\Psi(\\mathbf{r_1}, \\mathbf{r_2}, \\ldots, \\mathbf{r_N}, t)$";

    public static void helperWithLaTeX() {

        JTextArea textArea = new JTextArea(TEXT);
        textArea.setEditable(false);

        JScrollPane scrollPane = new JScrollPane(textArea);
        scrollPane.setPreferredSize(new Dimension(1000, 640));

        JFrame helpFrame = new JFrame("Инструкция");

        Image icon = Toolkit.getDefaultToolkit().getImage("iconBook.png");
        helpFrame.setIconImage(icon);

        helpFrame.add(scrollPane);
        helpFrame.pack();

        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();

        int x = (screenSize.width - helpFrame.getWidth()) / 2;
        int y = (screenSize.height - helpFrame.getHeight()) / 2;

        helpFrame.setLocation(x, y);

        helpFrame.setVisible(true);
    }

    public static String getHelperText() {
        return TEXT;
    }
}
