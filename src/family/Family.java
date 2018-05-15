package family;

import family.person.Person;

import java.util.ArrayList;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;

public class Family
{
    private Map<Integer, Person> persons = new TreeMap<>();
    private final int familyEquivalent;
    private int personequivalent = 0;


    public Family(Map<Integer, Person> persons, int familyEquivalent) {
        this(familyEquivalent);
        this.persons = persons;
        personequivalent = persons.size();

    }

    public Family(int familyEquivalent) {
        this.familyEquivalent = familyEquivalent;
    }

    public void addPerson(Person person)
    {
        persons.put(++personequivalent,person);
        person.setEquivalent(new int[]{familyEquivalent,personequivalent});
    }

    public Person getPerson(int personequivalent)
    {
        return persons.get(personequivalent);
    }

    public Person getPerson(int[] personequivalent)
    {
        if(personequivalent[0]==familyEquivalent)
        {
            return persons.get(personequivalent[1]);
        }
        return null;
    }

    public int getFamilyEquivalent() {
        return familyEquivalent;
    }

    public boolean removePerson(int equi)
    {
       return null != persons.remove(equi);
    }

    public ArrayList<Person> getPersonAtList()
    {
        Set<Integer> keySet  = persons.keySet();
        ArrayList<Person> people = new ArrayList<>();

        for (Integer i: keySet)
        {
            people.add(persons.get(i));
        }
        return people;
    }
}