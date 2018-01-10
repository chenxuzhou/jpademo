package com.datababy.Service;
import com.datababy.Entity.PageParm;
import  com.datababy.Entity.Student;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;
public interface IStudentService {

    /**
     * 添加
     * @param student
     * @return Student
     */
    public Student addStudent(Student student);

    /**
     * //删除
     * @param userId
     */
    public void deleteStudent(Integer userId);

    /**
     * 更新
     * @param student
     * @return Student
     */
    public Student updateStudent(Student student);

    /**
     * 不带参分页
     * @param pageable
     * @return Page<Student>
     */
    public Page<Student> getStudents1(Pageable pageable);

    /**
     *
     * @param pageParm
     * @param pageable
     * @return Page<Student>
     */
    public Page<Student> pageStudentName(PageParm pageParm, Pageable pageable);

    /**
     * //查询所有
     * @return List<Student>
     */
    public List<Student> getStudents();

    /**
     * //查询根据id单个
     * @param userId
     * @return Student
     */
    public Student getStudentById(Integer userId);
}
