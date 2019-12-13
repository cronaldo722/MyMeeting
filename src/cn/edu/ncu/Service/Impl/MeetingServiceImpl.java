package cn.edu.ncu.Service.Impl;

import cn.edu.ncu.Dao.MeetingDao;
import cn.edu.ncu.Dao.impl.MeetingImpl;
import cn.edu.ncu.Service.IMeetingService;
import cn.edu.ncu.vo.Meeting;
import cn.edu.ncu.vo.User;

import java.util.List;

public class MeetingServiceImpl implements IMeetingService {
    private MeetingDao meetingDao=new MeetingImpl();

    @Override
    public  boolean addMeeting(Meeting meeting) {
        return meetingDao.addMeeting(meeting);
    }

    @Override
    public Meeting getMeetingById(String idmeeting) {
        return meetingDao.getMeetingById(idmeeting);
    }

    @Override
    public List<Meeting> getAllMeeting() {
        return meetingDao.getAllMeeting();
    }

    @Override
    public List<User> getMeetingUsers(String idmeeting) {
        return meetingDao.getMeetingUsers(idmeeting);
    }

    @Override
    public boolean AttendMeeingById(String idmeeting,String name) {
        return meetingDao.AttendMeetingById(idmeeting,name);
    }

    @Override
    public boolean UpdataMeetingById(String idmeeting) {
        return meetingDao.UpdataMeetingById(idmeeting);
    }


}
