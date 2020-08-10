package io.pragra.learning.classscheduling.controller;

import io.pragra.learning.classscheduling.Repo.ScheduleRepo;
import io.pragra.learning.classscheduling.entity.Schedule;
import io.pragra.learning.classscheduling.service.ScheduleService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ScheduleController {
   private ScheduleService service;

    public ScheduleController(ScheduleService service) {
        this.service = service;
    }

    @GetMapping("/schedule")
    public List<Schedule> getAll(){
        return this.service.listAll();
    }


    @GetMapping("/schedule/{id}")
    public List<Schedule> getAllById(Integer id){
        return this.service.getAllById(id);
    }


    @PostMapping("/schedule")
    public Schedule saveSchedule(@RequestBody Schedule schedule){
        return this.service.saveSchedule(schedule);
    }


}