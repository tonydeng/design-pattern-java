package com.github.tonydeng.desgin.cor.filter;

import com.google.common.collect.Lists;

import java.util.List;

public class FilterChain {
	private List<Filter> filters = Lists.newArrayList();

	private int index = 0;

	public FilterChain addFilter(Filter filter) {
		filters.add(filter);
		return this;
	}

	public void doFilter(Request request, Response response) {
		if (index == filters.size()) {
			return;
		}
		Filter filter = filters.get(index);
		index++;
		filter.doFilter(request, response, this);
	}
}
