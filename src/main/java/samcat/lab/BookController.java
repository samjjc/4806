package samcat.lab;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
        import org.springframework.ui.Model;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.view.RedirectView;

import java.util.Map;

@Controller
public class BookController {

    @Autowired //don't forget the setter
    private AddressBookRepository repository;

    @GetMapping("/")
    public String spa(Model model) {

        return "spa";
    }

    @GetMapping("/mybooks/{id}")
    public String greeting(Model model, @PathVariable Long id) {

        model.addAttribute("buddy", new BuddyInfo());
        model.addAttribute("id", id);
        AddressBook book = repository.findById(id).get();
        model.addAttribute("buddies", book.asString());
        return "bookview";
    }

    @GetMapping("/newbook")
    public String bookform(Model model) {

        return "bookform";
    }

    @PostMapping("/newbook")
    public RedirectView bookformSubmit(Model model) {

        AddressBook book = new AddressBook();
        repository.save(book);
        Long id = book.getId();
        model.addAttribute("buddy", new BuddyInfo());
        model.addAttribute("id", id);
        model.addAttribute("buddies", book.asString());

//        return "bookview";
        return new RedirectView("/mybooks/"+id);
    }

////    @PostMapping(name="/newbuddy/{id}", consumes = MediaType.APPLICATION_FORM_URLENCODED_VALUE)
    @PostMapping("/newbuddy/{id}")
//    @RequestMapping(value = "/newbuddy/{id}", method = RequestMethod.POST, consumes = MediaType.APPLICATION_FORM_URLENCODED_VALUE)
    public RedirectView buddyformSubmit(@ModelAttribute BuddyInfo buddy, @PathVariable Long id, Model model) {
        AddressBook book = repository.findById(id).get();
        book.addBuddy(buddy);
        repository.save(book);
        model.addAttribute("buddy", new BuddyInfo());
        model.addAttribute("id", id);
        model.addAttribute("buddies", book.asString());


        return new RedirectView("/mybooks/"+id);
    }




}