public class Josephus{
    public int josephusPermutation(int n, int k){
        if(n==0 || k==0){
            return -1;
        }
        if(n==1){
            return 0;
        }
        int x = josephusPermutation(n-1, k);
        int y = (x+k)%n;
        return y;
    }
}
