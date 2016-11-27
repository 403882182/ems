package com.jyw.system.mapper;

import java.util.List;
import java.util.Map;

public interface ReportMapper {

	/**
	 * 学员意向状态的报表
	 * @return
	 */
	public List<Map> getStudentSateList();
	
	/**
	 * 学员类型状态的报表
	 * @return
	 */
	public List<Map> getStudentMarkList();
	
	/**
	 * 学员省份分布数据
	 */
	public List<Map> getStudentProList();
	
	/**
	 * 获取当天需要联系的学员信息
	 * @return
	 */
	public List<Map> getStudentList();
	
}
