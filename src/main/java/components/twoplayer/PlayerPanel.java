package components.twoplayer;

import java.awt.Color;
import java.awt.Font;

import javax.swing.BorderFactory;
import javax.swing.GroupLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.LayoutStyle;

import utils.constants.ResourceConstants;
import utils.constants.PrimitiveConstants;

public class PlayerPanel extends JPanel{

	private void initViewComponents() {
		lblPlayerName = new JLabel();
		lblPlayerWinScore = new JLabel();
		lblPlayerTimerCountDownTime = new JLabel();
		
		btnPlayerAvatar = new JButton();
		lblPlayerTimerText = new JLabel();
	}
	
	public PlayerPanel() {
		initViewComponents();
		setBackground(new Color(255, 255, 255));
        setBorder(BorderFactory.createEtchedBorder());

        lblPlayerWinScore.setFont(new Font("Lato", 1, 24));

        lblPlayerTimerCountDownTime.setFont(new Font("Lato", 1, 24));

        btnPlayerAvatar.setBackground(new Color(255, 255, 255));
        btnPlayerAvatar.setIcon(new ImageIcon(getClass().getClassLoader().getResource(ResourceConstants.ICONUSERAVATAR))); 
        btnPlayerAvatar.setBorder(BorderFactory.createLineBorder(new Color(0, 0, 0), 3));
        btnPlayerAvatar.setPreferredSize(new java.awt.Dimension(250, 216));

        lblPlayerTimerText.setFont(new Font("Lato", 1, 24)); 

        lblPlayerName.setFont(new Font("Lato", 1, 24)); 

        GroupLayout jPanel4Layout = new GroupLayout(this);
        setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGroup(jPanel4Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(jPanel4Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel4Layout.createSequentialGroup()
                                .addComponent(lblPlayerTimerText)
                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(lblPlayerTimerCountDownTime))
                            .addComponent(lblPlayerWinScore)))
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGap(23, 23, 23)
                        .addComponent(btnPlayerAvatar, GroupLayout.PREFERRED_SIZE, 210, GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGap(78, 78, 78)
                        .addComponent(lblPlayerName)))
                .addContainerGap(23, Short.MAX_VALUE))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                .addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(lblPlayerName)
                .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btnPlayerAvatar, GroupLayout.PREFERRED_SIZE, 180, GroupLayout.PREFERRED_SIZE)
                .addGap(29, 29, 29)
                .addComponent(lblPlayerWinScore)
                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel4Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                    .addComponent(lblPlayerTimerText)
                    .addComponent(lblPlayerTimerCountDownTime))
                .addGap(24, 24, 24))
        );
	}

	public void setScoreText(String score) {
		lblPlayerWinScore.setText(score);
	}
	public void setTimeCountDownTimer(String time) {
		lblPlayerTimerCountDownTime.setText(time);
	}
	public void setPlayerName (String name) {
		lblPlayerName.setText(name);
	}

	private JLabel lblPlayerWinScore; //lbPoint1 lbPoint2
	private JLabel lblPlayerName; // lbName1 lbName2
	private JLabel lblPlayerTimerCountDownTime; // lbTimer1 lbTimer2
	private JLabel lblPlayerTimerText; // lbPoint3 lbPoint4
	private JButton btnPlayerAvatar; // btnPlayer1 btnPlayer2

	public JLabel getLblPlayerWinScore() {
		return lblPlayerWinScore;
	}

	public void setLblPlayerWinScore(JLabel lblPlayerWinScore) {
		this.lblPlayerWinScore = lblPlayerWinScore;
	}

	public JLabel getLblPlayerName() {
		return lblPlayerName;
	}

	public void setLblPlayerName(JLabel lblPlayerName) {
		this.lblPlayerName = lblPlayerName;
	}

	public JLabel getLblPlayerTimerCountDownTime() {
		return lblPlayerTimerCountDownTime;
	}

	public void setLblPlayerTimerCountDownTime(JLabel lblPlayerTimerCountDownTime) {
		this.lblPlayerTimerCountDownTime = lblPlayerTimerCountDownTime;
	}

	public JLabel getLblPlayerTimerText() {
		return lblPlayerTimerText;
	}

	public void setLblPlayerTimerText(JLabel lblPlayerTimerText) {
		this.lblPlayerTimerText = lblPlayerTimerText;
	}

	public JButton getBtnPlayerAvatar() {
		return btnPlayerAvatar;
	}

	public void setBtnPlayerAvatar(JButton btnPlayerAvatar) {
		this.btnPlayerAvatar = btnPlayerAvatar;
	}
}
