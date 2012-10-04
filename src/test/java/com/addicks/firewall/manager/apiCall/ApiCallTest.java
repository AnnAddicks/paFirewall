package com.addicks.firewall.manager.apiCall;

import java.io.InputStream;
import java.util.List;
import java.util.Properties;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.addicks.firewall.domain.request.GetRuleRequest;
import com.addicks.firewall.domain.response.get.rules.Rule;

public class ApiCallTest {

  private ApiCall apiCall;

  @Before
  public void setUp() throws Exception {
    InputStream in = Thread.currentThread().getContextClassLoader()
        .getResourceAsStream("homeApp.properties");
    Properties prop = new Properties();
    prop.load(in);

    in.close();

    apiCall = new ApiCall(prop.getProperty("firewallIp"), prop.getProperty("username"),
        prop.getProperty("password"));
  }

  @After
  public void tearDown() throws Exception {

  }

  @Test
  public final void testGetRules() {
    System.out.println(apiCall.getRules(new GetRuleRequest()));
  }

  @Test
  public final void testResetRules() {
    List<Rule> rules = apiCall.getRules(new GetRuleRequest());
    apiCall.resetRules(rules);
  }
}
