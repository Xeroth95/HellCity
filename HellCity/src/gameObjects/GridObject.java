package gameObjects;

import gameMechanics.Level;

public abstract class GridObject {
	public int Id;
	public Level level;
	int x;
	int y;
	int sizeX;
	int sizeY;
	boolean hasMask;
	public int getSizeX() {
		return sizeX;
	}
	public void setSizeX(int sizeX) {
		this.sizeX = sizeX;
	}
	public int getSizeY() {
		return sizeY;
	}
	public void setSizeY(int sizeY) {
		this.sizeY = sizeY;
	}
	public boolean isHasMask() {
		return hasMask;
	}
	public void setHasMask(boolean hasMask) {
		this.hasMask = hasMask;
	}
	public int[][] getMask() {
		return mask;
	}
	public void setMask(int[][] mask) {
		this.mask = mask;
	}
	int[][] mask;
	public GridObject(){
		
	}
	public int getId() {
		return this.Id;
	}
	public Level getLevel() {
		return level;
	}
	public void setLevel(Level level) {
		this.level = level;
	}
	public int getX() {
		return x;
	}
	public void setX(int x) {
		this.x = x;
	}
	public int getY() {
		return y;
	}
	public void setY(int y) {
		this.y = y;
	}
	public void setId(int iD) {
		Id = iD;
	}
	
}
