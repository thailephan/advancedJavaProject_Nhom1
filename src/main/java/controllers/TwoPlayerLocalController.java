package controllers;

import static javax.swing.BorderFactory.createLineBorder;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.swing.*;

import jaco.mp3.player.MP3Player;

//import Set.User;
import components.board.BoardButtonTile;
import components.frame.DrawResultFrame;
import components.frame.WinnerResultFrame;
import utils.constants.PrimitiveConstants;
import utils.constants.ResourceConstants;
import utils.wincheck.CheckWinHelper;
import utils.wincheck.CheckWinType;
import views.BaseView;
import views.TwoPlayerLocalView;

public class TwoPlayerLocalController extends BaseController {

	private TwoPlayerLocalView twoPlayerLocalView;
	
    private BoardButtonTile boardButtonTile[][];
    private boolean tick[][];
    private int iUndo[];
    private int jUndo[];
    private int sizeUndo;
    
    private SettingController setting;
    private IntroController intro;
    
//    private User user;
    private boolean choosePlayer = false;
    private boolean isStart = false;
    private boolean flag = true;
    private boolean isSettingSelected = false;
    private boolean isGameMenuEnabled = false;
    private ButtonGroup btnGroupSound, btnGroupTimer;
    private boolean isRadioTimerEnabled;

    private Timer timerPlayer1, timerPlayer2;
    private int minute1, minute2, second1, second2, miniSecond1, miniSecond2;
    private boolean isTickSoundEnabled = true;
    private boolean isTimeCountDownEnabled = true; 
    
    private MP3Player mp3PlayerTickSound;
    
    WinnerResultFrame winnerResultFrame;

    public static int r = PrimitiveConstants.BOARDROW, c = PrimitiveConstants.BOARDCOLUMN;
    public static int count = 0;
    public static boolean isIconUsed = false;
    public static String crossO = PrimitiveConstants.O, crossX = PrimitiveConstants.X;
    public static Color colorO = Color.GREEN, colorX = Color.RED, colorBoard = Color.WHITE;
    public static ImageIcon icoO = new ImageIcon(), icoX = new ImageIcon();

    public TwoPlayerLocalController() {
    	this.twoPlayerLocalView = new TwoPlayerLocalView();
    	initView();
    	initBoard();
    	initController();
    }
    
	@Override
	void initController() {
		btnNewGame.addActionListener(e -> handleButtonNewGameClicked());
		btnUndo.addActionListener(e -> handleButtonUndoClicked());
		btnSetting.addActionListener(e -> handleButtonSettingClicked());
		btnMenu.addActionListener(e -> handleButtonMenuClicked());
		btnList.addActionListener(e -> handleButtonListClicked());
	
		radioOnSound.addActionListener(e -> handleRadioOnSound());
		radioOffSound.addActionListener(e -> handleRadioOffSound());
		radioOnTimer.addActionListener(e -> handleRadioOnTimer());
		radioOffTimer.addActionListener(e-> handleRadioOffTimer());
	}

