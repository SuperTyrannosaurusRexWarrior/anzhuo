package com.example.billnote;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.example.billnote.dao.TbAccountDao;
import com.example.billnote.model.TbAccount;

public class LoginActivity extends Activity {
	ProgressBar pb_login;
	EditText et_userid, et_password;
	Button btn_register, btn_login;


	@Override
	protected void onCreate ( Bundle savedInstanceState ) {
		super.onCreate ( savedInstanceState );
		setContentView ( R.layout.activity_login );
		pb_login = findViewById ( R.id.pb_login_id );
		et_userid = findViewById ( R.id.et_userid_id );
		et_password = findViewById ( R.id.et_password_id );
		btn_register = findViewById ( R.id.btn_register_id );
		btn_login = findViewById ( R.id.btn_login_id );
		et_userid.addTextChangedListener ( new TextWatcher () {
			@Override
			public void beforeTextChanged ( CharSequence charSequence, int i, int i1, int i2 ) {

			}

			@Override
			public void onTextChanged ( CharSequence charSequence, int start, int before, int count ) {
				if ( count == 0 || charSequence.equals ( "" ) ) {
					pb_login.setProgress ( 0 );
				} else {
					int progress = pb_login.getProgress ();
					if ( progress < 50 ) {
						for ( int i = 0; i <= 50; i++ ) {
							pb_login.setProgress ( i );
						}
					} else {
						for ( int i = 50; i <= 100; i++ ) {
							pb_login.setProgress ( i );
						}

					}
				}
			}

			@Override
			public void afterTextChanged ( Editable editable ) {

			}
		} );

		et_password.addTextChangedListener ( new TextWatcher () {
			@Override
			public void beforeTextChanged ( CharSequence charSequence, int i, int i1, int i2 ) {

			}

			@Override
			public void onTextChanged ( CharSequence charSequence, int start, int before, int count ) {
				if ( count == 0 || charSequence.equals ( "" ) ) {
					pb_login.setProgress ( 0 );
				} else {
					int progress = pb_login.getProgress ();
					if ( progress < 50 ) {
						for ( int i = 0; i <= 50; i++ ) {
							pb_login.setProgress ( i );
						}
					} else {
						for ( int i = 50; i <= 100; i++ ) {
							pb_login.setProgress ( i );
						}
					}
				}
			}

			@Override
			public void afterTextChanged ( Editable editable ) {

			}
		} );
		btn_login.setOnClickListener ( new View.OnClickListener () {
			@Override
			public void onClick ( View view ) {
				String userid = et_userid.getText ().toString ();
				String userpassword = et_password.getText ().toString ();
				if ( userid == null || userid.equals ( "" ) ) {
					Toast.makeText ( LoginActivity.this, "??????ID????????????", Toast.LENGTH_LONG ).show ();
					return;
				}
				if ( userpassword == null || userpassword.equals ( "" ) ) {
					Toast.makeText ( LoginActivity.this, "??????????????????", Toast.LENGTH_LONG ).show ();
					return;
				}
				TbAccountDao tbAccountDao = new TbAccountDao ( LoginActivity.this );//1????????????????????????
//                boolean loginflag=tbAccountDao.login(userid,userpassword);
				TbAccount tbAccount = tbAccountDao.findUserById ( userid );//4??????LoginActivity???????????????????????????dao?????????????????????????????????
				if ( tbAccount == null ) {//6????????????????????????????????????????????????LoginActivity???LoginActivity??????????????????????????????????????????????????????
					Toast.makeText ( LoginActivity.this, "??????????????????????????????", Toast.LENGTH_LONG ).show ();
				} else if ( !tbAccount.getAccount_password ().equals ( userpassword ) ) {
					Toast.makeText ( LoginActivity.this, "???????????????????????????", Toast.LENGTH_LONG ).show ();
				} else {
					SharedPreferences sharedPreferences = getSharedPreferences ( "loginuser", Context.MODE_PRIVATE );
					SharedPreferences.Editor editor = sharedPreferences.edit ();
					editor.putString ( "account_id", tbAccount.getAccount_id () );
					editor.commit ();
					Intent intent = new Intent ( LoginActivity.this, MainActivity.class );
					startActivity ( intent );
					finish ();
				}
			}
		} );

		btn_register.setOnClickListener ( new View.OnClickListener () {
			@Override
			public void onClick ( View view ) {
				Intent intent = new Intent ( LoginActivity.this, AccountRegistActivity.class );
				startActivity ( intent );
				finish ();
			}
		} );
	}
}
