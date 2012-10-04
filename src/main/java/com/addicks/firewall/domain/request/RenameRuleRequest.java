package com.addicks.firewall.domain.request;

import com.addicks.firewall.domain.response.RenameRuleResponse;

public class RenameRuleRequest implements IApiRequest {

  private String oldName;

  private String newName;

  public RenameRuleRequest(String oldName, String newName) {
    this.oldName = oldName;
    this.newName = newName;
  }

  @Override
  public String getURL() {
    return "&type=config&action=rename&xpath=/config/devices/entry[@name='localhost.localdomain']/vsys/entry[@name='vsys1']/rulebase/security/rules/entry[@name="
        + oldName + "]&%20newname=" + newName;
  }

  @Override
  public Class<?> getResponseClass() {
    return RenameRuleResponse.class;
  }

}
