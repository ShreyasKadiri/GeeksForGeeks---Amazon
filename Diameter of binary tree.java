public class Solution{
    
	public int diameter(TreeNode root, int result){
	    if(root==null){
	        return -1;
	    }
	    
	    int leftDiameter = diameter(root.left, result);
	    int rightDiameter = diameter(root.right, result);
	    
	    int temp = Math.max(leftDiameter, rightDiameter)+ 1;
	    int answer = Math.max(temp, leftDiameter+rightDiameter+1);
	    result = Math.max(answer, result);
	    return temp;
	}
}
