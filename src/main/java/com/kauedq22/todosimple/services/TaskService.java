package com.kauedq22.todosimple.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.kauedq22.todosimple.models.Task;
import com.kauedq22.todosimple.models.User;
import com.kauedq22.todosimple.repositories.TaskRepositoy;

@Service
public class TaskService {

    @Autowired
    private TaskRepositoy taskRepositoy;

    @Autowired
    private UserService userService;

    public Task findById(Long id){
        Optional<Task> task  = this.taskRepositoy.findById(id);
        return task.orElseThrow( () -> new RuntimeException(
            "Task Not Found! Id: " + id + ", Type" + Task.class.getName()
        ));
    }

    public List<Task> findByUserId(Long userId){
        List<Task> tasks = this.taskRepositoy.findByUser_Id(userId);
        return tasks;
        
    }

    @Transactional
    public Task create(Task obj) {
        User user = this.userService.findById(obj.getUser().getId());
        obj.setId(null);
        obj.setUser(user);
        obj = this.taskRepositoy.save(obj);
        return obj;
    }

    @Transactional
    public Task update(Task obj) {
        Task newObj = findById(obj.getId());
        newObj.setDescription(obj.getDescription());
        return this.taskRepositoy.save(newObj);
    }

    public void delete(Long id) {
        findById(id);
        try {
            this.taskRepositoy.deleteById(id);
        } catch (Exception e) {
            throw new RuntimeException("Unable to delete related entities");
        }
    }
}
