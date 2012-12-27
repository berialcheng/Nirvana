public abstract class AbstractDummyClass
{
    public abstract boolean subMethodNeedMock();

    public void run()
    {
        System.out.println(subMethodNeedMock());
        abc();
    }

    public void abc()
    {
        System.out.println("abc");
    }
}
