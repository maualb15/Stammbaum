/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package graphics;

import BL.StammBaumBL;
import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.Panel;
import java.awt.event.ActionEvent;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JSpinner;
import javax.swing.JTextField;
import javax.swing.SpinnerDateModel;
import family.person.Person;
import BL.TableModel;
import family.person.RelationType;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import javax.swing.JComboBox;
import javax.swing.JPanel;

public class AddingDLG extends JDialog
{  
    public AddingDLG(StammBaumBL sbl)
    {
        this.sbl = sbl;
        this.setTitle("Hinzufügen");
        this.setLocationRelativeTo(null);
        this.setPreferredSize(new Dimension(300,150));
        initComponents();
        this.pack();
        this.setVisible(true);
    }
    private StammBaumBL sbl;
    private void initComponents()
    {
        Container cont=this.getContentPane();
        cont.setLayout(new GridLayout(6, 2, 7,2));
        JPanel plFamily = new JPanel(); 
        cont.add(new JLabel("Verwandschaftstyp:"));
        String [] typ = {"Ehe", "Bruder", "Schwester", "Kind"};
        cbWaehle = new JComboBox(typ);
      
        cont.add(cbWaehle);
        cont.add(new JLabel("Vorname: "));
        cont.add(tfFirstname);
        cont.add(new JLabel("Nachname: "));
        cont.add(tfLastname);
        cont.add(new JLabel("Geburtstag: "));
        dateOfBirth = new JSpinner(new SpinnerDateModel());
        JSpinner.DateEditor d = new JSpinner.DateEditor(dateOfBirth, "dd.MM.yyyy");
        dateOfBirth.setEditor(d);
        cont.add(dateOfBirth);
        
        Panel panelDeath = new Panel();
        panelDeath.setLayout(new BorderLayout());
        panelDeath.add(new JLabel("Todestag (optional):"), BorderLayout.CENTER);
        cbDeath.setHorizontalAlignment(JCheckBox.RIGHT);
        panelDeath.add(cbDeath, BorderLayout.EAST);    
        cont.add(panelDeath);
        dateOfDeath = new JSpinner(new SpinnerDateModel());
        JSpinner.DateEditor d1 = new JSpinner.DateEditor(dateOfDeath, "dd.MM.yyyy");
        dateOfDeath.setEditor(d1);
        cont.add(dateOfDeath);
        
        JPanel plRelation = new JPanel();
       
        
        cont.add(btAdd);
        cont.add(btExit);
        btAdd.addActionListener(e -> {
            try {
                onAdd(e);
            } catch (ParseException ex) {
                Logger.getLogger(AddingDLG.class.getName()).log(Level.SEVERE, null, ex);
            }
        });
        btExit.addActionListener(e -> onExit(e));
    }
    private JComboBox cbWaehle;
    private JTextField tfFirstname = new JTextField();
    private JTextField tfLastname = new JTextField();
    private JSpinner dateOfBirth;
    private JSpinner dateOfDeath;
    private JButton btAdd = new JButton("Hinzufügen");
    private JButton btExit = new JButton("Abbrechen");
    private JCheckBox cbDeath = new JCheckBox();
    
    private void onAdd(ActionEvent e) throws ParseException 
    {       
       
        String type = (String)cbWaehle.getSelectedItem();
        DateFormat df = new SimpleDateFormat("dd.MM.yyyy");
       
         System.out.println(type);
         p = new Person(tfFirstname.getText(), tfLastname.getText(), (Date)dateOfBirth.getValue(), (Date)dateOfDeath.getValue());   
         sbl.addPerson(getP(), RelationType.Eltern);

        this.setVisible(false);
    }
    private Person p;
    private void onExit(ActionEvent e) 
    {
        this.setVisible(false);
    }

    public Person getP() 
    {
        System.out.println("Adding");
        return p;
    }

    
    
}




