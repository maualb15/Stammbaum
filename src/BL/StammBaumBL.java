/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BL;

import family.Family;
import family.person.Person;
import family.person.RelationType;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class StammBaumBL 
{
    private Family family;
    private Person actualPerson;
    private TableModel tm;
    private SimpleDateFormat smf = new SimpleDateFormat("dd.mm.yyyy");

    public StammBaumBL()
    {
        family = new Family(0);
        tm = new TableModel(family.getPersonAtList());

        try {
            test();
        } catch (ParseException e) {
            System.out.println("Fehler test");
        }
    }

    public void test() throws ParseException
    {
        new Person("a", "a", smf.parse("11.11.2000"), null);
    }


    public void setFamily(Family family)
    {
        this.family = family;
    }

    public void loadFamily(String path)
    {

    }

    public void saveFamily(String path)
    {

    }

    public void remove(int i) throws Exception {
        int[] equi = tm.remove(i);
        if(family.getFamilyEquivalent()==equi[0])
        {
            boolean check = family.removePerson(equi[1]);
            if(check == false)
            {
                throw new Exception("Fehler im löschen");
            }
        }
        else
        {
            throw new Exception("Fehler im löschen, fehlende Familie");
        }
    }

    public void addPerson(Person person)
    {
        if(actualPerson == null)
        {
            actualPerson = person;
        }

        family.addPerson(person);
        tm.add(person);
    }

    public void addPerson(Person person, RelationType relationType)
    {
        //auskommentierte Zeilen werfen NullPointException

        addPerson(person);
        if(person.getEquivalent() != actualPerson.getEquivalent()) {
            person.setRelatioan(actualPerson.getEquivalent(), relationType);
            actualPerson.setRelatioan(person.getEquivalent(), relationType);
        }
    }

    public void setNewRelation(int[] personequivalent, RelationType relationType)
    {
        actualPerson.setRelatioan(personequivalent,relationType);
        family.getPerson(personequivalent[1]).setRelatioan(actualPerson.getEquivalent(),relationType);
    }

    public Person getActualPerson()
    {
        return actualPerson;
    }

    public Person changeActuallPerson(int[] personequivalent)
    {
        return (actualPerson = family.getPerson(personequivalent[1]));
    }

    public TableModel getTableModel() 
    {
        return tm;
    }

}


