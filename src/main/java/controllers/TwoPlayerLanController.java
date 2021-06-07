package controllers;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Point;
import java.awt.event.ActionEvent;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.Inet4Address;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.swing.ImageIcon;
import javax.swing.JButton;

import components.frame.DrawResultFrame;
import components.frame.WinnerResultFrame;
import utils.constants.PrimitiveConstants;
import utils.wincheck.CheckWinHelper;
import utils.wincheck.CheckWinType;
import views.BaseView;
import views.TwoPlayerLanView;

public class TwoPlayerLanController extends BaseController {

	private TwoPlayerLanView twoPlayerLanView;
	
    private JButton b[][];
    private boolean tick[][];
    private boolean check[][];
    private int iUndo[];
    private int jUndo[];
    private int sizeUndo;
    private SettingController setting;
    private boolean sett = true; 
    private boolean newGame = false;
    private boolean menu = true;
    private IntroController intro;
    private boolean flag = true;
    public static int r = 16, c = 20;
    public static int count = 0;
    public static boolean isIconUsed = false;
    public static String crossO = "O", crossX = "X";
    public static Color colorO = Color.GREEN, colorX = Color.RED, colorBoard = Color.WHITE;
    public static ImageIcon icoO = new ImageIcon(), icoX = new ImageIcon();

    //Choi online
    private boolean back[][];
    private boolean server = false, online = false; // Kiem tra xem server hay client da online chua
    private ServerSocket listener = null; // tao socket cho server
    private Socket socket = null; // tao socket cho client
    private BufferedReader is = null; // doc du lieu tu trong socket
    private BufferedWriter os = null; // ghi du lieu vao trong socket
    private String IP = "localhost"; // IP
    //"10.3.52.16"
    private int PORT = 3333; // PORT

    public TwoPlayerLanController() {
    	this.twoPlayerLanView = new TwoPlayerLanView();
    	initView();
    	initController();
        initBoard();
    }

    public void initBoard() {
        b = new JButton[r][c];
        tick = new boolean[r][c];
        check = new boolean[r][c];
        back = new boolean[r][c];//online
        iUndo = new int[r * c];
        jUndo = new int[r * c];
        sizeUndo = 0;
        int i, j;
        int x = 0, y = 0;
        for (i = 0; i < r; i++) {
            for (j = 0; j < c; j++) {
                // Khoi tao tick & caro
                b[i][j] = new JButton();
                b[i][j].setSize(50, 50);
                b[i][j].setVisible(true);
                b[i][j].setLocation(new Point(x, y));
                b[i][j].setBackground(Color.GRAY);
                b[i][j].setFont(new Font("Lato", 1, 28));
                b[i][j].setActionCommand(i + " " + j);
                b[i][j].addActionListener(e -> actionPerformed(e));
                paneBoard.add(b[i][j]);
                tick[i][j] = false;
                check[i][j] = false;
                back[i][j] = false;
                x += 50;
                // khoi tao mang undo
                iUndo[j] = jUndo[j] = -1;
            }
            y += 50;
            x = 0;
        }
        String myIP = new String("Can't not find your ip!!!!");
        try {
            myIP = Inet4Address.getLocalHost().getHostAddress();
        } catch (UnknownHostException ex) {
            Logger.getLogger(TwoPlayerLanController.class.getName()).log(Level.SEVERE, null, ex);
        }
        lblYourIP.setText("Your IP: " + myIP);
    }

    public void setCheckedCross(int i, int j) {
        if (!isIconUsed) {
            //Khong dung icon
            if (count == 0) {
                b[i][j].setText(crossO);
                b[i][j].setForeground(colorO);
                tick[i][j] = false;
                check[i][j] = false;
                lbMove.setText("X player");
            } else {
                b[i][j].setText(crossX);
                b[i][j].setForeground(colorX);
                tick[i][j] = false;
                check[i][j] = false;
                lbMove.setText("O player");
            }
        } else {
            //Neu dung icon
            if (count == 0) {
                b[i][j].setIcon(TwoPlayerLanController.icoO);
                tick[i][j] = false; //online
                check[i][j] = false;
            } else {
                b[i][j].setIcon(TwoPlayerLanController.icoX);
                tick[i][j] = false;
                check[i][j] = false;
            }
        }
        if (this.peaceGame() == true) { //fix
            DrawResultFrame p = new DrawResultFrame();
            p.setVisible(true);
            this.pauseGame();
            this.flag = false;
        }
        iUndo[sizeUndo] = i;
        jUndo[sizeUndo] = j;
        sizeUndo++;
        count = 1 - count;
    }

    public void pauseGame() {
        for (int i = 0; i < r; i++) {
            for (int j = 0; j < c; j++) {
                b[i][j].setBackground(Color.GRAY);
                tick[i][j] = false;
                check[i][j] = false;
            }
        }
        this.btnSetting.setEnabled(true);
        this.newGame = true;
        this.btnNewGame.setEnabled(true);
        this.sett = true;
        this.btnMenu.setEnabled(true);
        this.menu = true;
    }

