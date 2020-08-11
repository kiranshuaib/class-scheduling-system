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

    @ManyToOne(targetEntity = Batch.class,cascade = CascadeType.ALL)
    private Batch batch;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID id;

    @ManyToOne(targetEntity = Program.class,cascade = CascadeType.ALL)
    private Program program;

    @Column
    private String createdBy;
    @Column
    private String createdDate;
    @Column
    private String lastModifiedBy;
    @Column
    private String lastModifiedDate;



    public Schedule() {
    }

    public Schedule(Long programId,
                    Batch batch,
                    String createdBy,
                    String createdDate,
                    String lastModifiedBy,
                    String lastModifiedDate) {
        this.programId = programId;
        this.batch = batch;
        this.createdBy = createdBy;
        this.createdDate = createdDate;
        this.lastModifiedBy = lastModifiedBy;
        this.lastModifiedDate = lastModifiedDate;
    }



    //
//    public Schedule(Long programId,
//                    List<String> batchTime,
//                    Type type,
//                    List<String> days,
//                    Status status,
//                    Instructor instructor,
//                    String startDate,
//                    String createdBy,
//                    String createdDate,
//                    String lastModifiedBy,
//                    String lastModifiedDate) {
//        this.programId = programId;
//        this.batchTime = batchTime;
//        this.type = type;
//        this.days = days;
//        this.status = status;
//        this.instructor = instructor;
//        this.startDate = startDate;
//        this.createdBy = createdBy;
//        this.createdDate = createdDate;
//        this.lastModifiedBy = lastModifiedBy;
//        this.lastModifiedDate = lastModifiedDate;
//    }





    public Batch getBatch() {
        return batch;
    }

    public void setBatch(Batch batch) {
        this.batch = batch;
    }


    public String getCreatedBy() {
        return createdBy;
    }

    public void setCreatedBy(String createdBy) {
        this.createdBy = createdBy;
    }

    public String getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(String createdDate) {
        this.createdDate = createdDate;
    }

    public String getLastModifiedBy() {
        return lastModifiedBy;
    }

    public void setLastModifiedBy(String lastModifiedBy) {
        this.lastModifiedBy = lastModifiedBy;
    }

    public String getLastModifiedDate() {
        return lastModifiedDate;
    }

    public void setLastModifiedDate(String lastModifiedDate) {
        this.lastModifiedDate = lastModifiedDate;
    }

    public Long getProgramId() {
        return programId;
    }

    public void setProgramId(Long programId) {
        this.programId = programId;
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }




}
