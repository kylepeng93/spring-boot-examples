package com.neo.web;

import com.neo.model.User;
import com.neo.service.UserService;
import com.neo.util.JsonUtil;
import com.neo.util.Result;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@Controller
public class UserController {

    @Resource
    UserService userService;


    @RequestMapping("/")
    public String index() {
        return "redirect:/list";
    }

    @RequestMapping(value = "/list")
    public String list(){
        return "user/list";
    }

    @RequestMapping(value = "/getUserList")
    public void getUserList(HttpServletResponse response) {
        List<User> list = userService.getUserList();
        try {
            if(list == null || list.isEmpty()) {
                JsonUtil.toJson(new Result(false, 7000, "没有数据", null), response);
                return;
            }
            List<User> userList = new ArrayList<>();
            Result result = new Result(true, 200, "成功",list);
            JsonUtil.toJson(result,response);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @RequestMapping(value = "/getUserList1")
    @ResponseBody
    public List getUserList1(HttpServletResponse response) {
        List<User> list = userService.getUserList();
        return list;
    }

    @RequestMapping("/toAdd")
    public String toAdd() {
        return "user/userAdd";
    }

    @RequestMapping("/add")
    public String add(User user) {
        userService.save(user);
        return "redirect:/list";
    }

    @RequestMapping("/toEdit")
    public String toEdit(Model model,Long id) {
        User user=userService.findUserById(id);
        model.addAttribute("user", user);
        return "user/userEdit";
    }

    @RequestMapping("/edit")
    public String edit(User user) {
        userService.edit(user);
        return "redirect:/list";
    }


    @RequestMapping(value = "/delete", method = RequestMethod.POST)
    @ResponseBody
    public String delete(Long id) {
        userService.delete(id);
        return "success";
    }
}
