package com.addicks.firewall.domain.request;

public abstract class AbstractApiRequest implements IApiRequest {

  private String credentials;

  protected String getCredentials() {
    return credentials;
  }

  protected void setCredentials(String credentials) {
    this.credentials = credentials;
  }
}
