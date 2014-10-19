import groovy.lang.GroovyObject;
import groovy.lang.MetaClass;
import org.codehaus.groovy.runtime.callsite.CallSite;

public class Foo
  implements GroovyObject
{
  private String name;

  public Foo()
  {
    Foo this;
    CallSite[] arrayOfCallSite = $getCallSiteArray();
    MetaClass localMetaClass = $getStaticMetaClass();
    this.metaClass = localMetaClass;
  }

  static
  {
    __$swapInit();
    long l1 = 0L;
    __timeStamp__239_neverHappen1375273625257 = l1;
    long l2 = 1375273625257L;
  }

  public String getName()
  {
    return this.name;
  }

  public void setName(String paramString)
  {
    this.name = paramString;
  }
}

/* Location:           C:\var\workingcopy\nirvana\jvm\groovy\
 * Qualified Name:     Foo
 * JD-Core Version:    0.6.2
 */