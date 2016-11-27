package com.jyw.system.service.impl;

import com.jyw.system.mapper.ReportMapper;
import com.jyw.system.service.ReportService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Map;

@Service
@Transactional(readOnly = true)
public class ReportServiceImpl implements ReportService {

    @Autowired
    private ReportMapper reportMapper;

    public List<Map> selectStudentSateList() {
        return reportMapper.getStudentSateList();
    }

    public List<Map> selectStudentMarkList() {
        return reportMapper.getStudentMarkList();
    }

    public List<Map> selectStudentProList() {
        return reportMapper.getStudentProList();
    }

    public List<Map> selectStudentList() {
        return reportMapper.getStudentList();
    }
}
