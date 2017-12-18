package url.genchi.myagent;

import javassist.ClassPool;
import javassist.CtClass;
import javassist.CtMethod;

import java.io.ByteArrayInputStream;
import java.lang.instrument.ClassFileTransformer;
import java.lang.instrument.IllegalClassFormatException;
import java.security.ProtectionDomain;

public class MyTransformer implements ClassFileTransformer {

  public byte[] transform(
                          ClassLoader loader,
                          String className,
                          Class<?> classBeingRedefined,
                          ProtectionDomain protectionDomain,
                          byte[] classfileBuffer) throws IllegalClassFormatException {

    ClassPool cp = ClassPool.getDefault();
    cp.importPackage("url.genchi.myagent");

    if (className.startsWith("url/genchi/myagent/MyTransformer")) {
      return null;
    }

    if (!className.startsWith("url/genchi/spring")) {
      return classfileBuffer;
    }

    try {
      CtClass ct = cp.makeClass(new ByteArrayInputStream(classfileBuffer));

      CtMethod[] declaredMethods = ct.getDeclaredMethods();
      for (CtMethod method : declaredMethods) {
          method.insertBefore(" { " +
                  "url.genchi.myagent.ExecuteTimeMeasurer.setStartTime();" +
                  "url.genchi.myagent.ExecuteTimeMeasurer.setSFunctionName(\"" + method.getName() +  "\");" +
                  "}");
          method.insertAfter("{ url.genchi.myagent.ExecuteTimeMeasurer.printMeasureTime(); }", true);
      }

      return ct.toBytecode();
    } catch (Throwable e) {
      e.printStackTrace();
    }

    return classfileBuffer;
  }
}
