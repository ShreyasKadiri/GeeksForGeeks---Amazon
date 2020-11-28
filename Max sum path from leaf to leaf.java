public class Solution{
    
	public int maxSumPathLeaf(TreeNode root, int result){
	    if(root==null){
	        return -1;
	    }
	    
	    int leftmaxSumPathLeaf = maxSumPathLeaf(root.left, result);
	    int rightmaxSumPathLeaf = maxSumPathLeaf(root.right, result);
	    
	    int temp = Math.max(leftmaxSumPathLeaf, rightmaxSumPathLeaf)+ root.val;
	    if(root.left==null && root.right==null)
	    temp = Math.max(temp, root.val);
	    
	    int answer = Math.max(temp, leftmaxSumPathLeaf+rightmaxSumPathLeaf+root.val);
	    
	    result = Math.max(answer, result);
	    return temp;
	}
}
