package io.pragra.learning.classscheduling.entity;

import javax.persistence.*;
import java.util.List;

@Table
public class Batch {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    public Batch() {
    }

    @OneToMany(targetEntity = Schedule.class,cascade = CascadeType.ALL)
    private List<Schedule> batchList;


    public Batch(List<Schedule> batchList) {
        this.batchList = batchList;
    }

}
