
package com.jyw.model;

import java.io.Serializable;

/**
 * 学员信息表 student_info
 * 2016/11/05 16:28
*/
public class StudentInfo implements Serializable {
    private static final long serialVersionUID = 1L;

    /** 
     * 学员编号
     */
    private Integer studentId;

    /** 
     * 负责人
     */
    private Integer staffId;

    /** 
     * 班级编号
     */
    private Integer classId;

    /** 
     * 学员姓名
     */
    private String studentName;

    /** 
     * 学员性别
     */
    private String studentSex;

    /** 
     * 学员年龄
     */
    private Integer studentAge;

    /** 
     * 学员手机号
     */
    private String studentTellphone;

    /** 
     * email
     */
    private String studentEmail;

    /** 
     * 身份证号码
     */
    private String studentIdcard;

    /** 
     * 家庭住址
     */
    private String studentAddress;

    /** 
     * 出生日期
     */
    private String studentBirthday;

    /** 
     * 所在院校
     */
    private String studentSchool;

    /** 
     * QQ号码
     */
    private String studentQq;

    /** 
     * 家长姓名
     */
    private String studentParentsName;

    /** 
     * 家长电话
     */
    private String studentParentsPhone;

    /** 
     * 省份
     */
    private String studentPro;

    /** 
     * 城市
     */
    private String studentProCity;

    /** 
     * 类型
     */
    private String studentType;

    /** 
     * 是否缴费
     */
    private String studentIspay;

    /** 
     * 意向状态
     */
    private Integer studentSate;

    /** 
     * 标识
     */
    private String studentMark;

    /** 
     * 描述
     */
    private String studentDesc;

    /** 
     * 账号
     */
    private String studentNumber;

    /** 
     * 密码
     */
    private String studentPassword;

    /** 
     * 构造查询条件
     */
    public StudentInfo(Integer studentId, Integer staffId, Integer classId, String studentName, String studentSex, Integer studentAge, String studentTellphone, String studentEmail, String studentIdcard, String studentAddress, String studentBirthday, String studentSchool, String studentQq, String studentParentsName, String studentParentsPhone, String studentPro, String studentProCity, String studentType, String studentIspay, Integer studentSate, String studentMark, String studentDesc, String studentNumber, String studentPassword) {
        this.studentId = studentId;
        this.staffId = staffId;
        this.classId = classId;
        this.studentName = studentName;
        this.studentSex = studentSex;
        this.studentAge = studentAge;
        this.studentTellphone = studentTellphone;
        this.studentEmail = studentEmail;
        this.studentIdcard = studentIdcard;
        this.studentAddress = studentAddress;
        this.studentBirthday = studentBirthday;
        this.studentSchool = studentSchool;
        this.studentQq = studentQq;
        this.studentParentsName = studentParentsName;
        this.studentParentsPhone = studentParentsPhone;
        this.studentPro = studentPro;
        this.studentProCity = studentProCity;
        this.studentType = studentType;
        this.studentIspay = studentIspay;
        this.studentSate = studentSate;
        this.studentMark = studentMark;
        this.studentDesc = studentDesc;
        this.studentNumber = studentNumber;
        this.studentPassword = studentPassword;
    }

    /** 
     * 构造查询条件
     */
    public StudentInfo() {
        super();
    }

    /** 
     * 获取 学员编号 student_info.student_id
     * @return 学员编号
     */
    public Integer getStudentId() {
        return studentId;
    }

    /** 
     * 设置 学员编号 student_info.student_id
     * @param studentId 学员编号
     */
    public void setStudentId(Integer studentId) {
        this.studentId = studentId;
    }

    /** 
     * 获取 负责人 student_info.staff_id
     * @return 负责人
     */
    public Integer getStaffId() {
        return staffId;
    }

    /** 
     * 设置 负责人 student_info.staff_id
     * @param staffId 负责人
     */
    public void setStaffId(Integer staffId) {
        this.staffId = staffId;
    }

    /** 
     * 获取 班级编号 student_info.class_id
     * @return 班级编号
     */
    public Integer getClassId() {
        return classId;
    }

    /** 
     * 设置 班级编号 student_info.class_id
     * @param classId 班级编号
     */
    public void setClassId(Integer classId) {
        this.classId = classId;
    }

    /** 
     * 获取 学员姓名 student_info.student_name
     * @return 学员姓名
     */
    public String getStudentName() {
        return studentName;
    }

    /** 
     * 设置 学员姓名 student_info.student_name
     * @param studentName 学员姓名
     */
    public void setStudentName(String studentName) {
        this.studentName = studentName == null ? null : studentName.trim();
    }

