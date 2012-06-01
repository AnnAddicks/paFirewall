package com.addicks.firewall.domain.response;

import java.util.List;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElementWrapper;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "response")
@XmlAccessorType(XmlAccessType.FIELD)
public class ApiKeyResponse implements IApiResponse {

  @XmlElementWrapper(name = "result")
  private List<String> key;

  public ApiKeyResponse() {

  }

  public String getKey() {
    if (key == null) {
      return "";
    }
    else {
      return key.get(0);
    }
  }

  @Override
  public String toString() {
    return "APIKeyResponse [key=" + key + "]";
  }
}
