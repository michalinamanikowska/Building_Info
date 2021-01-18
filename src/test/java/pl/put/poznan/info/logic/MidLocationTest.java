package pl.put.poznan.info.logic;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MidLocationTest {
    private MidLocation midLocation = null;

    @BeforeEach
    void setUp() {
        Room room1 = new Room("room1Id","room1Name",5,20, (float)15.4,90);
        Room room2 = new Room("room2Id","room2Name",10,50, (float)17.2,250);
        Room room3 = new Room("room3Id","room3Name",20,60, (float)3.1,520);
        Room room4 = new Room("room4Id","room4Name",30,120, (float)8.0,810);
        Room room5 = new Room("room5Id","room5Name",40,200, (float)22.6,1001);

        MidLocation level1 = new MidLocation("level1Id","level1Name");
        level1.addLocation(room1);
        level1.addLocation(room2);
        level1.addLocation(room3);
        
        MidLocation level2 = new MidLocation("level2Id","level2Name");
        level2.addLocation(room4);
        level2.addLocation(room5);

        midLocation = new MidLocation("buildingId","buildingName");
        midLocation.addLocation(level1);
        midLocation.addLocation(level2);
    }

    @Test
    void testCountTotalArea() {
        assertEquals(105,midLocation.countTotalArea());
    }

    @Test
    void testCountAreaById() {
        assertEquals(5,midLocation.countAreaById("room1Id"));
        assertEquals(30,midLocation.countAreaById("room4Id"));
        assertEquals(35,midLocation.countAreaById("level1Id"));
        assertEquals(70,midLocation.countAreaById("level2Id"));
    }

    @Test
    void testFindRoomsWithLimitedAreaLevel() {
        assertEquals("",midLocation.findRoomsWithLimitedAreaLevel(String.valueOf(1)));
        assertEquals("room1Id",midLocation.findRoomsWithLimitedAreaLevel(String.valueOf(5)));
        assertEquals("room1Id,room2Id,room3Id",midLocation.findRoomsWithLimitedAreaLevel(String.valueOf(25)));
        assertEquals("room1Id,room2Id,room3Id,room4Id,room5Id",midLocation.findRoomsWithLimitedAreaLevel(String.valueOf(41)));
    }

    @Test
    void testCountTotalCube() {
        assertEquals(450,midLocation.countTotalCube());
    }

    @Test
    void testCountCubeById() {
        assertEquals(50,midLocation.countCubeById("room2Id"));
        assertEquals(200,midLocation.countCubeById("room5Id"));
        assertEquals(130,midLocation.countCubeById("level1Id"));
        assertEquals(320,midLocation.countCubeById("level2Id"));
    }

    @Test
    void testFindRoomsWithLimitedCubeLevel() {
        assertEquals("",midLocation.findRoomsWithLimitedCubeLevel(String.valueOf(19)));
        assertEquals("room1Id",midLocation.findRoomsWithLimitedCubeLevel(String.valueOf(20)));
        assertEquals("room1Id,room2Id,room3Id,room4Id",midLocation.findRoomsWithLimitedCubeLevel(String.valueOf(130)));
        assertEquals("room1Id,room2Id,room3Id,room4Id,room5Id",midLocation.findRoomsWithLimitedCubeLevel(String.valueOf(1000)));
    }

    @Test
    void testCountTotalHeating() {
        assertEquals(6834,midLocation.countTotalHeating());
    }

    @Test
    void testCountHeatingById() {
        assertEquals(186,midLocation.countHeatingById("room3Id"));
        assertEquals(960,midLocation.countHeatingById("room4Id"));
        assertEquals(1354,midLocation.countHeatingById("level1Id"));
        assertEquals(5480,midLocation.countHeatingById("level2Id"));
    }

    @Test
    void testFindRoomsWithExceededHeatingLevel() {
        assertEquals("room1Id,room2Id,room3Id,room4Id,room5Id",midLocation.findRoomsWithExceededHeatingLevel(String.valueOf(1)));
        assertEquals("room1Id,room2Id,room4Id,room5Id",midLocation.findRoomsWithExceededHeatingLevel(String.valueOf(3.1)));
        assertEquals("room5Id",midLocation.findRoomsWithExceededHeatingLevel(String.valueOf(22.5)));
        assertEquals("",midLocation.findRoomsWithExceededHeatingLevel(String.valueOf(22.6)));
    }

    @Test
    void testFindRoomsWithLimitedHeatingLevel() {
        assertEquals("",midLocation.findRoomsWithLimitedHeatingLevel(String.valueOf(3)));
        assertEquals("room3Id",midLocation.findRoomsWithLimitedHeatingLevel(String.valueOf(3.1)));
        assertEquals("room1Id,room2Id,room3Id,room4Id",midLocation.findRoomsWithLimitedHeatingLevel(String.valueOf(17.2)));
    }

    @Test
    void testCountTotalLight() {
        assertEquals(2671,midLocation.countTotalLight());
    }

    @Test
    void testCountLightById() {
        assertEquals(90,midLocation.countLightById("room1Id"));
        assertEquals(1001,midLocation.countLightById("room5Id"));
        assertEquals(860,midLocation.countLightById("level1Id"));
        assertEquals(1811,midLocation.countLightById("level2Id"));
    }

    @Test
    void testFindRoomsWithLimitedLightLevel() {
        assertEquals("",midLocation.findRoomsWithLimitedLightLevel(String.valueOf(89)));
        assertEquals("room1Id,room2Id",midLocation.findRoomsWithLimitedLightLevel(String.valueOf(250)));
        assertEquals("room1Id,room2Id,room3Id,room4Id",midLocation.findRoomsWithLimitedLightLevel(String.valueOf(1000)));
        assertEquals("room1Id,room2Id,room3Id,room4Id,room5Id",midLocation.findRoomsWithLimitedLightLevel(String.valueOf(2000)));
    }
}