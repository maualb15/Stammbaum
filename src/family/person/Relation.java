package family.person;

import java.util.ArrayList;

public class Relation {

    private ArrayList<PersonEquivalent> persons = new ArrayList<>();
    private RelationType type;

    public Relation(RelationType type)
    {
        this.type = type;
    }

    public void addPerson(Person person)
    {
        persons.add(new PersonEquivalent(person.getEquivalent()));
    }

    public void addPerson(int[] personsEquivalent)
    {
        persons.add(new PersonEquivalent(personsEquivalent));
    }

    public int[][] getPersons()
    {
        int [][] personsEquivalents = new int[persons.size()][2];
        int count = 0;
        for (PersonEquivalent personEquivalent:persons)
        {
            personsEquivalents[count][0] = personEquivalent.getEquivalent()[0];

        }
        return personsEquivalents;
    }



    public RelationType getType()
    {
        return type;
    }

    class PersonEquivalent
    {
        private int[] equivalent;

        public PersonEquivalent(int[] equivalent)
        {

            this.equivalent = equivalent;
        }

        public int[] getEquivalent()
        {
            return equivalent;
        }
    }
}
