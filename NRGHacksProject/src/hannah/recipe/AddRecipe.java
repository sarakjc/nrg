package hannah.recipe;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

public class AddRecipe extends JPanel {
    private static final int TEXTBOX_X = 125;
    private static final int TEXTBOX_Y = 50;
    private static final int TEXTBOX_W = 275;
    private static final int TEXTBOX_H = 50;

    private final JScrollPane ingreScroll;
    private final JScrollPane instrucScroll;

    private final JTextField title;
    private final JTextField ingredients;
    private final JTextField instructions;
    private static JTextField titleInfo;
    private static JTextArea ingreInfo;
    private static JTextArea instrucInfo;
    
    private static JButton done;
    private static JButton cancel;

    //info
    private static String recTitle;
    private static String recIngre;
    private static String recInstruc;
    
    public AddRecipe() {
        setLayout(null);
        
        done = new JButton("done");
        done.setBounds(TEXTBOX_X + 510, TEXTBOX_Y + 490, TEXTBOX_W + 215, TEXTBOX_H - 25);
        done.setBackground(Color.WHITE);
        done.setFont(new Font("Edwardian Script ITC", Font.PLAIN, 20));
        cancel = new JButton("cancel");
        cancel.setBounds(TEXTBOX_X, TEXTBOX_Y + 490, TEXTBOX_W + 215, TEXTBOX_H - 25);
        cancel.setBackground(Color.WHITE);
        cancel.setFont(new Font("Edwardian Script ITC", Font.PLAIN, 20));
        
        //Initialize textfields and textareas
        title = new JTextField("Recipe title: ");
        ingredients = new JTextField("Ingredients: ");
        instructions = new JTextField("Instructions: ");
        titleInfo = new JTextField("");
        ingreInfo = new JTextArea();
        instrucInfo = new JTextArea();

        //Set bounds and font
        Font bigFont = new Font("Edwardian Script ITC", Font.BOLD, 40);
        title.setBounds(TEXTBOX_X, TEXTBOX_Y, TEXTBOX_W, TEXTBOX_H);
        title.setFont(bigFont);
        title.setBackground(Color.LIGHT_GRAY);
        title.setEditable(false);

        ingredients.setBounds(TEXTBOX_X, TEXTBOX_Y + 60, TEXTBOX_W + 215, TEXTBOX_H);
        ingredients.setFont(bigFont);
        ingredients.setBackground(Color.LIGHT_GRAY);
        ingredients.setEditable(false);

        instructions.setBounds(TEXTBOX_X + 510, TEXTBOX_Y + 60, TEXTBOX_W + 215, TEXTBOX_H);
        instructions.setFont(bigFont);
        instructions.setBackground(Color.LIGHT_GRAY);
        instructions.setEditable(false);

        titleInfo.setBounds(TEXTBOX_X + 295, TEXTBOX_Y, TEXTBOX_W + 430, TEXTBOX_H);
        titleInfo.setFont(new Font("Edwardian Script ITC", Font.PLAIN, 40));
        titleInfo.setEditable(true);

        Font smallFont = new Font("Edwardian Script ITC", Font.PLAIN, 20);
        ingreInfo.setFont(smallFont);
        ingreInfo.setLineWrap(true);
        ingreInfo.setWrapStyleWord(true);

        instrucInfo.setFont(smallFont);
        instrucInfo.setLineWrap(true);
        instrucInfo.setWrapStyleWord(true);

        // Wrap JTextAreas in JScrollPanes
        ingreScroll = new JScrollPane(ingreInfo);
        ingreScroll.setBounds(TEXTBOX_X, TEXTBOX_Y + 120, TEXTBOX_W + 215, TEXTBOX_H + 310);
        ingreScroll.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);

        instrucScroll = new JScrollPane(instrucInfo);
        instrucScroll.setBounds(TEXTBOX_X + 510, TEXTBOX_Y + 120, TEXTBOX_W + 215, TEXTBOX_H + 310);
        instrucScroll.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);

        // Add components to panel
        add(title);
        add(ingredients);
        add(instructions);
        add(titleInfo);
        add(ingreScroll);
        add(instrucScroll);
        add(done);
        add(cancel);
        done.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
                String info = getInfo();
                System.out.println(info);
                HannahRecipe.writeFile(info);
            }
        });
    }
    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g); 
    }
    public static String getInfo(){
        recTitle = titleInfo.getText();
        recipePanel.titles.add(recTitle);
        recIngre = ingreInfo.getText();
        recipePanel.ingredients.add(recIngre);
        recInstruc = instrucInfo.getText();
        recipePanel.steps.add(recInstruc);
        String info = "Title:\n" + recTitle + "\nIngredients:\n" + recIngre + "\nSteps:\n" + recInstruc;
        return info;
    }
}