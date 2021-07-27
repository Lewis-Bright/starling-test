package com.lewis.roundup.models;

import java.util.List;

public class SavingsGoals {

    private List<SavingsGoal> savingsGoals;

    public SavingsGoals(List<SavingsGoal> savingsGoals) {
        this.savingsGoals = savingsGoals;
    }

    public List<SavingsGoal> getSavingsGoals() {
        return savingsGoals;
    }

    public void setSavingsGoals(List<SavingsGoal> savingsGoals) {
        this.savingsGoals = savingsGoals;
    }
}
