package be.abis.exercise;

import be.abis.exercise.service.CurrencyService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class CurrencyAPITest {

    @Autowired
    CurrencyService cs;


    @Test
    public void testGetRate() {
        String fromCur="EUR";
        String toCur="JPY";
        double d = cs.getExchangeRate(fromCur,toCur);
        System.out.println("Rate from " + fromCur + " to "+ toCur+  " is " + d);
    }
}
