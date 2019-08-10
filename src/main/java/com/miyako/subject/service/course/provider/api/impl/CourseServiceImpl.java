package com.miyako.subject.service.course.provider.api.impl;

import com.alibaba.dubbo.config.annotation.Service;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.miyako.subject.commons.domain.TbCourse;
import com.miyako.subject.commons.mapper.TbCourseMapper;
import com.miyako.subject.dubbo.aop.MethodLog;
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
    @MethodLog(value = "CourseServiceImpl", operationType = "数据库访问", operationName = "selectAll")
    public List<TbCourse> selectAll(){
        return tbCourseMapper.selectAll();
    }

    @Override
    @MethodLog(value = "CourseServiceImpl", operationType = "数据库访问", operationName = "selectById",operationArgs = "课程id")
    public TbCourse selectById(Integer id){
        return tbCourseMapper.selectByPrimaryKey(id);
    }

    @Override
    @MethodLog(value = "CourseServiceImpl", operationType = "数据库访问", operationName = "selectOne",operationArgs = "课程id")
    public TbCourse selectOne(TbCourse tbCourse){
        return tbCourseMapper.selectOne(tbCourse);
    }

    @Override
    @MethodLog(value = "CourseServiceImpl", operationType = "数据库访问", operationName = "insert",operationArgs = "课程")
    public Integer insert(TbCourse tbCourse){
        return tbCourseMapper.insert(tbCourse);
    }


    @Override
    @MethodLog(value = "CourseServiceImpl", operationType = "数据库访问", operationName = "page",operationArgs = "分页信息")
    public PageInfo<TbCourse> page(int pageNum, int pageSize){
        Example example = new Example(TbCourse.class);
        PageHelper.startPage(pageNum, pageSize);
        PageInfo<TbCourse> pageInfo = new PageInfo<>(tbCourseMapper.selectByExample(example));
        return pageInfo;
    }

    @Override
    @MethodLog(value = "CourseServiceImpl", operationType = "数据库访问", operationName = "info",operationArgs = "课程")
    public int update(TbCourse tbCourse){
        return tbCourseMapper.updateByPrimaryKey(tbCourse);
    }
}
