package SMLibSource;

import java.util.List;

public interface StateMachine {
    State getCurrentState();

    StateTransition whenTransition(State fromState, Class<?> eventClass,State toState);

    StateTransition whenTransition(State fromState, Event event,State toState);

    StateTransition whenTransition(State fromState, List<? extends Event> events,State toState);
}
