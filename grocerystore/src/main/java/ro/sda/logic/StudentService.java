package ro.sda.logic;

import ro.sda.model.Student;

import java.util.HashSet;
import java.util.Set;

public class StudentService {

    private Set<Student> students = new HashSet<Student>();

    public void addStudent(Student student) {
        if(students.isEmpty()) {
            students.add(student);
            return;
        }

        for (Student s : students) {
            if (s.getId() == student.getId()) {
                throw new IllegalArgumentException("Student already exists!");
            }
        }
        students.add(student);
    }

    public Student getStudent(Student student) {
        for (Student s : students) {
            if (s.getId() == student.getId()) {
                return s;
            }
        }
        return  null;
    }

    public Student getStudent(int id) {
        for (Student s : students) {
            if (s.getId() == id) {
                return s;
            }
        }
        return null;
    }

    public void updateStudent(Student student) {
        for (Student s : students) {
            if (s.getId() == student.getId()) {
                s = student;
            } else {
                addStudent(student);
            }
        }
    }

    public void deleteStudent(Student student) {
        for (Student s : students) {
            if (s.getId() == student.getId()) {
                students.remove(s);
            }
        }
    }
}
