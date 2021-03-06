package io.pragra.learning.classscheduling;

import io.pragra.learning.classscheduling.entity.*;
import io.pragra.learning.classscheduling.service.ScheduleService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.Arrays;

@SpringBootApplication
public class ClassSchedulingSystemApplication {
    private ScheduleService service;

    public ClassSchedulingSystemApplication(ScheduleService service) {
        this.service = service;
    }

    public static void main(String[] args) {
        SpringApplication.run(ClassSchedulingSystemApplication.class, args);
    }

    @Bean
    CommandLineRunner runner(){
        return args -> {

          Program program1 = new Program(2389732L);
          Instructor instructor1 = new Instructor("Atin Singh","","https://pragra.gumlet.net/Atin.png");
          Instructor instructor2 = new Instructor("Vivek","","https://pragra.gumlet.net/Vivek.png");
          Batch batch1 = new Batch( Arrays.asList( "Saturday - 9:30 AM - 12:30 PM EST",
                  "Wednesday - 8:30 PM - 10:30 PM EST") ,Type.WEEKDAYS,Arrays.asList("Saturday",
                  "Wednesday"), Status.UPCOMING,instructor1,"Sep 15th, 2020" );
          Batch batch2 = new Batch(Arrays.asList( "Saturday - 9:30 AM - 12:30 PM EST",
                  "Wednesday - 8:30 PM - 10:30 PM EST",
                  "Thursday - 8:30 PM - 10:30 PM EST") ,Type.WEEKEND,Arrays.asList("Saturday",
                  "Wednesday","Thursday"), Status.ONGOING,instructor2, "Aug 15th, 2020");

            Schedule schedule1 = new Schedule(program1.getProgramId(),batch1,null,null,null,null);
            Schedule schedule2 = new Schedule(program1.getProgramId(), batch2,null,null,null,null );


            this.service.saveSchedule(schedule1);
            this.service.saveSchedule(schedule2);
            program1.setSchedules(Arrays.asList(schedule1,schedule2));





        };
    }
}
