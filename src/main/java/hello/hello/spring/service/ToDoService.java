package hello.hello.spring.service;

import hello.hello.spring.domain.ToDo;
import hello.hello.spring.repository.ToDoRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Transactional
public class ToDoService {

    private final ToDoRepository toDoRepository;

    public ToDoService(ToDoRepository toDoRepository) {
        this.toDoRepository = toDoRepository;
    }

    public List<ToDo> getToDoList(String fid) {
        List<ToDo> toDoList = toDoRepository.findAllByFid(fid);
        return toDoList;
    }
    public Long create(ToDo todo) {
        toDoRepository.save(todo);
        return todo.getId();
    }
    public ToDo updateToDoList(Long toDoId, String content) {
        Optional<ToDo> optionalToDo = toDoRepository.findById(toDoId);

        if(optionalToDo.isPresent()) {
            ToDo todo = optionalToDo.get();
            todo.setContent(content);

            return toDoRepository.save(todo);
        } else {
            throw new EntityNotFoundException("ToDo 엔터티를 찾을 수 없습니다. ID: " + toDoId);
        }
    }
    public void deleteToDoList(Long toDoId) {
        toDoRepository.deleteById(toDoId);
    }

    public void updateStatusById(Long id, String status) {
        toDoRepository.updateStatusById(id, status);
    }
}
