package be.voedsaam.business;


import java.io.Serializable;

abstract class Person implements Serializable {

    private String firstName;
    private String lastName;
    private String emailAddress;
    private String role;
    private Address address;

    public Person() {
        this.address = new Address();
    }

    public Person(String firstName, String lastName, String emailAddress) {
        this();
        this.firstName = firstName;
        this.lastName = lastName;
        this.emailAddress = emailAddress;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("Person{");
        sb.append("firstName='").append(firstName).append('\'');
        sb.append(", lastName='").append(lastName).append('\'');
        sb.append(", street='").append(address.getStreet()).append('\'');
        sb.append(", number='").append(address.getNumber()).append('\'');
        sb.append(", city='").append(address.getCity()).append('\'');
        sb.append(", postalCode='").append(address.getPostalCode()).append('\'');
        sb.append(", country='").append(address.getCountry()).append('\'');
        sb.append('}');
        return sb.toString();
    }
    // Getters and setters

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmailAddress() {
        return emailAddress;
    }

    public void setEmailAddress(String emailAddress) {
        this.emailAddress = emailAddress;
    }

    public String getStreet() {
        return address.getStreet();
    }

    public void setStreet(String street) {
        this.address.setStreet(street);
    }

    public Integer getStreetNumber() {
        return address.getNumber();

    }

    public void setStreetNumber(Integer streetNumber) {
        this.address.setNumber(streetNumber);
    }

    public String getCity() {
        return address.getCity();
    }

    public void setCity(String city) {
        this.address.setStreet(city);
    }

    public Integer getPostalCode() {
        return address.getPostalCode();
    }

    public void setPostalCode(Integer postalCode) {
        this.address.setNumber(postalCode);
    }

    public String getRole() {
        return role;
    }

    protected void setRole(String role) {
        this.role = role;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Person person = (Person) o;

        if (!getFirstName().equals(person.getFirstName())) return false;
        if (getLastName() != null ? !getLastName().equals(person.getLastName()) : person.getLastName() != null)
            return false;
        return getEmailAddress().equals(person.getEmailAddress());
    }

    @Override
    public int hashCode() {
        int result = getFirstName().hashCode();
        result = 31 * result + (getLastName() != null ? getLastName().hashCode() : 0);
        result = 31 * result + getEmailAddress().hashCode();
        return result;
    }
}
