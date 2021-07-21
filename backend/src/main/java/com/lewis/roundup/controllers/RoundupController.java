package com.lewis.roundup.controllers;

import com.lewis.roundup.classes.SavingsGoalCalculator;
import com.lewis.roundup.models.SavingsGoalInfo;
import com.lewis.roundup.repositories.SavingsGoalInfoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class RoundupController {

    @Autowired
    private SavingsGoalInfoRepository savingsGoalRepository;

    @Autowired
    private SavingsGoalCalculator savingsGoalCalculator;

    @GetMapping("/test")
    String test() {
        return "test";
    }

    @PostMapping("/savings_goal/create")
    SavingsGoalInfo createSavingsGoal() {
        return savingsGoalCalculator.calculate();
    }


}
