package com.liang.web;

import com.liang.JsonUtil.FastJsonUtil;
import com.liang.dao.FlightMapper;
import com.liang.dao.JourneyUserMapper;
import com.liang.model.Flight;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletResponse;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

@Controller
@RequestMapping(value = "/oprateSystem/flight")
public class FightController {
    @Autowired
    private JourneyUserMapper journeyUserMapper;
    @Autowired
    private FlightMapper flightMapper;

    @RequestMapping("/query")
    public String queryFight(@RequestParam Integer userid, Model model) {
        model.addAttribute("localUser",journeyUserMapper.selectByPrimaryKey(userid));
        model.addAttribute("flightList",flightMapper.selectAll());
        return "oprate/main";
    }
    @RequestMapping(value = "/insert" ,method = RequestMethod.POST)
    public void insertFight(Flight flight, Model model, HttpServletResponse responses) throws Exception{
        flightMapper.insert(flight);
        FastJsonUtil.sendJsonData(responses,1111);

    }
    @RequestMapping(value = "/beforUpdate",method = RequestMethod.POST)
    public String beforUpdate(Flight flight, Model model,HttpServletResponse responses) throws Exception{
        Flight flight1=flightMapper.selectByPrimaryKey(flight.getFlightnum());
        FastJsonUtil.sendJsonData(responses,flight1);
        return "sucess";
    }
    @RequestMapping(value = "/update",method = RequestMethod.POST)
    public String updateFight(Flight flight, Model model,HttpServletResponse responses) throws Exception{
        responses.reset();
        flightMapper.updateByPrimaryKey(flight);
        FastJsonUtil.sendJsonData(responses,1111);
        return "sucess";
    }

    @RequestMapping(value = "/delete",method = RequestMethod.POST)
    public String deleteFight(Flight flight, Model model,HttpServletResponse responses) throws Exception{
        flightMapper.deleteByPrimaryKey(flight.getFlightnum());
        FastJsonUtil.sendJsonData(responses,1111);
        return "sucess";
    }
}
