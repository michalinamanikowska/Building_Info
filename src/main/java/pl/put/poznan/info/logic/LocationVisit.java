package pl.put.poznan.info.logic;

interface LevelVisitor {
    void visit(MidLocation midLocation);
}

public class MidLocationVisit implements LevelVisitor {
    @Override
    public void visit(MidLocation midLocation) {
        System.out.println("Moving my body 2 " + midLocation.getName());
    }
}
