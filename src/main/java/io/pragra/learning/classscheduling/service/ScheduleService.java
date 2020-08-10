package io.pragra.learning.classscheduling.service;

import io.pragra.learning.classscheduling.Repo.ScheduleRepo;
import io.pragra.learning.classscheduling.entity.Schedule;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ScheduleService {

    private ScheduleRepo repo;

    public ScheduleService(ScheduleRepo repo) {
        this.repo = repo;
    }

    public List<Schedule> listAll(){
        return this.repo.findAll();
    }

    public Schedule saveSchedule(Schedule schedule){
        return this.repo.save(schedule);
    }


    public Optional<Schedule> getById(Integer id){
        return this.repo.findById(id);
    }

    public Integer deleteById(Integer id){
        if(id != null) {
            this.repo.deleteById(id);
            return 1;
        }
        else return 0;

    }





}
