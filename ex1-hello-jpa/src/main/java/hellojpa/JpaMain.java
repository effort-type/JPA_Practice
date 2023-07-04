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

        /**
         * EntityManagerFactory는 애플리케이션이 실행될 때 딱 한 번만 생성되어야 한다.
         * 그리고 애플리케이션이 실행되는 동안 DB에 값을 저장하거나 하는 트랜잭션 단위마다 EntityManager를 만들어줘야한다.
         * ex) 고객이 로그인해서 장바구니에 상품을 담거나 하는 행위를 할 때마다`
         */

        // DB에 저장, 조회되는 코드 작성하는 부분
        try {

            // 영속
            Member member1 = new Member(150L, "A");
            Member member2 = new Member(160L, "B");

            em.persist(member1);
            em.persist(member2);

            // 여기 이전까지는 영속 컨텍스트 안의 쓰기 지연 SQL 저장소에 계속 쌓아둔다.
            System.out.println("=====================");

            tx.commit(); // 이때 쿼리문이 실행된다.
        } catch (Exception e) {
            tx.rollback();
        } finally {
            em.close(); // 사용되고 나면 꼭 닫아주기
        }

        emf.close(); // 실제 애플리케이션이 완전히 종료될 때 entityManagerFactory를 닫아줘야한다.

    }
}
