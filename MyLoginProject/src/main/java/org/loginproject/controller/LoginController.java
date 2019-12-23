package org.loginproject.controller;

import org.loginproject.dto.User;
import org.loginproject.service.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;


@Controller
public class LoginController {

    private final UserService userServ;

    public LoginController(UserService userServ) {
        this.userServ = userServ;
    }

    @GetMapping("/")
    public String login(Model model) {
        model.addAttribute("user", new User());
        return "login";
    }

    @GetMapping("/register")
    public String register(Model model) {
        model.addAttribute("user", new User());
        return "add";
    }

    @PostMapping("/add")
    public String addUser(@ModelAttribute("user") User user, HttpServletRequest request)
            throws UnableToSaveUserException {
        if (request.getParameter("admin") != null && request.getParameter("admin").equals("Admin")) {
            user.setIsAdmin(true);
        } else {
            user.setIsAdmin(false);
        }
        userServ.create(user);
        return "redirect:/home";
    }

    @GetMapping("/home")
    public String personList(Model model) {
        model.addAttribute("users", userServ.returnAllUsers());
//        for (GrantedAuthority authority : SecurityContextHolder.getContext().getAuthentication().getAuthorities()) {
//            if (authority.getAuthority().equals("ADMIN")) {
//                return "users";
//            }
//        }
        return "userslist";
    }

    @PostMapping("login")
    public String postLogin(@ModelAttribute("user") User user,
                            HttpSession session,
                            Model model) {
        if( userServ.checkIfUserCanBeLoggedIn(user) ) {
            model.addAttribute("users", userServ.returnAllUsers());

            if(userServ.findUserByUsername(user.getUsername()).get().getIsAdmin()) {
                return "users";
            }
        }

        return "login";
    }
}
