package com.addicks.firewall.manager;

import com.addicks.firewall.domain.request.GetRuleRequest;
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
    apiCall.execute(new GetRuleRequest());

    // 2. Save the current rules and count

    // 3. rename all the rules

    // 4. rename all the rules back

    // 5. commit
  }

}
