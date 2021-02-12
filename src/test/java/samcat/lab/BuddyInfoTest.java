package samcat.lab;

import org.junit.Test;

import static org.junit.Assert.assertEquals;


public class BuddyInfoTest {

    @Test
    public void TestName() {
        BuddyInfo buddy = new BuddyInfo("sam", "123456789");
        assertEquals("sam", buddy.getName());
        buddy.setName("john");
        assertEquals("john", buddy.getName());
    }

    @Test
    public void TestPhoneNumber() {
        BuddyInfo buddy = new BuddyInfo("sam", "123456789");
        assertEquals("123456789", buddy.getPhoneNumber());
        buddy.setPhoneNumber("987654321");
        assertEquals("987654321", buddy.getPhoneNumber());
    }

//    @Test
//    public void TestPersistence() {
//        BuddyInfo buddy1 = new BuddyInfo("sam", "123456789");
//        BuddyInfo buddy2 = new BuddyInfo("john", "987654321");
//
//        // Connecting to the database through EntityManagerFactory
//        // connection details loaded from persistence.xml
//        EntityManagerFactory emf = Persistence.createEntityManagerFactory("jpa-test");
//
//        EntityManager em = emf.createEntityManager();
//
//        // Creating a new transaction
//        EntityTransaction tx = em.getTransaction();
//
//        tx.begin();
//        em.persist(buddy1);
//        em.persist(buddy2);
//
//        // Querying the contents of the database using JPQL query
//        Query q = em.createQuery("SELECT b FROM BuddyInfo b");
//
//        @SuppressWarnings("unchecked")
//        List<BuddyInfo> results = q.getResultList();
//
//        System.out.println("List of products\n----------------");
//
//        for (BuddyInfo b : results) {
//
//            System.out.println(b.getName());
//        }
//
//        assertEquals(buddy1, results.get(0));
//        assertEquals(buddy2, results.get(1));
//
//        // Closing connection
//        em.close();
//
//        emf.close();
//    }
}