package edu.unisabana.dyas.patterns.observer;

import java.text.DecimalFormat;
import java.text.SimpleDateFormat;

import edu.unisabana.dyas.patterns.observer.impl.ConfigurationManager;
import edu.unisabana.dyas.patterns.observer.impl.observers.DateFormatObserver;
import edu.unisabana.dyas.patterns.observer.impl.observers.MoneyFormatObserver;

/**
 * @author 
 */
public class ObserverMain {

    public static void main(String[] args) {
        // Instance of the observable
        ConfigurationManager conf = ConfigurationManager.getInstance();

        // we create the observers that will be registered in the observable
        DateFormatObserver dateFormatObserver = new DateFormatObserver();
        MoneyFormatObserver moneyFormatObserver = new MoneyFormatObserver();

        // we register the observers in the observable
        conf.addObserver(dateFormatObserver);
        conf.addObserver(moneyFormatObserver);

        // we establish the initial configuration
        conf.setDefaultDateFormat(new SimpleDateFormat("yyyy/MM/dd"));
        conf.setMoneyFormat(new DecimalFormat("##.00"));
        System.out.println("Established configuration");

        System.out.println("");

        // we make changes to the configuration
        conf.setDefaultDateFormat(new SimpleDateFormat("dd/MM/yyyy"));
        conf.setMoneyFormat(new DecimalFormat("###,#00.00"));

        System.out.println("");

        // another change
        conf.setDefaultDateFormat(new SimpleDateFormat("MM/yyyy/dd"));
        conf.setMoneyFormat(new DecimalFormat("###,#00"));

        // we remove the observers
        conf.removeObserver(dateFormatObserver);
        conf.removeObserver(moneyFormatObserver);

        System.out.println("");

        // we make changes to the configuration
        conf.setDefaultDateFormat(new SimpleDateFormat("MM/yyyy"));
        conf.setMoneyFormat(new DecimalFormat("###,##0.00"));
    }
}
