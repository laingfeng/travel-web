package com.liang.web;

import com.liang.JsonUtil.FastJsonUtil;
import com.liang.dao.FlightMapper;
import com.liang.dao.HotelMapper;
import com.liang.dao.TransforMapper;
import com.liang.dao.JourneyUserMapper;
import com.liang.handle.Myexception;
import com.liang.model.Flight;
import com.liang.model.Hotel;
import com.liang.model.Transfor;
import com.liang.model.JourneyUser;
import com.liang.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.websocket.Session;

@Controller

public class OrderControl {
   @Autowired
   private JourneyUserMapper journeyUserMapper;

   @Autowired
   private FlightMapper flightMapper;

   @Autowired
   private HotelMapper hotelMapper;

   @Autowired
   private TransforMapper transforMapper;


   @Autowired
    OrderService orderService;

    @RequestMapping(value = "/flight")
    public String index(@RequestParam Integer userid, Model model, HttpServletRequest servletRequest) {
        model.addAttribute("user",journeyUserMapper.selectByPrimaryKey(userid));
        model.addAttribute("flightList",flightMapper.selectAll());

        return "flight/flightInfo";
    }

    @RequestMapping(value = "/orderflight")
    public void orderFlight(Flight flight, JourneyUser user, Model model, HttpServletResponse response) throws Exception {

        if (orderService.orderFlight(flight.getFlightnum(),user.getUserid())){

            FastJsonUtil.sendJsonData(response,111 );
        }
        else {
            throw new Myexception("数据错误");
        }

    }

    @RequestMapping(value = "/hotel")
    public String index1(@RequestParam Integer userid, Model model, HttpServletRequest servletRequest) {
        model.addAttribute("user",journeyUserMapper.selectByPrimaryKey(userid));
        model.addAttribute("hotelList",hotelMapper.selectAll());

        return "hotel/hotelInfo";
    }

    @RequestMapping(value = "/orderhotel")
    public void orderHotel(Hotel hotel, JourneyUser user, Model model, HttpServletResponse response) throws Exception {

        if (orderService.orderHotel(hotel.getHotelnum(),user.getUserid())){

            FastJsonUtil.sendJsonData(response,111 );
        }
        else {
            throw new Myexception("数据错误");
        }

    }

    @RequestMapping(value = "/transfor")
    public String index2(@RequestParam Integer userid, Model model, HttpServletRequest servletRequest) {
        model.addAttribute("user",journeyUserMapper.selectByPrimaryKey(userid));
        model.addAttribute("transforList",transforMapper.selectAll());

        return "transfor/transforInfo";
    }

    @RequestMapping(value = "/ordertransfor")
    public void orderTransfor(Transfor transfor, JourneyUser user, Model model, HttpServletResponse response) throws Exception {

        if (orderService.orderTransfor(transfor.getCarnum(),user.getUserid())){

            FastJsonUtil.sendJsonData(response,111 );
        }
        else {
            throw new Myexception("数据错误");
        }

    }
}
