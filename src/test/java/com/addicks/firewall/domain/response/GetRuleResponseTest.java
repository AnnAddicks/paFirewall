package com.addicks.firewall.domain.response;

import java.io.IOException;
import java.io.InputStream;

import javax.xml.bind.JAXBException;

import org.junit.Test;

import com.addicks.firewall.domain.response.get.rules.GetRuleResponse;
import com.addicks.firewall.utilities.JAXBUtilities;

public class GetRuleResponseTest {

  @Test
  public void testJaxbConversion() throws IOException, JAXBException {
    InputStream resultStream = this.getClass().getClassLoader().getResource("GetRuleResponse.xml")
        .openStream();

    System.out.println(JAXBUtilities.getResponse(GetRuleResponse.class, resultStream));
    // TODO add asserts
  }
}
