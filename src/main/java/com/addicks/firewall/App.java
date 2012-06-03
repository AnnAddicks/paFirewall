package com.addicks.firewall;

import java.io.IOException;
import java.net.Socket;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

import org.apache.http.ConnectionReuseStrategy;
import org.apache.http.HttpEntity;
import org.apache.http.HttpException;
import org.apache.http.HttpHost;
import org.apache.http.HttpResponse;
import org.apache.http.HttpVersion;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.DefaultConnectionReuseStrategy;
import org.apache.http.impl.DefaultHttpClientConnection;
import org.apache.http.message.BasicHttpEntityEnclosingRequest;
import org.apache.http.message.BasicHttpRequest;
import org.apache.http.params.BasicHttpParams;
import org.apache.http.params.HttpParams;
import org.apache.http.params.HttpProtocolParams;
import org.apache.http.protocol.BasicHttpContext;
import org.apache.http.protocol.BasicHttpProcessor;
import org.apache.http.protocol.ExecutionContext;
import org.apache.http.protocol.HttpContext;
import org.apache.http.protocol.HttpRequestExecutor;
import org.apache.http.protocol.RequestConnControl;
import org.apache.http.protocol.RequestContent;
import org.apache.http.protocol.RequestExpectContinue;
import org.apache.http.protocol.RequestTargetHost;
import org.apache.http.protocol.RequestUserAgent;
import org.apache.http.util.EntityUtils;

/**
 * This is a Java HTTP Rest client generated by HTTP4e
 * (http://www.nextinterfaces.com), based on Apache HTTPComponents 4.x.
 * <p>
 * The sample project can be downloaded from
 * http://code.google.com/p/apache-httpcomponents-rest-client/
 */
public class App {

  public static void main(String[] args) throws Exception {

    HttpRunner.Bean bean = new HttpRunner.Bean();
    bean.method = "GET";
    bean.host = "168.11.51.95";
    bean.uri = "/api/?type=keygen&user=admin&password=R%40z0rR0ck3r&";
    bean.body = "";
    bean.port = 80;
    bean.addHeader("Accept", "application/xml");
    bean.addHeader("Content-Type", "application/x-www-form-urlencoded");

    // bean.addParam("type", "keygen");
    // bean.addParam("user", "admin");
    // bean.addParam("password", "R@z0rR0ck3r");

    HttpRunner httpRunner = new HttpRunner();
    HttpRunner.ResponseReader responseReader = new HttpRunner.ResponseReader() {

      public void onRead(HttpResponse response) {
        try {
          System.out.println("<< Response: " + response.getStatusLine());
          if (response.getEntity() != null) {
            System.out.println("\n" + EntityUtils.toString(response.getEntity()));
          }
          System.out.println("==============");
        }
        catch (IOException e) {
          e.printStackTrace();
        }
      }

      public void onFailure(Exception cause) {
        cause.printStackTrace();
      }
    };
    httpRunner.execute(bean, responseReader);
  }
}

/**
 * This class executes HTTP call using Apache HttpComponent API
 */
class HttpRunner {

  private Bean bean;

  private BasicHttpRequest request = null;

  public void execute(Bean tBean, ResponseReader responseReader) {
    this.bean = tBean;

    try {
      if ("GET".equalsIgnoreCase(bean.method)) {
        request = new BasicHttpRequest("GET", bean.uri);
        addHeaders(request);

      }
      else if ("POST".equalsIgnoreCase(bean.method)) {
        request = new BasicHttpEntityEnclosingRequest("POST", bean.uri);
        addHeaders(request);
        addParams(request);
        HttpEntity requestBody = new StringEntity(bean.body, "UTF-8");
        ((BasicHttpEntityEnclosingRequest) request).setEntity(requestBody);
        // new ByteArrayEntity(bean.body, "UTF-8");
        // new InputStreamEntity(new
        // ByteArrayInputStream(bean.body.getBytes("UTF-8")), -1);

      }
      else if ("HEAD".equalsIgnoreCase(bean.method)) {
        request = new BasicHttpRequest("HEAD", bean.uri);
        addHeaders(request);

      }
      else if ("PUT".equalsIgnoreCase(bean.method)) {
        request = new BasicHttpEntityEnclosingRequest("PUT", bean.uri);
        addHeaders(request);
        HttpEntity requestBody = new StringEntity(bean.body, "UTF-8");
        ((BasicHttpEntityEnclosingRequest) request).setEntity(requestBody);

      }
      else if ("DELETE".equalsIgnoreCase(bean.method)) {
        request = new BasicHttpRequest("DELETE", bean.uri);
        addHeaders(request);

      }
      else if ("TRACE".equalsIgnoreCase(bean.method)) {
        request = new BasicHttpRequest("TRACE", bean.uri);
        addHeaders(request);

      }
      else if ("OPTIONS".equalsIgnoreCase(bean.method)) {
        request = new BasicHttpRequest("OPTIONS", bean.uri);
        addHeaders(request);

      }
      else {
        throw new RuntimeException("Method '" + bean.method + "' not implemented.");
      }

      doExecute(tBean, request, responseReader);

    }
    catch (IOException e) {
      responseReader.onFailure(e);

    }
    catch (HttpException e) {
      responseReader.onFailure(e);

    }
    catch (Exception e) {
      responseReader.onFailure(e);
    }
  }

