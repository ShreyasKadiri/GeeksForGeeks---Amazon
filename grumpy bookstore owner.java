class Solution {
    public int maxSatisfied(int[] customers, int[] grumpy, int X) {
        int totalSleepy=0;
        int max= Integer.MIN_VALUE;
        for(int i=0; i<grumpy.length; i++){        //0->Awake and 1->Sleepy  we need to consider sleepy(1) case
            if(grumpy[i]==0){
                totalSleepy+=customers[i];
            }
        }
        
        int sleepyScore = 0 ;
        int k=0;
        for(int i=0; i<X; i++){
            if(grumpy[i]==1){
                sleepyScore=+customers[i];
            }
        }
        
        max = Math.max(max, sleepyScore);
          for(int i=X; i<customers.length; i++)  {
            if(grumpy[k]==1){
                sleepyScore=sleepyScore-customers[k];
            }
            
            if(grumpy[i]==1){
                sleepyScore=sleepyScore+customers[i];
            }
            max = Math.max(max, sleepyScore);
            k++;
        }
        return max + totalSleepy;
    }
}
