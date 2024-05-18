package com.example.springboot.controller;

import com.example.springboot.bean.Student;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
public class StudentController {

    // student rest get api - http://localhost:8080/student
    // client gets the response in json format the restcontroller annotation converts java bean to json at client side
    @GetMapping("/student")
    public Student getStudent() {
        Student student = new Student(1, "abc", "abc");
        return student;
    }

    // student list rest get api - http://localhost:8080/students
    @GetMapping("/students")
    public List<Student> getStudents(){
        List<Student> studentList = new ArrayList();
        studentList.add(new Student(1,"abc1","abc1"));
        studentList.add(new Student(2,"abc2","abc2"));
        studentList.add(new Student(3,"abc3","abc3"));
        studentList.add(new Student(4,"abc4","abc4"));
        return studentList;
    }


    // student list rest get api - http://localhost:8080/student/1
    @GetMapping("/student/{id}")
    public Student getStudentById(@PathVariable int id){ // this annotation is used to bind template variable {id} to method argumnet

        //if template variable name is different then variable name then it will throw exception
        // to avoid this exception use @PathVariable("id") int studentId so it will map template name id with studentId
        Student student = new Student(id, "abc", "abc");
        return student;
    }

    // student list rest get api - http://localhost:8080/student/1/abc
    //we can pass multiple path variables
    //{fname} uri template variable
    @GetMapping("/student/{id}/{fname}")
    public Student getStudentByIdAndFirstName(@PathVariable int id,@PathVariable String fname){ // this annotation is used to bind template variable {id} to method argumnet

        //if template variable name is different then variable name then it will throw exception
        // to avoid this exception use @PathVariable("id") int studentId so it will map template name id with studentId
        Student student = new Student(id, fname, "abc");
        return student;
    }

    // student list rest get api - http://localhost:8080/student/query?id=1&fname=abc
    //request parameter with query param -- extract query param from request url @RequestParam
    @GetMapping("/student/query")
    public Student getStudentByIdAndFirstNameRequestParam(@RequestParam int id, @RequestParam String fname){ // this annotation is used to bind template variable {id} to method argumnet

        Student student = new Student(id, fname, "abc");
        return student;
    }

    //note request param annotation used to extract variable values from url
    //pathparam maps the query template variable to variable in java


    // 2 annotatipons to be used for postmapping and requestbody to map the json with java object
    // spring boot uses http message converter to convert the json into java
    @PostMapping("/student")
    @ResponseStatus(HttpStatus.CREATED) // to send custom status
    public String createStudent(@RequestBody Student student){
        return "student entity created";
    }

    //update existing response we use patch
    //http://localhost:8080/student/1/update
    @PatchMapping("/student/{id}/update")
    @ResponseStatus(HttpStatus.OK) // to send custom status
    public Student updateStudent(@PathVariable int id, @RequestBody Student student){
        return new Student(id,student.getFirstName(),student.getLastName());
    }

    //update existing response we use delere
    //http://localhost:8080/student/1/delete
    @DeleteMapping("/student/{id}/delete")
    @ResponseStatus(HttpStatus.OK) // to send custom status
    public String deleteStudent(@PathVariable int id){
        return "deleted student "+id;
    }

    //response entity class used to manipulate http responses
    // it represents whole response status code, body, headers,
    // student rest get api - http://localhost:8080/student
    // client gets the response in json format the restcontroller annotation converts java bean to json at client side
    @GetMapping("/student")
    public ResponseEntity<Student> getStudentResponseEntity() {
        Student student = new Student(1, "abc", "abc");
        return new ResponseEntity<>(student,HttpStatus.OK);
    }

    //response entity class used to manipulate http responses
    // it represents whole response status code, body, headers,
    // student rest get api - http://localhost:8080/student
    // client gets the response in json format the restcontroller annotation converts java bean to json at client side
    @GetMapping("/student")
    public ResponseEntity<Student> getStudentResponseEntityOKHeaderBodyMethod() {
        Student student = new Student(1, "abc", "abc");
        return ResponseEntity.ok().header("customheader","").body(student);
    }
}
