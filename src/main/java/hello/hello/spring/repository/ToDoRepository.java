package hello.hello.spring.repository;

import hello.hello.spring.domain.Member;
import hello.hello.spring.domain.ToDo;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface ToDoRepository {
    ToDo save(ToDo todo);

    Optional<ToDo> findById(Long id);

    void deleteById(Long s);

    void updateStatusById(Long id, String status);

    List<ToDo> findAllByFid(String fid);
}
