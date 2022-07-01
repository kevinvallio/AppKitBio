/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.utils;

import java.awt.Image;
import java.text.DateFormat;
import java.util.Date;
import javax.swing.ImageIcon;

/**
 *
 * @author kevin
 */
public class Functions {

    Functions(){
    }
    
    public static ImageIcon scaleImage(Image img, int frameWidth, int frameHeight, int option){
        Image imgScale = img.getScaledInstance(frameWidth, frameHeight, option);
        ImageIcon scaledIcon = new ImageIcon(imgScale);
        return scaledIcon;
    }
    
    public static String getHeaderData() {

        Date data = new Date();
        DateFormat dff = DateFormat.getDateInstance(DateFormat.FULL);
        String formatedData = dff.format(data);
        formatedData = formatedData.substring(0, 1).toUpperCase() + formatedData.substring(1).toLowerCase();
        return formatedData;
    }
    
    
    
    
    //public ImageIcon scaleImage(Image img, int frameWidth, int frameHeight, int option){
    //    Image imgScale = img.getScaledInstance(frameWidth, frameHeight, option);
    //    ImageIcon scaledIcon = new ImageIcon(imgScale);
    //    return scaledIcon;
    //}
    
    
}
