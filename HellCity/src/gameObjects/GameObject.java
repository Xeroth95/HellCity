package gameObjects;

import static util.ErrorFactory.produceError;

/**
 * This is the base class for ALL game objects.
 * This class is abstract so no IDs get wasted for retarded code.
 * @author mint
 *
 */


//heeeyyy macaroni


/*
 * pepperoni macaroni?
 */

public abstract class GameObject {
	private static long currentId = 0;
	private long id = generateId();
	protected ObjectInformation information;
	
	public ObjectInformation getInfo() {
		assert (this.information != null) : produceError(this.getClass(), "No Objectinformation", this.id);
		return this.information;
	}
	
	public long getId() {
		return this.id;
	}
	
	private static long generateId() {
		return currentId++;
	}
}