    /** 
     * 获取 学员性别 student_info.student_sex
     * @return 学员性别
     */
    public String getStudentSex() {
        return studentSex;
    }

    /** 
     * 设置 学员性别 student_info.student_sex
     * @param studentSex 学员性别
     */
    public void setStudentSex(String studentSex) {
        this.studentSex = studentSex == null ? null : studentSex.trim();
    }

    /** 
     * 获取 学员年龄 student_info.student_age
     * @return 学员年龄
     */
    public Integer getStudentAge() {
        return studentAge;
    }

    /** 
     * 设置 学员年龄 student_info.student_age
     * @param studentAge 学员年龄
     */
    public void setStudentAge(Integer studentAge) {
        this.studentAge = studentAge;
    }

    /** 
     * 获取 学员手机号 student_info.student_tellphone
     * @return 学员手机号
     */
    public String getStudentTellphone() {
        return studentTellphone;
    }

    /** 
     * 设置 学员手机号 student_info.student_tellphone
     * @param studentTellphone 学员手机号
     */
    public void setStudentTellphone(String studentTellphone) {
        this.studentTellphone = studentTellphone == null ? null : studentTellphone.trim();
    }

    /** 
     * 获取 email student_info.student_email
     * @return email
     */
    public String getStudentEmail() {
        return studentEmail;
    }

    /** 
     * 设置 email student_info.student_email
     * @param studentEmail email
     */
    public void setStudentEmail(String studentEmail) {
        this.studentEmail = studentEmail == null ? null : studentEmail.trim();
    }

    /** 
     * 获取 身份证号码 student_info.student_idcard
     * @return 身份证号码
     */
    public String getStudentIdcard() {
        return studentIdcard;
    }

    /** 
     * 设置 身份证号码 student_info.student_idcard
     * @param studentIdcard 身份证号码
     */
    public void setStudentIdcard(String studentIdcard) {
        this.studentIdcard = studentIdcard == null ? null : studentIdcard.trim();
    }

    /** 
     * 获取 家庭住址 student_info.student_address
     * @return 家庭住址
     */
    public String getStudentAddress() {
        return studentAddress;
    }

    /** 
     * 设置 家庭住址 student_info.student_address
     * @param studentAddress 家庭住址
     */
    public void setStudentAddress(String studentAddress) {
        this.studentAddress = studentAddress == null ? null : studentAddress.trim();
    }

    /** 
     * 获取 出生日期 student_info.student_birthday
     * @return 出生日期
     */
    public String getStudentBirthday() {
        return studentBirthday;
    }

    /** 
     * 设置 出生日期 student_info.student_birthday
     * @param studentBirthday 出生日期
     */
    public void setStudentBirthday(String studentBirthday) {
        this.studentBirthday = studentBirthday == null ? null : studentBirthday.trim();
    }

    /** 
     * 获取 所在院校 student_info.student_school
     * @return 所在院校
     */
    public String getStudentSchool() {
        return studentSchool;
    }

    /** 
     * 设置 所在院校 student_info.student_school
     * @param studentSchool 所在院校
     */
    public void setStudentSchool(String studentSchool) {
        this.studentSchool = studentSchool == null ? null : studentSchool.trim();
    }

    /** 
     * 获取 QQ号码 student_info.student_qq
     * @return QQ号码
     */
    public String getStudentQq() {
        return studentQq;
    }

    /** 
     * 设置 QQ号码 student_info.student_qq
     * @param studentQq QQ号码
     */
    public void setStudentQq(String studentQq) {
        this.studentQq = studentQq == null ? null : studentQq.trim();
    }

    /** 
     * 获取 家长姓名 student_info.student_parents_name
     * @return 家长姓名
     */
    public String getStudentParentsName() {
        return studentParentsName;
    }

    /** 
     * 设置 家长姓名 student_info.student_parents_name
     * @param studentParentsName 家长姓名
     */
    public void setStudentParentsName(String studentParentsName) {
        this.studentParentsName = studentParentsName == null ? null : studentParentsName.trim();
    }

    /** 
     * 获取 家长电话 student_info.student_parents_phone
     * @return 家长电话
     */
    public String getStudentParentsPhone() {
        return studentParentsPhone;
    }

    /** 
     * 设置 家长电话 student_info.student_parents_phone
     * @param studentParentsPhone 家长电话
     */
    public void setStudentParentsPhone(String studentParentsPhone) {
        this.studentParentsPhone = studentParentsPhone == null ? null : studentParentsPhone.trim();
    }

    /** 
     * 获取 省份 student_info.student_pro
     * @return 省份
     */
    public String getStudentPro() {
        return studentPro;
    }

