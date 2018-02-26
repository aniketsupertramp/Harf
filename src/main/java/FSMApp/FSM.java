package FSMApp;

import SMLibSource.*;
import java.util.Arrays;

enum States implements State {
    A, B, C;
}

enum Events implements Event {
    E1, E2, E3;
}

public class FSM extends AbstractStateMachine {

    FSM(State state) {
        super(state); /**Need to define this constructor with parent class constructor being called*/
    }

    public void processEventE1() {
        if (this.getCurrentState().equals(States.A)) {
            System.out.println("Processed event E1: current state (special) " + this.getCurrentState());
        } else {
            System.out.println("Processed event E1: current state " + this.getCurrentState());
        }
    }

    public void processEventE2() {
        System.out.println("Processed event E2: current state " + this.getCurrentState());
    }

    public void processEventE3() {
        System.out.println("Processed event E3: current state " + this.getCurrentState());
    }

    public static void main(String[] args) {
        FSM fsm = new FSM(States.A); /**Create State Machine with initial State*/

        System.out.print(fsm.getCurrentState()); /**to print current state*/

        /** these define trnasition rules for the state machine FSSM*/
        fsm.whenTransition(States.A, Events.E1, States.B).callMethod("processEventE1", FSM.class);
        fsm.whenTransition(States.B, Arrays.asList(Events.E1, Events.E3), States.C).callMethod("processEventE2", FSM.class);
        fsm.whenTransition(States.C, Events.class, States.A).callMethod("processEventE3", FSM.class);

        /**method to notify if a event occurs*/
        fsm.notify(Events.E1);

         /**to display state machine structure, it shows like a linked list impl of a graph*/
        fsm.displayStateMachine();

    }

}
