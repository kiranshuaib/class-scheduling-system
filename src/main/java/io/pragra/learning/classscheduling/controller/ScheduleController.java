package io.pragra.learning.classscheduling.controller;

import io.pragra.learning.classscheduling.entity.Schedule;
import io.pragra.learning.classscheduling.service.ScheduleService;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

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
    public Optional<Schedule> getById(@PathVariable Integer id){
        return this.service.getById(id);
    }


    @PostMapping("/schedule")
    public Schedule saveSchedule(@RequestBody Schedule schedule){
        return this.service.saveSchedule(schedule);
    }

    @DeleteMapping("/schedule/{id}")
    public void deleteById(@PathVariable Integer id){
        this.service.deleteById(id);

    }

}
