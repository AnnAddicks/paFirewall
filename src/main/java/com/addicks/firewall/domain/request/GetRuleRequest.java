package com.addicks.firewall.domain.request;

public class GetRuleRequest extends AbstractApiRequest {

  public String getURL() {
    return "type=config&action=get&key="
        + getCredentials()
        + "&xpath=/config/devices/entry[@name='localhost.localdomain']/vsys/entry[@name='vsys1']/rulebase";
  }

  @Override
  public Class<?> getResponseClass() {
    // TODO return GetRuleResponse.class;
    return null;
  }

}
