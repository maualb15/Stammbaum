/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package graphics;

import family.person.Person;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.util.ArrayList;
import java.util.Date;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JSpinner;
import javax.swing.JTextField;
import javax.swing.SpinnerDateModel;

/**
 *
 * @author Tobias01
 */
public class Edit extends JFrame
{
    private String firstName;
    private String lastName;
    private Date birthDate;
    private Date deathDate;
    private Person p;
    public Edit(Person p)
    {
        firstName = p.getFirstName();
        lastName = p.getLastName();
        birthDate = p.getBirthDate();
        deathDate = p.getDeathDate();
        this.setTitle("Eintrag bearbeiten");
        this.setPreferredSize(new Dimension(400, 300));
        this.pack();
        this.setLocationRelativeTo(null);
        this.setVisible(true);
        this.firstName = firstName;
        this.lastName = lastName;
        this.birthDate = birthDate;
        this.deathDate = deathDate;
        this.p = p;
        initComponent();
    }
    private JTextField tfFirstName;
    private JTextField tfLastName;
    private JSpinner dateOfBirth;
    private JSpinner dateOfDeath;
    private JButton btEdit = new JButton("Bearbeiten");
    private JButton btClose = new JButton("Abbrechen");
    private void initComponent() 
    {
        if(deathDate == null)
        {
            Container con = new Container();
            con.setLayout(new GridLayout(4, 2, 1, 1));

            tfFirstName = new JTextField(firstName);
            JLabel lbFirstName = new JLabel("Vorname: ");
            
            tfLastName = new JTextField(lastName);
            JLabel lbLastName = new JLabel("Nachname: ");
            
            dateOfBirth = new JSpinner(new SpinnerDateModel());
            JSpinner.DateEditor d = new JSpinner.DateEditor(dateOfBirth, "dd.MM.yyyy");
            dateOfBirth.setEditor(d);
            dateOfBirth.setValue(birthDate);
            
            con.add(lbFirstName);
            con.add(tfFirstName);
            con.add(lbLastName);
            con.add(tfLastName);
            con.add(new JLabel("Geburtstag: "));
            con.add(dateOfBirth);
            
            con.add(btEdit);
            con.add(btClose);
            
            this.add(con);
            this.pack();
        }
        else
        {
            Container con = new Container();
            con.setLayout(new GridLayout(5, 2, 1, 1));

            tfFirstName = new JTextField(firstName);
            JLabel lbFirstName = new JLabel("Vorname: ");
            
            tfLastName = new JTextField(lastName);
            JLabel lbLastName = new JLabel("Nachname: ");
            
            dateOfBirth = new JSpinner(new SpinnerDateModel());
            JSpinner.DateEditor d = new JSpinner.DateEditor(dateOfBirth, "dd.MM.yyyy");
            dateOfBirth.setEditor(d);
            dateOfBirth.setValue(birthDate);
            dateOfDeath = new JSpinner(new SpinnerDateModel());
            JSpinner.DateEditor d1 = new JSpinner.DateEditor(dateOfDeath, "dd.MM.yyyy");
            dateOfDeath.setEditor(d1);
            dateOfDeath.setValue(deathDate);
            
            con.add(lbFirstName);
            con.add(tfFirstName);
            con.add(lbLastName);
            con.add(tfLastName);
            con.add(new JLabel("Geburtstag: "));
            con.add(dateOfBirth);
            con.add(new JLabel("Todestag: "));
            con.add(dateOfDeath);
            con.add(btEdit);
            con.add(btClose);
            
            this.add(con);
            this.pack();
        }
        
    }
}
