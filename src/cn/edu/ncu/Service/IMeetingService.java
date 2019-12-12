package cn.edu.ncu.Service;

import cn.edu.ncu.vo.Meeting;
import cn.edu.ncu.vo.User;

import java.util.List;

public interface IMeetingService {
    public  boolean addMeeting(Meeting meeting);
    public Meeting getMeetingById(String idmeeting);
    public List<Meeting> getAllMeeting();
    public List<User> getMeetingUsers(String idmeeting);
    public boolean AttendMeeingById(String idmeeting,String username);
    public boolean UpdataMeetingById(String idmeeting);
}
