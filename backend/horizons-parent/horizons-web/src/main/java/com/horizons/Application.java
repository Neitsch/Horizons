/**
 * Copyright 2015 Nigel Schuster.
 */


package com.horizons;

import java.net.MalformedURLException;

import lombok.extern.slf4j.XSlf4j;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.boot.autoconfigure.jdbc.DataSourceTransactionManagerAutoConfiguration;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.cache.ehcache.EhCacheCacheManager;
import org.springframework.cache.ehcache.EhCacheManagerFactoryBean;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.ImportResource;
import org.springframework.core.io.ClassPathResource;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import com.horizons.scraper.ClassScraper;

/**
 * @author nschuste
 * @version 1.0.0
 * @since Sep 23, 2015
 */
@XSlf4j
@EnableCaching
@SpringBootApplication
@EnableAutoConfiguration(exclude = {DataSourceAutoConfiguration.class,
    DataSourceTransactionManagerAutoConfiguration.class})
@ComponentScan
@EnableTransactionManagement
@EnableGlobalMethodSecurity(prePostEnabled = true)
@ImportResource("classpath:spring.xml")
public class Application {

  /**
   * @author nschuste
   * @version 1.0.0
   * @since Sep 24, 2015
   */
  public Application() {}

  public static void main(final String[] args) {
    log.entry((Object[]) args);
    System.setProperty("https.protocols", "SSLv3,SSLv2Hello,TLSv1");
    final ApplicationContext context = SpringApplication.run(Application.class, args);
    context.getBean(ClassScraper.class).getClasses();
    log.exit();
  }

  @Bean
  @Autowired
  public EhCacheCacheManager cacheManager(final EhCacheManagerFactoryBean ehcache) {
    final EhCacheCacheManager ehCacheCacheManager = new EhCacheCacheManager();
    ehCacheCacheManager.setCacheManager(ehcache.getObject());
    return ehCacheCacheManager;
  }

  @Bean
  public EhCacheManagerFactoryBean ehCacheManagerFactoryBean() throws MalformedURLException {
    final EhCacheManagerFactoryBean ehCacheManagerFactoryBean = new EhCacheManagerFactoryBean();
    ehCacheManagerFactoryBean.setConfigLocation(new ClassPathResource("ehcache.xml"));
    return ehCacheManagerFactoryBean;
  }
}
