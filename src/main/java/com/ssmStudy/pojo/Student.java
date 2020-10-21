package com.ssmStudy.pojo;

import org.apache.ibatis.session.ResultHandler;

import java.util.List;

/**
 * @Author sjw
 * @Description 学生类
 * @Date 16:50 2020/9/15
 **/
public class Student{
    String number;
    String name;
    int age;
    String sex;
    String grade;
    List<SchoolRoll> schoolRolls;

    public List<SchoolRoll> getSchoolRolls() {
        return schoolRolls;
    }

    public void setSchoolRolls(List<SchoolRoll> schoolRolls) {
        this.schoolRolls = schoolRolls;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public String getGrade() {
        return grade;
    }

    public void setGrade(String grade) {
        this.grade = grade;
    }

    @Override
    public String toString() {
        return "Student{" +
                "number='" + number + '\'' +
                ", name='" + name + '\'' +
                ", age=" + age +
                ", sex='" + sex + '\'' +
                ", grade='" + grade + '\'' +
                '}';
    }
}
