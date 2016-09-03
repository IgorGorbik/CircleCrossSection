package views.tabpanels;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.util.Arrays;
import java.util.Vector;
import javax.swing.BorderFactory;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JSpinner;
import javax.swing.JTextField;
import javax.swing.SpinnerNumberModel;
import javax.swing.SwingConstants;
import observer.Observable1;
import observer.Observer1;

/**
 *
 * @author Игорь
 */
public class Panel1 extends JPanel implements Observable1 {

    private double Rs = 350;
    private double Rb = 15.5;
    private double Eb = 32500;

    private JLabel l1;
    private JLabel l2;
    private JLabel l3;
    private JLabel l4;
    private JLabel l5;
    private JLabel l6;
    private JLabel l7;

    private JSpinner spinner1;

    private JTextField t1;
    private JTextField t2;
    private JTextField t3;

    private JComboBox box1;
    private JComboBox box2;
    private JComboBox box3;

    public JButton but1;

    private JPanel pan;

    private JPanel pan1;
    private JPanel pan1_1;
    private JPanel pan1_1_1;
    private JPanel pan1_1_1_1;
    private JPanel pan1_1_1_2;
    private JPanel pan1_1_2;
    private JPanel pan1_1_2_1;
    private JPanel pan1_1_2_2;
    private JPanel pan1_2;//содержит данные расчетной длины элемента
    private JPanel pan2;

    private final String[] i1 = {"10", "12", "14", "16", "18", "20", "22", "25",
        "28", "32", "36", "40"};
    private final String[] i2 = {"6", "8", "10", "12", "14", "16", "18", "20",
        "22", "25", "28", "32", "36", "40"};
    private final String[] i3 = {"B20", "B25", "B30"};
    private final String[] i4 = {"AII", "AIII"};

    private boolean changed = false;
    private Vector<Observer1> obs = new Vector<>();

    public Panel1() {
        super();
        initComponents();
        initMainComponent();
    }

    private void initMainComponent() {
        setBorder(BorderFactory.createEmptyBorder(20, 15, 10, 15));
        setLayout(new BorderLayout(0, 15));
        add(pan1, BorderLayout.CENTER);
        add(pan2, BorderLayout.SOUTH);
    }

    private void initComponents() {
        initLabels();
        initSpinner();
        initTextFields();
        initComboBoxes();
        initButton();
        iniPanels();
    }

    public void initComboBoxes() {
        initFirstBox();
        initSecondBox();
        initThirdBox();
    }

    //именование по вложенности
    public void iniPanels() {
        initPan1111();
        initPan1112();
        initPan111();
        initPan1121();
        initPan1122();
        initPan112();
        initPan11();
        initPan12();
        initPan1();
        initPan2();
    }

    public void initPan2() {
        pan2 = new JPanel();
        pan2.setOpaque(false);
        pan2.add(but1);
    }

    public void initPan1() {
        pan1 = new JPanel();
        pan1.setOpaque(false);
        pan1.setLayout(new BorderLayout(0, 20));
        pan1.add(pan1_1, BorderLayout.CENTER);
        pan1.add(pan1_2, BorderLayout.SOUTH);
    }

    public void initPan12() {
        pan1_2 = new JPanel();
        pan1_2.setOpaque(false);
        pan1_2.setOpaque(false);
        pan1_2.add(l7);
        pan1_2.add(t3);
    }

    public void initPan11() {
        pan1_1 = new JPanel();
        pan1_1.setOpaque(false);
        pan1_1.setLayout(new GridLayout(1, 2, 30, 0));
        pan1_1.add(pan1_1_1);
        pan1_1.add(pan1_1_2);
    }

    public void initPan112() {
        pan1_1_2 = new JPanel();
        pan1_1_2.setOpaque(false);
        pan1_1_2.setLayout(new BorderLayout());
        pan1_1_2.add(pan1_1_2_1, BorderLayout.CENTER);
        pan1_1_2.add(pan1_1_2_2, BorderLayout.EAST);
    }

    public void initPan1122() {
        pan1_1_2_2 = new JPanel();
        pan1_1_2_2.setOpaque(false);
        pan1_1_2_2.setLayout(new GridLayout(3, 1, 0, 7));
        pan1_1_2_2.add(box2);
        pan1_1_2_2.add(box3);
        pan1_1_2_2.add(t2);
    }

