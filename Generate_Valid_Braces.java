class BalancedBraceRepresentation{
    public List<String> balancedBraces(int n){
        List<String> balancedBracesList = new ArrayList<String>();
        if(n<=0){
            return balancedBracesList;
        }
        
        generateValidBraces(n, balancedBracesList, 0, 0, "");
        return balancedBracesList;
    }
    
    
public void generateValidBraces(int n, List<String> balancedBracesList, int openBraces, int closedBraces, String currentCombination){
        if(open==close==0){
            balancedBracesList.add("");
        }
        if(open < close){
            generateValidBraces(n, balancedBracesList, open, close-1,currentCombination+")");
            generateValidBraces(n, balancedBracesList, open-1, close, currentCombination+"(");
        }
        return ;
    }
}
