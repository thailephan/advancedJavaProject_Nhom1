package views;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.*;

import utils.constants.ResourceConstants;

public class TwoPlayerLanView extends BaseView{

	public TwoPlayerLanView() {
		super();
	}
	
	@Override
	protected void initNewJComponents() {
		rootPane = new JPanel();
        paneBoard = new JPanel();
        lblCaroTitle = new JLabel();
        lblIconCaroBoard = new JLabel();
        btnNewGame = new JButton();
        btnSetting = new JButton();
        lblPlayerMoveText = new JLabel();
        lblLineToWins = new JLabel();
        lbMove = new JLabel();
        lblYourIP = new JLabel();
        btnConnect = new JButton();
        btnMenu = new JButton();
        txtIP = new JTextField();
        lbConnect = new JLabel();
        lblFriendIP = new JLabel();
        jLabel5 = new JLabel();
	}
	@Override
	protected void initViewComponents() {
		super.initViewComponents();
		setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setTitle("CARO - X");
        setBackground(new Color(0, 0, 0));
        setResizable(false);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        rootPane.setBackground(new Color(255, 255, 255));

        paneBoard.setBackground(new Color(255, 255, 255));
        paneBoard.setBorder(BorderFactory.createLineBorder(new Color(38, 208, 254), 2));
        paneBoard.setPreferredSize(new Dimension(1000, 800));

        GroupLayout pn1Layout = new GroupLayout(paneBoard);
        paneBoard.setLayout(pn1Layout);
        pn1Layout.setHorizontalGroup(
            pn1Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGap(0, 996, Short.MAX_VALUE)
        );
        pn1Layout.setVerticalGroup(
            pn1Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGap(0, 796, Short.MAX_VALUE)
        );

        lblCaroTitle.setFont(new Font("Lato", 1, 64));
        lblCaroTitle.setForeground(new Color(38, 208, 254));
        lblCaroTitle.setText("CARO - X");

        lblIconCaroBoard.setIcon(new ImageIcon(getClass().getClassLoader().getResource(ResourceConstants.ICONTICTACTOE)));

        btnNewGame.setBackground(new Color(255, 255, 255));
        btnNewGame.setFont(new Font("Lato", 1, 18));
        btnNewGame.setForeground(new Color(38, 208, 254));
        btnNewGame.setText("New Game");

        btnSetting.setBackground(new Color(255, 255, 255));
        btnSetting.setFont(new Font("Lato", 1, 18));
        btnSetting.setForeground(new Color(38, 208, 254));
        btnSetting.setText("Setting");
        
        lblPlayerMoveText.setFont(new Font("Lato", 1, 18));
        lblPlayerMoveText.setText("Player move:");

        lblLineToWins.setFont(new Font("Lato", 1, 24));
        lblLineToWins.setForeground(new Color(38, 208, 254));
        lblLineToWins.setText("5 in line to win ...");

        lbMove.setFont(new Font("Lato", 1, 18));
        lbMove.setText("Unknown");

        lblYourIP.setText("Your IP: ");

        btnConnect.setBackground(new Color(255, 255, 255));
        btnConnect.setFont(new Font("Lato", 1, 18));
        btnConnect.setForeground(new Color(38, 208, 254));
        btnConnect.setText("Connect");

        btnMenu.setBackground(new Color(255, 255, 255));
        btnMenu.setFont(new Font("Lato", 1, 18));
        btnMenu.setForeground(new Color(38, 208, 254));
        btnMenu.setText("Menu");

        txtIP.setText("127.0.0.1");

        lbConnect.setText("Connect Status: None");

        lblFriendIP.setText("Friend IP:");

        jLabel5.setText("Copyright by CT276 Project");

        GroupLayout pnBoardLayout = new GroupLayout(rootPane);
        rootPane.setLayout(pnBoardLayout);
        pnBoardLayout.setHorizontalGroup(
            pnBoardLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(pnBoardLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(paneBoard, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                .addGroup(pnBoardLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                    .addGroup(pnBoardLayout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addGroup(pnBoardLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                            .addComponent(lblCaroTitle)
                            .addGroup(pnBoardLayout.createSequentialGroup()
                                .addGap(10, 10, 10)
                                .addComponent(lblIconCaroBoard))
                            .addGroup(pnBoardLayout.createSequentialGroup()
                                .addGap(38, 38, 38)
                                .addGroup(pnBoardLayout.createParallelGroup(GroupLayout.Alignment.LEADING, false)
                                    .addGroup(pnBoardLayout.createSequentialGroup()
                                        .addComponent(lblFriendIP)
                                        .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(txtIP))
                                    .addComponent(lbConnect)
                                    .addComponent(lblLineToWins, GroupLayout.Alignment.TRAILING)
                                    .addGroup(pnBoardLayout.createSequentialGroup()
                                        .addComponent(lblPlayerMoveText)
                                        .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(lbMove))
                                    .addComponent(btnConnect, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(btnSetting, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(btnMenu, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(btnNewGame, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(lblYourIP)))))
                    .addGroup(pnBoardLayout.createSequentialGroup()
                        .addGap(64, 64, 64)
                        .addComponent(jLabel5)))
                .addContainerGap(19, Short.MAX_VALUE))
        );
        pnBoardLayout.setVerticalGroup(
            pnBoardLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(GroupLayout.Alignment.TRAILING, pnBoardLayout.createSequentialGroup()
                .addContainerGap(17, Short.MAX_VALUE)
                .addGroup(pnBoardLayout.createParallelGroup(GroupLayout.Alignment.LEADING, false)
                    .addGroup(pnBoardLayout.createSequentialGroup()
                        .addComponent(lblCaroTitle)
                        .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(lblIconCaroBoard)
                        .addGap(18, 18, 18)
                        .addComponent(lblLineToWins)
                        .addGap(18, 18, 18)
                        .addComponent(btnNewGame)
                        .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btnMenu)
                        .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btnSetting)
                        .addGap(20, 20, 20)
                        .addGroup(pnBoardLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                            .addComponent(lblPlayerMoveText)
                            .addComponent(lbMove))
                        .addGap(18, 18, 18)
                        .addGroup(pnBoardLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                            .addComponent(txtIP, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                            .addComponent(lblFriendIP))
                        .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(lbConnect)
                        .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(lblYourIP)
                        .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnConnect)
                        .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel5))
                    .addComponent(paneBoard, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );

        getContentPane().add(rootPane, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1320, 830));

        pack();
        setLocationRelativeTo(null);
	}


    private JButton btnConnect;
    private JButton btnMenu;
    private JButton btnNewGame;
    private JButton btnSetting;
    private JLabel lblCaroTitle;
    private JLabel lblIconCaroBoard;
    private JLabel lblPlayerMoveText;
    private JLabel lblLineToWins;
    private JLabel jLabel5;
    private JLabel lbConnect;
    private JLabel lblYourIP;
    private JLabel lblFriendIP;
    private JLabel lbMove;
    private JPanel paneBoard;
    private JPanel rootPane;
    private JTextField txtIP;
	public JButton getBtnConnect() {
		return btnConnect;
	}

	public void setBtnConnect(JButton btnConnect) {
		this.btnConnect = btnConnect;
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

	public JButton getBtnSetting() {
		return btnSetting;
	}

	public void setBtnSetting(JButton btnSetting) {
		this.btnSetting = btnSetting;
	}

	public JLabel getLblCaroTitle() {
		return lblCaroTitle;
	}

	public void setLblCaroTitle(JLabel lblCaroTitle) {
		this.lblCaroTitle = lblCaroTitle;
	}

	public JLabel getLblIconCaroBoard() {
		return lblIconCaroBoard;
	}

	public void setLblIconCaroBoard(JLabel lblIconCaroBoard) {
		this.lblIconCaroBoard = lblIconCaroBoard;
	}

	public JLabel getLblPlayerMoveText() {
		return lblPlayerMoveText;
	}

	public void setLblPlayerMoveText(JLabel lblPlayerMoveText) {
		this.lblPlayerMoveText = lblPlayerMoveText;
	}

	public JLabel getLblLineToWins() {
		return lblLineToWins;
	}

	public void setLblLineToWins(JLabel lblLineToWins) {
		this.lblLineToWins = lblLineToWins;
	}

	public JLabel getjLabel5() {
		return jLabel5;
	}

	public void setjLabel5(JLabel jLabel5) {
		this.jLabel5 = jLabel5;
	}

	public JLabel getLbConnect() {
		return lbConnect;
	}

	public void setLbConnect(JLabel lbConnect) {
		this.lbConnect = lbConnect;
	}

	public JLabel getLblYourIP() {
		return lblYourIP;
	}

	public void setLblYourIP(JLabel lblYourIP) {
		this.lblYourIP = lblYourIP;
	}

	public JLabel getLblFriendIP() {
		return lblFriendIP;
	}

	public void setLblFriendIP(JLabel lblFriendIP) {
		this.lblFriendIP = lblFriendIP;
	}

	public JLabel getLbMove() {
		return lbMove;
	}

	public void setLbMove(JLabel lbMove) {
		this.lbMove = lbMove;
	}

	public JPanel getPaneBoard() {
		return paneBoard;
	}

	public void setPaneBoard(JPanel paneBoard) {
		this.paneBoard = paneBoard;
	}

	public JPanel getrootPane() {
		return rootPane;
	}

	public void setRootPane(JPanel rootPane) {
		this.rootPane = rootPane;
	}

	public JTextField getTxtIP() {
		return txtIP;
	}

	public void setTxtIP(JTextField txtIP) {
		this.txtIP = txtIP;
	}
    
}
