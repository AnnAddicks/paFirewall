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

    System.out.println(in);
    Properties prop = new Properties();
    prop.load(in);

    in.close();

    apiCall = new ApiCall("10.10.42.72", prop.getProperty("username"), prop.getProperty("password"));
  }

  public void tearDown() throws Exception {

  }

  @Test
  public final void testExecute() {
    System.out.println(apiCall.execute(new GetRuleRequest()));
  }
}
