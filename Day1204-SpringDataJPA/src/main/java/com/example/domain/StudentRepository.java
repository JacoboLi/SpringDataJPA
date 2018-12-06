package com.example.domain;

import java.util.List;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

public interface StudentRepository extends JpaRepository<Student, Integer>,JpaSpecificationExecutor<Student> {

	List<Student> findBySname(String name);

	@Transactional
    @Modifying
    @Query("update Student s set s.sname=:name where s.id=:id")
    public void updateName(@Param("id") Integer id, @Param("name")String name);
}
