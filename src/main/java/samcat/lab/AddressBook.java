package samcat.lab;

import javax.persistence.*;
import java.util.ArrayList; // import the ArrayList class
import java.util.List;


@Entity
public class AddressBook {
    @Id
    @GeneratedValue
    private Long id;

    @OneToMany(cascade = CascadeType.ALL, fetch=FetchType.EAGER)
    private List<BuddyInfo> buddies;

    public AddressBook() {
        buddies = new ArrayList<BuddyInfo>();
    }

    public void addBuddy(BuddyInfo buddy) {
        this.buddies.add(buddy);
    }

    public Long getId() {
        return this.id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void removeBuddy(int i) {
        buddies.remove(i);
    }

    public void removeBuddy(Long l) {
        buddies.removeIf(p -> p.getId().equals(l));;
    }

    public void removeBuddy(BuddyInfo b) {
        buddies.remove(b);
    }

    public List<BuddyInfo> getBuddies() {
        return buddies;
    }

    public void setBuddies(List<BuddyInfo> buddies) {
        this.buddies = buddies;
    }

    //overriding the to string method causes jpa errors
    public String asString() {
//        return "AddressBook{" +
//                "buddies=" + buddies +
//                '}';

        String s = "AddressBook{" +
                "buddies=";
        for (BuddyInfo buddy:
             buddies) {
            s += buddy.asString() + "\n";
        }
        return s + '}';
    }


    public static void main(String[] args) {
        AddressBook book = new AddressBook();
        BuddyInfo buddy1 = new BuddyInfo("sam", "123456789");
        BuddyInfo buddy2 = new BuddyInfo("john", "987654321");
        book.addBuddy(buddy1);
        book.addBuddy(buddy2);
        System.out.println(book);
    }
}
