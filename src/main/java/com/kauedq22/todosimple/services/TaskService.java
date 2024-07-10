package com.kauedq22.todosimple.services;

import java.util.List;
import java.util.Objects;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.kauedq22.todosimple.models.Task;
import com.kauedq22.todosimple.models.User;
import com.kauedq22.todosimple.models.enums.ProfileEnum;
import com.kauedq22.todosimple.models.projection.TaskProjection;
import com.kauedq22.todosimple.repositories.TaskRepository;
import com.kauedq22.todosimple.security.UserSpringSecurity;
import com.kauedq22.todosimple.services.exceptions.AuthorizationException;
import com.kauedq22.todosimple.services.exceptions.DataBindingViolationException;
import com.kauedq22.todosimple.services.exceptions.ObjectNotFoundException;

@Service
public class TaskService {

    @Autowired
    private TaskRepository taskRepository;

    @Autowired
    private UserService userService;

    public Task findById(Long id){
       Task task = this.taskRepository.findById(id).orElseThrow(() -> new ObjectNotFoundException(
            "Task Not Found! Id: " + id + ", Type" + Task.class.getName()));
        UserSpringSecurity userSpringSecurity = UserService.authentiacated();
        if(Objects.isNull(userSpringSecurity) 
                || !userSpringSecurity.hasRole(ProfileEnum.ADMIN) 
                && !userHasTask(userSpringSecurity, task)) 
        throw new AuthorizationException("Access defined ");
        return task;
    }

    public List<TaskProjection> findAllByUser(){
        UserSpringSecurity userSpringSecurity = UserService.authentiacated();
        if(Objects.isNull(userSpringSecurity))
            throw new AuthorizationException("Access defined ");
        List<TaskProjection> tasks = this.taskRepository.findByUser_Id(userSpringSecurity.getId());
        return tasks;
        
    }

    @Transactional
    public Task create(Task obj) {
        UserSpringSecurity userSpringSecurity = UserService.authentiacated();
        if(Objects.isNull(userSpringSecurity))
            throw new AuthorizationException("Access defined ");

        User user = this.userService.findById(userSpringSecurity.getId());
        obj.setId(null);
        obj.setUser(user);
        obj = this.taskRepository.save(obj);
        return obj;
    }

    @Transactional
    public Task update(Task obj) {
        Task newObj = findById(obj.getId());
        newObj.setDescription(obj.getDescription());
        return this.taskRepository.save(newObj);
    }

    public void delete(Long id) {
        findById(id);
        try {
            this.taskRepository.deleteById(id);
        } catch (Exception e) {
            throw new DataBindingViolationException("Unable to delete related entities");
        }
    }

    public Boolean userHasTask(UserSpringSecurity userSpringSecurity, Task task){
        return task.getUser().getId().equals(userSpringSecurity.getId());
    }
}
