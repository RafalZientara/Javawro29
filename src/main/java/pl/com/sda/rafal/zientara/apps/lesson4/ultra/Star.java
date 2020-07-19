package pl.com.sda.rafal.zientara.apps.lesson4.ultra;

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;

public class Star extends Shape {
    private final double x;
    private final double y;
    private final double r;

    public Star(Color color,
                double startX, double startY,
                double endX, double endY) {
        super(color);

        double width = Math.abs(endX - startX);
        double height = Math.abs(endY - startY);
        double side = Math.min(width, height);
        r = side / 2f;

        if (startX < endX) {
            x = startX + r;
        } else {
            x = startX - side + r;
        }
        if (startY > endY) {
            y = startY - side + r;
        } else {
            y = startY + r;
        }
    }

    public Star(double x, double y, double r) {
        super(Color.INDIANRED);
        this.x = x;
        this.y = y;
        this.r = r;
    }

    @Override
    public void drawShape(GraphicsContext context) {
        double fullTurn = 2 * Math.PI;
        int count = 10;
        double interval = fullTurn / count;
        double startTheta = Math.PI / 2;

        context.moveTo(x, y);//todo
        context.beginPath();

        for (int i = 0; i < count; i++) {
            double radian = r;
            if (i % 2 == 1) {
                radian /= 2;
            }
            double angle = i * interval;
            double diffX = Math.cos(angle + startTheta) * radian;
            double diffY = -Math.sin(angle + startTheta) * radian;

            context.lineTo(x + diffX, y + diffY);
        }
        context.closePath();
        context.fill();
        context.stroke();
    }
}
