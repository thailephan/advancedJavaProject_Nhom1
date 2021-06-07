package utils.wincheck;

import javax.swing.JButton;

import utils.constants.PrimitiveConstants;

public class CheckWinHelper {
	private static CheckWinPlayer check;
	
	public static boolean CheckWinPlayer(JButton b[][], int i, int j, int line, CheckWinType type) {
		if(type == CheckWinType.ICON) {
			System.out.println(PrimitiveConstants.CHECKICONTYPE);
			check = new IconCheckWinPlayerImpl();
		} 
		else		
		if(type == CheckWinType.TEXT) {
			System.out.println(PrimitiveConstants.CHECKTEXTTYPE);
			check = new TextCheckWinPlayerImpl();
		}
		
		return check.winCheck(b, i, j, line);
	}
}
