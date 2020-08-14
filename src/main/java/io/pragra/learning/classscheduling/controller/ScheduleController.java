package io.pragra.learning.classscheduling.controller;

import io.pragra.learning.classscheduling.entity.Schedule;
import io.pragra.learning.classscheduling.exception.BadRequestException;
import io.pragra.learning.classscheduling.service.ScheduleService;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
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
    public ResponseEntity<List<?>> getAll(){
        return ResponseEntity
                .status(HttpStatus.OK)
                .body(service.listAll());
    }


    @GetMapping("/schedules/{id}")
    public ResponseEntity<?> getById(@PathVariable UUID id) {
       if (id == null || id.equals(0)) {
           throw new BadRequestException(String.format("No data found for %s,id"));
        }
            return ResponseEntity.status(HttpStatus.OK).body(this.service.getById(id));

    }



    @PostMapping("/schedules")
    public ResponseEntity<?> saveSchedule(@RequestBody Schedule schedule){
        return ResponseEntity.status(HttpStatus.ACCEPTED).body(service.saveSchedule(schedule));

    }

    @DeleteMapping("/schedules/{id}")
    public ResponseEntity<?> deleteById(@PathVariable UUID id) {
        if (id == null || id.equals(0)) {
            throw new BadRequestException(String.format("No data found for %s,id"));
        }
        this.service.deleteById(id);
        return ResponseEntity
                .status(200).body(null);
    }

    @PutMapping("/schedules")
    public ResponseEntity<?> updateSchedule(@RequestBody Schedule schedule){
        return ResponseEntity
                .status(HttpStatus.ACCEPTED)
                .body(service.saveSchedule(schedule));

    }


}
