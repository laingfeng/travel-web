package com.liang.web;

import com.liang.dao.JourneyUserMapper;
import com.liang.handle.Myexception;
import com.liang.model.JourneyUser;
import com.liang.service.LoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;

@Controller
public class LoginController {

    @Autowired
    private JourneyUserMapper journeyUserMapper;

    @Autowired
    private  LoginService loginService;

    @RequestMapping("/")
    public String welcome() {

        return "index";
    }
    @RequestMapping("/index")
    public String index(@ModelAttribute("userName") String userName,Model model) {
        return "index";
    }

    @RequestMapping("/login")
    public String userLogin(JourneyUser journeyUser,Model model) throws Exception {

        if (!loginService.compareInfo(journeyUser)) {
            throw new Myexception("密码出错了，请重新登陆");
        }
        else {
            List<JourneyUser> journeyUserList=journeyUserMapper.selectByName(journeyUser.getUsername());
            model.addAttribute("user",journeyUserList.get(0));
            model.addAttribute("userid",journeyUserList.get(0).getUserid());
            return "userFront";
        }
    }
    @RequestMapping("/signup")
    public String signUp() {
        return "sign/signup";
    }
    @RequestMapping(value = "/dealsignup",method = RequestMethod.POST)
    public String dealSignup(JourneyUser user, Model model) {
        journeyUserMapper.insert(user);
        return "index";
    }
 //登录
  /*  @RequestMapping(value = "/atlogin",params="action=login", method = RequestMethod.POST)
    public String login(@RequestParam(value = "userName") String userName,
                        @RequestParam(value = "userPsw") String userPsw,Model model,RedirectAttributes redirectAttributes ) {
        User userDto = new User();
        if(userName.equals(userPsw)) {
            redirectAttributes.addFlashAttribute("userName",userName);
            return "redirect:index";
        } else {
            model.addAttribute("loginError",true);
            model.addAttribute("userDto",userDto);
            return "login";
        }
    }*/


}
