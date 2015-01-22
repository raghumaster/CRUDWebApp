/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.dao;

import com.model.Student;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 * Create the DAO Components
 * @author RaghuNandan
 */
@Stateless
public class StudentDao implements StudentDaoLocal {

    @PersistenceContext
    private EntityManager em;
    
    @Override
    public void addStudent(Student student) {
        System.out.println("DAO .. add");
        em.persist(student);
    }

    @Override
    public void editStudent(Student student) {
        System.out.println("DAO Edit");
        em.merge(student);
    }

    @Override
    public void deleteStudent(int studentId) {
        System.out.println("DAO delete...");
        em.remove(getStudent(studentId));
    }

    @Override
    public Student getStudent(int studentId) {
        System.out.println("Dao.. get student ... student Id:"+studentId);
        return em.find(Student.class, studentId);
    }

    @Override
    public List<Student> getAllStudents() {
        System.out.println("DAO : get all students ....");
        return em.createNamedQuery("Student.getAll").getResultList();
    }
    
    
    
}
