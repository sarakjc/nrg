/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package hannah.recipe;

import java.awt.Color;
import javax.swing.JFrame;

/**
 *
 * @author Administrator
 */
public class RecipePage extends JFrame{

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        JFrame frame = new JFrame("Add Recipe!");
        frame.setDefaultCloseOperation (JFrame.EXIT_ON_CLOSE);
        frame.setSize(1250, 650);
        frame.setBackground(Color.BLACK);
        //create a JPanel3
        AddRecipe newRec = new AddRecipe();
        //add the JPanel to the frame
        frame.add(newRec);
        //make the frame visible
        frame.setVisible(true);        
    }   
}