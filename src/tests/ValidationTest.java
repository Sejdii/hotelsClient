package tests;

import com.sadzbr.utils.Validator;
import org.junit.Assert;
import org.junit.Test;

import java.time.LocalDate;

public class ValidationTest {
    @Test
    public void dateTest() {
        boolean x = Validator.reservationDates(LocalDate.parse("2021-04-24"), LocalDate.parse("2021-04-25"));
        Assert.assertTrue("Lesser date", x);
        x = Validator.reservationDates(LocalDate.parse("2021-04-24"), LocalDate.parse("2021-04-24"));
        Assert.assertTrue("Equal date", x);
        x = Validator.reservationDates(LocalDate.parse("2021-04-24"), LocalDate.parse("2021-04-23"));
        Assert.assertFalse("Greater date", x);
    }

    @Test
    public void numberOfPersonsTest() {
        boolean x = Validator.numberOfPersons(-1);
        Assert.assertFalse(x);
        x = Validator.numberOfPersons(0);
        Assert.assertFalse(x);
        x = Validator.numberOfPersons(1);
        Assert.assertTrue(x);
    }

    @Test
    public void emailTest() {
        boolean x = Validator.email("ks@mail.com");
        Assert.assertTrue(x);
        x = Validator.email("@mail.com");
        Assert.assertFalse(x);
        x = Validator.email("jankowalski@mail.com");
        Assert.assertTrue(x);
        x = Validator.email("jankowalski@");
        Assert.assertFalse(x);
        x = Validator.email("jankowalski@mail");
        Assert.assertFalse(x);
    }

    @Test
    public void charsOnlyTest() {
        boolean x = Validator.charsOnly("Jan");
        Assert.assertTrue(x);
        x = Validator.charsOnly("Jan124");
        Assert.assertFalse(x);
        x = Validator.charsOnly("Mieczysław");
        Assert.assertTrue(x);
        x = Validator.charsOnly("d'Arras");
        Assert.assertTrue(x);
    }

    @Test
    public void postCodeTest() {
        boolean x = Validator.postCode("27-400");
        Assert.assertTrue(x);
        x = Validator.postCode("");
        Assert.assertFalse(x);
        x = Validator.postCode("400-27");
        Assert.assertFalse(x);
        x = Validator.postCode("-400");
        Assert.assertFalse(x);
    }

    @Test
    public void positiveNumberTest() {
        boolean x = Validator.positiveNumber(1);
        Assert.assertTrue(x);
        x = Validator.positiveNumber(0);
        Assert.assertFalse(x);
        x = Validator.positiveNumber(-1);
        Assert.assertFalse(x);
    }

    @Test
    public void isNotEmptyTest() {
        boolean x;
        x = Validator.isNotEmpty("");
        Assert.assertFalse(x);
        x = Validator.isNotEmpty("a");
        Assert.assertTrue(x);
    }
}
