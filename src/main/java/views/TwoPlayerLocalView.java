package views;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.border.*;

import components.twoplayer.PlayerPanel;
import utils.constants.ResourceConstants;
import utils.constants.PrimitiveConstants;

public class TwoPlayerLocalView extends BaseView {
	public TwoPlayerLocalView() {
		super();
	}
	
	@Override
	protected void initNewJComponents() {
		panelRoot = new JPanel();
        panelBoardGame = new JPanel();
        btnNewGame = new JButton();
        btnUndo = new JButton();
        btnSetting = new JButton();
        btnMenu = new JButton();
        btnList = new JButton();
        lblIconCaro = new JLabel();
        lblCaroXTitle = new JLabel();
        panelTimeRadioGroup = new JPanel();
        radioOnTimer = new JRadioButton();
        radioOffTimer = new JRadioButton();
        panelSoundRadioGroup = new JPanel();
        radioOnSound = new JRadioButton();
        radioOffSound = new JRadioButton();
        lblLinesToWin = new JLabel();
        
        panelPlayer2 = new PlayerPanel();
        lblPlayerWinScore2 = panelPlayer2.getLblPlayerWinScore();
        lblPlayerTimerCountDownTime2 = panelPlayer2.getLblPlayerTimerCountDownTime();
        btnPlayerAvatar2 = panelPlayer2.getBtnPlayerAvatar();
        lblPlayerTimerText2 = panelPlayer2.getLblPlayerTimerText();
        lblPlayerName2 = panelPlayer2.getLblPlayerName();

        panelPlayer1 = new PlayerPanel();
        lblPlayerWinScore1 = panelPlayer1.getLblPlayerWinScore();
        lblPlayerTimerCountDownTime1 = panelPlayer1.getLblPlayerTimerCountDownTime();
        btnPlayerAvatar1 = panelPlayer1.getBtnPlayerAvatar();
        lblPlayerTimerText1 = panelPlayer1.getLblPlayerTimerText();
        lblPlayerName1 = panelPlayer1.getLblPlayerName();
        
        lblCopyRight = new JLabel();
	}
	
	@Override
	protected void initViewComponents() {
		super.initViewComponents();
		
		setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setTitle(PrimitiveConstants.CAROX);
        setBackground(new Color(0, 0, 0));
        setResizable(false);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        panelRoot.setBackground(new Color(255, 255, 255));
        panelRoot.setPreferredSize(new Dimension(1589, 900));
        panelRoot.setRequestFocusEnabled(false);
        panelRoot.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        panelBoardGame.setBackground(new Color(255, 255, 255));
        panelBoardGame.setBorder(BorderFactory.createLineBorder(new Color(38, 208, 254), 2));
        panelBoardGame.setName("");
        panelBoardGame.setPreferredSize(new java.awt.Dimension(1000, 800));

        GroupLayout pn1Layout = new GroupLayout(panelBoardGame);
        panelBoardGame.setLayout(pn1Layout);
        pn1Layout.setHorizontalGroup(
            pn1Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGap(0, 996, Short.MAX_VALUE)
        );
        pn1Layout.setVerticalGroup(
            pn1Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGap(0, 796, Short.MAX_VALUE)
        );

        panelRoot.add(panelBoardGame, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 10, -1, -1));

        btnNewGame.setBackground(new Color(255, 255, 255));
        btnNewGame.setFont(new Font("Lato", 1, 18)); 
        btnNewGame.setForeground(new Color(38, 208, 254));
        btnNewGame.setText(PrimitiveConstants.NEWGAME);
        btnNewGame.setName(""); 
        
        panelRoot.add(btnNewGame, new org.netbeans.lib.awtextra.AbsoluteConstraints(1330, 560, 240, -1));

        btnUndo.setBackground(new Color(255, 255, 255));
        btnUndo.setFont(new Font("Lato", 1, 18)); 
        btnUndo.setForeground(new Color(38, 208, 254));
        btnUndo.setText(PrimitiveConstants.UNDO);
        btnUndo.setName(""); 
        
        panelRoot.add(btnUndo, new org.netbeans.lib.awtextra.AbsoluteConstraints(1330, 600, 240, -1));

        btnSetting.setBackground(new Color(255, 255, 255));
        btnSetting.setFont(new Font("Lato", 1, 18)); 
        btnSetting.setForeground(new Color(38, 208, 254));
        btnSetting.setText(PrimitiveConstants.SETTING);
        btnSetting.setName(""); 
        
