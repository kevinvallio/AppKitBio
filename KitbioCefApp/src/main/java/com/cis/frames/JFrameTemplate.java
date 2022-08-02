/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package com.cis.frames;

import cameraframe.CameraCallbackConnection;
import cameraframe.CameraCapture;
import static cameraframe.CameraResultsConst.CAMERA_ERROR_OK;
import cameraframe.CameraUser;
import static com.cis.frames.JFrameLogin.perfil;
import static com.cis.frames.JFrameLogin.usuario;
import com.utils.Constants;
import com.utils.Functions;
import fingerframe.FingerCallbackConnection;
import fingerframe.FingerCapture;
import static fingerframe.FingerResultsConst.FINGER_ERROR_OK;
import fingerframe.FingerUser;
import java.awt.Color;
import java.awt.HeadlessException;
import java.awt.event.WindowAdapter;
import java.io.IOException;
import java.nio.file.Paths;
import java.security.NoSuchAlgorithmException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;

/**
 *
 * @author kevin
 */
//public class JFrameTemplate extends javax.swing.JFrame implements CameraCallbackPosition, CameraCallbackConnection, CameraCallbackPreview, CameraCallbackComplete{
public class JFrameTemplate extends javax.swing.JFrame implements CameraCallbackConnection, FingerCallbackConnection{
    
    private static final int DEBUG_ENABLE = 1;
    private static final int TIME_RECONNECT = 3000;
    
    static Boolean camera = false;
    static Boolean leitor = false;
    
    int intCameraStatus;
    int intFingerStatus;
    
    static boolean bolCameraControlInitialize = false;
    boolean bolCameraControlStarted = false;
    boolean bolCameraControlConnect = false;
    boolean bolCameraControlFinalize = false;
    //static CameraUser objCameraUser = new CameraUser();
    private final WindowAdapter windowAdapter = null;
    Thread threadReconnet;
    
    boolean bolSensorControlInitialize = false;
    boolean bolSensorControlStarted = false;
    boolean bolSensorControlConnect = false;
    boolean bolSensorControlFinalize = false;
    Thread threadReconnect;
    
    String textBemVindoLine1;
    String textBemVindoLine2;
    
    //**************************************************************************
    // Function fncShowDebugLogMsg
    //**************************************************************************    
    private void fncShowDebugLogMsg(String strMessage){
        if(DEBUG_ENABLE == 1){
            System.out.println(strMessage);
        }
    }
    
    /**
     * Creates new form JFrameIncluirAttCadastro
     */
    public JFrameTemplate() {
        
        String userDirectory = Paths.get("")
                .toAbsolutePath()
                .toString();
        System.out.println(userDirectory);
        this.fncRegisterListenerJFrameWindow();
        
        initCamera();
        initSensor();
    }
    
    
    public void initCamera(){
        
        //*********************************************
        // Registro de Callback para Evento de Conexão
        //*********************************************
        CameraCapture.fncRegisterCallbackJFrame(this);
        
        try {
            intCameraStatus = CameraUser.fncInitialize();            
            if(intCameraStatus == CAMERA_ERROR_OK){
                bolCameraControlInitialize = true;
                bolCameraControlFinalize = false;
                System.out.println("camera iniciou");
            }
            else{
                JOptionPane.showMessageDialog(null,"Erro no Initialize !","Camera Status", JOptionPane.INFORMATION_MESSAGE);
                System.out.println("camera nao iniciou");
            }
        }
        catch(HeadlessException | IOException ex){
            fncShowDebugLogMsg("Exception: " + ex.getMessage());
            JOptionPane.showMessageDialog(null,"Erro no Initialize - exception !","Camera Status", JOptionPane.INFORMATION_MESSAGE);
            System.out.println("camera inicar exception");
        }
        
    }
    
