package edu.application.api.students;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.SequenceGenerator;

import java.time.LocalDate;
import java.time.Period;

@Entity
public class Student {

    @Id
    @SequenceGenerator(name = "student_sequence", sequenceName = "student_sequence")
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "student_sequence")
    private Long id;
    private String name;

    @Column(unique = true)
    private String email;
    private LocalDate dayOfBirth;

    public Student() {
    }

    public Student(String name, String email, LocalDate dayOfBirth) {
        this.name = name;
        this.email = email;
        this.dayOfBirth = dayOfBirth;
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public LocalDate getDayOfBirth() {
        return dayOfBirth;
    }

    public int getAge() {
        return Period.between(dayOfBirth, LocalDate.now()).getYears();
    }

    public String getEmail() {
        return email;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setDayOfBirth(LocalDate dayOfBirth) {
        this.dayOfBirth = dayOfBirth;
    }

    @Override
    public String toString() {
        return "Student{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", email='" + email + '\'' +
                ", dayOfBirth=" + dayOfBirth +
                '}';
    }
}
