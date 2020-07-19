package pl.com.sda.rafal.zientara.apps.lesson4.ultra.shape;

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;
import pl.com.sda.rafal.zientara.apps.lesson4.ultra.Converter;

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
    public void drawShape(GraphicsContext context) {
        //draw() w Shape samo ustawia kolory i linie
        context.strokeLine(startX, startY, endX, endY);
    }

    @Override
    public String convertToText() {
        return new Converter(this)
                .add(startX)
                .add(startY)
                .add(endX)
                .add(endY)
                .add(getStrokeColor())
                .add(getLineThickness())
                .create();
    }
}
