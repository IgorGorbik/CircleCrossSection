package info;

import utils.GenerateHTML;
import utils.Calculation;

/**
 *
 * @author Игорь
 */
public class CircleCross {

    private double D;
    private double as;
    private double l;
    private double N;
    private double Nd;
    private double M;
    private double Md;
    private double n;
    private double d;
    private double Rb;
    private double Rs;
    private double Eb;
    private double k;

    private String B;
    private String A;

    private double n1;
    private double n2;

    private double[] arr = new double[13];

    public GenerateHTML ghtml;

    public CircleCross() {

    }

    public boolean result() {
        double As = Calculation.get_As(n, d);
        double Ab = Calculation.get_Ab(D);
        double rs = Calculation.get_rs(D, as, d);
        boolean variant = Calculation.variant(N, Rs, As, Rb, Ab);
        n1 = load(variant, As, rs) / 1000;
        n2 = strength(variant, As, Ab, rs) / 1000;
        k = n2 / n1;
        arr[12] = k;
        ghtml = new GenerateHTML(arr, A, B);
        return k >= 1.0;
    }

    private double strength(boolean variant, double As, double Ab, double rs) {
        double ksi = Calculation.getKsi(N, Rs, As, Rb, Ab, variant);
        arr[8] = ksi;
        double fi = Calculation.getFi(ksi, variant);
        arr[9] = fi;
        double N2 = Calculation.get_N2(Rb, Ab, D, ksi, Rs, As, fi, rs);
        return N2;
    }

    private double load(boolean variant, double As, double rs) {
        double ec = Calculation.get_ec(N, M, l, variant);
        arr[10] = ec;
        double delt = Calculation.get_Delt(l, D, Rb, ec);
        double FiI = Calculation.get_FiI(N, Nd, M, Md, rs, ec, D);
        double Ib = Calculation.get_Ib(D);
        double Is = Calculation.get_Is(As, rs);
        double Ncr = Calculation.get_Ncr(Eb, l, Ib, FiI, delt, 1, n, Is);
        double eta = Calculation.get_Eta(N, Ncr);
        arr[11] = eta;
        double N1 = Calculation.get_N1(N, ec, eta);
        return N1;
    }

    public String validateDataPan1(String[] str1) {
        n = Integer.valueOf(str1[1]);
        arr[1] = n;
        d = Double.valueOf(str1[2]) * 0.001;
        arr[2] = d;
        Rb = Double.valueOf(str1[3]) * 1000000;
        Rs = Double.valueOf(str1[4]) * 1000000;
        Eb = Double.valueOf(str1[7]) * 1000000;
        A = str1[9];
        B = str1[8];
        String str = "";
        try {
            D = Double.valueOf(str1[0]) * 0.01;
            arr[0] = D;
        } catch (NumberFormatException el1) {
            str += "Неверно задан диаметр стойки" + "<br/>";
        } finally {
            try {
                as = Double.valueOf(str1[5]) * 0.001;
                arr[3] = as;
            } catch (NumberFormatException el2) {
                str += "Неверно задан защитный слой арматуры" + "<br/>";
            } finally {
                try {
                    l = Double.valueOf(str1[6]);
                } catch (NumberFormatException el3) {
                    str += "Неверно заданa расчетная длина стойки";
                }
            }
        }
        return str;
    }

    public String validateDataPan2(String[] str1) {
        String str = "";
        try {
            N = Double.valueOf(str1[0]) * 1000;
            arr[4] = N;
        } catch (NumberFormatException el1) {
            str += "Неверно задана N" + "<br/>";
        } finally {
            try {
                Nd = Double.valueOf(str1[1]) * 1000;
                arr[5] = Nd;
            } catch (NumberFormatException el2) {
                str += "Неверно задана Nдл" + "<br/>";
            } finally {
                try {
                    M = Double.valueOf(str1[2]) * 1000;
                    arr[6] = M;
                } catch (NumberFormatException el3) {
                    str += "Неверно задан M" + "<br/>";
                } finally {
                    try {
                        Md = Double.valueOf(str1[3]) * 1000;
                        arr[7] = Md;
                    } catch (NumberFormatException el3) {
                        str += "Неверно задан Mдл";
                    }
                }
            }
        }
        return str;
    }

    /**
     * @return the arr
     */
    public double[] getArr() {
        return arr;
    }

}
