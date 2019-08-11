package com.miyako.subject.service.course.provider.api.impl;

import com.alibaba.dubbo.config.annotation.Service;
import com.miyako.subject.commons.domain.TbCourse;
import com.miyako.subject.commons.domain.TbCourselist;
import com.miyako.subject.commons.domain.TbStudent;
import com.miyako.subject.commons.mapper.TbCourselistMapper;
import com.miyako.subject.service.course.api.TbCourseListService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import tk.mybatis.mapper.entity.Example;

import java.util.List;

/**
 * ClassName CourseListServiceImpl
 * Description //TODO
 * Author weila
 * Date 2019-08-11-0011 09:13
 */
@Service
public class CourseListServiceImpl implements TbCourseListService{

    private static Logger logger = LoggerFactory.getLogger(CourseListServiceImpl.class);

    @Autowired
    private TbCourselistMapper tbCourselistMapper;

    @Override
    public Integer insert(TbCourselist courselist){
        int i =tbCourselistMapper.insert(courselist);
        return i>=1?courselist.getId():i;
    }

    @Override
    public TbCourselist selectOne(TbCourselist courselist){
        logger.info("===>:CourseListServiceImpl select by example");
        Example example = new Example(TbCourselist.class);
        example.createCriteria()
               .andEqualTo("courseid",courselist.getCourseid())
               .andEqualTo("studentid",courselist.getStudentid());
        TbCourselist data = tbCourselistMapper.selectOneByExample(example);
        return data;
    }

    @Override
    public Integer selectCount(TbCourselist courselist){
        logger.info("===>:CourseListServiceImpl select list by example");
        Example example = new Example(TbCourselist.class);
        example.createCriteria()
               .andEqualTo("courseid",courselist.getCourseid())
               .andEqualTo("studentid",courselist.getStudentid());
        // 多少个满足查询条件的
        return tbCourselistMapper.selectCountByExample(example);
    }

    @Override
    public List<TbCourselist> selectList(TbCourselist courselist){
        logger.info("===>:CourseListServiceImpl select list by example");
        Example example = new Example(TbCourselist.class);
        example.createCriteria()
               .andEqualTo("courseid",courselist.getCourseid())
               .andEqualTo("studentid",courselist.getStudentid());
        // 多少个满足查询条件的
        return tbCourselistMapper.selectByExample(example);
    }
}
