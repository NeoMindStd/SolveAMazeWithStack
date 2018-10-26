package solveAMazeWithStack;

public class DataStack 
{	
	// Constants
	// protected final static char NULL_CHAR = '\0';
	// protected final static int STACK_SIZE = 100;
	
	// Variables
	protected int mTop = -1;
	protected int mStackSize = 0;
	private MazeCoord[] mStack = null;
	
	public DataStack(int size) 
	{
		this.mStackSize = size;
		mStack = new MazeCoord[mStackSize];
	}
	
	public void Push(MazeCoord data)
	{
		try {
			if(mTop < mStackSize-1) {	
				mStack[++mTop] = data;
			}
		} catch(Exception e) {
		}
		return;
	}
	
	public MazeCoord Pop()
	{
		try {
			if(!IsEmpty()) {
				return mStack[mTop--];
			}
		} catch(Exception e) {
		}
		return null;
	}
	
	public boolean IsEmpty()
	{
		return (mTop == -1);
	}
	
	public void Delete()
	{
		try {
			if(!IsEmpty()) {
				mTop--;
			}
		} catch(Exception e) {
		}
		return;
	}

	public MazeCoord Peek()
	{
		try {
			if(!IsEmpty()) {
				return mStack[mTop];
			}
		} catch(Exception e) {
		}
		return null;
	}

	public int GetSize()
	{
		return (mTop+1);
	}
	
	public int GetmStackSize()
	{
		return mStackSize;
	}
}
