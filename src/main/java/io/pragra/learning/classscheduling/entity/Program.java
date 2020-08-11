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

    public Program(Long programId, List<Schedule> schedules) {
        this.programId = programId;
        this.schedules = schedules;
    }

    @OneToMany(targetEntity = Schedule.class,cascade = CascadeType.ALL)
    private List<Schedule> schedules;

    public Long getProgramId() {
        return programId;
    }

    public void setProgramId(Long programId) {
        this.programId = programId;
    }


    public List<Schedule> getSchedules() {
        return schedules;
    }

    public void setSchedules(List<Schedule> schedules) {
        this.schedules = schedules;
    }
}
