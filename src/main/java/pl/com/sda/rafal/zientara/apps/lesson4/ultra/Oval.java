package pl.com.sda.rafal.zientara.apps.lesson4.ultra;

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;

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
    public void draw(GraphicsContext context) {
        context.setStroke(getColor());
        context.setLineWidth(getLineThickness());
        context.strokeOval(x, y, width, height);
    }
}
