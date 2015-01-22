/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.model;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

/**
 * Model class in JPA Annotations
 * @author RaghuNandan
 */

@Entity
@Table
@NamedQueries(@NamedQuery(name="Student.getAll",query="SELECT e FROM Student e"))
public class Student implements Serializable {
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    @Column
    private int studentId;
    @Column
    private String firstname;
    @Column
    private String lastname;
    @Column
    private int yearLevel;

    public Student(){
        System.out.println("Student Default Constructor ..");
    }
    
    public Student(int studentId, String firstName, String lastName, int yearLevel) {
        System.out.println("Student Param constructor .....");
        this.studentId = studentId;
        this.firstname = firstName;
        this.lastname = lastName;
        this.yearLevel = yearLevel;
    }

    
    
    
    public int getStudentId() {
        return studentId;
    }

    public void setStudentId(int studentId) {
        System.out.println("Student Id setter ....");
        this.studentId = studentId;
    }

    public String getFirstname() {
        System.out.println("Student Id getter ...");
        return firstname;
    }

    public void setFirstname(String firstName) {
        this.firstname = firstName;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastName) {
        this.lastname = lastName;
    }

    public int getYearLevel() {
        return yearLevel;
    }

    public void setYearLevel(int yearLevel) {
        this.yearLevel = yearLevel;
    }
    
    
}
