package samcat.lab;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class BuddyInfo {
    @Id
    @GeneratedValue
    private Long id;
    private String name;
    private String phoneNumber;

    public BuddyInfo() {
        this("","");
    }

    public BuddyInfo(String name, String phone) {
        this.name = name;
        this.phoneNumber = phone;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    //overriding the toString method causes jpa errors
    public String asString() {
        return "BuddyInfo{" +
                "id='" + id + '\'' +
                "name='" + name + '\'' +
                ", phoneNumber='" + phoneNumber + '\'' +
                '}';
    }
}

