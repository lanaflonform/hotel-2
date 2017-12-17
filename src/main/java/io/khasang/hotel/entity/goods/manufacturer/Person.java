//package io.khasang.hotel.entity.goods.manufacturer;
//
//import javax.persistence.*;
//
////@Entity
//@Table(name = "persons")
//public class Person {
//    @Id
//    @GeneratedValue(strategy = GenerationType.IDENTITY)
//    private long id;
//    private String firstName;
//    private String lastName;
//    private String position;
//    private String phone1;
//    private String phone2;
//    private String email1;
//    private String email2;
//
//    public long getId() {
//        return id;
//    }
//
//    public void setId(long id) {
//        this.id = id;
//    }
//
//    public String getFirstName() {
//        return firstName;
//    }
//
//    public void setFirstName(String firstName) {
//        this.firstName = firstName;
//    }
//
//    public String getLastName() {
//        return lastName;
//    }
//
//    public void setLastName(String lastName) {
//        this.lastName = lastName;
//    }
//
//    public String getPosition() {
//        return position;
//    }
//
//    public void setPosition(String position) {
//        this.position = position;
//    }
//
//    public String getPhone1() {
//        return phone1;
//    }
//
//    public void setPhone1(String phone1) {
//        this.phone1 = phone1;
//    }
//
//    public String getPhone2() {
//        return phone2;
//    }
//
//    public void setPhone2(String phone2) {
//        this.phone2 = phone2;
//    }
//
//    public String getEmail1() {
//        return email1;
//    }
//
//    public void setEmail1(String email1) {
//        this.email1 = email1;
//    }
//
//    public String getEmail2() {
//        return email2;
//    }
//
//    public void setEmail2(String email2) {
//        this.email2 = email2;
//    }
//
//    @Override
//    public boolean equals(Object o) {
//        if (this == o) return true;
//        if (o == null || getClass() != o.getClass()) return false;
//
//        Person person = (Person) o;
//
//        if (id != person.id) return false;
//        if (!firstName.equals(person.firstName)) return false;
//        return lastName.equals(person.lastName);
//    }
//
//    @Override
//    public int hashCode() {
//        int result = (int) (id ^ (id >>> 32));
//        result = 31 * result + firstName.hashCode();
//        result = 31 * result + lastName.hashCode();
//        return result;
//    }
//}
