package GUI;

import java.lang.Object;
import java.util.Calendar;
import java.sql.Date;
import javax.swing.JPanel;

public abstract class User {

    protected String firstname;
    protected String lastname;
    protected Date birthdate;
    protected String adress;
    protected String mail;
    protected String password;
    protected int id;
    JPanel PANELINFOS;
    MyProfileModify PANELMODIFY;

    public User(int id, String firstname, String lastname, Date birthdate, String adress, String mail) {
        this.id = id;
        this.firstname = firstname;
        this.lastname = lastname;
        this.birthdate = birthdate;
        this.adress = adress;
        this.mail = mail;
        PANELINFOS = new JPanel();
        PANELMODIFY = new MyProfileModify(this);
        showInfosMyProfile();

    }

    public int getID()
    {
        return this.id;
    }
    public void setPassword(String password) {
        this.password = password;
    }

    public void setFirstName(String firstname) {
        this.firstname = firstname;
    }

    public String getFirstName() {
        return this.firstname;
    }

    public String getLastName() {
        return this.lastname;
    }

    public String getAdress() {
        return this.adress;
    }

    public void setLastName(String lastname) {
        this.lastname = lastname;
    }

    public void setEmail(String mail) {
        this.mail = mail;
    }

    public String getEmail() {
        return this.mail;
    }

    public String getPassword() {
        return this.password;
    }

    public void setAdress(String adress) {
        this.adress = adress;
    }

    public void setBirthDate(Date birthdate) {
        this.birthdate = birthdate;
    }
    public Date getDate()
    {
        return this.birthdate;
    }

    public int getD() {
        return this.birthdate.getDate();
    }

    public int getM() {
        return this.birthdate.getMonth();
    }

    public int getY() {
        return this.birthdate.getYear();
    }

    public abstract void showInfos();

    public abstract JPanel showInfosMyProfile();
 }
