package com.datababy.Dao;

import com.datababy.Entity.Student;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

public interface StudentDaoRepository extends JpaRepository<Student,Integer>,JpaSpecificationExecutor<Student>{






}
