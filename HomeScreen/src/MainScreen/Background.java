/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package MainScreen;

import FileScroll.FileScroll;
import static MainScreen.Weather.getWeather;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.logging.Level;
import java.util.logging.Logger;
import weather.CantFindWeatherException;
import java.net.URL;
import javax.swing.Timer;

/**
 *
 * @author Paul
 */
public class Background extends javax.swing.JPanel {

    public FileScroll testScroller;
    URL resource1 = this.getClass().getResource("/Res/cloud.png");
    Image clouds = Toolkit.getDefaultToolkit().getImage(resource1);
    URL resource2 = this.getClass().getResource("/Res/rain.png");
    Image rain = Toolkit.getDefaultToolkit().getImage(resource2);
    URL resource3 = this.getClass().getResource("/Res/sun.png");
    Image sun = Toolkit.getDefaultToolkit().getImage(resource3);
    URL resource4 = this.getClass().getResource("/Res/twitter.png");
    Image twitter = Toolkit.getDefaultToolkit().getImage(resource4);
    public static boolean raining, cloudy, sunny;
    int refreshRate = 600000; // Rate at which the background refreshes based on the current weather (in milliseconds)

    /**
     * Creates new form Background
     */
    public Background() {
        initComponents();
        testScroller = new FileScroll(login.Interface.fileLocations, this, 0, 0);
        Timer t = new Timer(refreshRate, new TimerListener());
        t.start();
    }

    //Acquires the current weather conditions on set intervals
    private class TimerListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            try {
                raining = getWeather("Toronto").getItem().getCondition().getText().toLowerCase().contains("rain"); // check for rain
                cloudy = getWeather("Toronto").getItem().getCondition().getText().toLowerCase().contains("cloud"); // check for cloud
                sunny = getWeather("Toronto").getItem().getCondition().getText().toLowerCase().contains("sun"); // check for sun
            } catch (CantFindWeatherException ex) {
                Logger.getLogger(Background.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

    private final int SCALE_WEATHER_SIZE = 1280;
    
    public void paintComponent(Graphics x) {

        x.setColor(Color.BLACK);
        x.fillRect(0, 0, 1920, 1080);
        testScroller.draw(x); // Draws an image slideshow in the center of the screen
        
        x.drawImage(twitter, 0, 0, twitter.getWidth(this), this.getHeight(), this);
            x.drawImage(Display.twitPic[0],Display.tvNews1.getX() - (Display.twitPic[0].getWidth(this)+10),Display.tvNews1.getY() +(Display.twitPic[0].getHeight(this)/2) -2 ,this);
            x.drawImage(Display.twitPic[1],Display.tvNews2.getX() - (Display.twitPic[1].getWidth(this)+10),Display.tvNews2.getY() +(Display.twitPic[1].getHeight(this)/2) -2 ,this);
            x.drawImage(Display.twitPic[2],Display.tvNews3.getX() - (Display.twitPic[2].getWidth(this)+10),Display.tvNews3.getY() +(Display.twitPic[2].getHeight(this)/2) -2 ,this);
            x.drawImage(Display.twitPic[3],Display.tvNews4.getX() - (Display.twitPic[3].getWidth(this)+10),Display.tvNews4.getY() +(Display.twitPic[3].getHeight(this)/2) -2 ,this);
            x.drawImage(Display.twitPic[4],Display.tvNews5.getX() - (Display.twitPic[4].getWidth(this)+10),Display.tvNews5.getY() +(Display.twitPic[4].getHeight(this)/2) -2 ,this);
        
        
        //Sets background image according to current weather conditions
        if (raining) {
            x.drawImage(rain, this.getWidth()-rain.getWidth(this), 0, rain.getWidth(this), this.getHeight(), this);
        } else if (cloudy) {
            x.drawImage(clouds, this.getWidth()-rain.getWidth(this), 0, clouds.getWidth(this), this.getHeight(), this);
        } else {
            x.drawImage(sun, this.getWidth()-rain.getWidth(this), 0, sun.getWidth(this), this.getHeight(), this);
        }
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 400, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 300, Short.MAX_VALUE)
        );
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    // End of variables declaration//GEN-END:variables
}
