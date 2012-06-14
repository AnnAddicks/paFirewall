package com.addicks.firewall.manager;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import com.google.inject.AbstractModule;
import com.google.inject.name.Names;

public class PropertiesModule extends AbstractModule {
  public void configure() {
    Properties properties = new Properties();
    try {
      FileInputStream fis = new FileInputStream("/companyDefaults/wareCounty.properties");

      properties.load(fis);

    }
    catch (IOException e) {
      // throw exception
    }

    Names.bindProperties(binder(), properties);
  }
}
