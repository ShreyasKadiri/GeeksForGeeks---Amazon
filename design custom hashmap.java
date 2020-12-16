class MyHashMap {

    
    /** Initialize your data structure here. */
    Node buckets[];
    
    public MyHashMap() {
        this.buckets = new Node[100];
    }
    
    /** value will always be non-negative. */
    public void put(int key, int value) {
        int index=getAddress(key);
        //We need to put value at this index
        if(buckets[index]==null){
            buckets[index] = new Node(key,value);
        }else{
            //There is a chance of collision and hence we need to add to the linkedlist
            Node node = buckets[index];
            while(node.next!=null){
                if(node.key==key){
                    node.value= value;
                    break;
                }
            
            node = node.next;
        }
            //First time this value is coming in
            if(node.key==key){
                node.value = value;
                return ;
            }
            Node newNode = new Node(key,value);
            node.next=newNode;
        }
        return ;
    }
    
    /** Returns the value to which the specified key is mapped, or -1 if this map contains no mapping for the key */
    public int get(int key) {
        int index=getAddress(key);
        if(buckets[index]==null){
            return -1;
        }
        Node node = buckets[index];
        while(node!=null){
            if(node.key==key){
                return node.value;
            }
        }
        return -1;
    }
    
    /** Removes the mapping of the specified value key if this map contains a mapping for the key */
    public void remove(int key) {
        int index = getAddress(key);
        if(buckets[index]==null){
            return ;
        }
        Node node = buckets[index];
        //If we found the key
        if(node.key==key){
            //we need to remove this
            buckets[index]=buckets[index].next;
        }
        Node prev=null;
        Node prevRef = null;
        while(node!=null){
            if(node.key==key){
                prevRef = prev;
                break;
            }
            prev=node;
            node=node.next;
        }
        if(prevRef==null){
            return ;
        }else{
            prev.next = prev.next.next;
        }
        return  ;
    }
    
    
    public int getAddress(int key){
        return key%buckets.length;
    }
    
    static class Node{
        int key;
        int value;
        Node next;
        Node(int key, int value){
            this.key=key;
            this.value=value;
        }
    }
    
}

/**
 * Your MyHashMap object will be instantiated and called as such:
 * MyHashMap obj = new MyHashMap();
 * obj.put(key,value);
 * int param_2 = obj.get(key);
 * obj.remove(key);
 */
