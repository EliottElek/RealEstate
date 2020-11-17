package projet;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.util.Vector;
import javax.swing.JFrame;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

public class MyInterface extends JFrame implements ActionListener, ChangeListener {

    MyLogIn login;
    NewAccount newaccount;
    BuyerInterface buyerinterface;
    SellerInterface sellerinterface;
    Estate[] propertysample;
    Vector<Seller> listOfSellers = new Vector();
    Vector<Buyer> listOfBuyers = new Vector();
    Vector<Employee> listOfEmployees = new Vector();

    MyInterface(int factor, int w, int h) throws IOException {
        this.setResizable(true);
        login = new MyLogIn(factor);
        newaccount = new NewAccount(factor);
        propertysample = new Estate[5];
        String[] image = new String[5];
        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 5; j++) {
                image[j] = "image" + (j + 1) + ".png";
            }
            propertysample[i] = new ResidentialEstate("city " + (i + 1), "adress " + (i + 1), (i + 1) * 300000, (i + 1) * 50, "descritpion " + (i + 1), image, factor);
        }
        sellerinterface = new SellerInterface(factor);
        buyerinterface = new BuyerInterface(propertysample, factor);
        this.setSize(w, h);
        this.setTitle("Estate Manager");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setVisible(true);
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
        sellerinterface.add.addActionListener(this);
        //adding actionlisteners to all button from BuyerInterface panel
        buyerinterface.price.addChangeListener(this);
        buyerinterface.minarea.addChangeListener(this);
        buyerinterface.maxarea.addChangeListener(this);
        buyerinterface.gardenareachosen.addChangeListener(this);
        buyerinterface.gardenchoice.addActionListener(this);
        buyerinterface.back.addActionListener(this);
        //addibg actionlisteners to all button from SellerInterface panel
        sellerinterface.add.addActionListener(this);
        sellerinterface.locate.addActionListener(this);
        sellerinterface.proximitychosen.addActionListener(this);
        sellerinterface.nbroomschosen.addActionListener(this);
        sellerinterface.nbbthroomschosen.addActionListener(this);
        this.add(login);
    }

    public void setPropertiesArray(Estate properties[]) {
        this.propertysample = properties;
    }

    @Override
    public void actionPerformed(ActionEvent ae) {

        sellerinterface.SellerAddProperty(ae);
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
        } else if ((ae.getSource() == login.enter)) {//&&(login.logedin)) {
            if (login.buyeruser) {
                setContentPane(buyerinterface);
            } else if (login.selleruser) {
                setContentPane(sellerinterface);
            }
            invalidate();
            validate();
        } else if (ae.getSource() == buyerinterface.search) {
            buyerinterface.showResults();
            invalidate();
            validate();
        }
        else if (ae.getSource() == buyerinterface.back) {
            buyerinterface.hideResults();
            buyerinterface.backToSearchMenu();
            invalidate();
            validate();
        }
    }

    @Override
    public void stateChanged(ChangeEvent ce) {
        buyerinterface.BuyerResearch(ce);
    }

}
