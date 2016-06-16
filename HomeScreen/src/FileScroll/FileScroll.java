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
    Image a;

    public FileScroll(ArrayList<File> files) {
        this.files = files;
        t.start();
    }
    
    public void drawFile(Graphics g, JPanel j, int x, int y){
        g.drawImage(a, x, y, j);
    }
    
    public void changeFile(int i){
        a = Toolkit.getDefaultToolkit().getImage(files.get(i).getPath());
    }
    
    private class TimerListener implements ActionListener{
        int i = 0;
        
        @Override
        public void actionPerformed(ActionEvent e) {
            changeFile(i);
            i++;
        }
    }
}