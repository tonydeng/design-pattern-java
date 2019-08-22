package com.github.tonydeng.desgin.cor.filter;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class SensitiveFilter implements Filter {

	@Override
	public void doFilter(Request request, Response response, FilterChain chain) {
		log.debug("-- SensitiveFilter doFilter --");
		request.setReqStr(request.getReqStr().replace("敏感", "").replace("被就业", "就业"));

		chain.doFilter(request, response);
	}
}
