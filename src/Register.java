// import Admin.*;
// import Accountant.*;

import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.sql.*;

public class Register implements ActionListener, MouseListener {

    public Connection conn;
    public Statement statement;
    public ResultSet resultSet;

    JFrame frame;
    JButton reg_btn;
    JTextField fname_field;
    JTextField sname_field;
    JTextField uname_field;
    JTextField email_field;
    JLabel label_footer2;
    JPasswordField CPassword_field;
    JPasswordField Password_field;

    public void reg() {

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/accounts_db", "root", "");
            statement = conn.createStatement();
        } catch (Exception e) {
            System.out.print(e);
        }

        frame = new JFrame();
        frame.setSize(800, 500);
        frame.setResizable(false);
        frame.setLocationRelativeTo(null);

        ImageIcon img = new ImageIcon("src/img/bg1.jpg");
        frame.setIconImage(img.getImage());

        JPanel panel1 = new JPanel();
        panel1.setLayout(new BorderLayout());
        panel1.setBackground(Color.decode("#123456"));
        frame.add(panel1);

        ImageIcon image2 = new ImageIcon(
                new ImageIcon("src/img/ico.png").getImage().getScaledInstance(306, 400, Image.SCALE_SMOOTH));

        JLabel ic = new JLabel();
        ic.setIcon(image2);

        JPanel Big_panel = new JPanel(new BorderLayout());
        Big_panel.setPreferredSize(new Dimension(390, 250));
        Big_panel.add(ic);
        Big_panel.setBackground(Color.decode("#123456"));

        panel1.add(Big_panel, BorderLayout.WEST);

        JPanel footer_panel = new JPanel(new FlowLayout(FlowLayout.CENTER));
        footer_panel.setBackground(Color.decode("#123456"));
        footer_panel.setPreferredSize(new Dimension(0, 40));
        Big_panel.add(footer_panel, BorderLayout.SOUTH);

        JLabel label_footer = new JLabel();
        label_footer.setText("Already Have an Account?...");
        label_footer.setForeground(Color.BLACK);
        label_footer.setFont(new Font("Calibri", Font.ITALIC, 12));
        footer_panel.add(label_footer);

        label_footer2 = new JLabel();
        label_footer2.setText("Log In");
        label_footer2.setForeground(Color.black);
        label_footer2.addMouseListener(this);
        label_footer2.setFont(new Font("Calibri", Font.BOLD, 12));
        footer_panel.add(label_footer2);

        JPanel panel2 = new JPanel(new BorderLayout());
        panel2.setPreferredSize(new Dimension(390, 250));
        panel2.setBackground(Color.WHITE);
        panel1.add(panel2, BorderLayout.EAST);

        JPanel box = new JPanel();
        box.setBackground(null);
        box.setLayout(new BoxLayout(box, BoxLayout.Y_AXIS));
        panel2.add(box, BorderLayout.NORTH);

        JPanel iconpanel = new JPanel(new FlowLayout(FlowLayout.CENTER));
        iconpanel.setBackground(Color.gray);
        iconpanel.setPreferredSize(new Dimension(100, 100));
        iconpanel.setBorder(BorderFactory.createEmptyBorder(40, 0, 0, 0));
        box.add(iconpanel);

        JLabel REG = new JLabel("REGISTRATION");
        REG.setFont(new Font("Calibri", Font.BOLD, 25));
        iconpanel.add(REG);

        // labels and fields Panels
        JPanel fieldpanel1 = new JPanel(new FlowLayout(FlowLayout.LEFT));
        fieldpanel1.setBackground(Color.decode("#FFFAFA"));
        fieldpanel1.setPreferredSize(new Dimension(100, 25));
        // fieldpanel1.setBorder(BorderFactory.createEmptyBorder(40, 0, 0, 0));
        box.add(fieldpanel1);

        // First name label
        JLabel fname = new JLabel("First Name");
        fname.setFont(new Font("Caribri", Font.PLAIN, 15));
        fieldpanel1.add(fname);

        JPanel fieldpanel2 = new JPanel(new FlowLayout(FlowLayout.LEFT));
        fieldpanel2.setBackground(Color.decode("#FFFAFA"));
        fieldpanel2.setPreferredSize(new Dimension(100, 25));
        // fieldpanel2.setBorder(BorderFactory.createEmptyBorder(40, 0, 0, 0));
        box.add(fieldpanel2);

