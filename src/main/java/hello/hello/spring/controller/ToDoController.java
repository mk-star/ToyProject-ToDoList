package hello.hello.spring.controller;

import hello.hello.spring.domain.ToDo;
import hello.hello.spring.service.ToDoService;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import jakarta.servlet.http.HttpSession;

import java.util.List;

@Controller
public class ToDoController {

    private final ToDoService toDoService;

    @Autowired
    public ToDoController(ToDoService toDoService) {
        this.toDoService = toDoService;
    }

    @GetMapping("/todo")
    public String todo(Model model, HttpSession session) {
        // 세션에서 값을 가져와서 사용
        String memberId = (String) session.getAttribute("id");

        System.out.println("memberId: " + memberId);
        List<ToDo> todoList = toDoService.getToDoList(memberId);
        model.addAttribute("todoList", todoList);
        for (ToDo todo: todoList) {
            System.out.println(todo.getStatus());

        }
        return "to-doList";
    }
    @PostMapping("todo/create")
    public String createToDoList(ToDo todoForm, HttpServletRequest request) {
        ToDo todo = new ToDo();
        todo.setContent(todoForm.getContent());

        HttpSession session = request.getSession();
        todo.setFid((String)session.getAttribute("id"));

        toDoService.create(todo);

        return "redirect:/todo";
    }

    @GetMapping("todo/update")
    @ResponseBody
    public ResponseEntity<String> updateTodo(@RequestParam("todo_id") Long id, @RequestParam("todo_content") String content) {
        toDoService.updateToDoList(id, content);
        return ResponseEntity.ok("{\"success\": true, \"todo_id\": " + id + ", \"todo_content\": \"" + content + "\"}");
    }

    @GetMapping("todo/delete")
    @ResponseBody
    public ResponseEntity<String> deleteTodo(@RequestParam("todo_id") Long id) {
        toDoService.deleteToDoList(id);
        return ResponseEntity.ok("{\"suceturn Respocess\": true, \"todo_id\": " + id + "}");
    }

    @GetMapping("/todo/updateStatus")
    @ResponseBody
    public ResponseEntity<String> updateStatus(@RequestParam("todo_id") Long id, @RequestParam("todo_status") String status) {
        toDoService.updateStatusById(id, status);

        return ResponseEntity.ok("{\"success\": true, \"todo_id\": " + id + ", \"todo_status\": \"" + status + "\"}");
    }

}