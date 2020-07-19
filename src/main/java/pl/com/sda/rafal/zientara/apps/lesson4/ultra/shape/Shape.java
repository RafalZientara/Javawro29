package pl.com.sda.rafal.zientara.apps.lesson4.ultra.shape;

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;

//Template pattern
public abstract class Shape {
    private Color strokeColor;
    private Color fillColor = Color.RED;
    private double lineThickness;

    public Shape(Color strokeColor) {
        this.strokeColor = strokeColor;
        lineThickness = 5;
    }

    public void draw(GraphicsContext context) {
        context.setStroke(getStrokeColor());
        context.setLineWidth(getLineThickness());
        context.setFill(getFillColor());
        drawShape(context);
    }
    public abstract void drawShape(GraphicsContext context);

    public abstract String convertToText();

    public Color getStrokeColor() {
        return strokeColor;
    }

    public void setStrokeColor(Color strokeColor) {
        this.strokeColor = strokeColor;
    }

    public Color getFillColor() {
        return fillColor;
    }

    public void setFillColor(Color fillColor) {
        this.fillColor = fillColor;
    }

    public double getLineThickness() {
        return lineThickness;
    }
}