	public void initBoard() {
        boardButtonTile = new BoardButtonTile[r][c];
        tick = new boolean[r][c];
        iUndo = new int[r * c];
        jUndo = new int[r * c];
        sizeUndo = 0;
        isStart = false;
        this.btnUndo.setEnabled(false);
        btnGroupTimer = new ButtonGroup();
        btnGroupTimer.add(radioOnTimer);
        btnGroupTimer.add(radioOffTimer);
        btnGroupSound = new ButtonGroup();
        btnGroupSound.add(radioOnSound);
        btnGroupSound.add(radioOffSound);
        radioOnTimer.setSelected(true);
        this.setTime(true);
        isRadioTimerEnabled = true;
        radioOnSound.setSelected(true);
        this.setMusic(true);
        int i, j;
        int x = 0, y = 0;
        for (i = 0; i < r; i++) {
            for (j = 0; j < c; j++) {
                boardButtonTile[i][j] = new BoardButtonTile(x, y, i, j);
                boardButtonTile[i][j].addActionListener(e -> handleBoardGameButtonTileClicked(e));
                panelBoardGame.add(boardButtonTile[i][j]);
                tick[i][j] = false;
                x += 50;
                iUndo[j] = jUndo[j] = -1;
            }
            y += 50;
            x = 0;
        }
        this.resetTimer();
        mp3PlayerTickSound = new MP3Player(getClass().getClassLoader().getResource(ResourceConstants.AUIOTIENGTING));
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

    public void pauseGame() {
        for (int i = 0; i < r; i++) {
            for (int j = 0; j < c; j++) {
                boardButtonTile[i][j].setBackground(Color.GRAY);
                tick[i][j] = false;
            }
        }
        //this.resetTimer();
        this.isStart = false;
        timerPlayer1.stop();
        timerPlayer2.stop();
        this.resetAllBorder(); 
        this.setButtonEnabled(false);
        this.btnSetting.setEnabled(true);
        this.radioOnTimer.setEnabled(true);
        this.radioOffTimer.setEnabled(true);
        isRadioTimerEnabled = true;
        this.btnMenu.setEnabled(true);
        this.isGameMenuEnabled = true;
    }

    public void startGame() {
        for (int i = 0; i < r; i++) {
            for (int j = 0; j < c; j++) {
                boardButtonTile[i][j].setBackground(Color.WHITE);
                tick[i][j] = true;
                boardButtonTile[i][j].setText("");
                boardButtonTile[i][j].setIcon(null);
//                if (!isIconUsed){
//                   boardButtonTile[i][j].setText("");
//                }else{
//                   boardButtonTile[i][j].setIcon(null);
//                   boardButtonTile[i][j].setIcon(new ImageIcon());
//                }
            }
        }
        panelBoardGame.setBackground(colorBoard);
        this.btnSetting.setEnabled(false);
        this.flag = true;
        this.isStart = true;
        this.isSettingSelected=true;
        timerPlayer1.stop();
        timerPlayer2.stop();
        this.resetTimer();
        if (isTimeCountDownEnabled == true) {
            timerPlayer1.start();
        }
        this.resetAllBorder();
        if (count == 0) {
            btnPlayerAvatar1.setBorder(createLineBorder(new Color(38, 208, 254), 3));
        } else {
            btnPlayerAvatar2.setBorder(createLineBorder(new Color(38, 208, 254), 3));
        }
        this.setButtonEnabled(true);
    }

    public void undoGame() {
        boardButtonTile[iUndo[sizeUndo - 1]][jUndo[sizeUndo - 1]].setText("");
        tick[iUndo[sizeUndo - 1]][jUndo[sizeUndo - 1]] = true;
        sizeUndo--;
    }

    public void undoGameIcon() {
        boardButtonTile[iUndo[sizeUndo - 1]][jUndo[sizeUndo - 1]].setIcon(null);
        tick[iUndo[sizeUndo - 1]][jUndo[sizeUndo - 1]] = true;
        sizeUndo--;
    }

    public String whoIsWinner(boolean t) {
        if (t) {
            if (count == 0) {
                return lblPlayerName1.getText();
            } else {
                return lblPlayerName2.getText();
            }
        } else {
            if (count == 1) {
                return lblPlayerName1.getText();
            } else {
                return lblPlayerName2.getText();
            }
        }
    }

    public void setButtonEnabled(boolean kt) {

        this.btnUndo.setEnabled(kt);
    }

    public void setPlayerData() { 
        this.choosePlayer = true;
//        lblPlayerName1.setText(User.ten1);
//        lblPlayerName2.setText(User.ten2);
//        lblPlayerWinScore1.setText("Score: " + User.diem1);
//        lblPlayerWinScore2.setText("Score: " + User.diem2);
    }

//    public User getUser() {
//        return this.user;
//    }

    public boolean getChoosePlayer() {
        return this.choosePlayer;
    }

    public void setMusic(boolean a) {
        this.isTickSoundEnabled = a;
    }

    public void setTime(boolean a) {
        this.isTimeCountDownEnabled = a;
    }

    public Timer setTimePlayer(int mili, final int m, final int s, final int k, final JLabel lb) {
        Timer timer = new Timer(mili, new ActionListener() {
            private int minute = m, second = s, miniSecond = k;
            private JLabel lbTimer = lb;
            private int dem = 0;

            public void actionPerformed(ActionEvent ex) {
                String phut = "0", giay = "", khac = "";
                if (minute == 0 && second == 0) {
                    lbTimer.setText("00:00:00");
                    String winner;
                    winner = whoIsWinner(false);
                    winnerResultFrame = new WinnerResultFrame(winner);
                    if (winner.equals(lblPlayerName1.getText())) {
                        scorePlus(true);
                    } else {
                        scorePlus(false);
                    }
                    //JOptionPane.showMessageDialog(new JDialog(),whoIsWinner(false) +" inputStreamBufferedReader winner");
                    pauseGame();
                    flag = false;
                    return;
                } else {
                    if (miniSecond == 0) {
                        second--;
                        miniSecond = 100;
                    }
                    miniSecond--;
                    if (second == 0) {
                        minute--;
                        second = 59;
                    }
                    phut = phut + minute; 
                    if (miniSecond < 10) {
                        khac = "0" + miniSecond;
                    } else {
                        khac = Integer.toString(miniSecond);
                    }
                    if (second < 10) {
                        giay = "0" + second;
                    } else {
                        giay = Integer.toString(second);
                    }
                    lbTimer.setText(phut + ":" + giay + ":" + khac);
                }
            }
        });
        return timer; 
    }

    public void resetTimer() { 
        lblPlayerTimerCountDownTime1.setText("05:00:00");
        lblPlayerTimerCountDownTime2.setText("05:00:00");
        minute1 = minute2 = 5;
        second1 = second2 = 0;
        miniSecond1 = miniSecond2 = 100;
        timerPlayer1 = this.setTimePlayer(10, minute1, second1, miniSecond1, lblPlayerTimerCountDownTime1);
        timerPlayer2 = this.setTimePlayer(10, minute2, second2, miniSecond2, lblPlayerTimerCountDownTime2);
    }

    public void setBorderPlayer() {
        if (count == 1) {
            btnPlayerAvatar1.setBorder(createLineBorder(new Color(38, 208, 254), 3));
        } else {
            btnPlayerAvatar2.setBorder(createLineBorder(new Color(38, 208, 254), 3));
        }
    }

    public void resetBorderPlayer() { 
        if (count == 0) {
            btnPlayerAvatar1.setBorder(createLineBorder(new Color(0, 0, 0), 3));
        } else {
            btnPlayerAvatar2.setBorder(createLineBorder(new Color(0, 0, 0), 3));
        }
    }

    public void resetAllBorder() { 
        btnPlayerAvatar1.setBorder(createLineBorder(new Color(0, 0, 0), 3));
        btnPlayerAvatar2.setBorder(createLineBorder(new Color(0, 0, 0), 3));
    }

    public void setMenuController(IntroController a) {
    	this.intro = (IntroController) a;
    }

//    public void setUserController(JFrame a) {
//        this.user = (User) a;
//    }

    public void setSettingController(SettingController a){
        this.setting = (SettingController) a;
    }
    
    public void continueTimer() {
        if (isTimeCountDownEnabled == true) {
            if (count == 0) {
                this.timerPlayer1.start();
            } else {
                this.timerPlayer2.start();
            }
        }
    }

    public JButton getNewGame() {
        return this.btnNewGame;
    }

    public void scorePlus(boolean kt) {
//        if (kt) {
//            User.diem1++;
//            lblPlayerWinScore1.setText("Score: " + User.diem1);
//        } else {
//            User.diem2++;
//            lblPlayerWinScore2.setText("Score: " + User.diem2);
//        }
//        try {
//            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
//            try {
//                Connection conn = DriverManager.getConnection("jdbc:sqlserver://JARVIS\\JARVIS:1433;databaseName=caro;user=sa;password=sa");
//                System.out.println("Connection Successful");
//                Statement st = conn.createStatement();
//                st.executeUpdate("Update DB  set win1 = " + User.diem1 + ",win2 = " + User.diem2 + "where id = " + User.id + ";");
//                System.out.println("Cap nhat thanh cong");
//            } catch (SQLException ex) {
//                Logger.getLogger(User.class.getName()).log(Level.SEVERE, null, ex);
//            }
//        } catch (ClassNotFoundException ex) {
//            Logger.getLogger(User.class.getName()).log(Level.SEVERE, null, ex);
//        }
    }

    public boolean isGameStart() {
        return isStart;
    }

    public boolean isGameDraw() {
        int i, j;
        int found = 0;
        for (i = 0; i < r; i++) {
            for (j = 0; j < c; j++) {
                if (tick[i][j] == false) {
                    found++;
                }
            }
        }
        if (found == r * c) {
            return true;
        }
        return false;
    }

    public void handleBoardGameButtonTileClicked(ActionEvent e) {
        try {
            String evt = new String(e.getActionCommand());
            int flag = evt.indexOf(" ");
            int i = Integer.parseInt(evt.substring(0, flag));
            int j = Integer.parseInt(evt.substring(flag + 1));
            String winner = new String();
            if (count == 0) {
                winner = lblPlayerName1.getText();
            } else {
                winner = lblPlayerName2.getText();
            }
            if (tick[i][j]) {
                this.setBorderPlayer();
                this.resetBorderPlayer();
                this.btnUndo.setEnabled(true);
                Thread play = new Thread() {
                    public void run() {
                        mp3PlayerTickSound.play();
                    }
                };
                if (isTickSoundEnabled) {
                    play.start();
                }
                this.setCheckedCross(i, j);
                if (this.isGameDraw() == true) {
                    DrawResultFrame p = new DrawResultFrame();
                    p.setVisible(true);
                    this.pauseGame();
                    this.flag = false;
                    this.isSettingSelected = false;
                }
                if (isIconUsed) {
                    if (CheckWinHelper.CheckWinPlayer(boardButtonTile, i, j, 5, CheckWinType.ICON)) {
                        //JOptionPane.showMessageDialog(new JDialog(),winner+ " inputStreamBufferedReader winner");
                    	winnerResultFrame = new WinnerResultFrame(winner);
                        if (winner.equals(lblPlayerName1.getText())) {
                            this.scorePlus(true);
                        } else {
                            this.scorePlus(false);
                        }
                        winnerResultFrame.setVisible(true);
                        this.pauseGame();
                        this.flag = false;
                        this.isSettingSelected = false;
                    }
                } else {
                    if (CheckWinHelper.CheckWinPlayer(boardButtonTile, i, j, 5, CheckWinType.TEXT)) {
//                        JOptionPane.showMessageDialog(new JDialog(),winner+ " inputStreamBufferedReader winner");
                    	winnerResultFrame = new WinnerResultFrame(winner);
                        if (winner.equals(lblPlayerName1.getText())) {
                            this.scorePlus(true);
                        } else {
                            this.scorePlus(false);
                        }
                        winnerResultFrame.setVisible(true);
                        this.pauseGame();
                        this.flag = false;
                        this.isSettingSelected = false;
                    }
                }
                if (this.flag == true && isTimeCountDownEnabled == true)
                {
                    if (count == 0) {
                        timerPlayer1.start();
                        timerPlayer2.stop();
                    } else {
                        timerPlayer1.stop();
                        timerPlayer2.start();
                    }
                }
                if (this.flag == false) {
                    this.btnList.setEnabled(true);
                }
            }

        } catch (Exception ex) {
            System.out.println(ex);
        }

    }

    private void handleButtonNewGameClicked() {
        count = 0;
        startGame();
        this.btnUndo.setEnabled(false);
        this.btnList.setEnabled(false);
        this.radioOnTimer.setEnabled(false);
        this.radioOffTimer.setEnabled(false);
        isRadioTimerEnabled = false;
        this.btnMenu.setEnabled(false);
        this.isGameMenuEnabled = false;
    }

    private void handleButtonUndoClicked() {
        if (sizeUndo > 0 && flag) {
            if (!isIconUsed) {
                this.undoGame();
            } else {
                this.undoGameIcon();
            }
            count = 1 - count;
            if (isTimeCountDownEnabled == true) {
                if (count == 0) {
                    timerPlayer1.start();
                    timerPlayer2.stop();
                } else {
                    timerPlayer1.stop();
                    timerPlayer2.start();
                }
            }
        }
    }

    private void handleButtonSettingClicked() {
        if (this.isSettingSelected == false) {
            if (IntroController.isSettingSelected==false){
                setting = new SettingController();
                IntroController.isSettingSelected = true;
                intro.setSettingController(setting);
            }
            setting.getView().setVisible(true);
//            this.user.setVisible(false);
            SettingController.classReturn = 1;
            setting.setBackForm(this);
            this.getView().setVisible(false);
            this.timerPlayer1.stop();
            this.timerPlayer2.stop();
        }
    }

    private void handleButtonMenuClicked() {
        intro.getView().setVisible(true);
        this.getView().setVisible(false);
//        this.user.setVisible(false);
        this.timerPlayer1.stop();
        this.timerPlayer2.stop();
    }
    
    private void handleButtonListClicked() {
        if (this.isSettingSelected == false) {
//            this.user.setTable();
//            this.user.setVisible(true);
            this.timerPlayer1.stop();
            this.timerPlayer2.stop();
        }
    }
    
    private void handleRadioOnTimer() {
        if (this.radioOnTimer.isSelected() && isRadioTimerEnabled == true) {
            this.setTime(true);
        }
    }
    
    private void handleRadioOffTimer() {
        if (radioOffTimer.isSelected() && isRadioTimerEnabled == true) {
            this.setTime(false);
        }
    }
    
    private void handleRadioOnSound() {
        if (radioOnSound.isSelected()) {
            this.setMusic(true);
        }
    }
    
    private void handleRadioOffSound() {
        if (radioOffSound.isSelected()) {
            this.setMusic(false);
        }
    }
    
    public static void main(String args[]) {
        try {
            for (UIManager.LookAndFeelInfo info : UIManager.getInstalledLookAndFeels()) {
                if (PrimitiveConstants.NIMBUS.equals(info.getName())) {
                    UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(TwoPlayerLocalController.class.getName()).log(Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            Logger.getLogger(TwoPlayerLocalController.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            Logger.getLogger(TwoPlayerLocalController.class.getName()).log(Level.SEVERE, null, ex);
        } catch (UnsupportedLookAndFeelException ex) {
            Logger.getLogger(TwoPlayerLocalController.class.getName()).log(Level.SEVERE, null, ex);
        }
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                new TwoPlayerLocalController().getView().setVisible(true);
            }
        });
    }
    

	@Override
	BaseView getView() {
		return this.twoPlayerLocalView;
	}
	
	@Override
	void initView() {
		btnList = twoPlayerLocalView.getBtnList();
	    btnMenu = twoPlayerLocalView.getBtnMenu();
	    btnNewGame = twoPlayerLocalView.getBtnNewGame();
	    btnPlayerAvatar1 = twoPlayerLocalView.getBtnPlayerAvatar1();
	    btnPlayerAvatar2 = twoPlayerLocalView.getBtnPlayerAvatar2();
	    btnSetting = twoPlayerLocalView.getBtnSetting();
	    btnUndo = twoPlayerLocalView.getBtnUndo();
	    lblPlayerName1 = twoPlayerLocalView.getLblPlayerName1();
	    lblPlayerName2 = twoPlayerLocalView.getLblPlayerName2();
	    lblPlayerWinScore1 = twoPlayerLocalView.getLblPlayerWinScore1();
	    lblPlayerWinScore2 = twoPlayerLocalView.getLblPlayerWinScore2();
	    lblPlayerTimerCountDownTime1 = twoPlayerLocalView.getLblPlayerTimerCountDownTime1();
	    lblPlayerTimerCountDownTime2 = twoPlayerLocalView.getLblPlayerTimerCountDownTime2();
	    panelBoardGame = twoPlayerLocalView.getPanelBoardGame();
	    radioOffSound = twoPlayerLocalView.getRadioOffSound();
	    radioOffTimer = twoPlayerLocalView.getRadioOffTimer();
	    radioOnSound = twoPlayerLocalView.getRadioOnSound();
	    radioOnTimer = twoPlayerLocalView.getRadioOnTimer();
	}

    private JButton btnList;
    private JButton btnMenu;
    private JButton btnNewGame;
    private JButton btnPlayerAvatar1;
    private JButton btnPlayerAvatar2;
    private JButton btnSetting;
    private JButton btnUndo;
    private JLabel lblPlayerName1;
    private JLabel lblPlayerName2;
    private JLabel lblPlayerWinScore1;
    private JLabel lblPlayerWinScore2;
    private JLabel lblPlayerTimerCountDownTime1;
    private JLabel lblPlayerTimerCountDownTime2;
    private JPanel panelBoardGame;
    private JRadioButton radioOffSound;
    private JRadioButton radioOffTimer;
    private JRadioButton radioOnSound;
    private JRadioButton radioOnTimer;
}
