package pl.put.poznan.info.logic;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class BuildingInfoTest {

    @Test
    void testCalculateTotalArea() {
        // create mock object for building
        MidLocation building = mock(MidLocation.class);

        // countTotalArea() method returns 20
        when(building.countTotalArea()).thenReturn(20);

        // interaction phase
        BuildingInfo informer = new BuildingInfo(building);

        // verification of the expected value with the method
        assertEquals("20",informer.calculateTotalArea());
    }

    @Test
    void testCalculateAreaById() {
        // create mock object for building
        MidLocation building = mock(MidLocation.class);

        // countAreaById() method returns 100
        when(building.countAreaById("id")).thenReturn(100);
        when(building.countAreaById("id2")).thenReturn(237);

        // interaction phase
        BuildingInfo informer = new BuildingInfo(building);

        // verification of the expected value with the method
        assertEquals("100",informer.calculateAreaById("id"));
        assertEquals("237",informer.calculateAreaById("id2"));
    }

    @Test
    void testFindRoomsWithLimitedAreaLevel() {
        // create mock object for building
        MidLocation building = mock(MidLocation.class);

        // define return values for findRoomsWithLimitedAreaLevel() method
        when(building.findRoomsWithLimitedAreaLevel("10")).thenReturn("");
        when(building.findRoomsWithLimitedAreaLevel("100")).thenReturn("room1Id,room3Id");

        // interaction phase
        BuildingInfo informer = new BuildingInfo(building);

        // verification of the expected value with the method
        assertEquals("",informer.findRoomsWithLimitedAreaLevel("10"));
        assertEquals("room1Id,room3Id",informer.findRoomsWithLimitedAreaLevel("100"));
    }

    @Test
    void testCalculateTotalCube() {
        // create mock object for building
        MidLocation building = mock(MidLocation.class);

        // countTotalCube() method returns 60
        when(building.countTotalCube()).thenReturn(60);

        // interaction phase
        BuildingInfo informer = new BuildingInfo(building);

        // verification of the expected value with the method
        assertEquals("60",informer.calculateTotalCube());
    }

    @Test
    void testCalculateCubeById() {
        // create mock object for building
        MidLocation building = mock(MidLocation.class);

        // define return values for countCubeById() method
        when(building.countCubeById("id")).thenReturn(0);
        when(building.countCubeById("id2")).thenReturn(80);

        // interaction phase
        BuildingInfo informer = new BuildingInfo(building);

        // verification of the expected value with the method
        assertEquals("0",informer.calculateCubeById("id"));
        assertEquals("80",informer.calculateCubeById("id2"));
    }

    @Test
    void testFindRoomsWithLimitedCubeLevel() {
        // create mock object for building
        MidLocation building = mock(MidLocation.class);

        // define return values for findRoomsWithLimitedCubeLevel() method
        when(building.findRoomsWithLimitedCubeLevel("30")).thenReturn("");
        when(building.findRoomsWithLimitedCubeLevel("120")).thenReturn("room1Id,room4Id,room5Id");

        // interaction phase
        BuildingInfo informer = new BuildingInfo(building);

        // verification of the expected value with the method
        assertEquals("",informer.findRoomsWithLimitedCubeLevel("30"));
        assertEquals("room1Id,room4Id,room5Id",informer.findRoomsWithLimitedCubeLevel("120"));
    }

    @Test
    void testCalculateTotalHeating() {
        // create mock object for building
        MidLocation building = mock(MidLocation.class);

        // define return values for countTotalHeating() and countTotalCube() methods
        when(building.countTotalHeating()).thenReturn((float)860);
        when(building.countTotalCube()).thenReturn(50);

        // interaction phase
        BuildingInfo informer = new BuildingInfo(building);

        // verification of the expected value with the method
        assertEquals("17.2",informer.calculateTotalHeating());
    }

    @Test
    void testCalculateHeatingById() {
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
        assertEquals("3.1",informer.calculateHeatingById("id"));
        assertEquals("22.6",informer.calculateHeatingById("id2"));
    }

    @Test
    void testFindRoomsWithExceededHeatingLevel() {
        // create mock object for building
        MidLocation building = mock(MidLocation.class);

        // define return values for findRoomsWithExceededHeatingLevel() method
        when(building.findRoomsWithExceededHeatingLevel("3.1")).thenReturn("room2Id,room3Id,room4Id,room6Id");
        when(building.findRoomsWithExceededHeatingLevel("12.5")).thenReturn("room6Id");

        // interaction phase
        BuildingInfo informer = new BuildingInfo(building);

        // verification of the expected value with the method
        assertEquals("room2Id,room3Id,room4Id,room6Id",informer.findRoomsWithExceededHeatingLevel("3.1"));
        assertEquals("room6Id",informer.findRoomsWithExceededHeatingLevel("12.5"));
    }

    @Test
    void testFindRoomsWithLimitedHeatingLevel() {
        // create mock object for building
        MidLocation building = mock(MidLocation.class);

        // define return values for findRoomsWithLimitedHeatingLevel() method
        when(building.findRoomsWithLimitedHeatingLevel("3.1")).thenReturn("");
        when(building.findRoomsWithLimitedHeatingLevel("12.5")).thenReturn("room1Id,room2Id,room3Id");

        // interaction phase
        BuildingInfo informer = new BuildingInfo(building);

        // verification of the expected value with the method
        assertEquals("",informer.findRoomsWithLimitedHeatingLevel("3.1"));
        assertEquals("room1Id,room2Id,room3Id",informer.findRoomsWithLimitedHeatingLevel("12.5"));
    }

    @Test
    void testCalculateTotalLight() {
        // create mock object for building
        MidLocation building = mock(MidLocation.class);

        // countTotalLight() method returns 60
        when(building.countTotalLight()).thenReturn(520);

        // interaction phase
        BuildingInfo informer = new BuildingInfo(building);

        // verification of the expected value with the method
        assertEquals("520",informer.calculateTotalLight());
    }

    @Test
    void testCalculateLightById() {
        // create mock object for building
        MidLocation building = mock(MidLocation.class);

        // define return values for countLightById() method
        when(building.countLightById("id")).thenReturn(0);
        when(building.countLightById("id2")).thenReturn(520);

        // interaction phase
        BuildingInfo informer = new BuildingInfo(building);

        // verification of the expected value with the method
        assertEquals("0",informer.calculateLightById("id"));
        assertEquals("520",informer.calculateLightById("id2"));
    }

    @Test
    void testFindRoomsWithLimitedLightLevel() {
        // create mock object for building
        MidLocation building = mock(MidLocation.class);

        // define return values for findRoomsWithLimitedLightLevel() method
        when(building.findRoomsWithLimitedLightLevel("50")).thenReturn("room1Id");
        when(building.findRoomsWithLimitedLightLevel("810")).thenReturn("room1Id,room2Id,room3Id");

        // interaction phase
        BuildingInfo informer = new BuildingInfo(building);

        // verification of the expected value with the method
        assertEquals("room1Id",informer.findRoomsWithLimitedLightLevel("50"));
        assertEquals("room1Id,room2Id,room3Id",informer.findRoomsWithLimitedLightLevel("810"));
    }
}