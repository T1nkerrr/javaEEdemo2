package com.example.javaeedemo2.manager;
import java.sql.Date;

public class Manager {
    private Integer cmId;           // 客户经理编号
    private String cmName;         // 姓名
    private String cmSex;          // 性别
    private String cmSsn;          // 身份证号
    private Date cmBirthday;      // 生日
    private Integer cmAge;         // 年龄
    private String cmNation;       // 民族
    private String cmPolitical;    // 政治面貌
    private String cmHometown;     // 家乡

    public String getCmNation() {
        return cmNation;
    }

    public void setCmNation(String cmNation) {
        this.cmNation = cmNation;
    }

    public Integer getCmId() {
        return cmId;
    }

    public void setCmId(Integer cmId) {
        this.cmId = cmId;
    }

    public String getCmName() {
        return cmName;
    }

    public void setCmName(String cmName) {
        this.cmName = cmName;
    }

    public String getCmSex() {
        return cmSex;
    }

    public void setCmSex(String cmSex) {
        this.cmSex = cmSex;
    }

    public String getCmSsn() {
        return cmSsn;
    }

    public void setCmSsn(String cmSsn) {
        this.cmSsn = cmSsn;
    }

    public Date getCmBirthday() {
        return cmBirthday;
    }

    public void setCmBirthday(Date cmBirthday) {
        this.cmBirthday = cmBirthday;
    }

    public Integer getCmAge() {
        return cmAge;
    }

    public void setCmAge(Integer cmAge) {
        this.cmAge = cmAge;
    }

    public String getCmPolitical() {
        return cmPolitical;
    }

    public void setCmPolitical(String cmPolitical) {
        this.cmPolitical = cmPolitical;
    }

    public String getCmHometown() {
        return cmHometown;
    }

    public void setCmHometown(String cmHometown) {
        this.cmHometown = cmHometown;
    }
}
