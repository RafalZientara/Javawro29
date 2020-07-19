package pl.com.sda.rafal.zientara.apps.lesson4.ultra;

import javafx.scene.paint.Color;

public class Converter {
    private StringBuilder builder = new StringBuilder();

    public Converter(Object object) {
        builder.append(object.getClass().getSimpleName());
        builder.append(";");
    }
    //int, double, color, Object

    public Converter add(int value) {
        builder.append(value);
        builder.append(";");
        return this;
    }

    public Converter add(double value) {
        builder.append(value);
        builder.append(";");
        return this;
    }

    public Converter add(Color value) {
        builder.append(value);
        builder.append(";");
        return this;
    }

    public Converter add(Object value) {
        builder.append(value);
        builder.append(";");
        return this;
    }

    public String create() {
        return builder.toString();
    }

}
