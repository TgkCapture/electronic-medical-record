package Accountant;

// import Admin.*;
// import Accountant.*;

import javax.swing.*;
import java.awt.event.*;
import java.awt.*;

public class Fees extends JPanel implements MouseListener {

        JPanel layer;
        JPanel Heading_panel;
        JPanel Box;
        JPanel sub_1;
        JPanel sub_2;
        JPanel sub_3;
        JPanel sub_4;

        JLabel label_1;
        JLabel label_2;
        JLabel label_3;
        JLabel label_4;

        // CardLayout card = new CardLayout();
        // JPanel contain;
        // JPanel Main_panel;

        public Fees() {
                this.setLayout(new BorderLayout());

                layer = new JPanel(new BorderLayout());
                layer.setBackground(Color.RED);
                this.add(layer, BorderLayout.CENTER);

                // JLabel nL = new JLabel();
                // nL.setText("COLLECT FEES");
                // layer.add(nL);

                Heading_panel = new JPanel();
                Heading_panel.setBackground(Color.darkGray);
                Heading_panel.setPreferredSize(new Dimension(0, 75));
                layer.add(Heading_panel, BorderLayout.NORTH);

                ImageIcon heading_icon = new ImageIcon(new ImageIcon("src/icons/charge-fees.png").getImage()
                                .getScaledInstance(32, 32, Image.SCALE_DEFAULT));
                JLabel heading_label = new JLabel();
                heading_label.setText("FEES");
                heading_label.setIcon(heading_icon);
                heading_label.setHorizontalTextPosition(JLabel.CENTER);
                heading_label.setVerticalTextPosition(JLabel.BOTTOM);
                heading_label.setForeground(Color.BLACK);
                Heading_panel.add(heading_label);

                Box = new JPanel(new GridLayout(2, 2, 10, 10));
                Box.setBackground(Color.decode("#F3F6FB"));
                Box.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
                layer.add(Box, BorderLayout.CENTER);

                sub_1 = new JPanel();
                // sub_1.setPreferredSize(new Dimension(50, 50));
                // sub_1.setBackground(Color.green);
                sub_1.setBorder(BorderFactory.createEmptyBorder(40, 0, 0, 0));
                Box.add(sub_1);

                ImageIcon icon_1 = new ImageIcon(new ImageIcon("src/icons/images.jpeg").getImage().getScaledInstance(48,
                                48, Image.SCALE_DEFAULT));
                label_1 = new JLabel();
                label_1.setText("FEE COLLECTION");
                label_1.setHorizontalTextPosition(JLabel.CENTER);
                label_1.setVerticalTextPosition(JLabel.BOTTOM);
                label_1.addMouseListener(this);
                label_1.setIcon(icon_1);
                sub_1.add(label_1);

                sub_2 = new JPanel();
                // sub_2.setPreferredSize(new Dimension(50, 50));
                // sub_2.setBackground(Color.gray);
                sub_2.setBorder(BorderFactory.createEmptyBorder(40, 0, 0, 0));
                Box.add(sub_2);

                ImageIcon icon_2 = new ImageIcon(new ImageIcon("src/icons/icon2.png").getImage().getScaledInstance(32,
                                32, Image.SCALE_DEFAULT));
                label_2 = new JLabel();
                label_2.setText("VIEW BALANCES");
                label_2.setHorizontalTextPosition(JLabel.CENTER);
                label_2.setVerticalTextPosition(JLabel.BOTTOM);
                label_2.addMouseListener(this);
                label_2.setIcon(icon_2);
                sub_2.add(label_2);

                sub_3 = new JPanel();
                // sub_3.setPreferredSize(new Dimension(50, 50));
                // sub_3.setBackground(Color.cyan);
                sub_3.setBorder(BorderFactory.createEmptyBorder(40, 0, 0, 0));
                Box.add(sub_3);

                ImageIcon icon_3 = new ImageIcon(new ImageIcon("src/icons/icon2.png").getImage().getScaledInstance(32,
                                32, Image.SCALE_DEFAULT));
                label_3 = new JLabel();
                label_3.setText("UPDATE PAYMENT STATUS");
                label_3.setHorizontalTextPosition(JLabel.CENTER);
                label_3.setVerticalTextPosition(JLabel.BOTTOM);
                label_3.setIcon(icon_3);
                sub_3.add(label_3);

                sub_4 = new JPanel();
                // sub_4.setPreferredSize(new Dimension(50, 50));
                // sub_4.setBackground(Color.ORANGE);
                sub_4.setBorder(BorderFactory.createEmptyBorder(40, 0, 0, 0));
                Box.add(sub_4);

                ImageIcon icon_4 = new ImageIcon(new ImageIcon("src/icons/images.png").getImage().getScaledInstance(48,
                                48, Image.SCALE_DEFAULT));
                label_4 = new JLabel();
                label_4.setText("CALCULATE TAX");
                label_4.setHorizontalTextPosition(JLabel.CENTER);
                label_4.setVerticalTextPosition(JLabel.BOTTOM);
                label_4.setIcon(icon_4);
                sub_4.add(label_4);

                // contain = new JPanel(new BorderLayout());
                // contain.add(new Collect_fees());

                // Main_panel = new JPanel();
                // Main_panel.add(contain, "5");

                // layer.add(Main_panel, BorderLayout.CENTER);

        }

        @Override
        public void mouseClicked(MouseEvent e) {
                if (e.getSource() == label_1) {

                        new Collect_fees();
                } else if (e.getSource() == label_2) {
                        new viewfees_balance();
                }

        }

        @Override
        public void mousePressed(MouseEvent e) {
                // TODO Auto-generated method stub

        }

        @Override
        public void mouseReleased(MouseEvent e) {
                // TODO Auto-generated method stub

        }

        @Override
        public void mouseEntered(MouseEvent e) {
                // TODO Auto-generated method stub

        }

        @Override
        public void mouseExited(MouseEvent e) {
                // TODO Auto-generated method stub

        }

}
