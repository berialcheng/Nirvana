/*    */ import groovy.lang.Closure;
/*    */ import groovy.lang.GroovyObject;
/*    */ import groovy.lang.MetaClass;
/*    */ import org.codehaus.groovy.runtime.GStringImpl;
/*    */ import org.codehaus.groovy.runtime.GeneratedClosure;
/*    */ import org.codehaus.groovy.runtime.callsite.CallSite;
/*    */ 
/*    */ public class Simple
/*    */   implements GroovyObject
/*    */ {
/*    */   private Object def_member;
/*    */ 
/*    */   public Simple()
/*    */   {
/*    */     Simple this;
/*  5 */     CallSite[] arrayOfCallSite = $getCallSiteArray(); MetaClass localMetaClass = $getStaticMetaClass(); this.metaClass = localMetaClass; String str = "string"; this.def_member = str;
/*    */   }
/*    */ 
/*    */   public Object def_method() {
/*  9 */     CallSite[] arrayOfCallSite = $getCallSiteArray(); Object member_clousure = new Simple._def_method_closure1(this);
/*    */ 
/* 15 */     return arrayOfCallSite[0].call(member_clousure, "my name", "abc"); return null;
/*    */   }
/*    */ 
/*    */   public Object def_method2(String param1) {
/* 19 */     CallSite[] arrayOfCallSite = $getCallSiteArray(); return arrayOfCallSite[1].callCurrent(this, param1); return null;
/*    */   }
/*    */ 
/*    */   static
/*    */   {
/*    */     __$swapInit();
/*    */     long l1 = 0L;
/*    */     __timeStamp__239_neverHappen1375275884383 = l1;
/*    */     long l2 = 1375275884383L;
/*    */   }
/*    */ 
/*    */   public Object getDef_member()
/*    */   {
/*    */     return this.def_member;
/*    */   }
/*    */ 
/*    */   public void setDef_member(Object paramObject)
/*    */   {
/*    */     this.def_member = paramObject;
/*    */   }
/*    */ 
/*    */   class _def_method_closure1 extends Closure
/*    */     implements GeneratedClosure
/*    */   {
/*    */     public _def_method_closure1(Object _thisObject)
/*    */     {
/*    */       super(_thisObject);
/*    */     }
/*    */ 
/*    */     public Object doCall(Object a, Object b)
/*    */     {
/* 10 */       CallSite[] arrayOfCallSite = $getCallSiteArray(); arrayOfCallSite[0].callCurrent(this, new GStringImpl(new Object[] { a }, new String[] { "statement_one ", "." }));
/* 11 */       arrayOfCallSite[1].callCurrent(this, new GStringImpl(new Object[] { b }, new String[] { "statement_two ", "." }));
/* 12 */       return "return str"; return null;
/*    */     }
/*    */ 
/*    */     public Object call(Object a, Object b)
/*    */     {
/*    */       CallSite[] arrayOfCallSite = $getCallSiteArray();
/*    */       return arrayOfCallSite[2].callCurrent(this, a, b);
/*    */       return null;
/*    */     }
/*    */ 
/*    */     static
/*    */     {
/*    */       __$swapInit();
/*    */     }
/*    */   }
/*    */ }

/* Location:           C:\var\workingcopy\nirvana\jvm\groovy\
 * Qualified Name:     Simple
 * JD-Core Version:    0.6.2
 */