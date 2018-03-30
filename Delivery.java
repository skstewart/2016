/*
Project 1: Delivery Scheduler
Name: Shayna Stewart
Date: 20 September, 2016
What: CS 182 Lab Project 1
Description: creates delivery objects, allows user to input deliveries
 */

/**
 *
 * @author Student-HSLH133
 */
public class Delivery {

    /**
     * @param args the command line arguments
     */
    private String month;
    private String message;
    private int day;
    private int hour;
    private int minute;
    private int monthNum;

    public static void main(String[] args) {
        Delivery delivery = new Delivery();
        delivery.inputDelivery();
        System.out.println(delivery);

        Delivery delivery2 = new Delivery("may", 5, 2, 4, 10, "5 million bees");

        System.out.println(delivery2);

    }

    Delivery() {
        month = "jan";
        //setMonthNum("jan");
        day = 1;
        hour = 0;
        minute = 0;
        message = "none";

    }

    Delivery(String setMonth, int setMonthNum, int setDay, int setHour, int setMinute, String setMessage) {

        month = setMonth;
        monthNum = setMonthNum;
        day = setDay;
        hour = setHour;
        minute = setHour;
        message = setMessage;
    }

    public void inputDelivery() {

        month = (UserInput.getString(3, 3));
        setMonth(month);
        day = (UserInput.getInt(1, 31));
        hour = (UserInput.getInt(0, 23));
        minute = (UserInput.getInt(0, 59));
        message = (UserInput.getString(0, 60));

    }

    public void setMonth(String setMonth) {
        month = setMonth;
        switch (month) {
            case "Jan": {
                month = "Jan";
                monthNum = 1;
                break;
            }
            case "Feb": {
                month = "Feb";
                monthNum = 2;
                break;
            }
            case "Mar": {
                month = "Mar";
                monthNum = 3;
                break;
            }
            case "Apr": {
                month = "Apr";
                monthNum = 4;
                break;
            }
            case "May": {
                month = "May";
                monthNum = 5;
                break;
            }
            case "Jun": {
                month = "Jun";
                monthNum = 6;
                break;
            }
            case "Jul": {
                month = "Jul";
                monthNum = 7;
                break;
            }
            case "Aug": {
                month = "Aug";
                monthNum = 8;
                break;
            }
            case "Sep": {
                month = "Sep";
                monthNum = 9;
                break;
            }
            case "Oct": {
                month = "Oct";
                monthNum = 10;
                break;
            }
            case "Nov": {
                month = "Nov";
                monthNum = 11;
                break;
            }
            case "Dec": {
                month = "Dec";
                monthNum = 12;
                break;
            }
            case "jan": {
                month = "Jan";
                monthNum = 1;
                break;
            }
            case "feb": {
                month = "Feb";
                monthNum = 2;
                break;
            }
            case "mar": {
                month = "Mar";
                monthNum = 3;
                break;
            }
            case "apr": {
                month = "Apr";
                monthNum = 4;
                break;
            }
            case "may": {
                month = "May";
                monthNum = 5;
                break;
            }
            case "jun": {
                month = "Jun";
                monthNum = 6;
                break;
            }
            case "jul": {
                month = "Jul";
                monthNum = 7;
                break;
            }
            case "aug": {
                month = "Aug";
                monthNum = 8;
                break;
            }
            case "sep": {
                month = "Sep";
                monthNum = 9;
                break;
            }
            case "oct": {
                month = "Oct";
                monthNum = 10;
                break;
            }
            case "nov": {
                month = "Nov";
                monthNum = 11;
                break;
            }
            case "dec": {
                month = "Dec";
                monthNum = 12;
                break;
            }
            default: {
                System.out.println("Invalid input, try again!");
                month = (UserInput.getString(3, 3));
                setMonth(month);
                break;
            }

        }

    }

    public void setDay(int setDay) {
        day = setDay;
    }

    public void setHour(int setHour) {
        hour = setHour;
    }

    public void setMinute(int setMinute) {
        minute = setMinute;

    }

    public void setMessage(String setMessage) {
        message = setMessage;
    }

    public String getMonth() {
        return month;
    }

    public int getMonthNum() {

        return monthNum;
    }

    public int getDay() {
        return day;
    }

    public int getHour() {
        return hour;
    }

    public int getMinute() {
        return minute;
    }

    public String getMessage() {
        return message;
    }

    @Override
    public String toString() {
        if (minute >= 0 && minute < 10) {
            return this.month + " " + this.day + ", " + this.hour + ":0" + this.minute + " " + this.message;
        }
        return this.month + " " + this.day + ", " + this.hour + ":" + this.minute + " " + this.message;

    }
}
