package cn.edu.ncu.Dao;

import cn.edu.ncu.vo.Meeting;
import cn.edu.ncu.vo.User;

import java.util.List;

public interface UserDao {
    public User login(String name,String password);
    public boolean addUser(User user);
    public boolean isUsernameExists(String name);
    public List<Meeting> showMyMeetingsByUser(String username);
    public boolean UpdataUserByUsername(String username,int role);
    public List<User> ShowAllUsers();

}
