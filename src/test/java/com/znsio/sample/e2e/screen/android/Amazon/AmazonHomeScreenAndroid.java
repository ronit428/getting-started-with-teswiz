package com.znsio.sample.e2e.screen.android.Amazon;

import com.context.TestExecutionContext;
import com.znsio.e2e.runner.Runner;
import com.znsio.e2e.tools.Driver;
import com.znsio.e2e.tools.Visual;
import com.znsio.sample.e2e.screen.Amazon.AmazonHomeScreen;
import com.znsio.sample.e2e.screen.Amazon.SearchResultScreen;
import com.znsio.sample.e2e.screen.web.Amazon.AmazonHomeScreenWeb;
import org.apache.log4j.Logger;

public class AmazonHomeScreenAndroid extends AmazonHomeScreen {

    private final TestExecutionContext context;
    private static final String SCREEN_NAME = AmazonHomeScreenAndroid.class.getSimpleName();
    private static final Logger LOGGER = Logger.getLogger(SCREEN_NAME);
    private static final String NOT_YET_IMPLEMENTED = " not yet implemented";
    private final Driver driver;
    private final Visual visually;
    public AmazonHomeScreenAndroid(Driver driver, Visual visually) {
        long threadId = Thread.currentThread().getId();
        this.driver = driver;
        this.visually = visually;
        this.context= Runner.getTestExecutionContext(threadId);
    }


    @Override
    public boolean isUserOnHomePage() {
        return false;
    }

    @Override
    public SearchResultScreen iSearchForProduct(String productName) {
        return null;
    }
}
