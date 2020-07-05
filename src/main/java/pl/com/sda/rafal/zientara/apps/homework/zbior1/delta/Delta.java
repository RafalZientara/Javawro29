package pl.com.sda.rafal.zientara.apps.homework.zbior1.delta;

public class Delta {
    double a;
    double b;
    double c;

    public Delta(double a, double b, double c) {
        this.a = a;
        this.b = b;
        this.c = c;
    }

    public double countDelta() {
        return b * b - 4 * a * c;
    }

    public double[] getZeros() {
        double delta = countDelta();
        if (delta > 0) {
            double x1 = (-getB() - Math.sqrt(delta)) / (2 * getA());
            double x2 = (-getB() + Math.sqrt(delta)) / (2 * getA());
            return new double[]{x1, x2};
        } else if (delta == 0) {
            double x = -getB() / (2 * getA());
            return new double[]{x};
        } else {
            return new double[0];
        }
    }

    public double getA() {
        return a;
    }

    public double getB() {
        return b;
    }

    public double getC() {
        return c;
    }
}
