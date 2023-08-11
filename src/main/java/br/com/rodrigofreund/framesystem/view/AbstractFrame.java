package br.com.rodrigofreund.framesystem.view;

import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;

import javax.swing.JFrame;

abstract class AbstractFrame {

    private JFrame frame;
    private AbstractView actualView;

    AbstractFrame(String title) {
        frame = new JFrame();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setTitle(title);
        frame.setSize(300, 200);
        frame.setLocationByPlatform(true);

        frame.addWindowListener(new WindowListener() {

            @Override
            public void windowOpened(WindowEvent e) {
            }

            @Override
            public void windowIconified(WindowEvent e) {
            }

            @Override
            public void windowDeiconified(WindowEvent e) {
            }

            @Override
            public void windowDeactivated(WindowEvent e) {
            }

            @Override
            public void windowClosing(WindowEvent e) {
                EventManager.instance().notify(EventType.CLOSE_APP, EventParamFactory.of());
            }

            @Override
            public void windowClosed(WindowEvent e) {
            }

            @Override
            public void windowActivated(WindowEvent e) {
            }
        });
    }

    abstract void start();

    abstract void search();

    void changeView(AbstractView view) {
        if (actualView != null) {
            actualView.close();
        } else {
            frame.setVisible(true);
        }
        actualView = view;
        frame.getContentPane().add(actualView.getWindow());
    }

}
