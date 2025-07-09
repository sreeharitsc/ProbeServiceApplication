/**
 * 
 */
package com.maveric.probe.service;

import java.util.ArrayList;
import java.util.List;

import com.maveric.probe.model.Direction;
import com.maveric.probe.model.Grid;
import com.maveric.probe.model.Position;

/**
 * @author sreehari
 *	Class used to represent ProbeService service class
 */
public class ProbeService {

	private Position currentPosition;
    private Direction direction;
    private final Grid grid;
    private final List<Position> visitedPath = new ArrayList<>();

    public ProbeService(Grid grid, Position startPosition, Direction direction) {
        this.grid = grid;
        this.currentPosition = startPosition;
        this.direction = direction;
        visitedPath.add(currentPosition);
    }

    public Position getCurrentPosition() {
        return currentPosition;
    }

    public Direction getDirection() {
        return direction;
    }

    public List<Position> getVisitedPath() {
        return visitedPath;
    }

    public void move(String command) {
        switch (command) {
            case "F": tryMove(direction);
            case "B": tryMove(backwardDirection());
            case "L": direction = direction.turnLeft();
            case "R": direction = direction.turnRight();
        }
    }

    public void moveSequence(String sequence) {
        for (char cmd : sequence.toCharArray()) {
            move(String.valueOf(cmd));
        }
    }

    private void tryMove(Direction moveDirection) {
        Position newPosition = currentPosition.move(moveDirection.deltaX(), moveDirection.deltaY());

        if (grid.isWithinBounds(newPosition) && !grid.isObstacle(newPosition)) {
            currentPosition = newPosition;
            visitedPath.add(currentPosition);
        }
    }

    private Direction backwardDirection() {
        switch (direction) {
          case NORTH: return Direction.SOUTH;
		  case SOUTH: return Direction.NORTH; 
		  case EAST: return Direction.WEST; 
		  default: return Direction.EAST;
        }
    }
}
