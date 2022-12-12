package com.example.billnote.db;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class DBOpenHelper extends SQLiteOpenHelper {
	private static final String DBNAME = "diancandb.db";
	private static final int VERSION = 1;

	public DBOpenHelper ( @Nullable Context context ) {//通过构造函数来创建数据库  context=LoginActivity
		super ( context, DBNAME, null, VERSION );//sqliteopenhelper:创建数据库 context=LogigActivity
	}//3、在DBOpenHelper内运行构造函数
	//LoginActivity要操作数据：通过super就把context=LoginActivity与DBNAME=diancandb.db关联起来了

	@Override
	public void onCreate ( SQLiteDatabase sqLiteDatabase ) {

		sqLiteDatabase.execSQL ( "PRAGMA foreign_keys = ON;" );

		//通过 user 函数创建表
		sqLiteDatabase.execSQL ( "create table `user`(" +
				"`uid` INTEGER(10) NOT NULL PRIMARY KEY AUTOINCREMENT," +       //ID
				"`account` varchar(20) not null," +                             //账号
				"`password` varchar(20) not null," +                            //密码
				"`nickname` varchar(20) not null," +                            //昵称
				"`regdate` date(20) not null);");                               //注册时间
		sqLiteDatabase.execSQL ( "insert into user values('1','test','123456','张三','2022\12\12','成都高新区')" );


		sqLiteDatabase.execSQL ( "CREATE TABLE 'category' (" +
				" 'cid' INTEGER(10) NOT NULL PRIMARY KEY AUTOINCREMENT," +      //ID
				"'cname' varchar(20) not null);" );                             //分类名称
		sqLiteDatabase.execSQL ( "INSERT INTO `category` VALUES('1','酒水')" );
		sqLiteDatabase.execSQL ( "INSERT INTO `category` VALUES(null,'餐饮')" );
		sqLiteDatabase.execSQL ( "INSERT INTO `category` VALUES(null,'住宿')" );
		sqLiteDatabase.execSQL ( "INSERT INTO `category` VALUES(null,'交通')" );
		sqLiteDatabase.execSQL ( "INSERT INTO `category` VALUES(null,'采购')" );


		//创建note管理员表
		sqLiteDatabase.execSQL ( "CREATE TABLE `note` (" +
				"  `nid` INTEGER(10) NOT NULL PRIMARY KEY AUTOINCREMENT," + //ID
				"  `ntype` tintint(10) NOT NULL," +                         //类型 1-收入 0-支出
				"  `money` double(10,2) NOT NULL," +                        //金额
				"  `date` datetime(20) NOT NULL," +                         //时间
				"  `content` varchar(20) NOT NULL," +                       //备注
				"  `user_id` INTEGER(20) NOT NULL ," +                      //用户ID
				"  `category_id` INTEGER(20) NOT NULL," +                   //分类ID
				"FOREIGN KEY(user_id) REFERENCES user(uid) ON UPDATE CASCADE ON DELETE CASCADE," +
				"FOREIGN KEY(category_id) REFERENCES category(cid) ON UPDATE CASCADE ON DELETE SET NULL" +
				");" );
		//创造 note 预置数据
		sqLiteDatabase.execSQL ( "INSERT INTO `note` VALUES ('1', '1', '12','2022\12\12 06:21:23','','1','2');" );
		sqLiteDatabase.execSQL ( "INSERT INTO `note` VALUES ('1', '1', '12','2022\12\12 06:21:23','','1','2');" );
		sqLiteDatabase.execSQL ( "INSERT INTO `note` VALUES ('1', '1', '12','2022\12\12 06:21:23','','1','2');" );
		sqLiteDatabase.execSQL ( "INSERT INTO `note` VALUES ('1', '1', '12','2022\12\12 06:21:23','','1','2');" );
		sqLiteDatabase.execSQL ( "INSERT INTO `note` VALUES ('1', '1', '12','2022\12\12 06:21:23','','1','2');" );
	}

	@Override
	public void onUpgrade ( SQLiteDatabase sqLiteDatabase, int i, int i1 ) {

	}
}
