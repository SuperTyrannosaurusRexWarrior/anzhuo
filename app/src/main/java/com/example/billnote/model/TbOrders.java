package com.example.billnote.model;

import java.util.Date;

public class TbOrders {
	String orders_id;
	String account_id;
	String orders_goods_id;
	int orders_goods_num;
	Double order_price;
	Date orders_datetime;
	String orders_recipient_name;
	String order_recipient_address;
	String order_recipient_tel;
	String order_notes;
	String order_status;

	public String getOrders_id () {
		return orders_id;
	}

	public void setOrders_id ( String orders_id ) {
		this.orders_id = orders_id;
	}

	public String getAccount_id () {
		return account_id;
	}

	public void setAccount_id ( String account_id ) {
		this.account_id = account_id;
	}

	public String getOrders_goods_id () {
		return orders_goods_id;
	}

	public void setOrders_goods_id ( String orders_goods_id ) {
		this.orders_goods_id = orders_goods_id;
	}

	public int getOrders_goods_num () {
		return orders_goods_num;
	}

	public void setOrders_goods_num ( int orders_goods_num ) {
		this.orders_goods_num = orders_goods_num;
	}

	public Double getOrder_price () {
		return order_price;
	}

	public void setOrder_price ( Double order_price ) {
		this.order_price = order_price;
	}

	public Date getOrders_datetime () {
		return orders_datetime;
	}

	public void setOrders_datetime ( Date orders_datetime ) {
		this.orders_datetime = orders_datetime;
	}

	public String getOrders_recipient_name () {
		return orders_recipient_name;
	}

	public void setOrders_recipient_name ( String orders_recipient_name ) {
		this.orders_recipient_name = orders_recipient_name;
	}

	public String getOrder_recipient_address () {
		return order_recipient_address;
	}

	public void setOrder_recipient_address ( String order_recipient_address ) {
		this.order_recipient_address = order_recipient_address;
	}

	public String getOrder_recipient_tel () {
		return order_recipient_tel;
	}

	public void setOrder_recipient_tel ( String order_recipient_tel ) {
		this.order_recipient_tel = order_recipient_tel;
	}

	public String getOrder_notes () {
		return order_notes;
	}

	public void setOrder_notes ( String order_notes ) {
		this.order_notes = order_notes;
	}

	public String getOrder_status () {
		return order_status;
	}

	public void setOrder_status ( String order_status ) {
		this.order_status = order_status;
	}

	@Override
	public String toString () {
		return "TbOrders{" +
				"orders_id='" + orders_id + '\'' +
				", account_id='" + account_id + '\'' +
				", orders_goods_id='" + orders_goods_id + '\'' +
				", orders_goods_num=" + orders_goods_num +
				", order_price=" + order_price +
				", orders_datetime=" + orders_datetime +
				", orders_recipient_name='" + orders_recipient_name + '\'' +
				", order_recipient_address='" + order_recipient_address + '\'' +
				", order_recipient_tel='" + order_recipient_tel + '\'' +
				", order_notes='" + order_notes + '\'' +
				", order_status='" + order_status + '\'' +
				'}';
	}
}
