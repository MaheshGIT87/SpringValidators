/**
 * 
 */
package com.fidelity.aws.util;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.HashMap;
import java.util.Map;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

/**
 * @author kiran
 *
 */
public class JSONReader {
	
	private static Map<String, Object> dmSchemas = new HashMap<String, Object>();
	
	static {
		JSONParser parser = new JSONParser();
		try {
			Object object = parser.parse(new FileReader(JSONReader.class.getClassLoader().getResource("appDeviceManagerConfig.json").getFile()));

			// convert Object to JSONObject
			JSONObject jsonObject = (JSONObject) object;

			// Reading the array
			JSONArray schemas = (JSONArray) jsonObject.get("dm_schema");

			// Printing all the values
			for (Object schema : schemas) {
				JSONObject schemaObject  =  (JSONObject)schema;
				Map<String, Object> dmSchema = new HashMap<String, Object>();
				dmSchema.put("schema", schemaObject.get("schema"));
				dmSchema.put("url", schemaObject.get("url"));
				dmSchema.put("user", schemaObject.get("user"));
				dmSchema.put("password", schemaObject.get("password"));
				dmSchema.put("displayName", schemaObject.get("displayName"));
				
				dmSchemas.put((String)schemaObject.get("schema"), dmSchema);
			}
		} catch (FileNotFoundException fe) {
			fe.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	@SuppressWarnings({ "unchecked" })
	public Map<String, Object> getSchemaDetails(String schemaName) {
		if(!dmSchemas.isEmpty() && dmSchemas.get(schemaName) != null) {
			return (Map<String, Object>) dmSchemas.get(schemaName);
		}
		return null;
	}
	
	/**
	 * 
	 * @param args
	 */
	public static void main(String args[]) {
//		System.out.println(getSchemaDetails("dm_emeapilot"));
	}
}
