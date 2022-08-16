package com.znsio.sample.e2e.screen.Amazon;


import com.znsio.e2e.entities.Platform;
import com.znsio.e2e.runner.Runner;
import com.znsio.e2e.tools.Driver;
import com.znsio.e2e.tools.Visual;
import com.znsio.sample.e2e.screen.android.Amazon.ProductScreenAndroid;
import com.znsio.sample.e2e.screen.web.Amazon.ProductScreenWeb;
import org.apache.commons.lang3.NotImplementedException;
import org.apache.log4j.Logger;

import static com.znsio.e2e.runner.Runner.fetchDriver;
import static com.znsio.e2e.runner.Runner.fetchEyes;

public abstract class ProductScreen {
    private static final String SCREEN_NAME = ProductScreen.class.getSimpleName();
    private static final Logger LOGGER = Logger.getLogger(SCREEN_NAME);

    public static ProductScreen get() {
        Driver driver = fetchDriver(Thread.currentThread()
                .getId());
        Platform platform = Runner.fetchPlatform(Thread.currentThread()
                .getId());
        LOGGER.info(SCREEN_NAME + ": Driver type: " + driver.getType() + ": Platform: " + platform);
        Visual visually = fetchEyes(Thread.currentThread()
                .getId());

        switch (platform) {
            case web:
                return new ProductScreenWeb(driver, visually);
            case android:
                return new ProductScreenAndroid(driver, visually);
        }
        throw new NotImplementedException(SCREEN_NAME + " is not implemented in " + Runner.platform);
    }

    public abstract boolean isUserOnProductPage();

    public abstract boolean isAddToCartButtonIPresent();

    public abstract ProductScreen iAddProductToCart();

    public abstract AmazonCartScreen iClickOnCartButton();
}