/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package login;

/**
 *
 * @author Paul
 */
public class User {

    private String lName;
    private String fName;
    private String pw;
    private String uName;

    /**
     * Creates a new user object based on their last name, first name, password
     * and username.
     * @param lName User's last name, as a String.
     * @param fName User's first name, as a String.
     * @param pw User's password, as a String.
     * @param uName User's username, as a String.
     */
    public User(String lName, String fName, String pw, String uName) {
        this.lName = lName;
        this.fName = fName;
        this.pw = pw;
        this.uName = uName;
    }

    /**
     * Retrieves a user's last name.
     * @return The user's last name, as a String.
     */
    public String getlName() {
        return lName;
    }

    /**
     * Sets a user's last name.
     * @param lName The user's last name, as a String.
     */
    public void setlName(String lName) {
        this.lName = lName;
    }

    /**
     * Retrieves a user's first name.
     * @return The user's first name, as a String.
     */
    public String getfName() {
        return fName;
    }

    /**
     * Sets a user's first name.
     * @param fName The user's first name, as a String.
     */
    public void setfName(String fName) {
        this.fName = fName;
    }

    /**
     * Retrieves a user's password.
     * @return The user's password, as a String.
     */
    public String getPw() {
        return pw;
    }

    /**
     * Sets a user's password.
     * @param pw The user's password, as a String.
     */
    public void setPw(String pw) {
        this.pw = pw;
    }

    /**
     * Retrieves a user's username.
     * @return The user's username, as a String.
     */
    public String getuName() {
        return uName;
    }

    /**
     * Sets a user's username.
     * @param uName The user's username, as a String.
     */
    public void setuName(String uName) {
        this.uName = uName;
    }

}
