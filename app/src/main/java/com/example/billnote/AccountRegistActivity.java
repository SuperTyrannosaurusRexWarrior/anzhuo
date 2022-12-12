package com.example.billnote;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.billnote.dao.TbAccountDao;
import com.example.billnote.model.TbAccount;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class AccountRegistActivity extends Activity {
	EditText et_Register_userid, et_userName, et_userTel, et_userAddress, et_userIssue1;
	EditText et_userDaan1, et_userIssue2, et_userDaan2, et_userIssue3, et_userDaan3, et_accountpassword, et_accountpassword1;
	Button btn_regist_id, btn_goback_id;


	@Override
	protected void onCreate ( Bundle savedInstanceState ) {
		super.onCreate ( savedInstanceState );
		setContentView ( R.layout.activity_account_regist2 );
		initView ();
		initEvent ();
	}

	private void initEvent () {
		btn_regist_id.setOnClickListener ( new View.OnClickListener () {
			@Override
			public void onClick ( View view ) {
				String Register_userid = et_Register_userid.getText ().toString ();
				String userName = et_userName.getText ().toString ();
				String userTel = et_userTel.getText ().toString ();
				String userAddress = et_userAddress.getText ().toString ();
				String userIssue1 = et_userIssue1.getText ().toString ();
				String userDaan1 = et_userDaan1.getText ().toString ();
				String userIssue2 = et_userIssue2.getText ().toString ();
				String userDaan2 = et_userDaan2.getText ().toString ();
				String userIssue3 = et_userIssue3.getText ().toString ();
				String userDaan3 = et_userDaan3.getText ().toString ();
				String accountpassword = et_accountpassword.getText ().toString ();
//                String accountpassword1=et_accountpassword1.getText().toString();
				TbAccountDao tbAccountDao = new TbAccountDao ( AccountRegistActivity.this );
				TbAccount tbaccount = tbAccountDao.findUserById ( Register_userid );
				if ( Register_userid == null || "".equals ( ( Register_userid.trim () ) ) ) {
					Toast.makeText ( AccountRegistActivity.this, "用户ID不能为空", Toast.LENGTH_LONG ).show ();
					return;
				}

				if ( userName == null || "".equals ( ( Register_userid.trim () ) ) ) {
					Toast.makeText ( AccountRegistActivity.this, "用户名不能为空", Toast.LENGTH_LONG ).show ();
					return;
				}

				if ( accountpassword == null || "".equals ( ( Register_userid.trim () ) ) ) {
					Toast.makeText ( AccountRegistActivity.this, "用户密码不能为空", Toast.LENGTH_LONG ).show ();
					return;
				}

				if ( userIssue1 == null || "".equals ( ( Register_userid.trim () ) ) ) {
					Toast.makeText ( AccountRegistActivity.this, "密保问题1不能为空", Toast.LENGTH_LONG ).show ();
					return;
				}
				if ( userDaan1 == null || "".equals ( ( Register_userid.trim () ) ) ) {
					Toast.makeText ( AccountRegistActivity.this, "密保答案1不能为空", Toast.LENGTH_LONG ).show ();
					return;
				}

				if ( userIssue2 == null || "".equals ( ( Register_userid.trim () ) ) ) {
					Toast.makeText ( AccountRegistActivity.this, "密保问题2不能为空", Toast.LENGTH_LONG ).show ();
					return;
				}
				if ( userDaan2 == null || "".equals ( ( Register_userid.trim () ) ) ) {
					Toast.makeText ( AccountRegistActivity.this, "密保答案2不能为空", Toast.LENGTH_LONG ).show ();
					return;
				}

				if ( userIssue3 == null || "".equals ( ( Register_userid.trim () ) ) ) {
					Toast.makeText ( AccountRegistActivity.this, "密保问题3不能为空", Toast.LENGTH_LONG ).show ();
					return;
				}
				if ( userDaan3 == null || "".equals ( ( Register_userid.trim () ) ) ) {
					Toast.makeText ( AccountRegistActivity.this, "密保答案3不能为空", Toast.LENGTH_LONG ).show ();
					return;
				}

				if ( !accountpassword.equals ( ( accountpassword ) ) ) {
					Toast.makeText ( AccountRegistActivity.this, "两次输入密码不一致", Toast.LENGTH_LONG ).show ();
					return;
				}
				Pattern pattern = Pattern.compile ( "^1[3,4,5,7,8,9][0-9]{9}" );
				Matcher matcher = pattern.matcher ( userTel );
				if ( !matcher.matches () ) {
					Toast.makeText ( AccountRegistActivity.this, "电话号码格式错误", Toast.LENGTH_LONG ).show ();
					return;
				}


				if ( tbaccount != null ) {
					Toast.makeText ( AccountRegistActivity.this, "用户呢称已存在", Toast.LENGTH_LONG ).show ();
				} else {
					TbAccount tbAccount = new TbAccount ();
					tbAccount.setAccount_id ( Register_userid );
					tbAccount.setAccount_name ( userName );
					tbAccount.setAccount_tel ( userTel );
					tbAccount.setAccount_address ( userAddress );
					tbAccount.setAccount_q1 ( userIssue1 );
					tbAccount.setAccount_a1 ( userDaan1 );
					tbAccount.setAccount_q2 ( userIssue2 );
					tbAccount.setAccount_a2 ( userDaan2 );
					tbAccount.setAccount_q3 ( userIssue3 );
					tbAccount.setAccount_a3 ( userDaan3 );
					tbAccount.setAccount_password ( accountpassword );
					long addflag = tbAccountDao.addAccount ( tbAccount );
					if ( addflag > 0 ) {
						Toast.makeText ( AccountRegistActivity.this, "注册成功", Toast.LENGTH_LONG ).show ();
						Intent intent = new Intent ( AccountRegistActivity.this, LoginActivity.class );
						startActivity ( intent );
						finish ();
					} else {
						Toast.makeText ( AccountRegistActivity.this, "注册失败", Toast.LENGTH_LONG ).show ();
					}
				}
			}
		} );
	}

	private void initView () {
		et_Register_userid = findViewById ( R.id.et_Register_userid );
		et_userName = findViewById ( R.id.et_userName );
		et_userTel = findViewById ( R.id.et_userTel );
		et_userAddress = findViewById ( R.id.et_userAddress );
		et_userIssue1 = findViewById ( R.id.et_userIssue1 );
		et_userDaan1 = findViewById ( R.id.et_userDaan1 );
		et_userIssue2 = findViewById ( R.id.et_userIssue2 );
		et_userDaan2 = findViewById ( R.id.et_userDaan2 );
		et_userIssue3 = findViewById ( R.id.et_userIssue3 );
		et_userDaan3 = findViewById ( R.id.et_userDaan3 );
		et_accountpassword = findViewById ( R.id.et_accountpassword );
		btn_regist_id = findViewById ( R.id.btn_regist_id );
		btn_goback_id = findViewById ( R.id.btn_goback_id );
	}
}
