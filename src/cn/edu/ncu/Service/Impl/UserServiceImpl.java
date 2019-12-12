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
        if(loginUser.getRole()==1){
            return 1;
            //会议组织者
        }
        if(loginUser.getRole()==2){
            return 2;
            //表示为普通用户
        }
        return 0;
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

}
