package com.jungle.hdeng.servlet;

import java.io.IOException;
import java.io.InputStream;
import java.util.Arrays;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.codec.digest.DigestUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class WechatCallbackValidator extends HttpServlet {
	private static final Logger LOG = LoggerFactory.getLogger(WechatCallbackValidator.class);
	private static final long serialVersionUID = 1007407358736672712L;
	// 自定义 token
	private final static String TOKEN = "itisademo";

	@Override
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 时间戳
		String timestamp = request.getParameter("timestamp");

		// 随机数
		String nonce = request.getParameter("nonce");
		// 随机字符串
		String echostr = request.getParameter("echostr");
		LOG.info("timestamp={},\tnonce={},\techostr={}", timestamp, nonce, echostr);
		String[] ary = { TOKEN, timestamp, nonce };
		Arrays.sort(ary); // 字典序排序
		String dataStr = ary[0] + ary[1] + ary[2];
		// SHA1加密
		String digest = DigestUtils.shaHex(dataStr);

		// 微信加密签名
		String signature = request.getParameter("signature");
		// 确认请求来至微信
		if (digest.equals(signature)) {
			response.getWriter().print(echostr);
		} else {
			response.setCharacterEncoding("UTF-8");
			response.getWriter().print("<meta charset=\"utf-8\">你是猴子搬来的救兵吗？");
		}
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String uri = req.getRequestURI();
		String qs = req.getQueryString();

		String body = inputStream2String(req.getInputStream());

		LOG.info("uri={},\tqs={},\techostr={}", uri, qs, body);
		resp.setCharacterEncoding("UTF-8");
		resp.getWriter().print("<meta charset=\"utf-8\">你是猴子搬来的救兵吗？");
	}

	private String inputStream2String(InputStream in) throws IOException {
		StringBuffer out = new StringBuffer();
		byte[] b = new byte[4096];
		for (int n; (n = in.read(b)) != -1;) {
			out.append(new String(b, 0, n));
		}
		return out.toString();
	}
}
