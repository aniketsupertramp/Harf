package SMLibSource;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class StateTransitionImpl implements StateTransition {
    State fromState;
    State toState;
    Set<Event> events;
    String methodToCall;
    Class<? extends AbstractStateMachine> stateMachineClass;

    public Class<? extends AbstractStateMachine> getStateMachineClass() {
        return stateMachineClass;
    }

    public String getMethodToCall() {
        return methodToCall;
    }

    public StateTransitionImpl() {
        super();
    }

    public StateTransitionImpl(State fromState, Set<Event> events,State toState) {
        this.fromState = fromState;
        this.events = events;
        this.toState = toState;
    }

    public StateTransitionImpl(State fromState, Event event,State toState) {
        this.fromState = fromState;
        this.events = new HashSet<>(Arrays.asList(event));
        this.toState = toState;
    }

    public State getFromState() {
        return fromState;
    }

    public State getToState() {
        return toState;
    }

    public Set<Event> getEvents() {
        return events;
    }


    public void callMethod(String methodToCall, Class<? extends AbstractStateMachine> methodClass) {
        this.methodToCall = methodToCall;
        this.stateMachineClass = methodClass;
    }
}
