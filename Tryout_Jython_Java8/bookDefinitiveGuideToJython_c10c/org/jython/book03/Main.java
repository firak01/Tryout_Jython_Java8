package org.jython.book03;


import org.jython.book03.util.JythonObjectFactory;
import org.jython.book03.interfaces.BuildingType;

public class Main {

    private static void print(BuildingType building) {
        System.out.println("Building Info: " +
                building.getBuildingId() + " " +
                building.getBuildingName() + " " +
                building.getBuildingAddress());

    }

    public static void main(String[] args) {
        JythonObjectFactory factory = new JythonObjectFactory(BuildingType.class, "building", "Building");
       
        BuildingType building = (BuildingType) factory.createObject();

        building.setBuildingName("BUIDING-A");
        building.setBuildingAddress("100 MAIN ST.");
        building.setBuildingId(1);

        System.out.println(building.getBuildingId() + " " + building.getBuildingName() + " " +
                building.getBuildingAddress());
    }
}
