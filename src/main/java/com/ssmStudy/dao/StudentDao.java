package com.ssmStudy.dao;

import com.ssmStudy.pojo.SchoolRoll;
import com.ssmStudy.pojo.Student;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface StudentDao {
    SchoolRoll selectSchoolRoll(@Param("stuNo") String stuid);


}
