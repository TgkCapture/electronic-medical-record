import Admin.*;
import Accountant.*;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.ImageIcon;
import java.sql.*;

public class log_in implements ActionListener, MouseListener {
    JFrame frame = new JFrame();

    JButton login_btn;
    JTextField txt_name;
    JPasswordField txt_password;
    JLabel link_text2;

    Connection connection = null;

    public void login() {
        // JFrame frame = new JFrame();

        frame.setTitle("Log In");
        frame.setResizable(false);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        // frame.setLayout(null);
        frame.setSize(700, 500);
        frame.setLocationRelativeTo(null);

        ImageIcon img = new ImageIcon("src/icons/USER_ICON.jpg");
        frame.setIconImage(img.getImage());

        JPanel panel = new JPanel(new FlowLayout(FlowLayout.CENTER));
        panel.setBackground(Color.decode("#123456"));
        frame.add(panel);

        JPanel panel2 = new JPanel(new BorderLayout());
        panel2.setPreferredSize(new Dimension(400, 400));
        panel2.setBackground(Color.BLUE);
        panel.add(panel2);

        JPanel box = new JPanel();
        box.setBackground(null);
        box.setLayout(new BoxLayout(box, BoxLayout.Y_AXIS));
        panel2.add(box, BorderLayout.NORTH);

        // icon
        JPanel iconpanel = new JPanel(new FlowLayout(FlowLayout.CENTER));
        iconpanel.setBackground(Color.decode("#FFFAFA"));
        iconpanel.setPreferredSize(new Dimension(100, 150));
        iconpanel.setBorder(BorderFactory.createEmptyBorder(40, 0, 0, 0));
        box.add(iconpanel);

        ImageIcon logIcon = new ImageIcon(
                new ImageIcon("src/icons/user.jpg").getImage().getScaledInstance(75, 75, Image.SCALE_DEFAULT));

        JLabel icon = new JLabel();
        icon.setText("LOG IN");
        icon.setIcon(logIcon);
        icon.setVerticalAlignment(JLabel.TOP);
        icon.setHorizontalTextPosition(JLabel.CENTER);
        icon.setVerticalTextPosition(JLabel.BOTTOM);
        // icon.setHorizontalAlignment(JLabel.CENTER);
        // icon.setIconTextGap(iconTextGap);
        iconpanel.add(icon);

        // namelabel panel
        JPanel namepanel = new JPanel(new FlowLayout(FlowLayout.LEFT));
        namepanel.setBackground(Color.decode("#FFFAFA"));
        namepanel.setPreferredSize(new Dimension(100, 30));
        // namepanel.setBorder(BorderFactory.createEmptyBorder(40, 0, 0, 0));
        box.add(namepanel);

        JLabel namelabel = new JLabel("Username");
        namelabel.setFont(new Font("Caribli", Font.PLAIN, 15));
        namepanel.add(namelabel);

        // name field panel
        JPanel namefield_panel = new JPanel(new FlowLayout(FlowLayout.LEFT));
        namefield_panel.setBackground(Color.decode("#FFFAFA"));
        namefield_panel.setPreferredSize(new Dimension(100, 30));
        // namefield_panel.setBorder(BorderFactory.createEmptyBorder(40, 0, 0, 0));
        box.add(namefield_panel);

        txt_name = new JTextField();
        txt_name.setBackground(Color.WHITE);
        txt_name.setPreferredSize(new Dimension(350, 20));
        // txt_name.setFocusable(false);
        // txt_name.setBounds(20, 40, 100, 20);
        txt_name.setBorder(BorderFactory.createMatteBorder(0, 0, 1, 0, Color.BLACK));
        namefield_panel.add(txt_name);

        // password label panel
        JPanel passwordpanel = new JPanel(new FlowLayout(FlowLayout.LEFT));
        passwordpanel.setBackground(Color.decode("#FFFAFA"));
        passwordpanel.setPreferredSize(new Dimension(100, 30));
        // passwordpanel.setBorder(BorderFactory.createEmptyBorder(5, 0, 0, 0));
        box.add(passwordpanel);

        JLabel passlabel = new JLabel("Password");
        passlabel.setFont(new Font("Caribli", Font.PLAIN, 15));
        passwordpanel.add(passlabel);

        // password field panel
        JPanel passwordfield_panel = new JPanel(new FlowLayout(FlowLayout.LEFT));
        passwordfield_panel.setBackground(Color.decode("#FFFAFA"));
        passwordfield_panel.setPreferredSize(new Dimension(100, 25));
        // passwordpanel.setBorder(BorderFactory.createEmptyBorder(40, 0, 0, 0));
        box.add(passwordfield_panel);

        txt_password = new JPasswordField();
        txt_password.setBackground(Color.WHITE);
        txt_password.setPreferredSize(new Dimension(350, 20));
        // txt_password.setFocusable(false);
        txt_password.setBorder(BorderFactory.createMatteBorder(0, 0, 1, 0, Color.black));
        passwordfield_panel.add(txt_password);

        // button
        JPanel buttonpanel = new JPanel(new FlowLayout(FlowLayout.TRAILING));
        buttonpanel.setBackground(Color.decode("#FFFAFA"));
        buttonpanel.setPreferredSize(new Dimension(100, 100));
        buttonpanel.setBorder(BorderFactory.createEmptyBorder(20, 10, 0, 0));
        box.add(buttonpanel);

        login_btn = new JButton();
        login_btn.setText("LOG IN");
        login_btn.setBackground(Color.decode("#123456"));
        login_btn.setForeground(Color.white);
        login_btn.setFocusable(false);
        login_btn.addActionListener(this);
        buttonpanel.add(login_btn);

        // footer panel
        JPanel footer_panel = new JPanel(new FlowLayout(FlowLayout.LEADING));
        footer_panel.setPreferredSize(new Dimension(100, 35));
        footer_panel.setBackground(Color.decode("#FFFAFA"));
        box.add(footer_panel);

        JLabel link_text = new JLabel();
        link_text.setText("Don't Have an Account?...");
        link_text.setFont(new Font("Calibri", Font.ITALIC, 12));
        link_text.setForeground(Color.decode("#123456"));
        footer_panel.add(link_text);

        link_text2 = new JLabel();
        link_text2.setText("Register");
        link_text2.setFont(new Font("Calibri", Font.BOLD, 12));
        link_text2.addMouseListener(this);
        footer_panel.add(link_text2);

        frame.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {

        if (e.getSource() == login_btn) {
            DefaultAdmin();
        }
    }

    public void DefaultAdmin() {
        String Admin = "ADMIN1";
        String Password = "1234";

        String ADMIN = txt_name.getText();
        String PASSWORD = txt_password.getText();

        if (ADMIN.compareToIgnoreCase(Admin) == 0 && PASSWORD.compareToIgnoreCase(Password) == 0) {
            frame.dispose();
            new Admin_dashboard();
            // System.out.println("DONE");
        } else {
            validateDB();
        }
    }

    public void validateDB() {
        DatabaseConn CON = new DatabaseConn();
        connection = CON.getConnection();

        String uname = txt_name.getText();
        String pass = txt_password.getText();

        try {
            String url = "SELECT `Username`, `Password` FROM `accountants-register` WHERE `Username`='" + uname
                    + "' AND `Password`='" + pass + "'";
            Statement st = connection.createStatement();
            ResultSet Set = st.executeQuery(url);

            if (!Set.next()) {
                JOptionPane.showMessageDialog(login_btn, "INVALID PASSWORD OR USERNAME");
                ClearField();
            } else {
                // JOptionPane.showMessageDialog(login_btn, "SUCCESS");
                frame.dispose();
                new Dashboard();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    public void ClearField() {
        txt_name.setText("");
        txt_password.setText("");
    }

    @Override
    public void mouseClicked(MouseEvent event) {
        if (event.getSource() == link_text2) {
            frame.dispose();
            Register rg = new Register();
            rg.reg();

        }

    }

    @Override
    public void mousePressed(MouseEvent event) {
        // TODO Auto-generated method stub

    }

    @Override
    public void mouseReleased(MouseEvent event) {
        // TODO Auto-generated method stub

    }

    @Override
    public void mouseEntered(MouseEvent event) {
        // TODO Auto-generated method stub

    }

    @Override
    public void mouseExited(MouseEvent event) {
        // TODO Auto-generated method stub

    }

}