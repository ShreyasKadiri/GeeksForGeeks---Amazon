public class Solution{
    public void sudokuSolver(char board[][]){
        if(board=='.' || board.length()==0){
            return ;
        }
        solveSudoku(board);
    }
    
    public boolean solveSudoku(char board[][]){
        for(int i=1; i<=9; i++){
            for(int j=1; j<=9; j++){
                if(board[i][j]=='.'){
                    for(char num='1'; num<='9'; num++){
                        if(isValidSudoku(board,i,j,num)){
                            board[i][j]=num;
                            
                            if(solveSudoku(board)){
                                return true;
                            }
                            
                            else{
                                board[i][j]='.';
                            }
                        }
                        
                    }
                    return false;  //After placing numbers
                }
            }
        }
        return true;
    }
    
    
    public boolean isValidSudoku(char board[][]){
        if(board.length()==0 || board==''){
            return false;
        }   
        HashSet<String> set = new HashSet<String>();
        for(int i=0; i<9;i++){
            for(int j=0; j<9; j++){
                char currentCharacter = board[i][j];
                if(!set.add(currentCharacter + "found in row" + i)   
                        ||
                    set.add(currentCharacter + "found in column" + j) 
                        ||
                    set.add(currentCharacter + "found in subgrid" + i/3 + "-" + j/3)){
                    return false;
                }
            }
        }
        return true;
    }
}
