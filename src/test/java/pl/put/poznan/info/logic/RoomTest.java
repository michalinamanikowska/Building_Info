package pl.put.poznan.info.logic;

import org.json.JSONArray;
import org.json.JSONException;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.skyscreamer.jsonassert.JSONAssert;

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
    void testFindRoomsWithLimitedAreaLevel() throws JSONException {
        JSONAssert.assertEquals(new JSONArray(),room.findRoomsWithLimitedAreaLevel(String.valueOf(19)),true);
        JSONAssert.assertEquals(new JSONArray("[{\"id\":\"roomId\"}]"),room.findRoomsWithLimitedAreaLevel(String.valueOf(20)),true);
        JSONAssert.assertEquals(new JSONArray("[{\"id\":\"roomId\"}]"),room.findRoomsWithLimitedAreaLevel(String.valueOf(21)),true);
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
    void testFindRoomsWithLimitedCubeLevel() throws JSONException {
        JSONAssert.assertEquals(new JSONArray(),room.findRoomsWithLimitedCubeLevel(String.valueOf(79)),true);
        JSONAssert.assertEquals(new JSONArray("[{\"id\":\"roomId\"}]"),room.findRoomsWithLimitedCubeLevel(String.valueOf(80)),true);
        JSONAssert.assertEquals(new JSONArray("[{\"id\":\"roomId\"}]"),room.findRoomsWithLimitedCubeLevel(String.valueOf(81)),true);
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
    void testFindRoomsWithExceededHeatingLevel() throws JSONException {
        JSONAssert.assertEquals(new JSONArray("[{\"id\":\"roomId\"}]"),room.findRoomsWithExceededHeatingLevel(String.valueOf(15.3)),true);
        JSONAssert.assertEquals(new JSONArray(),room.findRoomsWithExceededHeatingLevel(String.valueOf(15.4)),true);
        JSONAssert.assertEquals(new JSONArray(),room.findRoomsWithExceededHeatingLevel(String.valueOf(15.5)),true);
    }

    @Test
    void testFindRoomsWithLimitedHeatingLevel() throws JSONException {
        JSONAssert.assertEquals(new JSONArray(),room.findRoomsWithLimitedHeatingLevel(String.valueOf(15.3)),true);
        JSONAssert.assertEquals(new JSONArray("[{\"id\":\"roomId\"}]"),room.findRoomsWithLimitedHeatingLevel(String.valueOf(15.4)),true);
        JSONAssert.assertEquals(new JSONArray("[{\"id\":\"roomId\"}]"),room.findRoomsWithLimitedHeatingLevel(String.valueOf(15.5)),true);
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
    void testFindRoomsWithLimitedLightLevel() throws JSONException {
        JSONAssert.assertEquals(new JSONArray(),room.findRoomsWithLimitedLightLevel(String.valueOf(25)),true);
        JSONAssert.assertEquals(new JSONArray("[{\"id\":\"roomId\"}]"),room.findRoomsWithLimitedLightLevel(String.valueOf(26)),true);
        JSONAssert.assertEquals(new JSONArray("[{\"id\":\"roomId\"}]"),room.findRoomsWithLimitedLightLevel(String.valueOf(27)),true);
    }
}