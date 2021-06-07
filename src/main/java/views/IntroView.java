package views;

import javax.swing.GroupLayout;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.WindowConstants;
import java.awt.*;

import utils.constants.PrimitiveConstants;

public class IntroView extends BaseView {

    public IntroView() {
    	super();
    }

    
    @Override
	protected void initNewJComponents() {
    	jPanel1 = new JPanel();
        lblSubTitle = new JLabel();
        lblHeadingTitle = new JLabel();
        btnSetting = new JButton();
        btnLAN = new JButton();
        btnTwo = new JButton();
        lblCopyRight = new JLabel();
	}
    
    protected void initViewComponents() {
    	super.initViewComponents();

		setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setTitle(PrimitiveConstants.INTROFRAMETITLE);
        setResizable(false);
        
        jPanel1.setBackground(new Color(255, 255, 255));

        lblSubTitle.setFont(new Font("Lato", 1, 24)); // NOI18N
        lblSubTitle.setForeground(new Color(38, 208, 254));
        lblSubTitle.setText(PrimitiveConstants.INTROLINESTOWIN);

        lblHeadingTitle.setBackground(new Color(255, 255, 255));
        lblHeadingTitle.setFont(new Font("Lato", 1, 64)); // NOI18N
        lblHeadingTitle.setForeground(new Color(38, 208, 254));
        lblHeadingTitle.setText(PrimitiveConstants.CAROX);

        btnSetting.setBackground(new Color(255, 255, 255));
        btnSetting.setFont(new Font("Calibri", 1, 30)); // NOI18N
        btnSetting.setForeground(new Color(38, 208, 254));
        btnSetting.setText(PrimitiveConstants.SETTING);
        btnSetting.setBorder(null);
        
        btnLAN.setBackground(new Color(255, 255, 255));
        btnLAN.setFont(new Font("Calibri", 1, 30)); // NOI18N
        btnLAN.setForeground(new Color(38, 208, 254));
        btnLAN.setText(PrimitiveConstants.PLAYONLAN);
        btnLAN.setBorder(null);
        

        btnTwo.setBackground(new Color(255, 255, 255));
        btnTwo.setFont(new Font("Calibri", 1, 30)); // NOI18N
        btnTwo.setForeground(new Color(38, 208, 254));
        btnTwo.setText("Two Player");
        btnTwo.setBorder(null);

        lblCopyRight.setText(PrimitiveConstants.COPYRIGHT);

        GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(69, 69, 69)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                .addComponent(btnTwo, javax.swing.GroupLayout.PREFERRED_SIZE, 259, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(btnLAN, javax.swing.GroupLayout.PREFERRED_SIZE, 259, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(btnSetting, javax.swing.GroupLayout.PREFERRED_SIZE, 259, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                .addComponent(lblSubTitle)
                                .addComponent(lblHeadingTitle))))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(120, 120, 120)
                        .addComponent(lblCopyRight)))
                .addContainerGap(75, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(7, 7, 7)
                .addComponent(lblHeadingTitle)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lblSubTitle)
                .addGap(61, 61, 61)
                .addComponent(btnTwo)
                .addGap(18, 18, 18)
                .addComponent(btnLAN)
                .addGap(18, 18, 18)
                .addComponent(btnSetting)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 41, Short.MAX_VALUE)
                .addComponent(lblCopyRight)
                .addContainerGap())
        );

        GroupLayout layout = new GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, GroupLayout.Alignment.TRAILING, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        

        pack();
        setLocationRelativeTo(null);
        setVisible(true);
    }

    public JButton getBtnLAN() {
		return btnLAN;
	}

	public void setBtnLAN(JButton btnLAN) {
		this.btnLAN = btnLAN;
	}

	public JButton getBtnSetting() {
		return btnSetting;
	}

	public void setBtnSetting(JButton btnSetting) {
		this.btnSetting = btnSetting;
	}

	public JButton getBtnTwo() {
		return btnTwo;
	}

	public void setBtnTwo(JButton btnTwo) {
		this.btnTwo = btnTwo;
	}

	public JLabel getLblCopyRight() {
		return lblCopyRight;
	}

	public void setLblCopyRight(JLabel lblCopyRight) {
		this.lblCopyRight = lblCopyRight;
	}

	public JLabel getLblSubTitle() {
		return lblSubTitle;
	}

	public void setLblSubTitle(JLabel lblSubTitle) {
		this.lblSubTitle = lblSubTitle;
	}

	public JLabel getlblHeadingTitle() {
		return lblHeadingTitle;
	}

	public void setlblHeadingTitle(JLabel lblHeadingTitle) {
		this.lblHeadingTitle = lblHeadingTitle;
	}

	public JPanel getjPanel1() {
		return jPanel1;
	}

	public void setjPanel1(JPanel jPanel1) {
		this.jPanel1 = jPanel1;
	}

	private JButton btnSetting;
    private JButton btnTwo;
    private JButton btnLAN;
    private JLabel lblCopyRight; // jLabel1
    private JLabel lblSubTitle; // jLabel3
    private JLabel lblHeadingTitle; // jLabel5
    private JPanel jPanel1;
}
