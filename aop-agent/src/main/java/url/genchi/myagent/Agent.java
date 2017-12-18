package url.genchi.myagent;

import java.lang.instrument.Instrumentation;

public class Agent {

  public static void premain(String args, Instrumentation instrumentation){
    MyTransformer transformer = new MyTransformer();
    instrumentation.addTransformer(transformer);
  }
}
