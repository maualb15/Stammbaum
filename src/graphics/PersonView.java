package graphics;

import family.person.Person;

import javax.swing.*;
import java.awt.*;

public class PersonView extends JPanel {
    JLabel lbFirstname = new JLabel();
    JLabel lbLastname = new JLabel();
    JLabel lbFirstnamename = new JLabel("Vorname: ");
    JLabel lbLastnamename = new JLabel( "Nachname: ");
    JLabel lbBirthdate = new JLabel();
    JLabel lbDeathdate = new JLabel();
    JLabel lbBirthdatename = new JLabel("Geburtsdatum: ");
    JLabel lbDeathdatename = new JLabel("Todesdatum: ");

    public PersonView()
    {
        this.setLayout(new GridLayout(4,2,5,5));
        this.add(lbFirstnamename);
        this.add(lbFirstname);
        this.add(lbLastnamename);
        this.add(lbLastname);
        this.add(lbBirthdatename);
        this.add(lbBirthdate);
        this.add(lbDeathdatename);
        this.add(lbDeathdate);
    }

    public void setPerson(Person person)
    {
        lbFirstname.setText(person.getFirstName());
        lbLastname.setText(person.getLastName());
        lbBirthdate.setText(person.getBirthDate().toString());
        if(person.getDeathDate()!=null)
        {
            lbDeathdate.setText(person.getDeathDate().toString());
        }
    }
}
