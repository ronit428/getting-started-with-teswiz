package com.znsio.sample.e2e.businessLayer.Amazon;


import com.context.TestExecutionContext;
import com.znsio.e2e.entities.Platform;
import com.znsio.e2e.runner.Runner;
import com.znsio.sample.e2e.entities.SAMPLE_TEST_CONTEXT;
import com.znsio.sample.e2e.screen.Amazon.AmazonCartScreen;
import com.znsio.sample.e2e.screen.Amazon.ProductScreen;
import org.apache.log4j.Logger;
import org.assertj.core.api.SoftAssertions;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class AmazonCartBL {
    private static final Logger LOGGER = Logger.getLogger(AmazonCartBL.class.getName());
    private final TestExecutionContext context;
    private final SoftAssertions softly;
    private final String currentUserPersona;
    private final Platform currentPlatform;

    public AmazonCartBL(String userPersona, Platform forPlatform) {
        long threadId = Thread.currentThread()
                .getId();
        this.context = Runner.getTestExecutionContext(threadId);
        softly = Runner.getSoftAssertion(threadId);
        this.currentUserPersona = userPersona;
        this.currentPlatform = forPlatform;
        Runner.setCurrentDriverForUser(userPersona, forPlatform, context);
    }

    public AmazonCartBL() {
        long threadId = Thread.currentThread()
                .getId();
        this.context = Runner.getTestExecutionContext(threadId);
        softly = Runner.getSoftAssertion(threadId);
        this.currentUserPersona = SAMPLE_TEST_CONTEXT.ME;
        this.currentPlatform = Runner.platform;
    }

    public AmazonCartBL validateUserOnCartPage() {
        boolean isUserOnCartPage= ProductScreen.get().iClickOnCartButton().isUserOnCartPage();;
        assertThat(isUserOnCartPage).as("User is not on Cart Page").isTrue();
        return this;
    }
    public AmazonHomeBL validateAddedProductIsFoundInCart(){
        String nameOfProductAddedToCart= context.getTestStateAsString("ProductName");
        String priceOfProductAddedToCart=context.getTestStateAsString("ProductPrice");
        boolean isTheAddedProductFoundInCart= AmazonCartScreen.get().isAddedProductFoundInCart(nameOfProductAddedToCart,priceOfProductAddedToCart);
        assertThat(isTheAddedProductFoundInCart).as("The Product wasn't added to cart").isTrue();
        return new AmazonHomeBL();
    }

}
