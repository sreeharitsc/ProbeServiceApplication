/**
 * 
 */
package com.maveric.probe.dto;

import com.maveric.probe.model.Direction;

/**
 * @author sreehari
 *	Class used to represent InitRequest DTO
 */
public class InitRequest {

	public int gridWidth;
    public int gridHeight;
    public int startX;
    public int startY;
    public Direction direction;
}
