package common;

import java.security.MessageDigest;

import sun.misc.BASE64Encoder;

/**
 * MD5加密机
 * @author GuoGuo
 *
 */
public class Encryptor {
	/**
	 * MD5加密
	 * @param String password
	 * @param String md5Password
	 */
	public static String md5Encrypt(String password){
		String md5Password = null;
		try {
			MessageDigest md5 = MessageDigest.getInstance("MD5");
			BASE64Encoder base64Encoder = new BASE64Encoder();
			md5Password = base64Encoder.encode(md5.digest(password.getBytes()));
		} catch (Exception e) {
			e.printStackTrace();
		}
		return md5Password;
	}
}
