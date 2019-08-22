package com.github.tonydeng.desgin.cor.filter;


import lombok.extern.slf4j.Slf4j;

@Slf4j
public class HtmlFilter implements Filter {

	@Override
	public void doFilter(Request request, Response response, FilterChain chain) {
		log.debug("-- HtmlFilter doFilter--");
		request.setReqStr(request.getReqStr().replace("<", "&lt").replace(">", "&gt"));
		chain.doFilter(request, response);
	}
}
