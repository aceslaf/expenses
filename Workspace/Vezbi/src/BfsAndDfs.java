import java.util.LinkedList;
import java.util.Map.Entry;
import java.util.Queue;


public class BfsAndDfs {

	private Maze maze;
	public BfsAndDfs(Maze maze) {
		super();
		this.maze = maze;		
	}
	
	public void dfs(INodeTraverser nodeAction,MyNode startNode)
	{		
		
		Queue<MyNode> q=new LinkedList<MyNode>();
		q.add(startNode);
		while(!q.isEmpty())
		{
			MyNode node = q.poll();
			boolean shouldBreak = nodeAction.execute(node);
			if(shouldBreak)
			{
				return;
			}
			for (MyNode neighbour : maze.GetNeighbours(node.row, node.column) ) {
				q.add(neighbour);
			}
			
			
		}
	}
	
	public void bfs(INodeTraverser nodeAction,MyNode startNode)
	{		
		
		Queue<MyNode> q=new LinkedList<MyNode>();
		boolean[][] isVisited=new boolean[this.maze.GetRowCount()][this.maze.GetColumnCount()];
		q.add(startNode);
		while(!q.isEmpty())
		{
			MyNode node = q.poll();
			isVisited[node.row][node.column]=true;
			boolean shouldBreak = nodeAction.execute(node);
			if(shouldBreak)
			{
				return;
			}
			Iterable<MyNode> neighbours=maze.GetNeighbours(node.row, node.column);
	
			for (MyNode neighbour :  neighbours) {
				if(!isVisited[neighbour.row][neighbour.column])
				{
					q.add(neighbour);
				}				
			}			
		}
	}

}
