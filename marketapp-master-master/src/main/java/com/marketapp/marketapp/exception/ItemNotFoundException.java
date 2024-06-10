package com.marketapp.marketapp.exception;

import java.math.BigDecimal;

//例外クラス
public class ItemNotFoundException extends RuntimeException {
	//serialVersionUIDを定義する必要がある
	
	private static final long serialVersionUID = 1L;
	
	public ItemNotFoundException(Long itemId) {
		super("商品コード：" + itemId + "は見つかりません。");
	}
	public ItemNotFoundException(String searchTerm) {
		super("「" + searchTerm + "」" + "が含まれる商品は見つかりません。");
	}
	public ItemNotFoundException(BigDecimal minPrice, BigDecimal maxPrice) {
		super(minPrice + "円～" + maxPrice + "円の範囲に含まれる商品は見つかりません。");
	}

	
}
