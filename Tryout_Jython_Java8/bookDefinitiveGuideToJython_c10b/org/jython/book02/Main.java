package org.jython.book02;

import org.jython.book02.interfaces.BuildingType;
import org.jython.book02.util.JythonObjectFactory;

public class Main {

    public static void main(String[] args) {

        JythonObjectFactory factory = JythonObjectFactory.getInstance();

        BuildingType building = (BuildingType) factory.createObject(
                BuildingType.class, "Building");
        building.setBuildingName("BUIDING-A");
        building.setBuildingAddress("100 MAIN ST.");
        building.setBuildingId(1);
        System.out.println(building.getBuildingId() + " " + building.getBuildingName() + " " +
                building.getBuildingAddress());

    }

}
