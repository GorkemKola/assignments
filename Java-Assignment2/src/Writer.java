public class Writer extends Artist {
    /**
     * Writing Style
     */
    private String writingStyle;

    /**
     * Empty Constructor
     */
    public Writer() {
    }

    /**
     * Constructor Using Fields
     *
     * @param id           Person ID
     * @param name         Name
     * @param surname      Surname
     * @param country      Country
     * @param writingStyle Writing Style
     */
    public Writer(int id, String name, String surname, String country, String writingStyle) {
        super(id, name, surname, country, "Writer");
        this.writingStyle = writingStyle;
    }

    /**
     * Getter of Writer
     *
     * @param person Person for Information
     * @return Writer
     */
    public static Writer getWriter(Person person) {
        Writer writer = new Writer();
        writer.id(person.getId());
        writer.name(person.getName());
        writer.surname(person.getSurname());
        writer.country(person.getCountry());
        writer.writingStyle(((Writer) person).getWritingStyle());
        return writer;
    }

    /**
     * Getter of Writing Style
     *
     * @return Writing Style
     */
    public String getWritingStyle() {
        return this.writingStyle;
    }

    /**
     * Setter of Writing Style
     *
     * @param writingStyle Writing Style
     */
    public void setWritingStyle(String writingStyle) {
        this.writingStyle = writingStyle;
    }

    /**
     * Fluent Setter of Writing Style
     *
     * @param writingStyle
     */
    public void writingStyle(String writingStyle) {
        setWritingStyle(writingStyle);
    }
}
