package hello.hello.spring.repository;

import hello.hello.spring.domain.ToDo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.Optional;

public interface SpringDataJpaToDoRepository extends JpaRepository<ToDo, Long>, ToDoRepository {
    @Modifying
    @Query("UPDATE ToDo t SET t.status = :status WHERE t.id = :id")
    void updateStatusById(@Param("id") Long id, @Param("status") String status);
}

