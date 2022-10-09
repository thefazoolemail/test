package com.example.demo.entity;


import lombok.Getter;
import lombok.Setter;
import org.springframework.data.jpa.domain.AbstractPersistable;
import org.springframework.data.util.ProxyUtils;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Getter @Setter
@Entity
public class Student implements Serializable {
    @Transient
    private long serialVersionUID = -5975254420151895542L;

    @Id
    private long id;

    private String name;

    private String rollNumber;


    @OneToMany(mappedBy = "student", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Registration> registrations = new ArrayList<>();

    public void addCourse(Course course) {
        Registration registration = new Registration(this, course);
        registrations.add(registration);
        course.getRegistrations().add(registration);
    }
}
