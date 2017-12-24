package com.modul.login.services;

import java.sql.SQLException;

import com.modul.login.model.Login;

public interface LoginService {

	int cekLogin(Login data) throws SQLException;
}
