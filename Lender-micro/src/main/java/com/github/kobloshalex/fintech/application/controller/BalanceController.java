package com.github.kobloshalex.fintech.application.controller;

import com.github.kobloshalex.fintech.domain.entity.Money;
import com.github.kobloshalex.fintech.domain.service.BalanceService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("balance")
public class BalanceController {

  private final BalanceService balanceService;

  public BalanceController(BalanceService balanceService) {
    this.balanceService = balanceService;
  }

  @PostMapping("/topup")
  public void topUp(@RequestBody final Money money, @RequestHeader final String authorization) {
    balanceService.topUpBalance(money, authorization);
  }

  @PostMapping("/withdraw")
  public void withdraw(@RequestBody final Money money, @RequestHeader final String authorization) {
    balanceService.withdrawBalance(money, authorization);
  }
}
