import java.util.*;

class swEasy1 {
    /**
     * myFirst solution, using a single pass through the prices array.
     * We track the lowest price seen so far and calculate the potential
     * profit at each price point. If the current price is lower than the
     * lowest price, we update the lowest price. Otherwise, we calculate
     * the profit and update the maximum profit if it's higher than the
     * previously recorded maximum profit.
     * @param prices array representing the stock prices on different days
     * @return the maximum profit that can be achieved
     */
    public int maxProfit(int[] prices) {
        int maxProf = Integer.MIN_VALUE;
        int currentLowest = Integer.MAX_VALUE;
        for (int price : prices) {
            if (price < currentLowest) {
                currentLowest = price;
            } else {
                maxProf = Math.max(maxProf, price - currentLowest);
            }
        }
        return maxProf == Integer.MIN_VALUE ? 0 : maxProf;
    }
}

// Other solutions can be made by, for example,
// 1. Using dynamic programming to keep track of the maximum profit at each day.
// 2. Using a brute force approach by checking all possible pairs of buy and sell days
//    to find the maximum profit, but this would have a higher time complexity.