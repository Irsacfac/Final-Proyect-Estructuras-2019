package juego;

import java.io.Serializable;

public class User implements Serializable {

    private char[] email;
    private char[] password;
    private int pointsEarned;

    public User() {
        email = new char[20];
        password = new char[100];
        pointsEarned = 0;
    }

    public char[] getEmail() {
        return email;
    }

    public char[] getPassword() {
        return password;
    }

    public void setPassword(char[] password){
        this.password = password;
    }

    public void setEmail(char[] email){
        this.email = email;
    }

    public int getPointsEarned() {
        return pointsEarned;
    }

    public void winPoint(){
        pointsEarned++;
    }
}
