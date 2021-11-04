package Accountant;

import javax.swing.*;
import javax.swing.plaf.DimensionUIResource;
import javax.swing.table.*;

import net.proteanit.sql.DbUtils;

import javax.swing.border.*;
import java.awt.*;

import java.sql.*;
import java.awt.event.*;

public class view_students implements ActionListener {

    public Connection connection;
    public Statement statement;
    public ResultSet resultSet;

    DefaultTableModel model = new DefaultTableModel();
    JTable table = new JTable(model);

    JFrame frame;
    JButton btn_search;
    JButton btn_back;
    JTextField search_field;

    public view_students() {

        frame = new JFrame();
        frame.setSize(800, 500);
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frame.setLocationRelativeTo(null);
        frame.setResizable(false);

        JPanel container = new JPanel(new BorderLayout());
        container.setBackground(Color.GRAY);
        frame.add(container);

        JPanel header_panel = new JPanel(new FlowLayout(FlowLayout.TRAILING));
        header_panel.setPreferredSize(new Dimension(0, 60));
        header_panel.setBackground(Color.DARK_GRAY);
        header_panel.setBorder(BorderFactory.createEmptyBorder(20, 0, 0, 0));
        container.add(header_panel, BorderLayout.NORTH);

        search_field = new JTextField();
        search_field.setBorder(BorderFactory.createMatteBorder(0, 0, 1, 0, Color.WHITE));
        search_field.setPreferredSize(new Dimension(150, 20));
        search_field.setBackground(Color.DARK_GRAY);
        search_field.setFocusable(true);
        search_field.setForeground(Color.WHITE);
        header_panel.add(search_field);

        btn_search = new JButton();
        btn_search.setText("Search");
        btn_search.setBackground(Color.decode("#123456"));
        btn_search.setForeground(Color.WHITE);
        btn_search.setFocusable(false);
        btn_search.addActionListener(this);
        header_panel.add(btn_search);

        JPanel main_panel = new JPanel(new BorderLayout());
        main_panel.setBackground(Color.white);
        container.add(main_panel);

        JPanel table_panel = new JPanel();
        table_panel.setBackground(Color.WHITE);
        table_panel.setBorder(BorderFactory.createTitledBorder(BorderFactory.createEtchedBorder(), "View Students",
                TitledBorder.LEADING, TitledBorder.TOP));
        main_panel.add(table_panel);

        // DefaultTableModel model = new DefaultTableModel();
        // JTable table = new JTable(model);

        model.addColumn("REG NO");
        model.addColumn("FIRST NAME");
        model.addColumn("SURNAME");
        model.addColumn("EMAIL");
        model.addColumn("PHONE NUMBER");
        model.addColumn("YEAR");
        model.addColumn("SEMESTER");

        JScrollPane Scroll = new JScrollPane(table);
        Scroll.setPreferredSize(new Dimension(750, 320));

        JTableHeader head = table.getTableHeader();
        head.setPreferredSize(new DimensionUIResource(600, 20));
        head.setBackground(Color.white);
        table_panel.add(Scroll);

        table.setShowVerticalLines(true);
        table.setShowHorizontalLines(false);

        JPanel footer_panel = new JPanel(new FlowLayout(FlowLayout.LEADING));
        footer_panel.setBackground(Color.DARK_GRAY);
        footer_panel.setPreferredSize(new Dimension(0, 40));
        main_panel.add(footer_panel, BorderLayout.SOUTH);

        btn_back = new JButton();
        btn_back.setText("Back");
        btn_back.setBackground(Color.decode("#123456"));
        btn_back.setForeground(Color.WHITE);
        btn_back.setFocusable(false);
        btn_back.addActionListener(this);
        footer_panel.add(btn_back);

        try {
            String query = "SELECT * FROM `students-register`";
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/accounts_db", "root", "");
            statement = conn.prepareStatement(query);

            resultSet = statement.executeQuery(query);

            while (resultSet.next()) {
                model.addRow(new Object[] { resultSet.getString(1), resultSet.getString(2), resultSet.getString(3),
                        resultSet.getString(4), resultSet.getString(5), resultSet.getString(6),
                        resultSet.getString(7) });
            }
        } catch (Exception e) {
            System.out.println(e);
        }

        frame.setVisible(true);
    }

    public void search() {
        String value = search_field.getText();
        try {
            Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/accounts_db", "root", "");
            String query = "SELECT `Reg_no`, `First-name`, `Surname`, `Email`, `Phone-number`, `Year`, `Semester` FROM `students-register` WHERE `Reg_no`  LIKE '%"
                    + value + "%' OR `First-name` LIKE '%" + value + "%' ";

            statement = conn.prepareStatement(query);
            resultSet = statement.executeQuery(query);

            table.setModel(DbUtils.resultSetToTableModel(resultSet));
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    @Override
    public void actionPerformed(ActionEvent ep) {
        if (ep.getSource() == btn_back) {
            frame.dispose();
        } else if (ep.getSource() == btn_search) {
            search();
        }

    }

    // public void view() {
    // try {
    // String query = "SELECT * FROM `students-register`";
    // Class.forName("com.mysql.cj.jdbc.Driver");
    // Connection conn =
    // DriverManager.getConnection("jdbc:mysql://localhost:3306/accounts_db",
    // "root", "");
    // statement = conn.prepareStatement(query);

    // resultSet = statement.executeQuery(query);

    // while (resultSet.next()) {
    // model.addRow(new Object[] { resultSet.getString(1), resultSet.getString(2),
    // resultSet.getString(4),
    // resultSet.getString(5), resultSet.getString(6), resultSet.getString(7) });
    // }
    // } catch (Exception e) {
    // System.out.println(e);
    // }

    // new view_students();
    // }
}
