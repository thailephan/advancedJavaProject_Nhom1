package components.board;

import javax.swing.*;

import controllers.TwoPlayerLocalController;
import utils.constants.PrimitiveConstants;

public class BoardGame extends JPanel{
	public BoardGame() {
		boardButtonTile = new BoardButtonTile[r][c];
        tick = new boolean[r][c];
        iUndo = new int[r * c];
        jUndo = new int[r * c];
        sizeUndo = 0;
	}
	
	public void initBoardGame() {
        int i, j;
        int x = 0, y = 0;
		for (i = 0; i < r; i++) {
            for (j = 0; j < c; j++) {
                boardButtonTile[i][j] = new BoardButtonTile(x, y, i, j);
                boardButtonTile[i][j].addActionListener(e -> handleBoardGameButtonTileClicked(e));
                add(boardButtonTile[i][j]);
                tick[i][j] = false;
                x += 50;
                iUndo[j] = jUndo[j] = -1;
            }
            y += 50;
            x = 0;
        }
	}
	
	public void setCheckedCross(int i, int j) {
        if (!isIconUsed) {
            if (count == 0) {
                boardButtonTile[i][j].setText(crossO);
                boardButtonTile[i][j].setForeground(colorO);
                tick[i][j] = false;

            } else {
                boardButtonTile[i][j].setText(crossX);
                boardButtonTile[i][j].setForeground(colorX);
                tick[i][j] = false;

            }
        } else {
            if (count == 0) {
                boardButtonTile[i][j].setIcon(TwoPlayerLocalController.icoO);
                tick[i][j] = false;
            } else {
                boardButtonTile[i][j].setIcon(TwoPlayerLocalController.icoX);
                tick[i][j] = false;
            }
        }
        iUndo[sizeUndo] = i;
        jUndo[sizeUndo] = j;
        sizeUndo++;
        count = 1 - count;
    }
	
	public static int r = PrimitiveConstants.BOARDROW, c = PrimitiveConstants.BOARDCOLUMN;
	private BoardButtonTile boardButtonTile[][];
    private boolean tick[][];
    private int iUndo[];
    private int jUndo[];
    private int sizeUndo;
}
