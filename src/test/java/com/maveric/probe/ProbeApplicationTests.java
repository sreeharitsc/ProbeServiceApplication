package com.maveric.probe;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.Collections;
import java.util.HashSet;

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
        Grid grid = new Grid(5, 5, Collections.unmodifiableSet(new HashSet<Position>()));
        ProbeService probe = new ProbeService(grid, new Position(1, 2), Direction.NORTH);
        assertEquals(new Position(1, 2), probe.getCurrentPosition());
        assertEquals(Direction.NORTH, probe.getDirection());
    }

}
