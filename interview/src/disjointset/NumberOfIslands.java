package disjointset;
//LeetCode #200
public class NumberOfIslands {
	
    public int numIslands(char[][] grid) {
    	boolean [][] visited=new boolean[grid.length][grid[0].length];
        int count=0;
        for(int i=0;i<grid.length;i++){
        	for(int j=0;j<grid[0].length;j++){
        		if(!visited[i][j]&&grid[i][j]!='0'){
        			visit(i,j,grid,visited);
        			count++;
        		}
        	}
        }
        return count;
    }
    public void visit(int i,int j,char[][]grid,boolean[][]visited ){
    	if(i<0||j<0||j>grid[0].length||i>grid.length||grid[i][j]!='0'){
    		return;
    	}
    	visited[i][j]=true;
    	visit(i-1,j,grid,visited);
    	visit(i+1,j,grid,visited);
    	visit(i,j-1,grid,visited);
    	visit(i,j+1,grid,visited);   	
    }

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
