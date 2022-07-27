/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package com.cis.frames;


import cameraframe.CameraCallbackComplete;
import cameraframe.CameraCallbackConnection;
import cameraframe.CameraCallbackPosition;
import cameraframe.CameraCallbackPreview;
import cameraframe.CameraCapture;
import static cameraframe.CameraResultsConst.CAMERA_ERROR_OK;
import cameraframe.CameraUser;
import cameraframe.JFrameCamera;
import camerascanner.FaceImage;
import camerasdk.objects.Image;
import com.utils.Constants;
import com.utils.Functions;
import java.awt.Color;
import java.text.ParseException;
import javax.swing.border.EmptyBorder;
import javax.swing.text.MaskFormatter;

import static com.cis.frames.JFrameLogin.usuario;
import static com.cis.frames.JFrameLogin.perfil;
import static java.awt.Image.SCALE_SMOOTH;
import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.util.Iterator;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import javax.imageio.ImageReadParam;
import javax.imageio.ImageReader;
import javax.imageio.stream.ImageInputStream;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;


/**
 *
 * @author kevin
 */
public final  class JFrameInserirCpf extends javax.swing.JFrame implements CameraCallbackPosition, CameraCallbackConnection, CameraCallbackPreview, CameraCallbackComplete{
    
    private static final int DEBUG_ENABLE = 1;
    private static final int TIME_RECONNECT = 3000;
    
    int intStatus;
    boolean bolCameraControlInitialize = false;
    boolean bolCameraControlStarted = false;
    boolean bolCameraControlConnect = false;
    boolean bolCameraControlFinalize = false;
    CameraUser objCameraUser = new CameraUser();
    Thread threadReconnet;
    
    static String cpf;
    
    String textBemVindoLine1;
    String textBemVindoLine2;
    static Boolean camera = false;
    static Boolean leitor = false;
    
    //**************************************************************************
    // Function fncShowDebugLogMsg
    //**************************************************************************    
    private void fncShowDebugLogMsg(String strMessage){
        if(DEBUG_ENABLE == 1){
            System.out.println(strMessage);
        }
    }
    
    /**
     * Creates new form JFrameInserirCpf
     */
    public JFrameInserirCpf() {
        initComponents();
                
        //CameraCapture.fncRegisterCallbackJFrame(this);
        
        try {
            intStatus = objCameraUser.fncInitialize();            
            if(intStatus == CAMERA_ERROR_OK){
                bolCameraControlInitialize = true;
                bolCameraControlFinalize = false;
                System.out.println("camera iniciou");
            }
            else{
                JOptionPane.showMessageDialog(null,"Erro no Initialize !","Camera Status", JOptionPane.INFORMATION_MESSAGE);
                System.out.println("camera nao iniciou");
            }
        }
        catch(Exception ex){
            fncShowDebugLogMsg("Exception: " + ex.getMessage());
            JOptionPane.showMessageDialog(null,"Erro no Initialize - exception !","Camera Status", JOptionPane.INFORMATION_MESSAGE);
            System.out.println("camera inicar exception");
        }
        
        loadImages();
        initHeader();
        setTexts();
    }
        
    public void loadImages() {

        ImageIcon footerImage = new ImageIcon("E:\\ciswk_git\\KitbioCEFApp\\KitbioCefApp\\src\\main\\Resources\\footer_complete.png");
        ImageIcon footerImageResized = Functions.scaleImage(footerImage.getImage(), jPanel3.getWidth(), jPanel3.getHeight(), Constants.SCALE_SMOOTH);
        jFooter.setIcon(footerImageResized);

    }

