package com.addicks.firewall.manager.apiCall;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;

import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.HttpsURLConnection;
import javax.net.ssl.SSLSession;
import javax.xml.bind.JAXBException;

import com.addicks.firewall.domain.request.IApiRequest;
import com.addicks.firewall.domain.response.ApiKeyResponse;
import com.addicks.firewall.domain.response.IApiResponse;
import com.addicks.firewall.utilities.JAXBUtilities;

public class ApiCall implements IApiCall {
  private static final String FIREWALL_IP = "https://168.11.51.95/";

  private static final String API = "api?";

  public IApiResponse execute(IApiRequest request) {
    URL url;
    IApiResponse response = null;
    HttpsURLConnection conn = null;
    try {
      url = new URL(FIREWALL_IP + API + request.getURL());
      conn = (HttpsURLConnection) url.openConnection();
      conn.setHostnameVerifier(new HostnameVerifier() {
        public boolean verify(String arg0, SSLSession arg1) {
          return true;
        }
      });

      response = JAXBUtilities.getResponse(ApiKeyResponse.class, conn.getInputStream());
    }
    catch (MalformedURLException e) {
      // TODO Auto-generated catch block
      e.printStackTrace();
    }
    catch (JAXBException e) {
      // TODO Auto-generated catch block
      e.printStackTrace();
    }
    catch (IOException e) {
      // TODO Auto-generated catch block
      e.printStackTrace();
    }
    finally {
      if (conn != null) {
        conn.disconnect();
      }
    }
    return response;
  }

  public Boolean undo() {
    // TODO Auto-generated method stub
    return null;
  }

  public Boolean commit() {
    // TODO Auto-generated method stub
    return null;
  }

}
