package assignment.hani;

import java.util.Scanner;

public class TVShow implements Watchable, Cloneable{
    private String showID;
    private String showName;
    private double startTime;
    private double endTime;

    public TVShow() {
    }

    public TVShow(String showID, String showName, double startTime, double endTime) {
        this.showID = showID;
        this.showName = showName;
        this.startTime = startTime;
        this.endTime = endTime;
    }

    public TVShow(TVShow otherShow, String showID){
        this.showID = showID;
        showName = otherShow.showName;
        startTime = otherShow.startTime;
        endTime = otherShow.endTime;
    }

    public TVShow(TVShow show) {
        showID = show.showID;
        showName = show.showName;
        startTime = show.startTime;
        endTime = show.endTime;
    }

    public Object clone(){
        Scanner keyIn = new Scanner(System.in);
        System.out.print("Please enter a new showID for " + showID + ": ");
        String newID = keyIn.next();
        try{
            TVShow copy = (TVShow)super.clone();
            copy.showID = newID;
            return copy;
        }catch(CloneNotSupportedException e){
            return null;
        }
    }

    public String getShowID() {
        return showID;
    }

    public void setShowID(String showID) {
        this.showID = showID;
    }

    public String getShowName() {
        return showName;
    }

    public void setShowName(String showName) {
        this.showName = showName;
    }

    public double getStartTime() {
        return startTime;
    }

    public void setStartTime(double startTime) {
        this.startTime = startTime;
    }

    public double getEndTime() {
        return endTime;
    }

    public void setEndTime(double endTime) {
        this.endTime = endTime;
    }

    @Override
    public String toString() {
        return "TVShow{" +
                "showID='" + showID + '\'' +
                ", showName='" + showName + '\'' +
                ", startTime=" + startTime +
                ", endTime=" + endTime +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        TVShow tvShow = (TVShow) o;

        if (Double.compare(tvShow.startTime, startTime) != 0) return false;
        if (Double.compare(tvShow.endTime, endTime) != 0) return false;
        return showName != null ? showName.equals(tvShow.showName) : tvShow.showName == null;
    }

    @Override
    public String isOnSameTime(TVShow S) {
        if (startTime == S.startTime && endTime == S.endTime)
            return "Same time";
        else if (startTime >= S.endTime || S.startTime >= endTime )
            return "Different time";
        else
            return "Some Overlap";
    }
}
