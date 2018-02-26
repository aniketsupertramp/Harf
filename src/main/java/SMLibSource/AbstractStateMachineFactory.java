package SMLibSource;

public abstract class AbstractStateMachineFactory {
    State initialState;

    abstract StateMachine createStateMachine(Class<? extends State> stateClass, Class<? extends Event> eventClass, State initialState);

}
