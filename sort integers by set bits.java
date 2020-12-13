class Solution {
    public int[] sortByBits(int[] arr) {
        int sorted[] = new int[arr.length];
        PrioirityQueue<Integer> minHeap = new PriorityQueue<Integer>(new Comparator<Integer>(){
            public int compare(Integer a, Integer b){
                int value1 = countOnes(a);
                int value2 = countOnes(b);
                if(value1 == value2){
                    return a - b;
                }
            }
            return value1-value2;   
        });
        
        for(int i=0; i<arr.length; i++){
            minHeap.add(arr[i]);
        }
        int index=0;
        while(minHeap.size() > 0){
            int value = minHeap.poll();
            sorted[index++] = value;
        }
        
        return sorted;
    }
    
    public int countOnes(int n){
        int count=0;
        while(n!=0){
            n = n & (n-1);
            count+=1;
        }
        return count;
    }
    
}
