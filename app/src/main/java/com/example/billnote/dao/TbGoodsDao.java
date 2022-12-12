package com.example.billnote.dao;

import android.annotation.SuppressLint;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.example.billnote.db.DBOpenHelper;
import com.example.billnote.model.TbGoods;

import java.util.ArrayList;
import java.util.List;

public class TbGoodsDao {
	private DBOpenHelper dbOpenHelper;
	private SQLiteDatabase sqLiteDatabase;

	public TbGoodsDao ( Context context ) {
		this.dbOpenHelper = new DBOpenHelper ( context );
	}

	@SuppressLint ("Range")
	public List< TbGoods > getAllGoods () {
		List< TbGoods > tbGoodsList = new ArrayList<> ();
		sqLiteDatabase = dbOpenHelper.getReadableDatabase ();
		String querysql = "Select * from tb_goods";
		Cursor cursor = sqLiteDatabase.rawQuery ( querysql, null );
		while ( cursor.moveToNext () ) {
			TbGoods goods = new TbGoods ();
			String goods_id = cursor.getString ( cursor.getColumnIndex ( "goods_id" ) );
			double goods_price = cursor.getDouble ( cursor.getColumnIndex ( "goods_price" ) );
			String seller_id = cursor.getString ( cursor.getColumnIndex ( "seller_id" ) );
			String goods_name = cursor.getString ( cursor.getColumnIndex ( "goods_name" ) );
			String goods_type = cursor.getString ( cursor.getColumnIndex ( "goods_type" ) );
			String goods_pic = cursor.getString ( cursor.getColumnIndex ( "goods_pic" ) );
			String goods_introduction = cursor.getString ( cursor.getColumnIndex ( "goods_introduction" ) );
			goods.setGoods_id ( goods_id );
			goods.setSeller_id ( seller_id );
			goods.setGoods_name ( goods_name );
			goods.setGoods_type ( goods_type );
			goods.setGoods_pic ( goods_pic );
			goods.setGoods_introduction ( goods_introduction );
			goods.setGoods_price ( goods_price );
			tbGoodsList.add ( goods );
		}
		return tbGoodsList;

	}

	@SuppressLint ("Range")
	public TbGoods getGoodsinfoByid ( String send_goodsiD ) {
		TbGoods tbGoods = null;
		sqLiteDatabase = dbOpenHelper.getReadableDatabase ();
		String querysql = "Select * from tb_goods where goods_id='" + send_goodsiD + "'";
		Cursor cursor = sqLiteDatabase.rawQuery ( querysql, null );
		if ( cursor.moveToNext () ) {
			tbGoods = new TbGoods ();
			String goods_id = cursor.getString ( cursor.getColumnIndex ( "goods_id" ) );
			double goods_price = cursor.getDouble ( cursor.getColumnIndex ( "goods_price" ) );
			String seller_id = cursor.getString ( cursor.getColumnIndex ( "seller_id" ) );
			String goods_name = cursor.getString ( cursor.getColumnIndex ( "goods_name" ) );
			String goods_type = cursor.getString ( cursor.getColumnIndex ( "goods_type" ) );
			String goods_pic = cursor.getString ( cursor.getColumnIndex ( "goods_pic" ) );
			String goods_introduction = cursor.getString ( cursor.getColumnIndex ( "goods_introduction" ) );
			tbGoods.setGoods_id ( goods_id );
			tbGoods.setSeller_id ( seller_id );
			tbGoods.setGoods_name ( goods_name );
			tbGoods.setGoods_type ( goods_type );
			tbGoods.setGoods_pic ( goods_pic );
			tbGoods.setGoods_introduction ( goods_introduction );
			tbGoods.setGoods_price ( goods_price );
		}
		return tbGoods;
	}
}
