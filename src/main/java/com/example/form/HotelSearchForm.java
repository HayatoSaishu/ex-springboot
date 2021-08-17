package com.example.form;

/**
 * ホテルの検索を行う際に必要なリクエストパラメータを受け取るフォーム.
 * 
 * @author hayato.saishu
 *
 */
public class HotelSearchForm {

	/** 価格 */
	private String price;

	public String getPrice() {
		return price;
	}

	public void setPrice(String price) {
		this.price = price;
	}

	@Override
	public String toString() {
		return "HotelSearchForm [price=" + price + "]";
	}

}
