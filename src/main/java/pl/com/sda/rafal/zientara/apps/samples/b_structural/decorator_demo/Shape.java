package pl.com.sda.rafal.zientara.apps.samples.b_structural.decorator_demo;

//ctrl + alt + B = wszystkie klasy implementujące dany interfej
public interface Shape {
    void draw();
    void resize();
    String description();
    boolean isHide();
}
