package Accountant;

import javax.swing.*;

import javax.swing.plaf.DimensionUIResource;
import javax.swing.table.*;

import net.proteanit.sql.DbUtils;

import javax.swing.border.*;
import java.awt.*;

import java.sql.*;
import java.awt.event.*;

public class viewfees_balance implements ActionListener {

    public Connection connection;
    public Statement statement;
    public ResultSet resultSet;

    DefaultTableModel model = new DefaultTableModel();
    JTable table = new JTable(model);

    JFrame frame;
    JTextField search_field;
    JButton btn_search;

    public viewfees_balance() {

        frame = new JFrame();
        frame.setSize(600, 400);
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
        table_panel.setBorder(BorderFactory.createTitledBorder(BorderFactory.createEtchedBorder(), "View Fees Balance",
                TitledBorder.LEADING, TitledBorder.TOP));
        main_panel.add(table_panel);

        model.addColumn("REG NO");
        model.addColumn("FIRST NAME");
        model.addColumn("SURNAME");
        model.addColumn("Amount Paid");
        model.addColumn("Balance Due");

        JScrollPane Scroll = new JScrollPane(table);
        Scroll.setPreferredSize(new Dimension(550, 250));

        JTableHeader head = table.getTableHeader();
        head.setPreferredSize(new DimensionUIResource(600, 20));
        head.setBackground(Color.white);
        table_panel.add(Scroll);

        table.setShowVerticalLines(true);
        table.setShowHorizontalLines(false);
        table.setBackground(Color.white);

        try {
            String query = "SELECT `Reg_no`, `First-name`, `Surname`, `Amount-paid`, `Due-balance` FROM `students-register`";
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/accounts_db", "root", "");
            statement = conn.prepareStatement(query);

            resultSet = statement.executeQuery(query);

            while (resultSet.next()) {
                model.addRow(new Object[] { resultSet.getString(1), resultSet.getString(2), resultSet.getString(3),
                        resultSet.getInt(4), resultSet.getInt(5) });
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
            String query = "SELECT `Reg_no`, `First-name`, `Surname`, `Amount-paid`, `Due-balance` FROM `students-register` WHERE `Reg_no`  LIKE '%"
                    + value + "%' OR `First-name` LIKE '%" + value + "%' ";

            statement = conn.prepareStatement(query);
            resultSet = statement.executeQuery(query);

            table.setModel(DbUtils.resultSetToTableModel(resultSet));
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    @Override
    public void actionPerformed(ActionEvent event) {
        if (event.getSource() == btn_search) {
            search();
        }
    }
}
