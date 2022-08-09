package com.znsio.sample.e2e.steps;

import com.context.TestExecutionContext;
import com.znsio.sample.e2e.businessLayer.Amazon.AmazonHomeBL;
import com.znsio.sample.e2e.businessLayer.Amazon.AmazonSearchResultBL;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import com.context.SessionContext;
import com.znsio.e2e.entities.TEST_CONTEXT;
import com.znsio.e2e.runner.Runner;
import com.znsio.e2e.tools.Drivers;
import com.znsio.sample.e2e.entities.SAMPLE_TEST_CONTEXT;

import org.apache.log4j.Logger;
public class AmazonCartSteps {

    private static final Logger LOGGER = Logger.getLogger(AmazonCartSteps.class.getName());
    private final TestExecutionContext context;
    private final Drivers allDrivers;

    public AmazonCartSteps() {
        context = SessionContext.getTestExecutionContext(Thread.currentThread()
                .getId());
        LOGGER.info("context: " + context.getTestName());
        allDrivers = (Drivers) context.getTestState(TEST_CONTEXT.ALL_DRIVERS);
        LOGGER.info("allDrivers: " + (null == allDrivers));
    }
    @Given("User is on HomePage")
    public void userIsOnHomePage() {
        allDrivers.createDriverFor(SAMPLE_TEST_CONTEXT.ME, Runner.platform, context);
        LOGGER.info(String.format("userIsOnHomePage - Persona:'%s'", SAMPLE_TEST_CONTEXT.ME));
        new AmazonHomeBL(SAMPLE_TEST_CONTEXT.ME, Runner.platform).validateUserIsOnTheHomePage();
    }

    @When("User searches for {string}")
    public void userSearchesFor(String productName) {
        new AmazonHomeBL().UserSearchsForProduct(productName);
    }

    @Then("Adds Product to Cart")
    public void addsProductToCart() {
        new AmazonSearchResultBL().userSelectsFirstProductOnSearchResultPage()
                .userAddProductToCart();
        new AmazonHomeBL().UserGoesToTheCart();
    }
}
