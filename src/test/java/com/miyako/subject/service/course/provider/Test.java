package com.miyako.subject.service.course.provider;

import com.alibaba.dubbo.config.annotation.Reference;
import com.miyako.subject.commons.domain.TbCourse;
import com.miyako.subject.service.course.api.TbCourseService;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Random;

/**
 * ClassName Test
 * Description //TODO
 * Author weila
 * Date 2019-08-09-0009 16:38
 */
@RunWith(SpringRunner.class)
@SpringBootTest(classes = SubjectServiceCourseProviderApplication.class)
public class Test{
    private static Logger logger = LoggerFactory.getLogger(Test.class);

    @Reference
    private TbCourseService tbCourseService;

    @org.junit.Test
    public void insertCourse(){
        logger.info("insert course...");
        String[] num = {"TX", "SW","JS", "ZD", "CM", "JX"};
        Random random = new Random();
        for (int i=1; i<21; i++){
            TbCourse course = new TbCourse();
            course.setTitle("测试课程-"+i);
            course.setTeacherid(1);
            course.setCollegeid(1);
            course.setCoursecount(random.nextInt(16)+50);
            course.setCoursenum(num[random.nextInt(18)%6]);
            logger.info(tbCourseService.insert(course).toString());
        }
    }

    @org.junit.Test
    public void editCourse(){
        logger.info("edit course...");
        Random random = new Random();
        for (int i=1; i<21; i++){
            TbCourse course = tbCourseService.selectById(i + 2);

            String num = String.format("%s%s%s%s",course.getCoursenum().substring(0,1),
                                       random.nextInt(12)%4 + 2020,
                                       random.nextInt(24)%12,
                                       random.nextInt(47)%28);
            course.setCoursenum(num);
            logger.info(tbCourseService.update(course)+"");
        }
    }
}
