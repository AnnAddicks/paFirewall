package com.addicks.firewall;

import com.addicks.firewall.manager.IResetRulesService;
import com.addicks.firewall.manager.PropertiesModule;
import com.addicks.firewall.manager.ResetRulesService;
import com.google.inject.Guice;
import com.google.inject.Inject;
import com.google.inject.Injector;
import com.google.inject.Module;

public class ServiceScheduler {

  @Inject
  private static IResetRulesService resetRulesService;

  /**
   * Test when cron isn't running
   * 
   * @param args
   */
  public static final void main(String[] args) {
    Module propertiesMoudule = new PropertiesModule();
    Injector injector = Guice.createInjector(propertiesMoudule);

    // Create a new injections
    IResetRulesService resetRulesService = injector.getInstance(ResetRulesService.class);

    resetRulesService.resetRules();
  }

  /**
   * Run this service at 7am on Mondays
   */
  // @Scheduled(cron = "0 0 7 * * MON")
  public static final void resetRules() {
    resetRulesService.resetRules();
  }
}
