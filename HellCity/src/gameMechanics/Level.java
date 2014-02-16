package gameMechanics;

import gameObjects.GridObject;

import java.util.ArrayList;

public class Level {
	public static int[] powersOf2;
	private int[][] objectGrid;
	int IdCounter;
	ArrayList<Integer> objectIds;
	ArrayList<Integer> availableIds;
	private  GridObject[] levelObjects;
	int size;
	static int MAX_OBJECT_COUNT=50000;
	static int MAX_SIZE=16;
	static{
		powersOf2=new int[10];
		int help=1;
		for(int i=0;i<MAX_SIZE;i++, help*=2){
			powersOf2[0]=help;
		}
	}
	public Level(){
		this.initializeBasics();
		levelObjects=new GridObject[MAX_OBJECT_COUNT];
		size=0;
	}
	public Level(int size){
		this.initializeBasics();
		this.size=size;
		objectGrid=new int[powersOf2[size]][powersOf2[size]];
		levelObjects=new GridObject[MAX_OBJECT_COUNT];
	}
	private void initializeBasics(){
		IdCounter=1; //there is no Id 0! always check for zero to be sure if there is nothing in a cell or whatever! This is convenient because arrays are initialized with 0!
		availableIds=new ArrayList<Integer>();
		objectIds=new ArrayList<Integer>();
	}
	private int getNewLevelId(){
		if(this.availableIds.size()!=0){	//first, try to recycle available Ids
			try{
				return this.availableIds.get(0);
			}
			finally{
				this.availableIds.remove(0);
			}
		}
		this.IdCounter++;
		return this.IdCounter;
	}
	public void addObject(GridObject o,int x,int y){
		o.setX(x);
		o.setY(y);
		this.addObject(o);
	}
	public void addObject(GridObject o){
		o.setLevel(this);
		o.setId(this.getNewLevelId());
		this.objectIds.add(o.getId());
		this.levelObjects[o.getId()]=o;
		if(o.isHasMask()){
			int[][] mask=o.getMask();
			for(int i=o.getX(), i2=0;i<mask.length;i++,i2++){
				for(int j=o.getY(), j2=0;j<mask[0].length;j++,j2++){
					if(mask[i2][j2]!=0)objectGrid[i][j]=o.getId();
				}
			}
		}
		else{
			for(int i=o.getX();i<o.getX();i++){
				for(int j=o.getY();j<o.getY();j++){
					objectGrid[i][j]=o.getId();
				}
			}
		}
	}
	public void removeObject(GridObject o){
		if(o.isHasMask()){
			int[][] mask=o.getMask();
			for(int i=o.getX(), i2=0;i<mask.length;i++,i2++){
				for(int j=o.getY(), j2=0;j<mask[0].length;j++,j2++){
					if(mask[i2][j2]!=0)objectGrid[i][j]=0;
				}
			}
		}
		else{
			for(int i=o.getX();i<o.getX();i++){
				for(int j=o.getY();j<o.getY();j++){
					objectGrid[i][j]=0;
				}
			}
		}
		this.objectIds.remove(o.getId());
		this.levelObjects[o.getId()]=null;
		this.availableIds.add(o.getId());
		
	}
	public void removeObject(int objectID){
		GridObject o=levelObjects[objectID];
		if(o.isHasMask()){
			int[][] mask=o.getMask();
			for(int i=o.getX(), i2=0;i<mask.length;i++,i2++){
				for(int j=o.getY(), j2=0;j<mask[0].length;j++,j2++){
					if(mask[i2][j2]!=0)objectGrid[i][j]=0;
				}
			}
		}
		else{
			for(int i=o.getX();i<o.getX();i++){
				for(int j=o.getY();j<o.getY();j++){
					objectGrid[i][j]=0;
				}
			}
		}
		this.objectIds.remove(objectID);
		this.levelObjects[objectID]=null;
		this.availableIds.add(objectID);
	}
	public boolean isPlaceFree(int leftUpperX, int leftUpperY, int x, int y){
		if(leftUpperX<0||leftUpperY<0||leftUpperX+x>powersOf2[this.size]||leftUpperX+x<0||leftUpperY+y>powersOf2[this.size]||leftUpperY+y<0){
			return false;
		}
		int check=0;//exploit that we only have positive values as IDs so adding them together will always result in a positive value. granted, that we don't have an overflow.
		for(int i=leftUpperX;i<leftUpperX;i++){
			for(int j=leftUpperY;j<leftUpperY;j++){
				check+=objectGrid[i][j];
			}
		}
		if(check!=0)return false;
		else return true;
	}
	public boolean isPlaceFree(int leftUpperX, int leftUpperY, int[][] mask){//for more complicated shapes. where mask has 0 there will nothing be build.
		if(leftUpperX<0||leftUpperY<0||leftUpperX+mask.length>powersOf2[this.size]||mask.length!=0||leftUpperY+mask[0].length>powersOf2[this.size]){// check for illegal values
			return false;
		}
		for(int i=leftUpperX, i2=0;i<mask.length;i++,i2++){
			for(int j=leftUpperY, j2=0;j<mask[0].length;j++,j2++){
				if(mask[i2][j2]!=0&&objectGrid[i][j]!=0)return false;
			}
		}
		return true;
	}
}
