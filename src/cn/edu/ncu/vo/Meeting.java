package cn.edu.ncu.vo;

import java.sql.Timestamp;

public class Meeting {
    private String idmeeting;
    private String namemeeting;
    private String placemeeting;
    private int roomid;
    private Timestamp starttime;
    private Timestamp endtime;
    private int pnums;
    private String description;

    public Meeting(String idmeeting, String namemeeting, String placemeeting, int roomid, Timestamp starttime, Timestamp endtime, int pnums, String description) {
        this.idmeeting = idmeeting;
        this.namemeeting = namemeeting;
        this.placemeeting = placemeeting;
        this.roomid = roomid;
        this.starttime = starttime;
        this.endtime = endtime;
        this.pnums = pnums;
        this.description = description;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getIdmeeting() {
        return idmeeting;
    }

    public void setIdmeeting(String idmeeting) {
        this.idmeeting = idmeeting;
    }

    public String getNamemeeting() {
        return namemeeting;
    }

    public void setNamemeeting(String namemeeting) {
        this.namemeeting = namemeeting;
    }

    public String getPlacemeeting() {
        return placemeeting;
    }

    public void setPlacemeeting(String placemeeting) {
        this.placemeeting = placemeeting;
    }

    public int getRoomid() {
        return roomid;
    }

    public void setRoomid(int roomid) {
        this.roomid = roomid;
    }

    public Timestamp getStarttime() {
        return starttime;
    }

    public void setStarttime(Timestamp starttime) {
        this.starttime = starttime;
    }

    public Timestamp getEndtime() {
        return endtime;
    }

    public void setEndtime(Timestamp endtime) {
        this.endtime = endtime;
    }

    public int getPnums() {
        return pnums;
    }

    public void setPnums(int pnums) {
        this.pnums = pnums;
    }
    @Override
    public String toString() {
        return this.getNamemeeting()+"-"+this.getPlacemeeting()+"-"+this.getStarttime()+""+this.getEndtime();
    }

}
