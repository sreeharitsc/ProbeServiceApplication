/**
 * 
 */
package com.maveric.probe.model;

import java.util.Objects;

/**
 * @author sreehari
 *	Class used to represent Position model
 */
public class Position {

	private final int x;
	private final int y;
	
	public Position(int x, int y) {
		this.x=x;
		this.y=y;
	}
	public int getX() {
		return x;
	}
	public int getY() {
		return y;
	}
	@Override
	public int hashCode() {
		return Objects.hash(x,y);
	}
	
	@Override
	public boolean equals(Object o) {
		if(this == o) return true;
		if(!(o instanceof Position)) return false;
		Position pos = (Position)o;
		return x == pos.x && y == pos.y;
	}
	@Override
	public String toString() {
		return "("+x+","+y+")";
	}
	
	public Position move(int dx, int dy) {
		return new Position(this.x+dx, this.y+dy);
	}
}
