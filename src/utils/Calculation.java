package utils;

/**
 *
 * @author Игорь
 */
public class Calculation {

    public static boolean variant(double N, double Rs, double As,
            double Rb, double Ab) {
        if (N <= 0.77 * Rb * Ab + 0.645 * Rs * As) {
            return true;
        } else {
            return false;
        }
    }

    public static double getKsi(double N, double Rs, double As, double Rb,
            double Ab, boolean bl) {
        double Ksicir1 = 0.000;
        double Ksicir = 0.000;
        while (Ksicir1 <= 1.000) {
            if (bl == true) {
                Ksicir = (N + Rs * As + Rb * Ab
                        * ((Math.sin(6.28 * Ksicir1)) / (2 * Math.PI)))
                        / (Rb * Ab + 2.55 * Rs * As);
            } else {
                Ksicir = (N + Rb * Ab * ((Math.sin(6.28 * Ksicir1))
                        / (2 * Math.PI))) / (Rb * Ab + Rs * As);
            }
            if (((Math.abs(Ksicir - Ksicir1))) <= 0.001) {
                break;
            }
            Ksicir1 += 0.001;
        }
        return Ksicir;
    }

    public static double getFi(double Ksicir, boolean bl) {
        if (bl) {
            if ((1.6 * (1 - 1.55 * Ksicir) * Ksicir) > 1.0) {
                return 1.0;
            } else {
                return (1.6 * (1 - 1.55 * Ksicir) * Ksicir);
            }
        } else {
            return 0.0;
        }
    }

    public static double get_As(double n, double d) {
        double As = Math.PI * d * d * 0.25 * n;
        return As;
    }

    public static double get_Ab(double d) {
        double Ab = Math.PI * d * d * 0.25;
        return Ab;
    }

    public static double get_ec(double N, double M, double l0, boolean bl) {
        if (bl == true) {
            return M / N + l0 / 400;
        } else if (M / N <= l0 / 400) {
            return l0 / 400;
        } else {
            return M / N;
        }
    }

    public static double get_rs(double d, double ds, double a) {
        return 0.5 * d - a - 0.5 * ds;
    }

    public static double get_Ared(double Ab, double As, double n) {
        return Ab + n * As;
    }

    public static double get_Ib(double D) {
        return Math.PI * Math.pow(D, 4) / 64;
    }

    public static double get_Is(double As, double rs) {
        return As * rs * rs * 0.5;
    }

    public static double get_Ired(double Ib, double Is, double n) {
        return Ib + n * Is;
    }

    public static double get_r(double Ired, double Ared, double r) {
        return Ired / (Ared * r);
    }

    public static double get_FiI(double N1, double N2, double M1, double M2,
            double rs, double ec, double D) {
        double Ml = M1 + N1 * rs;
        double M = (M1 + M2) + (N1 + N2) * rs;
        if (Ml * M != Math.abs(Ml * M)) {
            if (ec >= 0.1 * D) {
                return 1.0;
            } else {
                return 1.05;
            }
        } else {
            return 1 + (Ml) / (M);
        }
    }

    public static double get_Delt(double l0, double D, double Rb, double ec) {
        double Deltmin = 0.5 - 0.01 * l0 / D - 0.01 * Rb;
        double Delt = ec / D;
        if (Delt < Deltmin) {
            return Deltmin;
        } else {
            return Delt;
        }
    }

    public static double get_Ncr(double Eb, double l0, double Ib, double FiI,
            double Delt, double fp, double n, double Is) {
        return 6.4 * Eb * ((Ib / FiI) * (0.11 / (0.1 + Delt / fp) + 0.1)
                + n * Is) / (l0 * l0);
    }

    public static double get_Eta(double N, double Ncr) {
        return 1 / (1 - N / Ncr);
    }

    public static double get_N1(double N, double ec, double eta) {
        return N * ec * eta;
    }

    public static double get_N2(double Rb, double Ab, double D, double Ksicir,
            double Rs, double As, double fi, double rs) {
        return (2.0 / 3.0) * Rb * Ab * 0.5 * D
                * ((Math.pow(Math.sin(Math.PI * Ksicir), 3)) / Math.PI)
                + Rs * As * ((Math.sin(2 * Math.PI * Ksicir) / Math.PI) + fi)
                * rs;
    }

    public static double get_Chord(double rs, double a) {
        return 2 * rs * Math.sin(a / 2);
    }

}
