package SMLibSource;

import java.util.*;

public class AbstractStateMachine implements StateMachine {
    State state;
    List<StateTransition> stateTransitions;

    public void setState(State state) {
        this.state = state;
    }

    private AbstractStateMachine() {

    }

    public AbstractStateMachine(State state) {
        stateTransitions = new ArrayList<>();
        this.state = state;
    }

    public State getCurrentState() {
        return state;
    }
    
    public StateTransition whenTransition(State fromState, Class<?> eventClass,State toState) {
        if (!Event.class.isAssignableFrom(eventClass))
            throw new RuntimeException("eventClass must implement interface Event");
        Set<Event> events = new HashSet<>((Collection<? extends Event>) Arrays.asList(eventClass.getEnumConstants()));
        StateTransition stateTransition = new StateTransitionImpl(fromState, events,toState);
        this.stateTransitions.add(stateTransition);
        return stateTransition;
    }

    public StateTransition whenTransition(State fromState, Event event,State toState) {
        StateTransition stateTransition = new StateTransitionImpl(fromState, event,toState);
        this.stateTransitions.add(stateTransition);
        return stateTransition;
    }

    public StateTransition whenTransition(State fromState, List<? extends Event> events,State toState) {
        StateTransition stateTransition = new StateTransitionImpl(fromState, new HashSet<>(events),toState);
        this.stateTransitions.add(stateTransition);
        return stateTransition;
    }

    public void notify(Event event) {
        SMMethodInvoker smMethodInvoker = new SMMethodInvokerImpl();
        for (StateTransition stateTransition : stateTransitions) {
            if (stateTransition.getEvents().contains(event) && this.getCurrentState().equals(stateTransition.getFromState())) {
                smMethodInvoker.inVokeMethod(stateTransition.getMethodToCall(), this);
                this.setState(stateTransition.getToState());
            }
        }
    }

    public void displayStateMachine(){
        for(StateTransition stateTransition:stateTransitions){
            printStateTransition(stateTransition);
        }
    }

    private void printStateTransition(StateTransition stateTransition){
        String stateTransitionEventString = Arrays.toString(new Set[]{stateTransition.getEvents()});
      System.out.println(stateTransition.getFromState()+"--"+ stateTransitionEventString.replaceAll("\\[|\\]","")+"-->"+stateTransition.getToState());
    }
}
