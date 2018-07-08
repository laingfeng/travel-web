package com.liang.web;

import com.liang.dao.JourneyUserMapper;
import com.liang.model.JourneyUser;
import com.liang.service.MyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import java.util.Map;

@Controller
@RequestMapping(value = "/myself")
public class LiangControl {
    @Autowired
    private MyService myService;
    @Autowired
    private JourneyUserMapper journeyUserMapper;


    @RequestMapping(value ="/liang",method = RequestMethod.GET)
    public String delMyOrder(@RequestParam Integer userid, Model model){
        Map<String, Object> resultMap=myService.getOrderInfo(userid);
        model.addAttribute("flightList",resultMap.get("flightList"));
        model.addAttribute("transforList",resultMap.get("transforList"));
        model.addAttribute("hotelList",resultMap.get("hotelList"));
        model.addAttribute("user",journeyUserMapper.selectByPrimaryKey(userid));
        return "order/myorder";
    }
}
