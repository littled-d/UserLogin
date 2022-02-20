package cn.xiejp.controller;

import cn.xiejp.pojo.User;
import cn.xiejp.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/user")
public class UserController {

    @Autowired
    @Qualifier("userServiceImpl")
    private UserService userService;


    @RequestMapping("/login")   //现在这个视图的真实路径是/user/login
    public String loginView() {
        System.out.println("login");
        return "login";
    }

    @RequestMapping("/register")
    public String registerView() {
        System.out.println("register");
        return "register";
    }

    @RequestMapping("/loginRes")
    public String login(Model model, @RequestParam("mobile")String mobile, @RequestParam("password")String password) {
        // 1.接受前端参数
        System.out.println(mobile);
        System.out.println(password);
        // 2.对结果进行判断
        User user = userService.select(mobile);
        if (user != null && user.getPassword().equals(password)) {
            return "success";
        }
        return "error";  // return返回的字符会与前后缀组合成文件路径
    }
    @RequestMapping("/registerRes")
    public String register(Model model,User user) {
        if (userService.add(user) != 0) {
            return "success";
        }
        return "error";
    }

    // 接受前端的一个对象
    /*
    1. 接收前端用户传递的参数，判断参数的名字，假设名字直接在方法上，可以直接使用
    2. 假设传递一个User对象，匹配User对象中的字段名，如果一致就OK否则匹配不到，一部分也可以匹配
     */
    @RequestMapping("/Object")
    public String getObject(User user) {
        System.out.println(user);
        return "";
    }

}