        panelRoot.add(btnSetting, new org.netbeans.lib.awtextra.AbsoluteConstraints(1330, 680, 240, -1));

        btnMenu.setBackground(new Color(255, 255, 255));
        btnMenu.setFont(new Font("Lato", 1, 18)); 
        btnMenu.setForeground(new Color(38, 208, 254));
        btnMenu.setText("Menu");
        btnMenu.setName(""); 
        
        panelRoot.add(btnMenu, new org.netbeans.lib.awtextra.AbsoluteConstraints(1330, 640, 240, -1));

        btnList.setBackground(new Color(255, 255, 255));
        btnList.setFont(new Font("Lato", 1, 18)); 
        btnList.setForeground(new Color(38, 208, 254));
        btnList.setText(PrimitiveConstants.LISTBATTLE);
        btnList.setName(""); 
        
        panelRoot.add(btnList, new org.netbeans.lib.awtextra.AbsoluteConstraints(1330, 720, 240, -1));

        lblIconCaro.setIcon(new ImageIcon(getClass().getClassLoader().getResource(ResourceConstants.ICONTICTACTOE))); 
        panelRoot.add(lblIconCaro, new org.netbeans.lib.awtextra.AbsoluteConstraints(1320, 90, 260, 270));

        lblCaroXTitle.setFont(new Font("Lato", 1, 64)); 
        lblCaroXTitle.setForeground(new Color(38, 208, 254));
        lblCaroXTitle.setText(PrimitiveConstants.CAROX);
        panelRoot.add(lblCaroXTitle, new org.netbeans.lib.awtextra.AbsoluteConstraints(1320, 10, -1, -1));

        panelTimeRadioGroup.setBackground(new Color(255, 255, 255));
        panelTimeRadioGroup.setBorder(BorderFactory.createTitledBorder(null, "Time", TitledBorder.DEFAULT_JUSTIFICATION, TitledBorder.DEFAULT_POSITION, new Font("Lato", 0, 18))); 

        radioOnTimer.setFont(new Font("Lato", 0, 18)); 
        radioOnTimer.setText("On");
        
        radioOffTimer.setFont(new Font("Lato", 0, 18)); 
        radioOffTimer.setText("Off");

