package hello.hello.spring.domain;

import jakarta.persistence.*;

//Jpa가 관리하는 entity
@Entity
public class Member {

    @Id
    private String id;
    //@Column(name="~") name 값은 DB에 저장된 column명

    private String password;
    private String name;

    private String email;


    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    //비밀번호 검사
    public boolean matchPassword(String password) {
        if (password == null) {
            return false;
        }
        return this.password.equals(password);
    }
    //id가 같은지
    public boolean isSameMember(String id) {
        return this.id.equals(id);
    }
}
