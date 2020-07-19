package pl.com.sda.rafal.zientara.apps.lesson4.ultra;

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;

public class Line extends Shape {
    private final double startX;
    private final double startY;
    private final double endX;
    private final double endY;

    public Line(Color color, //todo support for colors
                double startX, double startY,
                double endX, double endY) {
        super(color);
        this.startX = startX;
        this.startY = startY;
        this.endX = endX;
        this.endY = endY;
    }

    @Override
    public void draw(GraphicsContext context) {
        context.setStroke(getColor());
        context.setLineWidth(getLineThickness());
        context.strokeLine(startX, startY, endX, endY);
    }
}
