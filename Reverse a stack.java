public class Solution
{
    public Stack<Integer> reverseStackRecursive(Stack<Integer> stack){
	  if(stack.isEmpty()==false){
        int popped= stack.pop();
        reverseStackRecursive(stack);
        insertAtBottom(stack, popped);
        }
}

   public void insertAtBottom(Stack<Integer> stack, int x){
        if(stack.isEmpty()){
            stack.push(x);
            return;
        }
        int popped= stack.pop();
        insertAtBottom(stack, x);
        stack.push(popped);
    }
}
