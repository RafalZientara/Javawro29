package pl.com.sda.rafal.zientara.apps.lesson3.Hangman;

import pl.com.sda.rafal.zientara.apps.lesson2.hangman.Hangman;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.Set;

public class HangmanWindow {
    private static final int VIEW_WIDTH = 450;
    private static final int VIEW_HEIGHT = 100;
    private JFrame frame;
    private JLabel guessLabel;
    private JTextField input;
    private JButton button;
    private JLabel hpLabel;
    private JTextArea tries;
    private Hangman game = new Hangman();

    public HangmanWindow() {
        this.frame = new JFrame("Hangman");
        this.frame.setSize(VIEW_WIDTH, VIEW_HEIGHT * 6);
        this.frame.setLayout(null);
        this.frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        this.guessLabel = new JLabel("... .. ....");
        this.guessLabel.setFont(new Font("Serif", Font.PLAIN, 50));
        this.guessLabel.setBounds(0,0,VIEW_WIDTH, VIEW_HEIGHT);
        this.frame.add(this.guessLabel);

        this.input = new JTextField();
        this.input.setBounds(0,VIEW_HEIGHT, VIEW_WIDTH, VIEW_HEIGHT);
        this.input.addKeyListener(new KeyListener() {
            @Override
            public void keyTyped(KeyEvent e) {

            }

            @Override
            public void keyPressed(KeyEvent e) {

            }

            @Override
            public void keyReleased(KeyEvent e) {
                if (e.getKeyCode() == 10){//ENTER
                    handleOkButton();
                }
            }
        });
        this.frame.add(this.input);

        this.button = new JButton("OK");
        this.button.setBounds(0, VIEW_HEIGHT * 2, VIEW_WIDTH, VIEW_HEIGHT);
        this.button.addActionListener(actionEvent -> handleOkButton());
        this.frame.add(this.button);

        this.hpLabel = new JLabel("7/7");
        this.hpLabel.setBounds(0, VIEW_HEIGHT * 3, VIEW_WIDTH, VIEW_HEIGHT);
        this.frame.add(this.hpLabel);

        this.tries = new JTextArea("a b c");
        this.tries.setBounds(0, VIEW_HEIGHT * 4, VIEW_WIDTH, VIEW_HEIGHT);
        this.frame.add(this.tries);

        game.setPuzzle(Resources.getRandomPuzzle());
        refreshUI();

        this.frame.setVisible(true);
    }

    private void handleOkButton() {
        if (game.isGameOver()){
            resetGame();
        } else {
            String guess = this.input.getText();
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
        if(game.isGameOver()){
            button.setText("Reset");
        } else {
            button.setText("OK");
        }
    }

    private void refreshPuzzle() {
        String output = game.getOutput();
        this.guessLabel.setText(output);
    }

    private void refreshHp() {
        int currentHp = game.getHp();
        String output = String.format("HP %d/7", currentHp);
        this.hpLabel.setText(output);
    }

    private void refreshTries() {
        Set<String> tries = game.getTries();
        StringBuilder stringBuilder = new StringBuilder();

        for (String s : tries){
            stringBuilder.append(s).append(" ");
        }

        String output = stringBuilder.toString();
        this.tries.setText(output);
    }
}
