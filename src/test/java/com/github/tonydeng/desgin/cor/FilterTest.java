package com.github.tonydeng.desgin.cor;

import com.github.tonydeng.desgin.BaseTest;
import com.github.tonydeng.desgin.cor.filter.*;
import org.junit.Assert;
import org.junit.Before;

public class FilterTest extends BaseTest {

	private static String msg = "被就业了：），敏感信息，<script>";

	private FilterChain chain;

	@Before
	public void init() {
		chain = new FilterChain();
		chain.addFilter(new HtmlFilter());
		chain.addFilter(new SensitiveFilter());
	}

	public void test() {
		Request request = new Request();
		Response response = new Response();
		request.setReqStr(msg);
		response.setRespStr("response");

		chain.doFilter(request, response);

		Assert.assertEquals("response", response.getRespStr());

		Assert.assertEquals("就业了：），信息，&ltscript&gt", request.getReqStr());
	}
}