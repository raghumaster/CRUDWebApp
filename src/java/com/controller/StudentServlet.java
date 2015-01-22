/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.controller;

import com.dao.StudentDaoLocal;
import com.model.Student;
import java.io.IOException;
import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author RaghuNandan
 */
@WebServlet(name = "StudentServlet", urlPatterns = {"/StudentServlet"})
public class StudentServlet extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @EJB
    private StudentDaoLocal studentDao;
    
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
       
        System.out.println("Student Servlet :  Process Request .....");
        
        String action = request.getParameter("action");
        String studentIdString = request.getParameter("studentId");
//        int studentId = studentIdString.equals("") ? 0 : Integer.parseInt(studentIdString);
        int studentId = 0;
        if(studentIdString !=null && studentIdString.equals(""))
            studentId = Integer.parseInt(studentIdString);
        
        String firstName = request.getParameter("firstname");
        String lastName = request.getParameter("lastname");
        String yearLevelStr = request.getParameter("yearLevel");
        int yearLevel = 0;
        if(yearLevelStr !=null && yearLevelStr.equals(""))
            yearLevel = Integer.parseInt(yearLevelStr);
        
        Student student = new Student(studentId, firstName, lastName, yearLevel);
        
        if("Add".equalsIgnoreCase("action")){
            System.out.println("Student Servlet : Add button");
            studentDao.addStudent(student);
        }
        else if ("Edit".equalsIgnoreCase("action")){
            System.out.println("Student Servlet : Edit Button");
            studentDao.editStudent(student);
        }
        else if("Delete".equalsIgnoreCase("action")){
            System.out.println("Student Servlet : Delete ");
            studentDao.deleteStudent(studentId);
        }
        else if("Search".equalsIgnoreCase("action")){
            System.out.println("Student Servlet : Search");
            student =  studentDao.getStudent(studentId);
        }
        
        request.setAttribute("student", student);
        request.setAttribute("allstudent", studentDao.getAllStudents());
        request.getRequestDispatcher("studentinfo.jsp").forward(request, response);
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
