package com.github.tonydeng.desgin.cor.filter;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class HtmlFilter implements Filter {
	private static final Logger log = LoggerFactory.getLogger(HtmlFilter.class);

	@Override
	public void doFilter(Request request, Response response, FilterChain chain) {
		log.debug("-- HtmlFilter doFilter--");
		request.setReqStr(request.getReqStr().replace("<", "&lt").replace(">", "&gt"));
		chain.doFilter(request, response);
	}
}
