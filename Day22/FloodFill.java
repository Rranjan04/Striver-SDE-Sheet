package Day22;

public class FloodFill {
	public int[][] floodFill(int[][] image, int sr, int sc, int nc) {
        boolean[][] visited = new boolean[image.length][image[0].length];
        help(image,sr,sc,nc,image[sr][sc],visited);
        return image;
    }
    public void help(int[][] image, int x, int y, int nc, int oc, boolean[][] visited){
        if(x<0||x>=image.length||y<0||y>=image[0].length||image[x][y]!=oc||visited[x][y]) return;
        image[x][y] = nc;
        visited[x][y] = true;
        help(image,x+1,y,nc,oc,visited);
        help(image,x-1,y,nc,oc,visited);
        help(image,x,y-1,nc,oc,visited);
        help(image,x,y+1,nc,oc,visited);
    }
}
