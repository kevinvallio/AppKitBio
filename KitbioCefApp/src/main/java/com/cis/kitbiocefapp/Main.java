/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.cis.kitbiocefapp;

import com.cis.frames.JFrameLogin;
import java.io.IOException;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

/**
 *
 * @author kevin
 */
public class Main {
    
    private static final int DEBUG_ENABLE = 1;
    private static final Logger logger = LogManager.getLogger(Main.class);
    
    //**************************************************************************
    // Function fncShowDebugLogMsg
    //**************************************************************************    
    private static void fncShowDebugLogMsg(String strMessage){
        if(DEBUG_ENABLE == 1){
            System.out.println(strMessage);
        }
    }
    
    public static void main(String[] args) {
        java.awt.EventQueue.invokeLater(() -> {
            
            JFrameLogin login = new JFrameLogin();
            login.setLocationRelativeTo(null);
            login.setSize(360,430);
            login.setVisible(true);
        
        });
        
    }
}
