package FileScroll;

import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Graphics2D;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;
import javax.swing.JPanel;
import javax.swing.Timer;
import java.awt.Desktop;

/**
 *
 * @author Emanuel Vellios
 */
public class FileScroll {

    public static final int delay = 5000;

    Timer t = new Timer(delay, new TimerListener());
    public static ArrayList<File> files;
    JPanel j;
    int currentItem = 0;
    int x, y;

    /**
     * Creates an interface that displays and scrolls through files
     *
     * @param files An array list of files to be drawn
     * @param j The jPanel it will draw to
     */
    public FileScroll(ArrayList<File> files, JPanel j, int x, int y) {
        this.files = files;
        this.j = j;
        this.x = x;
        this.y = y;
        t.start();
    }

    /**
     * Draw method (place in paintComponent)
     * @param g Graphics parameter passed from paintComponent
     */
    public void draw(Graphics g) {
        //Checking each file type and displaying them
        if (files.size() > 0) {
            if (files.get(currentItem).getPath().contains(".png") || files.get(currentItem).getPath().contains(".jpg") || files.get(currentItem).getPath().contains(".jpeg")) {
                Image img = Toolkit.getDefaultToolkit().getImage(files.get(currentItem).getPath());
                //g.drawImage(img, x, y, j);
                Graphics2D g2d = (Graphics2D) g;
                g2d.drawImage(img,0,0,j.getWidth(),j.getHeight(), null);
            } else if (files.get(currentItem).getPath().contains(".txt")) {
                try {
                    Scanner s = new Scanner(files.get(currentItem));
                    g.setFont(new Font("Times New Roman", Font.BOLD, 45));
                    g.drawString(s.nextLine(), 1920 / 2, 1080 / 2);
                } catch (IOException e) {
                    System.out.println("Error, a text file was not found");
                }
            } else if (files.get(currentItem).getPath().contains(".mp4")) {
                try {
                    Desktop.getDesktop().open(new File(files.get(currentItem).getPath()));
                } catch (IOException e) {
                    System.out.println("Error, a video file was not found");
                }
            }
        }
    }

    //Timer listener to move to next file
    private class TimerListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
                        
            //Move to next file index if the final index has not been reached
            if (currentItem < files.size() - 1) {
                currentItem++;
            } else {
                currentItem = 0;
            }
            j.repaint();
        }
    }
}
