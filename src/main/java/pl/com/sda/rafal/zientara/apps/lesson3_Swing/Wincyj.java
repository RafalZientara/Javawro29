package pl.com.sda.rafal.zientara.apps.lesson3_Swing;

import javax.swing.*;
import java.awt.event.ActionEvent;

public class Wincyj {
    private int clicksCount = 0;

    public Wincyj() {

        JFrame frame = new JFrame("Zwiększaj");
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        frame.setSize(200, 250);
        frame.setLayout(null);                                  //teraz można ustawiać przyciski i inne z parametrami
                                                                //za pomocą setBounds
        JLabel label = new JLabel("0");                    //tworzenie etykiety
        label.setBounds(50, 50, 100, 50);
        frame.add(label);

        JButton button = new JButton("Wincyj!");           //tworzenie przycisku
        button.setBounds(50, 150, 100, 50);
        button.addActionListener(new AbstractAction() {         //odanie akcji dla wciśnięcia przycisku
            @Override
            public void actionPerformed(ActionEvent e) {
               clicksCount++;                                   //zwiększamy liczbę kliknięc do wyświetlenia
               label.setText(String.valueOf(clicksCount));      //zmiana tekstu do wyświetlenia
            }
        });
        frame.add(button);

        frame.setVisible(true);
    }
}
