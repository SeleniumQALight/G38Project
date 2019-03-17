package restTests;

import org.junit.Test;
import restSteps.privateBank.ApiPrivateBank;
import restSteps.privateBank.CurrencyValues;

public class RestTestPrivateBank {

    @Test
    public void getCursDetails(){
        ApiPrivateBank apiPrivateBank = new ApiPrivateBank();

        CurrencyValues[] responseStructure = apiPrivateBank.getRequestToPrivateBankApi(5);

        for (CurrencyValues currencyElement : responseStructure ) {
            System.out.println("Cur " + currencyElement.ccy + " to " + currencyElement.base_ccy + " has for buy " + currencyElement.buy + " and for sale " + currencyElement.sale);
        }
    }
}

