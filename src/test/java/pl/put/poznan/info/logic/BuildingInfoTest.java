package pl.put.poznan.info.logic;

import org.json.JSONArray;
import org.json.JSONException;
import org.junit.jupiter.api.*;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class BuildingInfoTest {

    @Test
    void testCalculateTotalArea() throws JSONException {
        // create mock object for building
        MidLocation building = mock(MidLocation.class);

        // countTotalArea() method returns 20
        when(building.countTotalArea()).thenReturn(20);

        // interaction phase
        BuildingInfo informer = new BuildingInfo(building);

        // verification of the expected value with the method
        assertEquals("{\"area\":\"20\"}", informer.calculateTotalArea());
    }

    @Test
    void testCalculateAreaById() throws JSONException {
        // create mock object for building
        MidLocation building = mock(MidLocation.class);

        // countAreaById() method returns 100
        when(building.countAreaById("id")).thenReturn(100);
        when(building.countAreaById("id2")).thenReturn(237);

        // interaction phase
        BuildingInfo informer = new BuildingInfo(building);

        // verification of the expected value with the method
        assertEquals("{\"area\":\"100\"}",informer.calculateAreaById("id"));
        assertEquals("{\"area\":\"237\"}",informer.calculateAreaById("id2"));
    }

    @Test
    void testFindRoomsWithLimitedAreaLevel() throws JSONException {
        // create mock object for building
        MidLocation building = mock(MidLocation.class);

        // define return values for findRoomsWithLimitedAreaLevel() method
        when(building.findRoomsWithLimitedAreaLevel("10")).thenReturn(new JSONArray());
        when(building.findRoomsWithLimitedAreaLevel("100")).thenReturn(new JSONArray().put("room1Id").put("room3Id"));

        // interaction phase
        BuildingInfo informer = new BuildingInfo(building);

        // verification of the expected value with the method
        assertEquals("{\"rooms\":[]}",informer.findRoomsWithLimitedAreaLevel("10"));
        assertEquals("{\"rooms\":[\"room1Id\",\"room3Id\"]}",informer.findRoomsWithLimitedAreaLevel("100"));
    }

    @Test
    void testCalculateTotalCube() throws JSONException {
        // create mock object for building
        MidLocation building = mock(MidLocation.class);

        // countTotalCube() method returns 60
        when(building.countTotalCube()).thenReturn(60);

        // interaction phase
        BuildingInfo informer = new BuildingInfo(building);

        // verification of the expected value with the method
        assertEquals("{\"cube\":\"60\"}",informer.calculateTotalCube());
    }

    @Test
    void testCalculateCubeById() throws JSONException {
        // create mock object for building
        MidLocation building = mock(MidLocation.class);

        // define return values for countCubeById() method
        when(building.countCubeById("id")).thenReturn(0);
        when(building.countCubeById("id2")).thenReturn(80);

        // interaction phase
        BuildingInfo informer = new BuildingInfo(building);

        // verification of the expected value with the method
        assertEquals("{\"cube\":\"0\"}",informer.calculateCubeById("id"));
        assertEquals("{\"cube\":\"80\"}",informer.calculateCubeById("id2"));
    }

    @Test
    void testFindRoomsWithLimitedCubeLevel() throws JSONException {
        // create mock object for building
        MidLocation building = mock(MidLocation.class);

        // define return values for findRoomsWithLimitedCubeLevel() method
        when(building.findRoomsWithLimitedCubeLevel("30")).thenReturn(new JSONArray());
        when(building.findRoomsWithLimitedCubeLevel("120")).thenReturn(new JSONArray().put("room1Id").put("room4Id").put("room5Id"));

        // interaction phase
        BuildingInfo informer = new BuildingInfo(building);

        // verification of the expected value with the method
        assertEquals("{\"rooms\":[]}",informer.findRoomsWithLimitedCubeLevel("30"));
        assertEquals("{\"rooms\":[\"room1Id\",\"room4Id\",\"room5Id\"]}",informer.findRoomsWithLimitedCubeLevel("120"));
    }

    @Test
    void testCalculateTotalHeating() throws JSONException {
        // create mock object for building
        MidLocation building = mock(MidLocation.class);

        // define return values for countTotalHeating() and countTotalCube() methods
        when(building.countTotalHeating()).thenReturn((float)860);
        when(building.countTotalCube()).thenReturn(50);

        // interaction phase
        BuildingInfo informer = new BuildingInfo(building);

        // verification of the expected value with the method
        assertEquals("{\"heating\":\"17.2\"}",informer.calculateTotalHeating());
    }

    @Test
    void testCalculateHeatingById() throws JSONException {
        // create mock object for building
        MidLocation building = mock(MidLocation.class);

        // define return values for countHeatingById() and countCubeById() method
        when(building.countHeatingById("id")).thenReturn((float)186);
        when(building.countCubeById("id")).thenReturn(60);
        when(building.countHeatingById("id2")).thenReturn((float)4520);
        when(building.countCubeById("id2")).thenReturn(200);

        // interaction phase
        BuildingInfo informer = new BuildingInfo(building);

        // verification of the expected value with the method
        assertEquals("{\"heating\":\"3.1\"}",informer.calculateHeatingById("id"));
        assertEquals("{\"heating\":\"22.6\"}",informer.calculateHeatingById("id2"));
    }

    @Test
    void testFindRoomsWithExceededHeatingLevel() throws JSONException {
        // create mock object for building
        MidLocation building = mock(MidLocation.class);

        // define return values for findRoomsWithExceededHeatingLevel() method
        when(building.findRoomsWithExceededHeatingLevel("3.1")).thenReturn(new JSONArray().put("room2Id").put("room3Id").put("room4Id").put("room6Id"));
        when(building.findRoomsWithExceededHeatingLevel("12.5")).thenReturn(new JSONArray().put("room6Id"));

        // interaction phase
        BuildingInfo informer = new BuildingInfo(building);

        // verification of the expected value with the method
        assertEquals("{\"rooms\":[\"room2Id\",\"room3Id\",\"room4Id\",\"room6Id\"]}",informer.findRoomsWithExceededHeatingLevel("3.1"));
        assertEquals("{\"rooms\":[\"room6Id\"]}",informer.findRoomsWithExceededHeatingLevel("12.5"));
    }

    @Test
    void testFindRoomsWithLimitedHeatingLevel() throws JSONException {
        // create mock object for building
        MidLocation building = mock(MidLocation.class);

        // define return values for findRoomsWithLimitedHeatingLevel() method
        when(building.findRoomsWithLimitedHeatingLevel("3.1")).thenReturn(new JSONArray());
        when(building.findRoomsWithLimitedHeatingLevel("12.5")).thenReturn(new JSONArray().put("room1Id").put("room2Id").put("room3Id"));

        // interaction phase
        BuildingInfo informer = new BuildingInfo(building);

        // verification of the expected value with the method
        assertEquals("{\"rooms\":[]}",informer.findRoomsWithLimitedHeatingLevel("3.1"));
        assertEquals("{\"rooms\":[\"room1Id\",\"room2Id\",\"room3Id\"]}",informer.findRoomsWithLimitedHeatingLevel("12.5"));
    }

    @Test
    void testCalculateTotalLight() throws JSONException {
        // create mock object for building
        MidLocation building = mock(MidLocation.class);

        // define return values for countTotalLight() and countTotalArea() methods
        when(building.countTotalLight()).thenReturn(520);
        when(building.countTotalArea()).thenReturn(20);

        // interaction phase
        BuildingInfo informer = new BuildingInfo(building);

        // verification of the expected value with the method
        assertEquals("{\"light\":\"26\"}",informer.calculateTotalLight());
    }

    @Test
    void testCalculateLightById() throws JSONException {
        // create mock object for building
        MidLocation building = mock(MidLocation.class);

        // define return values for countLightById() and countAreaById() methods
        when(building.countLightById("id")).thenReturn(810);
        when(building.countAreaById("id")).thenReturn(30);

        // interaction phase
        BuildingInfo informer = new BuildingInfo(building);

        // verification of the expected value with the method
        assertEquals("{\"light\":\"27\"}",informer.calculateLightById("id"));
    }

    @Test
    void testFindRoomsWithLimitedLightLevel() throws JSONException {
        // create mock object for building
        MidLocation building = mock(MidLocation.class);

        // define return values for findRoomsWithLimitedLightLevel() method
        when(building.findRoomsWithLimitedLightLevel("50")).thenReturn(new JSONArray().put("room1Id"));
        when(building.findRoomsWithLimitedLightLevel("810")).thenReturn(new JSONArray().put("room1Id").put("room2Id").put("room3Id"));

        // interaction phase
        BuildingInfo informer = new BuildingInfo(building);

        // verification of the expected value with the method
        assertEquals("{\"rooms\":[\"room1Id\"]}",informer.findRoomsWithLimitedLightLevel("50"));
        assertEquals("{\"rooms\":[\"room1Id\",\"room2Id\",\"room3Id\"]}",informer.findRoomsWithLimitedLightLevel("810"));
    }
}