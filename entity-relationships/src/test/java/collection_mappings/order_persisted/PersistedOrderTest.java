package collection_mappings.order_persisted;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import java.util.Arrays;

/**
 * @author prekezes.
 */
public class PersistedOrderTest {
    private static EntityManagerFactory entityManagerFactory;
    private static EntityManager em;

    @BeforeClass
    public static void setup() {
        entityManagerFactory = Persistence.createEntityManagerFactory("entity-relationships");
        em = entityManagerFactory.createEntityManager();
    }

    @AfterClass
    public static void tearDown() {
        if (em != null)
            em.close();
        entityManagerFactory.close();
    }

    private EntityTransaction beginTx() {
        EntityTransaction tx = em.getTransaction();
        tx.begin();
        return tx;
    }

    @Test
    public void test() {
        EntityTransaction tx = beginTx();
        PrintQueue d = new PrintQueue();
        d.setName("D1");
        em.persist(d);

        PrintItem a = new PrintItem();
        a.setPayLoad(new byte[] { 1,2});
        em.persist(a);

        PrintItem b = new PrintItem();
        b.setPayLoad(new byte[]{3, 4});
        em.persist(b);

        PrintItem c = new PrintItem();
        c.setPayLoad(new byte[]{5, 6});
        em.persist(c);

        d.getItems().add(a);
        d.getItems().add(b);
        d.getItems().add(c);

        b.setQueue(d);
        a.setQueue(d);
        c.setQueue(d);

        tx.commit();

        PrintQueue dc = em.find(PrintQueue.class, d.getId());
        for( PrintItem e : dc.getItems()) {
            byte[] payload = e.getPayLoad();
            System.out.println(Arrays.asList(payload));
        }

    }

}
