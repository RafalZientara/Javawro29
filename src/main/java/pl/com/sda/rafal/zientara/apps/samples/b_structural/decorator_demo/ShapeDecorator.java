package pl.com.sda.rafal.zientara.apps.samples.b_structural.decorator_demo;

public abstract class ShapeDecorator implements Shape {
    protected Shape decoratedShape;
    public ShapeDecorator(Shape decoratedShape) {
        super();
        this.decoratedShape = decoratedShape;
    }
}
