package info;

import java.awt.Dimension;
import java.awt.GridLayout;
import java.io.IOException;
import java.net.URL;
import javax.swing.JEditorPane;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JSplitPane;
import javax.swing.JTree;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
import javax.swing.event.TreeSelectionEvent;
import javax.swing.event.TreeSelectionListener;
import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.tree.TreeSelectionModel;

/**
 *
 * @author Игорь
 */
public class Info extends JPanel implements TreeSelectionListener {

    private JEditorPane htmlPane;
    private JTree tree;
    private URL helpURL;

    private JFrame frame;

    private static boolean playWithLineStyle = false;
    private static String lineStyle = "Horizontal";

    private static boolean useSystemLookAndFeel = false;

    public Info() {
        super(new GridLayout(1, 0));
        initComponents();
    }

    private void initComponents() {
        DefaultMutableTreeNode top
                = new DefaultMutableTreeNode("Нормативная документация");
        createNodes(top);

        initTree(top);

        if (playWithLineStyle) {
            System.out.println("line style = " + lineStyle);
            tree.putClientProperty("JTree.lineStyle", lineStyle);
        }

        JScrollPane treeView = new JScrollPane(tree);

        initHTML();

        JScrollPane htmlView = new JScrollPane(htmlPane);

        JSplitPane splitPane = initSplit(treeView, htmlView);

        initDimension(htmlView, treeView, splitPane);

        add(splitPane);
    }

    private JSplitPane initSplit(JScrollPane treeView, JScrollPane htmlView) {
        JSplitPane splitPane = new JSplitPane(JSplitPane.HORIZONTAL_SPLIT);
        splitPane.setTopComponent(treeView);
        splitPane.setBottomComponent(htmlView);
        return splitPane;
    }

    private void initDimension(JScrollPane htmlView, JScrollPane treeView,
            JSplitPane splitPane) {
        Dimension minimumSize = new Dimension(100, 50);
        htmlView.setMinimumSize(minimumSize);
        treeView.setMinimumSize(minimumSize);
        splitPane.setDividerLocation(260);
        splitPane.setPreferredSize(new Dimension(500, 300));
    }

    private void initHTML() {
        htmlPane = new JEditorPane();
        htmlPane.setContentType("text/html; charset=utf-8");
        htmlPane.setEditable(false);
    }

    private void initTree(DefaultMutableTreeNode top) {
        tree = new JTree(top);
        tree.putClientProperty("JTree.lineStyle", "None");
        tree.getSelectionModel()
                .setSelectionMode(TreeSelectionModel.SINGLE_TREE_SELECTION);
        tree.addTreeSelectionListener(this);
    }

    @Override
    public void valueChanged(TreeSelectionEvent e) {
        DefaultMutableTreeNode node
                = (DefaultMutableTreeNode) tree.getLastSelectedPathComponent();
        if (node == null) {
            return;
        }
        Object nodeInfo = node.getUserObject();
        if (node.isLeaf()) {
            BookInfo book = (BookInfo) nodeInfo;
            displayURL(book.path);
        } else {
        }
    }

    private class BookInfo {

        public String bookName;
        URL path;

        public BookInfo(String book, String filename) {
            bookName = book;
            path = getClass().getResource(filename);
            if (path == null) {
                System.err.println("Couldn't find file: " + filename);
            }
        }

        @Override
        public String toString() {
            return bookName;
        }

    }

    private void displayURL(URL url) {
        try {
            if (url != null) {
                htmlPane.setPage(url);
            } else {
                htmlPane.setText("File Not Found");
            }
        } catch (IOException e) {
            System.err.println("Attempted to read a bad URL: " + url);
        }
    }

    private void createNodes(DefaultMutableTreeNode top) {
        DefaultMutableTreeNode category = null;
        DefaultMutableTreeNode book = null;

        category = new DefaultMutableTreeNode("Пункты норм");
        top.add(category);

        book = new DefaultMutableTreeNode(new BookInfo("ДБН В2.3-14:2006 "
                + "Приложение Z", "/resources/2.html"));
        category.add(book);

        book = new DefaultMutableTreeNode(new BookInfo("п.3.16",
                "/resources/4.html"));
        category.add(book);

        book = new DefaultMutableTreeNode(new BookInfo("п.3.52",
                "/resources/3.html"));
        category.add(book);

        book = new DefaultMutableTreeNode(new BookInfo("п.3.53",
                "/resources/5.html"));
        category.add(book);

        book = new DefaultMutableTreeNode(new BookInfo("п.3.54",
                "/resources/6.html"));
        category.add(book);

        book = new DefaultMutableTreeNode(new BookInfo("п.3.55",
                "/resources/7.html"));
        category.add(book);

    }

    public void createAndShowGUI() {
        if (useSystemLookAndFeel) {
            try {
                UIManager.setLookAndFeel(
                        UIManager.getSystemLookAndFeelClassName());
            } catch (ClassNotFoundException | InstantiationException |
                    IllegalAccessException | UnsupportedLookAndFeelException e) {
                System.err.println("Couldn't use system look and feel.");
            }
        }

        frame = new JFrame("TreeDemo");
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frame.add(new Info());
        frame.setSize(1110, 540);
        frame.setVisible(true);
    }

}
