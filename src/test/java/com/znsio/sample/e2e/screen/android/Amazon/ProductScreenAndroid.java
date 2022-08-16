package com.znsio.sample.e2e.screen.android.Amazon;

import com.context.TestExecutionContext;
import com.znsio.e2e.runner.Runner;
import com.znsio.e2e.tools.Driver;
import com.znsio.e2e.tools.Visual;
import com.znsio.sample.e2e.screen.Amazon.AmazonCartScreen;
import com.znsio.sample.e2e.screen.Amazon.ProductScreen;
import org.apache.log4j.Logger;

public class ProductScreenAndroid extends ProductScreen {
    private final TestExecutionContext context;
    private static final String SCREEN_NAME = ProductScreenAndroid.class.getSimpleName();
    private static final Logger LOGGER = Logger.getLogger(SCREEN_NAME);
    private static final String NOT_YET_IMPLEMENTED = " not yet implemented";
    private final Driver driver;
    private final Visual visually;
    public ProductScreenAndroid(Driver driver, Visual visually) {
        long threadId = Thread.currentThread().getId();
        this.driver = driver;
        this.visually = visually;
        this.context= Runner.getTestExecutionContext(threadId);
    }


    @Override
    public boolean isUserOnProductPage() {
        return false;
    }

    @Override
    public boolean isAddToCartButtonIPresent() {
        return false;
    }

    @Override
    public ProductScreen iAddProductToCart() {
        return null;
    }

    @Override
    public AmazonCartScreen iClickOnCartButton() {
        return null;
    }
}
