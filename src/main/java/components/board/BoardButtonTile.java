package components.board;

import java.awt.Color;
import java.awt.Font;
import java.awt.Point;

import javax.swing.JButton;

public class BoardButtonTile extends JButton{
	private int xPosition, yPosition;
	public BoardButtonTile(int xPosition, int yPosition, int row, int col) {
		setSize(50, 50);
        setVisible(true);
        setLocation(new Point(xPosition, yPosition));
        setBackground(Color.GRAY);
        setFont(new Font("Lato", 1, 28));
        setActionCommand(row + " " + col);
	}
	public int getxPosition() {
		return xPosition;
	}
	public void setxPosition(int xPosition) {
		this.xPosition = xPosition;
	}
	public int getyPosition() {
		return yPosition;
	}
	public void setyPosition(int yPosition) {
		this.yPosition = yPosition;
	}
}
