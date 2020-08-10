package io.pragra.learning.classscheduling.service;

import io.pragra.learning.classscheduling.Repo.ScheduleRepo;
import io.pragra.learning.classscheduling.entity.Program;
import io.pragra.learning.classscheduling.entity.Schedule;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.Collections;
import java.util.List;

@Service
public class ScheduleService {

    private ScheduleRepo repo;

    public ScheduleService(ScheduleRepo repo) {
        this.repo = repo;
    }

    public Schedule createSchedule(Schedule schedule) {
        return this.repo.save(schedule);
    }

    public List<Schedule> listAll(){
        return this.repo.findAll();
    }

    public Schedule saveSchedule(Schedule schedule){
        return this.repo.save(schedule);
    }


    public List<Schedule> getAllById(Integer id){
        return this.repo.findAllById(Collections.singleton(id));
    }





}
