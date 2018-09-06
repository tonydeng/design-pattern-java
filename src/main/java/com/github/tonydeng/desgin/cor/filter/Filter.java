package com.github.tonydeng.desgin.cor.filter;

public interface Filter {
	void doFilter(Request request, Response response, FilterChain chain);
}
