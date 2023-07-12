package hellojpa;

import javax.persistence.*;

/**
 * 1. @Entity을 반드시 넣어줘야 한다.그러면 관리하는 테이블이라고 인식한다.
 * 2. Table에 알맞게 변수들을 생성한다.
 * 3. 반드시 pk는 알려줘야하기 때문에 @Id 어노테이션을 사용해서 명시해주어야한다.
 * 4. Getter, Setter 생성해준다.
 *
 * 참고 : javax.persistence꺼를 import 해줘야한다.
 *       실제 DB Table 이름과 다를 경우에는 @Table(name = "테이블 이름") 어노테이션을 통해 명시해줘야한다.
 *       DB column과 변수 이름이 다를 경우에도 @Column(name = "컬럼 이름") 어노테이션을 통해 명시해줘야한다.
 */
@Entity
public class Member {

    @Id // primary key 설정
    @GeneratedValue
    @Column(name = "MEMBER_ID")
    private Long id;

    @Column(name = "USERNAME") // DB의 컬럼 이름과 객체의 변수 이름을 다르게 사용하고자 할 때 명시해주면 된다.
    private String username;

//    @Column(name = "TEAM_ID")
//    private Long teamId;

    @ManyToOne
    @JoinColumn(name = "TEAM_ID")
    private Team team;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public Team getTeam() {
        return team;
    }

    public void setTeam(Team team) {
        this.team = team;
    }
}
