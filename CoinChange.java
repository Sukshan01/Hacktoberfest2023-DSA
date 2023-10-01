class Solution {
    public int coinChange(int[] coins, int amount) {

        int n = coins.length;

        int m = amount;

        int dp[][] = new int[n+1][m+1];


         for (int i = 0; i <= n; i++) {
            for (int j = 1; j <= m; j++) {
                dp[i][j] = Integer.MAX_VALUE - 1;
            }
        }

        // Set dp[i][0] to 0, as it takes 0 coins to make an amount of 0
        for (int i = 0; i <= n; i++) {
            dp[i][0] = 0;
        }


        for(int i=1; i<n+1; i++){
            for(int j=1; j<m+1; j++){

             int v = coins[i-1];

             if(v <= j){
                 // include

                 dp[i][j] = Math.min(dp[i][j-v] + 1, dp[i-1][j]);

                
             }
              //exclude

             else{
                     dp[i][j] = dp[i-1][j];
             }

                
         }

            
     }
        

        return dp[n][m] == Integer.MAX_VALUE - 1 ? -1 : dp[n][m];
        
    }
}
