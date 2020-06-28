package pl.com.sda.rafal.zientara.apps.samples.b_structural.decorator_demo;

public class FillColorDecorator extends ShapeDecorator {
    protected Color color;
    public FillColorDecorator(Shape decoratedShape, Color color) {
        super(decoratedShape);
        this.color = color;
    }
    @Override
    public void draw() {
        decoratedShape.draw();
        System.out.println("Wypełnienie: " + color);
    }
    // żadnych zmian funkcjonalnych
    @Override
    public void resize() {
        decoratedShape.resize();
    }
    @Override
    public String description() {
        return decoratedShape.description() + " wypełniony " + color + " kolorem.";
    }
    // no change in the functionality
    @Override
    public boolean isHide() {
        return decoratedShape.isHide();
    }
}
