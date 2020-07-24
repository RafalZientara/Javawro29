package pl.com.sda.rafal.zientara.apps.lesson4.ultra;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.embed.swing.SwingFXUtils;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.geometry.Point2D;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.control.Alert;
import javafx.scene.control.ColorPicker;
import javafx.scene.control.ComboBox;
import javafx.scene.image.WritableImage;
import javafx.scene.input.MouseEvent;
import javafx.scene.paint.Color;
import javafx.scene.shape.Path;
import javafx.stage.FileChooser;
import pl.com.sda.rafal.zientara.apps.lesson4.ultra.shape.*;

import javax.imageio.ImageIO;
import java.awt.image.RenderedImage;
import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import static pl.com.sda.rafal.zientara.apps.lesson4.ultra.PaintJavaFx.primaryStage;

public class Controller {

    @FXML
    private Canvas canvas;
    @FXML
    private ColorPicker fillColorPicker;
    @FXML
    private ColorPicker strokeColorPicker;
    @FXML
    private ComboBox<Double> lineThickness;

    private double startX;
    private double startY;
    private double endX;
    private double endY;
    private List<Shape> shapeList = new ArrayList<>();
    private Shape currentShape;
    private Tool currentTool = Tool.LINE;
    private List<Point2D> path = new ArrayList<>();

    public void initialize() {
        System.out.println("Hello : D");
        fillColorPicker.setValue(Color.DARKSALMON);
        strokeColorPicker.setValue(Color.BLACK);

        ObservableList<Double> options =
                FXCollections.observableArrayList(
                        1.,
                        2.,
                        3.,
                        4.,
                        5.,
                        6.,
                        7.,
                        8.
                );

        lineThickness.setItems(options);
        lineThickness.setValue(1.);

        canvas.setOnMousePressed(new EventHandler<MouseEvent>() {
            public void handle(MouseEvent event) {
                double x = event.getX();
                double y = event.getY();
                startX = x;
                startY = y;
                endX = x;
                endY = y;

                path = new ArrayList<>();//tworzymy nowy, aby nie czyscic poprzedniej akcji brush
                //jesli nie uzyjemy new bedziemy korzystac dalej z tego samego adresu w pamieci - czyli wyczyscilibysmy
                //poprzedni przez path.clear()
                path.add(new Point2D(x,y));
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

                path.add(new Point2D(x,y));
                System.out.printf("Dragged: %.2f x %.2f\n", x, y);
                currentShape = createShape();
//                shapeList.add(currentShape);
                refreshCanvas();
            }
        });


        canvas.setOnMouseReleased(new EventHandler<MouseEvent>() {
            public void handle(MouseEvent event) {
                double x = event.getX();
                double y = event.getY();
                endX = x;
                endY = y;

                path.add(new Point2D(x,y));
                System.out.printf("Released: %.2f x %.2f\n", x, y);
                currentShape = createShape();
                shapeList.add(currentShape);
                currentShape = null;
                refreshCanvas();
            }
        });

        refreshCanvas();
    }

    private Shape createShape() {
        Shape shape = getBaseShape();
        shape.setStrokeColor(strokeColorPicker.getValue());
        shape.setFillColor(fillColorPicker.getValue());
        shape.setLineThickness(lineThickness.getValue());
        return shape;
    }

    private Shape getBaseShape() {
        switch (currentTool) {
            default:
            case LINE:
                return new Line(Color.DARKSALMON, startX, startY, endX, endY);
            case RECTANGLE:
                return new Rectangle(Color.GREEN, startX, startY, endX, endY);
            case TRIANGLE:
                return new Triangle(Color.MEDIUMAQUAMARINE, startX, startY, endX, endY);
            case OVAL:
                return new Oval(Color.BLUE, startX, startY, endX, endY);
            case SQUARE:
                return new Square(Color.INDIANRED, startX, startY, endX, endY);
            case STAR:
                return new Star(Color.YELLOW, startX, startY, endX, endY);
            case BRUSH:
                return new Brush(Color.HOTPINK, path);
        }
    }

