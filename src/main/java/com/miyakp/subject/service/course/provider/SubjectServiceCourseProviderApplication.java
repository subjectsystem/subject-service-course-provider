package com.miyakp.subject.service.course.provider;

import com.alibaba.dubbo.container.Main;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.hystrix.EnableHystrix;
import org.springframework.cloud.netflix.hystrix.dashboard.EnableHystrixDashboard;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import tk.mybatis.spring.annotation.MapperScan;

/**
 * ClassName SubjectServiceCourseProviderApplication
 * Description //TODO
 * Author weila
 * Date 2019-08-07-0007 11:22
 */
@EnableHystrix
@EnableHystrixDashboard
@SpringBootApplication(scanBasePackages = "com.miyako.subject")
@EnableTransactionManagement
@MapperScan(basePackages = "com.miyako.subject.commons.mapper")
public class SubjectServiceCourseProviderApplication{
    public static void main(String[] args) {
        SpringApplication.run(SubjectServiceCourseProviderApplication.class, args);
        Main.main(args);
    }
}
