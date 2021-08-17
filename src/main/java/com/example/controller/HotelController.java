package com.example.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.service.HotelService;

/**
 * ホテル情報を操作するコントローラ.
 * 
 * @author hayato.saishu
 *
 */
@Controller
@RequestMapping("/hotel")
public class HotelController {

	@Autowired
	private HotelService hotelService;

	@RequestMapping("/showHotelList")
	public String showHotelList() {
		return "hotel/hotel-list";
	}

	/**
	 * ホテルの価格検索を行うメソッド.
	 * 
	 * @param price フォームから受け取るリクエストパラメータ
	 * @param model　リクエストスコープへ格納
	 * @return　hotel-list.htmlにフォワード
	 */
	@RequestMapping("/searchHotel")
	public String searchHotel(Integer price, Model model) {
		if(price == null) {
			model.addAttribute("hotelList", hotelService.showHotelList());
		} else {
			model.addAttribute("hotelList", hotelService.searchByLessThanPrice(price));
		}

		return "hotel/hotel-List";
	}
}
