/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package MainLogin;

/**
 *
 * @author 068684570
 */
public class User {
    private String lName;
    private String fName;
    private String pw;
    private String uName;

    public User(String lName, String fName, String pw, String uName) {
        this.lName = lName;
        this.fName = fName;
        this.pw = pw;
        this.uName = uName;
    }

    public String getlName() {
        return lName;
    }

    public void setlName(String lName) {
        this.lName = lName;
    }

    public String getfName() {
        return fName;
    }

    public void setfName(String fName) {
        this.fName = fName;
    }

    public String getPw() {
        return pw;
    }

    public void setPw(String pw) {
        this.pw = pw;
    }

    public String getuName() {
        return uName;
    }

    public void setuName(String uName) {
        this.uName = uName;
    }
    
}
