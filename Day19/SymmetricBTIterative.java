package Day19;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class SymmetricBTIterative {
	public boolean isSymmetric(  Node root) {
        Queue<  Node> q = new LinkedList<>();
        q.add(root);
        while(!q.isEmpty()){
            int k = q.size();
            List<Integer> list = new ArrayList<>();
            for(int i=0;i<k;i++){
                  Node node = q.remove();
               if(node!=null){
                    list.add(node.val);
                    q.add(node.left);
                    q.add(node.right);
               }
                else{
                    list.add(null);
                }
            }
            if(!palin(list))return false;
        }
        return true;
    }
    public boolean palin(List<Integer> list){
        int i=0,j=list.size()-1;
        while(i<j){
            if(list.get(i)!=list.get(j)) {
                return false;
            }
            i++;
            j--;
        }
        return true;
    }
}
