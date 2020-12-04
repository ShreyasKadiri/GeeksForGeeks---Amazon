class Solution {
    public boolean canIWin(int maxChoosableInteger, int desiredTotal) {
        if(desiredTotal<=0) 
            return true;
        if(maxChoosableInteger*(maxChoosableInteger + 1) / 2 < desiredTotal)
            return false;
        int[] dp = new int[1<<maxChoosableInteger];
        return dfs(dp, 0, maxChoosableInteger, desiredTotal);
    }
    
    public boolean dfs(int[] dp, int currentState, int max, int target) {
        if(target<=0)
            return false;
        if(dp[currentState]!=0)
            return dp[currentState]==1;
        boolean win=false;
        for (int i=0; i<max; i++) {
            if ((currentState & (1<<i))==0) {
                win=win || !dfs(dp, currentState^(1<<i), max, target-i-1);
            }
        }
        dp[currentState]=win ? 1:-1;
        return win;
    }
}


/*
Ref:
https://leetcode.com/problems/can-i-win/discuss/404665/Java-DP-solution-with-detailed-explanation-very-easy-to-understand
*/

