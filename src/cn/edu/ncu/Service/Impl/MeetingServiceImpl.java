package cn.edu.ncu.Service.Impl;

import cn.edu.ncu.Dao.MeetingDao;
import cn.edu.ncu.Dao.impl.MeetingImpl;
import cn.edu.ncu.Service.IMeetingService;
import cn.edu.ncu.vo.Meeting;
import cn.edu.ncu.vo.User;

import java.util.List;

public class MeetingServiceImpl implements IMeetingService {

    @Override
    public  boolean addMeeting(Meeting meeting) {
        MeetingDao meetingDao=new MeetingImpl();
        return meetingDao.addMeeting(meeting);
    }

    @Override
    public Meeting getMeetingById(String idmeeting) {
        MeetingDao meetingDao=new MeetingImpl();
        return meetingDao.getMeetingById(idmeeting);
    }

    @Override
    public List<Meeting> getAllMeeting() {
        MeetingDao meetingDao=new MeetingImpl();
        return meetingDao.getAllMeeting();
    }

    @Override
    public List<User> getMeetingUsers(String idmeeting) {
        MeetingDao meetingDao=new MeetingImpl();
        return meetingDao.getMeetingUsers(idmeeting);
    }

    @Override
    public boolean AttendMeeingById(String idmeeting,String name) {
        MeetingDao meetingDao=new MeetingImpl();
        return meetingDao.AttendMeetingById(idmeeting,name);
    }

    @Override
    public boolean UpdataMeetingById(String idmeeting) {
        MeetingDao meetingDao=new MeetingImpl();
        return meetingDao.UpdataMeetingById(idmeeting);
    }


}
