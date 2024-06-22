package com.kauedq22.todosimple.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.kauedq22.todosimple.models.Task;

@Repository
public interface TaskRepositoy extends JpaRepository<Task, Long> {
    
    

}
