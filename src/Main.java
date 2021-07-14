import java.util.Scanner;

import javax.swing.JFrame;

public class Main {
    public static void main(String[] args) throws InterruptedException{
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
        UI ui = new UI(board);
        Solver solver = new Solver(board, ui);
        solver.show();
        int pause = input.nextInt();
        solver.solveBoard();
    }
}