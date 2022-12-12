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
	public void onCreate ( SQLiteDatabase sqLiteDatabase ) {//通过onCreate函数创建表
		sqLiteDatabase.execSQL ( "create table tb_account(account_id varchar(10) not null," +
				"account_password varchar(20) not null," +
				"account_surplusMoney double(20, 2),acount_name varchar(20) not null," +
				"account_tel char(12),account_address varchar(100)," +
				"account_q1 varchar(20) not null, account_a1 varchar(20)," +
				"account_q2 varchar(20) not null, account_a2 varchar(20)," +
				"account_q3 varchar(20) not null, account_a3 varchar(20)," +
				"account_status varchar(10), primary key(account_id))" );
		sqLiteDatabase.execSQL ( "insert into tb_account values('ac_101','1234','3000','张三','18906543211','成都高新区'," +
				" 'when','10','who','me','how','good','enable')" );

		sqLiteDatabase.execSQL ( "CREATE TABLE 'tb_seller' (" +
				" 'seller_id' varchar(10) not null," +
				"'seller_password' varchar(10) not null," +
				"'seller_surplusMoney' double(20,0) not null," +
				"'seller_name' varchar(36) not null," +
				"'seller_businessLicence_id' varchar(26) not null," +
				"'seller_legalperson_iDcard' varchar(26) not null," +
				"'seller_tel' varchar(15) not null," +
				"'seller_address' varchar(50) not null," +
				"'seller_status' varchar(20) not null," +
				" PRIMARY KEY('seller_id'));" );
		sqLiteDatabase.execSQL ( "INSERT INTO 'tb_seller' VALUES('se_101','12345','233','宜宾燃面馆','9089076','513723','1760238','成都市高新区天益街83号','enable')" );
		sqLiteDatabase.execSQL ( "INSERT INTO 'tb_seller' VALUES('se_102','12345','233','沙县小吃馆','9089086','513323','1760338','成都市高新区天益街53号','enable')" );


		//创建tb_admin管理员表
		sqLiteDatabase.execSQL ( "CREATE TABLE `tb_admin` (" +
				"  `admin_id` varchar(10) NOT NULL," +
				"  `admin_password` varchar(10) NOT NULL," +
				"  `admin_type` varchar(10) NOT NULL," +
				"  `admin_status` varchar(20) NOT NULL," +
				"  PRIMARY KEY (`admin_id`));" );
		//创造tb_seller预置数据
		sqLiteDatabase.execSQL ( "INSERT INTO `tb_admin` VALUES ('ad_101', '123456', 'super','enable');" );

		//创建tb_goods商品表
		sqLiteDatabase.execSQL ( "CREATE TABLE `tb_goods` (" +
				"  `goods_id` varchar(20) NOT NULL," +
				"  `seller_id` varchar(10) NOT NULL," +
				"  `goods_name` varchar(20) NOT NULL," +
				"  `goods_type` varchar(10) NOT NULL," +
				"  `goods_pic` varchar(225) NOT NULL," +
				"  `goods_price` double(20,0) NOT NULL," +
				"  `goods_introduction` varchar(225) NOT NULL," +
				"  PRIMARY KEY (`goods_id`));" );
		//创造tb_goods预置数据
		sqLiteDatabase.execSQL ( "INSERT INTO `tb_goods` VALUES ('go_101101', 'se_101','黄焖鸡米饭','其他','R.mipmap.ms1','18','黄焖鸡米饭又叫香鸡煲，浓汁鸡煲饭，是鲁菜名吃。是源自山东济南的汉族传统名吃，属于鲁菜系。');" );
		sqLiteDatabase.execSQL ( "INSERT INTO `tb_goods` VALUES ('go_101102', 'se_101','宜宾燃面','面条','R.mipmap.ms2','8','燃面是四川省宜宾地区最具特色的特色传统名小吃之一。原名叙府燃面，旧称油条面，因其油重无水，点火即燃，故名燃面。');" );
		sqLiteDatabase.execSQL ( "INSERT INTO `tb_goods` VALUES ('go_101103', 'se_101','川魂·帽牌货冒菜','冒菜','R.mipmap.ms3','20','冒菜起源于成都，具有四川特色的传统小吃。冒菜的不断创新，现已成为暨火锅、麻辣烫后强劲新一轮四川特色餐饮并风靡全国。');" );
		sqLiteDatabase.execSQL ( "INSERT INTO `tb_goods` VALUES ('go_101104', 'se_101','喜葵石锅拌饭','拌饭','R.mipmap.ms4','18',' “石锅拌饭”又称“韩国拌饭”、“石碗拌饭”，是韩国以及中国东北地区黑龙江、吉林、辽宁特有的米饭料理。');" );
		sqLiteDatabase.execSQL ( "INSERT INTO `tb_goods` VALUES ('go_101105', 'se_101','牛肉锅盔','其他','R.mipmap.ms5','6','陕西锅盔(英文：guokui)，又叫锅魁、锅盔馍、干馍，是陕西省关中地区城乡居民喜食的汉族传统风味面食小吃。');" );
		sqLiteDatabase.execSQL ( "INSERT INTO `tb_goods` VALUES ('go_101106', 'se_101','绝味鸭脖','其他','R.mipmap.ms6','15','绝味鸭脖是绝味食品股份有限公司的核心品牌，绝味鸭脖采用秘制香料精心烹制而成，融入楚湘传统美食烹饪技法，结合祖国传统药膳食谱，博采众长，积数年心血研制。');" );
		sqLiteDatabase.execSQL ( "INSERT INTO `tb_goods` VALUES ('go_101107', 'se_101','176℃炸鸡排','鸡排','R.mipmap.ms7','20','炸鸡排属于闽菜，主要食材是鸡大腿或鸡脯肉，工艺是炸，味咸辣。鸡肉中蛋白质含量高，但是油炸食品食用量宜控制。鸡胸肉是在胸部里侧的肉，形状像斗笠。');" );
		sqLiteDatabase.execSQL ( "INSERT INTO `tb_goods` VALUES ('go_101108', 'se_101','土耳其烤肉饭','其他','R.mipmap.ms8','12','土耳其烤肉来自在世界上世界三大菜系之一的土耳其菜系，又名清真菜系。故在正宗土耳其烤肉是以牛羊肉，鸡肉，鱼肉为食材的。');" );
		sqLiteDatabase.execSQL ( "INSERT INTO `tb_goods` VALUES ('go_102101', 'se_102','羊肉泡馍','其他','R.mipmap.ms9','7','羊肉泡馍简称羊肉泡、泡馍。古称\"羊羹\",西北美馔，尤以陕西西安最享牛羊肉泡馍盛名.');" );

		//创建tb_orders订单表
		sqLiteDatabase.execSQL ( "CREATE TABLE `tb_orders` (" +
				"  `orders_id` varchar(20) NOT NULL," +
				"  `account_id` varchar(10) NOT NULL," +
				"  `orders_goods_id` varchar(20) NOT NULL," +
				"  `orders_goods_num` int NOT NULL," +
				"  `order_price` double(20,0) NOT NULL," +
				"  `orders_datetime` datetime NOT NULL," +
				"  `orders_recipient_name` varchar(100) NOT NULL," +
				"  `order_recipient_address` varchar(100) NOT NULL," +
				"  `order_recipient_tel` varchar(20) NOT NULL," +
				"  `order_notes` varchar(225) NOT NULL," +
				"  `order_status` varchar(225) NOT NULL," +
				"  PRIMARY KEY (`orders_id`));" );
		//创造tb_orders预置数据
		sqLiteDatabase.execSQL ( "INSERT INTO `tb_orders` VALUES ('or_101101', 'ac_101','go_101101','2','1','2015-12-12 09:35:15','李德明','高新区益州大道','1838288','nihao','paid');" );
		sqLiteDatabase.execSQL ( "INSERT INTO `tb_orders` VALUES ('or_101102', 'ac_101','go_101101','2','1','2015-12-12 09:35:15','李继迁','高新区益州大道','1838288','nihao','sent');" );
		sqLiteDatabase.execSQL ( "INSERT INTO `tb_orders` VALUES ('or_101103', 'ac_101','go_101101','2','1','2015-12-12 09:35:15','李元昊','高新区益州大道','1838288','nihao','received');" );
		sqLiteDatabase.execSQL ( "INSERT INTO `tb_orders` VALUES ('or_101104', 'ac_101','go_102101','2','2','2015-12-12 10:316:15','李继迁','高新区益州大道','11760803','nihaoa','sent');" );
		sqLiteDatabase.execSQL ( "INSERT INTO `tb_orders` VALUES ('or_101105', 'ac_101','go_102101','2','14','2015-12-12 10:316:15','李元昊','高新区益州大道','11760803','nihaoa','received');" );

	}

	@Override
	public void onUpgrade ( SQLiteDatabase sqLiteDatabase, int i, int i1 ) {

	}
}