        GroupLayout jPanel1Layout = new GroupLayout(panelTimeRadioGroup);
        panelTimeRadioGroup.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(16, 16, 16)
                .addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                    .addComponent(radioOnTimer)
                    .addComponent(radioOffTimer))
                .addContainerGap(27, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(radioOnTimer)
                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, 14, Short.MAX_VALUE)
                .addComponent(radioOffTimer)
                .addGap(24, 24, 24))
        );

        panelRoot.add(panelTimeRadioGroup, new org.netbeans.lib.awtextra.AbsoluteConstraints(1330, 410, 110, 140));

        panelSoundRadioGroup.setBackground(new Color(255, 255, 255));
        panelSoundRadioGroup.setBorder(BorderFactory.createTitledBorder(null, PrimitiveConstants.SOUND, TitledBorder.DEFAULT_JUSTIFICATION, TitledBorder.DEFAULT_POSITION, new Font("Lato", 0, 18))); 
        panelSoundRadioGroup.setPreferredSize(new java.awt.Dimension(240, 70));

        radioOnSound.setFont(new Font("Lato", 0, 18)); 
        radioOnSound.setText("On");

        radioOffSound.setFont(new Font("Lato", 0, 18)); 
        radioOffSound.setText("Off");
        
        GroupLayout jPanel2Layout = new GroupLayout(panelSoundRadioGroup);
        panelSoundRadioGroup.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addGroup(jPanel2Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                    .addComponent(radioOffSound)
                    .addComponent(radioOnSound))
                .addContainerGap(23, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(radioOnSound)
                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, 14, Short.MAX_VALUE)
                .addComponent(radioOffSound)
                .addGap(24, 24, 24))
        );

        panelRoot.add(panelSoundRadioGroup, new org.netbeans.lib.awtextra.AbsoluteConstraints(1460, 410, 110, 140));

        lblLinesToWin.setFont(new Font("Lato", 1, 24)); 
        lblLinesToWin.setForeground(new Color(38, 208, 254));
        lblLinesToWin.setText(PrimitiveConstants.LINESTOWIN);
        panelRoot.add(lblLinesToWin, new org.netbeans.lib.awtextra.AbsoluteConstraints(1390, 370, -1, -1));

        lblPlayerWinScore2.setText(PrimitiveConstants.SCORETEXT);
        lblPlayerTimerCountDownTime2.setFont(new Font("Lato", 1, 24)); 
        lblPlayerTimerText2.setText(PrimitiveConstants.TIME);
        lblPlayerName2.setText(PrimitiveConstants.PLAYER2);
        panelRoot.add(panelPlayer2, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 400, 260, 350));
        
        lblPlayerWinScore1.setText(PrimitiveConstants.SCORETEXT);
        lblPlayerTimerCountDownTime1.setText(PrimitiveConstants.DEFAULTTWOPLAYERTIMER);
        lblPlayerTimerText1.setText(PrimitiveConstants.TIME);
        lblPlayerName1.setText(PrimitiveConstants.PLAYER1);
        panelRoot.add(panelPlayer1, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 10, 260, 350));

        lblCopyRight.setText(PrimitiveConstants.COPYRIGHT);
        panelRoot.add(lblCopyRight, new org.netbeans.lib.awtextra.AbsoluteConstraints(1370, 790, -1, 20));

        getContentPane().add(panelRoot, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1600, 833));

        pack();
        setLocationRelativeTo(null);
    
	}
	
	private JButton btnList;
    private JButton btnMenu;
    private JButton btnNewGame;
    private JButton btnPlayerAvatar1;
    private JButton btnPlayerAvatar2;
    private JButton btnSetting;
    private JButton btnUndo;
    private JLabel lblIconCaro;
    private JLabel lblCaroXTitle;
    private JLabel lblLinesToWin;
    private JLabel lblCopyRight;
    private JPanel panelTimeRadioGroup;
    private JPanel panelSoundRadioGroup;
    private PlayerPanel panelPlayer2;
    private PlayerPanel panelPlayer1;
    private JLabel lblPlayerName1;
    private JLabel lblPlayerName2;
    private JLabel lblPlayerWinScore1;
    private JLabel lblPlayerWinScore2;
    private JLabel lblPlayerTimerText1;
    private JLabel lblPlayerTimerText2;
    private JLabel lblPlayerTimerCountDownTime1;
    private JLabel lblPlayerTimerCountDownTime2;
    private JPanel panelBoardGame;
    private JPanel panelRoot;
    private JRadioButton radioOffSound;
    private JRadioButton radioOffTimer;
    private JRadioButton radioOnSound;
    private JRadioButton radioOnTimer;
    
	public JButton getBtnList() {
		return btnList;
	}

	public void setBtnList(JButton btnList) {
		this.btnList = btnList;
	}

	public JButton getBtnMenu() {
		return btnMenu;
	}

	public void setBtnMenu(JButton btnMenu) {
		this.btnMenu = btnMenu;
	}

	public JButton getBtnNewGame() {
		return btnNewGame;
	}

	public void setBtnNewGame(JButton btnNewGame) {
		this.btnNewGame = btnNewGame;
	}

	public JButton getBtnPlayerAvatar1() {
		return btnPlayerAvatar1;
	}

	public void setBtnPlayerAvatar1(JButton btnPlayerAvatar1) {
		this.btnPlayerAvatar1 = btnPlayerAvatar1;
	}

	public JButton getBtnPlayerAvatar2() {
		return btnPlayerAvatar2;
	}

	public void setBtnPlayerAvatar2(JButton btnPlayerAvatar2) {
		this.btnPlayerAvatar2 = btnPlayerAvatar2;
	}

	public JButton getBtnSetting() {
		return btnSetting;
	}

	public void setBtnSetting(JButton btnSetting) {
		this.btnSetting = btnSetting;
	}

	public JButton getBtnUndo() {
		return btnUndo;
	}

	public void setBtnUndo(JButton btnUndo) {
		this.btnUndo = btnUndo;
	}

	public JLabel getLblIconCaro() {
		return lblIconCaro;
	}

	public void setLblIconCaro(JLabel lblIconCaro) {
		this.lblIconCaro = lblIconCaro;
	}

	public JLabel getLblCaroXTitle() {
		return lblCaroXTitle;
	}

	public void setLblCaroXTitle(JLabel lblCaroXTitle) {
		this.lblCaroXTitle = lblCaroXTitle;
	}

	public JLabel getLblLinesToWin() {
		return lblLinesToWin;
	}

	public void setLblLinesToWin(JLabel lblLinesToWin) {
		this.lblLinesToWin = lblLinesToWin;
	}

	public JLabel getLblCopyRight() {
		return lblCopyRight;
	}

	public void setLblCopyRight(JLabel lblCopyRight) {
		this.lblCopyRight = lblCopyRight;
	}

	public JPanel getPanelTimeRadioGroup() {
		return panelTimeRadioGroup;
	}

	public void setPanelTimeRadioGroup(JPanel panelTimeRadioGroup) {
		this.panelTimeRadioGroup = panelTimeRadioGroup;
	}

	public JPanel getPanelSoundRadioGroup() {
		return panelSoundRadioGroup;
	}

	public void setPanelSoundRadioGroup(JPanel panelSoundRadioGroup) {
		this.panelSoundRadioGroup = panelSoundRadioGroup;
	}

	public PlayerPanel getPanelPlayer2() {
		return panelPlayer2;
	}

	public void setPanelPlayer2(PlayerPanel panelPlayer2) {
		this.panelPlayer2 = panelPlayer2;
	}

	public PlayerPanel getPanelPlayer1() {
		return panelPlayer1;
	}

	public void setPanelPlayer1(PlayerPanel panelPlayer1) {
		this.panelPlayer1 = panelPlayer1;
	}

	public JLabel getLblPlayerName1() {
		return lblPlayerName1;
	}

	public void setLblPlayerName1(JLabel lblPlayerName1) {
		this.lblPlayerName1 = lblPlayerName1;
	}

	public JLabel getLblPlayerName2() {
		return lblPlayerName2;
	}

	public void setLblPlayerName2(JLabel lblPlayerName2) {
		this.lblPlayerName2 = lblPlayerName2;
	}

	public JLabel getLblPlayerWinScore1() {
		return lblPlayerWinScore1;
	}

	public void setLblPlayerWinScore1(JLabel lblPlayerWinScore1) {
		this.lblPlayerWinScore1 = lblPlayerWinScore1;
	}

	public JLabel getLblPlayerWinScore2() {
		return lblPlayerWinScore2;
	}

	public void setLblPlayerWinScore2(JLabel lblPlayerWinScore2) {
		this.lblPlayerWinScore2 = lblPlayerWinScore2;
	}

	public JLabel getLblPlayerTimerText1() {
		return lblPlayerTimerText1;
	}

	public void setLblPlayerTimerText1(JLabel lblPlayerTimerText1) {
		this.lblPlayerTimerText1 = lblPlayerTimerText1;
	}

	public JLabel getLblPlayerTimerText2() {
		return lblPlayerTimerText2;
	}

	public void setLblPlayerTimerText2(JLabel lblPlayerTimerText2) {
		this.lblPlayerTimerText2 = lblPlayerTimerText2;
	}

	public JLabel getLblPlayerTimerCountDownTime1() {
		return lblPlayerTimerCountDownTime1;
	}

	public void setLblPlayerTimerCountDownTime1(JLabel lblPlayerTimerCountDownTime1) {
		this.lblPlayerTimerCountDownTime1 = lblPlayerTimerCountDownTime1;
	}

	public JLabel getLblPlayerTimerCountDownTime2() {
		return lblPlayerTimerCountDownTime2;
	}

	public void setLblPlayerTimerCountDownTime2(JLabel lblPlayerTimerCountDownTime2) {
		this.lblPlayerTimerCountDownTime2 = lblPlayerTimerCountDownTime2;
	}

	public JPanel getPanelBoardGame() {
		return panelBoardGame;
	}

	public void setPanelBoardGame(JPanel panelBoardGame) {
		this.panelBoardGame = panelBoardGame;
	}

	public JPanel getPanelRoot() {
		return panelRoot;
	}

	public void setPanelRoot(JPanel panelRoot) {
		this.panelRoot = panelRoot;
	}

	public JRadioButton getRadioOffSound() {
		return radioOffSound;
	}

	public void setRadioOffSound(JRadioButton radioOffSound) {
		this.radioOffSound = radioOffSound;
	}

	public JRadioButton getRadioOffTimer() {
		return radioOffTimer;
	}

	public void setRadioOffTimer(JRadioButton radioOffTimer) {
		this.radioOffTimer = radioOffTimer;
	}

	public JRadioButton getRadioOnSound() {
		return radioOnSound;
	}

	public void setRadioOnSound(JRadioButton radioOnSound) {
		this.radioOnSound = radioOnSound;
	}

	public JRadioButton getRadioOnTimer() {
		return radioOnTimer;
	}

	public void setRadioOnTimer(JRadioButton radioOnTimer) {
		this.radioOnTimer = radioOnTimer;
	}
    
    
}
