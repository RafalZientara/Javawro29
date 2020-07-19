package pl.com.sda.rafal.zientara.apps.lesson4.ultra.shape;

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;
import pl.com.sda.rafal.zientara.apps.lesson4.ultra.Converter;

public class Oval extends Shape {
    private final double x;
    private final double y;
    private final double width;
    private final double height;

    public Oval(Color color,
                double startX, double startY,
                double endX, double endY) {
        super(color);
        x = Math.min(startX, endX);
        y = Math.min(startY, endY);
        width = Math.abs(endX - startX);
        height = Math.abs(endY - startY);
    }

    public Oval(double x, double y, double width, double height) {
        super(Color.DARKSALMON);
        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;
    }

    @Override
    public void drawShape(GraphicsContext context) {
        context.fillOval(x, y, width, height);
        context.strokeOval(x, y, width, height);
    }

    @Override
    public String convertToText() {
        return new Converter(this)
                .add(x)
                .add(y)
                .add(width)
                .add(height)
                .add(getStrokeColor())
                .add(getFillColor())
                .add(getLineThickness())
                .create();
    }
}
