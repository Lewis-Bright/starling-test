package com.lewis.roundup.repositories;

import java.util.List;

import com.lewis.roundup.models.SavingsGoalInfo;
import org.springframework.data.repository.CrudRepository;

public interface SavingsGoalInfoRepository extends CrudRepository<SavingsGoalInfo, Long> {

    SavingsGoalInfo findById(long id);
}