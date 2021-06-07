package views;

import javax.swing.*;
import javax.swing.event.*;

import utils.commons.IconType;
import utils.constants.ResourceConstants;
import utils.constants.PrimitiveConstants;

import javax.swing.border.*;
import java.awt.*;

public class SettingView extends BaseView {
	public SettingView() {
		super();
	}
	
	@Override
	public void initNewJComponents() {
		jPanel5 = new JPanel();
        paneParent = new JPanel();
        panelColorSelectBotLeft = new JPanel();
        chkBoard = new JCheckBox();
        chkCrossO = new JCheckBox();
        chkCrossX = new JCheckBox();
        colorChooser = new JColorChooser();
        panelIconSelectTopLeft = new JPanel();
        iconTypescrollPaneList = new JScrollPane();
        iconTypeList = new JList<IconType>();
        btnIcoX = new JButton();
        btnIcoO = new JButton();
        lblCrossO = new JLabel();
        lblCrossX = new JLabel();
        txtIcoO = new JTextField();
        txtIcoX = new JTextField();
        lblTextCollect = new JLabel();
        lblInputOneCharacter = new JLabel();
        lblCaroXTitle = new JLabel();
        btnSet = new JButton();
        btnBack = new JButton();
        btnReset = new JButton();
        lblLineToWins = new JLabel();
        lblIconCaroBoard = new JLabel();
        lblCopyRight = new JLabel();
	}
	
	@Override
	public void initViewComponents(){
		super.initViewComponents();
        jPanel5.setBackground(new Color(255, 255, 255));

        GroupLayout jPanel5Layout = new GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGap(0, 950, Short.MAX_VALUE)
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGap(0, 252, Short.MAX_VALUE)
        );

        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setTitle(PrimitiveConstants.SETTING);
        setResizable(false);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        paneParent.setBackground(new Color(255, 255, 255));
        paneParent.setPreferredSize(new java.awt.Dimension(849, 810));

        panelColorSelectBotLeft.setBackground(new Color(255, 255, 255));
        panelColorSelectBotLeft.setBorder(BorderFactory.createTitledBorder(null, PrimitiveConstants.COLORSELECT, TitledBorder.DEFAULT_JUSTIFICATION, TitledBorder.DEFAULT_POSITION, new Font("Lato", 1, 18), new Color(38, 208, 254))); // NOI18N
        panelColorSelectBotLeft.setPreferredSize(new java.awt.Dimension(860, 401));

        chkBoard.setBackground(new Color(255, 255, 255));
        chkBoard.setFont(new Font("Lato", 0, 18)); // NOI18N
        chkBoard.setText(PrimitiveConstants.GAMEBOARD);

        chkCrossO.setBackground(new Color(255, 255, 255));
        chkCrossO.setFont(new Font("Lato", 0, 18)); // NOI18N
        chkCrossO.setText(PrimitiveConstants.CROSSO);

        chkCrossX.setBackground(new Color(255, 255, 255));
        chkCrossX.setFont(new Font("Lato", 0, 18)); // NOI18N
        chkCrossX.setText(PrimitiveConstants.CROSSX);

