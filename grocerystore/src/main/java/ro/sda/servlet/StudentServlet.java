package ro.sda.servlet;

import ro.sda.model.Student;
import ro.sda.logic.StudentService;
import ro.sda.model.Student;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet( name = "StudentServlet", urlPatterns = "/Student" )
public class StudentServlet extends HttpServlet {

    private StudentService studentService = new StudentService();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Integer id = Integer.parseInt(request.getParameter("studentId"));
        Student student = studentService.getStudent(id);
        if(student != null) {
            request.setAttribute("student", student);
            RequestDispatcher view = request.getRequestDispatcher("studentFound.jsp");
            view.forward(request, response);
        } else {
            RequestDispatcher view = request.getRequestDispatcher("studentNotFound.jsp");
            view.forward(request, response);
        }
    }

    @Override
    protected  void doPost(HttpServletRequest request,HttpServletResponse response) throws ServletException, IOException {
        Integer studentId = Integer.parseInt(request.getParameter("studentId"));
        String studentsFirstName = (String) request.getParameter("studentsFirstName");
        String studentsLastName = (String) request.getParameter("studentsLastName");
        if(studentService.getStudent(studentId) == null){
            Student retrievedStudent = new Student(studentId,studentsFirstName,studentsLastName);
            studentService.addStudent(retrievedStudent);
            RequestDispatcher view = request.getRequestDispatcher("studentAddSuccess.jsp");
            view.forward(request, response);
        } else {
            RequestDispatcher view = request.getRequestDispatcher("studentAddFailed.jsp");
            view.forward(request, response);
        }
    }


}