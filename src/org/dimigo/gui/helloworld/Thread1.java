package org.dimigo.gui.helloworld;

import javax.swing.*;

public class Thread1 extends Thread {

    public void run() {
        try {
            JFrame frame = new JFrame("최상위 윈도우");
            JOptionPane pane = new JOptionPane("뭘 하고 계신건지 다시 한 번 생각해보십쇼");
            pane.setMessageType(JOptionPane.WARNING_MESSAGE);
            JDialog dialog = pane.createDialog(frame, "왜 하고 있는건데");

            while (true) {
                dialog.setAlwaysOnTop(true);
                dialog.setVisible(true);
                Thread.sleep(3000);
            }

        } catch (InterruptedException e) {
            System.out.println(e);
        }

    }
}