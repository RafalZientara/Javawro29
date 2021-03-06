package pl.com.sda.rafal.zientara.apps.lesson4.ultra.shape;

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;
import pl.com.sda.rafal.zientara.apps.lesson4.ultra.Converter;

public class Triangle extends Shape {
    private final double x;
    private final double y;
    private final double width;
    private final double height;

    public Triangle(Color color,
                    double startX, double startY,
                    double endX, double endY) {
        super(color);
        x = Math.min(startX, endX);
        y = Math.min(startY, endY);
        width = Math.abs(endX - startX);
        height = Math.abs(endY - startY);
    }

    public Triangle(double x, double y, double width, double height) {
        super(Color.BLUE);
        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;
    }

    @Override
    public void drawShape(GraphicsContext context) {
        context.moveTo(x,y+height);//1 a
        context.beginPath();//1
        context.lineTo(x + width/2, y);//2 b
        context.lineTo(x + width, y + height);//3 c
        context.lineTo(x,y+height);
        context.closePath();
        context.fill();
        context.stroke();
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
