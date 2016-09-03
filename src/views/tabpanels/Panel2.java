package views.tabpanels;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Vector;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import observer.Observable1;
import observer.Observer1;

/**
 *
 * @author Игорь
 */
public class Panel2 extends JPanel implements Observable1 {

    private JLabel l1;
    private JLabel l2;
    private JLabel l3;
    private JLabel l4;
    private JLabel l5;
    private JLabel l6;
    private JLabel l7;
    private JLabel l8;

    private JTextField t1;
    private JTextField t2;
    private JTextField t3;
    private JTextField t4;
    private JTextField t5;
    private JTextField t6;

    public JButton but1;
    public JButton but2;

    private JPanel pan1;
    private JPanel pan1_1;
    private JPanel pan1_1_1;
    private JPanel pan1_1_2;
    private JPanel pan1_2;
    private JPanel pan1_2_1;
    private JPanel pan1_2_2;
    private JPanel pan2;//содержит кнопку

    private boolean changed = false;
    private Vector<Observer1> obs = new Vector<>();

    public Panel2() {
        super();
        initComponents();
        initMainComponennt();
    }

    private void initMainComponennt() {
        setBorder(BorderFactory.createEmptyBorder(15, 10, 10, 10));
        setLayout(new BorderLayout(0, 5));
        add(pan1, BorderLayout.CENTER);
        add(pan2, BorderLayout.SOUTH);
    }

    private void initComponents() {
        initLabels();
        initTextFields();
        initButtons();
        initPanels();
    }

    //именование по вложенности
    private void initPanels() {
        initPan111();
        initPan112();
        initPan11();
        initPan121();
        initPan122();
        initPan12();
        initPan1();
        initPan2();
    }

    private void initPan2() {
        pan2 = new JPanel();
        pan2.add(but1);
        pan2.add(but2);
    }

    private void initPan1() {
        pan1 = new JPanel();
        pan1.setLayout(new GridLayout(1, 2, 10, 0));
        pan1.setBorder(BorderFactory.createEmptyBorder(5, 5, 30, 5));
        pan1.add(pan1_1);
        pan1.add(pan1_2);
    }

    private void initPan12() {
        pan1_2 = new JPanel();
        pan1_2.setLayout(new BorderLayout(0, 10));
        pan1_2.setBorder(BorderFactory.createEtchedBorder());
        pan1_2.add(pan1_2_1, BorderLayout.CENTER);
        pan1_2.add(pan1_2_2, BorderLayout.EAST);
        pan1_2.add(l8, BorderLayout.NORTH);
    }

    private void initPan122() {
        pan1_2_2 = new JPanel();
        pan1_2_2.setLayout(new GridLayout(4, 1, 0, 7));
        pan1_2_2.add(t5);
        pan1_2_2.add(new JLabel());
        pan1_2_2.add(t6);
        pan1_2_2.add(new JLabel());
    }

    private void initPan121() {
        pan1_2_1 = new JPanel();
        pan1_2_1.setLayout(new GridLayout(4, 1, 0, 7));
        pan1_2_1.add(l5);
        pan1_2_1.add(new JLabel());
        pan1_2_1.add(l6);
        pan1_2_1.add(new JLabel());
    }

    private void initPan11() {
        pan1_1 = new JPanel();
        pan1_1.setLayout(new BorderLayout(0, 10));
        pan1_1.setBorder(BorderFactory.createEtchedBorder());
        pan1_1.add(pan1_1_1, BorderLayout.CENTER);
        pan1_1.add(pan1_1_2, BorderLayout.EAST);
        pan1_1.add(l7, BorderLayout.NORTH);
    }

    private void initPan112() {
        pan1_1_2 = new JPanel();
        pan1_1_2.setLayout(new GridLayout(4, 1, 0, 7));
        pan1_1_2.add(t1);
        pan1_1_2.add(t2);
        pan1_1_2.add(t3);
        pan1_1_2.add(t4);
    }

    private void initPan111() {
        pan1_1_1 = new JPanel();
        pan1_1_1.setLayout(new GridLayout(4, 1, 0, 7));
        pan1_1_1.add(l1);
        pan1_1_1.add(l2);
        pan1_1_1.add(l3);
        pan1_1_1.add(l4);
    }

    private void initButtons() {
        but1 = new JButton("<< Назад");
        but1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                setChanged();
                notifyObservers("");
            }
        });
        but2 = new JButton("Далее >>");
        but2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                setChanged();
                notifyObservers(getData());
            }
        });
    }

    private void initTextFields() {
        t1 = new JTextField(5);
        t1.setText("4000");
        t2 = new JTextField(5);
        t2.setText("2800");
        t3 = new JTextField(5);
        t3.setText("400");
        t4 = new JTextField(5);
        t4.setText("280");
        t5 = new JTextField(5);
        t5.setEnabled(false);
        t6 = new JTextField(5);
        t6.setEnabled(false);
    }

    private void initLabels() {
        l1 = new JLabel("Продольная сила N, кН");
        l2 = new JLabel("Длительная часть Nдл, кН");
        l3 = new JLabel("Изгибающий момент М, кНм");
        l4 = new JLabel("Длительная часть Мдл, кНм");
        l5 = new JLabel("Продольная сила Nn, кН");
        l6 = new JLabel("Изгибающий момент Мn, кНм");
        l7 = new JLabel("I предельное состояние");
        l7.setHorizontalAlignment(SwingConstants.CENTER);
        l8 = new JLabel("II предельное состояние");
        l8.setHorizontalAlignment(SwingConstants.CENTER);
    }

    private String[] getData() {
        String[] str = new String[4];
        str[0] = t1.getText();
        str[1] = t2.getText();
        str[2] = t3.getText();
        str[3] = t4.getText();
        return str;
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
