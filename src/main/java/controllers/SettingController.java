package controllers;

import java.awt.Color;
import java.awt.Font;
import java.net.URL;

import javax.swing.*;

import java.util.logging.Level;
import java.util.logging.Logger;

import utils.commons.IconType;
import utils.constants.ResourceConstants;
import utils.constants.PrimitiveConstants;

import views.BaseView;
import views.SettingView;

public class SettingController extends BaseController{

    private String select_icon1, select_icon2;
    private TwoPlayerLocalController twoPlayerLocalController;
    private TwoPlayerLanController twoPlayerLanController;
    public static int classReturn = 0;
    
    private IntroController intro;
    private SettingView view;
    
    public SettingController() {
    	super();
    	this.view = new SettingView();
    	initView();
    	initController();
    }
    

	@Override
	public BaseView getView() {
		return view;
	}
	
	@Override
	void initController() {
		btnReset.addActionListener(e -> btnResetMouseClicked());
		btnBack.addActionListener(e -> btnBackMouseClicked());
		btnSet.addActionListener(e -> btnSetMouseClicked());
		iconTypeList.addListSelectionListener(e -> listValueChanged());
		
		iconTypeList.setSelectedIndex(0);
	}
	
	@Override
	void initView() {
			btnReset = view.getBtnReset();
			btnBack = view.getBtnBack();
			btnSet = view.getBtnSet();
			colorChooser = view.getColorChooser();
			btnIcoO = view.getBtnIcoO();
			btnIcoX = view.getBtnIcoX();
			chkBoard = view.getChkBoard();
			chkCrossO = view.getChkCrossO();
			chkCrossX = view.getChkCrossX();
			txtIcoO = view.getTxtIcoO();
			txtIcoX = view.getTxtIcoX();
			iconTypeList = view.getIconTypeList();
	}
    
    public void setColorBoard() {
        TwoPlayerLocalController.colorBoard = colorChooser.getColor();
        TwoPlayerLanController.colorBoard = colorChooser.getColor();
    }

    public void setColorO() {
        TwoPlayerLocalController.colorO = colorChooser.getColor();
        TwoPlayerLanController.colorO = colorChooser.getColor();
    }

    public void setColorX() {
        TwoPlayerLocalController.colorX = colorChooser.getColor();
        TwoPlayerLanController.colorX = colorChooser.getColor();
    }

    public void setEmptyIcon() {
        btnIcoO.setText("");
        btnIcoX.setText("");
        btnIcoO.setIcon(null);
        btnIcoX.setIcon(null);
    }

    public void setBackForm(BaseController a) {
        if (classReturn == 0) {
            intro = (IntroController) a;
        } else {
            if (classReturn == 1) {
                twoPlayerLocalController = (TwoPlayerLocalController) a;
            } else {
                twoPlayerLanController = (TwoPlayerLanController) a;
            }
        }
    }
    
    private void btnSetMouseClicked() {
        if (chkBoard.isSelected()) {
            this.setColorBoard();
        }
        if (chkCrossO.isSelected()) {
            this.setColorO();
            btnIcoO.setForeground(TwoPlayerLocalController.colorO);
        }
        if (chkCrossX.isSelected()) {
            this.setColorX();
            btnIcoX.setForeground(TwoPlayerLocalController.colorX);
        }
        if (TwoPlayerLocalController.isIconUsed) {
            TwoPlayerLocalController.icoO = new ImageIcon(getImageResource(select_icon1));
            TwoPlayerLocalController.icoX = new ImageIcon(getImageResource(select_icon2));
            TwoPlayerLanController.icoO = new ImageIcon(getImageResource(select_icon1));
            TwoPlayerLanController.icoX = new ImageIcon(getImageResource(select_icon2));
        } else {
            boolean found=false;
            if (!txtIcoO.getText().equals("")) {
                if (txtIcoO.getText().length() == 1) {
                    TwoPlayerLocalController.crossO = txtIcoO.getText();
                    btnIcoO.setText(TwoPlayerLocalController.crossO);
                    TwoPlayerLanController.crossO = txtIcoO.getText();
                } else {
                    found=true;
                }
            }
            if (!txtIcoX.getText().equals("")) {
                if (txtIcoX.getText().length() == 1) {
                    TwoPlayerLocalController.crossX = txtIcoX.getText();
                    btnIcoX.setText(TwoPlayerLocalController.crossX);
                    TwoPlayerLanController.crossX = txtIcoX.getText();
                } else {
                    found=true;
                }
            }
            if (found==true){
//                JOptionPane.showMessageDialog(rootPane, "This cross have only ONE charater");
            }
        }
    }

    private void btnBackMouseClicked() {
        if (classReturn == 0) {
        	intro.getView().setVisible(true);
        } else {
            if (classReturn == 1) {
                twoPlayerLocalController.getView().setVisible(true);
                if (twoPlayerLocalController.isGameStart()) {
                    twoPlayerLocalController.continueTimer();
                }
                if (!twoPlayerLocalController.getChoosePlayer()) {
//                    twoPlayerLocalController.getUser().setVisible(true);
                }
            } else {
                twoPlayerLanController.getView().setVisible(true);
            }
        }
        IntroController.isSettingSelected = false;
        view.setVisible(false);
    }
    
