/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package MainScreen;

import static MainScreen.Weather.getWeather;
import FileScroll.FileScroll;
import login.Interface.*;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.Timer;
import login.Interface;
import twitter4j.Status;
import twitter4j.Twitter;
import twitter4j.TwitterException;
import twitter4j.TwitterFactory;
import twitter4j.conf.ConfigurationBuilder;
import weather.CantFindWeatherException;
import java.util.Calendar;

/**
 *
 * @author Paul
 * ALL UI CREATION WAS DONE BY PAUL
 */
public class Display extends javax.swing.JFrame {

    Timer t;
    ConfigurationBuilder cb = new ConfigurationBuilder();
    Twitter twitter;
    List<Status> statuses;
    int day;
    Calendar c;
    Interface i = new Interface();
    int refreshRate = 100000; // Rate at which the twitter and weather feed refreshes (in milliseconds)

    /**
     * Creates new form Display
     */
    public Display() {
        initComponents();
        //TWITTER INIT
        cb.setOAuthConsumerKey("3I1RTnsA7JhWgnbomQuYrEhmP");
        cb.setOAuthConsumerSecret("tNvpM739osUCRtTjDT47Yifbc4OB5mvxXWsKLld4lGRvn1X4SU");
        cb.setOAuthAccessToken("743138963767107584-3MZxk0Et5tmBhDXHWAppmHlyiPO5OW4");
        cb.setOAuthAccessTokenSecret("QaQPydUPRdH8SicXDVoIU13dSq5NKOxcloJlX1ZYYkrCO");
        twitter = new TwitterFactory(cb.build()).getInstance();
        try {
            statuses = twitter.getHomeTimeline();
            displayTweets();
        } catch (TwitterException ex) {
            Logger.getLogger(Display.class.getName()).log(Level.SEVERE, null, ex);
        }
        t = new Timer(refreshRate, new TimerListener());
        t.start();
        //WEATHER INIT
        c = Calendar.getInstance();                                 // Creates a calander object
        day = c.get(Calendar.DAY_OF_WEEK);
        displayWeather();
    }

    /**
     * REFRESHES THE TWITTER AND WEATHER FEED
     */
    private class TimerListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            try {
                displayTweets();
                displayWeather();
            } catch (TwitterException ex) {
                Logger.getLogger(Display.class.getName()).log(Level.SEVERE, null, ex);
            }
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

        background2 = new MainScreen.Background();
        jButton1 = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        tvNews1 = new javax.swing.JLabel();
        tvNews2 = new javax.swing.JLabel();
        tvNews3 = new javax.swing.JLabel();
        tvNews4 = new javax.swing.JLabel();
        tvNews5 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        tempDisplay = new javax.swing.JLabel();
        tempDisplay1 = new javax.swing.JLabel();
        tempDisplay2 = new javax.swing.JLabel();
        logo1 = new MainScreen.Logo();
        jButton2 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBackground(new java.awt.Color(0, 0, 0));
        setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        setExtendedState(MAXIMIZED_BOTH);
        setForeground(java.awt.Color.black);
        setUndecorated(true);

        background2.setBackground(new java.awt.Color(0, 0, 0));
        background2.setMinimumSize(new java.awt.Dimension(1920, 1080));
        background2.setPreferredSize(new java.awt.Dimension(1920, 1080));

