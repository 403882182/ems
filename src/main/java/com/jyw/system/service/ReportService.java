package com.jyw.system.service;

import java.util.List;
import java.util.Map;

public interface ReportService {
    /**
     *学员意向状态的报表
     * @return
     */
    public List<Map> selectStudentSateList();

    /**
     * 学员类型状态的报表
     * @return
     */
    public List<Map> selectStudentMarkList();

    /**
     *学员省份分布数据
     * @return
     */
    public List<Map> selectStudentProList();

    /**
     * 获取当天需要联系的学员信息
     * @return
     */
    public List<Map> selectStudentList();
}
