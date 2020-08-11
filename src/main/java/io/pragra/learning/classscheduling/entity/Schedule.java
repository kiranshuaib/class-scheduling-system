package io.pragra.learning.classscheduling.entity;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.UUID;

@Entity
@Table
public class Schedule {
    private Long programId;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID scheduleId;

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
    @ManyToOne(targetEntity = Program.class,cascade = CascadeType.ALL)
    private Program program;

    @OneToOne(targetEntity = Instructor.class,cascade = CascadeType.ALL)
//    private List<Instructor> instructors;
    private Instructor instructor;
    @Column
    private String startDate;
    @Column
    private String createdBy;
    @Column
    private String createdDate;

    private String lastModifiedBy;

    private String lastModifiedDate;



    public Schedule() {
    }

    public Schedule(Long programId,
                    List<String> batchTime,
                    Type type,
                    List<String> days,
                    Status status,
                    Instructor instructor,
                    String startDate,
                    String createdBy,
                    String createdDate,
                    String lastModifiedBy,
                    String lastModifiedDate) {
        this.programId = programId;
        this.batchTime = batchTime;
        this.type = type;
        this.days = days;
        this.status = status;
        this.instructor = instructor;
        this.startDate = startDate;
        this.createdBy = createdBy;
        this.createdDate = createdDate;
        this.lastModifiedBy = lastModifiedBy;
        this.lastModifiedDate = lastModifiedDate;
    }

    public void setProgram(Program program) {
        this.program = program;
    }

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

    public UUID getScheduleId() {
        return scheduleId;
    }

    public void setScheduleId(UUID scheduleId) {
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
