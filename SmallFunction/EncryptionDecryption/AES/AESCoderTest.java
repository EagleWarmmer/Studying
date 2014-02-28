package AES;

import java.security.Key;

import javax.crypto.Cipher;
import javax.crypto.KeyGenerator;
import javax.crypto.SecretKey;
import javax.crypto.spec.SecretKeySpec;


/**
 * AES
 * @author iWarmmer
 */
abstract class AESCoder{
	/**
	 * 密钥算法
	 */
	public static final String KEY_ALGORITHM="AES";
	/**
	 * 加密/解密算法/工作模式/填充方法
	 */
	public static final String CIPHER_ALGORITHM = "AES/ECB/PKCS5Padding";
	/**
	 * 转换密钥
	 * @param key 二进制密钥
	 * @return Key 密钥
	 * @throws Exception
	 */
	private static Key toKey (byte[] key)throws Exception{
		//实例化DES密钥材料
		SecretKey secretKey = new SecretKeySpec(key,KEY_ALGORITHM);
		return secretKey;
	}
	/**
	 * 解密
	 * @param data 待解密数据 
	 * @param key 密钥
	 * @return byte[] 解密数据
	 * @throws Exception
	 */
	public static byte[] decrypt(byte[] data, byte[] key) throws Exception{
		//还原密钥
		Key k = toKey(key);
		/**
		 * 实例化
		 * 选择填充方式
		 */
		Cipher cipher = Cipher.getInstance(CIPHER_ALGORITHM);
		//初始化，设置为解密模式
		cipher.init(Cipher.DECRYPT_MODE, k);
		//执行操作
		return cipher.doFinal(data);
	}
	/**
	 * 加密
	 * @param data 待加密数据
	 * @param key 密钥
	 * @return byte[] 加密数据
	 * @throws Exception
	 */
	public static byte[] encrypt(byte[] data, byte[] key) throws Exception{
		//还原密钥
				Key k = toKey(key);
				/**
				 * 实例化
				 * 选择填充方式
				 */
				Cipher cipher = Cipher.getInstance(CIPHER_ALGORITHM);
				//初始化，设置为加密模式
				cipher.init(Cipher.ENCRYPT_MODE, k);
				//执行操作
				return cipher.doFinal(data);
	}
	/**
	 * 生成密钥
	 * @return byte[] 二进制密钥
	 * @throws Exception
	 */
	public static byte[] initKey() throws Exception {
		//实例化
		KeyGenerator kGenerator = KeyGenerator.getInstance(KEY_ALGORITHM);
		//AES 密钥长度128、192、256
		kGenerator.init(128);
		//生成密钥
		SecretKey secretKey = kGenerator.generateKey();
		//获得密钥的二进制编码形成
		return secretKey.getEncoded();
	}
}

public class AESCoderTest {
	public static void main(String[] args) throws Exception{
		String aesString = "AES123";
		byte[] data =aesString.getBytes();
		byte[] key = AESCoder.initKey();
		byte [] result = AESCoder.encrypt(data, key);
		System.out.println(new String(result));
	}
}
