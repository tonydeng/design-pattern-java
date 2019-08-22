package com.github.tonydeng.desgin.cor;

import lombok.extern.slf4j.Slf4j;
@Slf4j
public class Dollar10Dispenser implements DispenseChain {
	private DispenseChain chain;

	@Override
	public void setNextChain(DispenseChain nextChain) {
		this.chain = nextChain;
	}

	@Override
	public void dispense(Currency currency) {
		if (currency.getAmount() >= 10) {
			int num = currency.getAmount() / 10;
			int remainder = currency.getAmount() % 10;

			log.info("Dispensing {} 10$ note", num);
			if (remainder != 0) {
				this.chain.dispense(new Currency(remainder));
			}
		} else {
			this.chain.dispense(currency);
		}
	}
}
