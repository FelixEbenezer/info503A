/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.univreims.l3info.serveur;

/**
 *
 * @author çpc
 */
import java.util.UUID;

/**
 * 字符串工具类
 * @author guojing
 * @date 2014-3-4
 */
public class StringUtil {

	public static boolean isEmpty(String str) {
		return str == null || str.length() == 0;
	}

	public static String creatSession() {
		UUID uuid = UUID.randomUUID();
		return uuid.toString();
	}
}
