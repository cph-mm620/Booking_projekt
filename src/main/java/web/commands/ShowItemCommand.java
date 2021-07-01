package web.commands;

import apple.laf.JRSUIConstants;
import business.exceptions.UserException;
import business.services.ItemFacade;
import business.services.StudentFacade;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class ShowItemCommand extends CommandProtectedPage {

    //StudentFacade studentFacade;
    ItemFacade itemFacade;
    public ShowItemCommand(String pageToShow, String role) {

        super(pageToShow, role);
        //studentFacade = new StudentFacade(database);

        itemFacade = new ItemFacade(database);
    }




    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) throws UserException {

        request.setAttribute("itemList", itemFacade.getAllItems());
        return pageToShow;
    }
}
