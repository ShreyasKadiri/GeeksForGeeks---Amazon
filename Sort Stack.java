class SortStack { 
    public static Stack<Integer> sortstack(Stack<Integer>input) { 
        Stack<Integer> stack = new Stack<Integer>(); 
        while(!input.isEmpty()) { 
            int popped = input.pop(); 
            while(!stack.isEmpty() && stack.peek()>popped){ 
            input.push(stack.pop()); 
            } 
            stack.push(popped)); 
        } 
        return stack; 
    } 
