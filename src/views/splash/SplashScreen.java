package views.splash;

import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.HeadlessException;
import java.awt.Image;
import java.awt.Rectangle;
import java.awt.Robot;
import java.awt.Toolkit;
import javax.swing.ImageIcon;
import javax.swing.JComponent;
import javax.swing.JWindow;

/**
 *
 * @author Игорь
 */
public class SplashScreen extends JWindow {

    // необходимые нам изображения, размеры и параметры
    private Image capture;
    private Image splash;
    private Dimension dim;

    public SplashScreen() {
        super();
        initComponents();
    }

    private void initComponents() {
        centered();
        getScreenCopy();
        addSplash();
        showSplash();
        someWork();
        disposeSplashScreen();
    }

    private void disposeSplashScreen() {
        this.dispose();
    }

    private void someWork() {
        // заканчиваем работу по истечении некоторого времени
        try {
            Thread.currentThread().sleep(3000);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void showSplash() {
        // выводим окно на экран
        setVisible(true);
    }

    private void addSplash() {
        // добавляем компонент-заставку
        add(new Splash());
    }

    private void getScreenCopy() {
        // снимаем экранную копию
        try {
            Robot robot = new Robot();
            capture = robot
                    .createScreenCapture(new Rectangle(400, 200, 911, 505));
            ImageIcon imageIcon = new ImageIcon(getClass()
                    .getResource("/resources/1.gif"));
            splash = imageIcon.getImage();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    private void centered() throws HeadlessException {
        // размер и положение окна на экране
        dim = Toolkit.getDefaultToolkit().getScreenSize();
        setSize(511, 305);
        setLocation(dim.width / 2 - this.getWidth() / 2,
                dim.height / 2 - this.getHeight() / 2);
    }

    // компонент рисует заставку
    class Splash extends JComponent {

        @Override
        public void paintComponent(Graphics g) {
            g.drawImage(capture, 0, 0, this);
            g.drawImage(splash, 0, 0, this);
        }
    }

}
