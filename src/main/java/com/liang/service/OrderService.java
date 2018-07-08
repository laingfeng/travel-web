package com.liang.service;

public interface OrderService {

    public Boolean orderFlight(String flightNum,Integer userid);

    public Boolean orderHotel(String hotelNum,Integer userid);

    public Boolean orderTransfor(String carNum,Integer userid);


}
