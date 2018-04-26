/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package family.person;

import java.util.Date;

public class Person
{

    private String firstName;
    private String lastName;
    private Date birthDate;
    private Date deathDate;
    private Relation[] relatioans = new Relation[4];
    /**
     * Erster Wert ist das der Familie zweite das der Person
     */
    private int equivalent[];


    public Person(String firstName, String lastName, Date birthDate, Date deathDate)
    {
        this.firstName = firstName;
        this.lastName = lastName;
        this.birthDate = birthDate;
        this.deathDate = deathDate;
        initializeRelations();
    }

    public Person(String firstName, String lastName, Date birthDate, Date deathDate, int[] equivalent)
    {
        this(firstName,lastName,birthDate,deathDate);
        this.equivalent = equivalent;
    }

    public void initializeRelations()
    {
        relatioans[0] = new Relation(RelationType.Eltern);
        relatioans[1] = new Relation(RelationType.Kinder);
        relatioans[2] = new Relation(RelationType.Partner);
        relatioans[3] = new Relation(RelationType.Geschwister);
    }

    public void setEquivalent(int [] equivalent)
    {
        if(this.equivalent == null)
        {
            this.equivalent  = equivalent;
        }
    }

    public void setRelatioan(int [] personequivalent, RelationType type)
    {
        for (Relation relation:relatioans) {
            if(relation.getType().equals(type))
            {
                relation.addPerson(personequivalent);
            }
        }
    }

    public int[] getEquivalent() {
        return equivalent;
    }

    public String getFirstName()
    {
        return firstName;
    }

    public void setFirstName(String firstName)
    {
        this.firstName = firstName;
    }

    public String getLastName()
    {
        return lastName;
    }

    public void setLastName(String lastName)
    {
        this.lastName = lastName;
    }

    public Date getBirthDate()
    {
        return birthDate;
    }

    public void setBirthDate(Date birthDate)
    {
        this.birthDate = birthDate;
    }

    public Date getDeathDate()
    {
        return deathDate;
    }

    public void setDeathDate(Date deathDate)
    {
        this.deathDate = deathDate;
    }

    public void setData(String firstName, String lastName, Date birthDate, Date deathDate) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.birthDate = birthDate;
        this.deathDate = deathDate;
    }
}