        // First name field
        fname_field = new JTextField();
        fname_field.setPreferredSize(new Dimension(350, 20));
        fname_field.setBorder(BorderFactory.createMatteBorder(0, 0, 1, 0, Color.BLACK));
        fname_field.setBackground(Color.white);
        fieldpanel2.add(fname_field);

        JPanel fieldpanel3 = new JPanel(new FlowLayout(FlowLayout.LEFT));
        fieldpanel3.setBackground(Color.decode("#FFFAFA"));
        fieldpanel3.setPreferredSize(new Dimension(100, 25));
        // fieldpanel3.setBorder(BorderFactory.createEmptyBorder(40, 0, 0, 0));
        box.add(fieldpanel3);

        // Surname label
        JLabel sname = new JLabel("Surname");
        sname.setFont(new Font("Caribri", Font.PLAIN, 15));
        fieldpanel3.add(sname);

        JPanel fieldpanel4 = new JPanel(new FlowLayout(FlowLayout.LEFT));
        fieldpanel4.setBackground(Color.decode("#FFFAFA"));
        fieldpanel4.setPreferredSize(new Dimension(100, 25));
        // fieldpanel4.setBorder(BorderFactory.createEmptyBorder(40, 0, 0, 0));
        box.add(fieldpanel4);

        // Surname field
        sname_field = new JTextField();
        sname_field.setPreferredSize(new Dimension(350, 20));
        sname_field.setBorder(BorderFactory.createMatteBorder(0, 0, 1, 0, Color.BLACK));
        sname_field.setBackground(Color.white);
        fieldpanel4.add(sname_field);

        JPanel fieldpanel5 = new JPanel(new FlowLayout(FlowLayout.LEFT));
        fieldpanel5.setBackground(Color.decode("#FFFAFA"));
        fieldpanel5.setPreferredSize(new Dimension(100, 25));
        // fieldpanel5.setBorder(BorderFactory.createEmptyBorder(40, 0, 0, 0));
        box.add(fieldpanel5);

        // username label
        JLabel Uname = new JLabel("Username");
        Uname.setFont(new Font("Caribri", Font.PLAIN, 15));
        fieldpanel5.add(Uname);

        JPanel fieldpanel6 = new JPanel(new FlowLayout(FlowLayout.LEFT));
        fieldpanel6.setBackground(Color.decode("#FFFAFA"));
        fieldpanel6.setPreferredSize(new Dimension(100, 25));
        // fieldpanel6.setBorder(BorderFactory.createEmptyBorder(40, 0, 0, 0));
        box.add(fieldpanel6);

        // username field
        uname_field = new JTextField();
        uname_field.setPreferredSize(new Dimension(350, 20));
        uname_field.setBorder(BorderFactory.createMatteBorder(0, 0, 1, 0, Color.BLACK));
        uname_field.setBackground(Color.white);
        fieldpanel6.add(uname_field);

        JPanel fieldpanel7 = new JPanel(new FlowLayout(FlowLayout.LEFT));
        fieldpanel7.setBackground(Color.decode("#FFFAFA"));
        fieldpanel7.setPreferredSize(new Dimension(100, 25));
        box.add(fieldpanel7);

        // Email label
        JLabel email = new JLabel("Email");
        email.setFont(new Font("Caribri", Font.PLAIN, 15));
        fieldpanel7.add(email);

        JPanel fieldpanel8 = new JPanel(new FlowLayout(FlowLayout.LEFT));
        fieldpanel8.setBackground(Color.decode("#FFFAFA"));
        fieldpanel8.setPreferredSize(new Dimension(100, 25));
        box.add(fieldpanel8);

        // Email field
        email_field = new JTextField();
        email_field.setPreferredSize(new Dimension(350, 20));
        email_field.setBorder(BorderFactory.createMatteBorder(0, 0, 1, 0, Color.BLACK));
        email_field.setBackground(Color.white);
        fieldpanel8.add(email_field);

        JPanel fieldpanel9 = new JPanel(new FlowLayout(FlowLayout.LEFT));
        fieldpanel9.setBackground(Color.decode("#FFFAFA"));
        fieldpanel9.setPreferredSize(new Dimension(100, 25));
        box.add(fieldpanel9);

