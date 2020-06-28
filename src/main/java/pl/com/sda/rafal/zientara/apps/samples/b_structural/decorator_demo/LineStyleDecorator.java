package pl.com.sda.rafal.zientara.apps.samples.b_structural.decorator_demo;

public class LineStyleDecorator extends ShapeDecorator {
    protected LineStyle style;
    public LineStyleDecorator(Shape decoratedShape, LineStyle style) {
        super(decoratedShape);
        this.style = style;
    }
    @Override
    public void draw() {
        decoratedShape.draw();
        System.out.println("Styl linii: " + style);
    }
    // no change in the functionality
    @Override
    public void resize() {
        decoratedShape.resize();
    }
    @Override
    public String description() {
        return decoratedShape.description() + " narysowany z użyciem " + style + " stylu linii.";
    }
    // no change in the functionality
    @Override
    public boolean isHide() {
        return decoratedShape.isHide();
    }
}
