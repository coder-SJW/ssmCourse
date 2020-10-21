package com.ssmStudy.pojo;

/**
 * @Author sjw
 * @Description 学籍类
 * @Date 10:54 2020/10/10
 **/
public class SchoolRoll {
    String rollId;
    String stuNo;
    String schoolName;
    Student stu;

    public String getRollId() {
        return rollId;
    }

    public void setRollId(String rollId) {
        this.rollId = rollId;
    }

    public String getSchoolName() {
        return schoolName;
    }

    public void setSchoolName(String schoolName) {
        this.schoolName = schoolName;
    }

    public Student getStu() {
        return stu;
    }

    public void setStu(Student stu) {
        this.stu = stu;
    }

    public String getStuNo() {
        return stuNo;
    }

    public void setStuNo(String stuNo) {
        this.stuNo = stuNo;
    }

    @Override
    public String toString() {
        return "SchoolRoll{" +
                "rollId='" + rollId + '\'' +
                ", stuNo='" + stuNo + '\'' +
                ", schoolName='" + schoolName + '\'' +
                ", stu=" + stu +
                '}';
    }
}
