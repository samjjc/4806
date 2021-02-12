package samcat.lab;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
        import org.springframework.ui.Model;
        import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class BookController {

    @Autowired //don't forget the setter
    private AddressBookRepository repository;

    @GetMapping("/mybooks/{id}")
    public String greeting(Model model, @PathVariable Long id) {

        model.addAttribute("id", id);
        AddressBook book = repository.findById(id).get();
        model.addAttribute("buddies", book.asString());
        return "bookview";
    }

}