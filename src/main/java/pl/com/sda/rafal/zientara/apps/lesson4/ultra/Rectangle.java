package pl.com.sda.rafal.zientara.apps.lesson4.ultra;

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;

public class Rectangle extends Shape {
    private final double x;
    private final double y;
    private final double width;
    private final double height;

    public Rectangle(Color color,
                     double startX, double startY,
                     double endX, double endY) {
        super(color);
        x = Math.min(startX, endX);
        y = Math.min(startY, endY);
        width = Math.abs(endX - startX);
        height = Math.abs(endY - startY);
    }

    public Rectangle(double x, double y, double width, double height) {
        super(Color.DARKSALMON);
        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;
    }

    @Override
    public void drawShape(GraphicsContext context) {
        context.fillRect(x, y, width, height);
        context.strokeRect(x, y, width, height);
    }
}
