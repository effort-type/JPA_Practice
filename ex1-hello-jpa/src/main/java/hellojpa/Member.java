package hellojpa;

import javax.persistence.*;
import java.util.Date;

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
    private Long id;

    @Column(name = "name") // DB의 컬럼 이름과 객체의 변수 이름을 다르게 사용하고자 할 때 명시해주면 된다.
    private String username;

    private Integer age; // 이렇게 하면 알아서 Integer 타입에 알맞게 생성해준다.

    @Enumerated(EnumType.STRING) // DB에는 enum 타입이 없는데 enum 타입을 쓰고 싶을 때 사용하면 된다.
    private RoleType roleType;

    @Temporal(TemporalType.TIMESTAMP) // 날짜를 사용할 때 DB는 DATE, TIME, TIMESTAMP로 구분해서 저장하기 때문에 명시해줘야한다.
    private Date createDate;

    @Temporal(TemporalType.TIMESTAMP)
    private Date lastModifiedDate;

    @Lob // varchar를 넘어서는 큰 콘텐츠와 같은 값을 저장하고 싶을 때 사용하면 된다.
    private String description;

    @Transient // DB에 컬럼이 있는 것이 아니라 메모리에서만 저장하고 계산할 값일 경우에 사용하면 된다.
    private int emp;

    public Member() {
    }

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

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public RoleType getRoleType() {
        return roleType;
    }

    public void setRoleType(RoleType roleType) {
        this.roleType = roleType;
    }

    public Date getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }

    public Date getLastModifiedDate() {
        return lastModifiedDate;
    }

    public void setLastModifiedDate(Date lastModifiedDate) {
        this.lastModifiedDate = lastModifiedDate;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getEmp() {
        return emp;
    }

    public void setEmp(int emp) {
        this.emp = emp;
    }
}
