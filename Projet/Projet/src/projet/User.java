package projet;

import java.lang.Object;
import java.util.Calendar;
import java.util.GregorianCalendar;

public abstract class User {

    protected String firstname;
    protected String lastname;
    protected GregorianCalendar birthdate;
    protected String adress;
    protected String mail;
    protected String password;

    public User(String firstname, String lastname, GregorianCalendar birthdate, String adress, String mail) {
        this.firstname = firstname;
        this.lastname = lastname;
        this.birthdate = birthdate;
        this.adress = adress;
        this.mail = mail;

    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setFirstName(String firstname) {
        this.firstname = firstname;
    }
    public String getFirstName()
    {
        return this.firstname;
    }

    public void setLastName(String lastname) {
        this.lastname = lastname;
    }

    public void setEmail(String mail) {
        this.mail = mail;
    }

    public String getEmail()
    {
        return this.mail;
    }
    public String getPassword()
    {
        return this.password;
    }

   public void setAdress(String adress) {
        this.adress = adress;
    }

    public void setBirthDate(GregorianCalendar birthdate) {
        this.birthdate = birthdate;
    }
public abstract void showInfos();
}
