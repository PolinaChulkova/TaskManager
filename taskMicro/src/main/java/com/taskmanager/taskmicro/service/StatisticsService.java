package com.taskmanager.taskmicro.service;

import com.taskmanager.taskmicro.dto.StatisticsDto;

import java.util.List;

public interface StatisticsService {
    List<Integer> getAllYearsTasksByUserId(long userId);
    List<StatisticsDto> getStatisticsByUserId(long userId, String period, int year);
    List<StatisticsDto> getStatisticsForAllYearsByUserId(long userId);
    List<StatisticsDto> getStatisticsForAllMonthsOfYearByUserId(long userId, int year);
}
