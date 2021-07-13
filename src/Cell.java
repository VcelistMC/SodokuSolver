import java.awt.Color;
import java.awt.Font;
import javax.swing.JTextField;

public class Cell extends JTextField{
    public static final Color BG_SHOWN = new Color(240, 240, 240);
    public static final Color FG_SHOWN = Color.black;
    public static final Color BG_CORRECT_GUESS = new Color(0, 216, 0);
    public static final Color BG_WRONG_GUESS = new Color(216, 0, 0);
    public static final Font FONT_NUMBERS = new Font("Monospaced", Font.BOLD, 24);

    int row, col;
    int value;
    CellStatus state;
    
    public Cell(int row, int col, boolean isEmpty) {
        super();
        this.row = row;
        this.col = col;
        this.state = isEmpty? CellStatus.CLUE : CellStatus.EMPTY;
        super.setHorizontalAlignment(JTextField.CENTER);
        super.setFont(FONT_NUMBERS);
        super.setForeground(FG_SHOWN);
    }

    public void write(int val) {
        this.value = val;
    }

    private void changeColor() {
        if(state == CellStatus.CORRECT) {
            super.setText(value + "");
            super.setEditable(false);
            super.setBackground(BG_CORRECT_GUESS);
        }
        else if(state == CellStatus.EMPTY) {
            super.setText("");
            super.setEditable(true);
            super.setBackground(BG_SHOWN);
        }
    }

    public void setState(CellStatus status) {
        this.state = status;
        changeColor();
    }
}
