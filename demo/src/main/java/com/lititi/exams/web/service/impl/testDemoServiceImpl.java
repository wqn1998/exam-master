package com.lititi.exams.web.service.impl;

import com.lititi.exams.web.entity.testDemo;
import com.lititi.exams.web.dao.testDemoMapper;
import com.lititi.exams.web.service.testDemoService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * 演示文件，请勿在此文件添加或者修改代码！！！
 * 演示文件，请勿在此文件添加或者修改代码！！！
 * 演示文件，请勿在此文件添加或者修改代码！！！
 */

/**
 * (testDemo)表服务实现类
 *
 * @author makejava
 * @since 2024-02-20 11:09:06
 */
@Service("testDemoService")
public class testDemoServiceImpl implements testDemoService {
    @Resource
    private testDemoMapper testDemoMapper;

    /**
     * 通过编号查询单条数据
     *
     * @param number 编号
     * @return 实例对象
     */
    @Override
    public testDemo selectByNumber(long number) {
        return testDemoMapper.selectByNumber(number);
    }
    
    /**
     * 通过编号查询Id
     *
     * @param number 编号
     * @return 实例对象
     */
    @Override
    public Long selectIdByNumber(long number) {
        return testDemoMapper.selectIdByNumber(number);
    }

    /**
     * 新增数据
     *
     * @param content 实例对象
     * @return 成功数量
     */
    @Override
    public int insert(testDemo content) {
        return testDemoMapper.insert(content);
    }

    /**
     * 修改数据
     *
     * @param content 实例对象
     * @return 成功数量
     */
    @Override
    public int update(testDemo content) {
        return testDemoMapper.update(content);
    }
}
