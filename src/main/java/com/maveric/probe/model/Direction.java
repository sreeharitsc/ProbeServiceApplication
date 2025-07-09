/**
 * 
 */
package com.maveric.probe.model;

/**
 * @author sreehari
 *	Class used to represent Direction model
 */
public enum Direction {
	NORTH, EAST, SOUTH, WEST;
	
	public Direction turnRight() {
		return values()[(this.ordinal()+1)%4];
	}
	
	public Direction turnLeft() {
		return values()[(this.ordinal()+3)%4]; // +3 is same as -1 in modulo 4
	}
	
	public int deltaX() {
		switch (this) {
		case EAST: return 1;
		case WEST: return -1;
		default: return 0;
		}
	}
	
	public int deltaY() {
		switch (this) {
		case NORTH: return 1;
		case SOUTH: return -1;
		default: return 0;
		}
	}
	
}
