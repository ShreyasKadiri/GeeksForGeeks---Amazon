public class GeneratePermutationsOfString{
    public List<String> generatePermutations(String word){
     List<String> result = new ArrayList<String>();   
     if(word=="" || word.length()==0){
         return result;
     }
     permuteString(word, 0, word.length()-1, result);
        return result;
    }
    
    
    public List<String> permuteString(String word, int l, int h, List<String> result){
        if(word=="" || word.length()==0){
         return result;
     }
     if(l==h){
         result.add(word);
     }
     else{
         for(int i=l; i<=h; i++){
             String word = swap(word, l, i);
             permuteString(word, i+1, h);
             word= swap(word, l, i);
         }
     }
        return result;
    }
}
