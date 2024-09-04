package org.scoula.config;

import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;
import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;

import javax.sql.DataSource;


//이 클래스가 Spring의 설정 클래스로 사용된다는 의미
//-> 클래스가 Spring 컨테이너에 의해 Bean으로 등록
@Configuration

// 외부 프로퍼티 파일을 로드해서 애플리케이션의 설정 제공
//-> 데이터베이스 연결 정보 읽어옴
@PropertySource({"classpath:/application.properties"})
//@MapperScan(basePackages = {})
@MapperScan(basePackages = {"org.scoula.board.mapper"})
public class RootConfig {
    @Value("${jdbc.driver}") String driver;
    @Value("${jdbc.url}") String url;
    @Value("${jdbc.username}") String username;
    @Value("${jdbc.password}") String password;

    @Bean
    public DataSource dataSource() {
        HikariConfig config = new HikariConfig();
        config.setDriverClassName(driver);
        config.setJdbcUrl
                (url);
        config.setUsername(username);
        config.setPassword(password);
        HikariDataSource dataSource = new HikariDataSource(config);
        return dataSource
                ;
    }

    //@Autowired : Spring이 ApplicationContext를 자동으로 주입
    //-> 애플리케이션의 컨텍스트 정보에 접근하기 위해 사용
    @Autowired
    ApplicationContext applicationContext;

    @Bean
    //MyBatis의 SQL 세션을 관리
    public SqlSessionFactory sqlSessionFactory() throws Exception {
        SqlSessionFactoryBean sqlSessionFactory = new SqlSessionFactoryBean();
        //MyBatis의 설정 파일 위치 지정
        sqlSessionFactory.setConfigLocation(
                applicationContext.getResource("classpath:/mybatis-config.xml"));
        //앞에서 정의한 datasource를 설정
        sqlSessionFactory.setDataSource(dataSource());
        return (SqlSessionFactory) sqlSessionFactory.getObject();
    }

    @Bean
    public DataSourceTransactionManager transactionManager(){
        DataSourceTransactionManager manager = new DataSourceTransactionManager(dataSource());
        return manager;
    }
}
