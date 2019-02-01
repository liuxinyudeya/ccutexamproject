package org.liuxinyu.project.login.entity;

/**
 * @author liuxinyu
 * @date 2019/1/31 0031 - 12:20
 */
public class Account {
    private String newusername;
    private String username;
    private String password;
    private String roleCode;

    @Override
    public String toString() {
        return "Account{" +
                "newusername='" + newusername + '\'' +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", roleCode='" + roleCode + '\'' +
                '}';
    }

    public String getNewusername() {
        return newusername;
    }

    public void setNewusername(String newusername) {
        this.newusername = newusername;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getRoleCode() {
        return roleCode;
    }

    public void setRoleCode(String roleCode) {
        this.roleCode = roleCode;
    }
}
