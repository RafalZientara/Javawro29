package pl.com.sda.rafal.zientara.apps.lesson3_Swing;

import javax.swing.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class SecondWindow implements FirstWindow.ConfirmListener {
    private JFrame frame;
    private JTextField input2;
    private JTextArea textArea;
    private String input1;

    public SecondWindow() {
        frame = new JFrame("Second Window");
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
//        frame.setSize(200, 250);
        frame.setBounds(250, 0, 200, 250);
        frame.setLayout(null);

        input2 = new JTextField("input2");
        input2.setBounds(50, 50, 100, 50);
        input2.addKeyListener(new KeyListener() {
            @Override
            public void keyTyped(KeyEvent e) {
                String text2 = input2.getText();
                String output = input1 + " " + text2;                //sklejamy teksty
                textArea.setText(output);
            }

            @Override
            public void keyPressed(KeyEvent e) {

            }

            @Override
            public void keyReleased(KeyEvent e) {

            }
        });
        frame.add(input2);

        textArea = new JTextArea("input1 + input2");
        textArea.setBounds(50, 150, 100, 50);

        frame.add(textArea);
        frame.setVisible(true);
    }

    @Override                                               //ta metoda nie musi być wywołana nigdzie w programie
    public void onInputConfirmed(String input) {            //parametr jest pobrany z pierwszego okna
        input1 = input;
        String text1 = input;
        String text2 = input2.getText();
        String output = text1 + " " + text2;                //sklejamy teksty
        textArea.setText(output);                           //przekazujemy do textArea nasz tekst
    }
}
