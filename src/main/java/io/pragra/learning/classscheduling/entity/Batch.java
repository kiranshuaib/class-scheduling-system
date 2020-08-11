package io.pragra.learning.classscheduling.entity;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@Entity
@Table
public class Batch {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    @ElementCollection
    @CollectionTable(name="batchTime")
    private List<String> batchTime = new ArrayList<>();
    @Column
    private Type type;

    @ElementCollection
    @CollectionTable(name="Days")
    private List<String> days;
    @Column
    private Status status;


    @OneToOne(targetEntity = Instructor.class,cascade = CascadeType.ALL)
//    private List<Instructor> instructors;
    private Instructor instructor;
    @Column
    private String startDate;

    public Batch() {
    }


    public Batch(
                 List<String> batchTime,
                 Type type,
                 List<String> days,
                 Status status,
                 Instructor instructor,
                 String startDate) {
        this.batchTime = batchTime;
        this.type = type;
        this.days = days;
        this.status = status;
        this.instructor = instructor;
        this.startDate = startDate;
    }

    public List<String> getBatchTime() {
        return batchTime;
    }

    public void setBatchTime(String batchTime) {
        this.batchTime = Collections.singletonList(batchTime);
    }

    public void setBatchTime(List<String> batchTime) {
        this.batchTime = batchTime;
    }

    public Type getType() {
        return type;
    }

    public void setType(Type type) {
        this.type = type;
    }

    public List<String> getDays() {
        return days;
    }

    public void setDays(List<String> days) {
        this.days = days;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    public String getStartDate() {
        return startDate;
    }

    public void setStartDate(String startDate) {
        this.startDate = startDate;
    }


    public Instructor getInstructor() {
        return instructor;
    }

    public void setInstructor(Instructor instructor) {
        this.instructor = instructor;
    }
}
