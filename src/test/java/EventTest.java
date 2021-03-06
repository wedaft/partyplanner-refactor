import models.Event;
import org.junit.Test;

import static org.junit.Assert.*;

public class EventTest {
    @Test
    public void newEvent_InstantiatesNewEvent_true() throws Exception {
        Event newEvent = new Event(50,"sfd","dsf", "sdf");
        assertEquals(true, newEvent instanceof Event);
    }

    @Test
    public void newEvent_SetPropertiesOfNewEvent() throws Exception {
        Event newEvent = new Event(50, "soup and salad", "wine and beer", "Beyonce");
        assertEquals(50, newEvent.getNumOfGuests());
        assertEquals("soup and salad", newEvent.getFoodSelection());
    }

    @Test
    public void newEvent_GetPriceOfFoodSelection_15() throws Exception {
        Event newEvent = new Event(50, "soup and salad", "wine and beer", "Beyonce");
        assertEquals(15, newEvent.getFoodPricePerGuest(newEvent.getFoodSelection()));
    }

    @Test
    public void newEvent_GetPriceOfBeverageSelection_5() throws Exception {
        Event newEvent = new Event(50, "soup and salad", "soda and water", "Beyonce");
        assertEquals(5, newEvent.getBeveragePricePerGuest(newEvent.getBeverageSelection()));
    }

    @Test
    public void newEvent_GetPerGuestFBPrice_20() throws Exception {
        Event newEvent = new Event(50, "soup and salad", "soda and water", "Beyonce");
        assertEquals(20, newEvent.getFBPricePerGuest(newEvent.getFoodPricePerGuest(newEvent.getFoodSelection()),newEvent.getBeveragePricePerGuest(newEvent.getBeverageSelection())));
    }

    @Test
    public void newEvent_GetTotalFBPriceForAllGuests_1000() throws Exception {
        Event newEvent = new Event(50, "soup and salad", "soda and water", "Beyonce");
        assertEquals(1000, newEvent.getTotalGuestPriceExcludingEntertainment(newEvent.getFBPricePerGuest(newEvent.getFoodPricePerGuest(newEvent.getFoodSelection()),newEvent.getBeveragePricePerGuest(newEvent.getBeverageSelection())), newEvent.getNumOfGuests()));
    }

    @Test
    public void newEvent_GetEntertainmentPrice_10000() throws Exception {
        Event newEvent = new Event(50, "soup and salad", "soda and water", "beyonce");
        assertEquals(20000, newEvent.getEntertainmentPrice(newEvent.getEntertainmentSelection()));
    }

    @Test
    public void newEvent_GetTotalEventPricePrediscount_21000() throws Exception {
        Event newEvent = new Event(50, "soup and salad", "soda and water", "beyonce");
        assertEquals(21000, newEvent.getTotalEventPriceBeforeDiscounts(newEvent.getTotalGuestPriceExcludingEntertainment(newEvent.getFBPricePerGuest(newEvent.getFoodPricePerGuest(newEvent.getFoodSelection()),newEvent.getBeveragePricePerGuest(newEvent.getBeverageSelection())), newEvent.getNumOfGuests()),newEvent.getEntertainmentPrice(newEvent.getEntertainmentSelection())));
    }

    @Test
    public void newEvent_Get20PercentOffTotalPrice_16800() throws Exception {
        Event newEvent = new Event(50, "soup and salad", "soda and water", "beyonce");
        assertEquals(16800, newEvent.get20PercentOffTotal(newEvent.getTotalEventPriceBeforeDiscounts(newEvent.getTotalGuestPriceExcludingEntertainment(newEvent.getFBPricePerGuest(newEvent.getFoodPricePerGuest(newEvent.getFoodSelection()),newEvent.getBeveragePricePerGuest(newEvent.getBeverageSelection())), newEvent.getNumOfGuests()),newEvent.getEntertainmentPrice(newEvent.getEntertainmentSelection()))));
    }

    @Test
    public void newEvent_GetFreeFleas_string() throws Exception {
        Event newEvent = new Event(100, "soup and salad", "imported beers", "beyonce");
        assertEquals("We have added the flea circus to your entertainment selection.", newEvent.getFreeFleas(newEvent.getTotalGuestPriceExcludingEntertainment(newEvent.getFBPricePerGuest(newEvent.getFoodPricePerGuest(newEvent.getFoodSelection()), newEvent.getBeveragePricePerGuest(newEvent.getBeverageSelection())), newEvent.getNumOfGuests())));
    }

}