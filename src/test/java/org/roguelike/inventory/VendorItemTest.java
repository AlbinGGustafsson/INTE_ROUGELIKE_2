package org.roguelike.inventory;

import org.junit.jupiter.api.Test;


import static net.obvj.junit.utils.matchers.AdvancedMatchers.throwsException;
import static org.hamcrest.MatcherAssert.assertThat;

public class VendorItemTest {

    @Test
    void vendorItemWithNegativeValueThrowsException(){

        assertThat(()-> new VendorItem("name", "desc", -1), throwsException(IllegalArgumentException.class));
    }
}
