package web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import web.model.User;
import web.service.UserServiceImpl;

@Controller
public class UserController {
    private final UserServiceImpl userService;

    @Autowired
    public UserController(UserServiceImpl userService) {
        this.userService = userService;
    }

    @GetMapping("/")
    public String index(Model model) {
        model.addAttribute("users", userService.index());
        return "index";
    }

    @GetMapping("/new")
    public String newUser(Model model) {
        model.addAttribute("user", new User());
        return "new";
    }

    @PostMapping
    public String create(@ModelAttribute("user") User user) {
        userService.save(user);
        return "redirect:/";
    }

    @GetMapping("/edit")
    public String edit(@RequestParam(value = "id") int id, Model model) {
        model.addAttribute("user", userService.show(id));
        return "edit";
    }

    @PatchMapping("/update")
    public String update(@ModelAttribute("user") User user, @RequestParam(value = "id") int id) {
        userService.update(id, user);
        return "redirect:/";
    }

    @DeleteMapping("/")
    public String delete(@RequestParam(value = "id") int id) {
        userService.delete(id);
        return "redirect:/";
    }
}
