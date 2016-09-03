package gui;

import info.Info;
import controller.TabPanel;
import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.HeadlessException;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.InputStream;
import javax.swing.JFrame;
import parser.XMLMenuLoader;

/**
 *
 * @author Игорь
 */
public class MainFrame extends JFrame {

    private Dimension dim;

    public MainFrame() {
        initComponents();
    }

    private void initComponents() throws HeadlessException {
        TabPanel panel = new TabPanel();
        add(panel, BorderLayout.CENTER);
        initMenu();
        loadFrame();
    }

    private void loadFrame() throws HeadlessException {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        dim = Toolkit.getDefaultToolkit().getScreenSize();
        setSize(521, 319);
        setLocation(dim.width / 2 - getWidth() / 2,
                dim.height / 2 - getHeight() / 2);
        setVisible(true);
    }

    private void initMenu() {
        try {
            String str = "/resources/menu.xml";
            InputStream stream = getClass().getResourceAsStream(str);
            XMLMenuLoader loader = new XMLMenuLoader(stream);
            loader.parse();
            setJMenuBar(loader.getMenuBar("mainMenu"));
            loader.addActionListener("exit", new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    System.exit(0);
                }
            });
            loader.addActionListener("normative", new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    new Info().createAndShowGUI();
                }
            });
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

}
