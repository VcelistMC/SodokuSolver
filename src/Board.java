

public class Board {
    public final int GRID_SIZE = 9;
    public final int SUBGRID_SIZE = 3;
    private int[][] board;

    public Board(int[][] board) {
        this.board = board;
    }

    public boolean isEmpty(int row, int col) {
        return board[row][col] == 0;
    }

    public int[][] getBoard() { return board; }

    public void makeMove(int row, int col, int val) {
        board[row][col] = val;
    }

    public int getCell(int row, int col){ return board[row][col]; }

    public boolean isValid(int row, int col, int cellVal) {

        for(int i = 0; i < GRID_SIZE; i++){
            if(i == col)
                continue;
            if(cellVal == board[row][i])
                return false;
        }
        
        for(int i = 0; i < GRID_SIZE; i++){
            if(i == row)
                continue;
            if(cellVal == board[i][col])
                return false;
        }

        int currentRowBlock = (row / 3) * 3;
        int currentColBlock = (col / 3) * 3;

        for(int i = currentRowBlock; i < currentRowBlock + 3; i++) {
            for(int j = currentColBlock; j < currentColBlock + 3; j++) {
                if(i == row && j == col)
                    continue;
                if(cellVal == board[i][j])
                    return false;
            }
        }
        return true;
    }

    public void printBoard() {
        for(int row = 0; row < GRID_SIZE; row++) {
            for(int col = 0; col < GRID_SIZE; col++) {
                if(col % 3 == 0 && col != 0)
                    System.out.print("  ");
                System.out.print(board[row][col] + ",");
            }
            System.out.println();
            if(row == 2 || row == 5)
                System.out.println();
        }
    }
}
