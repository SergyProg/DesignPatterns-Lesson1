package ru.netology;

public class Person {
    protected final String name;
    protected final String surname;
    protected int age = -1;
    protected String address;

   public Person(String name, String surname) {
        this.name = name;
        this.surname = surname;
    }

    public Person(String name, String surname, int age) {
        this.name = name;
        this.surname = surname;
        this.age = age;
    }

    public String getName() { return name; }

    public String getSurname() { return surname; }

    public int getAge() { return age; }

    public String getAddress() { return address; }

    public boolean hasAge() { return (age != -1); }

    public boolean hasAddress() { return (address != null); }

    public void setAddress(String address) { this.address = address; }

    public void happyBirthday() {
       if (hasAge()) age = age + 1;
   }

    public PersonBuilder newChildBuilder(){
       PersonBuilder personBuilder = new PersonBuilder()
               .setSurname(surname)
               .setAge(0);
       if(hasAddress()){
           personBuilder = personBuilder.setAddress(address);
       }

       return personBuilder;
    }

    @Override
    public String toString() {
       return "<" + name + " " + surname + " " +
               (hasAge() ?  (age == 0) ? "новорождённый" : "возраст: " + age : "") +
               (hasAddress() ? ", проживает по адресу: " + address : "") + ">";
    }
}
