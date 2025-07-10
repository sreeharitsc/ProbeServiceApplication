package com.maveric.probe;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import com.maveric.probe.model.Direction;
import com.maveric.probe.model.Grid;
import com.maveric.probe.model.Position;
import com.maveric.probe.service.ProbeService;

@SpringBootTest
class ProbeApplicationTests {

	@Test
    void testInitialPosition() {
        Grid grid = new Grid(5, 5, new HashSet<Position>());//Collections.unmodifiableSet(new HashSet<Position>()));
        ProbeService probe = new ProbeService(grid, new Position(1, 2), Direction.NORTH);
        assertEquals(new Position(1, 2), probe.getCurrentPosition());
        assertEquals(Direction.NORTH, probe.getDirection());
    }

	@Test
    void testMoveForward() {
        Grid grid = new Grid(5, 5, new HashSet<Position>());//Collections.unmodifiableSet(new HashSet<Position>()));
        ProbeService probe = new ProbeService(grid, new Position(0, 1), Direction.NORTH);
        probe.move("F");
        assertEquals(new Position(0, 1), probe.getCurrentPosition());
    }
	
	@Test
    void testTurnRight() {
        Grid grid = new Grid(5, 5, new HashSet<Position>());//Collections.unmodifiableSet(new HashSet<Position>()));
        ProbeService probe = new ProbeService(grid, new Position(0, 0), Direction.NORTH);
        probe.move("R");
        assertEquals(Direction.EAST, probe.getDirection());
    }
	
	@Test
    void testMoveBackward() {
        Grid grid = new Grid(5, 5, new HashSet<Position>());//Collections.unmodifiableSet(new HashSet<Position>()));
        ProbeService probe = new ProbeService(grid, new Position(1, 1), Direction.NORTH);
        probe.move("B");
        assertEquals(new Position(1, 0), probe.getCurrentPosition());
    }
	
	@Test
    void testAvoidObstacle() {
        Grid grid = new Grid(5, 5, new HashSet<Position>(1,2));//Collections.unmodifiableSet(new HashSet<Position>(1,2)));
        ProbeService probe = new ProbeService(grid, new Position(1, 1), Direction.NORTH);
        probe.move("F");
        assertEquals(new Position(1, 1), probe.getCurrentPosition());
    }

	@Test
    void testStayOnGrid() {
        Grid grid = new Grid(2, 2, new HashSet<Position>());//Collections.unmodifiableSet(new HashSet<Position>()));
        ProbeService probe = new ProbeService(grid, new Position(0, 0), Direction.SOUTH);
        probe.move("F");
        assertEquals(new Position(0, 1), probe.getCurrentPosition());
    }
	
	@Test
    void testVisitedPathSummary() {
        Grid grid = new Grid(5, 5, new HashSet<Position>());//Collections.unmodifiableSet(new HashSet<Position>()));
        ProbeService probe = new ProbeService(grid, new Position(0, 0), Direction.NORTH);
        probe.moveSequence("FFRFF");
        List<Position> path = probe.getVisitedPath();
        List<Position> posList = Arrays.asList(new Position(0, 0),
            new Position(0, 1),
            new Position(0, 0),
            new Position(0, 1),
            new Position(0, 0),
            new Position(1, 0),
            new Position(0, 0),
            new Position(1, 0),
            new Position(0, 0));
        assertEquals(posList, path);
    }
}
