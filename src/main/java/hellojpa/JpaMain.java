package hellojpa;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

public class JpaMain {
    public static void main(String[] args) {
        // persistenceUnitName: persistence.xml 파일의 persistence-unit-name
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("hello");

        EntityManager em = emf.createEntityManager();

        // 트랜잭션
        EntityTransaction tx = em.getTransaction();
        tx.begin();

        Member member = new Member();

        member.setId(1L);
        member.setName("hello1");
        em.persist(member); // Member 저장

        tx.commit();

        em.close();

        emf.close();
    }
}
