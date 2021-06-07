package components.frame;

import javax.swing.*;

import utils.constants.ResourceConstants;
import utils.constants.PrimitiveConstants;
import views.BaseView;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.awt.event.*;

public class DrawResultFrame extends BaseView {

    public DrawResultFrame() {
    	super();
    }

    @Override
    protected void initNewJComponents() {
    	jPanel1 = new JPanel();
        lbltictactoe = new JLabel();
        btnOk = new JButton();
        lblDrawTitle = new JLabel();
        lblIconTopRight = new JLabel();
        lblIconBotLeft = new JLabel();
        lblIconTopLeft = new JLabel();
    }
    
    @Override
    protected void initViewComponents() {
    	super.initViewComponents();
    	
        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setBorder(BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 2));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        lbltictactoe.setIcon(new ImageIcon(getClass().getClassLoader().getResource(ResourceConstants.ICONTICTACTOE)));
        jPanel1.add(lbltictactoe, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 130, -1, -1));

        btnOk.setBackground(new java.awt.Color(255, 255, 255));
        btnOk.setFont(new java.awt.Font("Lato", 1, 24));
        btnOk.setText(PrimitiveConstants.OK);
        btnOk.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnOkMouseClicked(evt);
            }
        });
        jPanel1.add(btnOk, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 290, 128, -1));

        lblDrawTitle.setFont(new java.awt.Font("Lato", 1, 36));
        lblDrawTitle.setText(PrimitiveConstants.DRAW.toUpperCase());
        jPanel1.add(lblDrawTitle, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 70, -1, -1));

        lblIconTopRight.setIcon(new ImageIcon(getClass().getClassLoader().getResource(ResourceConstants.ICONCONFETTI1)));
        jPanel1.add(lblIconTopRight, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 0, -1, -1));

        lblIconBotLeft.setIcon(new ImageIcon(getClass().getClassLoader().getResource(ResourceConstants.ICONCONFETTI2)));
        jPanel1.add(lblIconBotLeft, new org.netbeans.lib.awtextra.AbsoluteConstraints(-10, 280, -1, -1));

        lblIconTopLeft.setIcon(new ImageIcon(getClass().getClassLoader().getResource(ResourceConstants.ICONCONFETTI)));
        jPanel1.add(lblIconTopLeft, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, -1));

        GroupLayout layout = new GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, GroupLayout.PREFERRED_SIZE, 389, GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );


        setDefaultCloseOperation(WindowConstants.DO_NOTHING_ON_CLOSE);
        setUndecorated(true);
        addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent evt) {
                formWindowClosing(evt);
            }
        });
        
        pack();
        setLocationRelativeTo(null);
        setVisible(true);
    }
    private void btnOkMouseClicked(MouseEvent evt) {
        this.dispose();
    }
    private void formWindowClosing(WindowEvent evt) {
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
            Logger.getLogger(DrawResultFrame.class.getName()).log(Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            Logger.getLogger(DrawResultFrame.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            Logger.getLogger(DrawResultFrame.class.getName()).log(Level.SEVERE, null, ex);
        } catch (UnsupportedLookAndFeelException ex) {
            Logger.getLogger(DrawResultFrame.class.getName()).log(Level.SEVERE, null, ex);
        }

        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new DrawResultFrame().setVisible(true);
            }
        });
    }

    private JButton btnOk; //jButton1
    private JLabel lbltictactoe; //jLabel1
    private JLabel lblDrawTitle; //jLabel2
    private JLabel lblIconTopRight; //jLabel3
    private JLabel lblIconBotLeft; //jLabel4
    private JLabel lblIconTopLeft; //jLabel5
    private JPanel jPanel1; //jPanel1

}
