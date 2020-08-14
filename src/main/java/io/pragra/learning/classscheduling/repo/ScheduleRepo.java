package io.pragra.learning.classscheduling.repo;

import io.pragra.learning.classscheduling.entity.Schedule;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface ScheduleRepo extends JpaRepository<Schedule, UUID> {




}
