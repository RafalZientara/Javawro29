package pl.com.sda.rafal.zientara.apps.lesson4.ultra;

import javafx.scene.paint.Color;
import pl.com.sda.rafal.zientara.apps.lesson4.ultra.shape.Line;
import pl.com.sda.rafal.zientara.apps.lesson4.ultra.shape.Shape;

public class ShapeFactory {

    public static Shape make(String input) {
        String[] data = input.split(";");
        String type = data[0].toLowerCase();

        switch (type) {
            case "line":
                return createLine(data);
                //todo reszta figur
            default:
                System.out.println("Unsupported!");
                return null;
        }

    }

    private static Shape createLine(String[] data) {
        double x1 = Double.parseDouble(data[1]);
        double y1 = Double.parseDouble(data[2]);
        double x2 = Double.parseDouble(data[3]);
        double y2 = Double.parseDouble(data[4]);
        Color strokeColor = Color.valueOf(data[5]);
        double lineThickness = Double.parseDouble(data[6]);

        Line line = new Line(strokeColor, x1, y1, x2, y2);
        line.setLineThickness(lineThickness);
        return line;
    }
}
