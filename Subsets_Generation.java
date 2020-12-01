class SubsetIntegers{
    public List<List<Integer>> subsetOfIntegers(int numbers[]){
        List<List<Integer>> subsets = new ArrayList<List<Integer>>();
        if(numbers.length==0){
            return subsets;
        }
        
        generateSubsets(numbers, new ArrayList(), subsets, 0);
        return subsets;
    }
    
    public void generateSubsets(int numbers[], List<Integer> currentSet, List<List<Integer>> subsets, int index){
        if(index==numbers.length()){
            //Completed all possibilities
            subsets.add(currentSet);
            return ;
        }
        
        currentSet.add(numbers[index]);
        generateSubsets(numbers, currentSet, subsets, index+1);
        subsets.remove(subsets.length()-1);
        generateSubsets(numbers, currentSet, subsets, index+1);
        return;
    }
}
