package projet;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Vector;
import javax.swing.JFrame;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

public class MyInterface extends JFrame implements ActionListener,ChangeListener {

    MyLogIn login = new MyLogIn();
    NewAccount newaccount = new NewAccount();
    BuyerInterface buyerinterface = new BuyerInterface();
    Vector<Seller> listOfSellers = new Vector();
    Vector<Buyer> listOfBuyers = new Vector();
    Vector<Employee> listOfEmployees = new Vector();

    MyInterface() {
        this.setSize(900, 600);
        this.setTitle("Estate Manager");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setVisible(true);
        this.setResizable(true);
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
        buyerinterface.search.addActionListener(this);
        //addibg actionlisteners to all button from BuyerInterface panel
        buyerinterface.price.addChangeListener(this);
        this.add(buyerinterface);
    }

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
        } else if ((ae.getSource() == login.enter)&&(login.logedin)) {
            setContentPane(buyerinterface);
            invalidate();
            validate();
        }
        else if (ae.getSource() == buyerinterface.search) {
            setContentPane(login);
            invalidate();
            validate();
        }

    }

    @Override
    public void stateChanged(ChangeEvent ce) {
        buyerinterface.BuyerResearch(ce);
    }

  

}
