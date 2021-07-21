package Day24;

public class DisjointSet {
	// union and find parent
	public static void main(String[] args) {
		
	}
	int[] parent = new int[100000];
	int[] rank = new int[100000];
	void makeSet(){
		for(int i=0;i<=10000;i++){
			parent[i] = i;
			rank[i] = 0;
		}
	}
	int findparent(int node){
		if(node==parent[node]){
			return node;
		}
		return parent[node] = findparent(parent[node]);
	}
	void union(int u, int v){
		u = findparent(u);
		v = findparent(v);
		if(rank[u]<rank[v]){
			parent[u] = v;
		}else if (rank[u]>rank[v]){
			parent[v] = u;
		}else{
			parent[v] = u;
			rank[u]++;
		}
	}
}
