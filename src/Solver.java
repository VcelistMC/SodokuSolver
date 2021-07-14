import java.awt.Dimension;

import javax.swing.JFrame;


public class Solver {
    private final Board boardInstance;
    private final UI ui;
    public Solver(Board board, UI ui){ 
        this.boardInstance = board;
        this.ui = ui;
    }

    public void solveBoard() { solve(boardInstance.getBoard()); }


    public boolean solve(int[][] board) {
        try{
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
                }
            if(movesLeft)
                break;
            }

            if(!movesLeft)
                return true;
            
            for(int val = 1; val <= 9; val++) {
                if(boardInstance.isValid(row, col, val)) {
                    ui.makeMove(row, col, val);
                    if(solve(board))
                        return true;
                    else
                        ui.makeMove(row, col, 0);
                }
            }
            return false;
        }
        catch(Exception e) {
            System.out.println("Bruh");
            return false;
        }
    }

    public void show() {
        JFrame j = new JFrame();
        j.add(ui);
        j.setMinimumSize(new Dimension(UI.UI_HEIGHT, UI.UI_WIDTH));
        j.setVisible(true);
    }
}