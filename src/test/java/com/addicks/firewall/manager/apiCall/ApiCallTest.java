package com.addicks.firewall.manager.apiCall;

import org.junit.Test;

import com.addicks.firewall.domain.request.GetRuleRequest;

public class ApiCallTest {

  private ApiCall apiCall = new ApiCall("10.10.42.72");

  protected void setUp() throws Exception {

  }

  protected void tearDown() throws Exception {

  }

  @Test
  public final void testExecute() {
    System.out.println(apiCall.execute(new GetRuleRequest()));
  }

  public final void testUndo() {
    // fail("Not yet implemented");
  }

  public final void testCommit() {
    // fail("Not yet implemented");
  }

}
