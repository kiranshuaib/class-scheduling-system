package io.pragra.learning.classscheduling.controller;

import io.pragra.learning.classscheduling.entity.Schedule;
import io.pragra.learning.classscheduling.service.ScheduleService;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
public class ScheduleController {
   private ScheduleService service;

    public ScheduleController(ScheduleService service) {
        this.service = service;
    }

    @GetMapping("/schedules")
    public List<Schedule> getAll(){
        return this.service.listAll();
    }


    @GetMapping("/schedules/{id}")
    public Schedule getById(@PathVariable UUID id){
        return this.service.getById(id);
    }


    @PostMapping("/schedules")
    public Schedule saveSchedule(@RequestBody Schedule schedule){
        return this.service.saveSchedule(schedule);
    }

    @DeleteMapping("/schedules/{id}")
    public void deleteById(@PathVariable UUID id){
        this.service.deleteById(id);

    }

}
