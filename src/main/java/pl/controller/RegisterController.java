package pl.controller;

import org.apache.commons.lang3.tuple.Pair;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import pl.dto.LoginUserDTO;
import pl.dto.RegisterUserDTO;
import pl.model.User;
import pl.services.UserService;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;
import java.util.Optional;

@Controller
public class RegisterController {

    @Autowired
    private UserService userService;

    @Autowired
    private ModelMapper modelMapper;

    @RequestMapping("/register")
    public ModelAndView getRegisterForm(Model model){
        model.addAttribute("registerUserDTO", new RegisterUserDTO());
        return new ModelAndView("register");
    }

    @RequestMapping({"/login", "/"})
    public ModelAndView getLoginForm(Model model){
        model.addAttribute("loginUserDTO", new User());
        return new ModelAndView("login");
    }

    @RequestMapping(value = "/register", method = RequestMethod.POST)
    public ModelAndView register(@Valid @ModelAttribute("registerUserDTO") RegisterUserDTO candidate,
                                 BindingResult bindingResult,
                                 HttpSession session,
                                 Model model){
        if(bindingResult.hasErrors())
            return new ModelAndView("register");
        Pair<Boolean, String> canCreate = userService.canCreate(candidate);
        model.addAttribute("otherError", canCreate.getValue());
        if(canCreate.getKey()){
            User user = modelMapper.map(candidate, User.class);
            userService.add(user);
            session.setAttribute("logInUser", user);
            return new ModelAndView("profile");
        }
        return new ModelAndView("register");
    }

    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public ModelAndView login(@Valid @ModelAttribute("loginUserDTO") LoginUserDTO candidate,
                              BindingResult bindingResult,
                              HttpSession session,
                              Model model){

        if(bindingResult.hasErrors())
            return new ModelAndView("login");
        User user = modelMapper.map(candidate, User.class);
        Optional<User> userAfterLogin = userService.login(user);
        if(userAfterLogin.isPresent()){
            session.setAttribute("logInUser", userAfterLogin.get());
            return new ModelAndView("profile");
        }
        model.addAttribute("otherError", "invalid login or password");
        return new ModelAndView("login");
    }

}

