package samcat.lab;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class LabApplication {


	private static final Logger log = LoggerFactory.getLogger(LabApplication.class);

	public static void main(String[] args) {
		SpringApplication.run(LabApplication.class);
	}

//	@Bean
//	public CommandLineRunner demo(AddressBookRepository repository) {
//		return (args) -> {
//			AddressBook book1 = new AddressBook();
//			BuddyInfo buddy1 = new BuddyInfo("sam", "123456789");
//			BuddyInfo buddy2 = new BuddyInfo("john", "987654321");
////			book1.addBuddy(buddy1);
//			book1.addBuddy(buddy2);
//			repository.save(book1);
//			repository.save(new AddressBook());
//			log.info("Customers found with findAll():");
//			log.info("-------------------------------");
//			for (AddressBook book : repository.findAll()) {
//				log.info(book.toString());
//				log.info(book.getBuddies().toString());
//				book.addBuddy(buddy1);
//				repository.save(book);
//			}
//			log.info("");
//
//			log.info("Customers found with findAll():");
//			log.info("-------------------------------");
//			for (AddressBook book : repository.findAll()) {
//				log.info(book.toString());
//				log.info(book.getBuddies().toString());
//			}
//			log.info("");
//
//			AddressBook book2 = repository.findById(1L);
//			log.info("Customer found with findById(1L):");
//			log.info("--------------------------------");
//			log.info(book2.toString());
//			log.info(book2.getBuddies().toString());
//			log.info("");
//		};
//	}


}
