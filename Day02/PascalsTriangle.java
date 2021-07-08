package Day02;

import java.util.ArrayList;
import java.util.List;

public class PascalsTriangle {
	public List<List<Integer>> generate(int r) {
        List<List<Integer>> ans = new ArrayList<>();
        List<Integer> t0 = new ArrayList<>();
        t0.add(1);
        ans.add(t0);
        for(int i=1;i<r;i++){
            List<Integer> list = new ArrayList<>();
            for(int j=0;j<=i;j++){
                if(j==0||j==i){
                    list.add(1);
                }else{
                    int k = ans.get(i-1).get(j-1)+ans.get(i-1).get(j);
                    list.add(k);
                }
            }
            ans.add(list);
        }
        return ans;
    }
}
