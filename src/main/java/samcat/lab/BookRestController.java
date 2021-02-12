package samcat.lab;

import java.util.concurrent.atomic.AtomicLong;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class BookRestController {


    @Autowired //don't forget the setter
    private AddressBookRepository repository;


    //curl -X POST http://localhost:8080/book
    @PostMapping("/book")
    public AddressBook book() {
        AddressBook book = new AddressBook();
        repository.save(book);
        return book;
    }

    //curl -i -H "Content-Type:application/json" -d '{"name": "SAMM", "phoneNumber": "987"}' http://localhost:8080/book/1/buddy
    @PostMapping("/book/{id}/buddy")
    public AddressBook addBuddy(@RequestBody BuddyInfo buddy,
                                @PathVariable Long id) {
        AddressBook book = repository.findById(id).get();
        book.addBuddy(buddy);
        repository.save(book);
        return book;
    }

    //curl -X DELETE http://localhost:8080/book/1/buddy/3
    @DeleteMapping("/book/{bookid}/buddy/{buddyid}")
    public AddressBook removeBuddy(@PathVariable Long bookid, @PathVariable Long buddyid) {
        AddressBook book = repository.findById(bookid).get();
        book.removeBuddy(buddyid);
        repository.save(book);
        return book;
    }
}
