package cn.edu.ncu.vo;

public class User {
    private String username;
    private String password;
    private String name;
    private String workunit;
    private String idcard;
    private int phone;
    private String sex;
    private int role=2;
    //用户注册默认为普通用户

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public User(String username, String password, String name, String workunit, String idcard, int phone, String sex, int role) {
        this.username = username;
        this.password = password;
        this.name = name;
        this.workunit = workunit;
        this.idcard = idcard;
        this.phone = phone;
        this.sex = sex;
        this.role = role;
    }

    public int getRole() {
        return role;
    }

    public void setRole(int role) {
        this.role = role;
    }


    public User(){

    }


    public String getWorkunit() {
        return workunit;
    }

    public void setWorkunit(String workunit) {
        this.workunit = workunit;
    }

    public String getIdcard() {
        return idcard;
    }

    public void setIdcard(String idcard) {
        this.idcard = idcard;
    }

    public int getPhone() {
        return phone;
    }

    public void setPhone(int phone) {
        this.phone = phone;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    @Override
    public String toString() {
        return this.getName()+"-"+this.getUsername()+"-"+this.getPhone()+"";
    }
}
