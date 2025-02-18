/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package hannah.recipe;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import javax.swing.JPanel;

/**
 *
 * @author Jasmine
 */


public class Timer extends JPanel implements MouseListener {
    int panelWidth = 1250;
    int panelHeight = 650;
    
    int stage = 2;
    javax.swing.Timer countdown;
    int min = 0;
    int sec = 0;
    int ticks = 0;
    Sprite timer = new Sprite(panelWidth-310, panelHeight-180, "images//timer.png", 308, 150);
    Sound click = new Sound("buttonClick.mp3");
    
    //creating timer
    public Timer() {
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
    }
    
//    public void showTimer(Graphics g) {
//        timer.draw(g);
//        countdown.start();
//        repaint();
//    }
    
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        switch(stage) {
            case 2: 
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
                break;
        }
        repaint();
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
