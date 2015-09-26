package com.github.tonydeng.desgin.strategy;

import com.github.tonydeng.desgin.BaseTest;
import com.github.tonydeng.desgin.strategy.impl.CreaditCardStrategy;
import com.github.tonydeng.desgin.strategy.impl.PaypalStrategy;
import org.junit.Test;

/**
 * Created by tonydeng on 15/9/27.
 */
public class ShoppingCartTest extends BaseTest{

    @Test
    public void testCreaditCardPay(){
        ShoppingCart cart = new ShoppingCart();
        Item item1 = new Item("1234",10);
        Item item2 = new Item("5678",84);

        cart.addItem(item1);
        cart.addItem(item2);

        cart.pay(new CreaditCardStrategy("Tony Deng","1234567890123456","789","12/15"));
    }

    @Test
    public void testPaypalPay(){
        ShoppingCart cart = new ShoppingCart();
        Item item1 = new Item("1234",10);
        Item item2 = new Item("5678",84);

        cart.addItem(item1);
        cart.addItem(item2);

        cart.pay(new PaypalStrategy("tonydeng@github.com","***************"));
    }
}
