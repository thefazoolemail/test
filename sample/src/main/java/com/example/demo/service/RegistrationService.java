package com.example.demo.service;

import com.example.demo.entity.Course;
import com.example.demo.entity.Registration;
import com.example.demo.entity.Student;
import com.example.demo.repository.CourseRepository;
import com.example.demo.repository.RegistrationRepository;
import com.example.demo.repository.StudentRepository;
import com.sun.xml.internal.ws.developer.Serialization;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
@Transactional
public class RegistrationService {
    @Autowired
    StudentRepository studentRepository;

    @Autowired
    CourseRepository courseRepository;

    @Autowired
    RegistrationRepository registrationRepository;

    public void register() {
        Student s = new Student();
        s.setId(3l);
        s.setName("test");
        s.setRollNumber("123");
        //studentRepository.save(s);

        Course course = new Course();
        course.setId(2l);
        course.setName("test1");
        course.setDescription("test desc");
        //courseRepository.save(course);

        Registration registration = new Registration();
        registration.setId(1l);
        registration.setCourse(course);
        registration.setStudent(s);

        s.getRegistrations().add(registration);
        course.getRegistrations().add(registration);
        //registrationRepository.save(registration);
        studentRepository.save(s);
    }
}
