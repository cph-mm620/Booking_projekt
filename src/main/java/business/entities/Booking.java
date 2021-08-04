package business.entities;
import java.time.LocalDate;

public class Booking
{
    private int booking_id;
    private String booking_date;
    private int days;
    private String comment;
    private boolean booking_status;
    private int users_id;
    private int item_id;


    public Booking(String booking_date, int days, String comment, boolean booking_status, int users_id, int item_id) {
        this.booking_date=booking_date;
        this.days=days;
        this.comment=comment;
        this.booking_status=booking_status;
        this.users_id=users_id;
        this.item_id=item_id;

    }


    public Booking(int days, String booking_date, boolean booking_status, int booking_id) {
        this.days = days;
        this.booking_date = booking_date;
        this.booking_status = booking_status;
        this.booking_id = booking_id;
    }




    public int getBooking_id() {
        return booking_id;
    }

    public void setBooking_id(int booking_id) {
        this.booking_id = booking_id;
    }

    public String getBooking_date() {
        return booking_date;
    }

    public void setBooking_date(String booking_date) {
        this.booking_date = booking_date;
    }

    public int getDays() {
        return days;
    }

    public void setDays(int days) {
        this.days = days;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public boolean getBooking_status() {
        return booking_status;
    }

    public void setBooking_status(boolean booking_status) {
        this.booking_status = booking_status;
    }

    public boolean isBooking_status() {
        return booking_status;
    }

    public int getUsers_id() {
        return users_id;
    }

    public void setUsers_id(int users_id) {
        this.users_id = users_id;
    }

    public int getItem_id() {
        return item_id;
    }

    public void setItem_id(int item_id) {
        this.item_id = item_id;
    }
}
