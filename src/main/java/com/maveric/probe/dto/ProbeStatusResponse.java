/**
 * 
 */
package com.maveric.probe.dto;

import java.util.List;

import com.maveric.probe.model.Direction;
import com.maveric.probe.model.Position;

/**
 * @author sreehari
 *	Class used to represent ProbeStatusResponse 
 */
public class ProbeStatusResponse {

	public Position currentPosition;
    public Direction direction;
    public List<Position> visitedPath;

    public ProbeStatusResponse(Position currentPosition, Direction direction, List<Position> visitedPath) {
        this.currentPosition = currentPosition;
        this.direction = direction;
        this.visitedPath = visitedPath;
    }
}
