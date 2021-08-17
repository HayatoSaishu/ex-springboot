package com.example.repository;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.stereotype.Repository;

import com.example.domain.Hotel;

/**
 * hotelsテーブルの情報を操作するリポジトリ.
 * 
 * @author hayato.saishu
 *
 */
@Repository
public class HotelRepository {

	private static final RowMapper<Hotel> HOTEL_ROW_MAPPER = (rs, i) ->{
		
		Hotel hotel = new Hotel();
		hotel.setId(rs.getInt("id"));
		hotel.setAreaName(rs.getString("area_name"));
		hotel.setHotelName(rs.getString("hotel_name"));
		hotel.setAddress(rs.getString("address"));
		hotel.setNearestStation(rs.getString("nearest_station"));
		hotel.setPrice(rs.getInt("price"));
		hotel.setParking(rs.getString("parking"));
		
		return hotel;
	};
	
	@Autowired
	private NamedParameterJdbcTemplate template;
	
	/**
	 * ホテル情報を全件取得する.
	 * 
	 * @return ホテル全体の情報
	 */
	public List<Hotel> findAll(){
		
		String sql = "SELECT id, area_name, hotel_name, address, nearest_station, price, parking FROM hotels ORDER BY id;";
		
		List<Hotel> hotelList = template.query(sql, HOTEL_ROW_MAPPER);
		
		return hotelList;
	}
	
	/**
	 *　ホテルの価格を比較して情報を取得する.
	 *
	 * @param price 検索フォームから受け取る価格
	 * @return 条件当てはまるホテルの情報
	 */
	public List<Hotel> findByLessThanPrice(Integer price){
		
		String sql = "SELECT id, area_name, hotel_name, address, nearest_station, price, parking FROM hotels WHERE price <= :price;";
		
		SqlParameterSource param = new MapSqlParameterSource().addValue("price", price);
		
		List<Hotel> hotelList = template.query(sql, param, HOTEL_ROW_MAPPER);
		
		return hotelList;
	}
}
