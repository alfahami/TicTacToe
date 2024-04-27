package model;

public class Car {

    private String make;
    private String model;
    private BodyType bodyType; // Should this really be a String?
    private int productionYear;
    private double price;

    public enum BodyType {
        SEDAN, COUPE, HATCHBACK, SUV, TRUCK, VAN
    }
    public static final int MIN_PROD_YEAR = 1900;
    public static final double MAX_PRICE = 200000;
    public static final double MIN_PRICE = 0;

    public Car(String make, String model, BodyType bodyType, int productionYear, double price) {
        setMake(make);
        setModel(model);
        setBodyType(bodyType);
        setProductionYear(productionYear);
        setPrice(price);
    }

    public Car(Car source) {
        setMake(source.make);
        setModel(source.model);
        setBodyType(source.bodyType);
        setProductionYear(source.productionYear);
        setPrice(source.price);
    }

    public String getMake() {
        return this.make;
    }

    public void setMake(String make) {
        if(make == null || make.isBlank()) throw new IllegalArgumentException("Make cannot be null or blank");
        this.make = make;
    }

    public String getModel() {
        return this.model;
    }

    public void setModel(String model) {
        if(model == null || model.isBlank()) throw new IllegalArgumentException("Model cannot be null or blank");
        this.model = model;
    }

    public int getProductionYear() {
        return this.productionYear;
    }

    public void setProductionYear(int productionYear) {
        if(productionYear <= MIN_PROD_YEAR) throw new IllegalArgumentException("Production year must be greater or equal to the minimum year");
        this.productionYear = productionYear;
    }

    public double getPrice() {
        return this.price;
    }

    public void setPrice(double price) {
        if(price <= MIN_PRICE || price > MAX_PRICE) throw new IllegalArgumentException("Price must be within a valid range");
        this.price = price;
    }

    public void setBodyType(BodyType bodyType) {
        if(bodyType == null) throw new IllegalArgumentException("Body type cannot be null");
        this.bodyType = bodyType;
    }

    public BodyType getBodyType() {
        return this.bodyType;
    }

}