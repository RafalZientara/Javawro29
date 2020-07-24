package pl.com.sda.rafal.zientara.apps.lesson4.ultra.shape;

import javafx.geometry.Point2D;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;
import pl.com.sda.rafal.zientara.apps.lesson4.ultra.Converter;

import java.util.List;

public class Brush extends Shape {

    private List<Point2D> path;

    public Brush(Color strokeColor, List<Point2D> path) {
        super(strokeColor);
        this.path = path;
    }

    public Brush(List<Point2D> path) {
        super(Color.DARKSALMON);
        this.path = path;
    }

    @Override
    public void drawShape(GraphicsContext context) {
        if (path.size()>2) {
            Point2D first = path.get(0);
            context.moveTo(first.getX(), first.getY());
            context.beginPath();
            for (int i = 1; i < path.size(); i++) {
                Point2D current = path.get(i);
                context.lineTo(current.getX(), current.getY());
            }
//            context.closePath();//nie chcemy robic cyklu!
            context.stroke();
        }
    }

    @Override
    public String convertToText() {
        return new Converter(this)
                .add(path)
                .add(getStrokeColor())
                .add(getLineThickness())
                .create();
    }
}
