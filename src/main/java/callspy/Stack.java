package callspy;

@SuppressWarnings("unused")
public class Stack {

  static String indent = "";

  public static void push() {
    System.out.println("before push indent is " + indent);
    indent += "@";
    System.out.println("after push indent is " + indent);
  }

  public static void pop() {
    System.out.println("before pop indent is " + indent);
    indent = indent.substring(1);
    System.out.println("after pop indent is " + indent);
  }

  public static void log(String string){
    System.out.println(indent + string);
  }

}
