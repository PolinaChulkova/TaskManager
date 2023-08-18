package com.taskmanager.taskmicro.service.impl;

import com.taskmanager.taskmicro.dto.StatisticsDto;
import com.taskmanager.taskmicro.repository.TaskRepository;
import com.taskmanager.taskmicro.service.StatisticsService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.YearMonth;
import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class StatisticsServiceImpl implements StatisticsService {

    private final TaskRepository taskRepository;

    @Override
    public List<Integer> getAllYearsTasksByUserId(long userId) {
        return taskRepository.getAllYearsTasksByUserId(userId);
    }

    @Override
    public List<StatisticsDto> getStatisticsByUserId(long userId, String period, int year) {
        if (period.equals("years")) return getStatisticsForAllYearsByUserId(userId);
        else if (period.equals("months")) return getStatisticsForAllMonthsOfYearByUserId(userId, year);
        else return null; //Добавить исключение
    }

    @Override
    public List<StatisticsDto> getStatisticsForAllYearsByUserId(long userId) {
        List<Integer> allYears = getAllYearsTasksByUserId(userId);
        List<StatisticsDto> statistics = new ArrayList<>(allYears.size());
        for (Integer year : allYears) {
            statistics.add(new StatisticsDto(
                    YearMonth.of(year, 1).atDay(1),
                    YearMonth.of(year, 12).atDay(31),
                    taskRepository.countAllByUserId(userId),
                    taskRepository.countAllByUserIdAndStatus(userId, true),
                    taskRepository.countAllByUserIdAndStatus(userId, false)
                    ));
        }
        return statistics;
    }

    @Override
    public List<StatisticsDto> getStatisticsForAllMonthsOfYearByUserId(long userId, int year) {
        List<StatisticsDto> statisticsForAllMonthOfYear = new ArrayList<>(12);
        for(int month = 1; month <= 12; month++) {
            statisticsForAllMonthOfYear.add(new StatisticsDto(
                    YearMonth.of(year, month).atDay(1),
                    YearMonth.of(year, month).atDay(YearMonth.of(year, month).lengthOfMonth()),
                    taskRepository.countAllByUserIdAndMonth(userId, year, month),
                    taskRepository.countTasksByUserIdAndMonthAndStatus(userId, year, month, true),
                    taskRepository.countTasksByUserIdAndMonthAndStatus(userId, year, month, false)

            ));
        }
        return statisticsForAllMonthOfYear;
    }
}
