package io.pragra.learning.classscheduling.entity;

import javax.persistence.*;
import java.util.Collections;
import java.util.List;

@Entity
@Table
public class Schedule {
    private Long programId;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer scheduleId;

    @ElementCollection
    @CollectionTable(name="batchTime")
    private List<String> batchTime;
    @Column
    private Type type;

    @ElementCollection
    @CollectionTable(name="Days")
    private List<String> days;
    @Column
    private Status status;
    @Column
    private String startDate;



    public Schedule() {
    }

    @ManyToOne(targetEntity = Program.class,cascade = CascadeType.ALL)
    private Program program;

//    @OneToMany(targetEntity = Batch.class,cascade = CascadeType.ALL)
//    private List<Batch> batchList;

    @OneToOne(targetEntity = Instructor.class,cascade = CascadeType.ALL)
//    private List<Instructor> instructors;
    private Instructor instructor;




    public void setProgram(Program program) {
        this.program = program;
    }

    public Schedule(Long programId, List<String> batchTime, Type type, List<String> days, Status status, String startDate, Instructor instructor) {
        this.programId = programId;
        this.batchTime = batchTime;
        this.type = type;
        this.days = days;
        this.status = status;
        this.startDate = startDate;
        this.instructor = instructor;
    }

    //
//    public Schedule(Long programId, Integer scheduleId, List<String> batchTime, Type type, List<String> days, Status status, String startDate, Instructor instructor) {
//        this.programId = programId;
//        this.scheduleId = scheduleId;
//        this.batchTime = batchTime;
//        this.type = type;
//        this.days = days;
//        this.status = status;
//        this.startDate = startDate;
////        this.program = program;
//        this.instructor= instructor;
//    }

    public List<String> getBatchTime() {
        return batchTime;
    }

    public void setBatchTime(String batchTime) {
        this.batchTime = Collections.singletonList(batchTime);
    }

    public Long getProgramId() {
        return programId;
    }

    public void setProgramId(Long programId) {
        this.programId = programId;
    }

    public Integer getScheduleId() {
        return scheduleId;
    }

    public void setScheduleId(Integer scheduleId) {
        this.scheduleId = scheduleId;
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

//    public Program getProgram() {
//        return program;
//    }

    public Instructor getInstructor() {
        return instructor;
    }

    public void setInstructor(Instructor instructor) {
        this.instructor = instructor;
    }
}
