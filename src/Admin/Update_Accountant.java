package Admin;

// import Accountant.*;
// import Admin.*;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

import java.sql.*;

public class Update_Accountant implements ActionListener {

    // Connection connection = null;
    public Connection connection;
    public Statement statement;
    public ResultSet resultSet;

    JFrame frame;
    JTextField field1;
    JTextField field2;
    JTextField field3;
    JTextField field4;
    JTextField field_2;
    JTextField field_3;
    JTextField field_4;

    JButton Update_btn;

    public Update_Accountant() {

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/accounts_db", "root", "");
            statement = connection.createStatement();
        } catch (Exception ex) {
            System.out.print(ex);
        }

        frame = new JFrame();

        frame.setTitle("Update Accountant");
        frame.setResizable(false);
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frame.setSize(500, 400);
        frame.setLocationRelativeTo(null);

        ImageIcon title_icon = new ImageIcon("src/icons/edit-user-48.png");
        frame.setIconImage(title_icon.getImage());

        // box panel
        JPanel container = new JPanel();
        container.setBackground(Color.CYAN);
        container.setLayout(new BorderLayout());
        frame.add(container);

        JPanel heading_panel = new JPanel();
        heading_panel.setBackground(Color.gray);
        heading_panel.setPreferredSize(new Dimension(0, 75));
        container.add(heading_panel, BorderLayout.NORTH);

        ImageIcon heading_icon = new ImageIcon(
                new ImageIcon("src/icons/edit-user-48.png").getImage().getScaledInstance(48, 48, Image.SCALE_DEFAULT));
        JLabel heading_label = new JLabel();
        heading_label.setText("UPDATE ACCOUNTANT");
        heading_label.setIcon(heading_icon);
        heading_label.setHorizontalTextPosition(JLabel.CENTER);
        heading_label.setVerticalTextPosition(JLabel.BOTTOM);
        heading_panel.add(heading_label);

        JPanel box1 = new JPanel(new BorderLayout());
        box1.setBackground(Color.WHITE);
        box1.setPreferredSize(new Dimension(250, 0));
        // box1.setLayout(new BoxLayout(box1, BoxLayout.Y_AXIS));
        container.add(box1);

        // LEFT HAND SIDE BOX
        JPanel A = new JPanel();
        A.setBackground(Color.WHITE);
        A.setLayout(new BoxLayout(A, BoxLayout.Y_AXIS));
        box1.add(A, BorderLayout.NORTH);

        // fields in box 1
        JPanel label1_panel = new JPanel(new FlowLayout(FlowLayout.LEADING));
        // label1_panel.setBackground(Color.CYAN);
        label1_panel.setPreferredSize(new Dimension(0, 20));
        A.add(label1_panel);

        JLabel label_1 = new JLabel();
        label_1.setText("ID No");
        label1_panel.add(label_1);

        // field
        JPanel field1_panel = new JPanel(new FlowLayout(FlowLayout.LEADING));
        // field1_panel.setBackground(Color.LIGHT_GRAY);
        field1_panel.setPreferredSize(new Dimension(0, 30));
        field1_panel.setSize(new Dimension(0, 25));
        A.add(field1_panel);

        field1 = new JTextField();
        field1.setPreferredSize(new Dimension(210, 20));
        field1.setBorder(BorderFactory.createMatteBorder(0, 0, 1, 0, Color.black));
        field1.setBackground(null);
        field1_panel.add(field1);

        JPanel label2_panel = new JPanel(new FlowLayout(FlowLayout.LEADING));
        // label2_panel.setBackground(Color.CYAN);
        label2_panel.setPreferredSize(new Dimension(0, 20));
        A.add(label2_panel);

        JLabel label_2 = new JLabel();
        label_2.setText("First Name");
        label2_panel.add(label_2);

        JPanel field2_panel = new JPanel(new FlowLayout(FlowLayout.LEADING));
        // field2_panel.setBackground(Color.LIGHT_GRAY);
        field2_panel.setPreferredSize(new Dimension(0, 30));
        A.add(field2_panel);

