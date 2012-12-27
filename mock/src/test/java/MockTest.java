import java.lang.reflect.Method;

import org.easymock.EasyMock;
import org.junit.Test;

public class MockTest
{
    @Test
    public void testPartialMock()
        throws SecurityException, NoSuchMethodException
    {
        Class clz = AbstractDummyClass.class;
        Method method = clz.getMethod("subMethodNeedMock");
        AbstractDummyClass instance = (AbstractDummyClass)EasyMock.createMockBuilder(clz).addMockedMethod(method)
                .createMock();

        EasyMock.expect(instance.subMethodNeedMock()).andReturn(true);
        EasyMock.replay(instance);

        instance.run();
    }

}
