package com.addicks.firewall.domain.response.get.rules;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlRootElement(name = "rulebase")
public class RuleBase {

  @XmlElement
  private Security security;

  public Security getSecurity() {
    return security;
  }

  public void setSecurity(Security security) {
    this.security = security;
  }

  @Override
  public String toString() {
    return "RuleBase [security=" + security + "]";
  }

}
