package lab_7.util;

import org.junit.jupiter.api.Test;

import java.lang.reflect.Field;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertSame;

class PasswordMakerTest {
    @Test
    void instanceIsInitializedInStaticBlockAndReused() throws NoSuchFieldException, IllegalAccessException {
        Field instanceField = PasswordMaker.class.getDeclaredField("instance");
        instanceField.setAccessible(true);

        Object instanceFromStaticBlock = instanceField.get(null);

        assertNotNull(instanceFromStaticBlock);
        assertSame(instanceFromStaticBlock, PasswordMaker.getInstance());
    }
}
