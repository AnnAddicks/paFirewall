package com.addicks.firewall.domain.request;

import com.addicks.firewall.domain.response.ApiKeyResponse;

public class KeyGenRequest extends AbstractApiRequest {

  public String getURL() {
    return "type=keygen&user=admin&password=R%40z0rR0ck3r&";
  }

  @Override
  public Class<?> getResponseClass() {
    return ApiKeyResponse.class;
  }

}
