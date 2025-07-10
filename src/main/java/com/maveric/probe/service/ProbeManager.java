/**
 * 
 */
package com.maveric.probe.service;

import com.maveric.probe.model.Direction;
import com.maveric.probe.model.Grid;
import com.maveric.probe.model.Position;

/**
 * @author sreehari
 *	Class used to Create a Singleton Wrapper to simulate in-memory storage of 1 probe
 */
public class ProbeManager {

	private static ProbeService instance;

    public static void initialize(Grid grid, Position start, Direction direction) {
        instance = new ProbeService(grid, start, direction);
    }

    public static ProbeService getInstance() {
        if (instance == null) {
            throw new IllegalStateException("Probe not initialized");
        }
        return instance;
    }
}
