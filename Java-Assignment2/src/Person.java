public class Person {
    /**
     * Name
     */
    private String name;

    /**
     * Surname
     */
    private String surname;

    /**
     * Country
     */
    private String country;

    /**
     * Person ID
     */
    private int id;

    /**
     * Person Type
     */
    private String personType;

    /**
     * Empty Constructor
     */
    public Person() {
    }

    /**
     * Constructor Using Fields
     *
     * @param id         Person ID
     * @param name       Name
     * @param surname    Surname
     * @param country    Country
     * @param personType Person Type (User or Artist)
     */
    public Person(int id, String name, String surname, String country, String personType) {
        this.name = name;
        this.surname = surname;
        this.country = country;
        this.id = id;
        this.personType = personType;
    }

    /**
     * Getter of Name
     *
     * @return Name
     */
    public String getName() {
        return this.name;
    }

    /**
     * Setter of Name
     *
     * @param name Name
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Getter of Surname
     *
     * @return Surname
     */
    public String getSurname() {
        return this.surname;
    }

    /**
     * Setter of Surname
     *
     * @param surname Surname
     */
    public void setSurname(String surname) {
        this.surname = surname;
    }

    /**
     * Getter of Country
     *
     * @return Country
     */
    public String getCountry() {
        return this.country;
    }

    /**
     * Setter of Country
     *
     * @param country Country
     */
    public void setCountry(String country) {
        this.country = country;
    }

    /**
     * Getter of Person ID
     *
     * @return ID
     */
    public int getId() {
        return this.id;
    }

    /**
     * Setter of Person ID
     *
     * @param id ID
     */
    public void setId(int id) {
        this.id = id;
    }

    /**
     * Getter of PersonType
     *
     * @return PersonType
     */
    public String getPersonType() {
        return this.personType;
    }

    /**
     * Fluent Setter of Name
     *
     * @param name Name
     * @return Person(this)
     */
    public Person name(String name) {
        setName(name);
        return this;
    }

    /**
     * Fluent Setter of Surname
     *
     * @param surname Surname
     */
    public void surname(String surname) {
        setSurname(surname);
    }

    /**
     * Fluent Setter of Country
     *
     * @param country Country
     * @return Person(this)
     */
    public Person country(String country) {
        setCountry(country);
        return this;
    }

    /**
     * Fluent Setter of Person ID
     *
     * @param id ID
     * @return Person(this)
     */
    public Person id(int id) {
        setId(id);
        return this;
    }
}
