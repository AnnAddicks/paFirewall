package com.addicks.firewall;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.URL;
import java.security.SecureRandom;
import java.security.cert.CertificateException;
import java.security.cert.X509Certificate;

import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.HttpsURLConnection;
import javax.net.ssl.KeyManager;
import javax.net.ssl.SSLContext;
import javax.net.ssl.SSLSession;
import javax.net.ssl.TrustManager;
import javax.net.ssl.X509TrustManager;

import com.addicks.firewall.domain.response.ApiKeyResponse;
import com.addicks.firewall.domain.response.IApiResponse;
import com.addicks.firewall.utilities.JAXBUtilities;

public class UnsignedSSLTest {

  public static void main(String[] args) throws Exception {
    // configure the SSLContext with a TrustManager
    SSLContext ctx = SSLContext.getInstance("TLS");
    ctx.init(new KeyManager[0], new TrustManager[] { new DefaultTrustManager() },
        new SecureRandom());
    SSLContext.setDefault(ctx);

    URL url = new URL("https://168.11.51.95/api/?type=keygen&user=admin&password=R%40z0rR0ck3r&");
    HttpsURLConnection conn = (HttpsURLConnection) url.openConnection();
    conn.setHostnameVerifier(new HostnameVerifier() {
      public boolean verify(String arg0, SSLSession arg1) {
        return true;
      }
    });

    IApiResponse response = JAXBUtilities.getResponse(ApiKeyResponse.class, conn.getInputStream());

    conn.disconnect();

    URL url2 = new URL(
        "https://168.11.51.95/api/?type=config&action=get&key="
            + ((ApiKeyResponse) response).getKey()
            + "&xpath=/config/devices/entry[@name='localhost.localdomain']/vsys/entry[@name='vsys1']/rulebase");

    HttpsURLConnection conn2 = (HttpsURLConnection) url2.openConnection();
    conn.setHostnameVerifier(new HostnameVerifier() {
      public boolean verify(String arg0, SSLSession arg1) {
        return true;
      }
    });
    BufferedReader in = new BufferedReader(new InputStreamReader(conn2.getInputStream()));
    String line = null;
    while ((line = in.readLine()) != null) {
      System.out.println(line);
    }

  }

  private static class DefaultTrustManager implements X509TrustManager {

    public void checkClientTrusted(X509Certificate[] arg0, String arg1) throws CertificateException {
    }

    public void checkServerTrusted(X509Certificate[] arg0, String arg1) throws CertificateException {
    }

    public X509Certificate[] getAcceptedIssuers() {
      return null;
    }
  }
}