  private void addParams(BasicHttpRequest request) {
    HttpParams params = new BasicHttpParams();
    for (String key : bean.parameters.keySet()) {
      Collection<String> values = (Collection<String>) bean.parameters.get(key);
      for (String val : values) {
        params.setParameter(key, val);
      }
    }
    request.setParams(params);
  }

  private void addHeaders(BasicHttpRequest request) {
    for (String key : bean.headers.keySet()) {
      Collection<String> values = (Collection<String>) bean.headers.get(key);
      StringBuilder sb = new StringBuilder();
      int cnt = 0;
      for (String val : values) {
        if (cnt != 0) {
          sb.append(",");
        }
        sb.append(val);
        cnt++;
      }
      request.addHeader(key, sb.toString());
    }
  }

  private void doExecute(Bean tBean, BasicHttpRequest httpRequest, ResponseReader responseReader)
      throws IOException, HttpException {

    HttpParams params = httpRequest.getParams();
    HttpProtocolParams.setVersion(params, HttpVersion.HTTP_1_1);
    HttpProtocolParams.setContentCharset(params, "UTF-8");
    // HttpProtocolParams.setUserAgent(params, "http4e/3.0");
    HttpProtocolParams.setUseExpectContinue(params, true);

    BasicHttpProcessor httpProc = new BasicHttpProcessor();

    // Required protocol interceptors
    httpProc.addInterceptor(new RequestContent());
    httpProc.addInterceptor(new RequestTargetHost());

    // Recommended protocol interceptors
    httpProc.addInterceptor(new RequestConnControl());
    httpProc.addInterceptor(new RequestUserAgent());
    httpProc.addInterceptor(new RequestExpectContinue());

    HttpRequestExecutor httpExecutor = new HttpRequestExecutor();

    HttpContext ctx = new BasicHttpContext(null);
    HttpHost host;
    if (tBean.port > 0) {
      host = new HttpHost(tBean.host, tBean.port);
    }
    else {
      host = new HttpHost(tBean.host);
    }

    DefaultHttpClientConnection conn = new DefaultHttpClientConnection();
    ConnectionReuseStrategy connStrategy = new DefaultConnectionReuseStrategy();

    ctx.setAttribute(ExecutionContext.HTTP_CONNECTION, conn);
    ctx.setAttribute(ExecutionContext.HTTP_TARGET_HOST, host);

    try {

      if (!conn.isOpen()) {

        Socket socket = new Socket(host.getHostName(), host.getPort());
        conn.bind(socket, params);
      }
      httpExecutor.preProcess(request, httpProc, ctx);

      HttpResponse response = httpExecutor.execute(request, conn, ctx);
      response.setParams(params);
      httpExecutor.postProcess(response, httpProc, ctx);

      responseReader.onRead(response);

      if (!connStrategy.keepAlive(response, ctx)) {
        conn.close();
      }

    }
    finally {
      conn.close();
    }
  }

  // -- Inner classes

  /**
   * This is a helper class holding HTTP request data
   */
  public static class Bean {

    String method = "GET";

    String host = null;

    int port = -1;

    String uri = "";

    String body = "";

    private Map<String, Collection<String>> headers = new HashMap<String, Collection<String>>();

    private Map<String, Collection<String>> parameters = new HashMap<String, Collection<String>>();

    public void addHeader(String key, String value) {
      Collection<String> valuesList = (Collection<String>) headers.get(key);
      if (valuesList == null) {
        valuesList = new ArrayList<String>();
      }
      valuesList.add(value);
      headers.put(key, valuesList);
    }

    public void addParam(String key, String value) {
      Collection<String> valuesList = (Collection<String>) parameters.get(key);
      if (valuesList == null) {
        valuesList = new ArrayList<String>();
      }
      valuesList.add(value);
      parameters.put(key, valuesList);
    }

    public String toString() {
      return "{method=" + method + ",url=" + uri + ",headers=" + headers + ",parameters="
          + parameters + "}";
    }
  }

  /**
   * This interface is being hooked to the execution template method. It is
   * being invoked onRead of response or onFailre
   */
  public static interface ResponseReader {

    void onRead(HttpResponse response);

    void onFailure(Exception failure);
  }
  // --- End of Inner classes
}