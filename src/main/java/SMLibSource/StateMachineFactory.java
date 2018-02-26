package SMLibSource;

public class StateMachineFactory extends AbstractStateMachineFactory {
    public StateMachine createStateMachine(Class<? extends State> stateClass, Class<? extends Event> eventClass, State initialState) {
        this.initialState = initialState;
        return new AbstractStateMachine(initialState);
    }
}
