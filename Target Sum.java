class Solution{
int result=0;
public int findTargetSumWays(int[] nums, int s) {
dfs(0,nums,s,0);
return result;
}

public void dfs(int i, int[] nums, int target, int curr) {
	if (i==nums.length && curr==target){
		result++;
		return;
	}
	if(i==nums.length) {
		return;}
	dfs(i+1, nums, target, curr+nums[i]);
	dfs(i+1, nums, target, curr-nums[i]);
}
}
