public class Solver {
    private final Board boardInstance;
    public Solver(Board board){ this.boardInstance = board; }

    public void solveBoard() { solve(boardInstance.getBoard()); }


    public boolean solve(int[][] board) {
        //find next empty cell
        int row = -1, col = -1;
        boolean movesLeft = false;
        for(int i = 0; i < 9; i++){
            for(int j = 0; j < 9; j++) {
                if(board[i][j] == 0) {
                    movesLeft = true;
                    row = i;
                    col = j;
                    break;
                }
                if(movesLeft)
                    break;
            }
        }

        if(!movesLeft)
            return true;
        
        for(int val = 1; val <= 9; val++) {
            if(boardInstance.isValid(row, col, val)) {
                board[row][col] = val;
                if(solve(board))
                    return true;
                else
                    board[row][col] = 0;
            }
        }
        return false;
    }
}