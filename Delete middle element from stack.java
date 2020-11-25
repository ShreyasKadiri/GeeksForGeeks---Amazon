public class Solution{
     public int deleteMiddleElement(Stack<Integer> stack, int n){
	    if(stack.isEmpty()){
	       return -1;
	    }
	    
	    if(stack.size()==1){
	        return stack.pop();
	    }
	    
	    //Middle element is  (k/2  + 1 )th element
	    int k = (stack.size()/2 ) +1;
 	     if(k==1){
 	         return stack.pop();
 	     }
 	     
 	     int popped = stack.pop();
	     deleteMiddleElement(stack, k-1);
	     stack.push(popped);
	   
	    return -1;
	}
}
