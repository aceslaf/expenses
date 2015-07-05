import java.util.LinkedList;
import java.util.List;




public class Maze {

	private int[][] fields;
	private int rowCount;
	private int columnCount;
	public Iterable<MyNode> GetNeighbours(int row,int column)
	{	
		List<MyNode> neighbourList=new LinkedList<MyNode>();
		for (int i = -1; i <= 1; i++) {
			for(int j=-1;j<=1;j++)
			{
				if(i==0&&j==0)
				{
					continue;
				}
				int neighbourRow=row+i,neighbourColumn=column+j;
				if(neighbourRow>=this.rowCount ||neighbourRow<0)
				{
					continue;
				}
				
				if(neighbourColumn>=neighbourColumn||j<0 )
				{
					continue;
				}
				MyNode node = new MyNode(neighbourRow,neighbourColumn,this.fields[neighbourRow][neighbourColumn]==1);
				neighbourList.add(node);
			}
		}
		return neighbourList;
	}
	public Maze(int rowCount,int columnCount, float unwalkableProbabilityTreshold) {
		super();
		this.fields=new int[rowCount][columnCount];
		this.rowCount=rowCount;
		this.columnCount=columnCount;
		
		for (int i = 0; i < rowCount; i++) {
			for (int j = 0; j < columnCount; j++) {
				if(Math.random()<unwalkableProbabilityTreshold)
				{
					this.fields[i][j]=1;
				}else
				{					
					this.fields[i][j]=0;
				}
			}
		}
	} 
	
	public void print()
	{
		for (int i = 0; i < this.rowCount; i++) {
			for (int j = 0; j < this.columnCount; j++) {
				System.out.print(this.fields[i][j]+" ");
			}
			System.out.println("");
		}
	}
	
	
	
	public int GetRowCount(){return this.rowCount;}
	public int GetColumnCount(){return this.columnCount;}
}
