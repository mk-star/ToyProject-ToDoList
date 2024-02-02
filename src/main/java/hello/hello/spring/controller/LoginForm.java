package hello.hello.spring.controller;

public class LoginForm {

    private String id;
    //@Column(name="~") name 값은 DB에 저장된 column명

    private String password;

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
}

