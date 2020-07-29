/**
 * Buy and Sell Stocks with coolDown
 *  
 *  HOLD(R)--------SELL
 *    -          -
 *     -       -
 *       BUY(R)
 *
 *   Hold[i] = max( hold[i-1], sell[i-1]
 *   buy[i]  = max(hold[i-1] - prices[i], buy[i - 1]
 *   sell[i] = buy[i - 1] + prices[i];
 */

class BuyAndSellStocks{

    public int maxProfit(int[] prices) {

	if(prices == null || prices.length < 2)
	   return 0;
	int n      = prices.length;
	int[] hold = new int[n];
	int[] buy  = new int[n];
	int[] sell = new int[n];
	hold[0]    = 0;
	buy[0]     = -prices[0];
	sell[0]    = Integer.MIN_VALUE;
	for(int i = 1; i < n; i++){

	   hold[i] = Math.max(hold[i - 1] , sell[i - 1]);
	   buy[i]  = Math.max(buy[i - 1], hold[i - 1] - prices[i]);
	   sell[i] = buy[i - 1] + prices[i];
        }
	return Math.max(hold[n - 1], sell[n - 1]);
    }
}
