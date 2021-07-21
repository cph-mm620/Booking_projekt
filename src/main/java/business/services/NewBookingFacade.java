package business.services;

import business.entities.Booking;
import business.exceptions.UserException;
import business.persistence.BookingMapper;
import business.persistence.Database;

public class NewBookingFacade
{
    private BookingMapper bookingMapper;

    public NewBookingFacade(Database database){this.bookingMapper = new BookingMapper(database);}

    public Booking addNewBooking(int users_id, String booking_date, boolean booking_status, int item_id, int days, String comment) throws UserException
    {
        Booking booking = new Booking(comment, users_id, booking_date, booking_status, item_id, days);
        booking = bookingMapper.addNewBooking(booking);
        return booking;
    }

}