    public void initHeader() {
        jDataText.setText(Functions.getHeaderData());
        jUserName.setText("Olá, " + usuario);
        jPerfil.setText("Perfil: " + perfil);

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

    public void setTexts() {
        
        textBemVindoLine1 = "Bem-vindo ao sistema de cadastro de autenticação biométrica!";
        textBemVindoLine2 = "Para mais funcionalidades e informações, acesse <font color='blue'><u>https://biometria.caixa</u></font> ou consulte o MN AD178.";
        jBemVindoText.setBorder(new EmptyBorder(0, 20, 0, 0));
        jBemVindoText.setText("<html>" + textBemVindoLine1 + "<br/>" + textBemVindoLine2 + "</html>");
        
    }
    
    public boolean getCamera(){
        return camera;
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
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
        jBemVindoText = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        try {
            MaskFormatter mascaraCpf = new MaskFormatter(" ###.###.###-##");
            mascaraCpf.setPlaceholderCharacter('_');
            jCpfTextField = new javax.swing.JFormattedTextField(mascaraCpf);
            jCpfTextField.setColumns(11);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        jLabel2 = new javax.swing.JLabel();
        jButton2 = new javax.swing.JButton();
        jPanel3 = new javax.swing.JPanel();
        jFooter = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);
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

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));
        jPanel2.setPreferredSize(new java.awt.Dimension(1366, 526));

        jBemVindoText.setBackground(new java.awt.Color(197, 224, 180));
        jBemVindoText.setFont(new java.awt.Font("Arial", 1, 16)); // NOI18N
        jBemVindoText.setForeground(new java.awt.Color(56, 87, 35));
        jBemVindoText.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jBemVindoText.setText("Frase");
        jBemVindoText.setOpaque(true);

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/digital_logo.png"))); // NOI18N
        jLabel1.setText("jLabel1");

