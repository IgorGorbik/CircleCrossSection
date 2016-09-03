package views.tabpanels;

import java.awt.BorderLayout;
import javax.swing.JEditorPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;

/**
 *
 * @author Игорь
 */
public class Panel4 extends JPanel {

    private JEditorPane editorPane;

    public Panel4() {
        setLayout(new BorderLayout());
        editorPane = new JEditorPane();
        editorPane.setContentType("text/html");
        editorPane.setEditable(false);
        add(new JScrollPane(editorPane));
    }

    public void f(String str) {
        editorPane.setText(str);
    }

}
