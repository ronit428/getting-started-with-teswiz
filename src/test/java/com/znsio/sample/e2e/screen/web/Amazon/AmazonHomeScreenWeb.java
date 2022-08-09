package com.znsio.sample.e2e.screen.web.Amazon;


import com.context.TestExecutionContext;
import com.znsio.e2e.runner.Runner;
import com.znsio.e2e.tools.Driver;
import com.znsio.e2e.tools.Visual;
import com.znsio.sample.e2e.screen.Amazon.AmazonHomeScreen;
import com.znsio.sample.e2e.screen.Amazon.SearchResultScreen;
import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class AmazonHomeScreenWeb extends AmazonHomeScreen {
    private static final String SCREEN_NAME = AmazonHomeScreenWeb.class.getSimpleName();
    private static final Logger LOGGER = Logger.getLogger(SCREEN_NAME);
    private static final String NOT_YET_IMPLEMENTED = " not yet implemented";
    private final Driver driver;
    private final Visual visually;

    private static final By bySearchTextBoxId =By.id("twotabsearchtextbox");
    private static final By bySearchIconId =By.id("nav-search-submit-button");
    private static final By byHomePageSectionHeaders= By.xpath("//div[contains(@id,'desktop-grid')]//h2");
    private static final String PAGE_TITLE = "Online Shopping site in India: Shop Online for Mobiles, Books, Watches, Shoes and More - Amazon.in";
    private final TestExecutionContext context;
    public AmazonHomeScreenWeb(Driver driver, Visual visually) {
        long threadId = Thread.currentThread().getId();
        this.driver = driver;
        this.visually = visually;
        this.context= Runner.getTestExecutionContext(threadId);
    }

    @Override
    public boolean isUserOnHomePage() {
        LOGGER.debug("Amazon Application is Launched");
        visually.checkWindow(SCREEN_NAME,"On Amazon Launch/Home Screen");
        return driver.getInnerDriver().getTitle().equals(PAGE_TITLE);
    }

    @Override
    public SearchResultScreen iSearchForProduct(String productName) {
        LOGGER.debug("Search for product");
        WebElement searchTextBox=driver.findElement(bySearchTextBoxId);
        context.addTestState("Searched Product",productName);
        searchTextBox.click();
        searchTextBox.clear();
        searchTextBox.sendKeys(productName);
        driver.findElement(bySearchIconId).click();
        return SearchResultScreen.get();
    }
}
