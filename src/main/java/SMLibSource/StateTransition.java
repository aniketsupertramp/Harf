package SMLibSource;

import java.util.Set;

public interface StateTransition {


    String getMethodToCall();

    State getFromState();

    State getToState();

    Set<Event> getEvents();

    void callMethod(String methodToCall, Class<? extends AbstractStateMachine> methodClass);

}
