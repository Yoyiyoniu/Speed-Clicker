package org.core;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.TimerTask;
import java.util.Timer;
public class Main implements ActionListener {
    JFrame frame;
    static int count = 0;
    static int perSecond;
    static JLabel label;
    static JLabel Clicks;
    static JPanel panel;
    static Timer timer = new Timer();

    public void GUI() {

        JButton button = new JButton("Click");
        button.addActionListener(this);
        label = new JLabel("Numero de clicks: 0");
        Clicks = new JLabel("Clicks por segundo: "+ perSecond);
        label.setHorizontalTextPosition(JLabel.CENTER);
        Clicks.setHorizontalTextPosition(JLabel.CENTER);

        frame = new JFrame();

        panel = new JPanel();
        panel.setBorder(BorderFactory.createEmptyBorder(110,170,110,170));
        panel.setLayout(new GridLayout(0,1));
        panel.add(label);
        panel.add(Clicks);
        panel.add(button);


        frame.add(panel, BorderLayout.CENTER);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setTitle("Contador de Clicks Por Segundo");
        frame.pack();
        frame.setVisible(true);
        frame.getContentPane().setBackground( Color.red );

    }

    public static void main(String[] args) {

        Main main = new Main();
        main.GUI();
        TimerTask timerTask = new TimerTask() {
                @Override
                public void run() {
                    if (count >= 1){
                        System.out.println("Clicks Por segundo: " + count);
                        label.setText("Numero de clicks: " + count);
                        perSecond = count;
                        count = 0;
                    }
                }
            };
            timer.schedule(timerTask, 0,1000);
        }

    @Override
    public void actionPerformed(ActionEvent e) {
        count++;
        Clicks.setText("Clicks por segundo: "+ perSecond);
        label.setText("Numero de clicks: " + count);

    }

}