        field2 = new JTextField();
        field2.setPreferredSize(new Dimension(210, 20));
        field2.setBorder(BorderFactory.createMatteBorder(0, 0, 1, 0, Color.black));
        field2.setBackground(null);
        field2_panel.add(field2);

        JPanel label3_panel = new JPanel(new FlowLayout(FlowLayout.LEADING));
        // label3_panel.setBackground(Color.CYAN);
        label3_panel.setPreferredSize(new Dimension(0, 20));
        A.add(label3_panel);

        JLabel label_3 = new JLabel();
        label_3.setText("Username");
        label3_panel.add(label_3);

        JPanel field3_panel = new JPanel(new FlowLayout(FlowLayout.LEADING));
        // field3_panel.setBackground(Color.LIGHT_GRAY);
        field3_panel.setPreferredSize(new Dimension(0, 30));
        A.add(field3_panel);

        field3 = new JTextField();
        field3.setPreferredSize(new Dimension(210, 20));
        field3.setBorder(BorderFactory.createMatteBorder(0, 0, 1, 0, Color.black));
        field3.setBackground(null);
        field3_panel.add(field3);

        JPanel label4_panel = new JPanel(new FlowLayout(FlowLayout.LEADING));
        // label4_panel.setBackground(Color.CYAN);
        label4_panel.setPreferredSize(new Dimension(0, 20));
        A.add(label4_panel);
        /*
         * JLabel label_4 = new JLabel(); label_4.setText("Year Of Study");
         * label4_panel.add(label_4);
         */
        JPanel field4_panel = new JPanel(new FlowLayout(FlowLayout.LEADING));
        // field4_panel.setBackground(Color.LIGHT_GRAY);
        field4_panel.setPreferredSize(new Dimension(0, 30));
        A.add(field4_panel);
        /*
         * field4 = new JTextField(); field4.setPreferredSize(new Dimension(210, 20));
         * field4.setBorder(BorderFactory.createMatteBorder(0, 0, 1, 0, Color.black));
         * field4.setBackground(null); field4_panel.add(field4);
         */
        JPanel Cancel_panel = new JPanel(new FlowLayout());
        Cancel_panel.setPreferredSize(new Dimension(0, 82));

        A.add(Cancel_panel);

        // right hand side Box
        JPanel box2 = new JPanel(new BorderLayout());
        box2.setBackground(Color.WHITE);
        box2.setPreferredSize(new Dimension(250, 0));
        container.add(box2, BorderLayout.EAST);

        // JPanel B = new JPanel();

        JPanel B = new JPanel();
        B.setBackground(Color.WHITE);
        B.setLayout(new BoxLayout(B, BoxLayout.Y_AXIS));
        box2.add(B, BorderLayout.NORTH);

        // fields in box 1
        JPanel label_panel1 = new JPanel(new FlowLayout(FlowLayout.LEADING));
        // label_panel1.setBackground(Color.LIGHT_GRAY);
        label_panel1.setOpaque(true);
        label_panel1.setPreferredSize(new Dimension(0, 20));
        B.add(label_panel1);

        // JLabel label1 = new JLabel();
        // label1.setText("");
        // label_panel1.add(label1);

        // field
        JPanel field_panel1 = new JPanel(new FlowLayout(FlowLayout.LEADING));
        // field_panel1.setBackground(Color.CYAN);
        field_panel1.setOpaque(true);
        field_panel1.setPreferredSize(new Dimension(0, 30));
        B.add(field_panel1);

        // JTextField field_1 = new JTextField();
        // field_1.setPreferredSize(new Dimension(210, 20));
        // field_1.setBorder(BorderFactory.createMatteBorder(0, 0, 1, 0, Color.black));
        // field_panel1.add(field_1);

        JPanel label_panel2 = new JPanel(new FlowLayout(FlowLayout.LEADING));
        // label_panel2.setBackground(Color.LIGHT_GRAY);
        label_panel2.setPreferredSize(new Dimension(0, 20));
        B.add(label_panel2);

        JLabel label2 = new JLabel();
        label2.setText("Surname");
        label_panel2.add(label2);

