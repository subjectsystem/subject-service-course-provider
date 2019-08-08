package com.miyako.subject.service.course.provider.api.impl;

import com.alibaba.dubbo.config.annotation.Service;
import com.miyako.subject.commons.domain.TbCourse;
import com.miyako.subject.commons.mapper.TbCourseMapper;
import com.miyako.subject.service.course.api.TbCourseService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * ClassName CourseServiceImpl
 * Description //TODO
 * Author weila
 * Date 2019-08-07-0007 14:08
 */
@Service
//@Transactional(readOnly = true)
@Component
public class CourseServiceImpl implements TbCourseService{

    private static Logger logger = LoggerFactory.getLogger(CourseServiceImpl.class);

    @Autowired
    private TbCourseMapper tbCourseMapper;

    @Override
    public List<TbCourse> selectAll(){
        logger.info("===>:CourseServiceImpl select all...");
        return tbCourseMapper.selectAll();
    }

    public void insert(TbCourse course){
        tbCourseMapper.insertUseGeneratedKeys(course);
    }
}
