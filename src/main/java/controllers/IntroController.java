package controllers;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.logging.Level;

import utils.constants.PrimitiveConstants;
import views.*;
public class IntroController extends BaseController{

	private IntroView view;
	
	private SettingController settingController;
    private TwoPlayerLocalController twoPlayerLocalController;
    private TwoPlayerLanController twoPlayerLanController;
//    private User user;
    private boolean isTwoLocalSelected, isTwoLanSelected;
    public static boolean isSettingSelected;
	
	public IntroController() {
		super();
		this.view = new IntroView();
		initView();
		isTwoLocalSelected = false;
        isTwoLanSelected = false;
        isSettingSelected = false;
        
        initController();
	}
	
	@Override
	public void initView() {
	}
	
	@Override
	public void initController() {
		JButton a = new JButton();
		view.getBtnSetting().addActionListener(e -> handleSettingButtonClicked());
		
		view.getBtnLAN().addActionListener(e -> handleLANButtonClicked());
		
		view.getBtnTwo().addActionListener(e -> handleLocalButtonClicked());
		
	}
	

    public void createSettingFrame() {
        settingController = new SettingController();
        isSettingSelected = true;
        SettingController.classReturn = 0; 
        settingController.setBackForm(this);
        settingController.getView().setVisible(true);        
        view.setVisible(false);
    }

    public void setSettingController(SettingController a) {
        this.settingController = (SettingController) a;
    }

    public void setSettingButton(boolean a){
        view.getBtnSetting().setEnabled(a);
    }
    
    public void setEnabledSetting(boolean a){
    	view.getBtnSetting().setEnabled(a);
    }
    
    public void createMainClass(boolean kt) {
        if (kt == false) {
            twoPlayerLocalController = new TwoPlayerLocalController();
            //MainClassTwo.isTwoLanSelected=kt;
            isTwoLocalSelected = true;
            twoPlayerLocalController.setMenuController(this); 
            twoPlayerLocalController.getView().setVisible(true);
//            user = new User(); 
//            twoPlayerLocalController.setUserController(user); 
//            user.setVisible(true);
//            user.setMainClass(twoPlayerLocalController);
            twoPlayerLocalController.getNewGame().setEnabled(false);
            twoPlayerLocalController.setSettingController(settingController);
            view.setVisible(false);
        } else {
            twoPlayerLanController = new TwoPlayerLanController();
            //MainClassTwo.isTwoLanSelected=kt;
            isTwoLanSelected = true;
//            twoPlayerLanController.setMenuClass(this);
//            twoPlayerLanController.setVisible(true);
//            twoPlayerLanController.getNewGame().setEnabled(false);
//            twoPlayerLanController.setSettingController(settingController);
            view.setVisible(false);
        }
    }
	
    private void handleSettingButtonClicked() {
        if (IntroController.isSettingSelected == false) {
            this.createSettingFrame();
            IntroController.isSettingSelected = true;
        } else {
            settingController.getView().setVisible(true);
            view.setVisible(false);
            SettingController.classReturn = 0;
            settingController.setBackForm(this);
        }
    }
    private void handleLocalButtonClicked() {
        if (isTwoLocalSelected == false) {
            this.createMainClass(false);
        } else {
            twoPlayerLocalController.getView().setVisible(true);
//            user.setVisible(true);
            view.setVisible(false);
        }
        
    }

    private void handleLANButtonClicked() {
        if (isTwoLanSelected == false) {
            this.createMainClass(true);
        } else {
            twoPlayerLanController.getView().setVisible(true);
            view.setVisible(false);
        }
    }
    
    public static void main(String args[]) {
    	try {
            for (javax.swing.UIManager.LookAndFeelInfo info : UIManager.getInstalledLookAndFeels()) {
                if (PrimitiveConstants.WINDOWS.equals(info.getName())) {
                    UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(IntroController.class.getName()).log(Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(IntroController.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(IntroController.class.getName()).log(Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(IntroController.class.getName()).log(Level.SEVERE, null, ex);
        }

        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
            	new IntroController().initController();
            }
        });
    }
    
    @Override
    public BaseView getView() {
		return view;
	}
}
