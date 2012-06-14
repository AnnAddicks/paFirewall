package com.addicks.firewall.manager.apiCall;

import com.addicks.firewall.domain.request.IApiRequest;
import com.addicks.firewall.domain.response.IApiResponse;
import com.google.inject.ImplementedBy;

@ImplementedBy(ApiCall.class)
public interface IApiCall {

  IApiResponse execute(IApiRequest request);

  Boolean undo();

  Boolean commit();
}
