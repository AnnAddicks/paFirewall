package com.addicks.firewall.manager.apiCall;

import junit.framework.TestCase;

import com.addicks.firewall.domain.request.GetRuleRequest;

public class AipCallTest extends TestCase {

  private ApiCall apiCall;

  protected void setUp() throws Exception {
    super.setUp();
    this.apiCall = new ApiCall();
  }

  protected void tearDown() throws Exception {
    super.tearDown();
  }

  public final void testExecute() {

    System.out.println(apiCall.execute(new GetRuleRequest()));
  }

  public final void testUndo() {
    fail("Not yet implemented");
  }

  public final void testCommit() {
    fail("Not yet implemented");
  }

}
