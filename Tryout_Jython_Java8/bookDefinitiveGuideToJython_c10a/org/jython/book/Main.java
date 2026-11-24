package org.jython.book;

import org.jython.book.util.BuildingFactory;
import org.jython.book.interfaces.BuildingType;

public class Main {

    private static void print(BuildingType building) {
        System.out.println("Building Info: " +
                building.getBuildingId() + " " +
                building.getBuildingName() + " " +
                building.getBuildingAddress());

    }

    public static void main(String[] args) {
        BuildingFactory factory = new BuildingFactory();
        print(factory.create("BUILDING-A", "100 WEST MAIN", "1"));
        print(factory.create("BUILDING-B", "110 WEST MAIN", "2"));
        print(factory.create("BUILDING-C", "120 WEST MAIN", "3"));
    }
}
