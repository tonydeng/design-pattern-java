package com.github.tonydeng.desgin.cor.filter;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class SensitiveFilter implements Filter {
	private static final Logger log = LoggerFactory.getLogger(SensitiveFilter.class);

	@Override
	public void doFilter(Request request, Response response, FilterChain chain) {
		log.debug("-- SensitiveFilter doFilter --");
		request.setReqStr(request.getReqStr().replace("敏感", "").replace("被就业", "就业"));

		chain.doFilter(request, response);
	}
}
