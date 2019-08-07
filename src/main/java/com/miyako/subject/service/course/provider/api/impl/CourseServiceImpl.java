package com.miyako.subject.service.course.provider.api.impl;

import com.alibaba.dubbo.config.annotation.Service;
import com.miyako.subject.commons.domain.TbCourse;
import com.miyako.subject.commons.mapper.TbCourseMapper;
import com.miyako.subject.service.course.api.TbCourseService;
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

    @Autowired
    private TbCourseMapper tbCourseMapper;

    @Override
    public List<TbCourse> selectAll(){
        System.out.println("dubbo...");
        return tbCourseMapper.selectAll();
    }
}
