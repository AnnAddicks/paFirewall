package com.addicks.firewall.manager.apiCall;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;

import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.HttpsURLConnection;
import javax.net.ssl.SSLSession;
import javax.xml.bind.JAXBException;

import com.addicks.firewall.domain.request.IApiRequest;
import com.addicks.firewall.domain.request.KeyGenRequest;
import com.addicks.firewall.domain.response.ApiKeyResponse;
import com.addicks.firewall.domain.response.IApiResponse;
import com.addicks.firewall.utilities.JAXBUtilities;
import com.google.inject.Inject;
import com.google.inject.name.Named;

public class ApiCall implements IApiCall {

  private String firewallIp;

  private static final String API = "/api/?";

  @Inject
  public ApiCall(@Named("firewallIp") String firewall_IP) {
    firewallIp = firewall_IP;
  }

  public IApiResponse execute(IApiRequest request) {
    String url = "https://" + firewallIp + API + "key=" + getKey() + request.getURL();

    IApiResponse response = sendRequest(url, request);
    return response;
  }

  private String getKey() {
    String url = "https://" + firewallIp + API + "type=keygen&user=admin&password=R%40z0rR0ck3r&";
    ApiKeyResponse response = (ApiKeyResponse) sendRequest(url, new KeyGenRequest());

    if (response != null) {
      return response.getKey();
    }
    else {
      return "";
    }

  }

  private IApiResponse sendRequest(String urlString, IApiRequest request) {

    HttpsURLConnection conn = null;
    IApiResponse response = null;
    System.out.println("URL: " + urlString);
    try {
      URL url = new URL(urlString);
      conn = (HttpsURLConnection) url.openConnection();
      conn.setHostnameVerifier(new HostnameVerifier() {
        public boolean verify(String arg0, SSLSession arg1) {
          return true;
        }
      });

      if (request.getResponseClass() == null) {
        System.out.println("response class is null");
        BufferedReader in = new BufferedReader(new InputStreamReader(conn.getInputStream()));
        String line = null;
        while ((line = in.readLine()) != null) {
          System.out.println(line);
        }
      }
      else {
        response = JAXBUtilities.getResponse(request.getResponseClass(), conn.getInputStream());
      }
    }
    catch (IOException e) {
      // TODO Auto-generated catch block
      e.printStackTrace();
    }
    catch (JAXBException e) {
      // TODO Auto-generated catch block
      e.printStackTrace();
    }
    finally {
      conn.disconnect();
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
