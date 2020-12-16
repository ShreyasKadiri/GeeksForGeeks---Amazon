class Solution{
    public static String serializeBinarySearchTree(TreeNode root){
        if(root==null){
            return  "";
        }
        return formString(root, new StringBuilder()).toString();
    }
    
    public static StringBuilder formString(TreeNode root, StringBuilder sb){
        sb.append(root.value);
        while(root!=null){
        sb.append(" ");
        formString(root.left, sb);
        formString(root.rigt, sb);
        }
        return sb;
    }
    
    //Deserialize a binary search tree 
    
    public static TreeNode deserializeBinarySearchTree(String word){
        if(word==""){
            return null;
        }
        String words[] = word.split(" ");
        TreeNode root = new TreeNode(Integer.parseInt(words[0]));
        for(int i=1; i<words.length; i++){
            TreeNode currentNode = root;
            int val = Integer.parseInt(words[i]);
            while(true){
                if(currentNode.val > val){
                    if(currentNode.left!=null){
                    currentNode = currentNode.left;
                    }
                    else{
                        currentNode.left = new TreeNode(val);
                    }
                }
                
                else{
                    if(currentNode.right!=null){
                    currentNode = currentNode.right;
                    }
                    else{
                        currentNode.right = new TreeNode(val);
                    }
                }
            }
        }
        return root;
    }
}
