import java.awt.*;
import javax.swing.*;


public class UI extends JPanel{
    private Board boardInstance;
    public static int CELL_SIZE = 60;
    public static int GRID_SIZE, SUBGRID_SIZE;
    public static int UI_WIDTH, UI_HEIGHT;
    private Cell cells[][];

    public UI(Board board) {
        boardInstance = board;
        UI_HEIGHT = CELL_SIZE * GRID_SIZE;
        UI_WIDTH = CELL_SIZE * GRID_SIZE;
        GRID_SIZE = boardInstance.GRID_SIZE;
        SUBGRID_SIZE = GRID_SIZE;
        cells = new Cell[GRID_SIZE][GRID_SIZE];

        super.setLayout(new GridLayout(GRID_SIZE, GRID_SIZE));
        for(int i = 0; i < GRID_SIZE; i++) {
            for(int j = 0; j < GRID_SIZE; j++) {
                cells[i][j] = new Cell(i, j);
                int val = boardInstance.getCell(i, j);
                if(val != 0) {
                    cells[i][j].writeVal(boardInstance.getCell(i, j));
                    cells[i][j].setState(CellStatus.CLUE);
                }
                super.add(cells[i][j]);
            }
        }
    }
    public void makeMove(int row, int col, int val) throws InterruptedException {
        Cell currCell = cells[row][col];
        currCell.writeVal(val);
        boardInstance.makeMove(row, col, val);
        if(val != 0) {
            currCell.setState(CellStatus.CORRECT);
        }
        else {
            currCell.setState(CellStatus.WRONG);
            Thread.sleep(10);
            currCell.setState(CellStatus.EMPTY);
            boardInstance.makeMove(row, col, 0);
        }
        Thread.sleep(45);
    }
}
