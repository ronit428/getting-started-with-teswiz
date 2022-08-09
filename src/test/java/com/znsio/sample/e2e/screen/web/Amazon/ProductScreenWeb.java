package com.znsio.sample.e2e.screen.web.Amazon;

import com.context.TestExecutionContext;
import com.znsio.e2e.runner.Runner;
import com.znsio.e2e.tools.Driver;
import com.znsio.e2e.tools.Visual;
import com.znsio.sample.e2e.screen.Amazon.AmazonCartScreen;
import com.znsio.sample.e2e.screen.Amazon.ProductScreen;
import org.apache.log4j.Logger;
import org.openqa.selenium.By;

public class ProductScreenWeb extends ProductScreen {
    private static final String SCREEN_NAME = ProductScreenWeb.class.getSimpleName();
    private static final Logger LOGGER = Logger.getLogger(SCREEN_NAME);
    private static final String NOT_YET_IMPLEMENTED = " not yet implemented";
    private final Driver driver;
    private final Visual visually;
    private final TestExecutionContext context;

    //    private static final By backToProductLinkId=By.id("breadcrumb-back-link");
    private static final By byShareProductDetailsButton =By.xpath("//i[@title='Share']");
    private static final By byProductTitleId =By.id("productTitle");
    private static final By byProductPriceXpath =By.xpath("//span[@class='a-price']/span[@class='a-offscreen']");
    private static final By byAddToCartButtonId =By.id("add-to-cart-button");
    private static final By byCartPopupCloseButtonId =By.id("attach-close_sideSheet-link");

    private static final By byNewCheckBox=By.xpath("//div[@class='a-accordion-row-a11y' and @aria-expanded='false']//a");

    private static final By byCartButtonId =By.id("nav-cart");

    public ProductScreenWeb(Driver driver, Visual visually) {
        long threadId = Thread.currentThread().getId();
        this.driver = driver;
        this.visually = visually;
        this.context= Runner.getTestExecutionContext(threadId);
    }

    @Override
    public boolean isUserOnProductPage() {
        LOGGER.debug("On ProductsDetail Page");
        visually.checkWindow(SCREEN_NAME,"On ProductsDetail page");
        driver.waitTillElementIsPresent(byShareProductDetailsButton);
        return driver.isElementPresent(byShareProductDetailsButton);
    }
    private ProductScreen detailsOfProductToBeAdded(){
        String productName=driver.findElement(byProductTitleId).getText();
        String productPrice=driver.findElement(byProductPriceXpath).getText();
        if(context.getTestStateAsString("firstproductonresultspage").equals(productName)) {
            context.addTestState("ProductName", productName);
            context.addTestState("ProductPrice", productPrice);
        }
        return this;
    }
    private ProductScreen iClickAddToCart(){
//        driver.findElement(byNewCheckBox).click();
        driver.waitForClickabilityOf(byAddToCartButtonId);
        driver.findElement(byAddToCartButtonId).click();
        return this;
    }
    private ProductScreen iDismissTheCartDetailsSidePopup(){
        driver.waitForClickabilityOf(byCartPopupCloseButtonId);
        driver.findElement(byCartPopupCloseButtonId).click();
        return this;
    }
    @Override
    public boolean isAddToCartButtonIPresent() {
        return driver.isElementPresent(byAddToCartButtonId);
    }

    @Override
    public ProductScreen iAddProductToCart() {
        detailsOfProductToBeAdded();
        iClickAddToCart();
        LOGGER.info("add to cart button clicked");
        iDismissTheCartDetailsSidePopup();
        return this;
    }
    @Override
    public AmazonCartScreen iClickOnCartButton() {
        LOGGER.debug("Click on Amazon Cart");
        driver.findElement(byCartButtonId).click();
        return AmazonCartScreen.get();
    }

}