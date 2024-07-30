# 配置多数据源

开源软件`dynamic-datasource-spring-boot-starter`

依赖：
```xml
<dependency>
    <groupId>com.baomidou</groupId>
    <artifactId>dynamic-datasource-spring-boot-starter</artifactId>
    <version>3.4.0</version>
    <exclusions>
        <exclusion>
            <groupId>com.baomidou</groupId>
            <artifactId>mybatis-plus-boot-starter</artifactId>
        </exclusion>
    </exclusions>
</dependency>
```

属性配置文件：
```yaml
spring:
  datasource:
    dynamic:
      primary: master #设置默认的数据源或者数据源组,默认值即为master
      strict: false #严格匹配数据源,默认false. true未匹配到指定数据源时抛异常,false使用默认数据源
      datasource: # Map<String, DataSourceProperty> datasource = new LinkedHashMap<>();
        master:
          driver-class-name: org.sqlite.JDBC
          url: jdbc:sqlite:${sqlite.home}/data/test.db?date_string_format=yyyy-MM-dd HH:mm:ss
          password: 123456
        slave_1:
          driver-class-name: org.sqlite.JDBC
          url: jdbc:sqlite:${sqlite.home}/data/test.db?date_string_format=yyyy-MM-dd HH:mm:ss
          password: 123456
```