        jButton1.setFont(new java.awt.Font("Sakkal Majalla", 0, 14)); // NOI18N
        jButton1.setForeground(new java.awt.Color(255, 255, 255));
        jButton1.setText("EDIT");
        jButton1.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(255, 255, 255), 1, true));
        jButton1.setContentAreaFilled(false);
        jButton1.setFocusPainted(false);
        jButton1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jButton1MouseClicked(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 36)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(240, 240, 240));
        jLabel1.setText("Twitter Feed");

        tvNews1.setFont(new java.awt.Font("HelveticaNeueLT Pro 55 Roman", 0, 24)); // NOI18N
        tvNews1.setForeground(new java.awt.Color(240, 240, 240));
        tvNews1.setToolTipText("");

        tvNews2.setFont(new java.awt.Font("HelveticaNeueLT Pro 55 Roman", 0, 24)); // NOI18N
        tvNews2.setForeground(new java.awt.Color(240, 240, 240));
        tvNews2.setToolTipText("");

        tvNews3.setFont(new java.awt.Font("HelveticaNeueLT Pro 55 Roman", 0, 24)); // NOI18N
        tvNews3.setForeground(new java.awt.Color(240, 240, 240));
        tvNews3.setToolTipText("");

        tvNews4.setFont(new java.awt.Font("HelveticaNeueLT Pro 55 Roman", 0, 24)); // NOI18N
        tvNews4.setForeground(new java.awt.Color(240, 240, 240));
        tvNews4.setToolTipText("");

        tvNews5.setFont(new java.awt.Font("HelveticaNeueLT Pro 55 Roman", 0, 24)); // NOI18N
        tvNews5.setForeground(new java.awt.Color(240, 240, 240));
        tvNews5.setToolTipText("");

        jLabel2.setFont(new java.awt.Font("Tahoma", 0, 36)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(240, 240, 240));
        jLabel2.setText("weather");

        tempDisplay.setFont(new java.awt.Font("Tahoma", 1, 70)); // NOI18N
        tempDisplay.setForeground(new java.awt.Color(240, 240, 240));
        tempDisplay.setText("temp");

        tempDisplay1.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        tempDisplay1.setForeground(new java.awt.Color(240, 240, 240));
        tempDisplay1.setText("temp");

        tempDisplay2.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        tempDisplay2.setForeground(new java.awt.Color(240, 240, 240));
        tempDisplay2.setText("temp");

        javax.swing.GroupLayout logo1Layout = new javax.swing.GroupLayout(logo1);
        logo1.setLayout(logo1Layout);
        logo1Layout.setHorizontalGroup(
            logo1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 211, Short.MAX_VALUE)
        );
        logo1Layout.setVerticalGroup(
            logo1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 252, Short.MAX_VALUE)
        );

        jButton2.setFont(new java.awt.Font("Sakkal Majalla", 0, 14)); // NOI18N
        jButton2.setForeground(new java.awt.Color(255, 255, 255));
        jButton2.setText("CLOSE");
        jButton2.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(255, 255, 255), 1, true));
        jButton2.setContentAreaFilled(false);
        jButton2.setFocusPainted(false);
        jButton2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jButton2MouseClicked(evt);
            }
        });

        javax.swing.GroupLayout background2Layout = new javax.swing.GroupLayout(background2);
        background2.setLayout(background2Layout);
        background2Layout.setHorizontalGroup(
            background2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(background2Layout.createSequentialGroup()
                .addGroup(background2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(background2Layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(background2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addGroup(background2Layout.createSequentialGroup()
                                .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGroup(background2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(background2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                        .addComponent(tvNews5, javax.swing.GroupLayout.PREFERRED_SIZE, 464, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(tvNews4, javax.swing.GroupLayout.PREFERRED_SIZE, 464, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addComponent(tvNews1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 464, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(tvNews2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 464, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(tvNews3, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 464, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(background2Layout.createSequentialGroup()
                                .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(494, 494, 494))))
                    .addGroup(background2Layout.createSequentialGroup()
                        .addGap(190, 190, 190)
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 247, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 224, Short.MAX_VALUE)
                        .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 137, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGroup(background2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(background2Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 527, Short.MAX_VALUE)
                        .addGroup(background2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(tempDisplay2, javax.swing.GroupLayout.PREFERRED_SIZE, 271, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(tempDisplay, javax.swing.GroupLayout.PREFERRED_SIZE, 271, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(tempDisplay1, javax.swing.GroupLayout.PREFERRED_SIZE, 271, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(324, 324, 324))
                    .addGroup(background2Layout.createSequentialGroup()
                        .addGap(66, 66, 66)
                        .addComponent(logo1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
        );
        background2Layout.setVerticalGroup(
            background2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(background2Layout.createSequentialGroup()
                .addGroup(background2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(background2Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jButton1)
                        .addGap(21, 21, 21)
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 162, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(tvNews1, javax.swing.GroupLayout.PREFERRED_SIZE, 156, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(tvNews2, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(tvNews3, javax.swing.GroupLayout.PREFERRED_SIZE, 151, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(background2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(background2Layout.createSequentialGroup()
                                .addComponent(tvNews4, javax.swing.GroupLayout.PREFERRED_SIZE, 151, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(tvNews5, javax.swing.GroupLayout.PREFERRED_SIZE, 158, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(logo1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(background2Layout.createSequentialGroup()
                        .addGroup(background2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(background2Layout.createSequentialGroup()
                                .addGap(38, 38, 38)
                                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 162, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(background2Layout.createSequentialGroup()
                                .addGap(167, 167, 167)
                                .addComponent(tempDisplay, javax.swing.GroupLayout.PREFERRED_SIZE, 63, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(165, 165, 165)
                        .addComponent(tempDisplay2, javax.swing.GroupLayout.PREFERRED_SIZE, 63, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(tempDisplay1, javax.swing.GroupLayout.PREFERRED_SIZE, 63, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 8, Short.MAX_VALUE)
                .addComponent(jButton2)
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(background2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(background2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton1MouseClicked
        i.setVisible(true);
    }//GEN-LAST:event_jButton1MouseClicked

    private void jButton2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton2MouseClicked
        System.exit(1);
    }//GEN-LAST:event_jButton2MouseClicked

    /**
     * Displays the 5 most recent tweets from the established twitter account
     * link onto their respective jLabels (in chronological order).
     *
     * @throws TwitterException
     */
    public void displayTweets() throws TwitterException {
        System.out.println("Showing home timeline.");

        // shows the first newest
        tvNews1.setText("<html>@" + statuses.get(0).getUser().getScreenName() + ": <br>"
                + statuses.get(0).getText() + "</html>");
        if (statuses.size() > 1) {
            tvNews2.setText("<html>@" + statuses.get(1).getUser().getScreenName() + ": <br>"
                    + statuses.get(1).getText() + "</html>");
        }
        if (statuses.size() > 2) {
            tvNews3.setText("<html>@" + statuses.get(2).getUser().getScreenName() + ": <br>"
                    + statuses.get(2).getText() + "</html>");
        }
        if (statuses.size() > 3) {
            tvNews4.setText("<html>@" + statuses.get(3).getUser().getScreenName() + ": <br>"
                    + statuses.get(3).getText() + "</html>");
        }
        if (statuses.size() > 4) {
            tvNews5.setText("<html>@" + statuses.get(4).getUser().getScreenName() + ": <br>"
                    + statuses.get(4).getText() + "</html>");
        }
    }

    /**
     * Displays the current temperature, weather conditions and high/low
     * temperatures of the current day (displayed through jLabels).
     */
    public void displayWeather() {
        // Sets jLabel text according to current weather conditions
        if (Background.sunny) {
            jLabel2.setText("Sunny");
        } else if (Background.cloudy) {
            jLabel2.setText("Cloudy");
        } else {
            jLabel2.setText("Raining");
        }
        
        // Sets the jLabel text according to current temps
        try {
            tempDisplay.setText(Integer.toString(Weather.getWeather("Toronto").getItem().getCondition().getTemp()) + "°C");
        } catch (CantFindWeatherException ex) {
            Logger.getLogger(Display.class.getName()).log(Level.SEVERE, null, ex);
        }
        try {
            tempDisplay1.setText("Today's High: " + Integer.toString(getWeather("Toronto").getItem().getForecasts().get(day).getHigh()) + "°C");
        } catch (CantFindWeatherException ex) {
            Logger.getLogger(Display.class.getName()).log(Level.SEVERE, null, ex);
        }
        try {
            tempDisplay2.setText("Today's Low: " + Integer.toString(getWeather("Toronto").getItem().getForecasts().get(day).getLow()) + "°C");
        } catch (CantFindWeatherException ex) {
            Logger.getLogger(Display.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Display.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Display.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Display.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Display.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Display().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private MainScreen.Background background2;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private MainScreen.Logo logo1;
    private javax.swing.JLabel tempDisplay;
    private javax.swing.JLabel tempDisplay1;
    private javax.swing.JLabel tempDisplay2;
    private javax.swing.JLabel tvNews1;
    private javax.swing.JLabel tvNews2;
    private javax.swing.JLabel tvNews3;
    private javax.swing.JLabel tvNews4;
    private javax.swing.JLabel tvNews5;
    // End of variables declaration//GEN-END:variables
}
