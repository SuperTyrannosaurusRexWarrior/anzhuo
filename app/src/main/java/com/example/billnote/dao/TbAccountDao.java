package com.example.billnote.dao;

import android.annotation.SuppressLint;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.example.billnote.db.DBOpenHelper;
import com.example.billnote.model.TbAccount;

public class TbAccountDao {
	private DBOpenHelper dbOpenHelper;
	private SQLiteDatabase sqLiteDatabase;

	public TbAccountDao ( Context context ) {
		this.dbOpenHelper = new DBOpenHelper ( context );
	}//2、在TbAccountDao 内运行构造函数

	public boolean login ( String accountid, String password ) {
		sqLiteDatabase = dbOpenHelper.getReadableDatabase ();//5、在dao对象具体操作数据库表首先要获得SQLiteDatabase数据库对象
		String querysql = "select * from tb_account where account_id='" + accountid + "' and account_password='" + password + "'";
		Cursor cursor = sqLiteDatabase.rawQuery ( querysql, null );//再通过获得的数据库对象来执行sql语句，//返回一个数据集指针cursor  resultset
		if ( cursor.moveToNext () ) {
			return true;
		}
		return false;
	}

	@SuppressLint ("Range")
	public TbAccount findUserById ( String userid ) {
		sqLiteDatabase = dbOpenHelper.getReadableDatabase ();
		TbAccount tbAccount = null;
		String querysql = "Select * from tb_account where account_id='" + userid + "'";
		Cursor cursor = sqLiteDatabase.rawQuery ( querysql, null );
		if ( cursor.moveToNext () ) {
			tbAccount = new TbAccount ();
			int usidindx = cursor.getColumnIndex ( "account_id" );
			String usid = cursor.getString ( usidindx );
			String account_password = cursor.getString ( cursor.getColumnIndex ( "account_password" ) );
			double usrmoney = cursor.getDouble ( cursor.getColumnIndex ( "account_surplusMoney" ) );
			String usertel = cursor.getString ( cursor.getColumnIndex ( "account_tel" ) );
			String username = cursor.getString ( cursor.getColumnIndex ( "acount_name" ) );
			String userq1 = cursor.getString ( cursor.getColumnIndex ( "account_q1" ) );
			tbAccount.setAccount_id ( usid );
			tbAccount.setAccount_password ( account_password );
			tbAccount.setAccount_surplusMoney ( usrmoney );
			tbAccount.setAccount_tel ( usertel );
			tbAccount.setAccount_name ( username );
			tbAccount.setAccount_q1 ( userq1 );
		}
		return tbAccount;
	}

	public long addAccount ( TbAccount tbAccount ) {
		long insertflag = 0;
		sqLiteDatabase = dbOpenHelper.getReadableDatabase ();
		ContentValues contentValues = new ContentValues ();
		contentValues.put ( "account_id", tbAccount.getAccount_id () );
		contentValues.put ( "account_password", tbAccount.getAccount_password () );
		contentValues.put ( "account_surplusMoney", 100.0 );
		contentValues.put ( "acount_name", tbAccount.getAccount_name () );
		contentValues.put ( "account_tel", tbAccount.getAccount_tel () );
		contentValues.put ( "account_address", tbAccount.getAccount_address () );
		contentValues.put ( "account_q1", tbAccount.getAccount_q1 () );
		contentValues.put ( "account_a1", tbAccount.getAccount_a1 () );
		contentValues.put ( "account_q2", tbAccount.getAccount_q2 () );
		contentValues.put ( "account_a2", tbAccount.getAccount_a2 () );
		contentValues.put ( "account_q3", tbAccount.getAccount_q3 () );
		contentValues.put ( "account_a3", tbAccount.getAccount_a3 () );
		contentValues.put ( "account_status", "enable" );
		insertflag = sqLiteDatabase.insert ( "tb_account", null, contentValues );
		return insertflag;
	}


	@SuppressLint ("Range")
	public String getSurplusMoneyByiD ( String user_id ) {
		sqLiteDatabase = dbOpenHelper.getReadableDatabase ();
		String usrmoney = "0";
		TbAccount tbAccount = null;
		String querysql = "Select * from tb_account where account_id='" + user_id + "'";
		Cursor cursor = sqLiteDatabase.rawQuery ( querysql, null );
		if ( cursor.moveToNext () ) {
			usrmoney = String.valueOf ( cursor.getDouble ( cursor.getColumnIndex ( "account_surplusMoney" ) ) );
		}
		return usrmoney;
	}

	public int[] getNotificationNum ( String user_id ) {
		int[] a = new int[] { 1, 21, 3 };
		return a;
	}

	public String judgeTypeByiD ( String user_id ) {
		return "account";
	}
}
