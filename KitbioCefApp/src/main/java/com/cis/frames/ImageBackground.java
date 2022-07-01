/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.cis.frames;

import com.utils.Constants;
import com.utils.Functions;
import javax.swing.*;
import java.awt.*;


/**
 *
 * @author kevin
 */
public class ImageBackground {
    
    public static void main(String args[]) 
    {
        JFrame frame = new JFrame();
        final ImageIcon icon = new ImageIcon("E:\\ciswk_git\\KitbioCEFApp\\KitbioCefApp\\src\\main\\Resources\\header.png");
        ImageIcon headerLogoResized = Functions.scaleImage(icon.getImage(), 1366, 138, Constants.SCALE_SMOOTH);

        JPanel text = new JPanel()
        {
          Image img = headerLogoResized.getImage();

          // instance initializer
          {setOpaque(false);}
          @Override
          public void paintComponent(Graphics graphics)
          {
            graphics.drawImage(img, 0, 0, this);
            super.paintComponent(graphics);
          }
        };
        JScrollPane pane = new JScrollPane(text);
        Container content = frame.getContentPane();
        content.add(pane, BorderLayout.CENTER);
        frame.setDefaultCloseOperation(3);
        frame.setSize(1366, 138);
        frame.setVisible(true);
        //jPanel1.add(pane);
             
        
    }
}
