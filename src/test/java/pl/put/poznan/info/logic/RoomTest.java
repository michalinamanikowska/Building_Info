package pl.put.poznan.info.logic;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class RoomTest {
    private Room room = null;

    @BeforeEach
    void setUp() {
        room = new Room("roomId","roomName",20,80, (float)15.4,520);
    }

    @Test
    void testCountTotalArea() {
        assertEquals(20,room.countTotalArea());
    }

    @Test
    void testCountAreaById() {
        assertEquals(20,room.countAreaById(room.getId()));
        assertEquals(0,room.countAreaById("roomId2"));
    }

    @Test
    void testFindRoomsWithLimitedAreaLevel() {
        assertEquals("",room.findRoomsWithLimitedAreaLevel(String.valueOf(19)));
        assertEquals("roomId",room.findRoomsWithLimitedAreaLevel(String.valueOf(20)));
        assertEquals("roomId",room.findRoomsWithLimitedAreaLevel(String.valueOf(21)));
    }

    @Test
    void testCountTotalCube() {
        assertEquals(80,room.countTotalCube());
    }

    @Test
    void testCountCubeById() {
        assertEquals(80,room.countCubeById(room.getId()));
        assertEquals(0,room.countCubeById("roomId2"));
    }

    @Test
    void testFindRoomsWithLimitedCubeLevel() {
        assertEquals("",room.findRoomsWithLimitedCubeLevel(String.valueOf(79)));
        assertEquals("roomId",room.findRoomsWithLimitedCubeLevel(String.valueOf(80)));
        assertEquals("roomId",room.findRoomsWithLimitedCubeLevel(String.valueOf(81)));
    }

    @Test
    void testCountTotalHeating() {
        assertEquals(1232,room.countTotalHeating());
    }

    @Test
    void testCountHeatingById() {
        assertEquals(1232,room.countHeatingById(room.getId()));
        assertEquals(0,room.countHeatingById("roomId2"));
    }

    @Test
    void testFindRoomsWithExceededHeatingLevel() {
        assertEquals("roomId",room.findRoomsWithExceededHeatingLevel(String.valueOf(15.3)));
        assertEquals("",room.findRoomsWithExceededHeatingLevel(String.valueOf(15.4)));
        assertEquals("",room.findRoomsWithExceededHeatingLevel(String.valueOf(15.5)));
    }

    @Test
    void testFindRoomsWithLimitedHeatingLevel() {
        assertEquals("",room.findRoomsWithLimitedHeatingLevel(String.valueOf(15.3)));
        assertEquals("roomId",room.findRoomsWithLimitedHeatingLevel(String.valueOf(15.4)));
        assertEquals("roomId",room.findRoomsWithLimitedHeatingLevel(String.valueOf(15.5)));
    }

    @Test
    void testCountTotalLight() {
        assertEquals(520,room.countTotalLight());
    }

    @Test
    void testCountLightById() {
        assertEquals(520,room.countLightById(room.getId()));
        assertEquals(0,room.countLightById("roomId2"));
    }

    @Test
    void testFindRoomsWithLimitedLightLevel() {
        assertEquals("",room.findRoomsWithLimitedLightLevel(String.valueOf(519)));
        assertEquals("roomId",room.findRoomsWithLimitedLightLevel(String.valueOf(520)));
        assertEquals("roomId",room.findRoomsWithLimitedLightLevel(String.valueOf(521)));
    }
}