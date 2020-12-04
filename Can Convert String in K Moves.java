class Solution {
    public boolean canConvertString(String s, String t, int k) {
        int numberOfSteps=0;
        if(s==t)  return true;
        if(s.length()!=t.length())   return false;
        int characters[]=new int[26];
        int h=k/26;
        int h1=k%26;
        //count of each number from 1 to 26 from 1 to k
        for(int i=0;i<26;i++){
            characters[i]+=h;
            if(i<=h1)
                characters[i]++;
        }

       int i=0;
        while(i<s.length()){
            if(s.charAt(i)==t.charAt(i)){
                i++;
            }else{
                int diff=((t.charAt(i)-s.charAt(i))+26)%26;
                characters[diff]--;
                    if(characters[diff]<0)
                        return false;
                else  
                    i++;
            }
            
        }
        return true;
    }
}