package Accountant;

// import Admin.*;

// import Accountant.*;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class Dashboard implements MouseListener {

    JFrame frame;
    JLabel icon2_label;
    JLabel icon3_label;
    JLabel icon4_label;
    JLabel icon5_label;
    JLabel icon6_label;
    JLabel logout;
    JPanel main_panel;

    CardLayout card = new CardLayout();
    JPanel P;
    JPanel Q;
    JPanel R;
    JPanel S;
    JPanel T;

    public Dashboard() {

        frame = new JFrame();
        frame.setSize(800, 500);
        // frame.setBackground(Color.RED);
        frame.setLocationRelativeTo(null);
        frame.setResizable(false);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        ImageIcon img = new ImageIcon("src/img/bg1.jpg");
        frame.setIconImage(img.getImage());

        JPanel panel_1 = new JPanel(new BorderLayout());
        panel_1.setBackground(Color.BLUE);
        panel_1.setPreferredSize(new Dimension(800, 500));
        frame.add(panel_1);

        JPanel panel_2 = new JPanel();
        panel_2.setLayout(new BorderLayout());
        panel_2.setBackground(Color.DARK_GRAY);
        panel_2.setPreferredSize(new Dimension(800, 500));
        panel_1.add(panel_2);

        // sidebar panel
        JPanel sidebar_panel = new JPanel(new BorderLayout());
        sidebar_panel.setPreferredSize(new Dimension(200, 500));
        sidebar_panel.setBackground(Color.red);
        sidebar_panel.setBorder(BorderFactory.createMatteBorder(0, 0, 0, 1, Color.decode("#123456")));
        panel_2.add(sidebar_panel, BorderLayout.WEST);

        // box panel holding all sidebar panels
        JPanel box = new JPanel();
        box.setLayout(new BoxLayout(box, BoxLayout.Y_AXIS));
        sidebar_panel.add(box, BorderLayout.NORTH);

        // sidebar icon panel
        JPanel side_iconpanel = new JPanel();
        side_iconpanel.setPreferredSize(new Dimension(200, 75));
        side_iconpanel.setBackground(Color.darkGray);
        side_iconpanel.setBorder(BorderFactory.createMatteBorder(1, 0, 1, 0, Color.decode("#123456")));
        box.add(side_iconpanel);

        ImageIcon icon1 = new ImageIcon(new ImageIcon("src/icons/administrator-32.png").getImage().getScaledInstance(64,
                64, Image.SCALE_DEFAULT));

        JLabel icon1_label = new JLabel();
        icon1_label.setText("ACCOUNTANT ");
        icon1_label.setIcon(icon1);
        icon1_label.setForeground(Color.black);
        side_iconpanel.add(icon1_label);

        // sidebar panel
        JPanel side_iconpanel2 = new JPanel();
        side_iconpanel2.setPreferredSize(new Dimension(200, 70));
        side_iconpanel2.setBorder(BorderFactory.createEmptyBorder(20, 0, 0, 0));
        // side_iconpanel2.setBorder(BorderFactory.createMatteBorder(0, 0, 1, 0,
        // Color.decode("#123456")));
        // side_iconpanel2.setBackground(null);
        box.add(side_iconpanel2);

        ImageIcon icon2 = new ImageIcon(
                new ImageIcon("src/icons/home-24.png").getImage().getScaledInstance(24, 24, Image.SCALE_DEFAULT));

        icon2_label = new JLabel();
        icon2_label.setText("Home");
        icon2_label.setIcon(icon2);
        icon2_label.addMouseListener(this);
        side_iconpanel2.add(icon2_label);

        // sidebar panel
        JPanel side_iconpanel3 = new JPanel();
        side_iconpanel3.setPreferredSize(new Dimension(200, 70));
        // side_iconpanel3.setBorder(BorderFactory.createMatteBorder(0, 0, 1, 0,
        // Color.decode("#123456")));
        side_iconpanel3.setBorder(BorderFactory.createEmptyBorder(20, 0, 0, 0));
        side_iconpanel3.setBackground(null);
        box.add(side_iconpanel3);

        ImageIcon icon3 = new ImageIcon(
                new ImageIcon("src/icons/student.png").getImage().getScaledInstance(24, 24, Image.SCALE_DEFAULT));

        icon3_label = new JLabel();
        icon3_label.setText("Students");
        icon3_label.setIcon(icon3);
        icon3_label.addMouseListener(this);
        side_iconpanel3.add(icon3_label);

        // sidebar panel
        JPanel side_iconpanel4 = new JPanel();
        side_iconpanel4.setPreferredSize(new Dimension(200, 70));
        // side_iconpanel4.setBorder(BorderFactory.createMatteBorder(0, 0, 1, 0,
        // Color.decode("#123456")));
        side_iconpanel4.setBorder(BorderFactory.createEmptyBorder(20, 0, 0, 0));
        side_iconpanel4.setBackground(null);
        box.add(side_iconpanel4);

        ImageIcon icon4 = new ImageIcon(
                new ImageIcon("src/icons/us-dollar-24.png").getImage().getScaledInstance(24, 24, Image.SCALE_DEFAULT));

        icon4_label = new JLabel();
        icon4_label.setText("Fees");
        icon4_label.setIcon(icon4);
        icon4_label.addMouseListener(this);
        side_iconpanel4.add(icon4_label);

        // sidebar panel
        JPanel side_iconpanel5 = new JPanel();
        side_iconpanel5.setPreferredSize(new Dimension(200, 70));
        // side_iconpanel5.setBorder(BorderFactory.createMatteBorder(0, 0, 1, 0,
        // Color.decode("#123456")));
        side_iconpanel5.setBorder(BorderFactory.createEmptyBorder(20, 0, 0, 0));
        side_iconpanel5.setBackground(null);
        box.add(side_iconpanel5);

        ImageIcon icon5 = new ImageIcon(
                new ImageIcon("src/icons/report-3-24.png").getImage().getScaledInstance(24, 24, Image.SCALE_DEFAULT));

        icon5_label = new JLabel();
        icon5_label.setText("Report");
        icon5_label.setIcon(icon5);
        icon5_label.addMouseListener(this);
        side_iconpanel5.add(icon5_label);

        // sidebar panel
        JPanel side_iconpanel6 = new JPanel();
        side_iconpanel6.setPreferredSize(new Dimension(200, 70));
        side_iconpanel6.setBorder(BorderFactory.createEmptyBorder(20, 0, 0, 0));
        side_iconpanel6.setBackground(null);
        box.add(side_iconpanel6);

        ImageIcon icon6 = new ImageIcon(new ImageIcon("src/icons/settings-24-24.png").getImage().getScaledInstance(24,
                24, Image.SCALE_DEFAULT));

        icon6_label = new JLabel();
        icon6_label.setText("Settings");
        icon6_label.setIcon(icon6);
        icon6_label.addMouseListener(this);
        side_iconpanel6.add(icon6_label);

        // logout panel
        JPanel side_iconpanel7 = new JPanel();
        side_iconpanel7.setPreferredSize(new Dimension(200, 36));
        side_iconpanel7.setBorder(BorderFactory.createMatteBorder(0, 0, 1, 0, Color.decode("#123456")));
        side_iconpanel7.setBorder(BorderFactory.createEmptyBorder(5, 0, 0, 0));
        side_iconpanel7.setBackground(Color.darkGray);
        box.add(side_iconpanel7);

        ImageIcon icon7 = new ImageIcon(
                new ImageIcon("src/icons/power-2-24.png").getImage().getScaledInstance(16, 16, Image.SCALE_DEFAULT));

        logout = new JLabel();
        logout.setText("LOG OUT");
        logout.setForeground(Color.black);
        logout.setIcon(icon7);
        logout.addMouseListener(this);
        side_iconpanel7.add(logout);

        // cards
        P = new JPanel(new BorderLayout());
        P.add(new Home());
        // P.setBackground(Color.BLACK);

        Q = new JPanel(new BorderLayout());
        Q.add(new Students());
        // Q.setBackground(Color.red);

        R = new JPanel(new BorderLayout());
        R.add(new Fees());
        // R.setBackground(Color.BLUE);

        S = new JPanel(new BorderLayout());
        S.add(new Report());
        S.setBackground(Color.MAGENTA);

        T = new JPanel(new BorderLayout());
        T.add(new Acc_settings());
        // S.setBackground(Color.ORANGE);

        // main_content_panel
        main_panel = new JPanel();
        main_panel.setPreferredSize(new Dimension(500, 500));
        main_panel.setBackground(Color.white);
        main_panel.setLayout(card);
        main_panel.add(P, "1");
        main_panel.add(Q, "2");
        main_panel.add(R, "3");
        main_panel.add(S, "4");
        main_panel.add(T, "5");
        panel_2.add(main_panel, BorderLayout.CENTER);

        frame.setVisible(true);
    }

    public void log_out() {
        // JOptionPane.OK_CANCEL_OPTION;
        frame.dispose();
        // new log_in();
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        // System.out.println("DONE");
        // card.show(main_panel, "2");
        if (e.getSource() == icon2_label) {
            card.show(main_panel, "1");
        } else if (e.getSource() == icon3_label) {
            card.show(main_panel, "2");
        } else if (e.getSource() == icon4_label) {
            card.show(main_panel, "3");
        } else if (e.getSource() == icon5_label) {
            card.show(main_panel, "4");
        } else if (e.getSource() == icon6_label) {
            card.show(main_panel, "5");
        } else if (e.getSource() == logout) {
            log_out();
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
        // icon2_label.setBackground(Color.RED);

    }

    @Override
    public void mouseExited(MouseEvent e) {
        // icon2_label.setBackground(null);

    }
}
