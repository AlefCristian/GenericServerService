package util.json;

import org.json.JSONException;
import org.json.JSONObject;

import java.math.BigDecimal;

/**
 * Created by alef on 21/11/16.
 */

public class JsonBuilder {
    JSONObject object;

    public JsonBuilder() {
        object = new JSONObject();
    }
    public JsonBuilder put(String nome, String value) {
        try {
            object.put(nome, value);
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return this;
    }

    public JsonBuilder put(String nome, int value) {
        try {
            object.put(nome, value);
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return this;
    }
    
    public JsonBuilder put(String nome, boolean result) {
    	try {
    		object.put(nome, result);
		} catch (JSONException e) {
			e.printStackTrace();
		}
    	return this;
    }

    public JsonBuilder put(String nome, BigDecimal value) {
        try {
            object.put(nome, value);
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return this;
    }   

    public JSONObject builder() {
        return this.object;
    }
}
