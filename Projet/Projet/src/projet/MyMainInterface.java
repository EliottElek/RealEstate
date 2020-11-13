package projet;

import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Vector;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class MyMainInterface extends JFrame implements ActionListener {

    MyLogIn login = new MyLogIn();
    NewAccount newaccount = new NewAccount();
    Vector<Seller> listOfSellers = new Vector();
    Vector<Buyer> listOfBuyers = new Vector();
    Vector<Employee> listOfEmployees = new Vector();

    MyMainInterface() {
        this.setSize(900, 600);
        this.setTitle("Estate Manager");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setVisible(true);
        this.setResizable(true);
        System.out.println("etat" + login.createNewAccount());
        //adding actionlisteners to all buttons from MyLogIn panel
        login.newaccount.addActionListener(this);
        login.enter.addActionListener(this);
        login.choice1.addActionListener(this);
        login.choice2.addActionListener(this);
        login.choice3.addActionListener(this);
        login.userpassword.addActionListener(this);
        login.usermail.addActionListener(this);
        //adding actionlisteners to all buttons from NewAccount panel
        newaccount.createaccount.addActionListener(this);
        newaccount.newfirstname.addActionListener(this);
        newaccount.newlastname.addActionListener(this);
        newaccount.newmail.addActionListener(this);
        newaccount.newpassword.addActionListener(this);
        newaccount.newadress.addActionListener(this);
        newaccount.birthday.addActionListener(this);
        newaccount.birthmonth.addActionListener(this);
        newaccount.birthyear.addActionListener(this);
        newaccount.choice1.addActionListener(this);
        newaccount.choice2.addActionListener(this);
        newaccount.choice3.addActionListener(this);
        newaccount.back.addActionListener(this);

        this.add(login);
    }

    @Override
    public void actionPerformed(ActionEvent ae) {
        login.login(ae, listOfSellers, listOfBuyers, listOfEmployees);
        newaccount.createAccount(ae, listOfSellers, listOfBuyers, listOfEmployees);
        if (ae.getSource() == login.newaccount) {
            setContentPane(newaccount);
            invalidate();
            validate();
        } else if (ae.getSource() == newaccount.back) {
            setContentPane(login);
            invalidate();
            validate();
        }
    }

}
