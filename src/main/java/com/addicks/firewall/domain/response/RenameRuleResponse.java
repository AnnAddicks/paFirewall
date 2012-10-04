package com.addicks.firewall.domain.response;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;

import org.eclipse.persistence.oxm.annotations.XmlPath;

@XmlRootElement(name = "response")
@XmlAccessorType(XmlAccessType.FIELD)
public class RenameRuleResponse {
  @XmlPath("/msg/line")
  private String message;

  public RenameRuleResponse() {

  }

  public String getMessage() {
    return message;
  }

  @Override
  public String toString() {
    return "RenameRuleResponse [message=" + message + "]";
  }
}
