package com.addicks.firewall.domain.request;

import com.addicks.firewall.domain.response.get.rules.GetRuleResponse;

public class GetRuleRequest implements IApiRequest {

  public String getURL() {
    return "&type=config&action=get&xpath=/config/devices/entry[@name='localhost.localdomain']/vsys/entry[@name='vsys1']/rulebase/security/rules";
  }

  @Override
  public Class<?> getResponseClass() {
    return GetRuleResponse.class;
  }

}