        // password label
        JLabel Password = new JLabel("Password");
        Password.setFont(new Font("Caribri", Font.PLAIN, 15));
        fieldpanel9.add(Password);

        JPanel fieldpanel10 = new JPanel(new FlowLayout(FlowLayout.LEFT));
        fieldpanel10.setBackground(Color.decode("#FFFAFA"));
        fieldpanel10.setPreferredSize(new Dimension(100, 25));
        box.add(fieldpanel10);

        // password field
        Password_field = new JPasswordField();
        Password_field.setPreferredSize(new Dimension(350, 20));
        Password_field.setBackground(Color.white);
        Password_field.setBorder(BorderFactory.createMatteBorder(0, 0, 1, 0, Color.BLACK));
        fieldpanel10.add(Password_field);

        JPanel fieldpanel11 = new JPanel(new FlowLayout(FlowLayout.LEFT));
        fieldpanel11.setBackground(Color.decode("#FFFAFA"));
        fieldpanel11.setPreferredSize(new Dimension(100, 25));
        box.add(fieldpanel11);

        // confirm password label
        JLabel C_password = new JLabel("Confirm Password");
        C_password.setFont(new Font("Caribri", Font.PLAIN, 15));
        fieldpanel11.add(C_password);

        JPanel fieldpanel12 = new JPanel(new FlowLayout(FlowLayout.LEFT));
        fieldpanel12.setBackground(Color.decode("#FFFAFA"));
        fieldpanel12.setPreferredSize(new Dimension(100, 25));
        box.add(fieldpanel12);

        // confirm password field
        CPassword_field = new JPasswordField();
        CPassword_field.setPreferredSize(new Dimension(350, 20));
        CPassword_field.setBackground(Color.white);
        CPassword_field.setBorder(BorderFactory.createMatteBorder(0, 0, 1, 0, Color.BLACK));
        fieldpanel12.add(CPassword_field);

        JPanel btn_panel = new JPanel(new FlowLayout(FlowLayout.TRAILING));
        btn_panel.setPreferredSize(new Dimension(100, 45));
        btn_panel.setBackground(Color.decode("#FFFAFA"));
        btn_panel.setBorder(BorderFactory.createEmptyBorder(10, 0, 0, 20));
        // btn_panel.setBorder(BorderFactory.createEmptyBorder(top, left, bottom,
        // right));
        box.add(btn_panel);

        // button
        reg_btn = new JButton();
        reg_btn.setText("Register");
        reg_btn.setBackground(Color.decode("#123456"));
        reg_btn.setForeground(Color.white);
        reg_btn.addActionListener(this);
        btn_panel.add(reg_btn);

        frame.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent event) {

        if (event.getSource() == reg_btn) {
            frame.dispose();
            DB();
            // ClearField();
        }

    }

    public void DB() {
        String fname = fname_field.getText();
        String sname = sname_field.getText();
        String uname = uname_field.getText();
        String email = email_field.getText();
        String password = Password_field.getText();
        String cpassword = CPassword_field.getText();

        // if (password != cpassword) {
        // JOptionPane.showMessageDialog(reg_btn, "Password Does not Match");
        // reg();
        // }
        try {

            if (password.compareTo(cpassword) != 0) {
                JOptionPane.showMessageDialog(reg_btn, "Password Does not Match");
                ClearField();
            } else {
                String query = "INSERT INTO `accountants-register` (`First-name`, `Last-name`, `Username`, `Email`, `Password`, `Conf-password`) VALUES ('"
                        + fname + "', '" + sname + "', '" + uname + "', '" + email + "', '" + password + "', '"
                        + cpassword + "')";
                int x = statement.executeUpdate(query);

                if (x > 0) {
                    // new log_in();
                    log_in lg = new log_in();
                    lg.login();
                } else {
                    JOptionPane.showMessageDialog(reg_btn, "FIll all Fields");
                    ClearField();
                }
            }

        } catch (Exception e) {
            System.out.print(e);
        }
    }

    public void ClearField() {
        fname_field.setText("");
        sname_field.setText("");
        uname_field.setText("");
        email_field.setText("");
        Password_field.setText("");
        CPassword_field.setText("");
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        if (e.getSource() == label_footer2) {
            frame.dispose();
            log_in log = new log_in();
            log.login();
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
