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
    // TODO Auto-generated method stub

    // 1. Get all the rules and counts
    List<Rule> ruleResponse = apiCall.getRules(new GetRuleRequest());

    // 3. rename all the rules

    // 4. rename all the rules back

    // 5. commit
  }

}
