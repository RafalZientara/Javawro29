package pl.com.sda.rafal.zientara.apps.lesson3.hangman;

import pl.com.sda.rafal.zientara.apps.lesson2.hangman.Hangman;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.Set;

public class HangmanWindow {

    private JFrame frame;
    private JLabel guessLabel;
    private JTextField input;
    private JButton button;
    private JLabel hpLabel;
    private JTextArea tries;
    private static final int VIEW_WIDTH = 500;
    private static final int VIEW_HEIGHT = 100;
    private Hangman game = new Hangman();

    public HangmanWindow() {
        frame = new JFrame("Hangman");
        frame.setSize(VIEW_WIDTH, 6 * VIEW_HEIGHT);
        frame.setLayout(null);
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        guessLabel = new JLabel("... .. ....");
        guessLabel.setBounds(0, 0, VIEW_WIDTH, VIEW_HEIGHT);
        guessLabel.setFont(new Font("Serif", Font.PLAIN, 24));
        frame.add(guessLabel);

        input = new JTextField();
        input.setBounds(0, VIEW_HEIGHT, VIEW_WIDTH, VIEW_HEIGHT);
        input.addKeyListener(new KeyListener() {
            @Override
            public void keyTyped(KeyEvent keyEvent) {

            }

            @Override
            public void keyPressed(KeyEvent keyEvent) {

            }

            @Override
            public void keyReleased(KeyEvent keyEvent) {
                System.out.println(keyEvent);
                if (keyEvent.getKeyCode() == 10) {//ENTER
                    handleOkButton();
                }
            }
        });
        frame.add(input);

        button = new JButton("OK");
        button.setBounds(0, VIEW_HEIGHT * 2, VIEW_WIDTH, VIEW_HEIGHT);
        button.addActionListener(actionEvent -> handleOkButton());
        frame.add(button);

        hpLabel = new JLabel("HP = 7/7");
        hpLabel.setBounds(0, VIEW_HEIGHT * 3, VIEW_WIDTH, VIEW_HEIGHT);
        frame.add(hpLabel);

        tries = new JTextArea("a b c");
        tries.setBounds(0, VIEW_HEIGHT * 4, VIEW_WIDTH, VIEW_HEIGHT);
        frame.add(tries);

        game.setPuzzle(Resources.getRandomPuzzle());
        refreshUI();
        frame.setVisible(true);
    }

    private void handleOkButton() {
        //todo akcja reset czy ok?
        if (game.isGameOver()) {
            resetGame();
        } else {
            String guess = input.getText();
            game.guess(guess);
            input.setText("");
        }
        refreshUI();
    }

    private void resetGame() {
        game.setPuzzle(Resources.getRandomPuzzle());
    }

    private void refreshUI() {
        refreshPuzzle();
        refreshButton();
        refreshHp();
        refreshTries();
    }

    private void refreshButton() {
        if (game.isGameOver())
            button.setText("Reset");
        else
            button.setText("OK");
    }

    private void refreshPuzzle() {
        String output = game.getOutput();
        guessLabel.setText(output);
    }

    private void refreshHp() {
        int currentHp = game.getHp();
        String output = String.format("HP %d/7", currentHp);
        hpLabel.setText(output);
    }

    private void refreshTries() {
        Set<String> tries = game.getTries();


        StringBuilder builder = new StringBuilder();
        //"a b c "
        for (String s : tries) {
            builder.append(s).append(" ");
        }

        String output = builder.toString();
        this.tries.setText(output);

    }
}
