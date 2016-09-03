package utils;

import java.text.DecimalFormat;
import java.text.NumberFormat;

/**
 *
 * @author Игорь
 */
public class GenerateHTML {

    private double D;
    private double n;
    private double d;
    private double as;
    private double N;
    private double Nd;
    private double M;
    private double Md;
    private double ksi;
    private double fi;
    private double ec;
    private double eta;
    private double k;

    private String A;
    private String B;

    public GenerateHTML(double[] arr, String a, String b) {
        D = arr[0];
        n = arr[1];
        d = arr[2];
        as = arr[3];
        N = arr[4];
        Nd = arr[5];
        M = arr[6];
        Md = arr[7];
        ksi = arr[8];
        fi = arr[9];
        ec = arr[10];
        eta = arr[11];
        k = arr[12];
        A = a;
        B = b;
    }

    /**
     * @return the str
     */
    public String getStr() {
        NumberFormat f = new DecimalFormat("#0.000");
        return "    <head>\n"
                + "        <meta charset=\"utf-8\">\n"
                + "        <title>Отчет</title>\n"
                + "    </head>\n"
                + "\n"
                + "    <body>\n"
                + "\n"
                + "        <table width=100% border=\"0\">\n"
                + "\n"
                + "            <tr>\n"
                + "                <td colspan=\"2\" style=\"background-color:#FFA500;\">\n"
                + "                    <p align=\"center\" "
                + "style=\"font-size:12px\"><b>Результаты расчета</p>\n"
                + "                </td>\n"
                + "            </tr>\n"
                + "\n"
                + "            <tr>\n"
                + "                <td colspan=\"2\">\n"
                + "                    <p align=\"center\" "
                + "style=\"text-decoration: underline;\">1.Геометрические характеристики</p>\n"
                + "                </td>\n"
                + "            </tr>\n"
                + "\n"
                + "            <tr>\n"
                + "                <td colspan=\"1\" style=\"width:50%;\">\n"
                + "                    <p align=\"center\">Диаметр сечения: "
                + D * 100
                + " см</p>\n"
                + "                </td>\n"
                + "                <td colspan=\"1\" style=\"width:50%;\">\n"
                + "                    <p align=\"center\">Класс бетона: "
                + B
                + "</p>\n"
                + "                </td>\n"
                + "            </tr>\n"
                + "\n"
                + "            <tr>\n"
                + "                <td colspan=\"1\"  style=\"width:50%;\">\n"
                + "                    <p align=\"center\">Количество стержней: "
                + (int) n
                + "</p>\n"
                + "                </td>\n"
                + "                <td colspan=\"1\"  style=\"width:50%;\">\n"
                + "                    <p align=\"center\">Класс арматуры: "
                + A
                + "</p>\n"
                + "                </td>\n"
                + "            </tr>\n"
                + "\n"
                + "            <tr>\n"
                + "                <td colspan=\"1\"  style=\"width:50%;\">\n"
                + "                    <p align=\"center\">Диаметр арматуры: "
                + (int) (d * 1000)
                + " мм</p>\n"
                + "                </td>\n"
                + "                <td colspan=\"1\"  style=\"width:50%;\">\n"
                + "                    <p align=\"center\">Защитный слой: "
                + (int) (as * 1000)
                + " мм</p>\n"
                + "                </td>\n"
                + "            </tr>\n"
                + "\n"
                + "            <tr>\n"
                + "                <td colspan=\"2\" >\n"
                + "                    <p align=\"center\" "
                + "style=\"text-decoration: underline;\">2.Нагрузки</p>\n"
                + "                </td>\n"
                + "            </tr>\n"
                + "\n"
                + "            <tr>\n"
                + "                <td colspan=\"2\" >\n"
                + "                    <p align=\"center\" "
                + "style=\"text-decoration: underline;\">2.1 Постоянные нагрузки</p>\n"
                + "                </td>\n"
                + "            </tr>\n"
                + "\n"
                + "            <tr>\n"
                + "                <td colspan=\"1\"  style=\"width:50%;\">\n"
                + "                    <p align=\"center\">Продольная сила: "
                + N / 1000.0
                + " кН</p>\n"
                + "                </td>\n"
                + "                <td colspan=\"1\"  style=\"width:50%;\">\n"
                + "                    <p align=\"center\">Изгибающий момент: "
                + M / 1000.0
                + " кНм</p>\n"
                + "                </td>\n"
                + "            </tr>\n"
                + "\n"
                + "            <tr>\n"
                + "                <td colspan=\"2\" >\n"
                + "                    <p align=\"center\">2.1 Временные нагрузки</p>\n"
                + "                </td>\n"
                + "            </tr>\n"
                + "\n"
                + "            <tr>\n"
                + "                <td colspan=\"1\" style=\"width:50%;\">\n"
                + "                    <p align=\"center\">Продольная сила: "
                + Nd / 1000.0
                + " кН</p>\n"
                + "                </td>\n"
                + "                <td colspan=\"1\"  style=\"width:50%;\">\n"
                + "                    <p align=\"center\">Изгибающий момент: "
                + Md / 1000.0
                + " кНм</p>\n"
                + "                </td>\n"
                + "            </tr>\n"
                + "\n"
                + "            <tr>\n"
                + "                <td colspan=\"2\" >\n"
                + "                    <p align=\"center\""
                + " style=\"text-decoration: underline;\">3.Аналитика</p>\n"
                + "                </td>\n"
                + "            </tr>\n"
                + "\n"
                + "            <tr>\n"
                + "                <td colspan=\"2\" >\n"
                + "                    <p align=\"center\" "
                + "style=\"text-decoration: underline;\">3.1 Параметры расчета</p>\n"
                + "                </td>\n"
                + "            </tr>\n"
                + "\n"
                + "            <tr>\n"
                + "                <td colspan=\"1\"  style=\"width:50%;\">\n"
                + "                    <p align=\"center\">Параметр ξ: "
                + f.format(ksi)
                + "</p>\n"
                + "                </td>\n"
                + "                <td colspan=\"1\"  style=\"width:50%;\">\n"
                + "                    <p align=\"center\">Параметр φ: "
                + f.format(fi)
                + "</p>\n"
                + "                </td>\n"
                + "            </tr>\n"
                + "\n"
                + "            <tr>\n"
                + "                <td colspan=\"1\"  style=\"width:50%;\">\n"
                + "                    <p align=\"center\">Эксцентриситет e: "
                + f.format(ec)
                + " м</p>\n"
                + "                </td>\n"
                + "                <td colspan=\"1\"  style=\"width:50%;\">\n"
                + "                    <p align=\"center\">Параметр η: "
                + f.format(eta)
                + "</p>\n"
                + "                </td>\n"
                + "            </tr>\n"
                + "\n"
                + "            <tr>\n"
                + "                <td colspan=\"2\" >\n"
                + "                    <p align=\"center\""
                + " style=\"text-decoration: underline;\">3.2 Коэффициент прочности: "
                + f.format(k)
                + "</p>\n"
                + "                </td>\n"
                + "            </tr>\n"
                + "\n"
                + "        </table>  \n"
                + "\n"
                + "    </body>\n"
                + "</html>";
    }

}
