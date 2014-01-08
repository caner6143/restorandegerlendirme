package com.templates;

import com.restoran.core.mySession;
import com.restoran.core.mySessionService;
import com.restoran.data.DataAccess;
import java.awt.Cursor;
import java.awt.event.KeyEvent;
import java.beans.PropertyVetoException;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFrame;
import javax.swing.JInternalFrame;
import javax.swing.JOptionPane;
import javax.swing.event.InternalFrameEvent;
import javax.swing.event.InternalFrameListener;
import main.adminIslem;
import main.degerlendirmeRead;
import main.restoranIslem;
import main.yeniMain;

public class menu extends javax.swing.JFrame {
 

    @Override
    public void dispose() {
        super.dispose();
    }
    @Override
    public void removeAll() {
        super.removeAll();
    }
    
    private static JInternalFrame frameOku = null;
    private static JInternalFrame frameRes = null;
    private static JInternalFrame frameDeg = null;
    private static JInternalFrame frameKullanici = null;
    mySession mYs = null;
    private static mySessionService myService = null;

    public menu() {
        initComponents();
        mySession.clearItems();
        kullaniciGoster.setVisible(false);
        loginArayuz.setVisible(false);
        realMenu.setEnabled(false);
        yardimPencere.setVisible(false);
        logOut.setVisible(false);
    }
    
    public void start(){
        
        removeAll();
        dispose();
        logOut.setVisible(false);
        frameOku = null;
        frameDeg = null;
        frameKullanici = null;
        frameRes = null ;
        JFrame frame = new menu();
        frame.setVisible(true);
    }
    
    public void saatAndTarih() {

        String sSql = "", sSql1 = "", tarih = "", saat = "";
        sSql += "select tarh,saat from kisi where username = '";
        sSql += mySession.getUsername() + "'";
        ResultSet rs = DataAccess.Select(sSql);

        try {
            while (rs.next()) {
                tarih = rs.getDate("tarh").toString();
                saat = rs.getTime("saat").toString();

            }
        } catch (SQLException ex) {
            Logger.getLogger(menu.class.getName()).log(Level.SEVERE, null, ex);
        }
        lablTarih.setText(tarih);
        lablSaat.setText(saat);

        sSql1 += "UPDATE kisi set tarh=CURDATE(),saat = CURTIME() where username = '";
        sSql1 += mySession.getUsername().trim() + "'";

        DataAccess.InsertDeleteUpdate(sSql1);
    }

    public void checkIdentity() {

        txAdmin.setCursor(Cursor.getPredefinedCursor(Cursor.WAIT_CURSOR));
        txAdmin.transferFocusBackward();

        char[] pass = new char[1];
        pass = txPass.getPassword();
        String sStr = "";
        for (int i = 0; i < pass.length; i++) {
            sStr += pass[i];
        }
        if (myService == null) {
            myService = new mySessionService();
        }


        boolean result = mySessionService.checkUser(txAdmin.getText(), sStr);

        if (result) {

            if ("3".equals(mySession.getYetkiID())) {
                kullanici.setVisible(false);
                isletme.setVisible(false);
            } else if ("2".equals(mySession.getYetkiID())) {
                kullanici.setVisible(false);
            }


            kullaniciGoster.setVisible(true);
            realMenu.setEnabled(true);
            loginArayuz.setVisible(false);
            txAdmin.setText("");
            txPass.setText("");
            login.setVisible(false);
            logOut.setVisible(true);
        }
        nametext.setText(mySession.getName().toUpperCase());
        surnametext.setText(mySession.getSurname().toUpperCase());
        usernametext.setText(mySession.getUsername().toUpperCase());

        saatAndTarih();

    }

    public void logOutRun() {
        mySession.clearItems();
        login.setEnabled(true);
        kullaniciGoster.setVisible(false);
        realMenu.setEnabled(false);
        nametext.setText(mySession.getName().toUpperCase());
        surnametext.setText(mySession.getSurname().toUpperCase());
        usernametext.setText(mySession.getUsername().toUpperCase());
        

        start();
        
    }

