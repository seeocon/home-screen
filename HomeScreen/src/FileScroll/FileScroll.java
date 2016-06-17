package FileScroll;

import java.awt.Font;
import java.awt.Graphics;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;
import javax.swing.JPanel;
import javax.swing.Timer;

import com.xuggle.xuggler.*;
import java.awt.Desktop;

public class FileScroll {

    public static final int delay = 1000;
    
    Timer t = new Timer(delay, new TimerListener());
    ArrayList<File> files;
    //Graphics g;
    JPanel j;
    int x;
    int y;
    int currentItem = 0;

    public FileScroll(ArrayList<File> files, JPanel j, int x, int y) {
        this.files = files;
        this.j = j;
        this.x = x;
        this.y = y;
        t.start();
    }

    public void draw(Graphics g) {
        g.drawRect(0, 0, 0, 0);
        if (files.get(currentItem).getPath().contains(".png")) {
            g.drawImage(Toolkit.getDefaultToolkit().getImage(files.get(currentItem).getPath()), x, y, j);
        }else if(files.get(currentItem).getPath().contains(".txt")){
            try{
                Scanner s = new Scanner(files.get(currentItem));
                g.setFont(new Font("Times New Roman", Font.BOLD, 45));
                g.drawString(s.nextLine(), x, y);
                //Desktop.getDesktop().open(new File("video.mp4"));
            }catch(IOException e){
                System.out.println("Error, a text file was not found");
            }
        }
        
        
        
    }

    private class TimerListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            if(currentItem < files.size() - 1){
                currentItem++;
            }else{
                currentItem = 0;
            }
            j.repaint();
        }
    }
}
