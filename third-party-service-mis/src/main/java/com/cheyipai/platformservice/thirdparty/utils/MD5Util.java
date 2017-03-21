package com.cheyipai.platformservice.thirdparty.utils;

import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.UUID;

/**
 * <p>
 * @Description: TODO
 * <p>
 * <p>
 * @author jmk
 * <p>
 * <p>
 * @date 2013-11-15
 * <p>
 */
public class MD5Util {

	static MessageDigest getDigest() {
		try {
			return MessageDigest.getInstance("MD5");
		} catch (NoSuchAlgorithmException e) {
			throw new RuntimeException(e);
		}
	}

	/**
	 * c13dceabcb143acd6c9298265d618a9f ---MD5UtilGbk---中国--utf-8
	 * cf0832dedf7457bbcbfa00bbd87b300a----MD5UtilGbk---中国--GBK
	 * 
	 * cf0832dedf7457bbcbfa00bbd87b300a-----MD5UtilUTF-8---中国--GBK
	 * c13dceabcb143acd6c9298265d618a9f---- MD5UtilUTF-8---中国--utf-8
	 * <p>
	 * </p>
	 * 
	 * @param args 00bcf9ca4fd6caf36e67618e4f5f0b5c\
	 * 086e1b7e1c12ba37cd473670b3a15214
	 * @throws java.io.UnsupportedEncodingException
	 */

	public static void main(String[] args) throws UnsupportedEncodingException {
		String key = UUID.randomUUID().toString();
		key = key.substring(0, 8) + key.substring(9, 13) + key.substring(14, 18) + key.substring(19, 23) + key.substring(24);
		String app_sign = MD5Util.md5Hex("key" + key);
		System.out.println(key);
		System.out.println(app_sign);
//		String a = "123456qwerty";
//		byte[] dataArray = a.getBytes("UTF-8");
//		// byte[] dataArray = a.getBytes("utf-8");
//		String aHex = MD5Util.md5Hex(a);
//		System.out.println(aHex);
	}

	public static byte[] md5(byte[] data) {
		return getDigest().digest(data);
	}

	public static byte[] md5(String data) {
		return md5(data.getBytes());
	}

	public static String md5Hex(byte[] data) {
		byte[] dataArray = md5(data);
		return toHexString(dataArray);
	}

	public static String md5Hex(String data) {
		byte[] dataArray = md5(data);
		return toHexString(dataArray);
	}

	/**
	 * <p>
	 * digist convert hexadecimal string
	 * </p>
	 *
	 * @param data
	 * @return
	 */
	public static String toHexString(byte[] data) {
		StringBuffer hexString = new StringBuffer();
		for (int i = 0; i < data.length; i++) {
			String hex = Integer.toHexString(0xff & data[i]);
			if (hex.length() == 1) {
				hexString.append('0');
			}
			hexString.append(hex);
		}
		return hexString.toString();
	}

	private MD5Util() {
	}


}
