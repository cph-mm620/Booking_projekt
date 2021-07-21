package web.commands;

import business.entities.Booking;
import business.entities.User;
import business.exceptions.UserException;
import business.persistence.UserMapper;
import business.services.NewBookingFacade;
import business.services.UserFacade;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.time.LocalDate;

public class NewBookingCommand extends CommandProtectedPage {
    UserFacade userFacade;
    UserMapper userMapper;

    NewBookingFacade NewBookingFacade = new NewBookingFacade(database);


    public NewBookingCommand(String pageToShow, String role) {
        super(pageToShow, role);
        userFacade = new UserFacade(database);
        userMapper = new UserMapper(database);
    }

    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) throws UserException
    {
        HttpSession session = request.getSession();

        User user = (User) session.getAttribute("user");
        int userId = user.getId();
        int itemId = Integer.parseInt(request.getParameter("item"));
        int days = 0;
        boolean booking_status = false;

        try {
            days = Integer.parseInt(request.getParameter("days" + itemId));
        }
        catch (NumberFormatException e){
            throw new UserException("Husk at indtaste et antal dage!!!");
        }
        LocalDate booking_date = LocalDate.now(); // .plusDays(days);


        String comment = request.getParameter("comment");
        Booking booking = NewBookingFacade.addNewBooking(userId, String.valueOf(booking_date), booking_status, itemId, days, comment);
        // call a method in the UserMapper by name: subtractPoints(int points)
        userFacade.subtractsPoints(days,userId);
        request.setAttribute("booking", booking);
        return pageToShow;
    }
}
