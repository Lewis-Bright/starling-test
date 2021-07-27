package com.lewis.roundup.controllers;

import com.lewis.roundup.classes.RoundupCalculator;
import com.lewis.roundup.models.*;
import com.lewis.roundup.services.StarlingRestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class RoundupController {

    @Autowired
    private StarlingRestService starlingRestService;

    @Autowired
    private RoundupCalculator roundupCalculator;

    @CrossOrigin("http://localhost:3000")
    @PostMapping("/savings_goal/create")
    RoundupInfo createSavingsGoal(@RequestHeader("Authorization") String auth) {
        Accounts accounts = starlingRestService.getAccounts(auth);
        RoundupInfo roundupInfo = roundupCalculator.calculate(accounts.getFirst(), auth);
        CurrencyAmount savingAmount = new CurrencyAmount("GBP", roundupInfo.getTotalSavings().intValue());
        SavingsGoal savingsGoal = new SavingsGoal("Roundup", "GBP", savingAmount, "");
        starlingRestService.createSavingsGoal(accounts.getFirst(), savingsGoal, auth);
        return roundupInfo;
    }


}
