import java.util.Scanner;

public class Board {
    private final int BOARD_SIZE = 9;
    int[][] board;

    public Board(int[][] board) {
        this.board = board;
    }

    private boolean isEmpty(int row, int col) {
        return board[row][col] == 0;
    }

    public void makeMove(int row, int col, int val) {
        if(isEmpty(row, col) && isValid(row, col, val))
            board[row][col] = val;
        else
            System.out.println("invalid move");
    }

    private boolean isValid(int row, int col, int cellVal) {

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
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int[][] b = {
            {0,0,0, 2,6,0, 7,0,1},
            {6,8,0, 0,7,0, 0,9,0},
            {1,9,0, 0,0,4, 5,0,0},

            {8,2,0, 1,0,0, 0,4,0},
            {0,0,4, 6,0,2, 9,0,0},
            {0,5,0, 0,0,3, 0,2,8},

            {0,0,9, 3,0,0, 0,7,4},
            {0,4,0, 0,5,0, 0,3,6},
            {7,0,3, 0,1,8, 0,0,0}
        };

        Board board = new Board(b);
        while(true) {
            int row = input.nextInt();
            int col = input.nextInt();
            int val = input.nextInt();
            board.makeMove(row, col, val);
        }
    }
}