        jCpfTextField.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        jCpfTextField.setForeground(new java.awt.Color(105, 195, 181));
        jCpfTextField.setText("CPF");
        jCpfTextField.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(105, 195, 181)));
        jCpfTextField.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jCpfTextFieldMouseClicked(evt);
            }
        });

        jLabel2.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(105, 195, 181));
        jLabel2.setText("Digite o CPF:");

        jButton2.setBackground(new java.awt.Color(105, 195, 181));
        jButton2.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jButton2.setForeground(new java.awt.Color(255, 255, 255));
        jButton2.setText("Consultar");
        jButton2.setBorder(null);
        jButton1.setContentAreaFilled(false);
        jButton2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jButton2MouseClicked(evt);
            }
        });
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(22, 22, 22)
                        .addComponent(jBemVindoText, javax.swing.GroupLayout.PREFERRED_SIZE, 1324, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(364, 364, 364)
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 96, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(30, 30, 30)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jCpfTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 467, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel2)
                            .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 172, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(20, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jBemVindoText, javax.swing.GroupLayout.PREFERRED_SIZE, 67, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(97, 97, 97)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabel2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jCpfTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 52, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jLabel1))
                .addContainerGap(222, Short.MAX_VALUE))
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

    private void jCpfTextFieldMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jCpfTextFieldMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_jCpfTextFieldMouseClicked

    private void jButton2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton2MouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton2MouseClicked

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        // TODO add your handling code here:
        
        cpf = jCpfTextField.getText();
        // ************ VERIFICAR CPF *****************
        
        this.setVisible(false);
        
        JFrameIncluirAttCadastro cadFrame = new JFrameIncluirAttCadastro();
        cadFrame.setSize(1366,768);
        cadFrame.setLocationRelativeTo(null);
        cadFrame.setVisible(true);
        
    }//GEN-LAST:event_jButton2ActionPerformed

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
            java.util.logging.Logger.getLogger(JFrameInserirCpf.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(JFrameInserirCpf.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(JFrameInserirCpf.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(JFrameInserirCpf.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new JFrameInserirCpf().setVisible(true);
            }
        });
    }
    
    // Callback Position
    //@Override
    public void eventCallbackPosition(String strEvent, int intResult) {
        //lblPosicionamento.setText(strEvent);
    }
    
    // Callback Connection
    @Override
    public void eventCallbackConnection(String strEvent, int intResult) {
        
        try {        
        
            Runnable runnableReconnect;
            runnableReconnect = () -> {
                //fncShowDebugLogMsg("Inside : " + Thread.currentThread().getName());
                boolean bolCheckConnection = true;
                while(bolCheckConnection == true){
                    try {
                        if(fncReconnect() == true){
                            bolCheckConnection = false;
                            bolCameraControlConnect = false;
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
                initHeader();
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
                initHeader();
            }
            else{
                fncShowDebugLogMsg("Evento desconhecido !!!");    
            }  

        }
        catch(Exception ex){
            fncShowDebugLogMsg("Exception: " + ex.getMessage());            
        }          
        
    }
    
    
    public Boolean fncReconnect() throws IOException, InterruptedException{
        
        Boolean bolReconnect = false;
        
        try{
            
            if(bolCameraControlFinalize == false){
                bolCameraControlFinalize = true;
                intStatus = objCameraUser.fncFinalize();
                if(intStatus == CAMERA_ERROR_OK){                                    
                    bolCameraControlInitialize = false;
                }  
                else{
                    fncShowDebugLogMsg("Erro reconexao finalize !!!");
                }          
                Thread.sleep(500);
            }

            intStatus = objCameraUser.fncInitialize();
            if(intStatus == CAMERA_ERROR_OK){
                bolCameraControlInitialize = true;
                bolCameraControlFinalize = false;
                bolReconnect = true;
            }        
            else{
                fncShowDebugLogMsg("Erro reconexao initialize !!!");
            }             
            
        }
        catch(Exception ex){
            fncShowDebugLogMsg("Exception - " + ex.getMessage());
        } 
        
        return bolReconnect;
    }
    
    // Callback Preview
    //@Override
    public void eventCallbackPreview(Image faceImage) {
        
        BufferedImage img =  null;
        java.awt.Image scaled = null;
        ImageIcon icon = null;
        
        try {
            if(faceImage.getRawImage() != null){
                img = convertByteToImage(faceImage.getRawImage());
                scaled = img.getScaledInstance(480,640 , SCALE_SMOOTH);
                icon = new ImageIcon(scaled);
            }
        } catch (IOException ex) {
            Logger.getLogger(JFrameCamera.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        img = null;
        scaled = null;
        icon = null;
        faceImage = null;
    }

    // Callback Complete
    //@Override
    public void eventCallbackComplete(FaceImage faceImage, int status) {
        
        BufferedImage img =  null;
        java.awt.Image scaled = null;
        ImageIcon icon = null;
        
        try {
            if(faceImage.getRawImage() != null){
                img = convertByteToImage(faceImage.getRawImage());
                scaled = img.getScaledInstance(480,640 , SCALE_SMOOTH);
                icon = new ImageIcon(scaled);
            }
        } catch (IOException ex) {
            Logger.getLogger(JFrameCamera.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        img = null;
        scaled = null;
        icon = null;
        faceImage = null;
        
    }
    
    private BufferedImage convertByteToImage(byte[] rawImage) throws IOException {
        
        ByteArrayInputStream bis = new ByteArrayInputStream(rawImage);
        Iterator<?> readers = ImageIO.getImageReadersByFormatName("jpg");
 
        ImageReader reader = (ImageReader) readers.next();
        Object source = bis; 
        ImageInputStream iis = ImageIO.createImageInputStream(source); 
        reader.setInput(iis, true);
        ImageReadParam param = reader.getDefaultReadParam();
 
        BufferedImage image = reader.read(0, param);
        
        bis = null;
        readers = null;
        reader = null;
        source = null;
        iis = null;
        param = null;
        
        return image;
        
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jBackground;
    private javax.swing.JLabel jBemVindoText;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jCamera;
    private javax.swing.JTextField jCpfTextField;
    private javax.swing.JLabel jDataText;
    private javax.swing.JLabel jFooter;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLeitor;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JLabel jPerfil;
    private javax.swing.JLabel jUserName;
    // End of variables declaration//GEN-END:variables
}
