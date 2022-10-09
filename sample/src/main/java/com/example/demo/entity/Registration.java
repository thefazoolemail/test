package com.example.demo.entity;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;

@Getter @Setter
@Entity
public class Registration  implements Serializable {
    @Transient
    private long serialVersionUID = 5495164248139949958L;

    @Id
    private long id;

    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private Student student;

    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private Course course;

    public Registration() {}

    public Registration(Student student, Course course) {
        this.course = course;
        this.student = student;
        this.id = 1;
    }
}
