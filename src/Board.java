import java.util.Scanner;

public class Board {
    public final int BOARD_SIZE = 9;
    private int[][] board;

    public Board(int[][] board) {
        this.board = board;
    }

    public boolean isEmpty(int row, int col) {
        return board[row][col] == 0;
    }

    public int[][] getBoard() { return board; }

    public void makeMove(int row, int col, int val) {
        if(isEmpty(row, col))
            board[row][col] = val;
        else
            System.out.println("invalid move");
    }

    public boolean isValid(int row, int col, int cellVal) {

        for(int i = 0; i < BOARD_SIZE; i++){
            if(i == col)
                continue;
            if(cellVal == board[row][i])
                return false;
        }
        
        for(int i = 0; i < BOARD_SIZE; i++){
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
        for(int row = 0; row < BOARD_SIZE; row++) {
            for(int col = 0; col < BOARD_SIZE; col++) {
                if(col % 3 == 0 && col != 0)
                    System.out.print("  ");
                System.out.print(board[row][col] + ",");
            }
            System.out.println();
            if(row == 2 || row == 5)
                System.out.println();
        }
    }

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int[][] grid = { 
            {3, 0, 6, 5, 0, 8, 4, 0, 0}, 
            {5, 2, 0, 0, 0, 0, 0, 0, 0}, 
            {0, 8, 7, 0, 0, 0, 0, 3, 1}, 
            {0, 0, 3, 0, 1, 0, 0, 8, 0}, 
            {9, 0, 0, 8, 6, 3, 0, 0, 5}, 
            {0, 5, 0, 0, 9, 0, 6, 0, 0}, 
            {1, 3, 0, 0, 0, 0, 2, 5, 0}, 
            {0, 0, 0, 0, 0, 0, 0, 7, 4}, 
            {0, 0, 5, 2, 0, 6, 3, 0, 0} 
        };


        Board board = new Board(grid);
        Solver boardSolver = new Solver(board);
        boardSolver.solveBoard();
        board.printBoard();
    }
}
