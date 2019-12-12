package cn.edu.ncu.Dao;

import cn.edu.ncu.vo.Meeting;
import cn.edu.ncu.vo.User;

import java.util.List;

public interface MeetingDao {
    //添加会议
    public boolean addMeeting(Meeting meeting);
    public List<Meeting> getAllMeeting();
    public Meeting getMeetingById(String idmeeting);
    public List<User> getMeetingUsers(String idmeeting);
    public boolean AttendMeetingById(String idmeeting,String username);
    public boolean isUserExits(String idmeeting,String username);
    public boolean UpdataMeetingById(String idmeeting);


}
