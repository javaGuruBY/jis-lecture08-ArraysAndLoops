package by.jrr;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class App {

    static Logger logger = LoggerFactory.getLogger(App.class);

    public static void main(String[] args) {
        logger.info("zero size array demo: size is " + (args.length));


    }
}
