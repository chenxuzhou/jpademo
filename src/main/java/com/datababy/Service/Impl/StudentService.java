package com.datababy.Service.Impl;

import com.datababy.Dao.StudentDaoRepository;
import com.datababy.Entity.PageParm;
import com.datababy.Service.IStudentService;
import org.springframework.beans.factory.annotation.Autowired;
import  com.datababy.Entity.Student;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import java.util.ArrayList;
import java.util.List;

@Service
public class StudentService implements IStudentService {

    @Autowired
    private StudentDaoRepository studentDaoRepository;

    /**
     * 添加学生
     * @param student
     * @return
     */
    public Student addStudent(Student student){
        return studentDaoRepository.save(student);
    }

    /**
     * 更新学生
     * @param student
     * @return
     */
    public Student updateStudent(Student student){
        return studentDaoRepository.save(student);
    }



    /**
     * 删除
     * @param userId
     */
    public void deleteStudent(Integer userId){
        studentDaoRepository.delete(userId);
    }



    /**
     * //分页查询
     * @param pageable
     * @return Page<Student>
     */
    public Page<Student> getStudents1(Pageable pageable){
       return studentDaoRepository.findAll(pageable);
    }

    /**
     * 分页查询（根据学生姓名,id,学院,专业）
     * @param  pageParm
     * @return
     */
    public Page<Student> pageStudentName(PageParm pageParm){

        Specification<Student> specification=new Specification<Student>() {
            @Override
            public Predicate toPredicate(Root<Student> root, CriteriaQuery<?> criteriaQuery, CriteriaBuilder cb) {
                List<Predicate> predicates=new ArrayList<>();
                if(null != pageParm.getId()){ //添加断言
                    Predicate likeId = cb.like(root.get("id").as(String.class),"%"+pageParm.getId()+"%");
                    predicates.add(likeId);
                }if (null != pageParm.getUser_name()){
                    Predicate likeName =cb.like(root.get("user_name").as(String.class),"%"+pageParm.getUser_name()+"%");
                    predicates.add(likeName);
                }if (null !=pageParm.getMajor()){
                    Predicate likeMajor=cb.like(root.get("major").as(String.class),"%"+pageParm.getMajor()+"%");
                    predicates.add(likeMajor);
                }


            return cb.and(predicates.toArray(new Predicate[0]));
            }
        };
        Sort sort=new Sort(Sort.Direction.ASC,"id");
        Pageable pageable=new PageRequest(pageParm.getPage(),pageParm.getSize(),sort);
        return this.studentDaoRepository.findAll(specification,pageable);
    }

    /**
     * //查询所有
     * @return List<Student>
     */
    public List<Student> getStudents(){
        return studentDaoRepository.findAll();
    }

    /**
     * //查询根据id单个
     * @param userId
     * @return Student
     */
    public Student getStudentById(Integer userId){
        return  studentDaoRepository.findOne(userId);
    }
}
