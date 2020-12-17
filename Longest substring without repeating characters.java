class Solution {
    public int lengthOfLongestSubstring(String s) {
        int max = Integer.MIN_VALUE;
        HashSet<Character> set = new HashSet<Character>();
        int i=0, j=0;
        while(i< s.length()){
         char c =s.charAt(i);
            while(set.contains(c)){
                set.remove(s.charAt(j));
                j++;
            }
            set.add(c);
            max = Math.max(i-j+1, max);
            i++;
        }
        return max;
    }
}
