# Harf
Harf- An Easy to use State Machine Library.
Harf حرف is an urdu word meaning A character so,to use  my State Machine Library is as simple as that.

Steps to use it. (The FSM class is the state machine class that uses my library .You can go though it for reference)

1.) Declare 2 Enums, first ,States which must implement State and secondly, Events which must implement Event

2.)FSM extends the AbstractStateMachine class

3.)It needs to have constructor like

      FSM(State state) {
           super(state); /**Need to define this constructor with parent class constructor being called*/
       }
    
   You can write a diffrent more parameterized constructor iof FSM , but always remember to call super(state) in it.

4.) to create and intialize State Machine , 

     FSM fsm = new FSM(States.A); //the parameter is the initial state that needs to be passed
 
5.)  To define the transition rules for yopur state machine

        (i) fsm.whenTransition(States.A, Events.E1, States.B).callMethod("processEventE1", FSM.class);
        
   In above rule, whenTransition is taking 3 arguments :
        fromState, Event and toState
        
        
        (ii) fsm.whenTransition(States.B, Arrays.asList(Events.E1, Events.E3), States.C).callMethod("processEventE2", FSM.class);
        
   In above rule, whenTransition is taking 3 arguments :
        fromState, list of Events and toState
        
       (iii) fsm.whenTransition(States.C, Events.class, States.A).callMethod("processEventE3", FSM.class);
       
   In above rule, whenTransition is taking 3 arguments :
        fromState, Event class and toState.
        
   passing Event class in above will indicate transition will happen from "fromState" to "toState" , no matter whihc event occurs.
  
 6.)   call below method to notify if a event occurs
  
        fsm.notify(Events.E1);
  
 7.)     To display current state machine structure, 
  
        fsm.displayStateMachine();  /**it shows like a linked list impl of a graph*/

 
