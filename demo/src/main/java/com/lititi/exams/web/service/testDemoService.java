package com.lititi.exams.web.service;

import com.lititi.exams.commons2.service.BaseService;
import com.lititi.exams.web.entity.testDemo;

/**
 * 演示文件，请勿在此文件添加或者修改代码！！！
 * 演示文件，请勿在此文件添加或者修改代码！！！
 * 演示文件，请勿在此文件添加或者修改代码！！！
 */

/**
 * (testDemo)表服务接口
 *
 * @author makejava
 * @since 2024-02-20 11:09:06
 */
public interface testDemoService extends BaseService {

    /**
     * 通过编号查询单条数据
     *
     * @param number 编号
     * @return 实例对象
     */
    testDemo selectByNumber(long number);
    
     /**
     * 通过编号查询id
     *
     * @param number 编号
     * @return 成功数量
     */
    Long selectIdByNumber(long number);
 
    /**
     * 新增数据
     *
     * @param content 实例对象
     * @return 实例对象
     */
   int insert(testDemo content);

    /**
     * 修改数据
     *
     * @param content 实例对象
     * @return 成功数量
     */
    int update(testDemo content);

}
