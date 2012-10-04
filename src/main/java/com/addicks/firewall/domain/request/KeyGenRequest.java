package com.addicks.firewall.domain.request;

import com.addicks.firewall.domain.response.ApiKeyResponse;

public class KeyGenRequest implements IApiRequest {

  private final String username;

  private final String password;

  public KeyGenRequest(String username, String password) {
    this.username = username;
    this.password = password;
  }

  @Override
  public String getURL() {
    return "type=keygen&user=" + username + "&password=" + password;
  }

  @Override
  public Class<?> getResponseClass() {
    return ApiKeyResponse.class;
  }

}
