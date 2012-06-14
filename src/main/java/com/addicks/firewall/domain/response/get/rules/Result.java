package com.addicks.firewall.domain.response.get.rules;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlRootElement(name = "result")
public class Result {

  private RuleBase rulebase;

  public RuleBase getRulebase() {
    return rulebase;
  }

  public void setRulebase(RuleBase rulebase) {
    this.rulebase = rulebase;
  }

  @Override
  public String toString() {
    return "Result [rulebase=" + rulebase + "]";
  }

}
