package pl.com.sda.rafal.zientara.apps.lesson4.ultra;

import javafx.scene.paint.Color;
import pl.com.sda.rafal.zientara.apps.lesson4.ultra.shape.*;

public class ShapeFactory {

    public static Shape make(String input) {
        String[] data = input.split(";");
        String type = data[0].toLowerCase();

        switch (type) {
            case "line":
                return createLine(data);
            case "oval":
                return createOval(data);
            case "rectangle":
                return createRectangle(data);
            case "square":
                return createSquare(data);
            case "star":
                return createStar(data);
            case "triangle":
                return createTriangle(data);
            default:
                System.out.println("Unsupported!");
                return null;
        }

    }

    private static Line createLine(String[] data) {
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

    private static Oval createOval(String[] data) {
        double x1 = Double.parseDouble(data[1]);
        double y1 = Double.parseDouble(data[2]);
        double width = Double.parseDouble(data[3]);
        double height = Double.parseDouble(data[4]);
        Color strokeColor = Color.valueOf(data[5]);
        Color fillColor = Color.valueOf(data[6]);
        double lineThickness = Double.parseDouble(data[7]);

        Oval shape = new Oval(x1, y1, width, height);
        shape.setFillColor(fillColor);
        shape.setStrokeColor(strokeColor);
        shape.setLineThickness(lineThickness);
        return shape;
    }

    private static Rectangle createRectangle(String[] data) {
        double x = Double.parseDouble(data[1]);
        double y = Double.parseDouble(data[2]);
        double width = Double.parseDouble(data[3]);
        double height = Double.parseDouble(data[4]);
        Color strokeColor = Color.valueOf(data[5]);
        Color fillColor = Color.valueOf(data[6]);
        double lineThickness = Double.parseDouble(data[7]);

        Rectangle shape = new Rectangle(x, y, width, height);
        shape.setFillColor(fillColor);
        shape.setStrokeColor(strokeColor);
        shape.setLineThickness(lineThickness);
        return shape;
    }

    private static Square createSquare(String[] data) {
        double x = Double.parseDouble(data[1]);
        double y = Double.parseDouble(data[2]);
        double side = Double.parseDouble(data[3]);
        Color strokeColor = Color.valueOf(data[4]);
        Color fillColor = Color.valueOf(data[5]);
        double lineThickness = Double.parseDouble(data[6]);

        Square shape = new Square(x, y, side);
        shape.setFillColor(fillColor);
        shape.setStrokeColor(strokeColor);
        shape.setLineThickness(lineThickness);
        return shape;
    }

    private static Star createStar(String[] data) {
        double x = Double.parseDouble(data[1]);
        double y = Double.parseDouble(data[2]);
        double r = Double.parseDouble(data[3]);
        Color strokeColor = Color.valueOf(data[4]);
        Color fillColor = Color.valueOf(data[5]);
        double lineThickness = Double.parseDouble(data[6]);

        Star shape = new Star(x, y, r);
        shape.setFillColor(fillColor);
        shape.setStrokeColor(strokeColor);
        shape.setLineThickness(lineThickness);
        return shape;
    }

    private static Triangle createTriangle(String[] data) {
        double x = Double.parseDouble(data[1]);
        double y = Double.parseDouble(data[2]);
        double width = Double.parseDouble(data[3]);
        double height = Double.parseDouble(data[4]);
        Color strokeColor = Color.valueOf(data[5]);
        Color fillColor = Color.valueOf(data[6]);
        double lineThickness = Double.parseDouble(data[7]);

        Triangle shape = new Triangle(x, y, width, height);
        shape.setFillColor(fillColor);
        shape.setStrokeColor(strokeColor);
        shape.setLineThickness(lineThickness);
        return shape;
    }
}
