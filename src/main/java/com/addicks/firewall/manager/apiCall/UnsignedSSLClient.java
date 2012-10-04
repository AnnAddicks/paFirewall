package com.addicks.firewall.manager.apiCall;

import java.io.IOException;
import java.security.KeyManagementException;
import java.security.KeyStoreException;
import java.security.NoSuchAlgorithmException;
import java.security.UnrecoverableKeyException;
import java.security.cert.CertificateException;
import java.security.cert.X509Certificate;

import javax.xml.bind.JAXBException;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.conn.scheme.Scheme;
import org.apache.http.conn.ssl.SSLSocketFactory;
import org.apache.http.conn.ssl.TrustStrategy;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.util.EntityUtils;

import com.addicks.firewall.domain.request.IApiRequest;
import com.addicks.firewall.domain.response.IApiResponse;
import com.addicks.firewall.utilities.JAXBUtilities;

/**
 * Most of the pa firewalls that are setup are not signed or self-signed. We are
 * going to by default trust them.
 * 
 */
public class UnsignedSSLClient implements ISSLClient {

  public UnsignedSSLClient() {

  }

  @Override
  public IApiResponse sendPostRequest(String urlString, IApiRequest request) {
    IApiResponse apiResponse = null;
    DefaultHttpClient httpclient = new DefaultHttpClient();
    try {
      TrustStrategy strategy = new TrustStrategy() {
        @Override
        public boolean isTrusted(X509Certificate[] chain, String authType)
            throws CertificateException {
          // TODO Auto-generated method stub
          return true;
        }
      };

      SSLSocketFactory socketFactory = new SSLSocketFactory(strategy,
          SSLSocketFactory.ALLOW_ALL_HOSTNAME_VERIFIER);
      Scheme sch = new Scheme("https", 443, socketFactory);
      httpclient.getConnectionManager().getSchemeRegistry().register(sch);

      HttpPost httpPost = new HttpPost(urlString);

      System.out.println("executing request" + httpPost.getRequestLine());

      HttpResponse response = httpclient.execute(httpPost);
      HttpEntity entity = response.getEntity();

      System.out.println("----------------------------------------");
      System.out.println(response.getStatusLine());
      if (entity != null) {
        System.out.println("Response content length: " + entity.getContentLength());
      }

      apiResponse = JAXBUtilities.getResponse(request.getResponseClass(), response.getEntity()
          .getContent());

      EntityUtils.consume(entity);

    }
    catch (IllegalStateException e) {
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
    catch (KeyManagementException e) {
      // TODO Auto-generated catch block
      e.printStackTrace();
    }
    catch (UnrecoverableKeyException e) {
      // TODO Auto-generated catch block
      e.printStackTrace();
    }
    catch (NoSuchAlgorithmException e) {
      // TODO Auto-generated catch block
      e.printStackTrace();
    }
    catch (KeyStoreException e) {
      // TODO Auto-generated catch block
      e.printStackTrace();
    }
    finally {
      // When HttpClient instance is no longer needed,
      // shut down the connection manager to ensure
      // immediate deallocation of all system resources
      httpclient.getConnectionManager().shutdown();
    }

    return apiResponse;

  }

}
