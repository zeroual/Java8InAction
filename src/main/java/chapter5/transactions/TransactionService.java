package chapter5.transactions;

import java.util.Arrays;
import java.util.List;
import static java.util.Comparator.comparing;
import static java.util.stream.Collectors.toList;

/**
 * Created by abdellah on 21/05/15.
 */
public class TransactionService {

    private final List<Transaction> transations;

    public TransactionService() {
        Trader abdel=new Trader("Abdel","Errachidia");
        Trader souhail=new Trader("Souhail","Fez");
        Trader alami=new Trader("Alami","Fez");
        Trader amin=new Trader("Amin","Marseille");
        transations= Arrays.asList(
                new Transaction(amin, 2011, 300),
                new Transaction(abdel, 2012, 1000),
                new Transaction(alami, 2011, 400),
                new Transaction(souhail, 2012, 710),
                new Transaction(abdel, 2012, 700),
                new Transaction(amin, 2012, 950)
        );
    }

    public List<Transaction> findAllTransactionsOf(int year) {
         return transations.stream().filter(t -> t.getYear() == year).
                 sorted(comparing(Transaction::getValue))
                 .collect(toList());
    }

    public List<String> extractAllTradersCities() {
        // its possible to use toSet as Collector
        return transations.stream().map(t -> t.getTrader().getCity()).distinct().collect(toList());
    }

    public List<Trader> findAllTradersFrom(String city) {
        return transations.stream().map(Transaction::getTrader)
                .filter(trader -> trader.getCity()
                        .equals(city)).distinct()
                .sorted(comparing(Trader::getName)).collect(toList());
    }

    public String getAllTradersNames() {
        //my first solution
        return transations.stream()
                .map(transaction -> transaction.getTrader().getName())
                .distinct()
                .sorted()
                .reduce((n1, n2) -> n1 + " " + n2).orElse("");
        //solution proposed by the abhor
        //collect(joining())
    }

    public boolean IsThereAnyTreaderIn(String city) {
        //return transations.stream().map(t->t.getTrader().getCity()).anyMatch(c->c.equals(city));
        return  transations.stream().anyMatch(t->t.getTrader().getCity().equals(city));
    }

    public List<Integer> findAllTransactionsValuesIn(String city) {
        return transations.stream().filter(t -> t.getTrader().getCity().equals(city)).map(Transaction::getValue).collect(toList());
    }

    public int getTheHighestValue() {
        return transations.stream().mapToInt(Transaction::getValue).max().orElse(0);
    }

    public int getTheSmallestValue() {
        return transations.stream().map(Transaction::getValue).reduce(Integer::min).get();
    }

    public Transaction findTheSmallestTransaction() {
//        return transations.stream().reduce((t1,t2)->t1.getValue()<t2.getValue()?t1:t2).get();
        return transations.stream().min(comparing(Transaction::getValue)).get();
    }
}
