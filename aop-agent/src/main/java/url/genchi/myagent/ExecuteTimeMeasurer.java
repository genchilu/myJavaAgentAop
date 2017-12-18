package url.genchi.myagent;

public class ExecuteTimeMeasurer {
    public static ThreadLocal<Long> startTime = new ThreadLocal<Long>();
    public static ThreadLocal<String> functionName = new ThreadLocal<String>();

    public static void setStartTime(){
        startTime.set(System.currentTimeMillis());
    }

    public static void setSFunctionName(String funName){
        functionName.set(funName);
    }

    public static void printMeasureTime() {
        String funName = functionName.get();
        long executeTime = System.currentTimeMillis() - startTime.get();
        String msg = String.format("Function: %s's execute time is: %d", funName, executeTime);
        System.out.println(msg);
    }
}