    public void initSensor(){

        //*********************************************
        // Registro de Callback para Evento de Conexão
        //*********************************************
        FingerCapture.fncRegisterCallbackJFrame(this);
        
        try {            
            intFingerStatus = FingerUser.fncInitialize();
            if(intFingerStatus == FINGER_ERROR_OK){
                bolSensorControlInitialize = true;  
                bolSensorControlFinalize = false;
                intFingerStatus = FingerUser.fncConfigure();
                if(intFingerStatus == FINGER_ERROR_OK){
                    System.out.println("Sensor configurou");
                }
                else{
                    JOptionPane.showMessageDialog(null,"Erro no Configure !","Sensor Status", JOptionPane.INFORMATION_MESSAGE);
                }                
            }
            else{
                JOptionPane.showMessageDialog(null,"Erro no Initialize !","Sensor Status", JOptionPane.INFORMATION_MESSAGE);
            }            
        } catch (IOException | NoSuchAlgorithmException | InterruptedException ex) {
            Logger.getLogger(JFrameTemplate.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(null,"Erro no Initialize - exception !","Sensor Status", JOptionPane.INFORMATION_MESSAGE);
        }
        
    }
    
    public void loadImages() {

        ImageIcon footerImage = new ImageIcon(".\\src\\main\\Resources\\footer_complete.png");
        ImageIcon footerImageResized = Functions.scaleImage(footerImage.getImage(), jPanel3.getWidth(), jPanel3.getHeight(), Constants.SCALE_SMOOTH);
        jFooter.setIcon(footerImageResized);

    }
    
    public void initHeader() {
        jDataText.setText(Functions.getHeaderData());
        jUserName.setText("Olá, " + usuario);
        jPerfil.setText("Perfil: " + perfil);
        
        setConnectionText();

    }
    
    public void setConnectionText(){
        
        if (camera) {
            jCamera.setText("Câmera conectada");
            jCamera.setForeground(Color.black);
        } else {
            jCamera.setText("Câmera desconectada");
            jCamera.setForeground(Color.red);
        }

        if (leitor) {
            jLeitor.setText("Leitor biométrico conectado");
            jLeitor.setForeground(Color.black);
        } else {
            jLeitor.setText("Leitor biométrico desconectado");
            jLeitor.setForeground(Color.red);
        }
    }


    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jDataText = new javax.swing.JLabel();
        jUserName = new javax.swing.JLabel();
        jPerfil = new javax.swing.JLabel();
        jCamera = new javax.swing.JLabel();
        jLeitor = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        jBackground = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jPanel3 = new javax.swing.JPanel();
        jFooter = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);
        setResizable(false);

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setPreferredSize(new java.awt.Dimension(1366, 141));

        jDataText.setFont(new java.awt.Font("Arial", 1, 15)); // NOI18N
        jDataText.setForeground(new java.awt.Color(255, 255, 255));
        jDataText.setText("Data");

        jUserName.setFont(new java.awt.Font("Arial", 1, 20)); // NOI18N
        jUserName.setForeground(new java.awt.Color(255, 255, 255));
        jUserName.setText("Name");

        jPerfil.setFont(new java.awt.Font("Arial", 1, 20)); // NOI18N
        jPerfil.setForeground(new java.awt.Color(255, 255, 255));
        jPerfil.setText("Perfil");

        jCamera.setFont(new java.awt.Font("Arial", 1, 20)); // NOI18N
        jCamera.setForeground(new java.awt.Color(255, 255, 255));
        jCamera.setText("Câmera");

        jLeitor.setFont(new java.awt.Font("Arial", 1, 20)); // NOI18N
        jLeitor.setForeground(new java.awt.Color(255, 255, 255));
        jLeitor.setText("Leitor");

