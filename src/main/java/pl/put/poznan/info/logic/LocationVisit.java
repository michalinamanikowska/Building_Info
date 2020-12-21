package pl.put.poznan.info.logic;

interface LocationVisitor {
    int visit(Location location);
}

public class LocationVisit implements LocationVisitor {
    @Override
    public int visit (Location location) {
        System.out.println("Location " + location.getName());
        if (location instanceof Room) {
            System.out.println("Room area " + ((Room) location).getArea());
            System.out.println("return " + ((Room) location).getArea());
            return ((Room) location).getArea();
        }
        System.out.println("return 0");
        return 0;
    }
}
