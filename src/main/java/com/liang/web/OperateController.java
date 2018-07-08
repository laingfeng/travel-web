package com.liang.web;

import com.liang.dao.FlightMapper;
import com.liang.dao.HotelMapper;
import com.liang.dao.JourneyUserMapper;
import com.liang.model.JourneyUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping(value = "/oprateSystem")
public class OperateController {

    @Autowired
    private JourneyUserMapper journeyUserMapper;
    @Autowired
    private FlightMapper flightMapper;
    @Autowired
    private FlightMapper hotelMapper;

    @RequestMapping("/goto")
    public String index(@RequestParam Integer userid, Model model) {
        model.addAttribute("localUser",journeyUserMapper.selectByPrimaryKey(userid));
        model.addAttribute("flightList",flightMapper.selectAll());
        model.addAttribute("flightList",hotelMapper.selectAll());
        return "oprate/main";
    }

}
