package solveAMazeWithStack;

public class SolveAMazeWithStack {
	// M * N Maze
	private static final int M = 7;
	private static final int N = 6;
	
	public static void main(String[] args) {
		DataStack pathStack = mazePath();
		if(pathStack == null) return;
		else {
			MazeCoord[] mazePath = new MazeCoord[pathStack.GetSize()];
			while(!pathStack.IsEmpty()) {
				mazePath[pathStack.GetSize()-1] = pathStack.Pop();
			}
			for(MazeCoord temp : mazePath)
				temp.printToArrayPostion();
		}
	}

	
	private static DataStack mazePath() {
		/**
		 * Initialize
		 * Please initialize the your maze.
		 * Maze's first and last rows and columns are must 1.
		 * You must initialize index of 1~last-1. The array's size is [M+2][N+2].
		 * 0 : pass possible, road 1 : impossible, wall.
		 */
		int[][] maze = 
				{ {1, 1, 1, 1, 1, 1, 1, 1}, 
				  {1, 0, 1, 1, 0, 1, 1, 1},
				  {1, 0, 0, 1, 0, 1, 1, 1}, 
				  {1, 1, 0, 0, 0, 1, 1, 1}, 
				  {1, 1, 1, 0, 0, 0, 1, 1}, 
				  {1, 0, 0, 0, 1, 1, 1, 1}, 
				  {1, 1, 0, 1, 0, 0, 0, 1},
			      {1, 0, 0, 0, 0, 1, 0, 1}, 
				  {1, 1, 1, 1, 1, 1, 1, 1} };
		int[][] mark = new int[M+2][N+2];
		for(int i = 0; i < mark.length; i++)
			for(int j = 0; j < mark[0].length; j++)
				mark[i][j] = 0;
		
		// print initialized arrays.
		System.out.println("==== MAZE ====");
		for(int i = 0; i < maze.length; i++) {
			for(int j = 0; j < maze[0].length; j++) {
				System.out.print(maze[i][j] + " ");
			}
			System.out.println();
		}
		System.out.println();
		
		// Solve the maze.
		DataStack mazeStack = new DataStack(M * N);
		mazeStack.Push(new MazeCoord(1, 1, MazeCoord.EAST));		// Entrance. The direction of movement is initialized to the east.
		mark[1][1] = 1;
		
		MazeCoord current, next;
		while(!mazeStack.IsEmpty()) {
			current = mazeStack.Pop();
			while(current.dir <= MazeCoord.WEAST) {
				next = new MazeCoord(current);
				next.move();
				if(next.i == M && next.j == N) {
					mazeStack.Push(current);
					mazeStack.Push(next);
					System.out.println("The path is as follows.");
					return mazeStack;
				}
				if(maze[next.i][next.j] == 0 &&			// Can Move
						mark[next.i][next.j] == 0) {	// Didn't try
					mark[next.i][next.j] = 1;
					mazeStack.Push(current);
					current = new MazeCoord(next);
					current.dir = MazeCoord.NORTH;
				} 
				else current.dir++;
			}
		}
		System.out.println("There is no path");
		return null;
	}
}
