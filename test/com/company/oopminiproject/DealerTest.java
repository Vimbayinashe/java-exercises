package com.company.oopminiproject;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class DealerTest {

    @Test
    void changeOwnerChangesOwnerAndTransfersMoney() {
        //Arrange - Create objects required for the test
        Buyer buyer1 = new Buyer("Martin", 44 , "teacher", 100);
        Seller seller1 =  new Seller("Greger", 96, "Retired", 0);
        Dealer dealer = new Dealer("Hans", 45, 0);

        Airplane  airplane = new Airplane(44000, 100, seller1);

        //Act - make the method call
        dealer.changeOwner(airplane, buyer1);

        //Assert - verify the state after changeOwner
        assertEquals(buyer1, airplane.getOwner());      //buyer owns the plane after transaction
        assertEquals(85.0f,seller1.bankBalance(), 0.001f);
        assertEquals(15.0f, dealer.bankBalance(), 0.001f);
        assertEquals(0.0f, buyer1.bankBalance(), 0.001f);

        //0.001f - delta ->  comparing the float values only up to to 2 decimal places

    }

    @Test
    void changeOwnerDoesNotChangeOwnerWhenBuyerHasTooLittleMoney() {
        Buyer buyer1 = new Buyer("Martin", 44 , "teacher", 100);
        Seller seller1 =  new Seller("Greger", 96, "Retired", 0);
        Dealer dealer = new Dealer("Hans", 45, 0);

        Airplane  airplane = new Airplane(44000, 1000, seller1);

        //Act - make the method call
        dealer.changeOwner(airplane, buyer1);

        //Assert - verify the state after changeOwner
        assertEquals(seller1, airplane.getOwner());
        assertEquals(0.0f,seller1.bankBalance(), 0.001f);
        assertEquals(0.0f, dealer.bankBalance(), 0.001f);
        assertEquals(100.0f, buyer1.bankBalance(), 0.001f);
    }

}