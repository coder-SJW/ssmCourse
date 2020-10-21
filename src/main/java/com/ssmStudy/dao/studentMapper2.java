package com.ssmStudy.dao;

import com.ssmStudy.pojo.SchoolRoll;
import com.ssmStudy.pojo.Student;

import java.util.List;

public interface studentMapper2 {
    SchoolRoll selectSchoolRoll(String stuid);
    /**
     * 对student表进行批量插入
     * @param list
     * @return
     */
    int insertStu(List<Student> list);
}
