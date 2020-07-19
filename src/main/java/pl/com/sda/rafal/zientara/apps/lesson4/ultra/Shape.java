package pl.com.sda.rafal.zientara.apps.lesson4.ultra;

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;

public abstract class Shape {
    private Color color;
    private double lineThickness;

    public Shape(Color color) {
        this.color = color;
        lineThickness = 5;
    }

    public abstract void draw(GraphicsContext context);

    public Color getColor() {
        return color;
    }

    public double getLineThickness() {
        return lineThickness;
    }
}
