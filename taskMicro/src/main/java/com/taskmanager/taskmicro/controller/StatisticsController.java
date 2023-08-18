package com.taskmanager.taskmicro.controller;

import com.taskmanager.taskmicro.dto.StatisticsDto;
import com.taskmanager.taskmicro.service.impl.StatisticsService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/statistics")
@RequiredArgsConstructor
public class StatisticsController {

    private final StatisticsService statisticsService;

    @GetMapping("/all-years/{userId}")
    public ResponseEntity<List<Integer>> getAllYearsTasksByUserId(@PathVariable("userId") long userId) {
        return ResponseEntity.ok(statisticsService.getAllYearsTasksByUserId(userId));
    }

    @GetMapping("/{userId}")
    public ResponseEntity<List<StatisticsDto>> getStatisticsByUserId(@PathVariable("userId") long userId,
                                                                     @RequestParam String period,
                                                                     @RequestParam(required = false,
                                                                             defaultValue = "0") int year) {
        return ResponseEntity.ok(statisticsService.getStatisticsByUserId(userId, period, year));
    }
}
