public class CheckForTarget implements INodeTraverser
	{
		MyNode targetNode;
		boolean[][] isTraversedFields;
		private Maze maze;
		public CheckForTarget(Maze maze,int targetR,int targetC) {
			// TODO Auto-generated constructor stub
			this.maze=maze;
		}
		@Override
		public boolean execute(MyNode n) {
			return false;	
		}
		@Override
		public boolean shoudlTraverse(MyNode n) {
			// TODO Auto-generated method stub
			return this.isTraversedFields[n.row][n.column];
		}

		
	}
