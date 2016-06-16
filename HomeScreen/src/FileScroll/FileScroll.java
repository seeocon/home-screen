package FileScroll;

import java.awt.Graphics;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.util.ArrayList;
import javax.swing.JPanel;
import javax.swing.Timer;

public class FileScroll {

    Timer t = new Timer(1000, new TimerListener());
    ArrayList<File> files;
    Graphics g;
    JPanel j;
    int x;
    int y;
    int currentItem = 0;

    public FileScroll(ArrayList<File> files, Graphics g, JPanel j, int x, int y) {
        this.files = files;
        this.g = g;
        this.j = j;
        this.x = x;
        this.y = y;
        t.start();
    }

    public void draw() {
        if (files.get(currentItem).getPath().contains(".png")) {
            g.drawImage(Toolkit.getDefaultToolkit().getImage(files.get(currentItem).getPath()), x, y, j);
        }
    }

    private class TimerListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            currentItem++;
            j.repaint();
        }
    }
}
