package com.addicks.firewall.manager;

import java.util.List;

import com.addicks.firewall.domain.request.GetRuleRequest;
import com.addicks.firewall.domain.response.get.rules.Rule;
import com.addicks.firewall.manager.apiCall.IApiCall;
import com.google.inject.Inject;

public class ResetRulesService implements IResetRulesService {

  private IApiCall apiCall;

  @Inject
  public ResetRulesService(IApiCall apiCall) {
    this.apiCall = apiCall;
  }

  @Override
  public void resetRules() {
    // Get all the rules and counts
    List<Rule> rules = apiCall.getRules(new GetRuleRequest());

    // Rename all the rules
    apiCall.resetRules(rules);
  }

}
