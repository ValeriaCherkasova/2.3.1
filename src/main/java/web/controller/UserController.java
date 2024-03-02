package web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;
import web.model.User;
import web.service.UserService;

import java.util.List;

@Controller
@RequestMapping(value = "/user")
public class UserController {
    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping(value = "/get_all_users")
    public String getAllUsers(ModelMap model) {
        List<User> users = userService.getAllUsers();
        model.addAttribute("users", users);
        return "users";
    }

    @RequestMapping(value = "/read_user", method = RequestMethod.GET)
    public String readUser(@RequestParam("id") Long id, Model model) {
        User user = userService.readUser(id);
        model.addAttribute("user", user);
        return "read_user";
    }

    @RequestMapping(value = "/create_user", method = RequestMethod.POST)
    public String createUser(@ModelAttribute("user") User user) {
        userService.createUser(user);
        return "redirect:/user/get_all_users";
    }

    @RequestMapping(value = "/update_user", method = RequestMethod.POST)
    public String updateUser(User user) {
        userService.updateUser(user);
        return "redirect:/user/get_all_users";
    }

    @RequestMapping(value = "/delete_user", method = RequestMethod.POST)
    public String deleteUser(@RequestParam("id") Long id) {
        userService.deleteUser(id);
        return "redirect:/user/get_all_users";
    }
}
