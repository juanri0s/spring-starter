package com.juanri0s.springstarter;

import lombok.extern.slf4j.Slf4j;
import org.apache.commons.dbcp.BasicDataSource;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

import javax.sql.DataSource;

@Slf4j
@ComponentScan(basePackages = {"com.juanri0s.springstarter"})
@Configuration
public class JpaConfig {

    @Value("${spring.datasource.driver-class-name}")
    private String driverClassName;

    @Value("${spring.datasource.url}")
    private String datasourceUrl;

    @Value("${spring.datasource.username}")
    private String username;

    @Value("${spring.datasource.password}")
    private String password;

  @Bean
  public DataSource getDataSource() {
      BasicDataSource dataSource = new BasicDataSource();
      dataSource.setDriverClassName(driverClassName);
      dataSource.setUrl(datasourceUrl);
      dataSource.setUsername(username);
      dataSource.setPassword(password);

      log.info("using {} {} {} {}", driverClassName, dataSource.toString(), username, password);
      return dataSource;
  }
}
