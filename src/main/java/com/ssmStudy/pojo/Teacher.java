package com.ssmStudy.pojo;

/**
 * @Author sjw
 * @Description
 * @Date 11:32 2020/9/24
 **/
public class Teacher {
    String teacherId;
    String teacherName;

    public String getTeacherId() {
        return teacherId;
    }

    public void setTeacherId(String teacherId) {
        this.teacherId = teacherId;
    }

    public String getTeacherName() {
        return teacherName;
    }

    public void setTeacherName(String teacherName) {
        this.teacherName = teacherName;
    }

    @Override
    public String toString() {
        return "Teacher{" +
                "tId='" + teacherId + '\'' +
                ", TeacherName='" + teacherName + '\'' +
                '}';
    }
}
