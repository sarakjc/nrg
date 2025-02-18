/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package hannah.recipe;

import static hannah.recipe.HannahRecipe.readFile;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;
import javax.swing.*;

/**
 *
 * @author sarak
 */
public class recipePanel extends JPanel implements MouseListener{

    public static ArrayList<String> titles;
    public static ArrayList<String> ingredients;
    public static ArrayList<String> steps;
    static JTextArea inLabel = new JTextArea("Ingredients");
    static JTextArea stepLabel = new JTextArea("Instructions");
    static JTextArea titleLabel = new JTextArea("");
    static JTextArea inText = new JTextArea("");
    static JTextArea stepText = new JTextArea("");
    static JButton addRecipe = new JButton("+");
    
    int panelWidth = 1250;
    int panelHeight = 650;
    
    int stage = 2;
    javax.swing.Timer countdown;
    int min = 0;
    int sec = 0;
    int ticks = 0;
    Sprite timer = new Sprite(panelWidth-310, panelHeight-180, "images//timer.png", 308, 150);
    Sound click = new Sound("buttonClick.mp3");

    public recipePanel() {
        super();
        addMouseListener(this);
        //add keyboard listener
        setFocusable(true);
        requestFocusInWindow();

        countdown = new javax.swing.Timer(100, e -> {
            ticks++;
            if (ticks % 10 == 0) {
                if (min >= 0) {
                    if (sec == 0) {
                        if (min == 0) {
                            countdown.stop();
                            ticks = 0;
                        } else {
                            min--;
                            sec = 59;
                        }
                    } else {
                        sec--;
                    }
//                    System.out.println("timer running !!!");
                }
            }
        });
        ArrayList<ArrayList<String>> array = HannahRecipe.readFile();
        titles = array.get(0);
            ingredients = array.get(1);
            steps = array.get(2);        
        
        this.add(inLabel);
        this.add(stepLabel);
        this.add(titleLabel);
        this.add(inText);
        this.add(stepText);
        this.add(addRecipe);
//        inLabel.setVisible(false);
//        stepLabel.setVisible(false);
//        titleLabel.setVisible(false);
//        inText.setVisible(false);
//        stepText.setVisible(false);
        addRecipe.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
            }
        });
    }

    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        // sets background colour
        g.setColor(Const.BG);
        g.fillRect(0, 0, Const.panelWIDTH, Const.panelHEIGHT);
        inLabel.setBounds(20, 100, 400, 50);
        stepLabel.setBounds(440, 100, 400, 50);
        titleLabel.setBounds(20, 20, 820, 50);
        inText.setBounds(20, 170, 400, 400);
        stepText.setBounds(440, 170, 400, 400);
        inLabel.setEditable(false);
        stepLabel.setEditable(false);
        titleLabel.setEditable(false);
        inText.setEditable(false);
        stepText.setEditable(false);
        addRecipe.setBounds(875,20,100,100);
        addRecipe.setFont(new Font("Ariel", Font.PLAIN, 40));
        
        timer.draw(g);
        g.setFont(new Font("Press Start 2P", Font.PLAIN, 35));
        g.setColor(Color.DARK_GRAY);
        if (min < 10 && sec < 10) {
            g.drawString("0" + min + ":0" + sec, 985, 550);
        } else if (sec < 10) {
            g.drawString(min + ":0" + sec, 985, 550);
        } else if (min < 10) {
            g.drawString("0" + min + ":" + sec, 985, 550);
        } else {
            g.drawString(min + ":" + sec, 985, 550);
        }
        repaint();
    }

    public void updatePanel(int index) {
        titleLabel.setText(titles.get(index));
        inText.setText(ingredients.get(index));
        stepText.setText(steps.get(index));
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        int mouseX = e.getX();
        int mouseY = e.getY();
        System.out.println(mouseX);
        System.out.println(mouseY);
        //if pressed start: start countdown
        if (mouseX > timer.getX()+250 && mouseX < timer.getX()+300 && mouseY > timer.getY()+23 && mouseY < timer.getY()+43) {
            countdown.start();
            click.start();
            System.out.println("timer started");
        }
        //if pressed stop: pause countdown
        if (mouseX > timer.getX()+250 && mouseX < timer.getX()+300 && mouseY > timer.getY()+58 && mouseY < timer.getY()+78) {
            countdown.stop();
            click.start();
            System.out.println("timer stopped");
        }
        //if pressed clear: set everything back to 0 / original
        if (mouseX > timer.getX()+250 && mouseX < timer.getX()+300 && mouseY > timer.getY()+103 && mouseY < timer.getY()+123) {
            countdown.restart();
            min = 0;
            sec = 0;
            countdown.stop();
            System.out.println("timer cleared");
        }
        //min +/-
        if (min < 99 && mouseX > timer.getX() + 30 && mouseX < timer.getX() + 50 && mouseY > timer.getY() + 113 && mouseY < timer.getY() + 133) {
            min++;
        }
        if (min > 0 && mouseX > timer.getX() + 110 && mouseX < timer.getX() + 130 && mouseY > timer.getY() + 113 && mouseY < timer.getY() + 133) {
            min--;
        }
        //sec +/-
        if (sec < 59 && mouseX > timer.getX() + 135 && mouseX < timer.getX() + 155 && mouseY > timer.getY() + 113 && mouseY < timer.getY() + 133) {
            sec++;
        }
        if (sec > 0 && mouseX > timer.getX() + 220 && mouseX < timer.getX() + 240 && mouseY > timer.getY() + 113 && mouseY < timer.getY() + 133) {
            sec--;
        }
    }

    @Override
    public void mousePressed(MouseEvent e) {
    }

    @Override
    public void mouseReleased(MouseEvent e) {
    }

    @Override
    public void mouseEntered(MouseEvent e) {
    }

    @Override
    public void mouseExited(MouseEvent e) {
    }
}
