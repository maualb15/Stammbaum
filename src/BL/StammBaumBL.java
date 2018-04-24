/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BL;

import family.Family;
import family.person.Person;
import family.person.RelationType;

public class StammBaumBL 
{
    private Family family;
    private Person actualPerson;
    private TableModel tm;

    public StammBaumBL()
    {
        family = new Family(0);
        tm = new TableModel(family.getPersonAtList());
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

    public void creatNewPerson(Person person)
    {
        family.addPerson(person);
        tm.add(person);
    }

    public void addPerson(Person person, RelationType relationType)
    {

        family.addPerson(person);
        person.setRelatioan(actualPerson.getEquivalent(),relationType);
        actualPerson.setRelatioan(person.getEquivalent(),relationType);
        tm.add(person);
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


