package SMLibSource;

public interface SMMethodInvoker {
    <T> T inVokeMethod(String methodToCall, StateMachine abstractStateMachine);
}
