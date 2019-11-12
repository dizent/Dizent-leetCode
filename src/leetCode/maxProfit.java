package leetCode;

public class maxProfit {

    public int function(int[] prices){
        int buy = -1;
        int sell = -1;
        int earnMoney = 0;
        for(int i = 1 ;i< prices.length; i++){
            if(prices[i-1] < prices[i]){
                buy = prices[i-1];
                sell = prices[i];
                earnMoney += sell - buy;
            }
//            if(prices[i]<prices[i+1] && sell == -1 && buy == -1){
//                buy = prices[i];
//            }
//            if(prices[i]>prices[i+1] && buy != -1){
//                sell = prices[i];
//            }
//            if(i+1 == prices.length -1 && buy != -1 && sell == -1 && prices[i+1] > buy ){
//                sell = prices[i+1];
//            }
//            if(sell != -1 && buy != -1){
//                earnMoney += sell - buy;
//                sell = -1;
//                buy = -1;
//            }
        }
        return earnMoney;
    }

    public void test(){
        System.out.println(function(new int[]{7,1,5,3,6,4}));
    }
}
