package io.pragra.learning.classscheduling.entity;

import javax.persistence.*;
import java.util.List;

@Entity
@Table
public class Program {
    @Id
//    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long programId;


    public Program() {
    }

    public Program(Long programId) {
        this.programId = programId;
    }

    public Long getProgramId() {
        return programId;
    }
//
//    @OneToMany
//    private List<Batch> batchList;

    public void setProgramId(Long programId) {
        this.programId = programId;
    }

}
