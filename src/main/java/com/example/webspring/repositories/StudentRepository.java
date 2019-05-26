package com.example.webspring.repositories;

import com.example.webspring.entity.Student;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.Optional;

public interface StudentRepository extends CrudRepository<Student,Integer> {
    //добавление записи
    //удаление записи
    //обновление записи
    //получение по первичному ключу
    //получение всех записей

    @Query("SELECT c FROM Student c WHERE c.studentCode = :code")
    Optional<Student>findByCode(@Param("code") String studentCode);
}
