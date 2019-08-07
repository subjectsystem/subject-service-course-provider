package com.miyakp.subject.service.course.provider.api.impl;

import com.alibaba.dubbo.config.annotation.Service;
import com.miyako.subject.commons.domain.TbCourse;
import com.miyako.subject.commons.mapper.TbCourseMapper;
import com.miyako.subject.service.course.api.TbCourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * ClassName CourseServiceImpl
 * Description //TODO
 * Author weila
 * Date 2019-08-07-0007 14:08
 */
@Service(version = "${services.version.course.v1}")
@Transactional(readOnly = true)
public class CourseServiceImpl implements TbCourseService{

    @Autowired
    private TbCourseMapper tbCourseMapper;

    @Override
    public List<TbCourse> selectAll(){
        return tbCourseMapper.selectAll();
    }
}
