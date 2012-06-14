package com.addicks.firewall.domain.response.get.rules;

import java.util.List;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

import org.eclipse.persistence.oxm.annotations.XmlPath;

import com.addicks.firewall.domain.response.IApiResponse;

@XmlRootElement(name = "response")
@XmlType(propOrder = { "rules" })
@XmlAccessorType(XmlAccessType.FIELD)
public class GetRuleResponse implements IApiResponse {

  private List<Rule> rules;

  @XmlPath("result/rulebase/security/rules/entry")
  public List<Rule> getRules() {
    return rules;
  }

  public void setRules(List<Rule> rules) {
    this.rules = rules;
  }

  @Override
  public String toString() {
    return "GetRuleResponse [rules=" + rules + "]";
  }

}
