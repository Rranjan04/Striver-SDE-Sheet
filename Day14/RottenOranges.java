package Day14;

import java.util.LinkedList;
import java.util.Queue;

public class RottenOranges {
	public int orangesRotting(int[][] grid) {
        int time = 0;
        int one = 0;
        int two = 0;
        Queue<Pair> q = new LinkedList<>();
        for(int i=0;i<grid.length;i++){
            for(int j=0;j<grid[0].length;j++){
                if(grid[i][j]==2){
                    q.add(new Pair(i,j));
                    two++;
                }else if(grid[i][j]==1){
                    one++;
                }
            }
        }
        int count = two;
        q.add(null);
        while(!q.isEmpty()){
            Pair p = q.poll();
            if(p==null){
                if(!q.isEmpty()){
                    q.add(null);
                    time++;
                }
            }
          if(p!=null){
                int i = p.x;
                int j = p.y;
                if(isValid(grid,i+1,j)){
                    grid[i+1][j] = 2;
                    count++;
                    q.add(new Pair(i+1,j));
                }
                if(isValid(grid,i-1,j)){
                    grid[i-1][j] = 2;
                    count++;
                    q.add(new Pair(i-1,j));
                }
                if(isValid(grid,i,j+1)){
                    grid[i][j+1] = 2;
                    count++;
                    q.add(new Pair(i,j+1));
                }
                if(isValid(grid,i,j-1)){
                    grid[i][j-1] = 2;
                    count++;
                    q.add(new Pair(i,j-1));
                }
          }
        }
        
        return count!=one+two?-1:time;
    }
    public boolean isValid(int[][] grid, int i, int j){
        if(i<0||i>=grid.length||j<0||j>=grid[0].length||grid[i][j]!=1) return false;
        return true;
    }
    class Pair{
        int x;
        int y;
        Pair(int x, int y){
            this.x = x;
            this.y = y;
        }
    }
}
