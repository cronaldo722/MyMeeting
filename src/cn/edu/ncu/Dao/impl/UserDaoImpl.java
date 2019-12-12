package cn.edu.ncu.Dao.impl;

import cn.edu.ncu.Dao.JDBCUtil;
import cn.edu.ncu.Dao.UserDao;
import cn.edu.ncu.Service.IMeetingService;
import cn.edu.ncu.Service.Impl.MeetingServiceImpl;
import cn.edu.ncu.vo.Meeting;
import cn.edu.ncu.vo.User;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class UserDaoImpl implements UserDao {

    @Override
    public User login(String name, String password) {
        String sql="SELECT * FROM user WHERE username='" + name + "'AND password='"+password+"'";
        ResultSet rs= JDBCUtil.executeQuery(sql);
        try {
            while(rs.next()) {
               return new User(
                        rs.getString("username"),
                        rs.getString("password"),
                        rs.getString("name"),
                        rs.getString("workunit"),
                        rs.getString("idcard"),
                        rs.getInt("phone"),
                        rs.getString("sex"),
                        rs.getInt("role")
                );
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }catch (Exception e) {
            e.printStackTrace();
        }finally {
            JDBCUtil.closeAll(rs, JDBCUtil.pstmt, JDBCUtil.connection);
        }
        return null;
    }

    @Override
    public boolean addUser(User user) {
        if (isUsernameExists(user.getUsername())) {
            return false;
        }else {
            Object[] obs={user.getUsername(),user.getPassword(),user.getName(),user.getWorkunit(),user.getIdcard(),user.getPhone(),user.getSex(),user.getRole()};
            String sql="INSERT INTO employee(id,password,username,workunit,idcard,phone,sex,role) VALUES (?,?,?,?,?,?,?,?);";
            return JDBCUtil.executeUpdate(sql,obs);
        }

    }

    @Override
    public boolean isUsernameExists(String name) {
        String sql="select *from user where username='"+name+"';";
        ResultSet rs=JDBCUtil.executeQuery(sql);
        try{
            if(rs.next())
                return false;

        }catch (SQLException e) {
            e.printStackTrace();
        }catch (Exception e) {
            e.printStackTrace();
        }finally {
            JDBCUtil.closeAll(rs, JDBCUtil.pstmt, JDBCUtil.connection);
        }
        return true;
    }

    @Override
    public List<Meeting> showMyMeetingsByUser(String username) {
        String sql="select *from meeting where idmeeting IN(SELECT idmeeting from meetingusers where  username='"+username+"');";
        ResultSet rs=JDBCUtil.executeQuery(sql);
        List<Meeting> MyMeetings=new ArrayList<>();
        try{
                while (rs.next()){
                Meeting meeting=new Meeting(
                        rs.getString("idmeeting"),
                        rs.getString("namemeeting"),
                        rs.getString("placemeeting"),
                        rs.getInt("roomid"),
                        rs.getTimestamp("starttime"),
                        rs.getTimestamp("endtime"),
                        rs.getInt("pnums"),
                        rs.getString("description")
                );
                MyMeetings.add(meeting);
                }
                return MyMeetings;

        }catch (SQLException e) {
            e.printStackTrace();
        }catch (Exception e) {
            e.printStackTrace();
        }finally {
            JDBCUtil.closeAll(rs, JDBCUtil.pstmt, JDBCUtil.connection);
        }
        return null;
    }
}
