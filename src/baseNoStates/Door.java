package baseNoStates;

import baseNoStates.requests.RequestReader;
import org.json.JSONObject;


public class Door {
  private final String id;
  private boolean closed;
  private DoorState state;

  public Door(String id) {
    this.id = id;
    closed = true;
    state = new DoorUnlocked(this);
  }

  public void setState(DoorState dS) {
      state = dS;
  }

  public void processRequest(RequestReader request) {
    // it is the Door that process the request because the door has and knows
    // its state, and if closed or open
    if (request.isAuthorized()) {
      String action = request.getAction();

      if (!state.changeState(action))
          System.out.println("Acció no vàlida en aquest estat");
    } else {
      System.out.println("not authorized");
    }
    request.setDoorStateName(getStateName());
  }
/*
  private void doAction(String action) {
    switch (action) {
      case Actions.OPEN:
        if (closed) {
          closed = false;
        } else {
          System.out.println("Can't open door " + id + " because it's already open");
        }
        break;
      case Actions.CLOSE:
        if (closed) {
          System.out.println("Can't close door " + id + " because it's already closed");
        } else {
          closed = true;
        }
        break;
      case Actions.LOCK:
        // TODO
        // fall through
      case Actions.UNLOCK:
        // TODO
        // fall through
      case Actions.UNLOCK_SHORTLY:
        // TODO
        System.out.println("Action " + action + " not implemented yet");
        break;
      default:
        assert false : "Unknown action " + action;
        System.exit(-1);
    }
  }
*/
  public boolean isClosed() {
    return closed;
  }

  public void open() {
      closed = false;
  }

  public void close() {
      closed = true;
  }

  public String getId() {
    return id;
  }

  public String getStateName() {
    return state.getStateName();
  }

  @Override
  public String toString() {
    return "Door{"
        + ", id='" + id + '\''
        + ", closed=" + closed
        + ", state=" + getStateName()
        + "}";
  }

  public JSONObject toJson() {
    JSONObject json = new JSONObject();
    json.put("id", id);
    json.put("state", getStateName());
    json.put("closed", closed);
    return json;
  }
}
