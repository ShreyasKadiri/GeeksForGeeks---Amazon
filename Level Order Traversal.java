public class TreeNode{
    int value;
    TreeNode root;
    TreeNode left;
    TreeNode right;
}

class LevelOrderTraversal{
     public void levelOrderTraversal(TreeNode root){
         if(root==null){
             return null;
         }
         List<List<Integer>> result = new ArrayList<ArrayList<Integer>>();
         Queue<Integer> queue = new LinkedList<Integer>();
         queue.offer(root);
         while(!queue.isEmpty()){
             int level = queue.size();
             List<Integer> currentTraversal = new ArrayList<Integer>();
             for(int i=0; i<level; i++){
                TreeNode currentNode = queue.poll();
                if(currentNode.left!=null){
                    currentTraversal.offer(currentNode.value);
                }
                if(currentNode.right!=null){
                    currentTraversal.offer(currentNode.value);
                }
                
             }
             result.add(currentTraversal);
         }
         return result;
     }
}
