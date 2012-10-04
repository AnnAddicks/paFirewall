package com.addicks.firewall.manager.apiCall;

import java.io.InputStream;
import java.util.Properties;

import org.junit.Before;
import org.junit.Test;

import com.addicks.firewall.domain.request.GetRuleRequest;

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

  public void tearDown() throws Exception {

  }

  @Test
  public final void testExecute() {
    System.out.println(apiCall.getRules(new GetRuleRequest()));
  }
}
