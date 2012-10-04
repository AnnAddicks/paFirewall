package com.addicks.firewall.domain.request;

import com.addicks.firewall.domain.response.CommitResponse;

public class CommitRequest implements IApiRequest {

  public CommitRequest() {

  }

  @Override
  public String getURL() {
    return "&type=commit&cmd=<commit></commit>";
  }

  @Override
  public Class<?> getResponseClass() {
    return CommitResponse.class;
  }
}
