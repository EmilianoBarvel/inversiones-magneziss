/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package org.magnezis.inversiones.magnezis.config;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
 
public class DataBaseConnection {
 
    public static Connection getConnection() throws SQLException {
 
        return DriverManager.getConnection(
                CredentialsDB.URL_MYSQL_DB,
                CredentialsDB.USER_DB,
                CredentialsDB.PASS_DB
        );
    }
}
