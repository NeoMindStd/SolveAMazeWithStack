package solveAMazeWithStack;

public class SolveAMazeWithStack {
	private static final int M = 6;
	private static final int N = 6;
	
	// Direction
	private static final int NORTH = 0;
	private static final int EAST = 1;
	private static final int SOUTH = 2;
	private static final int WEAST = 3;
	
	public static void main(String[] args) {
		mazePath();
	}
	
	private static void mazePath() {
		// Initialize
		int[][] maze = new int[M+2][N+2];
		int[][] mark = new int[M+2][N+2];
		
		for(int i = 0; i < maze.length; i++) {
			for(int j = 0; j < maze[0].length; j++) {
				maze[i][j] = mark[i][j] = 0;
				if((i == 0) || (i == maze.length-1) || 
						(j == 0) || (j == maze[0].length-1)) {
					maze[i][j] = 1;
				}
			}
		}
		
		DataStack mazeStack = new DataStack(M * N);
		mazeStack.Push(new MazeCoord(1, 1, EAST));		// Entrance. The direction of movement is initialized to the east.
		
		while(!mazeStack.IsEmpty()) {
			MazeCoord current = mazeStack.Pop();
		}
	}
}
