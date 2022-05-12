package psnbtech;

import main.psnbtech.Clock;
import org.junit.Assert;
import org.junit.Before;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeEach;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

import static main.psnbtech.SnakeGame.CYCLES_PER_SECOND;

public class ClockTest {
    Clock clock;

    @BeforeEach
    public void setUp(){
        clock = new Clock(CYCLES_PER_SECOND);
    }

    @Test public void testUpdate(){

        clock.update();

    }

    @Test public void testPeekElapsedCycles(){
        clock.setElapsedCycles(0);
        boolean actual = clock.peekElapsedCycle();
        Assert.assertEquals(false,actual);
        clock.setElapsedCycles(1);
        actual = clock.peekElapsedCycle();
        Assert.assertEquals(true,actual);
    }

    @Test public void testHasElapsedCycle(){
        clock.reset();
        boolean actual = clock.hasElapsedCycle();
        Assert.assertEquals(false, actual);
        clock.setElapsedCycles(100);
        actual = clock.hasElapsedCycle();
        Assert.assertEquals(true, actual);
    }

    /**
     * This is a smelly test
     */
    @Test public void testCalcDeltaTime() throws NoSuchMethodException, InvocationTargetException, IllegalAccessException {
        long value = (long) 1.0;
        Method method = Clock.class.getDeclaredMethod("calcDeltaTime", long.class);
        method.setAccessible(true);
        clock.reset();
        float delta = (float)method.invoke(clock,value);
        Assert.assertEquals(-8.3, delta/1E7, .2 );
    }
}
