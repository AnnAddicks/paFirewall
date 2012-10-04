package com.addicks.firewall.manager.apiCall;

import java.util.Collections;
import java.util.List;

import com.addicks.firewall.domain.request.IApiRequest;
import com.addicks.firewall.domain.request.KeyGenRequest;
import com.addicks.firewall.domain.response.ApiKeyResponse;
import com.addicks.firewall.domain.response.IApiResponse;
import com.addicks.firewall.domain.response.get.rules.GetRuleResponse;
import com.addicks.firewall.domain.response.get.rules.Rule;
import com.google.inject.Inject;
import com.google.inject.name.Named;

public class ApiCall implements IApiCall {

  private String firewallIp;

  private String username;

  private String password;

  private String key;

  private ISSLClient client;

  private static final String API = "/api/?";

  @Inject
  public ApiCall(@Named("firewallIp") String firewallIp, @Named("username") String username,
      @Named("password") String password) {
    this.firewallIp = firewallIp;
    this.username = username;
    this.password = password;

    client = new UnsignedSSLClient();
    key = null;
  }

  @Override
  public List<Rule> getRules(IApiRequest request) {
    String url = "https://" + firewallIp + API + "key=" + getKey() + request.getURL();

    IApiResponse response = client.sendPostRequest(url, request);
    if (response != null) {
      return ((GetRuleResponse) response).getRules();
    }
    else {
      return Collections.emptyList();
    }
  }

  private String getKey() {
    if (key == null) {
      IApiRequest keyRequest = new KeyGenRequest(username, password);
      String url = "https://" + firewallIp + API + keyRequest.getURL();

      ApiKeyResponse response = (ApiKeyResponse) client.sendPostRequest(url, keyRequest);
      if (response != null) {
        key = response.getKey();
      }

    }
    return key;
  }

}