    private void refreshCanvas() {
        GraphicsContext context = canvas.getGraphicsContext2D();

        //czyszczenie calej planszy
        context.clearRect(0, 0, canvas.getWidth(), canvas.getHeight());
        context.setLineWidth(1);
        context.setStroke(Color.BLACK);
        context.strokeRect(0, 0, canvas.getWidth(), canvas.getHeight());

        for (Shape shape : shapeList) {
            shape.draw(context);
        }

        if (currentShape != null) {
            currentShape.draw(context);
        }
    }

    @FXML
    public void handleRectangleButton() {
        currentTool = Tool.RECTANGLE;
    }

    @FXML
    public void handleTriangleButton() {
        currentTool = Tool.TRIANGLE;
    }

    @FXML
    public void handleOvalButton() {
        currentTool = Tool.OVAL;
    }

    @FXML
    public void handleLineButton() {
        currentTool = Tool.LINE;
    }

    @FXML
    public void handleSquareButton() {
        currentTool = Tool.SQUARE;
    }

    @FXML
    public void handleStarButton() {
        currentTool = Tool.STAR;
    }

    @FXML
    public void handleBrushButton() {
        currentTool = Tool.BRUSH;
    }

    @FXML
    public void handleExportToImage() {
        FileChooser fileChooser = new FileChooser();
        fileChooser.getExtensionFilters()
                .add(new FileChooser.ExtensionFilter("png files (*.png)", "*.png"));

        File file = fileChooser.showSaveDialog(primaryStage);
        if (file != null) {
            try {
                WritableImage writableImage = new WritableImage((int) canvas.getWidth(),
                        (int) canvas.getHeight());
                canvas.snapshot(null, writableImage);
                RenderedImage renderedImage = SwingFXUtils.fromFXImage(writableImage, null);
                ImageIO.write(renderedImage, "png", file);
            } catch (IOException ex) {
                ex.printStackTrace();
            }
        }
    }

    @FXML
    public void handleSave() {
        Optional<String> output = shapeList.stream()
                .map(Shape::convertToText)
                .reduce((acc, obj) -> acc + "\n" + obj);
        if (output.isPresent()) {
            System.out.println(output.get());
            saveList(output.get());
        } else {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Nope!");
            alert.setContentText("No data to save");
            alert.showAndWait();
        }
    }

    private void saveList(String data) {
        FileChooser fileChooser = getFileChooser();

        File file = fileChooser.showSaveDialog(PaintJavaFx.primaryStage);
        if (file != null) {
            saveTextToFile(data, file);
        }
    }

    private FileChooser getFileChooser() {
        FileChooser fileChooser = new FileChooser();
        FileChooser.ExtensionFilter extFilter =
                new FileChooser.ExtensionFilter("YOLO image (*.yolo)", "*.yolo");
        fileChooser.getExtensionFilters().add(extFilter);
        return fileChooser;
    }

    private void saveTextToFile(String content, File file) {
        try {
            PrintWriter writer;
            writer = new PrintWriter(file);
            writer.println(content);
            writer.close();
        } catch (IOException ex) {
            ex.printStackTrace();
            //todo error alert dialog
        }
    }

    @FXML
    public void handleLoad() {
        FileChooser fileChooser = getFileChooser();

        File file = fileChooser.showOpenDialog(PaintJavaFx.primaryStage);
        if (file != null) {
            readData(file);
        }
    }

    private void readData(File file) {
        try {
            FileReader reader = new FileReader(file);
            BufferedReader bufferedReader = new BufferedReader(reader);
            List<Shape> newData = bufferedReader.lines()
                    .filter(s -> s != null)
                    .map(text -> ShapeFactory.make(text))
                    .filter(s -> s != null)
                    .collect(Collectors.toList());

            shapeList.clear();
            shapeList.addAll(newData);
            refreshCanvas();
        } catch (Exception e) {
            e.printStackTrace();
            //todo alert
        }
    }

    @FXML
    public void handleClear() {
        shapeList.clear();
        refreshCanvas();
    }

    @FXML
    public void handleUndo() {
        if (!shapeList.isEmpty()) {
            shapeList.remove(shapeList.size() - 1);
        }
        refreshCanvas();
    }

}
