package com.addicks.firewall;

import org.springframework.scheduling.annotation.Scheduled;

import com.addicks.firewall.manager.IResetRulesService;

public class ServiceScheduler {

  private static IResetRulesService resetRulesService;

  /**
   * Test when cron isn't running
   * 
   * @param args
   */
  public static final void main(String[] args) {
    // TODO Auto-generated method stub

    ServiceScheduler.withdrawWeekly();
  }

  /**
   * Run this service at 7am on Mondays
   */
  @Scheduled(cron = "0 0 7 * * MON")
  public static final void withdrawWeekly() {
    resetRulesService.resetRules();
  }
}