    public void degerlendirMenu() {

        if (frameOku == null) {
            {
                frameOku = new degerlendirmeRead();

                jDesktopPane2.add(frameOku);
                frameOku.addInternalFrameListener(new InternalFrameListener() {

                    @Override
                    public void internalFrameOpened(InternalFrameEvent e) {
                    }

                    @Override
                    public void internalFrameClosing(InternalFrameEvent e) {
                    }

                    @Override
                    public void internalFrameClosed(InternalFrameEvent e) {
                        frameOku = null;
                    }

                    @Override
                    public void internalFrameIconified(InternalFrameEvent e) {
                    }

                    @Override
                    public void internalFrameDeiconified(InternalFrameEvent e) {
                    }

                    @Override
                    public void internalFrameActivated(InternalFrameEvent e) {
                    }

                    @Override
                    public void internalFrameDeactivated(InternalFrameEvent e) {
                    }
                });
            }
            try {
                frameOku.setMaximum(rootPaneCheckingEnabled);
            } catch (PropertyVetoException ex) {
                Logger.getLogger(menu.class.getName()).log(Level.SEVERE, null, ex);
            }
            frameOku.setMaximizable(true);
            frameOku.setIconifiable(rootPaneCheckingEnabled);
            frameOku.setClosable(rootPaneCheckingEnabled);
            frameOku.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
            frameOku.setResizable(true);
            frameOku.setEnabled(true);
            frameOku.setVisible(true);

        }
    }

