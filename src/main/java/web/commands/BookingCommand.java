package web.commands;

import business.exceptions.UserException;
import business.services.BookingFacade;
import business.services.ItemFacade;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class BookingCommand extends CommandProtectedPage {

    //StudentFacade studentFacade;
    BookingFacade bookingFacade;
    public BookingCommand(String pageToShow, String role) {

        super(pageToShow, role);
        //studentFacade = new StudentFacade(database);

        bookingFacade = new BookingFacade(database);
    }




    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) throws UserException {

        request.setAttribute("bookingList", bookingFacade.getAllBookings());
        return pageToShow;
    }
}
