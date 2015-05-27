package test.java.chapter5;

import chapter5.Trader;
import chapter5.Transaction;
import chapter5.TransactionService;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

import java.util.List;

/**
 * Created by abdellah on 21/05/15.
 */
@RunWith(JUnit4.class)
public class TransactionServiceTest {


    private TransactionService transactionService;

    @Before
    public void setUp(){
         transactionService=new TransactionService();
    }
    @Test
    public void shouldFindAll2011TransactionsAndSortThem(){
        List<Transaction>transactions=transactionService.findAllTransactionsOf(2011);
        Assert.assertNotNull(transactions);
        Transaction firstTransaction = transactions.get(0);
        Assert.assertEquals(firstTransaction.getTrader().getName(),"Amin");
        Transaction secondTransaction = transactions.get(1);
        Assert.assertEquals(secondTransaction.getTrader().getName(),"Alami");
    }
    @Test
    public void shouldExtractAllTradersCities(){
        List<String> cities = transactionService.extractAllTradersCities();
        Assert.assertEquals(3,cities.size());
        Assert.assertTrue(cities.contains("Errachidia"));
        Assert.assertTrue(cities.contains("Fez"));
        Assert.assertTrue(cities.contains("Marseille"));
    }
    @Test
    public void shouldReturnAllTradersFormFezSortedByName() {
        List<Trader> traders = transactionService.findAllTradersFrom("Fez");
        Assert.assertEquals(2,traders.size());
        Trader firstTrader = traders.get(0);
        Assert.assertEquals(firstTrader.getName(),"Alami");
        Trader secondTrader=traders.get(1);
        Assert.assertEquals(secondTrader.getName(),"Souhail");
    }
    @Test
    public void shouldReturnInStringAllTradersNamesSorted(){
        String names=transactionService.getAllTradersNames();
        Assert.assertEquals("Abdel Alami Amin Souhail",names);
    }
    @Test
    public void shouldTestIsThereAnyTreaderInCity(){
        Assert.assertEquals(false,transactionService.IsThereAnyTreaderIn("Paris"));
        Assert.assertEquals(true, transactionService.IsThereAnyTreaderIn("Fez"));
    }
    @Test
    public void shouldReturnAllTransactionValuesInFez(){
        List<Integer>values=transactionService.findAllTransactionsValuesIn("Fez");
        Assert.assertEquals(values.size(),2);
        Assert.assertTrue(values.contains(400));
        Assert.assertTrue(values.contains(710));
    }
    @Test
    public void shouldReturnTheHighestOfAllTransactions(){
        Assert.assertEquals(transactionService.getTheHighestValue(),1000);
    }
    @Test
    public void shouldReturnTheSmallestValue(){
        Assert.assertEquals(transactionService.getTheSmallestValue(),300);
    }
    @Test
    public void findTheSmallestTransaction(){
        Transaction transaction =transactionService.findTheSmallestTransaction();
        Assert.assertEquals(transaction.getValue(),300);
    }

}
