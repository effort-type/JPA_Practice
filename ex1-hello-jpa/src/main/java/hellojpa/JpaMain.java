package hellojpa;

import javax.persistence.*;
import java.util.List;

public class JpaMain {

    public static void main(String[] args) {

        /**
         * resources/META-INF/persistence.xml에 있는 <persistence-unit의 name 속성 값을 매개변수 값으로 전달해야 함
         */
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("hello");

        EntityManager em = emf.createEntityManager();

        // JPA는 꼭 트랜잭션 안에서 실행되어야 함
        EntityTransaction tx = em.getTransaction();
        tx.begin();


        try {

            Team team = new Team();
            team.setName("TeamA");
            em.persist(team);

            Member member = new Member();
            member.setUsername("member1");
            member.setTeamId(team.getId());
            em.persist(member);

            tx.commit(); // 이때 쿼리문이 실행된다.
        } catch (Exception e) {
            tx.rollback();
        } finally {
            em.close(); // 사용되고 나면 꼭 닫아주기
        }

        emf.close(); // 실제 애플리케이션이 완전히 종료될 때 entityManagerFactory를 닫아줘야한다.

    }
}
