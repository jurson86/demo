package com.abo.service.Impl;



import com.abo.dao.WeibuPointsBillDao;
import com.abo.stock.Portfolio;
import com.abo.stock.Stock;
import com.abo.stock.StockMarket;
import junit.framework.TestCase;

import org.easymock.EasyMock;
import org.junit.Before;
import org.junit.Test;



public class PortfolioTest extends TestCase {

    private Portfolio portfolio;
    private StockMarket marketMock;

    @Before
    public void setUp() {
        portfolio = new Portfolio();
        portfolio.setName("Veera's portfolio.");
        marketMock = EasyMock.createMock(StockMarket.class);
        portfolio.setStockMarket(marketMock);

    }

    @Test
    public void testGetTotalValue() {
        WeibuPointsBillDao weibuPointsBillDao=EasyMock.createMock(WeibuPointsBillDao.class);
        EasyMock.expect(weibuPointsBillDao.selectMyPoints(10)).andReturn(10);
        EasyMock.replay(weibuPointsBillDao);
        System.out.println(weibuPointsBillDao.selectMyPoints(10));

		/* = Setup our mock object with the expected values */
        EasyMock.expect(marketMock.getPrice("EBAY")).andReturn(42.00);
        EasyMock.replay(marketMock);

		/* = Now start testing our portfolio */
        Stock ebayStock = new Stock("EBAY", 2);
        portfolio.addStock(ebayStock);
//        assertEquals(84.00, portfolio.getTotalValue());
        System.out.println(portfolio.getTotalValue());
    }

}
