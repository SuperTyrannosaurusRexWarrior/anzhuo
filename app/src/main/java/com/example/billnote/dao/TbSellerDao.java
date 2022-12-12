package com.example.billnote.dao;

import android.annotation.SuppressLint;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.example.billnote.db.DBOpenHelper;
import com.example.billnote.model.TbSeller;

public class TbSellerDao {
	private DBOpenHelper dbOpenHelper;
	private SQLiteDatabase sqLiteDatabase;

	public TbSellerDao ( Context context ) {
		this.dbOpenHelper = new DBOpenHelper ( context );
	}

	public boolean login ( String sellerid, String password ) {
		sqLiteDatabase = dbOpenHelper.getReadableDatabase ();
		String querysql = "select * from tb_seller wnere seller_id='" + sellerid + "' and seller_password='" + password + "'";
		Cursor cursor = sqLiteDatabase.rawQuery ( querysql, null );
		if ( cursor.moveToNext () ) {
			return true;
		}

		return false;
	}

	@SuppressLint ("Range")
	public TbSeller getSellerMiniInfo ( String seller_id ) {
		TbSeller tbSeller = new TbSeller ();
		sqLiteDatabase = dbOpenHelper.getReadableDatabase ();
		String querysql = "select * from tb_seller where seller_id='" + seller_id + "'";
		Cursor cursor = sqLiteDatabase.rawQuery ( querysql, null );
		if ( cursor.moveToNext () ) {
			String sellname = cursor.getString ( cursor.getColumnIndex ( "seller_name" ) );
			String sellertel = cursor.getString ( cursor.getColumnIndex ( "seller_tel" ) );
			String sellAddress = cursor.getString ( cursor.getColumnIndex ( "seller_address" ) );
			tbSeller.setSeller_name ( sellname );
			tbSeller.setSeller_tel ( sellertel );
			tbSeller.setSeller_address ( sellAddress );
		}

		return tbSeller;
	}
}
