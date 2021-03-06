/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package login;

import FileScroll.FileScroll;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.math.BigInteger;
import java.net.URL;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import static login.FileChooser.*;
import javax.swing.JFileChooser;
import javax.swing.filechooser.FileNameExtensionFilter;

/**
 *
 * @author 068684570 LOGIN INTERFACE DONE BY PAUL, FILE CHOOSER DONE BY MICHAEL,
 * IMPLEMENTED BY PAUL
 */
public class Interface extends javax.swing.JFrame {

    // Initialization of I/O text files
    File file1 = new File("data/Users.txt"); // File of registered users
    File file2 = new File("data/badpass.txt"); // File of unusable passwords
    File file3 = new File("data/files.txt"); // File of unusable passwords

    // Initiazlization of I/O variables
    Scanner s, scanner, scanner2 = null;
    PrintWriter pw = null;
    User primeUser;
    String[] lineRead = null;
    public static ArrayList<File> fileLocations = new ArrayList<>();
    FileChooser chooser = new FileChooser();

    /**
     * Creates new form Interface
     */
    public Interface() {
        initComponents();
        initScanner();
        fileLocations = buildFileList();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        UserName = new javax.swing.JLabel();
        PassWord = new javax.swing.JLabel();
        FirstName = new javax.swing.JLabel();
        LastName = new javax.swing.JLabel();
        UNInput = new javax.swing.JTextField();
        PWInput = new javax.swing.JTextField();
        FNInput = new javax.swing.JTextField();
        LNInput = new javax.swing.JTextField();
        jButton1 = new javax.swing.JButton();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        PWInput1 = new javax.swing.JTextField();
        PassWord1 = new javax.swing.JLabel();
        UserName1 = new javax.swing.JLabel();
        UNInput1 = new javax.swing.JTextField();
        jButton2 = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);

        UserName.setText("UserName");

        PassWord.setText("Password");

        FirstName.setText("First Name");

        LastName.setText("Last Name");