    public void startGame() {
        for (int i = 0; i < r; i++) {
            for (int j = 0; j < c; j++) {
                b[i][j].setBackground(Color.WHITE);
                tick[i][j] = true;
                check[i][j] = true;
                b[i][j].setText("");
                b[i][j].setIcon(null);
//                if (!isIconUsed) {
//                    b[i][j].setText("");
//                } else {
//                    b[i][j].setIcon(null);
//                    b[i][j].setIcon(new ImageIcon());
//                }
            }
        }
        paneBoard.setBackground(colorBoard);
        this.flag = true;
        if (online) { //online
            if (!server) {
                this.blockPlayer();
                this.resetBack();
            }
            this.read();
        }

    }

    public void undoGame() {
        b[iUndo[sizeUndo - 1]][jUndo[sizeUndo - 1]].setText("");
        sizeUndo--;
    }

    public void undoGameIcon() {
        b[iUndo[sizeUndo - 1]][jUndo[sizeUndo - 1]].setIcon(null);
        sizeUndo--;
    }

    // Che do choi online
    public void connetor() { // Kiem tra phai chuong trinh la ben kia la server thi ket noi, try catch ben minh la server 
        try { //Client 
            socket = new Socket(IP, PORT); // Ket noi socket vao ip va port
            System.out.println("Client: Connect Server OK");
            is = new BufferedReader(new InputStreamReader(socket.getInputStream())); //tao buffer de doc du lieu tu socket
            os = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream())); // tao buffer de ghi du lieu vao socket
        } catch (IOException ex) {
            try { // Server
                listener = new ServerSocket(PORT); // tao ra socket server
                Thread wait = new Thread() {
                    public void run() {
                        try {
                            socket = listener.accept(); // Lang nghe va chap nhan khi client ket noi
                            System.out.println("Server: Connect Client OK");
                            is = new BufferedReader(new InputStreamReader(socket.getInputStream()));
                            os = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));
                            server = true;
                        } catch (IOException ex1) {
                            Logger.getLogger(TwoPlayerLanController.class.getName()).log(Level.SEVERE, null, ex1);
                        }
                    }
                };
                wait.start();
            } catch (IOException ex1) {
                Logger.getLogger(TwoPlayerLanController.class.getName()).log(Level.SEVERE, null, ex1);
            }

        } finally {
            online = true; // Danh dau la  online
        }

    }

    public void send(int i, int j, int who, boolean winner) { // Gui thong tin nguoi chien thang di
        String kq = i + " " + j + "," + who + "-" + winner;
        try {
            os.write(kq);
            os.newLine();
            os.flush();
            System.out.println("Has sent: " + kq);
        } catch (IOException ex) {
            Logger.getLogger(TwoPlayerLanController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void read() {
        Thread wait = new Thread() {
            private boolean winner = false;

            public void run() {
                int i, j, who = 0;
                while (true) {
                    try {
                        String st = is.readLine();
                        int vt1 = st.indexOf(" ");
                        int vt2 = st.indexOf(",");
                        int vt3 = st.indexOf("-");

                        boolean win = false;
                        try { // Cat chuoi
                            i = Integer.parseInt(st.substring(0, vt1));
                            j = Integer.parseInt(st.substring(vt1 + 1, vt2));
                            who = Integer.parseInt(st.substring(vt2 + 1, vt3));
                            win = Boolean.parseBoolean(st.substring(vt3 + 1));
                            winner = win;
                            unBlockPlayer();
                            setCheckedCross(i, j);// doi cho

                        } catch (Exception ex1) {
                            System.out.println("Khong dich duoc chuoi");
                        }
                    } catch (IOException ex) {
                    }
                    if (winner == true) { // Xac dinh nguoi choi chien thang
                        //JOptionPane.showMessageDialog(new JDialog(), winner + " is winner");
                        String t = new String();
                        if (who == 1) {
                            t = "X";
                        } else {
                            t = "O";
                        }
                        new WinnerResultFrame(t+" Player");
                        pauseGame();
                        flag = false;
                        break;
                    }
                }

            }
        };
        wait.start();

    }

    public void blockPlayer() {
        this.resetBack();
        for (int i = 0; i < r; i++) {
            for (int j = 0; j < c; j++) {
                if (tick[i][j] == false) {
                    back[i][j] = true;
                }
                if (tick[i][j] == true) {
                    tick[i][j] = false; 
                }
            }
        }
    }

    public void unBlockPlayer() {
        for (int i = 0; i < r; i++) {
            for (int j = 0; j < c; j++) {
                if (back[i][j] == false) {
                    tick[i][j] = true;
                }
            }
        }
    }

    public void resetBack() { //online
        for (int i = 0; i < r; i++) {
            for (int j = 0; j < c; j++) {
                back[i][j] = false;
            }
        }
    }

    public boolean getOnline() {
        return online;
    }

    public void setMenuClass(IntroController a) {
        this.intro = a;
    }

    public void setSettingClass(SettingController a) {
        this.setting = (SettingController) a;
    }

    public JButton getNewGame() {
        return this.btnNewGame;
    }

    public boolean peaceGame() {
        int i, j;
        int found = 0;
        for (i = 0; i < r; i++) {
            for (j = 0; j < c; j++) {
                if (check[i][j] == false) {
                    found++;
                }
            }
        }
        if (found == r * c) {
            return true;
        }
        return false;
    }

    public void actionPerformed(ActionEvent e) {
        try {
            String evt = new String(e.getActionCommand());
            int flag = evt.indexOf(" ");
            int i = Integer.parseInt(evt.substring(0, flag));
            int j = Integer.parseInt(evt.substring(flag + 1));
            String winner = new String();
            if (count == 0) {
                winner = "O";
            } else {
                winner = "X";
            }
            if (tick[i][j]) {
                this.setCheckedCross(i, j);
                if (online == true) //online
                {
                    this.blockPlayer();
                }
                if (isIconUsed) {
                    if (CheckWinHelper.CheckWinPlayer(b, i, j, 5, CheckWinType.ICON)) {
                        //JOptionPane.showMessageDialog(new JDialog(), winner + " is winner");
                        WinnerResultFrame w = new WinnerResultFrame(winner+" Player");
                        w.setVisible(true);
                        this.pauseGame();
                        this.flag = false;
                    }
                } else {
                    if (CheckWinHelper.CheckWinPlayer(b, i, j, 5, CheckWinType.TEXT)) {
                        //JOptionPane.showMessageDialog(new JDialog(), winner + " is winner");
                    	WinnerResultFrame w = new WinnerResultFrame(winner+" Player");
                        w.setVisible(true);
                        this.pauseGame();
                        this.flag = false;
                    }
                }
                if (online) { //online
                    this.send(i, j, 1 - count, !this.flag);
                }
            }
        } catch (Exception ex) {
            System.out.println(ex);
        }

    }

    private void handleNewGameButtonClicked() {
        if (newGame == true) {
            this.resetBack();
            startGame();
            lbMove.setText("O player");
            this.sett = false;
            this.btnNewGame.setEnabled(false);
            this.newGame = false;
            this.menu = false;
            this.btnMenu.setEnabled(false);
            this.btnSetting.setEnabled(false);
            count = 0;
        }
    }

    private void handleSettingClicked() {
        if (this.sett == true) {
            if (IntroController.isSettingSelected == false) {
                setting = new SettingController();
                IntroController.isSettingSelected = true;
                intro.setSettingController(setting);
            }
            setting.getView().setVisible(true);
            SettingController.classReturn = 2;
//            setting.getView().setBackForm(this);
            this.getView().setVisible(false);
//        setting = new SettingClass();
//        setting.setVisible(true);
//        this.dispose();
        }
    }

    private void handleConnectLAN() {
        this.IP = txtIP.getText();
        this.connetor(); //online
        lbConnect.setText("Connect Status: Connected");
        this.btnNewGame.setEnabled(true);
        this.newGame = true;
    }

    private void handleShowMenu() {
        if (this.menu == true) {
            intro.getView().setVisible(true);
            this.getView().setVisible(false);
        }
    }
	
    public static void main(String args[]) {
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if (PrimitiveConstants.NIMBUS.equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(TwoPlayerLanController.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(TwoPlayerLanController.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(TwoPlayerLanController.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(TwoPlayerLanController.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }

        EventQueue.invokeLater(new Runnable() {
            public void run() {
                new TwoPlayerLanController().getView().setVisible(true);
            }
        });
    }
	
	@Override
	void initView() {
		btnConnect = twoPlayerLanView.getBtnConnect();
		btnMenu = twoPlayerLanView.getBtnMenu();
		btnNewGame = twoPlayerLanView.getBtnNewGame();
		btnSetting = twoPlayerLanView.getBtnSetting();
		lbConnect = twoPlayerLanView.getLbConnect();
		txtIP = twoPlayerLanView.getTxtIP();
		paneBoard = twoPlayerLanView.getPaneBoard();
		lbMove = twoPlayerLanView.getLbMove();
		lblYourIP = twoPlayerLanView.getLblYourIP();
	}

	@Override
	void initController() {
		btnConnect.addActionListener(l -> handleConnectLAN());
		btnMenu.addActionListener(l->handleShowMenu());
		btnSetting.addActionListener(l -> handleSettingClicked());
		btnNewGame.addActionListener(l -> handleNewGameButtonClicked());
	}

	@Override
	BaseView getView() {
		return twoPlayerLanView;
	}

    private javax.swing.JButton btnConnect;
    private javax.swing.JButton btnMenu;
    private javax.swing.JButton btnNewGame;
    private javax.swing.JButton btnSetting;
    private javax.swing.JLabel lbConnect;
    private javax.swing.JLabel lblYourIP;
    private javax.swing.JLabel lbMove;
    private javax.swing.JPanel paneBoard;
    private javax.swing.JTextField txtIP;
}
