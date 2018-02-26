package SMLibSource;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class SMMethodInvokerImpl implements SMMethodInvoker {

    @Override
    public <T> T inVokeMethod(String methodToCall, StateMachine stateMachine) {
        Method method = findMethod(methodToCall, stateMachine);
        if (method == null)
            throw new RuntimeException("No such method found: " + methodToCall);
        T returnVal = null;
        try {
            returnVal = (T) method.invoke(stateMachine);
        } catch (IllegalAccessException | InvocationTargetException e) {
            throw new RuntimeException("Excetion: " + e.getCause());
        }
        return returnVal;
    }

    private Method findMethod(String methodToCall, StateMachine stateMachine) {
        Method[] methods = stateMachine.getClass().getDeclaredMethods();
        for (Method method : methods) {
            if (method.getName().contains(methodToCall))
                return method;
        }
        return null;
    }
}
