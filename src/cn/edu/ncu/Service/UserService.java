package cn.edu.ncu.Service;

import cn.edu.ncu.vo.Meeting;
import cn.edu.ncu.vo.User;

import java.util.List;

public interface UserService {
    public int login(String name,String password);
    public User getUser(String name,String password);
    public boolean addUser(User user);
    public List<Meeting> showMyMeetingsByUser(String username);
}
