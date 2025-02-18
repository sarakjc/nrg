/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package hannah.recipe;

import static hannah.recipe.HannahRecipe.readFile;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import javax.swing.*;

/**
 *
 * @author sarak
 */
public class recipePanel extends JPanel implements MouseListener {

    public static Font font;
    public static ArrayList<String> titles;
    public static ArrayList<String> ingredients;
    public static ArrayList<String> steps;
    static JTextArea inLabel = new JTextArea("Ingredients");
    static JTextArea stepLabel = new JTextArea("Instructions");
    static JTextArea titleLabel = new JTextArea("");
    static JTextArea inText = new JTextArea("");
    static JTextArea stepText = new JTextArea("");
    static JButton addRecipe = new JButton("+");
    private BufferedImage image;

    int panelWidth = 1250;
    int panelHeight = 650;

    javax.swing.Timer countdown;
    int min = 0;
    int sec = 0;
    int ticks = 0;
    Sprite timer = new Sprite(panelWidth - 1230, panelHeight - 210, "images//timer.png", 308, 150);
    Sound click = new Sound("buttonClick.mp3");

    public recipePanel() {
        super();
        setFont();
        try {
            image = ImageIO.read(new File("back.png"));
        } catch (IOException ex) {
            image = null;
        }

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
        addRecipe.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
            }
        });
    }

    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);

        g.drawImage(image, 0, 0, this);

        inLabel.setBounds(20, 100, 310, 60);
        stepLabel.setBounds(350, 100, 490, 60);
        titleLabel.setBounds(20, 20, 820, 70);
        inText.setBounds(20, 170, 300, 260);
        stepText.setBounds(350, 170, 490, 420);
        inLabel.setEditable(false);
        stepLabel.setEditable(false);
        titleLabel.setEditable(false);
        inText.setEditable(false);
        stepText.setEditable(false);
        addRecipe.setBounds(875, 20, 100, 100);
        addRecipe.setFont(new Font("Arial", Font.PLAIN, 40));
        inLabel.setFont(font);
        inLabel.setFont(font.deriveFont(40f));
        stepLabel.setFont(font);
        stepLabel.setFont(font.deriveFont(40f));
        titleLabel.setFont(font);
        titleLabel.setFont(font.deriveFont(60f));
        inText.setFont(new Font("Arial", Font.PLAIN, 20));
        stepText.setFont(new Font("Arial", Font.PLAIN, 20));

        timer.draw(g);
        g.setFont(new Font("Press Start 2P", Font.PLAIN, 35));
        g.setColor(Color.DARK_GRAY);
        if (min < 10 && sec < 10) {
            g.drawString("0" + min + ":0" + sec, timer.getX() + 45, timer.getY() + 80);
        } else if (sec < 10) {
            g.drawString(min + ":0" + sec, timer.getX() + 45, timer.getY() + 80);
        } else if (min < 10) {
            g.drawString("0" + min + ":" + sec, timer.getX() + 45, timer.getY() + 80);
        } else {
            g.drawString(min + ":" + sec, timer.getX() + 45, timer.getY() + 80);
        }
        repaint();
    }

    public void updatePanel(int index) {
        titleLabel.setText(titles.get(index));
        inText.setText(ingredients.get(index));
        stepText.setText(steps.get(index));
    }

    public static void setFont() {
        try {
            File f = new File("PerfectbomberfreepersonaluseSc-PVqmd.ttf");
            font = Font.createFont(Font.TRUETYPE_FONT, f);
        } catch (FontFormatException | IOException e) {
            font = new Font("Arial", Font.PLAIN, 1);
        }
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        int mouseX = e.getX();
        int mouseY = e.getY();
        System.out.println(mouseX);
        System.out.println(mouseY);
        //if pressed start: start countdown
        if (mouseX > timer.getX() + 250 && mouseX < timer.getX() + 300 && mouseY > timer.getY() + 23 && mouseY < timer.getY() + 43) {
            countdown.start();
            click.start();
            System.out.println("timer started");
        }
        //if pressed stop: pause countdown
        if (mouseX > timer.getX() + 250 && mouseX < timer.getX() + 300 && mouseY > timer.getY() + 58 && mouseY < timer.getY() + 78) {
            countdown.stop();
            click.start();
            System.out.println("timer stopped");
        }
        //if pressed clear: set everything back to 0 / original
        if (mouseX > timer.getX() + 250 && mouseX < timer.getX() + 300 && mouseY > timer.getY() + 103 && mouseY < timer.getY() + 123) {
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
