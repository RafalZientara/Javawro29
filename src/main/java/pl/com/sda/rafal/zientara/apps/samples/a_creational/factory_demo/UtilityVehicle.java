package pl.com.sda.rafal.zientara.apps.samples.a_creational.factory_demo;

public class UtilityVehicle extends Car {

    private String type;
    private String engine;
    private String bodyType;
    private String brand;

    public UtilityVehicle(String engine, String bodyType, String brand) {
        this.type = this.getClass().getSimpleName();
        this.engine = engine;
        this.bodyType = bodyType;
        this.brand = brand;
    }

    @Override
    public String getType() { return this.type; }

    @Override
    public String getEngine() {
        return this.engine;
    }

    @Override
    public String getBodyType() {
        return this.bodyType;
    }

    @Override
    public String getBrand() {
        return this.brand;
    }
}
