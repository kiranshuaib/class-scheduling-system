package io.pragra.learning.classscheduling.service;

import io.pragra.learning.classscheduling.repo.ScheduleRepo;
import io.pragra.learning.classscheduling.entity.Schedule;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

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


    public Schedule getById(UUID id){
        return this.repo.findById(id)
                .orElseThrow(()->new RuntimeException("Invalid Id or No Data"));
    }

    public Integer deleteById(UUID id){
        if(id != null) {
            this.repo.deleteById(id);
            return 1;
        }
        return 0;



    }





}
