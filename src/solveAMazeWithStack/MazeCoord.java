package solveAMazeWithStack;

public class MazeCoord {
	public int i;
	public int j;
	public int dir;
	// Direction
	public static final int NORTH = 0;
	public static final int EAST = 1;
	public static final int SOUTH = 2;
	public static final int WEAST = 3;
	
	MazeCoord(int i, int j, int dir) {
		this.i = i;
		this.j = j;
		this.dir = dir;
	}
	
	// For a call by value
	MazeCoord(MazeCoord mazeCoord) {
		this.i = mazeCoord.i;
		this.j = mazeCoord.j;
		this.dir = mazeCoord.dir;
	}

	public boolean move() {
		switch(dir) {
		case NORTH :
			i--;
			break;
		case EAST :
			j++;
			break;
		case SOUTH :
			i++;
			break;
		case WEAST :
			j--;
			break;
		default :
			return false;
		}
		if(i >= 0 && j >= 0) return true;
		else return false;
	}
	public boolean move(int dir) {
		this.dir = dir;
		switch(dir) {
		case NORTH :
			i--;
			break;
		case EAST :
			j++;
			break;
		case SOUTH :
			i++;
			break;
		case WEAST :
			j--;
			break;
		default :
			return false;
		}
		if(i >= 0 && j >= 0) return true;
		else return false;
	}

	public void print() {
		System.out.println("i : " + i + ", j :" + j + ", Direction : " + dir);
	}
	public void printToArrayPostion() {
		System.out.println("(" + i + ", " + j + ")");
	}
	public void printToRealPosition() {
		System.out.println("(" + (i-1) + ", " + (j-1) + ")");
	}
}
