package family.person;

public enum RelationType
{
    Eltern ("Eltern"),
    Kinder ("Kinder"),
    Partner ("Partner"),
    Geschwister("Geschwister");

    public final String name;

    RelationType(String name)
    {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public boolean equals(RelationType relationType)
    {
        return name.equals(relationType.getName());
    }



}
