package hello.hello.spring.domain;

import jakarta.persistence.*;
@Entity
@Table(name = "todo")
public class ToDo {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String content;


    private String status;


    private String fid;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    // 기본 생성자
    public ToDo() {
        this.status = "Y"; // 기본값 설정
    }

    public String getFid() {
        return fid;
    }

    public void setFid(String fid) {
        this.fid = fid;
    }
}