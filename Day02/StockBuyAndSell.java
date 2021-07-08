package Day02;

public class StockBuyAndSell {
	public int maxProfit(int[] prices) {
        int min = Integer.MAX_VALUE;
        int profit = 0;
        for(int x:prices){
            if(x<min){
                min = x;
            }else{
                profit = Math.max(profit,x-min);
            }
        }
        return profit;
    }
	public int maxProfit2(int[] prices) {
        int min = Integer.MAX_VALUE;
        int profit = 0,  maxProfit = 0;
        for(int x:prices){
            profit = x-min;
            min = Math.min(min,x);
            maxProfit = Math.max(maxProfit,profit);
        }
        return maxProfit;
    }
}
