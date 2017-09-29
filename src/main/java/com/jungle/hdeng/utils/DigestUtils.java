package com.jungle.hdeng.utils;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

import org.apache.commons.codec.binary.Hex;

public class DigestUtils {
	static MessageDigest getDigest(String algorithm) {
		try {
			return MessageDigest.getInstance(algorithm);
		} catch (NoSuchAlgorithmException e) {
			throw new RuntimeException(e.getMessage());
		}
	}

	/**
	 * Calculates the SHA digest and returns the value as a <code>byte[]</code>.
	 *
	 * @param data
	 *            Data to digest
	 * @return SHA digest
	 */
	public static byte[] sha1(byte[] data) {
		return getSha1Digest().digest(data);
	}

	private static MessageDigest getSha1Digest() {
		return getDigest("SHA1");
	}

	/**
	 * Calculates the SHA digest and returns the value as a <code>byte[]</code>.
	 *
	 * @param data
	 *            Data to digest
	 * @return SHA digest
	 */
	public static byte[] sha1(String data) {
		return sha1(data.getBytes());
	}

	/**
	 * Calculates the SHA digest and returns the value as a hex string.
	 *
	 * @param data
	 *            Data to digest
	 * @return SHA digest as a hex string
	 */
	public static String sha1Hex(byte[] data) {
		return new String(Hex.encodeHex(sha1(data)));
	}

	/**
	 * Calculates the SHA digest and returns the value as a hex string.
	 *
	 * @param data
	 *            Data to digest
	 * @return SHA digest as a hex string
	 */
	public static String sha1Hex(String data) {
		return new String(Hex.encodeHex(sha1(data)));
	}
}
