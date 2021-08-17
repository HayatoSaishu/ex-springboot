package com.example.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.domain.Hotel;
import com.example.repository.HotelRepository;

/**
 * ホテル情報の業務処理を行うサービス.
 * 
 * @author hayato.saishu
 *
 */
@Service
@Transactional
public class HotelService {

	@Autowired
	private HotelRepository hotelRepository;
	
	/**
	 * ホテル情報を全件取得する.
	 * 
	 * @return ホテル全体の情報
	 */
	public List<Hotel> showHotelList(){
		return hotelRepository.findAll();
	}
	
	/**
	 * フォームのリクエストパラメータの価格よりも低い価格のホテル情報を取得する.
	 * 
	 * @param price フォームのリクエストパラメータ
	 * @return 条件に当てはまるホテルの情報
	 */
	public List<Hotel> searchByLessThanPrice(Integer price){
		return hotelRepository.findByLessThanPrice(price);
	}
}
