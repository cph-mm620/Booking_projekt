package business.persistence;

import business.entities.Booking;
import business.entities.User;
import business.exceptions.UserException;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class BookingMapper {

    Database database;
    public BookingMapper(Database database) {

        this.database = database;
    }

    public Booking addNewBooking(Booking booking) throws UserException {
        try (Connection connection = database.connect()) {
            String sql = "INSERT INTO booking SET days = ?, booking_date = ?, booking_status = ?, users_id =?, item_id = ?";

            try (PreparedStatement ps = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS))
            {
                ps.setInt(1, booking.getDays());
                ps.setString(2, booking.getBooking_date());
                ps.setBoolean(3, booking.isBooking_status());
                ps.setInt(4, booking.getUsers_id());
                ps.setInt(5, booking.getItem_id());


                ps.executeUpdate();
                ResultSet booking_id = ps.getGeneratedKeys();
                booking_id.next();

            }

        } catch (SQLException ex) {
            throw new UserException(ex.getMessage());
        }
        return booking;
    }
    public List<Booking> getAllBookings() throws UserException{
        List<Booking> bookingList = new ArrayList<>();

        try (Connection connection = database.connect())
        {
            String sql = "SELECT * FROM booking";

            try (PreparedStatement ps = connection.prepareStatement(sql))
            {

                ResultSet rs = ps.executeQuery();
                while (rs.next()) {
                    String booking_date = rs.getString("booking_date");
                    int days = rs.getInt("days");
                    String comment = rs.getString("comment");
                    boolean booking_status = rs.getBoolean("booking_status");
                    int users_id = rs.getInt("users_id");
                    int item_id = rs.getInt("item_id");


                    Booking booking = new Booking(booking_date,days,comment,booking_status,users_id,item_id);
                    booking.setItem_id(item_id);
                    bookingList.add(booking);
                }
            }
            catch (SQLException ex)
            {
                throw new UserException(ex.getMessage());
            }
        }
        catch (SQLException ex)
        {
            throw new UserException("Connection to database could not be established");
        }


        return bookingList;
    }
}