    public void kullaniciMenu() {

        if (frameKullanici == null) {
            {
                frameKullanici = new adminIslem();

                jDesktopPane2.add(frameKullanici);
                frameKullanici.addInternalFrameListener(new InternalFrameListener() {

                    @Override
                    public void internalFrameOpened(InternalFrameEvent e) {
                    }

                    @Override
                    public void internalFrameClosing(InternalFrameEvent e) {
                    }

                    @Override
                    public void internalFrameClosed(InternalFrameEvent e) {
                        frameKullanici = null;
                    }

                    @Override
                    public void internalFrameIconified(InternalFrameEvent e) {
                    }

                    @Override
                    public void internalFrameDeiconified(InternalFrameEvent e) {
                    }

                    @Override
                    public void internalFrameActivated(InternalFrameEvent e) {
                    }

                    @Override
                    public void internalFrameDeactivated(InternalFrameEvent e) {
                    }
                });
            }
            try {
                frameKullanici.setMaximum(rootPaneCheckingEnabled);
            } catch (PropertyVetoException ex) {
                Logger.getLogger(menu.class.getName()).log(Level.SEVERE, null, ex);
            }
            frameKullanici.setMaximizable(true);
            frameKullanici.setIconifiable(rootPaneCheckingEnabled);
            frameKullanici.setClosable(rootPaneCheckingEnabled);
            frameKullanici.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
            frameKullanici.setResizable(true);
            frameKullanici.setEnabled(true);
            frameKullanici.setVisible(true);

        }

    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jMenuItem4 = new javax.swing.JMenuItem();
        jMenuItem5 = new javax.swing.JMenuItem();
        jMenuItem6 = new javax.swing.JMenuItem();
        jDesktopPane2 = new javax.swing.JDesktopPane();
        loginArayuz = new javax.swing.JInternalFrame();
        jLabel1 = new javax.swing.JLabel();
        txAdmin = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        txPass = new javax.swing.JPasswordField();
        loginButton = new javax.swing.JButton();
        yardimPencere = new javax.swing.JInternalFrame();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTextArea1 = new javax.swing.JTextArea();
        kullaniciGoster = new javax.swing.JDesktopPane();
        aktifKullanici = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        usernametext = new javax.swing.JLabel();
        jSeparator1 = new javax.swing.JSeparator();
        jLabel4 = new javax.swing.JLabel();
        nametext = new javax.swing.JLabel();
        lablSaat = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        surnametext = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        lablTarih = new javax.swing.JLabel();
        menuCubugu = new javax.swing.JMenuBar();
        realMenu = new javax.swing.JMenu();
        kullanici = new javax.swing.JMenuItem();
        degerlendir = new javax.swing.JMenuItem();
        isletme = new javax.swing.JMenuItem();
        degerlendirMenu = new javax.swing.JMenu();
        loginMenu = new javax.swing.JMenu();
        login = new javax.swing.JMenuItem();
        logOut = new javax.swing.JMenuItem();
        yardim = new javax.swing.JMenu();
        yardimMenu = new javax.swing.JMenuItem();
        jMenu1 = new javax.swing.JMenu();

        jMenuItem4.setText("jMenuItem4");

        jMenuItem5.setText("jMenuItem5");

        jMenuItem6.setText("jMenuItem6");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("DEĞERLENDİRME PROGRAMI");
        setAlwaysOnTop(true);
        setBackground(new java.awt.Color(204, 204, 204));
        setBounds(new java.awt.Rectangle(200, 100, 0, 0));
        setResizable(false);

        jDesktopPane2.setBackground(new java.awt.Color(204, 204, 204));
        jDesktopPane2.setForeground(new java.awt.Color(255, 51, 0));
        jDesktopPane2.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jDesktopPane2.setDoubleBuffered(true);

        loginArayuz.setBackground(java.awt.Color.lightGray);
        loginArayuz.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        loginArayuz.setClosable(true);
        loginArayuz.setDefaultCloseOperation(javax.swing.WindowConstants.HIDE_ON_CLOSE);
        loginArayuz.setIconifiable(true);
        loginArayuz.setTitle("LOGİN PANEL");
        loginArayuz.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        loginArayuz.setFocusCycleRoot(false);
        loginArayuz.setOpaque(true);
        loginArayuz.setVisible(true);

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel1.setText("Kullanıcı Adı");

        txAdmin.setForeground(new java.awt.Color(51, 0, 0));
        txAdmin.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txAdminKeyPressed(evt);
            }
        });

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel2.setText("Şifre");

        txPass.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txPassKeyPressed(evt);
            }
        });

        loginButton.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        loginButton.setText("Giriş");
        loginButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                loginButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout loginArayuzLayout = new javax.swing.GroupLayout(loginArayuz.getContentPane());
        loginArayuz.getContentPane().setLayout(loginArayuzLayout);
        loginArayuzLayout.setHorizontalGroup(
            loginArayuzLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(loginArayuzLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(loginArayuzLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(loginButton, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(loginArayuzLayout.createSequentialGroup()
                        .addGroup(loginArayuzLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel1)
                            .addComponent(jLabel2))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 23, Short.MAX_VALUE)
                        .addGroup(loginArayuzLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txPass, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txAdmin, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        loginArayuzLayout.setVerticalGroup(
            loginArayuzLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(loginArayuzLayout.createSequentialGroup()
                .addGap(17, 17, 17)
                .addGroup(loginArayuzLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txAdmin, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(29, 29, 29)
                .addGroup(loginArayuzLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txPass, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(loginButton)
                .addContainerGap(29, Short.MAX_VALUE))
        );

        loginArayuz.setBounds(240, 100, 230, 204);
        jDesktopPane2.add(loginArayuz, javax.swing.JLayeredPane.DEFAULT_LAYER);

        yardimPencere.setClosable(true);
        yardimPencere.setDefaultCloseOperation(javax.swing.WindowConstants.HIDE_ON_CLOSE);
        yardimPencere.setIconifiable(true);
        yardimPencere.setVisible(true);

        jTextArea1.setColumns(20);
        jTextArea1.setEditable(false);
        jTextArea1.setFont(new java.awt.Font("Lucida Console", 0, 12)); // NOI18N
        jTextArea1.setRows(5);
        jTextArea1.setText("\tBu program işletmeler hakkında değerlendirme yapma, yapılan\ndeğerlendirmeleri okuma kullanıcı ekleme, çıkarma, işletme ekleme,\nsilme işlemlerini yapmaktadır. Değerlendirme yapma işlemini herkes\nyapabilir fakat diğer özellikleri kullanabilmeniz için aktif kullanıcı\nolmanız yani giriş yapmanız gerekmektedir.");
        jScrollPane1.setViewportView(jTextArea1);

        javax.swing.GroupLayout yardimPencereLayout = new javax.swing.GroupLayout(yardimPencere.getContentPane());
        yardimPencere.getContentPane().setLayout(yardimPencereLayout);
        yardimPencereLayout.setHorizontalGroup(
            yardimPencereLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 514, Short.MAX_VALUE)
        );
        yardimPencereLayout.setVerticalGroup(
            yardimPencereLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 155, Short.MAX_VALUE)
        );

        yardimPencere.setBounds(40, 150, 530, 184);
        jDesktopPane2.add(yardimPencere, javax.swing.JLayeredPane.DEFAULT_LAYER);

        kullaniciGoster.setBackground(java.awt.SystemColor.activeCaption);
        kullaniciGoster.setBorder(javax.swing.BorderFactory.createMatteBorder(1, 1, 1, 1, new java.awt.Color(153, 0, 0)));

        aktifKullanici.setBackground(new java.awt.Color(255, 255, 255));
        aktifKullanici.setFont(new java.awt.Font("Tahoma", 3, 18)); // NOI18N
        aktifKullanici.setLabelFor(jDesktopPane2);
        aktifKullanici.setText("AKTİF KULLANCI :");
        aktifKullanici.setBounds(20, 20, 170, 60);
        kullaniciGoster.add(aktifKullanici, javax.swing.JLayeredPane.DEFAULT_LAYER);

        jLabel3.setFont(new java.awt.Font("Tahoma", 2, 12)); // NOI18N
        jLabel3.setText("Kullanıcı : ");
        jLabel3.setBounds(10, 90, 80, 30);
        kullaniciGoster.add(jLabel3, javax.swing.JLayeredPane.DEFAULT_LAYER);

        usernametext.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        usernametext.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        usernametext.setBounds(20, 120, 160, 40);
        kullaniciGoster.add(usernametext, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jSeparator1.setBounds(0, 170, 260, 10);
        kullaniciGoster.add(jSeparator1, javax.swing.JLayeredPane.DEFAULT_LAYER);

        jLabel4.setFont(new java.awt.Font("Tahoma", 2, 12)); // NOI18N
        jLabel4.setText("Kullanıcı Bilgileri : ");
        jLabel4.setBounds(10, 190, 140, 30);
        kullaniciGoster.add(jLabel4, javax.swing.JLayeredPane.DEFAULT_LAYER);

        nametext.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        nametext.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        nametext.setBounds(30, 230, 160, 40);
        kullaniciGoster.add(nametext, javax.swing.JLayeredPane.DEFAULT_LAYER);

        lablSaat.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        lablSaat.setBounds(50, 420, 130, 40);
        kullaniciGoster.add(lablSaat, javax.swing.JLayeredPane.DEFAULT_LAYER);

        jLabel6.setFont(new java.awt.Font("Tahoma", 2, 12)); // NOI18N
        jLabel6.setText("İsim : ");
        jLabel6.setBounds(10, 230, 60, 40);
        kullaniciGoster.add(jLabel6, javax.swing.JLayeredPane.DEFAULT_LAYER);

        surnametext.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        surnametext.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        surnametext.setBounds(40, 280, 160, 40);
        kullaniciGoster.add(surnametext, javax.swing.JLayeredPane.DEFAULT_LAYER);

        jLabel7.setFont(new java.awt.Font("Tahoma", 2, 12)); // NOI18N
        jLabel7.setText("Soyisim : ");
        jLabel7.setBounds(10, 280, 60, 40);
        kullaniciGoster.add(jLabel7, javax.swing.JLayeredPane.DEFAULT_LAYER);

        jLabel8.setFont(new java.awt.Font("Tahoma", 2, 12)); // NOI18N
        jLabel8.setText("Son Ziyaret Zamanı : ");
        jLabel8.setBounds(10, 330, 130, 40);
        kullaniciGoster.add(jLabel8, javax.swing.JLayeredPane.DEFAULT_LAYER);

        lablTarih.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        lablTarih.setBounds(50, 370, 130, 40);
        kullaniciGoster.add(lablTarih, javax.swing.JLayeredPane.DEFAULT_LAYER);

        menuCubugu.setBackground(new java.awt.Color(204, 204, 204));
        menuCubugu.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        menuCubugu.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N

        realMenu.setText("Menü");
        realMenu.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N

        kullanici.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_A, java.awt.event.InputEvent.CTRL_MASK));
        kullanici.setText("Kullanıcı İşlemleri");
        kullanici.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                kullaniciMousePressed(evt);
            }
        });
        kullanici.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                kullaniciActionPerformed(evt);
            }
        });
        realMenu.add(kullanici);

        degerlendir.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_D, java.awt.event.InputEvent.CTRL_MASK));
        degerlendir.setText("Değerlendirme Oku");
        degerlendir.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                degerlendirMousePressed(evt);
            }
        });
        degerlendir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                degerlendirActionPerformed(evt);
            }
        });
        realMenu.add(degerlendir);

        isletme.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_S, java.awt.event.InputEvent.CTRL_MASK));
        isletme.setText("İşletme İşlemleri");
        isletme.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                isletmeMousePressed(evt);
            }
        });
        isletme.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                isletmeActionPerformed(evt);
            }
        });
        realMenu.add(isletme);

        menuCubugu.add(realMenu);

        degerlendirMenu.setText("Değerlendirme Yap");
        degerlendirMenu.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        degerlendirMenu.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                degerlendirMenuMousePressed(evt);
            }
        });
        menuCubugu.add(degerlendirMenu);

        loginMenu.setText("Giriş yap");
        loginMenu.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N

        login.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_L, java.awt.event.InputEvent.CTRL_MASK));
        login.setText("Online");
        login.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                loginMousePressed(evt);
            }
        });
        login.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                loginActionPerformed(evt);
            }
        });
        loginMenu.add(login);

        logOut.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_K, java.awt.event.InputEvent.CTRL_MASK));
        logOut.setText("Offline");
        logOut.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                logOutMousePressed(evt);
            }
        });
        logOut.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                logOutActionPerformed(evt);
            }
        });
        loginMenu.add(logOut);

        menuCubugu.add(loginMenu);

        yardim.setText("Yardım");
        yardim.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N

        yardimMenu.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_F1, 0));
        yardimMenu.setText("Yardım");
        yardimMenu.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                yardimMenuMousePressed(evt);
            }
        });
        yardimMenu.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                yardimMenuActionPerformed(evt);
            }
        });
        yardim.add(yardimMenu);

        menuCubugu.add(yardim);

        jMenu1.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jMenu1.setLabel("Çıkış");
        jMenu1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                jMenu1MousePressed(evt);
            }
        });
        menuCubugu.add(jMenu1);

        setJMenuBar(menuCubugu);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jDesktopPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 755, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(kullaniciGoster, javax.swing.GroupLayout.PREFERRED_SIZE, 250, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jDesktopPane2)
            .addGroup(layout.createSequentialGroup()
                .addComponent(kullaniciGoster, javax.swing.GroupLayout.PREFERRED_SIZE, 527, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void loginMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_loginMousePressed
        loginArayuz.setVisible(true);
    }//GEN-LAST:event_loginMousePressed

    private void loginActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_loginActionPerformed
        loginMousePressed(null);
    }//GEN-LAST:event_loginActionPerformed

    private void loginButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_loginButtonActionPerformed
        checkIdentity();
    }//GEN-LAST:event_loginButtonActionPerformed

    private void logOutActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_logOutActionPerformed
        logOutRun();
    }//GEN-LAST:event_logOutActionPerformed

    private void logOutMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_logOutMousePressed
        logOutRun();
    }//GEN-LAST:event_logOutMousePressed

    private void txAdminKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txAdminKeyPressed
        if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
            txAdmin.transferFocus();
        }
    }//GEN-LAST:event_txAdminKeyPressed

    private void txPassKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txPassKeyPressed
        if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
            loginButtonActionPerformed(null);
        }
    }//GEN-LAST:event_txPassKeyPressed

    private void degerlendirMenuMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_degerlendirMenuMousePressed

        if (frameDeg == null) {
            {
                frameDeg = new yeniMain();
                jDesktopPane2.add(frameDeg);
                frameDeg.addInternalFrameListener(new InternalFrameListener() {

                    @Override
                    public void internalFrameOpened(InternalFrameEvent e) {
                        //JOptionPane.showMessageDialog(null, "frame acıldı");
                    }

                    @Override
                    public void internalFrameClosing(InternalFrameEvent e) {
                    }

                    @Override
                    public void internalFrameClosed(InternalFrameEvent e) {
                        frameDeg = null;
                    }

                    @Override
                    public void internalFrameIconified(InternalFrameEvent e) {
                    }

                    @Override
                    public void internalFrameDeiconified(InternalFrameEvent e) {
                    }

                    @Override
                    public void internalFrameActivated(InternalFrameEvent e) {
                    }

                    @Override
                    public void internalFrameDeactivated(InternalFrameEvent e) {
                    }
                });
            }
            try {
                frameDeg.setMaximum(rootPaneCheckingEnabled);
            } catch (PropertyVetoException ex) {
                Logger.getLogger(menu.class.getName()).log(Level.SEVERE, null, ex);
            }
            frameDeg.setMaximizable(true);
            frameDeg.setIconifiable(rootPaneCheckingEnabled);
            frameDeg.setClosable(rootPaneCheckingEnabled);
            frameDeg.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
            frameDeg.setResizable(true);
            frameDeg.setEnabled(true);
            frameDeg.setVisible(true);

        }
    }//GEN-LAST:event_degerlendirMenuMousePressed

    private void degerlendirMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_degerlendirMousePressed
        degerlendirMenu();
    }//GEN-LAST:event_degerlendirMousePressed

    private void degerlendirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_degerlendirActionPerformed
        degerlendirMenu();
    }//GEN-LAST:event_degerlendirActionPerformed

    private void isletmeMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_isletmeMousePressed
        if (frameRes == null) {
            {
                frameRes = new restoranIslem();
                jDesktopPane2.add(frameRes);
                frameRes.addInternalFrameListener(new InternalFrameListener() {

                    @Override
                    public void internalFrameOpened(InternalFrameEvent e) {
                    }

                    @Override
                    public void internalFrameClosing(InternalFrameEvent e) {
                    }

                    @Override
                    public void internalFrameClosed(InternalFrameEvent e) {
                        frameRes = null;
                    }

                    @Override
                    public void internalFrameIconified(InternalFrameEvent e) {
                    }

                    @Override
                    public void internalFrameDeiconified(InternalFrameEvent e) {
                    }

                    @Override
                    public void internalFrameActivated(InternalFrameEvent e) {
                    }

                    @Override
                    public void internalFrameDeactivated(InternalFrameEvent e) {
                    }
                });
            }

            frameRes.setMaximizable(true);
            frameRes.setIconifiable(rootPaneCheckingEnabled);
            frameRes.setClosable(rootPaneCheckingEnabled);
            frameRes.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
            frameRes.setResizable(true);
            frameRes.setEnabled(true);
            frameRes.setVisible(true);

        }
    }//GEN-LAST:event_isletmeMousePressed

    private void yardimMenuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_yardimMenuActionPerformed
        yardimPencere.setVisible(true);
    }//GEN-LAST:event_yardimMenuActionPerformed

    private void yardimMenuMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_yardimMenuMousePressed
        yardimPencere.setVisible(true);
    }//GEN-LAST:event_yardimMenuMousePressed

    private void kullaniciMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_kullaniciMousePressed
        kullaniciMenu();
    }//GEN-LAST:event_kullaniciMousePressed

    private void kullaniciActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_kullaniciActionPerformed
        kullaniciMenu();
    }//GEN-LAST:event_kullaniciActionPerformed

    private void jMenu1MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jMenu1MousePressed
        System.exit(WIDTH);
    }//GEN-LAST:event_jMenu1MousePressed

    private void isletmeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_isletmeActionPerformed
        if (frameRes == null) {
            {
                frameRes = new restoranIslem();
                jDesktopPane2.add(frameRes);
                frameRes.addInternalFrameListener(new InternalFrameListener() {

                    @Override
                    public void internalFrameOpened(InternalFrameEvent e) {
                    }

                    @Override
                    public void internalFrameClosing(InternalFrameEvent e) {
                    }

                    @Override
                    public void internalFrameClosed(InternalFrameEvent e) {
                        frameRes = null;
                    }

                    @Override
                    public void internalFrameIconified(InternalFrameEvent e) {
                    }

                    @Override
                    public void internalFrameDeiconified(InternalFrameEvent e) {
                    }

                    @Override
                    public void internalFrameActivated(InternalFrameEvent e) {
                    }

                    @Override
                    public void internalFrameDeactivated(InternalFrameEvent e) {
                    }
                });
            }

            frameRes.setMaximizable(true);
            frameRes.setIconifiable(rootPaneCheckingEnabled);
            frameRes.setClosable(rootPaneCheckingEnabled);
            frameRes.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
            frameRes.setResizable(true);
            frameRes.setEnabled(true);
            frameRes.setVisible(true);

        } 
    }//GEN-LAST:event_isletmeActionPerformed

    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(menu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(menu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(menu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(menu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        
        java.awt.EventQueue.invokeLater(new Runnable() {

            @Override
            public void run() {
                new menu().setVisible(true);
            }
        });
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    javax.swing.JLabel aktifKullanici;
    javax.swing.JMenuItem degerlendir;
    javax.swing.JMenu degerlendirMenu;
    javax.swing.JMenuItem isletme;
    javax.swing.JDesktopPane jDesktopPane2;
    javax.swing.JLabel jLabel1;
    javax.swing.JLabel jLabel2;
    javax.swing.JLabel jLabel3;
    javax.swing.JLabel jLabel4;
    javax.swing.JLabel jLabel6;
    javax.swing.JLabel jLabel7;
    javax.swing.JLabel jLabel8;
    javax.swing.JMenu jMenu1;
    javax.swing.JMenuItem jMenuItem4;
    javax.swing.JMenuItem jMenuItem5;
    javax.swing.JMenuItem jMenuItem6;
    javax.swing.JScrollPane jScrollPane1;
    javax.swing.JSeparator jSeparator1;
    javax.swing.JTextArea jTextArea1;
    javax.swing.JMenuItem kullanici;
    javax.swing.JDesktopPane kullaniciGoster;
    javax.swing.JLabel lablSaat;
    javax.swing.JLabel lablTarih;
    javax.swing.JMenuItem logOut;
    javax.swing.JMenuItem login;
    javax.swing.JInternalFrame loginArayuz;
    javax.swing.JButton loginButton;
    javax.swing.JMenu loginMenu;
    javax.swing.JMenuBar menuCubugu;
    javax.swing.JLabel nametext;
    javax.swing.JMenu realMenu;
    javax.swing.JLabel surnametext;
    javax.swing.JTextField txAdmin;
    javax.swing.JPasswordField txPass;
    javax.swing.JLabel usernametext;
    javax.swing.JMenu yardim;
    javax.swing.JMenuItem yardimMenu;
    javax.swing.JInternalFrame yardimPencere;
    // End of variables declaration//GEN-END:variables

}