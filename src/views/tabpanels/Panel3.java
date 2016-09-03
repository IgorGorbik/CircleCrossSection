package views.tabpanels;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Vector;
import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JProgressBar;
import javax.swing.JRadioButton;
import javax.swing.JTextField;
import observer.Observable1;
import observer.Observer1;

/**
 *
 * @author Игорь
 */
public class Panel3 extends JPanel implements Observable1 {

    private JButton but1_pan3;
    private JButton but2_pan3;
    private JButton but3_pan3;

    private JPanel pan1;
    private JPanel pan2;
    private JPanel pan2_1;
    private JPanel pan2_1_1;
    private JPanel pan2_1_2;
    private JPanel pan2_1_2_1;
    private JPanel pan2_1_2_2;

    public JLabel prog = new JLabel("");

    private JRadioButton rb1;
    private JRadioButton rb2;
    private ButtonGroup bg;

    private JTextField text1;
    private JTextField text2;

    private boolean changed = false;
    private Vector<Observer1> obs = new Vector<>();

    public Panel3() {
        super();
        initComponents();
        initMainComponent();
    }

    private void initMainComponent() {
        setBorder(BorderFactory.createEmptyBorder(20, 15, 10, 15));
        setLayout(new BorderLayout(0, 5));
        add(BorderLayout.SOUTH, pan1);
        add(BorderLayout.CENTER, pan2);
    }

    private void initComponents() {
        initButtons();
        //initProgressBar();
        initTextComponents();
        initRadioButtons();
        initPanels();

    }

    //именование по вложенности
    private void initPanels() {
        initPan1();
        initPan211();
        initPan2121();
        initPan2122();
        initPan212();
        initPan21();
        initPan2();
        prog.setHorizontalAlignment(JLabel.CENTER);
    }

    private void initPan2() {
        pan2 = new JPanel();
        pan2.setLayout(new BorderLayout());
        pan2.add(BorderLayout.CENTER, pan2_1);
        pan2.add(BorderLayout.SOUTH, prog);
    }

    private void initPan21() {
        pan2_1 = new JPanel();
        pan2_1.add(pan2_1_1);
        pan2_1.add(pan2_1_2);
    }

    private void initPan212() {
        pan2_1_2 = new JPanel();
        pan2_1_2.add(pan2_1_2_1);
        pan2_1_2.add(pan2_1_2_2);
    }

    private void initPan2122() {
        pan2_1_2_2 = new JPanel();
        pan2_1_2_2.setLayout(new BoxLayout(pan2_1_2_2, BoxLayout.Y_AXIS));
        pan2_1_2_2.add(text1);
        pan2_1_2_2.add(text2);
    }

    private void initTextComponents() {
        text1 = new JTextField(3);
        text2 = new JTextField(3);
    }

    private void initPan2121() {
        pan2_1_2_1 = new JPanel();
        pan2_1_2_1.setLayout(new BoxLayout(pan2_1_2_1, BoxLayout.Y_AXIS));
        pan2_1_2_1.add(new JLabel("Мин расстояние, мм "));
        pan2_1_2_1.add(new JLabel("Макс расстояние, мм "));
    }

    private void initPan211() {
        pan2_1_1 = new JPanel();
        pan2_1_1.setLayout(new BoxLayout(pan2_1_1, BoxLayout.Y_AXIS));
        pan2_1_1.add(rb1);
        pan2_1_1.add(rb2);
    }

    private void initRadioButtons() {
        rb1 = new JRadioButton("неопределимая", true);
        rb2 = new JRadioButton("определимая");
        bg = new ButtonGroup();
        bg.add(rb1);
        bg.add(rb2);
    }

    private void initPan1() {
        pan1 = new JPanel();
        pan1.add(but1_pan3);
        pan1.add(but2_pan3);
        pan1.add(but3_pan3);
    }

//    private void initProgressBar() {
//        prog = new JProgressBar();
//        prog.setBorderPainted(true);
//        prog.setOrientation(JProgressBar.HORIZONTAL);
//        prog.setValue(0);
//        prog.setStringPainted(true);
//    }
    private void initButtons() {
        but1_pan3 = new JButton("<< Назад");
        but1_pan3.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                setChanged();
                notifyObservers("back");
                but3_pan3.setEnabled(false);
            }
        });
        but2_pan3 = new JButton("Расчет");
        but2_pan3.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                setChanged();
                notifyObservers("start");
            }
        });
        but3_pan3 = new JButton("Далее >>");
        but3_pan3.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                setChanged();
                notifyObservers("forward");
                but3_pan3.setEnabled(true);
            }
        });
        but3_pan3.setEnabled(false);
    }

    @Override
    public void addObserver(Observer1 o) {
        if (o == null) {
            throw new NullPointerException();
        }
        if (!obs.contains(o)) {
            obs.addElement(o);
        }
    }

    @Override
    public void deleteObserver(Observer1 o) {
        obs.removeElement(o);
    }

    @Override
    public void notifyObservers() {
        notifyObservers(null);
    }

    @Override
    public void notifyObservers(Object arg) {
        Object[] arrLocal;
        synchronized (this) {
            if (!changed) {
                return;
            }
            arrLocal = obs.toArray();
            clearChanged();
        }
        for (int i = arrLocal.length - 1; i >= 0; i--) {
            ((Observer1) arrLocal[i]).update(this, arg);
        }
    }

    @Override
    public synchronized void deleteObservers() {
        obs.removeAllElements();
    }

    @Override
    public void setChanged() {
        changed = true;
    }

    @Override
    public void clearChanged() {
        changed = false;
    }

    @Override
    public boolean hasChanged() {
        return changed;
    }

    @Override
    public int countObservers() {
        return obs.size();
    }

}
