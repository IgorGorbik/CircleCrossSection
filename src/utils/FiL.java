package utils;

import java.util.Enumeration;
import java.util.Vector;

/**
 *
 * @author Игорь
 */
public class FiL {

    static double x;// l0/d
    static double x1;// ec/r

    static Vector ht = new Vector();
    static Vector ht1 = new Vector();
    static Vector ht2 = new Vector();
    static Vector ht3 = new Vector();
    static Vector ht4 = new Vector();
    static Vector ec = new Vector();
    static Vector ht0 = new Vector();

    static {

        ht0.add(1.0);
        ht0.add(0.84);
        ht0.add(0.79);
        ht0.add(0.7);
        ht0.add(0.65);
        ht0.add(0.56);
        ht0.add(0.47);
        ht0.add(0.41);
        ht0.add(0.32);
        ht0.add(0.25);
        ht0.add(0.2);
        ht0.add(0.16);
        ht0.add(0.14);
        ht0.add(0.1);
        ht0.add(0.08);
        ht0.add(0.07);
        ht0.add(0.06);

        ht.add(3.5);
        ht.add(3.6);
        ht.add(10.4);
        ht.add(12.1);
        ht.add(13.8);
        ht.add(15.6);
        ht.add(17.3);
        ht.add(19.1);
        ht.add(20.8);
        ht.add(22.5);
        ht.add(24.3);
        ht.add(26.0);
        ht.add(27.7);
        ht.add(29.0);
        ht.add(33.0);
        ht.add(34.6);
        ht.add(37.5);

        ht1.add(1.0);
        ht1.add(1.0);
        ht1.add(0.95);
        ht1.add(0.9);
        ht1.add(0.86);
        ht1.add(0.82);
        ht1.add(0.78);
        ht1.add(0.72);
        ht1.add(0.67);
        ht1.add(0.62);
        ht1.add(0.58);
        ht1.add(0.53);
        ht1.add(0.48);
        ht1.add(0.43);
        ht1.add(0.38);
        ht1.add(0.35);
        ht1.add(0.33);

        ht2.add(0.9);
        ht2.add(0.86);
        ht2.add(0.83);
        ht2.add(0.79);
        ht2.add(0.75);
        ht2.add(0.71);
        ht2.add(0.67);
        ht2.add(0.6);
        ht2.add(0.55);
        ht2.add(0.51);
        ht2.add(0.49);
        ht2.add(0.45);
        ht2.add(0.41);
        ht2.add(0.36);
        ht2.add(0.32);
        ht2.add(0.29);
        ht2.add(0.28);

        ht3.add(0.81);
        ht3.add(0.77);
        ht3.add(0.74);
        ht3.add(0.7);
        ht3.add(0.66);
        ht3.add(0.62);
        ht3.add(0.57);
        ht3.add(0.52);
        ht3.add(0.47);
        ht3.add(0.44);
        ht3.add(0.43);
        ht3.add(0.39);
        ht3.add(0.36);
        ht3.add(0.31);
        ht3.add(0.28);
        ht3.add(0.25);
        ht3.add(0.24);

        ht4.add(0.69);
        ht4.add(0.65);
        ht4.add(0.62);
        ht4.add(0.58);
        ht4.add(0.55);
        ht4.add(0.51);
        ht4.add(0.48);
        ht4.add(0.43);
        ht4.add(0.38);
        ht4.add(0.35);
        ht4.add(0.34);
        ht4.add(0.32);
        ht4.add(0.31);
        ht4.add(0.25);
        ht4.add(0.24);
        ht4.add(0.21);
        ht4.add(0.21);

        ec.add(0.0);
        ec.add(0.25);
        ec.add(0.5);
        ec.add(1.0);

    }

    static Vector[] v = {ht1, ht2, ht3, ht4, ht, ec, ht0};
    static Enumeration en;
    static String st;

    static double method1(double a) {
        en = ht.elements();
        double st1 = 0;
        while (en.hasMoreElements()) {
            st1 = (double) en.nextElement();
            if (a < st1) {
                break;
            }
        }
        return st1;
    }

    static double method2(double a, int vect) {
        Vector vector1 = v[vect];
        int b = ht.indexOf(a);
        int c = (b - 1) < 0 ? 0 : (b - 1);
        double d = method3(a, (double) ht.get(c));
        return ((double) vector1.get(c) + d * (((double) vector1.get(b))
                - ((double) vector1.get(c))));
    }

    static double method3(double a, double b) {
        double c;
        if ((a - b) == 0) {
            c = 0;
        } else {
            c = (((x - b) / (a - b)) > 1) ? 1 : ((x - b) / (a - b));
        }
        return c;
    }

    public static double fil(double y, double y1) {
        x = y;
        x1 = y1;
        double z = 0;
        if (x1 <= (0.25)) {
            z = ((x1 - 0) / 0.25) * ((method2(method1(x), 1))
                    - (method2(method1(x), 0)))
                    + (method2(method1(x), 0));
        }
        if ((x1 > (0.25)) && (x1 <= (0.5))) {
            z = ((x1 - 0.25) / 0.25) * ((method2(method1(x), 2))
                    - (method2(method1(x), 1)))
                    + (method2(method1(x), 1));
        }
        if ((x1 > (0.5)) && (x1 <= (1.0))) {
            z = ((x1 - 0.5) / 0.5) * ((method2(method1(x), 3))
                    - (method2(method1(x), 2)))
                    + (method2(method1(x), 2));
        }
        if (x1 > 1) {
            z = ((1 - 0.5) / 0.5) * ((method2(method1(x), 3))
                    - (method2(method1(x), 2)))
                    + (method2(method1(x), 2));
        }
        return z;
    }

    public static double fim(double y) {
        x = y;
        return method2(method1(x), 6);
    }

}
