package com.addicks.firewall.domain.response.get.rules;

import java.util.List;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "rules")
public class Rules {

  List<Rule> rules;

  public List<Rule> getRules() {
    return rules;
  }

  public void setRules(List<Rule> rules) {
    this.rules = rules;
  }

  @Override
  public String toString() {
    return "Rules [rules=" + rules + "]";
  }

}
