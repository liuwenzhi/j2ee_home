package lkhwtk.leetcode901;

import java.util.ArrayList;

/**
 * 901. 股票价格跨度
 * 个人思路：使用list列表实现，时空耗时均比较高
 */
public class StockSpanner {
    private ArrayList<Integer> stockPriceList;
    public StockSpanner() {
        stockPriceList = new ArrayList<>();
    }

    /**
     * 注意算今天，往前看连续的不大于天数
     */
    public int next(int price) {
        stockPriceList.add(price);
        int stocks = 0;
        for(int i=stockPriceList.size()-1;i>=0;i--){
            if(price>=stockPriceList.get(i)){
                stocks++;
            }else{
                break;
            }
        }
        return stocks;
    }

    public static void main(String[] args){
        StockSpanner stockSpanner = new StockSpanner();
        System.out.println(stockSpanner.next(100));
        System.out.println(stockSpanner.next(80));
        System.out.println(stockSpanner.next(60));
        System.out.println(stockSpanner.next(70));
        System.out.println(stockSpanner.next(60));
        System.out.println(stockSpanner.next(75));
        System.out.println(stockSpanner.next(85));
    }
}