        UNInput.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                UNInputActionPerformed(evt);
            }
        });

        PWInput.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                PWInputActionPerformed(evt);
            }
        });

        FNInput.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                FNInputActionPerformed(evt);
            }
        });

        jButton1.setText("Register");
        jButton1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jButton1MouseClicked(evt);
            }
        });
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        PWInput1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                PWInput1ActionPerformed(evt);
            }
        });

        PassWord1.setText("Password");

        UserName1.setText("UserName");

        UNInput1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                UNInput1ActionPerformed(evt);
            }
        });

        jButton2.setText("Login");
        jButton2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jButton2MouseClicked(evt);
            }
        });
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jLabel1.setText("New User:");

        jLabel2.setText("Existing User:");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(PassWord)
                            .addComponent(FirstName)
                            .addComponent(LastName)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(1, 1, 1)
                                .addComponent(UserName)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(UNInput)
                            .addComponent(LNInput)
                            .addComponent(FNInput)
                            .addComponent(PWInput, javax.swing.GroupLayout.DEFAULT_SIZE, 79, Short.MAX_VALUE))
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(PassWord1)
                                    .addComponent(UserName1))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(PWInput1, javax.swing.GroupLayout.DEFAULT_SIZE, 86, Short.MAX_VALUE)
                                    .addComponent(UNInput1)))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(41, 41, 41)
                                .addComponent(jButton2)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(36, 36, 36)
                        .addComponent(jButton1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel7)
                    .addComponent(jLabel6)
                    .addComponent(jLabel8)
                    .addComponent(jLabel5))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(layout.createSequentialGroup()
                .addGap(51, 51, 51)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 92, Short.MAX_VALUE)
                .addComponent(jLabel2)
                .addGap(54, 54, 54))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(jLabel2))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel5)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel6)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel7)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel8)
                        .addGap(49, 49, 49))
                    .addGroup(layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(UserName1)
                                .addComponent(UNInput1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(UserName)
                                .addComponent(UNInput, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(PWInput1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(PassWord)
                                .addComponent(PWInput, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(PassWord1)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jButton2)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(FirstName)
                                .addComponent(FNInput, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(LastName)
                            .addComponent(LNInput, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButton1)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
        );

        jLabel5.getAccessibleContext().setAccessibleName("UserNameApprove");
        jLabel6.getAccessibleContext().setAccessibleName("PassWordApprove");
        jLabel7.getAccessibleContext().setAccessibleName("FNApproved");
        jLabel8.getAccessibleContext().setAccessibleName("LNApproved");

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton1ActionPerformed

    private void UNInputActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_UNInputActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_UNInputActionPerformed

    private void FNInputActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_FNInputActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_FNInputActionPerformed

    private void PWInputActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_PWInputActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_PWInputActionPerformed

    private void jButton1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton1MouseClicked
        // Creates a new user, granted their info is valid
        String un = UNInput.getText();
        String fn = FNInput.getText();
        String ln = LNInput.getText();
        String pw = PWInput.getText();
        primeUser = new User(ln, fn, pw, un);
        try {
            writeToFile(primeUser);
        } catch (IOException ex) {
            Logger.getLogger(Interface.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_jButton1MouseClicked

    private void PWInput1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_PWInput1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_PWInput1ActionPerformed

    private void UNInput1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_UNInput1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_UNInput1ActionPerformed

    private void jButton2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton2MouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton2MouseClicked

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        // Logs in a user, granted their info is valid
        String user = UNInput1.getText();
        String pass = PWInput1.getText();
        if (findUser(pass, user)) {
            chooser.setVisible(true);
            try {
                pw = new PrintWriter(new FileWriter(file3, true));
            } catch (IOException ex) {
                Logger.getLogger(Interface.class.getName()).log(Level.SEVERE, null, ex);
            }
            pw.println(checkFileChooser(jFileChooser1).replace("\\", "/"));
            pw.close();
            fileLocations = buildFileList();
            FileScroll.files = login.Interface.fileLocations;
        } else {
            displayPopup("Login unrecognized.");
        }
    }//GEN-LAST:event_jButton2ActionPerformed

    /**
     * Checks the text file which stores the absolute paths of all images used
     * and creates/returns a ArrayList<File> of all such paths.
     *
     * @return The ArrayList<File> containing all absolute image paths.
     */
    public ArrayList<File> buildFileList() {
        ArrayList<File> fileList = new ArrayList<>();
        try {
            scanner = new Scanner(file3);
        } catch (FileNotFoundException ex) {
            Logger.getLogger(Interface.class.getName()).log(Level.SEVERE, null, ex);
        }
        while (scanner.hasNextLine()) {
            String lineFromFile = scanner.nextLine();
            fileList.add(new File(lineFromFile));
        }
        return fileList;
    }

    /**
     * Checks the file chooser's selection and returns an absolute path to the
     * file as a String. Code done by Michael.
     *
     * @param j The JFileChooser to be used.
     * @return The absolute path to the file.
     */
    public String checkFileChooser(JFileChooser j) {
        if (j.showOpenDialog(this.rootPane) == j.APPROVE_OPTION) {
            File selectedFile = jFileChooser1.getSelectedFile();
            chooser.setVisible(false);
            this.setVisible(false);
            return selectedFile.getParent() + "/" + selectedFile.getName();
        } else if (j.showOpenDialog(this.rootPane) == j.CANCEL_OPTION) {
            chooser.setVisible(false);
            this.setVisible(false);
        }
        return "DOESN'T EXIST";
    }

    /**
     * Displays a popup text message.
     *
     * @param message
     */
    private void displayPopup(String message) {
        JFrame d = new JFrame();
        JOptionPane.showMessageDialog(d, message);
    }

    /**
     * Initializes the file scanner. This is meant to be used once per program
     * execution.
     */
    private void initScanner() {
        try {
            s = new Scanner(file1);
        } catch (FileNotFoundException ex) {
            Logger.getLogger(Interface.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    /**
     * Writes a user's details to a string format, using commas (,) as a
     * delimiter, granted their information is valid.
     *
     * @param u The User object from which info is referenced
     */
    private void writeToFile(User u) throws IOException {
        pw = new PrintWriter(new FileWriter(file1, true));
        // Converts user info to a string, using commas as delimeters
        String userInfo = u.getuName() + "," + u.getlName() + "," + u.getfName() + "," + getMD5(u.getPw());
        // Validates user info
        switch (validateUserInfo(userInfo, u.getPw())) {
            case 0:
                // Successful registration
                displayPopup("You have registered successfully!");
                pw.println(userInfo);
                break;
            case 1:
                // User exists in file ; failed registration
                displayPopup("User already exists!");
                break;
            default:
                // invaild password ; failed registration
                displayPopup("Password is not valid; Too easy to guess.");
                break;
        }
        pw.close(); // Closes the printwriter
    }

    /**
     * Checks to see if a user already exists, and also checks if their password
     * is secure.
     *
     * @param info A String containing all the users info (last name, first
     * name, password and username).
     * @param pass A String representing the user's password.
     * @return
     */
    private int validateUserInfo(String info, String pass) {
        try {
            scanner = new Scanner(file1);
            scanner2 = new Scanner(file2);
        } catch (FileNotFoundException ex) {
            Logger.getLogger(Interface.class.getName()).log(Level.SEVERE, null, ex);
        }
        while (scanner.hasNextLine()) {
            String lineFromFile = scanner.nextLine();
            if (lineFromFile.equals(info)) {
                // The user's info already existed in the saved text file
                scanner.close();
                return 1;
            }
        }
        while (scanner2.hasNextLine()) {
            String lineFromFile = scanner2.nextLine();
            if (lineFromFile.equals(pass)) {
                // The password entered by the user was found in the file of insecure passwords
                scanner.close();
                scanner2.close();
                return 3;
            }
        }
        return 0;   // The user's info is valid
    }

    /**
     * Checks to see if a user's login info (encrypted password, username)
     * matches with existing saved info.
     *
     * @param pw The password used by the user to login.
     * @param un The username used by the user to login.
     * @return
     */
    private boolean findUser(String pw, String un) {
        try {
            s = new Scanner(file1);
        } catch (FileNotFoundException ex) {
            Logger.getLogger(Interface.class.getName()).log(Level.SEVERE, null, ex);
        }
        while (s.hasNextLine()) {
            lineRead = s.nextLine().split(",", 4);  // Splits a line into a String array using commas as delimeters
            System.out.println(lineRead[0] + getMD5(lineRead[3]));
            if (lineRead[0].equals(un) && lineRead[3].equals(getMD5(pw))) {
                // Login was successful; username and encypted password matched with that contained in the file
                return true;
            }
        }
        // Login failed; username and encypted password did not match with that contained in the file
        return false;
    }

    /**
     * Encodes a string utilizing the MD5 algorithm
     *
     * @param input The string to be encoded
     * @return The encoded string
     */
    public static String getMD5(String input) {
        try {
            MessageDigest md = MessageDigest.getInstance("MD5");
            byte[] messageDigest = md.digest(input.getBytes());
            BigInteger number = new BigInteger(1, messageDigest);
            String hashtext = number.toString(16);
            while (hashtext.length() < 32) {
                hashtext = "0" + hashtext;
            }
            return hashtext;
        } catch (NoSuchAlgorithmException e) {
            throw new RuntimeException(e);
        }
    }

    //***********IMPORTANT: USE THIS CODE TO START LOGIN INTERFACE*************\\

    /*
    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                Interface meme = new Interface();
            }
        });
    }*/

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField FNInput;
    private javax.swing.JLabel FirstName;
    private javax.swing.JTextField LNInput;
    private javax.swing.JLabel LastName;
    private javax.swing.JTextField PWInput;
    private javax.swing.JTextField PWInput1;
    private javax.swing.JLabel PassWord;
    private javax.swing.JLabel PassWord1;
    private javax.swing.JTextField UNInput;
    private javax.swing.JTextField UNInput1;
    private javax.swing.JLabel UserName;
    private javax.swing.JLabel UserName1;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    // End of variables declaration//GEN-END:variables
}
