package FileScroll;

import java.awt.Graphics;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.util.ArrayList;
import javax.swing.Timer;

public class FileScroll {
    
    Timer t1 = new Timer(10000, new TimerListener());
    
    public void drawFiles(Graphics g, int x, int y, ArrayList<File> files){
        for(int i = 0; i < files.size(); i++){
            Image a = Toolkit.getDefaultToolkit().getImage(files.get(i).getPath());
            
        }
    }
    
    private class TimerListener implements ActionListener{
        @Override
        public void actionPerformed(ActionEvent e) {
            //Count down until clock reaches zero
//            if (Integer.valueOf(MainFrame.startLabel.getText()) > 1){
//                MainFrame.startLabel.setText(String.valueOf(Integer.valueOf(MainFrame.startLabel.getText())-1));
//            }else{
//                //Stop start timer and start framerate timer
//                MainFrame.startLabel.setText(" ");
//                tStart.stop();
//                t1.start();
//            }
            
            
        }
        
    }
}