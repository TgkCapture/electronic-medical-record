package Admin;

import javax.swing.*;
import javax.swing.border.TitledBorder;

import java.awt.*;
import java.awt.event.*;

public class Admin_settings extends JPanel {

        JPanel container;
        JPanel Heading_panel;
        JPanel Box;

        public Admin_settings() {

                this.setLayout(new BorderLayout());

                container = new JPanel(new BorderLayout());
                container.setBackground(Color.RED);
                this.add(container, BorderLayout.CENTER);

                Heading_panel = new JPanel();
                Heading_panel.setBackground(Color.gray);
                Heading_panel.setPreferredSize(new Dimension(0, 75));
                container.add(Heading_panel, BorderLayout.NORTH);

                ImageIcon heading_icon = new ImageIcon(new ImageIcon("src/icons/settings-24-48.png").getImage()
                                .getScaledInstance(32, 32, Image.SCALE_DEFAULT));

                JLabel heading_label = new JLabel();
                heading_label.setText("SETTINGS");
                heading_label.setIcon(heading_icon);
                heading_label.setHorizontalTextPosition(JLabel.CENTER);
                heading_label.setVerticalTextPosition(JLabel.BOTTOM);
                Heading_panel.add(heading_label);

                Box = new JPanel(new BorderLayout());
                Box.setBackground(Color.decode("#F3F6FB"));
                Box.setBorder(BorderFactory.createTitledBorder(BorderFactory.createEtchedBorder(), "Settings",
                                TitledBorder.TRAILING, TitledBorder.BOTTOM));
                container.add(Box, BorderLayout.CENTER);

                JPanel centre = new JPanel();
                centre.setPreferredSize(new Dimension(100, 100));
                // centre.setBackground(Color.gray);
                centre.setBorder(BorderFactory.createEmptyBorder(5, 5, 5, 5));
                Box.add(centre);

                ImageIcon icon_1 = new ImageIcon(new ImageIcon("src/img/404.png").getImage().getScaledInstance(540, 459,
                                Image.SCALE_DEFAULT));

                JLabel label = new JLabel();
                label.setIcon(icon_1);
                centre.add(label);

        }

}