        JPanel field_panel2 = new JPanel(new FlowLayout(FlowLayout.LEADING));
        // field_panel2.setBackground(Color.CYAN);
        field_panel2.setPreferredSize(new Dimension(0, 30));
        B.add(field_panel2);

        field_2 = new JTextField();
        field_2.setPreferredSize(new Dimension(210, 20));
        field_2.setBorder(BorderFactory.createMatteBorder(0, 0, 1, 0, Color.black));
        field_2.setBackground(null);
        field_panel2.add(field_2);

        JPanel label_panel3 = new JPanel(new FlowLayout(FlowLayout.LEADING));
        // label_panel3.setBackground(Color.LIGHT_GRAY);
        label_panel3.setPreferredSize(new Dimension(0, 20));
        B.add(label_panel3);

        JLabel label3 = new JLabel();
        label3.setText("Email");
        label_panel3.add(label3);

        JPanel field_panel3 = new JPanel(new FlowLayout(FlowLayout.LEFT));
        // field_panel3.setBackground(Color.CYAN);
        field_panel3.setPreferredSize(new Dimension(0, 30));
        B.add(field_panel3);

        field_3 = new JTextField();
        field_3.setPreferredSize(new Dimension(210, 20));
        field_3.setBorder(BorderFactory.createMatteBorder(0, 0, 1, 0, Color.black));
        field_3.setBackground(null);
        field_panel3.add(field_3);

        JPanel label_panel4 = new JPanel(new FlowLayout(FlowLayout.LEFT));
        // label_panel4.setBackground(Color.LIGHT_GRAY);
        label_panel4.setPreferredSize(new Dimension(0, 20));
        B.add(label_panel4);
        /*
         * JLabel label4 = new JLabel(); label4.setText("Semester");
         * label_panel4.add(label4);
         */
        JPanel field_panel4 = new JPanel(new FlowLayout(FlowLayout.LEADING));
        // field_panel4.setBackground(Color.CYAN);
        field_panel4.setPreferredSize(new Dimension(0, 30));
        B.add(field_panel4);
        /*
         * field_4 = new JTextField(); field_4.setPreferredSize(new Dimension(210, 20));
         * field_4.setBorder(BorderFactory.createMatteBorder(0, 0, 1, 0, Color.black));
         * field_4.setBackground(null); field_panel4.add(field_4);
         */
        JPanel Button_panel = new JPanel(new FlowLayout(FlowLayout.TRAILING));
        // Button_panel.setBackground(null);
        Button_panel.setPreferredSize(new Dimension(0, 82));
        Button_panel.setBorder(BorderFactory.createEmptyBorder(20, 0, 0, 25));
        B.add(Button_panel);

        Update_btn = new JButton();
        Update_btn.setText("UPDATE");
        Update_btn.setFocusable(false);
        Update_btn.setBackground(Color.decode("#123456"));
        Update_btn.setForeground(Color.WHITE);
        Update_btn.addActionListener(this);

        Button_panel.add(Update_btn);

        frame.setVisible(true);
    }

    public void UpdateDB() {

        try {
            // String regno = field1.getText();
            String id = field1.getText();
            String fname = field2.getText();
            String surname = field_2.getText();
            String username = field3.getText();
            String email = field_3.getText();
            // String semester = field4.getText();
            // String year = field_4.getText();

            String query = "UPDATE `accountants-register` SET `First-name`='" + fname + "', `Last-name`='" + surname
                    + "', `Username`='" + username + "', `Email`='" + email + "' WHERE  `ID`='" + id + "'";

            statement = connection.prepareStatement(query);
            int x = statement.executeUpdate(query);

            if (x > 0) {
                JOptionPane.showMessageDialog(Update_btn, "Updated Successfully");
                frame.dispose();
            } else {
                JOptionPane.showMessageDialog(Update_btn, "Failed to Update");
                ClearField();
            }

        } catch (Exception ey) {
            System.out.print(ey);
        }

    }

    public void ClearField() {
        field1.setText("");
        field2.setText("");
        field_2.setText("");
        field3.setText("");

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == Update_btn) {

            UpdateDB();
            ClearField();
        }

    }

}
