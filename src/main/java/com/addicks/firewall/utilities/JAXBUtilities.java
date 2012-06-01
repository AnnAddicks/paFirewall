package com.addicks.firewall.utilities;

import java.io.InputStream;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;

import com.addicks.firewall.domain.response.IApiResponse;

public enum JAXBUtilities {
  INSTANCE;

  public static IApiResponse getResponse(Class<?> clazz, InputStream resultStream)
      throws JAXBException {

    JAXBContext context = JAXBContext.newInstance(clazz);
    Unmarshaller unmarshaller = context.createUnmarshaller();
    unmarshaller.setEventHandler(new javax.xml.bind.helpers.DefaultValidationEventHandler()); // debug

    IApiResponse response = (IApiResponse) unmarshaller.unmarshal(resultStream);
    System.out.println("RESPONSE: " + response);
    return response;
  }
}
