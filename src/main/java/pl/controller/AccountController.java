package pl.controller;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import pl.model.User;

import javax.servlet.http.HttpSession;

@Scope("session")
@RequestMapping("/account")
@Controller()
public class AccountController {

    @RequestMapping("/profile")
    public ModelAndView showProfile(HttpSession session){
        Object user =  session.getAttribute("logInUser");
        if(user instanceof User)
            return new ModelAndView("profile");
        return new ModelAndView("redirect:/login");
    }

    @RequestMapping("/logout")
    public ModelAndView logout(HttpSession session){
        session.setAttribute("logInUser", null);
        return new ModelAndView("redirect:/login");
    }

}
