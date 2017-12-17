package callspy;

import java.lang.instrument.Instrumentation;

public class Agent {

  public static void premain(String args, Instrumentation instrumentation){
    System.out.println("in premain");
    CallSpy transformer = new CallSpy();
    instrumentation.addTransformer(transformer);
  }
}
