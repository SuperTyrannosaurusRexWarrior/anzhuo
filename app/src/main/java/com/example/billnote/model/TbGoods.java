package com.example.billnote.model;

public class TbGoods {
	String goods_id;
	String seller_id;
	String goods_name;
	String goods_type;
	String goods_pic;
	Double goods_price;
	String goods_introduction;

	public String getGoods_id () {
		return goods_id;
	}

	public void setGoods_id ( String goods_id ) {
		this.goods_id = goods_id;
	}

	public String getSeller_id () {
		return seller_id;
	}

	public void setSeller_id ( String seller_id ) {
		this.seller_id = seller_id;
	}

	public String getGoods_name () {
		return goods_name;
	}

	public void setGoods_name ( String goods_name ) {
		this.goods_name = goods_name;
	}

	public String getGoods_type () {
		return goods_type;
	}

	public void setGoods_type ( String goods_type ) {
		this.goods_type = goods_type;
	}

	public String getGoods_pic () {
		return goods_pic;
	}

	public void setGoods_pic ( String goods_pic ) {
		this.goods_pic = goods_pic;
	}

	public Double getGoods_price () {
		return goods_price;
	}

	public void setGoods_price ( Double goods_price ) {
		this.goods_price = goods_price;
	}

	public String getGoods_introduction () {
		return goods_introduction;
	}

	public void setGoods_introduction ( String goods_introduction ) {
		this.goods_introduction = goods_introduction;


	}

	@Override
	public String toString () {
		return "TbGoods{" +
				"goods_id='" + goods_id + '\'' +
				", seller_id='" + seller_id + '\'' +
				", goods_name='" + goods_name + '\'' +
				", goods_type='" + goods_type + '\'' +
				", goods_pic='" + goods_pic + '\'' +
				", goods_price=" + goods_price +
				", goods_introduction='" + goods_introduction + '\'' +
				'}';
	}
}
