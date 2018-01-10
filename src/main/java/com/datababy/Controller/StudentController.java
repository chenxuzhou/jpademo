package com.datababy.Controller;

import com.alibaba.fastjson.JSON;
import com.datababy.Entity.PageParm;
import com.datababy.Entity.Student;
import com.datababy.Service.IStudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class StudentController {

    @Autowired
    IStudentService iStudentService;


    /**
     * //添加学生
     * @param student
     * @return Student
     */
    @PostMapping("/addStudent")
    public Student addStudent(@RequestBody Student student){
        // 1、 将javabean转化成json字符串
        String jsonString = JSON.toJSONString(student);
        System.out.println(jsonString);
        // 2、将json字符串转化成javabean对象
        student = JSON.parseObject(jsonString, Student.class);
        return iStudentService.addStudent(student);
    }

    /**
     *  //更新学生信息
     * @param student
     * @return Student
     */
    @PostMapping("/updateStudent")
    public Student updateStudent(@RequestBody Student student){
        // 1、 将javabean转化成json字符串
        String jsonString = JSON.toJSONString(student);
        System.out.println(jsonString);
        // 2、将json字符串转化成javabean对象
        student = JSON.parseObject(jsonString, Student.class);
        System.out.println(student);
        return iStudentService.updateStudent(student);
    }

    /**
     * //删除学生信息
     * @param userId
     */
    @RequestMapping("deleteStudent/{id}")
    public void deleteStudent(@PathVariable("id") Integer userId){
        iStudentService.deleteStudent(userId);

    }


    /**
     *带参查询分页
     *  @param   pageParm
     * @return Page<Student>
     */
//    @PostMapping("/pageQuery")
//    public Page<Student> queryPageStudents(@RequestBody PageParm pageParm){
//
//        Sort sort=new Sort(Sort.Direction.ASC,"id");
//        Pageable pageable=new PageRequest(pageParm.getPage(),pageParm.getSize(),sort);
//            if ("".equals(pageParm.getName())&&
//                "".equals(pageParm.getCollege())&&
//                "".equals(pageParm.getCollege())&&
//                "".equals(pageParm.getId())||
//                    pageParm.getId()==null&&
//                    pageParm.getMajor()==null&&
//                    pageParm.getCollege()==null &&
//                    pageParm.getName()==null){
//            return iStudentService.getStudents1(pageable);
//        }else{
//            return iStudentService.pageStudentName(pageParm,pageable);
//        }
//  }

    @PostMapping("/pageQuery")
    public Page<Student> queryPageStudents( @RequestParam(value = "page",defaultValue = "0") Integer page,
                                            @RequestParam(value = "size",defaultValue = "5") Integer size,
                                            PageParm pageParm) {

                    Sort sort=new Sort(Sort.Direction.ASC,"id");
                    Pageable pageable=new PageRequest((page/size),size,sort);

            return iStudentService.pageStudentName(pageParm,pageable);
                    }






    /**
     * //查询所有学生信息
     * @return List<Student>
     */
    @GetMapping("/getStudents")
    @ResponseBody
    public List<Student> getStudents(){
        return  iStudentService.getStudents();
    }


    /**
     * 根据id 查询学生信息
     * @param userId
     * @return Student
     */
    @GetMapping("/getStudent")
    public Student getOne(@RequestParam("userId") Integer userId){
//            String userid=JSON.toJSONString(userId);
//            Integer id=Integer.parseInt(userid);
        return  iStudentService.getStudentById(userId);

    }


}
