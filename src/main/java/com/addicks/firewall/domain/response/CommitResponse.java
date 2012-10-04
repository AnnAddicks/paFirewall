package com.addicks.firewall.domain.response;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;

import org.eclipse.persistence.oxm.annotations.XmlPath;

@XmlRootElement(name = "response")
@XmlAccessorType(XmlAccessType.FIELD)
public class CommitResponse implements IApiResponse {

  @XmlPath("result/msg/line")
  private String message;

  public CommitResponse() {

  }

  public String getMessage() {
    return message;
  }

  @Override
  public String toString() {
    return "CommitResponse [message=" + message + "]";
  }

}
