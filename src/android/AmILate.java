package co.fancyrabbit.AmILate;

import org.apache.cordova.CordovaPlugin;
import org.apache.cordova.CallbackContext;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/**
 * This class echoes a string called from JavaScript.
 */
public class AmILate extends CordovaPlugin {

    @Override
    public boolean execute(String action, JSONArray args, CallbackContext callbackContext) throws JSONException {
        if (action.equals("getNextAppointment")) {
            int minutes = args.getInt(0);
            this.getNextAppointment(minutes, callbackContext);
            return true;
        }
        return false;
    }

    private void getNextAppointment(int minutes, CallbackContext callbackContext) {
        if (minutes > 0) {
            /**
                Code to retrieve name, time of next appointment goes here
            **/
            boolean foundAppointment = true;
            String appointmentTitle = "Android Test";
            String appointmentDate = "Right now!";

            if (foundAppointment) {
                JSONObject returnObject = new JSONObject();
                returnObject.put("title", appointmentTitle);
                returnObject.put("date", appointmentDate);
                callbackContext.success(returnObject);
            } else {
                // If no appointment was found, return an empty string.
                // Note that we used success() rather than error(), since
                // no finding an appointment is perfectly valid. Error
                // conditions should be reserved for situations where
                // the plugin was unable to complete its task at all.
                callbackContext.success("");
            }
        } else {
            callbackContext.error("minutes must be > 0");
        }
    }
}
