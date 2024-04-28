package shape;

import static java.lang.Math.*;

public class Sphere extends Shape {

    public Sphere(double radius) {
        super(radius);
    }

    @Override
    public double getArea() {
        return 4 * PI * pow(this.getRadius(), 2); 
    }

    @Override
    public double getVolume() {
        return (4 / 3) * PI * pow(this.getRadius(), 2);
    }

}