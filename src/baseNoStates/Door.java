package baseNoStates;

import baseNoStates.DoorStates.DoorUnlocked;
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
      doAction(action);
    } else {
      System.out.println("not authorized");
    }
    request.setDoorStateName(getStateName());
  }

  private void doAction(String action) {
    switch (action) {
      case Actions.OPEN:
          state.open();
        break;
      case Actions.CLOSE:
          state.close();
        break;
      case Actions.LOCK:
          state.lock();
        break;
      case Actions.UNLOCK:
          state.unlock();
        break;
      case Actions.UNLOCK_SHORTLY:
          state.unlock_shortly();
        break;
      default:
        assert false : "Unknown action " + action;
        System.exit(-1);
    }
  }

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
