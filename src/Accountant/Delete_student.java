package Accountant;

import java.awt.Color;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;

// import Admin.*;
// import Accountant.*;

public class Delete_student implements ActionListener {

    JFrame frame;
    JTextField label;
    JButton btn_delete;

    public Connection connection;
    public Statement statement;
    public ResultSet resultSet;

    public Delete_student() {

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/accounts_db", "root", "");
            statement = connection.createStatement();
        } catch (Exception ex) {
            System.out.print(ex);
        }

        frame = new JFrame();

        ImageIcon icon1 = new ImageIcon("src/icons/delete-32.png");
        frame.setIconImage(icon1.getImage());
        frame.setLocationRelativeTo(null);
        frame.setSize(350, 200);
        frame.setResizable(false);
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

        JPanel Panel_1 = new JPanel(new BorderLayout());
        Panel_1.setPreferredSize(new Dimension(350, 0));
        Panel_1.setBackground(Color.cyan);
        frame.add(Panel_1);

        JPanel Box = new JPanel();
        Box.setLayout(new BoxLayout(Box, BoxLayout.Y_AXIS));
        // Box.setPreferredSize(new Dimension(350, 200));
        Box.setBackground(Color.white);
        Panel_1.add(Box, BorderLayout.NORTH);

        JPanel icon_panel = new JPanel();
        icon_panel.setPreferredSize(new Dimension(0, 60));
        icon_panel.setBackground(Color.DARK_GRAY);
        Box.add(icon_panel);

        ImageIcon icon = new ImageIcon(
                new ImageIcon("src/icons/delete-32.png").getImage().getScaledInstance(32, 32, Image.SCALE_DEFAULT));
        JLabel label_icon = new JLabel();
        label_icon.setText("DELETE STUDENT");
        label_icon.setForeground(Color.BLACK);
        label_icon.setIcon(icon);
        label_icon.setHorizontalTextPosition(JLabel.CENTER);
        label_icon.setVerticalTextPosition(JLabel.BOTTOM);
        icon_panel.add(label_icon);

        JPanel label_panel = new JPanel(new FlowLayout(FlowLayout.LEADING));
        label_panel.setPreferredSize(new Dimension(0, 30));
        label_panel.setBorder(BorderFactory.createEmptyBorder(10, 0, 0, 0));
        // label_panel.setBackground(Color.MAGENTA);
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

        JPanel btn_panel = new JPanel(new FlowLayout(FlowLayout.TRAILING));
        btn_panel.setPreferredSize(new Dimension(0, 40));
        // btn_panel.setBackground(Color.magenta);
        Box.add(btn_panel);

        btn_delete = new JButton();
        btn_delete.setText("Delete");
        btn_delete.setBackground(Color.decode("#123456"));
        btn_delete.setForeground(Color.white);
        btn_delete.setFocusable(false);
        btn_delete.addActionListener(this);
        btn_panel.add(btn_delete);

        frame.setVisible(true);

    }

    public void clear() {
        label.setText("");
    }

    public void delete_db() {
        try {
            String reg = label.getText();

            String query = "DELETE FROM `students-register` WHERE `Reg_no` = '" + reg + "'";

            statement = connection.prepareStatement(query);
            int x = statement.executeUpdate(query);

            if (x > 0) {
                JOptionPane.showMessageDialog(btn_delete, "Deleted Successfully");
                frame.dispose();

            } else {
                JOptionPane.showMessageDialog(btn_delete, "Failed to Delete...try again");
                clear();
            }

        } catch (Exception exe) {
            System.out.print(exe);
        }
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == btn_delete) {
            delete_db();
        }

    }

}
