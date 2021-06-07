package components.frame;

import javax.swing.*;
import java.util.logging.Level;
import java.util.logging.Logger;

import utils.constants.ResourceConstants;
import utils.constants.PrimitiveConstants;
import views.BaseView;

public class WinnerResultFrame extends BaseView {
	
	public WinnerResultFrame() {
		super();
    }

    public WinnerResultFrame(String name) {
        super();
        lblWinnerName.setText(name);
    }

    protected void initNewJComponents() {
    	jPanel1 = new JPanel();
        lblIsWinner = new JLabel();
        btnOK = new JButton();
        lblIconCup = new JLabel();
        lblWinnerName = new JLabel();
        lblIconTopLeft = new JLabel();
        lblIconTopRight = new JLabel();
        lblIconBotLeft = new JLabel();
        lblIconBotRight = new JLabel();
    }

    @Override
    protected void initViewComponents() {
    	super.initViewComponents();
        
        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setBorder(BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 2));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        lblIsWinner.setFont(new java.awt.Font("Lato", 1, 36)); // NOI18N
        lblIsWinner.setText(PrimitiveConstants.ISWINNER);
        jPanel1.add(lblIsWinner, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 80, -1, -1));

        btnOK.setBackground(new java.awt.Color(255, 255, 255));
        btnOK.setFont(new java.awt.Font("Lato", 1, 24)); // NOI18N
        btnOK.setText(PrimitiveConstants.OK);
        btnOK.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnOKMouseClicked(evt);
            }
        });
        jPanel1.add(btnOK, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 310, 128, 31));

        lblIconCup.setIcon(new ImageIcon(getClass().getClassLoader().getResource(ResourceConstants.ICONTROPHY))); // NOI18N
        jPanel1.add(lblIconCup, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 140, -1, -1));

        lblWinnerName.setFont(new java.awt.Font("Lato", 1, 36)); // NOI18N
        lblWinnerName.setText(PrimitiveConstants.ISWINNER);
        jPanel1.add(lblWinnerName, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 30, -1, -1));

        lblIconTopLeft.setIcon(new ImageIcon(getClass().getClassLoader().getResource(ResourceConstants.ICONCONFETTI))); // NOI18N
        jPanel1.add(lblIconTopLeft, new org.netbeans.lib.awtextra.AbsoluteConstraints(-10, 0, -1, -1));

        lblIconTopRight.setIcon(new ImageIcon(getClass().getClassLoader().getResource(ResourceConstants.ICONCONFETTI1))); // NOI18N
        jPanel1.add(lblIconTopRight, new org.netbeans.lib.awtextra.AbsoluteConstraints(420, 0, -1, -1));

        lblIconBotLeft.setIcon(new ImageIcon(getClass().getClassLoader().getResource(ResourceConstants.ICONCONFETTI2))); // NOI18N
        jPanel1.add(lblIconBotLeft, new org.netbeans.lib.awtextra.AbsoluteConstraints(-10, 280, -1, -1));

        lblIconBotRight.setIcon(new ImageIcon(getClass().getClassLoader().getResource(ResourceConstants.ICONCONFETTI4))); // NOI18N
        lblIconBotRight.setText("lblIconBotRight");
        jPanel1.add(lblIconBotRight, new org.netbeans.lib.awtextra.AbsoluteConstraints(430, 280, -1, -1));

        GroupLayout layout = new GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, GroupLayout.PREFERRED_SIZE, 549, GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
        );
        
        setDefaultCloseOperation(WindowConstants.DO_NOTHING_ON_CLOSE);
        setTitle(PrimitiveConstants.HAPPYTOWIN);
        setUndecorated(true);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosing(java.awt.event.WindowEvent evt) {
                formWindowClosing(evt);
            }
        });

        pack();
        setLocationRelativeTo(null);
        setVisible(true);
    }
    
    private void formWindowClosing(java.awt.event.WindowEvent evt) {
        this.dispose();
    }
    
    private void btnOKMouseClicked(java.awt.event.MouseEvent evt) {
        this.dispose();
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
            Logger.getLogger(WinnerResultFrame.class.getName()).log(Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            Logger.getLogger(WinnerResultFrame.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            Logger.getLogger(WinnerResultFrame.class.getName()).log(Level.SEVERE, null, ex);
        } catch (UnsupportedLookAndFeelException ex) {
            Logger.getLogger(WinnerResultFrame.class.getName()).log(Level.SEVERE, null, ex);
        }

        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new WinnerResultFrame().setVisible(true);
            }
        });
    }

    private JButton btnOK;
    private JLabel lblIconCup; // jLabel1
    private JLabel lblIconTopLeft; // jLabel2
    private JLabel lblIconTopRight; // jLabel3
    private JLabel lblIconBotLeft; // jLabel4
    private JLabel lblIconBotRight; // jLabel5
    private JPanel jPanel1;
    private JLabel lblIsWinner; //lbName
    private JLabel lblWinnerName; //lbName
}
