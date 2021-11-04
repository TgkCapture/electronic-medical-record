package Accountant;

// import Admin.*;
// import Accountant.*;

import javax.swing.*;

import java.awt.*;
// import java.awt.event.*;

public class Home extends JPanel {

        JPanel layer;
        JPanel Heading_panel;
        JPanel Box;
        JPanel sub_1;
        JPanel sub_2;
        JPanel sub_3;
        JPanel sub_4;

        JLabel label_A;
        JLabel label_B;
        JLabel label_C;
        JLabel label_D;

        public Home() {
                this.setLayout(new BorderLayout());

                layer = new JPanel(new BorderLayout());
                layer.setBackground(Color.RED);
                layer.setBorder(BorderFactory.createMatteBorder(1, 1, 1, 1, Color.BLACK));
                this.add(layer, BorderLayout.CENTER);

                Heading_panel = new JPanel();
                Heading_panel.setBackground(Color.darkGray);// smoke white #E3DAC9 #F5F5F5
                Heading_panel.setPreferredSize(new Dimension(0, 75));
                Heading_panel.setBorder(BorderFactory.createMatteBorder(1, 1, 1, 1, Color.BLACK));
                layer.add(Heading_panel, BorderLayout.NORTH);

                ImageIcon heading_icon = new ImageIcon(new ImageIcon("src/icons/home-48.png").getImage()
                                .getScaledInstance(32, 32, Image.SCALE_DEFAULT));
                JLabel heading_label = new JLabel();
                heading_label.setText("HOME");
                heading_label.setIcon(heading_icon);
                heading_label.setForeground(Color.BLACK);
                heading_label.setHorizontalTextPosition(JLabel.CENTER);
                heading_label.setVerticalTextPosition(JLabel.BOTTOM);
                Heading_panel.add(heading_label);

                Box = new JPanel(new GridLayout(2, 2, 10, 10));
                Box.setBackground(Color.decode("#F3F6FB"));// snow white
                Box.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
                layer.add(Box, BorderLayout.CENTER);

                sub_1 = new JPanel();
                sub_1.setPreferredSize(new Dimension(50, 50));
                sub_1.setBorder(BorderFactory.createMatteBorder(1, 1, 1, 1, Color.BLACK));
                sub_1.setBorder(BorderFactory.createEmptyBorder(40, 0, 0, 0));
                // sub_1.setBackground(Color.green);
                Box.add(sub_1);

                ImageIcon icon_1 = new ImageIcon(new ImageIcon("src/icons/admin.png").getImage().getScaledInstance(32,
                                32, Image.SCALE_DEFAULT));
                label_A = new JLabel();
                label_A.setIcon(icon_1);
                label_A.setText("Home");
                label_A.setHorizontalTextPosition(JLabel.CENTER);
                label_A.setVerticalTextPosition(JLabel.BOTTOM);
                sub_1.add(label_A);

                sub_2 = new JPanel();
                sub_2.setPreferredSize(new Dimension(50, 50));
                sub_2.setBorder(BorderFactory.createMatteBorder(1, 1, 1, 1, Color.BLACK));
                sub_2.setBorder(BorderFactory.createEmptyBorder(40, 0, 0, 0));
                // sub_2.setBackground(Color.gray);
                Box.add(sub_2);

                ImageIcon icon_2 = new ImageIcon(new ImageIcon("src/icons/admin.png").getImage().getScaledInstance(32,
                                32, Image.SCALE_DEFAULT));
                label_B = new JLabel();
                label_B.setIcon(icon_2);
                label_B.setText("Portfolio");
                label_B.setHorizontalTextPosition(JLabel.CENTER);
                label_B.setVerticalTextPosition(JLabel.BOTTOM);
                sub_2.add(label_B);

                sub_3 = new JPanel();
                sub_3.setPreferredSize(new Dimension(50, 50));
                sub_3.setBorder(BorderFactory.createMatteBorder(1, 1, 1, 1, Color.BLACK));
                sub_3.setBorder(BorderFactory.createEmptyBorder(40, 0, 0, 0));
                // sub_3.setBackground(Color.cyan);
                Box.add(sub_3);

                ImageIcon icon_3 = new ImageIcon(new ImageIcon("src/icons/admin.png").getImage().getScaledInstance(32,
                                32, Image.SCALE_DEFAULT));
                label_C = new JLabel();
                label_C.setIcon(icon_3);
                label_C.setText("Profile");
                label_C.setHorizontalTextPosition(JLabel.CENTER);
                label_C.setVerticalTextPosition(JLabel.BOTTOM);
                sub_3.add(label_C);

                sub_4 = new JPanel();
                // sub_4.setPreferredSize(new Dimension(50, 50));
                // sub_4.setBackground(Color.ORANGE);
                sub_4.setBorder(BorderFactory.createEmptyBorder(40, 0, 0, 0));
                // sub_4.setBorder(BorderFactory.createMatteBorder(1, 1, 1, 1, Color.BLACK));
                Box.add(sub_4);

                ImageIcon icon_4 = new ImageIcon(new ImageIcon("src/icons/admin.png").getImage().getScaledInstance(32,
                                32, Image.SCALE_DEFAULT));
                label_D = new JLabel();
                label_D.setIcon(icon_4);
                label_D.setText("About");
                label_D.setHorizontalTextPosition(JLabel.CENTER);
                label_D.setVerticalTextPosition(JLabel.BOTTOM);
                sub_4.add(label_D);
        }

}
