package cn.edu.ncu.Service.Impl;

import cn.edu.ncu.Dao.UserDao;
import cn.edu.ncu.Dao.impl.UserDaoImpl;
import cn.edu.ncu.Service.UserService;
import cn.edu.ncu.vo.Meeting;
import cn.edu.ncu.vo.User;

import java.util.List;

public class UserServiceImpl implements UserService {
    private UserDao userDao=new UserDaoImpl();


    @Override
    //判断登录状态，登录成功或失败
    public int login(String name, String password) {
        //返回值为0表示登录失败
        User loginUser = userDao.login(name, password);
        return loginUser.getRole();
    }

    @Override
    public User getUser(String name, String password) {
        return userDao.login(name,password);

    }

    @Override
    public boolean addUser(User user) {
        return userDao.addUser(user);
    }

    @Override
    public List<Meeting> showMyMeetingsByUser(String username) {
        return userDao.showMyMeetingsByUser(username);
    }

    @Override
    public boolean UpdataUserByUsername(String username,int role) {
        return userDao.UpdataUserByUsername(username,role);
    }

    @Override
    public List<User> ShowAllUsers() {
        return userDao.ShowAllUsers();
    }

}
