package pl.com.sda.rafal.zientara.apps.lesson3.swingzad2;

import javax.swing.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class SecondWindow implements FirstWindow.ConfirmListener {
    private JFrame frame;
    private final JTextField input2;
    private JTextArea textSum;
    private String input1;

    public SecondWindow() {
        frame = new JFrame("Drugie okno");
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        frame.setBounds(300,300, 200, 250);
        frame.setLayout(null);//teraz mozna ustawiac widoki
        //za pomoca setBounds

        input2 = new JTextField("input2");
        input2.setBounds(50, 50, 100, 50);
        input2.addKeyListener(new KeyListener() {
            @Override
            public void keyTyped(KeyEvent keyEvent) {
                String text2 = input2.getText();
                String output = input1 + text2;
                textSum.setText(output);
            }

            @Override
            public void keyPressed(KeyEvent keyEvent) {

            }

            @Override
            public void keyReleased(KeyEvent keyEvent) {

            }
        });
        frame.add(input2);

        textSum = new JTextArea("in1 + in2");
        textSum.setBounds(50, 150, 100, 50);
        frame.add(textSum);

        frame.setVisible(true);
    }

    @Override
    public void onInputConfirmed(String input) {
        input1 = input;
        String text1 = input;
        String text2 = input2.getText();
        String output = text1 + text2;
        textSum.setText(output);
    }
}
