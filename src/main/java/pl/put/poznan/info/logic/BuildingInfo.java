package pl.put.poznan.info.logic;

public interface BuildingInfo {
    public void readJSON(String info);
    public String calculateBuilding();
    public String calculateLevel(String id);
    public String calculateRoom(String id);
}
