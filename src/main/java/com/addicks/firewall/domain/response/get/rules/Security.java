package com.addicks.firewall.domain.response.get.rules;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "security")
public class Security {

  private Rules rules;

  public Rules getRules() {
    return rules;
  }

  public void setRules(Rules rules) {
    this.rules = rules;
  }

  @Override
  public String toString() {
    return "Security [rules=" + rules + "]";
  }

}