    private URL getImageResource(String iconResource) {
    	return getClass().getClassLoader().getResource(iconResource);
    }
    
    private void listValueChanged() {
        IconType select = iconTypeList.getSelectedValue();
        this.setEmptyIcon();
        
        if(select == IconType.Default) {
        	TwoPlayerLocalController.isIconUsed = false;
            TwoPlayerLanController.isIconUsed = false;
            btnIcoO.setText(PrimitiveConstants.O);
            btnIcoO.setFont(new Font("Lato", 1, 36));
            btnIcoO.setForeground(TwoPlayerLocalController.colorO);
            btnIcoX.setText(TwoPlayerLocalController.crossX);
            btnIcoX.setFont(new Font("Lato", 1, 36));
            btnIcoX.setForeground(TwoPlayerLocalController.colorX);
            txtIcoO.setEnabled(true);
            txtIcoX.setEnabled(true);
        } else {
        	switch (select) {
    		case SocialNetwork:
    			select_icon1 = ResourceConstants.ICONFACEBOOK;
                select_icon2 = ResourceConstants.ICONINSTAGRAM;
    			break;
    		case Food:
                select_icon1 = ResourceConstants.ICONBURGER;
                select_icon2 = ResourceConstants.ICONVEGETABLES;
    			break;
    		case Human:
                select_icon1 = ResourceConstants.ICONMAN;
                select_icon2 = ResourceConstants.ICONWOMAN;
    			break;
    		case Vehicle:
                select_icon1 = ResourceConstants.ICONJEEP;
                select_icon2 = ResourceConstants.ICONCAR;
    			break;
    		case Superhero:
                select_icon1 = ResourceConstants.ICONSUPERMAN;
                select_icon2 = ResourceConstants.ICONBATMAN;
    			break;
    		case SearchEngine:
                select_icon1 = ResourceConstants.ICONCHROME;
                select_icon2 = ResourceConstants.ICONFIREFOX;
    			break;
    		case Smartphone:
                select_icon1 = ResourceConstants.ICONWINDOWS;
                select_icon2 = ResourceConstants.ICONAPPLE;
    			break;
			default:
				System.out.println(PrimitiveConstants.WRONGICONCHOOSEN);
				break;
    		}
	        TwoPlayerLocalController.isIconUsed = true;
	        TwoPlayerLanController.isIconUsed = true;
            btnIcoO.setIcon(new ImageIcon(getImageResource(select_icon1)));
            btnIcoX.setIcon(new ImageIcon(getImageResource(select_icon2)));
            txtIcoO.setEnabled(false);
            txtIcoX.setEnabled(false);
        }
        
        if (TwoPlayerLocalController.isIconUsed) {
            chkCrossO.setEnabled(false);
            chkCrossX.setEnabled(false);
        } else {
            chkCrossO.setEnabled(true);
            chkCrossX.setEnabled(true);
        }
    }

    private void btnResetMouseClicked() {
        TwoPlayerLocalController.colorBoard = Color.white;
        TwoPlayerLocalController.colorO = Color.GREEN;
        TwoPlayerLocalController.colorX = Color.RED;
        TwoPlayerLocalController.isIconUsed = false;
        TwoPlayerLocalController.crossO = PrimitiveConstants.O;
        TwoPlayerLocalController.crossX = PrimitiveConstants.X;
        
        TwoPlayerLanController.colorBoard = Color.white;
        TwoPlayerLanController.colorO = Color.GREEN;
        TwoPlayerLanController.colorX = Color.RED;
        TwoPlayerLanController.isIconUsed = false;
        TwoPlayerLanController.crossO = PrimitiveConstants.O;
        TwoPlayerLanController.crossX = PrimitiveConstants.X;
        iconTypeList.setSelectedIndex(0);
        btnIcoO.setText(PrimitiveConstants.O);
        btnIcoO.setForeground(TwoPlayerLanController.colorO);
        btnIcoO.setIcon(null);
        btnIcoX.setText(PrimitiveConstants.X);
        btnIcoX.setForeground(TwoPlayerLanController.colorX);
        btnIcoX.setIcon(null);
        txtIcoO.setText("");
        txtIcoX.setText("");
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
            Logger.getLogger(SettingController.class.getName()).log(Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            Logger.getLogger(SettingController.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            Logger.getLogger(SettingController.class.getName()).log(Level.SEVERE, null, ex);
        } catch (UnsupportedLookAndFeelException ex) {
            Logger.getLogger(SettingController.class.getName()).log(Level.SEVERE, null, ex);
        }

        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new SettingController().getView().setVisible(true);
            }
        });
    }
	
	private JButton btnBack;
    private JButton btnIcoO;
    private JButton btnIcoX;
    private JButton btnReset;
    private JButton btnSet;
    private JCheckBox chkBoard;
    private JCheckBox chkCrossO;
    private JCheckBox chkCrossX;
    private JColorChooser colorChooser;
    private JList<IconType> iconTypeList;
    private JTextField txtIcoO;
    private JTextField txtIcoX;
}
