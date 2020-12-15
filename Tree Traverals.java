class Solution {
    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> result= new ArrayList<Integer>();
        Stack<TreeNode> stack = new Stack<TreeNode>();
        if (root!=null) 
            stack.push(root);
        while(!stack.isEmpty()) {
            TreeNode curr = stack.pop();
            result.add(curr.val);
            if(curr.right!=null) 
                stack.push(curr.right);
            if (curr.left!=null) 
                stack.push(curr.left);
        }
        return result;
    }


        ////////////////////////Inorder traversal////////////////////////
class Solution{
  public static List<Integer> inOrderTraversal(TreeNode root){
    if(root==null)  return null;
    TreeNode curr = root;
    Stack<TreeNode> stack = new Stack<TreeNode>();
    List<Integer> result = new ArrayList<Integer>();
    while(!stack.isEmpty() || curr!=null){
        while(curr!=null){
          stack.add(curr);
          curr=curr.left;
          }
          curr=stack.pop();
          result.add(curr.val);
          curr=curr.right;
      }
  return result;
   }
}

/////////////////////////Postorder Traversal////////////////////////////

class Solution {
    public List<Integer> postorderTraversal(TreeNode root) {
        List<Integer> res = new LinkedList<>();
        if (root == null) {
            return res;
        }

        Stack<TreeNode> stack = new Stack<TreeNode>();
        Stack<TreeNode> tmp = new Stack<TreeNode>();
        stack.add(root);
        while (!stack.isEmpty()) {
            TreeNode node = stack.pop();
            tmp.push(node);
            if (node.left != null) {
                stack.push(node.left);
            }
            if (node.right != null) {
                stack.push(node.right);
            }
        }
        
        while (!tmp.isEmpty()) {
            res.add(tmp.pop().val);
        }
        return res;
    }
}
