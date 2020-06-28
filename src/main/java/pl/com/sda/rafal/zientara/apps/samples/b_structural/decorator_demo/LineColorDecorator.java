package pl.com.sda.rafal.zientara.apps.samples.b_structural.decorator_demo;

public class LineColorDecorator extends ShapeDecorator {
    protected Color color;
    public LineColorDecorator(Shape decoratedShape, Color color) {
        super(decoratedShape);
        this.color = color;
    }
    @Override
    public void draw() {
        decoratedShape.draw();
        System.out.println("Kolor linii: " + color);
    }
    // no change in the functionality
    @Override
    public void resize() {
        decoratedShape.resize();
    }
    @Override
    public String description() {
        return decoratedShape.description() + " narysowane w " + color + " kolorze.";
    }
    // no change in the functionality
    @Override
    public boolean isHide() {
        return decoratedShape.isHide();
    }
}
