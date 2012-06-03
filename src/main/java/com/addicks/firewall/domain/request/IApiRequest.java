package com.addicks.firewall.domain.request;

public interface IApiRequest {

  String getURL();

  Class<?> getResponseClass();
}
