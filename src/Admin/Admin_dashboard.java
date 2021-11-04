package Admin;

// import Admin.*;
// import Accountant.*;

import java.awt.event.*;
import javax.swing.*;
import java.awt.*;

public class Admin_dashboard implements MouseListener {

        JFrame frame;
        JLabel label_1;
        JLabel label_2;
        JLabel label_3;
        JLabel label_4;
        JLabel label_5;
        JLabel label_6;
        JLabel label;

        JPanel Content_panel;

        CardLayout card = new CardLayout();
        JPanel A;
        JPanel B;
        JPanel C;
        JPanel D;
        JPanel E;

        public Admin_dashboard() {

                frame = new JFrame();
                frame.setSize(800, 500);
                frame.setLocationRelativeTo(null);
                frame.setResizable(false);
                frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

                ImageIcon img = new ImageIcon("src/icons/administrator-24.png");
                frame.setIconImage(img.getImage());

                // main panel
                JPanel Main_panel = new JPanel();
                Main_panel.setBackground(Color.red);
                Main_panel.setLayout(new BorderLayout());
                frame.add(Main_panel);

                // panel A - Side Bar
                JPanel Side_panel = new JPanel(new BorderLayout());
                Side_panel.setPreferredSize(new Dimension(200, 500));
                Side_panel.setBackground(Color.BLUE);
                Side_panel.setBorder(BorderFactory.createMatteBorder(0, 0, 0, 1, Color.decode("#123456")));
                Main_panel.add(Side_panel, BorderLayout.WEST);

                // box panel holding all side_bar panels
                JPanel Box = new JPanel(new BorderLayout());
                Box.setLayout(new BoxLayout(Box, BoxLayout.Y_AXIS));
                Side_panel.add(Box, BorderLayout.NORTH);

                // icon panel
                JPanel icon_panel = new JPanel();
                icon_panel.setPreferredSize(new Dimension(200, 75));
                icon_panel.setBackground(Color.gray);
                icon_panel.setBorder(BorderFactory.createMatteBorder(0, 0, 1, 0, Color.decode("#123456")));
                // icon_panel.setOpaque(true);
                Box.add(icon_panel);

                ImageIcon icon = new ImageIcon(new ImageIcon("src/icons/administrator-32.png").getImage()
                                .getScaledInstance(32, 32, Image.SCALE_DEFAULT));

                label = new JLabel();
                label.setText("ADMINISTRATOR");
                label.setIcon(icon);
                icon_panel.add(label);

                // side panel 1
                JPanel side_panel1 = new JPanel();
                side_panel1.setPreferredSize(new Dimension(200, 75));
                side_panel1.setOpaque(true);
                // side_panel1.setBackground(Color.red);
                Box.add(side_panel1);

                ImageIcon label1_icon = new ImageIcon(new ImageIcon("src/icons/home-24.png").getImage()
                                .getScaledInstance(24, 24, Image.SCALE_DEFAULT));

                label_1 = new JLabel();
                label_1.setText("HOME");
                label_1.addMouseListener(this);
                label_1.setIcon(label1_icon);
                side_panel1.add(label_1);

                // side panel 2
                JPanel side_panel2 = new JPanel();
                side_panel2.setPreferredSize(new Dimension(200, 75));
                // side_panel2.setBackground(Color.red);
                side_panel2.setOpaque(true);
                Box.add(side_panel2);

                ImageIcon label2_icon = new ImageIcon(new ImageIcon("src/icons/conference-call-24.png").getImage()
                                .getScaledInstance(24, 24, Image.SCALE_DEFAULT));

                label_2 = new JLabel();
                label_2.setText("USERS");
                label_2.addMouseListener(this);
                label_2.setIcon(label2_icon);
                side_panel2.add(label_2);

                // side panel 3
                JPanel side_panel3 = new JPanel();
                side_panel3.setPreferredSize(new Dimension(200, 75));
                // side_panel3.setBackground(Color.red);
                side_panel3.setOpaque(true);
                Box.add(side_panel3);

                ImageIcon label3_icon = new ImageIcon(new ImageIcon("src/icons/guest-48.png").getImage()
                                .getScaledInstance(24, 24, Image.SCALE_DEFAULT));

                label_3 = new JLabel();
                label_3.setText("PROFILE");
                label_3.addMouseListener(this);
                label_3.setIcon(label3_icon);
                side_panel3.add(label_3);

                // side panel 4
                JPanel side_panel4 = new JPanel();
                side_panel4.setPreferredSize(new Dimension(200, 75));
                // side_panel4.setBackground(Color.red);
                side_panel4.setOpaque(true);
                Box.add(side_panel4);

                ImageIcon label4_icon = new ImageIcon(new ImageIcon("src/icons/report-3-24.png").getImage()
                                .getScaledInstance(24, 24, Image.SCALE_DEFAULT));

                label_4 = new JLabel();
                label_4.setText("REPORT");
                label_4.addMouseListener(this);
                label_4.setIcon(label4_icon);
                side_panel4.add(label_4);

                // side panel 5
                JPanel side_panel5 = new JPanel();
                side_panel5.setPreferredSize(new Dimension(200, 55));
                // side_panel5.setBackground(Color.red);
                side_panel5.setOpaque(true);
                Box.add(side_panel5);

                ImageIcon label5_icon = new ImageIcon(new ImageIcon("src/icons/settings-24-24.png").getImage()
                                .getScaledInstance(24, 24, Image.SCALE_DEFAULT));

                label_5 = new JLabel();
                label_5.setText("SETTINGS");
                label_5.addMouseListener(this);
                label_5.setIcon(label5_icon);
                side_panel5.add(label_5);

                // side panel 6
                JPanel side_panel6 = new JPanel();
                side_panel6.setPreferredSize(new Dimension(200, 55));
                side_panel6.setBackground(Color.gray);
                side_panel6.setOpaque(true);
                Box.add(side_panel6);

                ImageIcon label6_icon = new ImageIcon(new ImageIcon("src/icons/power-2-24.png").getImage()
                                .getScaledInstance(24, 24, Image.SCALE_DEFAULT));

                label_6 = new JLabel();
                label_6.setText("Log Out");
                label_6.addMouseListener(this);
                label_6.setForeground(Color.black);
                label_6.setIcon(label6_icon);
                side_panel6.add(label_6);

                // CARDS
                A = new JPanel(new BorderLayout());
                A.add(new Admin_home());
                A.setBackground(Color.BLUE);

                B = new JPanel(new BorderLayout());
                B.add(new Users());
                B.setBackground(Color.RED);

                C = new JPanel(new BorderLayout());
                C.add(new Profile());
                C.setBackground(Color.BLACK);

                D = new JPanel(new BorderLayout());
                D.add(new Report());
                D.setBackground(Color.BLUE);

                E = new JPanel(new BorderLayout());
                E.add(new Admin_settings());
                E.setBackground(Color.BLACK);

                // Panel B - Main Content
                Content_panel = new JPanel();
                // Content_panel.setPreferredSize(new Dimension(200, 500));
                Content_panel.setLayout(card);
                Content_panel.setBackground(Color.RED);
                Content_panel.add(A, "1");
                Content_panel.add(B, "2");
                Content_panel.add(C, "3");
                Content_panel.add(D, "4");
                Content_panel.add(E, "5");
                Main_panel.add(Content_panel, BorderLayout.CENTER);

                frame.setVisible(true);
        }

        @Override
        public void mouseClicked(MouseEvent e) {
                if (e.getSource() == label_1) {
                        card.show(Content_panel, "1");
                } else if (e.getSource() == label_2) {
                        card.show(Content_panel, "2");
                } else if (e.getSource() == label_3) {
                        card.show(Content_panel, "3");
                } else if (e.getSource() == label_4) {
                        card.show(Content_panel, "4");
                } else if (e.getSource() == label_5) {
                        card.show(Content_panel, "5");
                } else if (e.getSource() == label_6) {
                        frame.dispose();
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