        jButton1.setBackground(new java.awt.Color(90, 181, 177));
        jButton1.setFont(new java.awt.Font("Arial", 1, 11)); // NOI18N
        jButton1.setForeground(new java.awt.Color(255, 255, 255));
        jButton1.setText("Sair");
        jButton1.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(255, 255, 255), 1, true));
        jButton1.setContentAreaFilled(false);
        jButton1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jButton1MouseClicked(evt);
            }
        });
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jBackground.setBackground(new java.awt.Color(240, 240, 40));
        jBackground.setIcon(new javax.swing.ImageIcon(getClass().getResource("/header_complete.png"))); // NOI18N
        jBackground.setText("jLabel1");
        jBackground.setMaximumSize(new java.awt.Dimension(1366, 140));
        jBackground.setMinimumSize(new java.awt.Dimension(1366, 140));
        jBackground.setPreferredSize(new java.awt.Dimension(1366, 140));

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(180, 180, 180)
                .addComponent(jUserName, javax.swing.GroupLayout.PREFERRED_SIZE, 380, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(180, 180, 180)
                .addComponent(jPerfil, javax.swing.GroupLayout.PREFERRED_SIZE, 390, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(180, 180, 180)
                .addComponent(jDataText, javax.swing.GroupLayout.PREFERRED_SIZE, 360, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(860, 860, 860)
                .addComponent(jLeitor, javax.swing.GroupLayout.PREFERRED_SIZE, 360, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(860, 860, 860)
                .addComponent(jCamera, javax.swing.GroupLayout.PREFERRED_SIZE, 360, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(1250, 1250, 1250)
                .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addComponent(jBackground, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(50, 50, 50)
                .addComponent(jUserName, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(90, 90, 90)
                .addComponent(jPerfil))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addComponent(jDataText, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(80, 80, 80)
                .addComponent(jLeitor, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(34, 34, 34)
                .addComponent(jCamera, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(50, 50, 50)
                .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addComponent(jBackground, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));
        jPanel2.setPreferredSize(new java.awt.Dimension(1366, 526));

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 1366, Short.MAX_VALUE)
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 526, Short.MAX_VALUE)
        );

        jPanel3.setBackground(new java.awt.Color(255, 255, 255));
        jPanel3.setPreferredSize(new java.awt.Dimension(1366, 100));

        jFooter.setAlignmentY(0.0F);

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jFooter, javax.swing.GroupLayout.PREFERRED_SIZE, 1366, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jFooter, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents
    */
    
    private void initComponentsRefresh(javax.swing.JPanel objJPanelContent) {

        jPanel1 = new javax.swing.JPanel();
        jDataText = new javax.swing.JLabel();
        jUserName = new javax.swing.JLabel();
        jPerfil = new javax.swing.JLabel();
        jCamera = new javax.swing.JLabel();
        jLeitor = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        jBackground = new javax.swing.JLabel();
        jPanel2 = objJPanelContent;
        jPanel3 = new javax.swing.JPanel();
        jFooter = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        //setUndecorated(true);
        setResizable(false);

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setPreferredSize(new java.awt.Dimension(1366, 141));
        jPanel1.setLayout(null);

        jDataText.setFont(new java.awt.Font("Arial", 1, 15)); // NOI18N
        jDataText.setForeground(new java.awt.Color(255, 255, 255));
        jDataText.setText("Data");
        jPanel1.add(jDataText);
        jDataText.setBounds(180, 20, 360, 30);

        jUserName.setFont(new java.awt.Font("Arial", 1, 20)); // NOI18N
        jUserName.setForeground(new java.awt.Color(255, 255, 255));
        jUserName.setText("Name");
        jPanel1.add(jUserName);
        jUserName.setBounds(180, 50, 380, 40);

        jPerfil.setFont(new java.awt.Font("Arial", 1, 20)); // NOI18N
        jPerfil.setForeground(new java.awt.Color(255, 255, 255));
        jPerfil.setText("Perfil");
        jPanel1.add(jPerfil);
        jPerfil.setBounds(180, 90, 390, 24);

        jCamera.setFont(new java.awt.Font("Arial", 1, 20)); // NOI18N
        jCamera.setForeground(new java.awt.Color(255, 255, 255));
        jCamera.setText("Câmera");
        jPanel1.add(jCamera);
        jCamera.setBounds(860, 34, 360, 20);

        jLeitor.setFont(new java.awt.Font("Arial", 1, 20)); // NOI18N
        jLeitor.setForeground(new java.awt.Color(255, 255, 255));
        jLeitor.setText("Leitor");
        jPanel1.add(jLeitor);
        jLeitor.setBounds(860, 80, 360, 30);

        jButton1.setBackground(new java.awt.Color(90, 181, 177));
        jButton1.setFont(new java.awt.Font("Arial", 1, 11)); // NOI18N
        jButton1.setForeground(new java.awt.Color(255, 255, 255));
        jButton1.setText("Sair");
        jButton1.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(255, 255, 255), 1, true));
        jButton1.setContentAreaFilled(false);
        jButton1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jButton1MouseClicked(evt);
            }
        });
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton1);
        jButton1.setBounds(1250, 50, 90, 30);

        jBackground.setBackground(new java.awt.Color(240, 240, 40));
        jBackground.setIcon(new javax.swing.ImageIcon(getClass().getResource("/header_complete.png"))); // NOI18N
        jBackground.setText("jLabel1");
        jBackground.setMaximumSize(new java.awt.Dimension(1366, 140));
        jBackground.setMinimumSize(new java.awt.Dimension(1366, 140));
        jBackground.setPreferredSize(new java.awt.Dimension(1366, 140));
        jPanel1.add(jBackground);
        jBackground.setBounds(0, 0, 1366, 140);
        /*
        jPanel2.setBackground(new java.awt.Color(255, 255, 255));
        jPanel2.setPreferredSize(new java.awt.Dimension(1366, 526));

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 1366, Short.MAX_VALUE)
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 526, Short.MAX_VALUE)
        );
        */
        jPanel3.setBackground(new java.awt.Color(255, 255, 255));
        jPanel3.setPreferredSize(new java.awt.Dimension(1366, 100));

        jFooter.setAlignmentY(0.0F);

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jFooter, javax.swing.GroupLayout.PREFERRED_SIZE, 1366, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jFooter, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>
    
    
    public void UpdateJpanelContent(javax.swing.JPanel objJPanelContent){

        initComponentsRefresh(objJPanelContent);
        loadImages();
        initHeader();
        
    }
    
    
    private void jButton1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton1MouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton1MouseClicked

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        this.setVisible(false);

        JFrameLogin login = new JFrameLogin();
        login.setSize(360, 430);
        login.setLocationRelativeTo(null);
        login.setVisible(true);
    }//GEN-LAST:event_jButton1ActionPerformed

    /**
     * @param args the command line arguments
     */
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
            java.util.logging.Logger.getLogger(JFrameTemplate.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(JFrameTemplate.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(JFrameTemplate.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(JFrameTemplate.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new JFrameTemplate().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jBackground;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jCamera;
    private javax.swing.JLabel jDataText;
    private javax.swing.JLabel jFooter;
    private javax.swing.JLabel jLeitor;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JLabel jPerfil;
    private javax.swing.JLabel jUserName;
    // End of variables declaration//GEN-END:variables

    
    //**************************************************************************
    // Callback para Evento de Conexão/Desconexão da Camera
    //**************************************************************************
    @Override
    public void eventCameraCallbackConnection(String strEvent, int intResult) {
        
        try {        
        
            Runnable runnableReconnect;
            runnableReconnect = () -> {
                //fncShowDebugLogMsg("Inside : " + Thread.currentThread().getName());
                boolean bolCheckConnection = true;
                while(bolCheckConnection == true){
                    try {
                        if(fncCameraReconnect() == true){
                            bolCheckConnection = false;
                            bolCameraControlConnect = false;
                            camera = true;
                            setConnectionText();
                            JOptionPane.showMessageDialog(null,"Camera CONECTADA a USB ! Liberando o uso !","Camera Status", JOptionPane.INFORMATION_MESSAGE);
                        }
                        Thread.sleep(TIME_RECONNECT);
                    } catch (InterruptedException ex) {
                        fncShowDebugLogMsg("Exception: " + ex.getMessage());
                    } catch (IOException ex) {
                        Logger.getLogger(JFrameInserirCpf.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }
            }; 
            threadReconnet = new Thread(runnableReconnect);
         
            if("Camera Desconectada".equals(strEvent)){
                fncShowDebugLogMsg("Recebeu callback de Camera Desconectada !!!");
                camera = false;
                setConnectionText();
                if(bolCameraControlConnect == false){
                    bolCameraControlConnect = true;                     
                    if (JOptionPane.showConfirmDialog(null, 
                                                      "Camera DESCONECTADA da USB ! Gostaria de tentar reconectar ?", "Capture Camera", 
                                                      JOptionPane.YES_NO_OPTION,
                                                      JOptionPane.QUESTION_MESSAGE) == JOptionPane.YES_OPTION){                    
                        //intStatus = objCameraUser.fncFinalize();
                        //if(intStatus == CAMERA_ERROR_OK){                                    
                        //    bolCameraControlInitialize = false;
                        //}                        
                        threadReconnet.start();
                    }
                }
            }
            else if ("Camera Conectada".equals(strEvent)){
                fncShowDebugLogMsg("Recebeu callback de Camera Conectada !!!");
                camera = true;
            }
            else{
                fncShowDebugLogMsg("Evento desconhecido !!!");    
            }  

        }
        catch(HeadlessException ex){
            fncShowDebugLogMsg("Exception: " + ex.getMessage());            
        }          
        
    }
    
    //**************************************************************************
    // Tentativa de Reconexão da Camera
    //**************************************************************************     
    public Boolean fncCameraReconnect() throws IOException, InterruptedException{
        
        Boolean bolReconnect = false;
        
        try{
            
            if(bolCameraControlFinalize == false){
                bolCameraControlFinalize = true;
                intCameraStatus = CameraUser.fncFinalize();
                if(intCameraStatus == CAMERA_ERROR_OK){                                    
                    bolCameraControlInitialize = false;
                }  
                else{
                    fncShowDebugLogMsg("Erro reconexao finalize !!!");
                }          
                Thread.sleep(500);
            }

            intCameraStatus = CameraUser.fncInitialize();
            if(intCameraStatus == CAMERA_ERROR_OK){
                bolCameraControlInitialize = true;
                bolCameraControlFinalize = false;
                bolReconnect = true;
            }        
            else{
                fncShowDebugLogMsg("Erro reconexao initialize !!!");
            }             
            
        }
        catch(IOException | InterruptedException ex){
            fncShowDebugLogMsg("Exception - " + ex.getMessage());
        } 
        
        return bolReconnect;
    }
    
    //**************************************************************************
    // Callback para Evento de Conexão/Desconexão do Sensor
    //**************************************************************************    
    @Override
    public void eventFingerCallbackConnection(String strEvent, int intResult) {
        System.out.println("entrou callback");
        
        try{
            Runnable runnableReconnect;
            runnableReconnect = () -> {
                boolean bolCheckConnection = true;
                while(bolCheckConnection == true){
                    
                    try {
                        if(fncFingerReconnect() == true){
                            bolCheckConnection = false;
                            bolSensorControlConnect = false;
                            leitor = true;
                            setConnectionText();
                            JOptionPane.showMessageDialog(null,"Sensor CONECTADO a USB ! Liberando o uso !","Sensor Status", JOptionPane.INFORMATION_MESSAGE);
                        }
                        Thread.sleep(TIME_RECONNECT);                        
                    } catch (InterruptedException | IOException  ex) {
                        fncShowDebugLogMsg("Exception: " + ex.getMessage());
                    } catch (NoSuchAlgorithmException ex) {
                        Logger.getLogger(JFrameTemplate.class.getName()).log(Level.SEVERE, null, ex);
                    }
                    
                }
            }; 
            threadReconnect = new Thread(runnableReconnect);        
        
            if (strEvent == "onSensorPlug"){
                fncShowDebugLogMsg("Recebeu Callback de Sensor Conectado");
                leitor = true;
            }
            else if(strEvent == "onSensorUnplug"){
                fncShowDebugLogMsg("Recebeu Callback de Sensor Desconectado");
                leitor = false;
                setConnectionText();
                if(bolSensorControlConnect == false){
                    bolSensorControlConnect = true;
                    if (JOptionPane.showConfirmDialog(null, 
                                                      "Sensor DESCONECTADO da USB ! Gostaria de tentar reconectar ?", "Capture Sensor", 
                                                      JOptionPane.YES_NO_OPTION,
                                                      JOptionPane.QUESTION_MESSAGE) == JOptionPane.YES_OPTION){
                        threadReconnect.start();
                    } 
                }
            }
            else{
                fncShowDebugLogMsg("Evento desconhecido !!!"); 
            }
        }
        catch(HeadlessException ex){
            fncShowDebugLogMsg("Exception - " + ex.getMessage()); 
        }
        
    }
    
    //**************************************************************************
    // Tentativa de Reconexão do Sensor
    //**************************************************************************      
    public Boolean fncFingerReconnect() throws IOException, NoSuchAlgorithmException, InterruptedException{
        
        Boolean bolReconnect = false;
        
        try{
            
            intFingerStatus = FingerUser.fncFinalize();
            if(intFingerStatus == FINGER_ERROR_OK){
                bolSensorControlInitialize = false; 
                bolSensorControlStarted = false;
                bolSensorControlFinalize = true;
                Thread.sleep(500);
                intFingerStatus = FingerUser.fncInitialize();
                if(intFingerStatus == FINGER_ERROR_OK){                
                    bolSensorControlInitialize = true;    
                    bolSensorControlFinalize = false;                    
                    intFingerStatus = FingerUser.fncConfigure();
                    if(intFingerStatus == FINGER_ERROR_OK){
                        bolReconnect = true;
                    }
                    else{
                        fncShowDebugLogMsg("Erro reconexao configure !!!");
                    }                  
                }
                else{
                    fncShowDebugLogMsg("Erro reconexao initialize !!!");
                }                          
            } 
            else{                                
                fncShowDebugLogMsg("Erro reconexao finalize");                
            }               
            
        }
        catch(Exception ex){
            fncShowDebugLogMsg("Exception - " + ex.getMessage());                               
        }
        
        return bolReconnect;
    }

    //**************************************************************************
    // Listener de Fechamento do Form
    //**************************************************************************     
    private void fncRegisterListenerJFrameWindow(){
        
        this.addWindowListener(new java.awt.event.WindowAdapter() {
            @Override
            public void windowClosing(java.awt.event.WindowEvent windowEvent) {
                if (JOptionPane.showConfirmDialog(null, 
                                                  "Voce tem certeza que gostaria de sair da Aplicação ?", "Capture Camera", 
                                                  JOptionPane.YES_NO_OPTION,
                                                  JOptionPane.QUESTION_MESSAGE) == JOptionPane.YES_OPTION){                    
                        try {
                            if(bolCameraControlInitialize == true){
                                
                                intCameraStatus = CameraUser.fncStop();
                                if(intCameraStatus == CAMERA_ERROR_OK){
                                    bolCameraControlStarted = false;
                                    
                                    intCameraStatus = CameraUser.fncFinalize();
                                    if(intCameraStatus == CAMERA_ERROR_OK){                                    
                                        bolCameraControlInitialize = false;
                                        bolCameraControlFinalize = true;                                    
                                    }
                                    else{
                                        JOptionPane.showMessageDialog(null,"Erro no Finalize !","Camera Status", JOptionPane.INFORMATION_MESSAGE);
                                    }                                    
                                    
                                }
                                else{
                                    JOptionPane.showMessageDialog(null,"Erro no StopCaptute !","Camera Status", JOptionPane.INFORMATION_MESSAGE);
                                }

                            }
                        }
                        catch(Exception ex){
                            fncShowDebugLogMsg("Exception: " + ex.getMessage());
                            JOptionPane.showMessageDialog(null,"Erro no Finalize - exception !","Camera Status", JOptionPane.INFORMATION_MESSAGE);
                        }
                        finally{
                            if(threadReconnet.isAlive()){
                                threadReconnet.stop();                                
                            }
                            if(threadReconnect.isAlive()){
                                threadReconnect.stop();                                
                            } 
                            threadReconnet = null;
                            threadReconnect = null;
                            System.exit(0);
                        }

                }
            }
        });         
        
    }    
    
}