    public void initPan1121() {
        pan1_1_2_1 = new JPanel();
        pan1_1_2_1.setOpaque(false);
        pan1_1_2_1.setLayout(new GridLayout(3, 1, 0, 7));
        pan1_1_2_1.add(l4);
        pan1_1_2_1.add(l5);
        pan1_1_2_1.add(l6);
    }

    public void initPan111() {
        pan1_1_1 = new JPanel();
        pan1_1_1.setOpaque(false);
        pan1_1_1.setLayout(new BorderLayout());
        pan1_1_1.add(pan1_1_1_1, BorderLayout.CENTER);
        pan1_1_1.add(pan1_1_1_2, BorderLayout.EAST);
    }

    public void initPan1112() {
        pan1_1_1_2 = new JPanel();
        pan1_1_1_2.setOpaque(false);
        pan1_1_1_2.setLayout(new GridLayout(3, 1, 0, 7));
        pan1_1_1_2.add(t1);
        pan1_1_1_2.add(spinner1);
        pan1_1_1_2.add(box1);
    }

    public void initPan1111() {
        pan1_1_1_1 = new JPanel();
        pan1_1_1_1.setOpaque(false);
        pan1_1_1_1.setLayout(new GridLayout(3, 1, 0, 7));
        pan1_1_1_1.add(l1);
        pan1_1_1_1.add(l2);
        pan1_1_1_1.add(l3);
    }

    public void initButton() {
        but1 = new JButton("Далее >>");
        but1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                setChanged();
                notifyObservers(getData());
            }
        });
    }

    public void initThirdBox() {
        box3 = new JComboBox(i4);
        box3.setSelectedIndex(1);
        box3.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                switch (box3.getSelectedIndex()) {
                    case 0:
                        box1.setModel(new DefaultComboBoxModel(i1));
                        box1.setSelectedIndex(5);
                        Rs = 280;
                        break;
                    case 1:
                        box1.setModel(new DefaultComboBoxModel(i2));
                        box1.setSelectedIndex(9);
                        Rs = 350;
                        break;
                }
            }
        });
    }

    public void initSecondBox() {
        box2 = new JComboBox(i3);
        box2.setSelectedIndex(2);
        box2.addItemListener(new ItemListener() {
            @Override
            public void itemStateChanged(ItemEvent e) {
                if (e.getStateChange() == ItemEvent.SELECTED) {
                    switch (box2.getSelectedIndex()) {
                        case 0:
                            Rb = 10.5;
                            Eb = 27000;
                            break;
                        case 1:
                            Rb = 13.0;
                            Eb = 30000;
                            break;
                        case 2:
                            Rb = 15.5;
                            Eb = 32500;
                            break;
                    }
                }
            }
        });
    }

    public void initFirstBox() {
        box1 = new JComboBox(i2);
        box1.setSelectedIndex(9);
    }

    private void initTextFields() {
        t1 = new JTextField(5);
        t1.setText("120");
        t2 = new JTextField(5);
        t2.setText("40");
        t3 = new JTextField(7);
        t3.setText("10.337");
        t3.setHorizontalAlignment(JTextField.CENTER);
    }

    private void initSpinner() {
        SpinnerNumberModel snm = new SpinnerNumberModel(20, 6, null, 1);
        spinner1 = new JSpinner(snm);
        JTextField jt = ((JSpinner.NumberEditor) spinner1.getEditor())
                .getTextField();
        jt.setHorizontalAlignment(SwingConstants.LEADING);
    }

    private void initLabels() {
        l1 = new JLabel("Диаметр сечения, см");
        l2 = new JLabel("Количество стержней");
        l3 = new JLabel("Диаметр арматуры, мм");
        l4 = new JLabel("Класс бетона");
        l5 = new JLabel("Класс арматуры");
        l6 = new JLabel("Защитный слой, мм");
        l7 = new JLabel("Расчетная длина элемента, м");
    }

    private String[] getData() {
        String[] str = new String[10];
        str[0] = t1.getText();
        str[1] = spinner1.getValue().toString();
        str[2] = box1.getSelectedItem().toString();
        str[3] = Rb + "";
        str[4] = Rs + "";
        str[5] = t2.getText();
        str[6] = t3.getText();
        str[7] = Eb + "";
        str[8] = box2.getSelectedItem().toString();
        str[9] = box3.getSelectedItem().toString();
        return str;
    }

    @Override
    public void addObserver(Observer1 o) {
        if (o == null) {
            System.out.println("123");
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
