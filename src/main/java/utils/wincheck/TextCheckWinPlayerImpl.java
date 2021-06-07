package utils.wincheck;

import javax.swing.JButton;

import controllers.TwoPlayerLocalController;

public class TextCheckWinPlayerImpl implements CheckWinPlayer {

	@Override
	public boolean winCheck(JButton b[][], int i, int j, int line) {
		int countX = 1, countY = 1, countXY = 1, countYX = 1; 
        int x = i, y = j, n = 0;
        int row = TwoPlayerLocalController.r, column = TwoPlayerLocalController.c;
        String cross = "";
        if (TwoPlayerLocalController.count != 0) {
            cross = TwoPlayerLocalController.crossO;
        } else {
            cross = TwoPlayerLocalController.crossX;
        }

        x = i - 1;
        while (x < row && x >= 0 && y >= 0 && y < column && n < 4) { 
            if (cross.equals(b[x][y].getText())) {
                countX++;
            } else {
                break;
            }
            x--; 
            n++;
        }
        n = 0;
        x = i + 1;
        while (x < row && x >= 0 && y >= 0 && y < column && n < 4) {
            if (cross.equals(b[x][y].getText())) {
                countX++;
            } else {
                break;
            }
            x++;
            n++;
        }
        if (countX >= 5) {
            return true;
        }

        //ngang
        n = 0;
        x = i;
        y = j - 1;
        while (x < row && x >= 0 && y >= 0 && y < column && n < 4) {
            if (cross.equals(b[x][y].getText())) {
                countY++;
            } else {
                break;
            }
            y--;
            n++;
        }
        n = 0;
        y = j + 1;
        while (x < row && x >= 0 && y >= 0 && y < column && n < 4) {
            if (cross.equals(b[x][y].getText())) {
                countY++;
            } else {
                break;
            }
            y++;
            n++;
        }
        if (countY >= 5) {
            return true;
        }

        //xuyen phai
        n = 0;
        x = i + 1;
        y = j + 1;
        while (x < row && x >= 0 && y >= 0 && y < column && n < 4) {
            if (cross.equals(b[x][y].getText())) {
                countYX++;
            } else {
                break;
            }
            x++;
            y++;
            n++;
        }
        n = 0;
        x = i - 1;
        y = j - 1;
        while (x < row && x >= 0 && y >= 0 && y < column && n < 4) {
            if (cross.equals(b[x][y].getText())) {
                countYX++;
            } else {
                break;
            }
            x--;
            y--;
            n++;
        }
        if (countYX >= 5) {
            return true;
        }

        //xuyen trai
        n = 0;
        x = i - 1;
        y = j + 1;
        while (x < row && x >= 0 && y >= 0 && y < column && n < 4) { 
            if (cross.equals(b[x][y].getText())) {
                countXY++;
            } else {
                break;
            }
            x--;
            y++;
            n++;
        }
        n = 0;
        x = i + 1;
        y = j - 1;
        while (x < row && x >= 0 && y >= 0 && y < column && n < 4) {
            if (cross.equals(b[x][y].getText())) {
                countXY++;
            } else {
                break;
            }
            x++;
            y--;
            n++;
        }
        if (countXY >= 5) { 
            return true;
        }
        return false;
	}

}
