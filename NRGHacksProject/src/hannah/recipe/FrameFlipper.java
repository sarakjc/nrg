/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package hannah.recipe;

import java.awt.Color;
import javax.swing.JFrame;

/**
 *
 * @author hannahblack
 */
public class FrameFlipper {
    public static int stage = 1;
    static GUI2 frame1;
        static RecipePage frame2;
    public static void main(String[] args) {
        frame1 = new GUI2();

        JFrame frame2 = new JFrame("Add Recipe!");
        frame2.setDefaultCloseOperation (JFrame.EXIT_ON_CLOSE);
        frame2.setSize(1250, 650);
        //create a JPanel3
        AddRecipe newRec = new AddRecipe();
        //add the JPanel to the frame
        frame2.add(newRec);
        //make the frame visible
        frame2.setVisible(true);   
        
        switchFrame();
    }
    
    public static void switchFrame() {
        switch(stage) {
            case 1:
                frame1.setVisible(true);
                frame2.setVisible(false);
                break;
            case 2:
                frame1.setVisible(false);
                frame2.setVisible(true);
                break;
        }
    }
}
