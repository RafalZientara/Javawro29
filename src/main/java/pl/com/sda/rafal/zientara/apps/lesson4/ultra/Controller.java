package pl.com.sda.rafal.zientara.apps.lesson4.ultra;

import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.input.MouseEvent;
import javafx.scene.paint.Color;

import java.util.ArrayList;
import java.util.List;

public class Controller {

    @FXML
    private Canvas canvas;

    private double startX;
    private double startY;
    private double endX;
    private double endY;
    private List<Shape> shapeList = new ArrayList<>();
    private Shape currentShape;

    public void initialize() {
        System.out.println("Hello : D");
        canvas.setOnMousePressed(new EventHandler<MouseEvent>() {
            public void handle(MouseEvent event) {
                double x = event.getX();
                double y = event.getY();
                startX = x;
                startY = y;
                endX = x;
                endY = y;

                System.out.printf("Pressed: %.2f x %.2f\n", x, y);
                refreshCanvas();
            }
        });

        canvas.setOnMouseDragged(new EventHandler<MouseEvent>() {
            public void handle(MouseEvent event) {
                double x = event.getX();
                double y = event.getY();
                endX = x;
                endY = y;

                System.out.printf("Dragged: %.2f x %.2f\n", x, y);
                currentShape = createShape();
                refreshCanvas();
            }
        });


        canvas.setOnMouseReleased(new EventHandler<MouseEvent>() {
            public void handle(MouseEvent event) {
                double x = event.getX();
                double y = event.getY();
                endX = x;
                endY = y;

                System.out.printf("Released: %.2f x %.2f\n", x, y);
                currentShape = createShape();
                shapeList.add(currentShape);
                refreshCanvas();
            }
        });

        refreshCanvas();
    }

    private Shape createShape() {
        return new Line(Color.DARKSALMON, startX, startY, endX, endY);
    }

    private void refreshCanvas() {
        GraphicsContext context = canvas.getGraphicsContext2D();

        //czyszczenie calej planszy
        context.clearRect(0, 0, canvas.getWidth(), canvas.getHeight());
        context.strokeRect(0, 0, canvas.getWidth(), canvas.getHeight());

        for (Shape shape : shapeList) {
            shape.draw(context);
        }

        if (currentShape!=null) {
            currentShape.draw(context);
        }
    }
}
