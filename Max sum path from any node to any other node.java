public class Solution{
    
	public int maxSumPath(TreeNode root, int result){
	    if(root==null){
	        return -1;
	    }
	    
	    int leftmaxSumPath = maxSumPath(root.left, result);
	    int rightmaxSumPath = maxSumPath(root.right, result);
	    
	    int temp = Math.max(Math.max(leftmaxSumPath, rightmaxSumPath)+ root.val, root.val);
	    int answer = Math.max(temp, leftmaxSumPath+rightmaxSumPath+root.val);
	    
	    result = Math.max(answer, result);
	    return temp;
	}
}
