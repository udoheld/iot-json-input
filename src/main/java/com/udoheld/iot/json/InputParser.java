/**
 * This object contains the meta data and holds the data.
 *
 * @author Udo Held
 */

package com.udoheld.iot.json;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import com.udoheld.iot.json.api.SensorData;

/**
 * Parses input data from a simplified JSON SenML format into a Java object representation.
 *
 * @author Udo Held
 */
public class InputParser {

  /**
   * Parses the JSON input.
   * @param input input in JSON format. If it starts with a "[" it will be parsed as an array
   *              otherwise a single record is assumed.
   * @return An array of the parsed objects.
   */
  public SensorData [] parseInput(String input) {
    if (input == null || input.isEmpty()) {
      return new SensorData[]{};
    } else if (input.startsWith("[")) {
      return parseArrayInput(input);
    } else {
      return parseSingleInput(input);
    }
  }

  private SensorData [] parseSingleInput(String input) {
    GsonBuilder builder = new GsonBuilder();
    Gson gson = builder.create();

    SensorData sensorData = gson.fromJson(input, SensorData.class);

    return new SensorData[] { sensorData };

  }

  private SensorData [] parseArrayInput(String input) {
    GsonBuilder builder = new GsonBuilder();
    Gson gson = builder.create();

    SensorData [] sensorData = gson.fromJson(input, SensorData[].class);
    return sensorData;
  }
}
