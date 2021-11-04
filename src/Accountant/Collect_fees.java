package Accountant;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;

public class Collect_fees implements ActionListener {

    JFrame frame;
    JPanel layer;
    JPanel Heading_panel;

    JPanel Box;
    JTextField label;
    JTextField label2;
    JTextField label3;
    JButton btn_addpay;
    JButton btn_cancel;

    public Connection connection;
    public Statement statement;
    public ResultSet resultSet;

    public Collect_fees() {

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/accounts_db", "root", "");
            statement = connection.createStatement();
        } catch (Exception ex) {
            System.out.print(ex);
        }

        frame = new JFrame();
        frame.setSize(400, 320);
        frame.setLocationRelativeTo(null);
        frame.setResizable(false);
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

        layer = new JPanel(new BorderLayout());
        layer.setPreferredSize(new Dimension(350, 0));
        layer.setBackground(Color.cyan);
        frame.add(layer);

        JPanel Box = new JPanel();
        Box.setLayout(new BoxLayout(Box, BoxLayout.Y_AXIS));
        Box.setBackground(Color.white);
        layer.add(Box, BorderLayout.NORTH);

        JPanel icon_panel = new JPanel();
        icon_panel.setPreferredSize(new Dimension(0, 60));
        icon_panel.setBackground(Color.DARK_GRAY);
        Box.add(icon_panel);

        ImageIcon icon = new ImageIcon(
                new ImageIcon("src/icons/us-dollar-24.png").getImage().getScaledInstance(32, 32, Image.SCALE_DEFAULT));
        JLabel label_icon = new JLabel();
        label_icon.setText("COLLECT FEES");
        label_icon.setForeground(Color.BLACK);
        label_icon.setIcon(icon);
        label_icon.setHorizontalTextPosition(JLabel.CENTER);
        label_icon.setVerticalTextPosition(JLabel.BOTTOM);
        icon_panel.add(label_icon);

        JPanel label_panel = new JPanel(new FlowLayout(FlowLayout.LEADING));
        label_panel.setPreferredSize(new Dimension(0, 30));
        label_panel.setBorder(BorderFactory.createEmptyBorder(10, 0, 0, 0));
        Box.add(label_panel);

        JLabel label_text = new JLabel();
        label_text.setText("Reg No");
        // label_text.setFont(new Font("calibri"));
        label_panel.add(label_text);

        JPanel field_panel = new JPanel(new FlowLayout(FlowLayout.LEADING));
        field_panel.setPreferredSize(new Dimension(0, 30));
        // field_panel.setBackground(Color.DARK_GRAY);
        Box.add(field_panel);

        label = new JTextField();
        label.setPreferredSize(new Dimension(250, 20));
        label.setBorder(BorderFactory.createMatteBorder(0, 0, 1, 0, Color.black));
        label.setBackground(null);
        field_panel.add(label);

        JPanel label2_panel = new JPanel(new FlowLayout(FlowLayout.LEADING));
        label2_panel.setPreferredSize(new Dimension(0, 30));
        label2_panel.setBorder(BorderFactory.createEmptyBorder(10, 0, 0, 0));
        Box.add(label2_panel);

        JLabel label2_text = new JLabel();
        label2_text.setText("First Name");
        // label_text.setFont(new Font("calibri"));
        label2_panel.add(label2_text);

        JPanel field_panel2 = new JPanel(new FlowLayout(FlowLayout.LEADING));
        field_panel2.setPreferredSize(new Dimension(0, 30));
        // field_panel.setBackground(Color.DARK_GRAY);
        Box.add(field_panel2);

        label2 = new JTextField();
        label2.setPreferredSize(new Dimension(250, 20));
        label2.setBorder(BorderFactory.createMatteBorder(0, 0, 1, 0, Color.black));
        label2.setBackground(null);
        field_panel2.add(label2);

        JPanel label3_panel = new JPanel(new FlowLayout(FlowLayout.LEADING));
        label3_panel.setPreferredSize(new Dimension(0, 30));
        label3_panel.setBorder(BorderFactory.createEmptyBorder(10, 0, 0, 0));
        Box.add(label3_panel);

        JLabel label3_text = new JLabel();
        label3_text.setText("Amount (Mwk)");
        // label_text.setFont(new Font("calibri"));
        label3_panel.add(label3_text);

        JPanel field3_panel = new JPanel(new FlowLayout(FlowLayout.LEADING));
        field3_panel.setPreferredSize(new Dimension(0, 30));
        // field_panel.setBackground(Color.DARK_GRAY);
        Box.add(field3_panel);

        label3 = new JTextField();
        label3.setPreferredSize(new Dimension(250, 20));
        label3.setBorder(BorderFactory.createMatteBorder(0, 0, 1, 0, Color.black));
        label3.setBackground(null);
        field3_panel.add(label3);

        JPanel btn_panel = new JPanel(new FlowLayout(FlowLayout.TRAILING));
        btn_panel.setPreferredSize(new Dimension(0, 40));
        // btn_panel.setBackground(Color.magenta);
        Box.add(btn_panel);

        btn_addpay = new JButton();
        btn_addpay.setText("Add Payment");
        btn_addpay.setBackground(Color.decode("#123456"));
        btn_addpay.setForeground(Color.white);
        btn_addpay.setFocusable(false);
        btn_addpay.addActionListener(this);
        btn_panel.add(btn_addpay);

        // btn_cancel = new JButton();
        // btn_cancel.setText("Back");
        // btn_cancel.setBackground(Color.decode("#123456"));
        // btn_cancel.setForeground(Color.white);
        // btn_cancel.setFocusable(false);
        // btn_cancel.addActionListener(this);
        // btn_panel.add(btn_cancel);

        frame.setVisible(true);
    }

    public void add() {

        // formula for math
        // int fixed = 560000;
        // String am = label2.getText();
        // int AM = Integer.parseInt(am);

        // int sum = fixed - AM;

        // String balance = fixed - am;

        try {
            int fees = 560000;
            String value = label3.getText();
            int Amt = Integer.parseInt(value);

            String reg = label.getText();
            String name = label2.getText();
            String amount = label3.getText();

            // formula
            int bal = fees - Amt;

            String query = "UPDATE `students-register` SET `Amount-paid`='" + amount + "', `Due-balance`='" + bal
                    + "' WHERE `Reg_no`='" + reg + "' AND `First-name`='" + name + "' ";
            // String query = "UPDATE `students-register` SET `Amount-paid`='" + amount + "'
            // WHERE `reg_no`='" + reg
            // + "' ";

            statement = connection.prepareStatement(query);
            int x = statement.executeUpdate(query);

            if (x > 0) {
                JOptionPane.showMessageDialog(btn_addpay, "Payment Successful");

            } else {
                JOptionPane.showMessageDialog(btn_addpay, "Failed to Add Payment");
                clearfield();
            }

        } catch (Exception exe) {
            System.out.print(exe);
        }

    }

    public void clearfield() {
        label.setText("");
        ;
        label2.setText("");
        label3.setText("");
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == btn_addpay) {
            add();
        }

    }
}
