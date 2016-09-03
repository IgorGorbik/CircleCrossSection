package controller;

import info.CircleCross;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import javax.swing.JTabbedPane;
import observer.Observable1;
import observer.Observer1;
import views.tabpanels.Panel1;
import views.tabpanels.Panel2;
import views.tabpanels.Panel3;
import views.tabpanels.Panel4;

/**
 *
 * @author Игорь
 */
public class TabPanel extends JTabbedPane implements Observer1 {

    private Panel1 pan1;
    private Panel2 pan2;
    private Panel3 pan3;
    private Panel4 pan4;

    private ArrayList<Observable1> observableList = new ArrayList<>();

    private CircleCross circleCross;

    public TabPanel() {
        super();
        initComponents();
        initCircleCross();
    }

    private void initCircleCross() {
        circleCross = new CircleCross();
    }

    public void addObservable(Observable1 o) {
        o.addObserver(this);
        observableList.add(o);
    }

    private void initComponents() {
        initPanels();
        initMainComponent();
    }

    private void initMainComponent() {
        insertTab("Геометрические характеристики", null, pan1, null, 0);
        insertTab("Нагрузки", null, pan2, null, 1);
        insertTab("Расчет", null, pan3, null, 2);
        insertTab("Результаты расчета", null, pan4, null, 3);
        setEnabledAt(1, false);
        setEnabledAt(2, false);
        setEnabledAt(3, false);
//        setEnabledAt(2, false);
    }

    private void initPanels() {
        pan1 = new Panel1();
        addObservable(pan1);
        pan2 = new Panel2();
        addObservable(pan2);
        pan3 = new Panel3();
        addObservable(pan3);
        pan4 = new Panel4();
        //addObservable(pan4);
    }

    @Override
    public void update(Observable1 o, Object arg) {
        if (o instanceof Panel1) {
            if (arg instanceof String[]) {
                String str = circleCross.validateDataPan1((String[]) arg);
                if ("".equals(str)) {
                    setEnabledAt(0, false);
                    setEnabledAt(1, true);
                    setSelectedIndex(1);
                } else {
                    JOptionPane.showMessageDialog(this, "<html>" + str);
                }
            }
        } else if (o instanceof Panel2) {
            if (arg instanceof String[]) {
                String str = circleCross.validateDataPan2((String[]) arg);
                if ("".equals(str)) {
                    setEnabledAt(1, false);
                    setEnabledAt(2, true);
                    setSelectedIndex(2);
                } else {
                    JOptionPane.showMessageDialog(this, "<html>" + str);
                }
            } else if (arg instanceof String) {
                setEnabledAt(1, false);
                setEnabledAt(0, true);
                setSelectedIndex(0);
            }
        } else if (o instanceof Panel3) {
            if (arg.equals("start")) {
                boolean b = circleCross.result();
                if (b) {
                    pan3.prog
                            .setText("<html><center color=green>"
                                    + "Прочность сечения обеспечена");
                } else {
                    pan3.prog
                            .setText("<html><center color=red>"
                                    + "Прочность сечения не обеспечена");
                }
                setEnabledAt(3, true);
                pan4.f(circleCross.ghtml.getStr());
            } else if (arg.equals("back")) {
                setEnabledAt(1, true);
                setEnabledAt(2, false);
                setEnabledAt(3, false);
                setSelectedIndex(1);
            }
        }
    }

}
