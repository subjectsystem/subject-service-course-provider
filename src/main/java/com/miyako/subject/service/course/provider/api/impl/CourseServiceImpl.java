package com.miyako.subject.service.course.provider.api.impl;

import com.alibaba.dubbo.config.annotation.Service;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.miyako.subject.commons.domain.TbCourse;
import com.miyako.subject.commons.mapper.TbCourseMapper;
import com.miyako.subject.service.course.api.TbCourseService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import tk.mybatis.mapper.entity.Example;

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

    @Override
    public TbCourse selectById(Integer id){
        logger.info("===>:CourseServiceImpl select by Id...");
        return tbCourseMapper.selectByPrimaryKey(id);
    }

    @Override
    public TbCourse selectOne(TbCourse tbCourse){
        logger.info("===>:CourseServiceImpl select one...");
        return tbCourseMapper.selectOne(tbCourse);
    }

    @Override
    public Integer insert(TbCourse tbCourse){
        logger.info("===>:UserServiceImpl insert...");
        return tbCourseMapper.insert(tbCourse);
    }


    @Override
    public PageInfo<TbCourse> page(int pageNum, int pageSize){
        logger.info("===>:CourseServiceImpl select page...");
        Example example = new Example(TbCourse.class);
        PageHelper.startPage(pageNum, pageSize);
        PageInfo<TbCourse> pageInfo = new PageInfo<>(tbCourseMapper.selectByExample(example));
        return pageInfo;
    }

    @Override
    public int update(TbCourse tbCourse){
        logger.info("===>:CourseServiceImpl update...");
        return tbCourseMapper.updateByPrimaryKey(tbCourse);
    }
}
