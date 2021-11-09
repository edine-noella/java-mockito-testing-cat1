package com.example.junittest.services;


import com.example.junittest.models.Student;
import com.example.junittest.repository.StudentRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.ArgumentMatchers;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.Arrays;
import java.util.Optional;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.*;

@RunWith(MockitoJUnitRunner.class)
public class StudentServicesTest {

    @Mock
    StudentRepository studentRepository;

    @InjectMocks
    StudentService studentService;


    @Test
    public void returnStudents(){
        when(studentRepository.findAll()).thenReturn(Arrays.asList(new Student(1,"Annabelle","Transsexual Woman"),new Student(2,"Peace","Cis"),new Student(3,"Nicole","Other")));
        assertEquals("Other",studentService.getAllStudents().get(2).getGender());
    }

    @Test
    public  void createStudent(){
        when(studentRepository.save(ArgumentMatchers.any(Student.class))).thenReturn(new Student(1,"Annabelle","Transsexual Woman"));
        assertEquals("Transsexual Woman",studentService.createStudent("Didier","Male",4).getGender());
//        assertEquals("Male",studentService.createStudent("Didier","Male",4).getGender());
    }
    @Test
    public void deleteStudent(){
        Student st = new Student(5,"Chanelle","Female");
        when(studentRepository.findById(st.getId())).thenReturn(Optional.of(st));

        studentService.deleteStudent(st.getId());

        verify(studentRepository).deleteById(st.getId());

    }

    @Test
    public void updateStudent(){
        Student st = new Student(6,"Loraine","Female");
        Student newST = new Student("Mukezwa","Female to male transgender woman");
        given(studentRepository.findById(st.getId())).willReturn(Optional.of(st));

        studentService.updateStudent(st.getId(),newST);
        verify(studentRepository).save(newST);
        verify(studentRepository).findById(st.getId());
    }

    @Test
    public void returnStudent(){
        Student student = new Student();
        student.setId(2);

        when(studentRepository.findById(student.getId())).thenReturn(Optional.of(student));

        Student expected = studentService.detailStudent(student.getId());

        assertThat(expected).isSameAs(student);

        verify(studentRepository).findById(student.getId());
    }

}
