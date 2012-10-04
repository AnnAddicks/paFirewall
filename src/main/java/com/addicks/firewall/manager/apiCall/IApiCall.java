package com.addicks.firewall.manager.apiCall;

import java.util.List;

import com.addicks.firewall.domain.request.IApiRequest;
import com.addicks.firewall.domain.response.get.rules.Rule;
import com.google.inject.ImplementedBy;

@ImplementedBy(ApiCall.class)
public interface IApiCall {

  List<Rule> getRules(IApiRequest request);

  List<Rule> resetRules(List<Rule> rules);

}
