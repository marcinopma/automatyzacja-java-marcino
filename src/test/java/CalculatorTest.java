import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.*;

public class CalculatorTest {
    @Test
    public void main() throws Exception {
    }

    @Test
    public void canAddPositiveNumbers() throws Exception {
        double a=4.2;
        double b=4.2;
        Assert.assertTrue("10+5=8.4 " , Calculator.add(a,b)==8.4);


    }

    @Test
    public void canAddPositiveNegative() throws Exception {
        double a=-4.2;
        double b=4.2;
        Assert.assertTrue("-4.2+4.2=0 " , Calculator.add(a,b)==0);


    }

    @Test
    public void subtract() throws Exception {
        double a=4.2;
        double b=2.2;
        Assert.assertTrue("4.2+2.2=2 " , Calculator.subtract(a,b)==2);
    }

    @Test
    public void canSubtractNegative() throws Exception {
        double a=4.2;
        double b=-2.2;
        Assert.assertTrue("4.2-(-2.2)=6.4 " , Calculator.subtract(a,b)==6.4);
    }

    @Test
    public void divide() throws Exception {
        double a=8;
        double b=2;
        Assert.assertTrue("4.2+2.2=2 " , Calculator.divide(a,b)==4);


    }

    @Test
    public void canDividebyZero() throws Exception {
        double a=8;
        double b=0;
        Assert.assertTrue("8/0= positive infinity" , Calculator.divide(a,b)== Double.POSITIVE_INFINITY);


    }

    @Test
    public void canDivideNegativeIntegerbyZero() throws Exception {
        double a=-8;
        double b=0;
        Assert.assertTrue("8/0= positive infinity" , Calculator.divide(a,b)== Double.NEGATIVE_INFINITY);


    }

    @Test
    public void canDivideZerobyZero() throws Exception {
        double a=0;
        double b=0;
        Assert.assertTrue("0/0= positive infinity" , Calculator.divide(a,b)== 0.0);


    }


    @Test
    public void multiply() throws Exception {
        double a=8;
        double b=2;
        Assert.assertTrue("8*2=16 " , Calculator.multiply(a,b)==16);
    }

    @Test
    public void canMultiplyNegative() throws Exception {
        double a=8;
        double b=-2;
        Assert.assertTrue("8*(-2)=-16 " , Calculator.multiply(a,b)==-16);
    }

}