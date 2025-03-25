package com.example.demo.student;

import java.time.LocalDate;

import jakarta.annotation.Generated;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;

@Entity
@Table
public class Student {
    @Id
    @SequenceGenerator(
        name = "student_sequence",
        sequenceName = "student_sequence",
        allocationSize = 1
    )

    @GeneratedValue(
        strategy = GenerationType.SEQUENCE,
        generator =  "student_sequence"
    )
    private Long student_id;
    private String first_name;
    private String last_name;
    private LocalDate dob;
    private String class_of_student;
    private Integer score;
    private Integer status;
    private String photo_path;

    public Student(){};
    public Student(
        Long student_id,
        String first_name,
        String last_name,
        LocalDate dob,
        String class_of_student,
        Integer score,
        Integer status,
        String photo_path
    ) {
        this.student_id = student_id;
        this.first_name = first_name;
        this.last_name = last_name;
        this.dob = dob;
        this.class_of_student = class_of_student;
        this.score = score;
        this.status = status;
        this.photo_path = photo_path;
    }
    public Long getStudent_id() {
        return student_id;
    }
    public void setStudent_id(Long student_id) {
        this.student_id = student_id;
    }
    public String getFirst_name() {
        return first_name;
    }
    public void setFirst_name(String first_name) {
        this.first_name = first_name;
    }
    public String getLast_name() {
        return last_name;
    }
    public void setLast_name(String last_name) {
        this.last_name = last_name;
    }
    public LocalDate getDob() {
        return dob;
    }
    public void setDob(LocalDate dob) {
        this.dob = dob;
    }
    public String getClass_of_student() {
        return class_of_student;
    }
    public void setClass_of_student(String class_of_student) {
        this.class_of_student = class_of_student;
    }
    public Integer getScore() {
        return score;
    }
    public void setScore(Integer score) {
        this.score = score;
    }
    public Integer getStatus() {
        return status;
    }
    public void setStatus(Integer status) {
        this.status = status;
    }
    public String getPhoto_path() {
        return photo_path;
    }
    public void setPhoto_path(String photo_path) {
        this.photo_path = photo_path;
    }
 
}
