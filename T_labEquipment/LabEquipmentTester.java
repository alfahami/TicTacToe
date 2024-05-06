import model.Centrifuge;
import model.Microscope;

public class LabEquipmentTester {
    public static void main(String[] args) {
        Microscope microscope1 = new Microscope("Nikon", "E200", 2021, 1000);
        Centrifuge centrifuge1 = new Centrifuge("Eppendorf", "5424R", 2020, 15000);
    
    
        // Test the copy constructors
        Microscope microscopeCopy = new Microscope(microscope1);
        Centrifuge centrifugeCopy = new Centrifuge(centrifuge1);
    
    
        System.out.println("Original Microscope: " + microscope1.getManufacturer() + " " + microscope1.getModel());
        System.out.println("Copied Microscope: " + microscopeCopy.getManufacturer() + " " + microscopeCopy.getModel());
        
        System.out.println("Original Centrifuge: " + centrifuge1.getManufacturer() + " " + centrifuge1.getModel());
        System.out.println("Copied Centrifuge: " + centrifugeCopy.getManufacturer() + " " + centrifugeCopy.getModel());
    }
}