package com.mybatis.entity;

import java.util.Date;

/**
 * @ClassName: User
 * @Description: TODO(�û�ʵ��)
 * @author warcaft
 * @date 2015-6-27 ����1:56:02
 * 
 */
public class User {
    // �������ƺ����ݿ��ֶ����Ʊ���һ��
    private Integer id;
    // ����
    private String username;
    // �Ա�
    private String sex;
    // ��ַ
    private String address;
    // ����
    private Date birthday;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public Date getBirthday() {
        return birthday;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }

    @Override
    public String toString() {
        return "User [id=" + id + ", username=" + username + ", sex=" + sex
                + ", address=" + address + ", birthday=" + birthday + "]";
    }

}