package cn.edu.ncu.Dao.impl;

import cn.edu.ncu.Util.JDBCUtil;
import cn.edu.ncu.Dao.MeetingDao;
import cn.edu.ncu.vo.Meeting;
import cn.edu.ncu.vo.User;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class MeetingImpl implements MeetingDao {
    @Override
    public boolean addMeeting(Meeting meeting) {
        String sql ="insert into meeting(idmeeting,namemeeting,placemeeting,roomid,starttime,endtime,pnums,description) values(?,?,?,?,?,?,?,?);" ;
        Object[] params = {meeting.getIdmeeting(),meeting.getNamemeeting(),meeting.getPlacemeeting(), meeting.getRoomid(),meeting.getStarttime(),meeting.getEndtime(),meeting.getPnums(),meeting.getDescription()};
        return JDBCUtil.executeUpdate(sql, params) ;

    }

    @Override
    public List<Meeting> getAllMeeting() {
        String sql="select *from meeting;";
       List<Meeting> Meetings=new ArrayList<>();
        ResultSet rs=JDBCUtil.executeQuery(sql);
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
                    Meetings.add(meeting);
            }
            return Meetings;

        }catch (SQLException e) {
            e.printStackTrace();
        }catch (Exception e) {
            e.printStackTrace();
        }finally {
            JDBCUtil.closeAll(rs, JDBCUtil.pstmt, JDBCUtil.connection);
        }
        return null;
    }

    @Override
    public Meeting getMeetingById(String idmeeting) {
        String sql="select *from meeting where idmeeting='"+idmeeting+"';";
        ResultSet rs=JDBCUtil.executeQuery(sql);
        try{
            if(rs.next()){
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
                return meeting;
            }
        }catch (SQLException e) {
            e.printStackTrace();
        }catch (Exception e) {
            e.printStackTrace();
        }finally {
            JDBCUtil.closeAll(rs, JDBCUtil.pstmt, JDBCUtil.connection);
        }
        return null;
    }

    @Override
    public List<User> getMeetingUsers(String idmeeting) {
        String sql="select *from user where username IN(SELECT username from meetingusers where  idmeeting='"+idmeeting+"');";
        ResultSet rs=JDBCUtil.executeQuery(sql);
        List<User> users=new ArrayList<>();
        try {
            while (rs.next()){
                User user=new User(
                        rs.getString("username"),
                        rs.getString("password"),
                        rs.getString("name"),
                        rs.getString("workunit"),
                        rs.getString("idcard"),
                        rs.getInt("phone"),
                        rs.getString("sex"),
                        rs.getInt("role")
                );
                users.add(user);
            }
            return users;
        }catch (SQLException e) {
            e.printStackTrace();
        }catch (Exception e) {
            e.printStackTrace();
        }finally {
            JDBCUtil.closeAll(rs, JDBCUtil.pstmt, JDBCUtil.connection);
        }
        return null;
    }

    @Override
    public boolean AttendMeetingById(String idmeeting, String username) {
        if(!isUserExits(idmeeting,username)) {
            Object[] obs = {idmeeting, username};
            String sql = "INSERT INTO meetingusers(idmeeting,username) VALUES (?,?);";
            return JDBCUtil.executeUpdate(sql, obs);
        }
        else return false;
    }

    @Override
    public boolean isUserExits(String idmeeting, String username) {
        String sql="select *from meetingusers where idmeeting='"+idmeeting+"' and username='"+username+"';";
        ResultSet rs=JDBCUtil.executeQuery(sql);
        try {
            if(rs.next())
                return true;

        }catch (SQLException e) {
            e.printStackTrace();
        }catch (Exception e) {
            e.printStackTrace();
        }finally {
            JDBCUtil.closeAll(rs, JDBCUtil.pstmt, JDBCUtil.connection);
        }
        return false;
    }
//只是
    @Override
    public boolean UpdataMeetingById(String idmeeting) {
        String sql="delete from meeting where  idmeeting='"+idmeeting+"';";
        return JDBCUtil.executeUpdate(sql,null);

    }

}