        GroupLayout jPanel1Layout = new GroupLayout(panelColorSelectBotLeft);
        panelColorSelectBotLeft.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(colorChooser, GroupLayout.PREFERRED_SIZE, 646, GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                    .addComponent(chkCrossX)
                    .addComponent(chkCrossO)
                    .addComponent(chkBoard))
                .addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                    .addComponent(colorChooser, GroupLayout.PREFERRED_SIZE, 357, GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(25, 25, 25)
                        .addComponent(chkBoard)
                        .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(chkCrossO)
                        .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(chkCrossX)))
                .addContainerGap(25, Short.MAX_VALUE))
        );

        panelIconSelectTopLeft.setBackground(new Color(255, 255, 255));
        panelIconSelectTopLeft.setBorder(BorderFactory.createTitledBorder(null, PrimitiveConstants.ICONSELECT, TitledBorder.DEFAULT_JUSTIFICATION, TitledBorder.DEFAULT_POSITION, new Font("Lato", 1, 18), new Color(38, 208, 254))); // NOI18N

        iconTypeList.setModel(new AbstractListModel<IconType>() {
            IconType[] strings = { IconType.Default, IconType.SocialNetwork, IconType.Food, IconType.Human, IconType.Vehicle, IconType.Superhero, IconType.SearchEngine, IconType.Smartphone };
            public int getSize() { return strings.length; }
            public IconType getElementAt(int i) { return strings[i]; }
        });
        
        iconTypescrollPaneList.setViewportView(iconTypeList);

        btnIcoX.setBackground(new Color(255, 255, 255));
        btnIcoX.setBorder(BorderFactory.createLineBorder(new Color(38, 208, 254)));

        btnIcoO.setBackground(new Color(255, 255, 255));
        btnIcoO.setBorder(BorderFactory.createLineBorder(new Color(38, 208, 254)));

        lblCrossO.setFont(new Font("Lato", 0, 18)); // NOI18N
        lblCrossO.setText("Cross O");

        lblCrossX.setFont(new Font("Lato", 0, 18)); // NOI18N
        lblCrossX.setText("Cross X");

        lblTextCollect.setFont(new Font("Lato", 0, 18)); // NOI18N
        lblTextCollect.setText("Collect:");

        lblInputOneCharacter.setFont(new Font("Tahoma", 0, 14)); // NOI18N
        lblInputOneCharacter.setText("You can input ONE charater (Default) ");

        GroupLayout jPanel2Layout = new GroupLayout(panelIconSelectTopLeft);
        panelIconSelectTopLeft.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(iconTypescrollPaneList, GroupLayout.PREFERRED_SIZE, 312, GroupLayout.PREFERRED_SIZE)
                        .addGap(60, 60, 60)
                        .addGroup(jPanel2Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGroup(jPanel2Layout.createParallelGroup(GroupLayout.Alignment.TRAILING)
                                    .addComponent(txtIcoO, GroupLayout.PREFERRED_SIZE, 62, GroupLayout.PREFERRED_SIZE)
                                    .addComponent(btnIcoO, GroupLayout.PREFERRED_SIZE, 131, GroupLayout.PREFERRED_SIZE))
                                .addGap(18, 18, 18)
                                .addGroup(jPanel2Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                                    .addComponent(btnIcoX, GroupLayout.PREFERRED_SIZE, 125, GroupLayout.PREFERRED_SIZE)
                                    .addGroup(jPanel2Layout.createSequentialGroup()
                                        .addComponent(lblCrossX)
                                        .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(txtIcoX, GroupLayout.PREFERRED_SIZE, 60, GroupLayout.PREFERRED_SIZE))))
                            .addComponent(lblCrossO, GroupLayout.PREFERRED_SIZE, 274, GroupLayout.PREFERRED_SIZE))
                        .addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(lblTextCollect)
                        .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(lblInputOneCharacter)
                        .addGap(0, 0, Short.MAX_VALUE))))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(36, 36, 36)
                .addGroup(jPanel2Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                    .addComponent(lblTextCollect)
                    .addComponent(lblInputOneCharacter))
                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                    .addComponent(iconTypescrollPaneList, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                            .addComponent(lblCrossO)
                            .addComponent(txtIcoO, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                            .addComponent(lblCrossX)
                            .addComponent(txtIcoX, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                        .addGap(16, 16, 16)
                        .addGroup(jPanel2Layout.createParallelGroup(GroupLayout.Alignment.LEADING, false)
                            .addComponent(btnIcoX, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(btnIcoO, GroupLayout.PREFERRED_SIZE, 98, GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        lblCaroXTitle.setFont(new Font("Lato", 1, 64)); // NOI18N
        lblCaroXTitle.setForeground(new Color(38, 208, 254));
        lblCaroXTitle.setText(PrimitiveConstants.CAROX);

        btnSet.setBackground(new Color(255, 255, 255));
        btnSet.setFont(new Font("Lato", 1, 18)); // NOI18N
        btnSet.setForeground(new Color(38, 208, 254));
        btnSet.setText(PrimitiveConstants.SET);

        btnBack.setBackground(new Color(255, 255, 255));
        btnBack.setFont(new Font("Lato", 1, 18)); // NOI18N
        btnBack.setForeground(new Color(38, 208, 254));
        btnBack.setText(PrimitiveConstants.BACK);

        btnReset.setBackground(new Color(255, 255, 255));
        btnReset.setFont(new Font("Lato", 1, 18)); // NOI18N
        btnReset.setForeground(new Color(38, 208, 254));
        btnReset.setText(PrimitiveConstants.RESET);


        lblLineToWins.setFont(new Font("Lato", 1, 24)); // NOI18N
        lblLineToWins.setForeground(new Color(38, 208, 254));
        lblLineToWins.setText(PrimitiveConstants.LINESTOWIN);

        lblIconCaroBoard.setIcon(new ImageIcon(getClass().getClassLoader().getResource(ResourceConstants.ICONTICTACTOE))); // NOI18N

        lblCopyRight.setText(PrimitiveConstants.COPYRIGHT);

        GroupLayout jPanel3Layout = new GroupLayout(paneParent);
        paneParent.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addGap(24, 24, 24)
                .addGroup(jPanel3Layout.createParallelGroup(GroupLayout.Alignment.LEADING, false)
                    .addComponent(panelIconSelectTopLeft, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(panelColorSelectBotLeft, GroupLayout.PREFERRED_SIZE, 819, GroupLayout.PREFERRED_SIZE))
                .addGroup(jPanel3Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGap(29, 29, 29)
                        .addGroup(jPanel3Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                            .addComponent(lblCaroXTitle)
                            .addComponent(lblIconCaroBoard)))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGap(65, 65, 65)
                        .addGroup(jPanel3Layout.createParallelGroup(GroupLayout.Alignment.TRAILING)
                            .addGroup(jPanel3Layout.createParallelGroup(GroupLayout.Alignment.LEADING, false)
                                .addComponent(btnSet, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(btnReset, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(btnBack, GroupLayout.PREFERRED_SIZE, 182, GroupLayout.PREFERRED_SIZE))
                            .addComponent(lblLineToWins))))
                .addContainerGap(22, Short.MAX_VALUE))
            .addGroup(GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(lblCopyRight)
                .addGap(69, 69, 69))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(22, 22, 22)
                .addGroup(jPanel3Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(panelIconSelectTopLeft, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(panelColorSelectBotLeft, GroupLayout.PREFERRED_SIZE, 413, GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 30, Short.MAX_VALUE))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(lblCaroXTitle)
                        .addGap(18, 18, 18)
                        .addComponent(lblIconCaroBoard)
                        .addGap(18, 18, 18)
                        .addComponent(lblLineToWins)
                        .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnSet)
                        .addGap(18, 18, 18)
                        .addComponent(btnReset)
                        .addGap(18, 18, 18)
                        .addComponent(btnBack)
                        .addGap(66, 66, 66)
                        .addComponent(lblCopyRight)))
                .addContainerGap())
        );

        getContentPane().add(paneParent, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1150, 740));
        pack();
        setLocationRelativeTo(null);
	}

    private JPanel paneParent; //jPanel3 Store all other component
	private JButton btnBack;
    private JButton btnIcoO;
    private JButton btnIcoX;
    private JButton btnReset;
    private JButton btnSet;
    private JCheckBox chkBoard;
    private JCheckBox chkCrossO;
    private JCheckBox chkCrossX;
    private JColorChooser colorChooser;
    private JLabel lblCrossO;//jLabel1
    private JLabel lblCrossX;//jLabel2
    private JLabel lblTextCollect; //jLabel3
    private JLabel lblInputOneCharacter; //jLabel
    private JLabel lblCaroXTitle; //jLabel5
    private JLabel lblLineToWins; //jLabel6
    private JLabel lblIconCaroBoard; //jLabel7
    private JLabel lblCopyRight;
    private JPanel panelColorSelectBotLeft; //jPanel1
    private JPanel panelIconSelectTopLeft;
    private JPanel jPanel5;
    private JScrollPane iconTypescrollPaneList; // jScrollPane
    private JList<IconType> iconTypeList; //list
    private JTextField txtIcoO;
    private JTextField txtIcoX;
	public JPanel getPaneParent() {
		return paneParent;
	}

	public void setPaneParent(JPanel paneParent) {
		this.paneParent = paneParent;
	}

	public JButton getBtnBack() {
		return btnBack;
	}

	public void setBtnBack(JButton btnBack) {
		this.btnBack = btnBack;
	}

	public JButton getBtnIcoO() {
		return btnIcoO;
	}

	public void setBtnIcoO(JButton btnIcoO) {
		this.btnIcoO = btnIcoO;
	}

	public JButton getBtnIcoX() {
		return btnIcoX;
	}

	public void setBtnIcoX(JButton btnIcoX) {
		this.btnIcoX = btnIcoX;
	}

	public JButton getBtnReset() {
		return btnReset;
	}

	public void setBtnReset(JButton btnReset) {
		this.btnReset = btnReset;
	}

	public JButton getBtnSet() {
		return btnSet;
	}

	public void setBtnSet(JButton btnSet) {
		this.btnSet = btnSet;
	}

	public JCheckBox getChkBoard() {
		return chkBoard;
	}

	public void setChkBoard(JCheckBox chkBoard) {
		this.chkBoard = chkBoard;
	}

	public JCheckBox getChkCrossO() {
		return chkCrossO;
	}

	public void setChkCrossO(JCheckBox chkCrossO) {
		this.chkCrossO = chkCrossO;
	}

	public JCheckBox getChkCrossX() {
		return chkCrossX;
	}

	public void setChkCrossX(JCheckBox chkCrossX) {
		this.chkCrossX = chkCrossX;
	}

	public JColorChooser getColorChooser() {
		return colorChooser;
	}

	public void setColorChooser(JColorChooser colorChooser) {
		this.colorChooser = colorChooser;
	}

	public JLabel getLblCrossO() {
		return lblCrossO;
	}

	public void setLblCrossO(JLabel lblCrossO) {
		this.lblCrossO = lblCrossO;
	}

	public JLabel getLblCrossX() {
		return lblCrossX;
	}

	public void setLblCrossX(JLabel lblCrossX) {
		this.lblCrossX = lblCrossX;
	}

	public JLabel getLblTextCollect() {
		return lblTextCollect;
	}

	public void setLblTextCollect(JLabel lblTextCollect) {
		this.lblTextCollect = lblTextCollect;
	}

	public JLabel getLblInputOneCharacter() {
		return lblInputOneCharacter;
	}

	public void setLblInputOneCharacter(JLabel lblInputOneCharacter) {
		this.lblInputOneCharacter = lblInputOneCharacter;
	}

	public JLabel getLblCaroXTitle() {
		return lblCaroXTitle;
	}

	public void setLblCaroXTitle(JLabel lblCaroXTitle) {
		this.lblCaroXTitle = lblCaroXTitle;
	}

	public JLabel getLblLineToWins() {
		return lblLineToWins;
	}

	public void setLblLineToWins(JLabel lblLineToWins) {
		this.lblLineToWins = lblLineToWins;
	}

	public JLabel getLblIconCaroBoard() {
		return lblIconCaroBoard;
	}

	public void setLblIconCaroBoard(JLabel lblIconCaroBoard) {
		this.lblIconCaroBoard = lblIconCaroBoard;
	}

	public JLabel getLblCopyRight() {
		return lblCopyRight;
	}

	public void setLblCopyRight(JLabel lblCopyRight) {
		this.lblCopyRight = lblCopyRight;
	}

	public JPanel getPanelColorSelectBotLeft() {
		return panelColorSelectBotLeft;
	}

	public void setPanelColorSelectBotLeft(JPanel panelColorSelectBotLeft) {
		this.panelColorSelectBotLeft = panelColorSelectBotLeft;
	}

	public JPanel getPanelIconSelectTopLeft() {
		return panelIconSelectTopLeft;
	}

	public void setPanelIconSelectTopLeft(JPanel panelIconSelectTopLeft) {
		this.panelIconSelectTopLeft = panelIconSelectTopLeft;
	}

	public JPanel getjPanel5() {
		return jPanel5;
	}

	public void setjPanel5(JPanel jPanel5) {
		this.jPanel5 = jPanel5;
	}

	public JScrollPane getIconTypescrollPaneList() {
		return iconTypescrollPaneList;
	}

	public void setIconTypescrollPaneList(JScrollPane iconTypescrollPaneList) {
		this.iconTypescrollPaneList = iconTypescrollPaneList;
	}

	public JList<IconType> getIconTypeList() {
		return iconTypeList;
	}

	public void setIconTypeList(JList<IconType> iconTypeList) {
		this.iconTypeList = iconTypeList;
	}

	public JTextField getTxtIcoO() {
		return txtIcoO;
	}

	public void setTxtIcoO(JTextField txtIcoO) {
		this.txtIcoO = txtIcoO;
	}

	public JTextField getTxtIcoX() {
		return txtIcoX;
	}

	public void setTxtIcoX(JTextField txtIcoX) {
		this.txtIcoX = txtIcoX;
	}
}
