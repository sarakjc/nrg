/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package hannah.recipe;

import static hannah.recipe.HannahRecipe.readFile;
import java.awt.*;
import java.util.ArrayList;
import javax.swing.*;

/**
 *
 * @author sarak
 */
public class recipePanel extends JPanel {

    public static ArrayList<String> titles;
    public static ArrayList<String> ingredients;
    public static ArrayList<String> steps;
    static JTextArea inLabel = new JTextArea("Ingredients");
    static JTextArea stepLabel = new JTextArea("Instructions");
    static JTextArea titleLabel = new JTextArea("");
    static JTextArea inText = new JTextArea("");
    static JTextArea stepText = new JTextArea("");    
    
    public recipePanel() {
        super();
        ArrayList<ArrayList<String>> array = HannahRecipe.readFile();
        titles = array.get(0);
        ingredients = array.get(1);
        steps = array.get(2);
        this.add(inLabel);
        this.add(stepLabel);
        this.add(titleLabel);
        this.add(inText);
        this.add(stepText);
//        inLabel.setVisible(false);
//        stepLabel.setVisible(false);
//        titleLabel.setVisible(false);
//        inText.setVisible(false);
//        stepText.setVisible(false);
    }

    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        // sets background colour
        g.setColor(Const.BG);
        g.fillRect(0, 0, Const.panelWIDTH, Const.panelHEIGHT);
        inLabel.setBounds(20, 100, 400, 50);
        stepLabel.setBounds(440, 100, 400, 50);
        titleLabel.setBounds(20, 20, 1000, 50);
        inText.setBounds(20, 170, 400, 400);
        stepText.setBounds(440, 170, 400, 400);
                inLabel.setEditable(false);
        stepLabel.setEditable(false);
        titleLabel.setEditable(false);
        inText.setEditable(false);
        stepText.setEditable(false);
    }
    
    public void updatePanel(int index) {
        titleLabel.setText(titles.get(index));
        inText.setText(ingredients.get(index));
        stepText.setText(steps.get(index));
    }
}
