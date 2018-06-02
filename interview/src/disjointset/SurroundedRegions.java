package disjointset;

/**
 * @author: ryjarvis
 * Jan 13, 2018
 * 
 */
//LeetCode #130
public class SurroundedRegions {
	public static void solve(char[][]b){
        if(b.length==0){
            return;
        }
		int r=b.length;
		int c=b[0].length;
		boolean[][]visited=new boolean[r][c];
		for(int i=0;i<c;i++){
			if(b[0][i]=='O'){
				b[0][i]='s';
				dfs(b,visited,0,i);
			}
            
			if(r-1>=0&&b[r-1][i]=='O'){
				b[r-1][i]='s';
				dfs(b,visited,r-1,i);
			}
		}
		for(int j=0;j<r;j++){
			if(c-1>=0&&b[j][c-1]=='O'){
				b[j][c-1]='s';
				dfs(b,visited,j,c-1);
			}
			if(b[j][0]=='O'){
				b[j][0]='s';
				dfs(b,visited,j,0);
			}
		}
		for(int i=0;i<r;i++){
			for(int j=0;j<c;j++){
				if(b[i][j]=='O'){
					b[i][j]='X';
				}
				if(b[i][j]=='s'){
					b[i][j]='O';
				}
			}
		}
	}
	public static void dfs(char[][]b,boolean[][]v,int i,int j){
		if(i>=b.length||j>=b[0].length||i<0||j<0){
			return;
		}
		if(v[i][j]){
			return;
		}
		v[i][j]=true;
		if(b[i][j]=='X'){
			return;
		}
		else{
			b[i][j]='s';
			dfs(b,v,i-1,j);
			dfs(b,v,i+1,j);
			dfs(b,v,i,j-1);
			dfs(b,v,i,j+1);			
		}
	}
	

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		char[][]b={{'X','O','X'},{'O','X','O'},{'X','O','X'}};
		solve(b);
	}

}


