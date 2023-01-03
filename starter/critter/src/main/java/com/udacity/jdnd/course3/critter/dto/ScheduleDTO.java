package com.udacity.jdnd.course3.critter.dto;

import java.time.LocalDateTime;
import java.util.List;

public class ScheduleDTO {
    private Long id;
    private List<Long> employeeId;
    private List<Long> petId;
    private Set<Skills> skills;
    private LocalDateTime localDateTime;

}
