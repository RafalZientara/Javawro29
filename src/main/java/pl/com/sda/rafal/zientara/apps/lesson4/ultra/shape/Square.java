package pl.com.sda.rafal.zientara.apps.lesson4.ultra.shape;

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;
import pl.com.sda.rafal.zientara.apps.lesson4.ultra.Converter;

public class Square extends Shape {
    private final double x;
    private final double y;
    private final double side;

    public Square(Color color,
                  double startX, double startY,
                  double endX, double endY) {
        super(color);

        double width = Math.abs(endX - startX);
        double height = Math.abs(endY - startY);
        side = Math.min(width, height);

        if (startX < endX) {
            x = startX;
        } else {
            x = startX - side;
        }
        if (startY > endY) {
            y = startY - side;
        } else {
            y = startY;
        }
    }

    public Square(double x, double y, double side) {
        super(Color.INDIANRED);
        this.x = x;
        this.y = y;
        this.side = side;
    }

    @Override
    public void drawShape(GraphicsContext context) {
        context.fillRect(x, y, side, side);
        context.strokeRect(x, y, side, side);
    }

    @Override
    public String convertToText() {
        return new Converter(this)
                .add(x)
                .add(y)
                .add(side)
                .add(getStrokeColor())
                .add(getFillColor())
                .add(getLineThickness())
                .create();
    }
}