    /** 
     * 设置 省份 student_info.student_pro
     * @param studentPro 省份
     */
    public void setStudentPro(String studentPro) {
        this.studentPro = studentPro == null ? null : studentPro.trim();
    }

    /** 
     * 获取 城市 student_info.student_pro_city
     * @return 城市
     */
    public String getStudentProCity() {
        return studentProCity;
    }

    /** 
     * 设置 城市 student_info.student_pro_city
     * @param studentProCity 城市
     */
    public void setStudentProCity(String studentProCity) {
        this.studentProCity = studentProCity == null ? null : studentProCity.trim();
    }

    /** 
     * 获取 类型 student_info.student_type
     * @return 类型
     */
    public String getStudentType() {
        return studentType;
    }

    /** 
     * 设置 类型 student_info.student_type
     * @param studentType 类型
     */
    public void setStudentType(String studentType) {
        this.studentType = studentType == null ? null : studentType.trim();
    }

    /** 
     * 获取 是否缴费 student_info.student_ispay
     * @return 是否缴费
     */
    public String getStudentIspay() {
        return studentIspay;
    }

    /** 
     * 设置 是否缴费 student_info.student_ispay
     * @param studentIspay 是否缴费
     */
    public void setStudentIspay(String studentIspay) {
        this.studentIspay = studentIspay == null ? null : studentIspay.trim();
    }

    /** 
     * 获取 意向状态 student_info.student_sate
     * @return 意向状态
     */
    public Integer getStudentSate() {
        return studentSate;
    }

    /** 
     * 设置 意向状态 student_info.student_sate
     * @param studentSate 意向状态
     */
    public void setStudentSate(Integer studentSate) {
        this.studentSate = studentSate;
    }

    /** 
     * 获取 标识 student_info.student_mark
     * @return 标识
     */
    public String getStudentMark() {
        return studentMark;
    }

    /** 
     * 设置 标识 student_info.student_mark
     * @param studentMark 标识
     */
    public void setStudentMark(String studentMark) {
        this.studentMark = studentMark == null ? null : studentMark.trim();
    }

    /** 
     * 获取 描述 student_info.student_desc
     * @return 描述
     */
    public String getStudentDesc() {
        return studentDesc;
    }

    /** 
     * 设置 描述 student_info.student_desc
     * @param studentDesc 描述
     */
    public void setStudentDesc(String studentDesc) {
        this.studentDesc = studentDesc == null ? null : studentDesc.trim();
    }

    /** 
     * 获取 账号 student_info.student_number
     * @return 账号
     */
    public String getStudentNumber() {
        return studentNumber;
    }

    /** 
     * 设置 账号 student_info.student_number
     * @param studentNumber 账号
     */
    public void setStudentNumber(String studentNumber) {
        this.studentNumber = studentNumber == null ? null : studentNumber.trim();
    }

    /** 
     * 获取 密码 student_info.student_password
     * @return 密码
     */
    public String getStudentPassword() {
        return studentPassword;
    }

    /** 
     * 设置 密码 student_info.student_password
     * @param studentPassword 密码
     */
    public void setStudentPassword(String studentPassword) {
        this.studentPassword = studentPassword == null ? null : studentPassword.trim();
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append(", studentId=").append(studentId);
        sb.append(", staffId=").append(staffId);
        sb.append(", classId=").append(classId);
        sb.append(", studentName=").append(studentName);
        sb.append(", studentSex=").append(studentSex);
        sb.append(", studentAge=").append(studentAge);
        sb.append(", studentTellphone=").append(studentTellphone);
        sb.append(", studentEmail=").append(studentEmail);
        sb.append(", studentIdcard=").append(studentIdcard);
        sb.append(", studentAddress=").append(studentAddress);
        sb.append(", studentBirthday=").append(studentBirthday);
        sb.append(", studentSchool=").append(studentSchool);
        sb.append(", studentQq=").append(studentQq);
        sb.append(", studentParentsName=").append(studentParentsName);
        sb.append(", studentParentsPhone=").append(studentParentsPhone);
        sb.append(", studentPro=").append(studentPro);
        sb.append(", studentProCity=").append(studentProCity);
        sb.append(", studentType=").append(studentType);
        sb.append(", studentIspay=").append(studentIspay);
        sb.append(", studentSate=").append(studentSate);
        sb.append(", studentMark=").append(studentMark);
        sb.append(", studentDesc=").append(studentDesc);
        sb.append(", studentNumber=").append(studentNumber);
        sb.append(", studentPassword=").append(studentPassword);
        sb.append("]");
        return sb.toString();
    }
}