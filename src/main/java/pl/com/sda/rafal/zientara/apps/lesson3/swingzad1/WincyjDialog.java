package pl.com.sda.rafal.zientara.apps.lesson3.swingzad1;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class WincyjDialog {
    private int clicksCount = 0;

    public WincyjDialog() {
        JFrame frame = new JFrame("Klikaj!");
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        frame.setSize(200,250);
        frame.setLayout(null);//teraz mozna ustawiac widoki
        //za pomoca setBounds

        final JLabel number = new JLabel("0");
        number.setBounds(50,50,100,50);
        frame.add(number);

        JButton button = new JButton("Wincyj");
        button.setBounds(50,150,100,50);
        button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                System.out.println(actionEvent);
                clicksCount++;
                number.setText(String.valueOf(clicksCount));
            }
        });
        frame.add(button);

        frame.setVisible(true);
    }

    public static void main(String[] args) {
        new WincyjDialog();
    }
}
