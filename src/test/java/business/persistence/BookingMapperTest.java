package business.persistence;

import business.entities.Booking;
import business.entities.Item;
import business.entities.User;
import business.exceptions.UserException;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.sql.SQLException;
import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.*;

class BookingMapperTest {
    BookingMapper bookingMapper;
    Database database;
    Item item;
    User user;
    Booking booking;
    private final static String DATABASE = "booking";  // Change this to your own database
    private final static String TESTDATABASE = DATABASE + "_test";
    private final static String USER = "dev";
    private final static String PASSWORD = "ax2";
    private final static String URL = "jdbc:mysql://localhost:3306/" + TESTDATABASE + "?serverTimezone=CET&useSSL=false";
//TODO: husk at lave en test database booking_test

    @BeforeEach
    void setUp() throws ClassNotFoundException {
        database = new Database(USER, PASSWORD, URL);
        bookingMapper = new BookingMapper(database);
        item = new Item(1,"Oculus Quest 2", "medialab", 212,"VR-headset","vr-2");
        user = new User("m@m.dk", "12", "student");
        user.setId(1);
        booking = null;
    }

    @Test
    void addNewBooking() throws UserException {
        LocalDate booking_date = LocalDate.now();
        //booking = new Booking(booking_date, 2, "", false, user.getId(), item.getItem_id());
        bookingMapper.addNewBooking(booking);
    }
}