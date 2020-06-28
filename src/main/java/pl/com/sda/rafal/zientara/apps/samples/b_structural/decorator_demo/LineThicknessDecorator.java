package pl.com.sda.rafal.zientara.apps.samples.b_structural.decorator_demo;

public class LineThicknessDecorator extends ShapeDecorator {
    protected double thickness;
    public LineThicknessDecorator(Shape decoratedShape, double thickness) {
        super(decoratedShape);
        this.thickness = thickness;
    }
    @Override
    public void draw() {
        decoratedShape.draw();
        System.out.println("Grubość linii: " + thickness);
    }
    // no change in the functionality
    @Override
    public void resize() {
        decoratedShape.resize();
    }
    @Override
    public String description() {
        return decoratedShape.description() + " z linią grubą na: " + thickness + ".";
    }
    // no change in the functionality
    @Override
    public boolean isHide() {
        return decoratedShape.isHide();
    }
}
