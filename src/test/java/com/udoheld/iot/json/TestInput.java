/**
 * Parses input data from a simplified JSON SenML format into a Java object representation.
 *
 * @author Udo Held
 */

package com.udoheld.iot.json;

import com.google.gson.JsonSyntaxException;
import com.udoheld.iot.json.api.DataHolder;
import com.udoheld.iot.json.api.SensorData;
import org.junit.Test;

import static junit.framework.TestCase.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

/**
 * Testcases for JSON input parsing.
 * @author Udo Held
 */
public class TestInput {

  private String simpleJson = "{\"d\":[{\"bn\":\"urn:dev:mac:784b87a58c3d;temp1\",\"bt\":1485869189.215,\"n\":\"temp\",\"u\":\"Cel\",\"v\":27.9}],\"clientid\":\"edison-1\",\"timestamp\":1485869189339,\"topic\":\"iot/sensordata/prod/json\"}";
  private String listOfJson = "[{\"d\":[{\"bn\":\"urn:dev:mac:784b87a58c3d;temp1\",\"bt\":1485176050.051,\"n\":\"temp\",\"u\":\"Cel\",\"v\":27.6}],\"clientid\":\"edison-1\",\"timestamp\":1485176050097,\"topic\":\"iot/sensordata/prod/json\"},\n" +
      "{\"d\":[{\"bn\":\"urn:dev:mac:784b87a58c3d;temp1\",\"bt\":1485174849.051,\"n\":\"temp\",\"u\":\"Cel\",\"v\":27}],\"clientid\":\"edison-1\",\"timestamp\":1485174849132,\"topic\":\"iot/sensordata/prod/json\"},\n" +
      "{\"d\":[{\"bn\":\"urn:dev:mac:784b87a58c3d;temp1\",\"bt\":1485175449.531,\"n\":\"temp\",\"u\":\"Cel\",\"v\":27.2}],\"clientid\":\"edison-1\",\"timestamp\":1485175449597,\"topic\":\"iot/sensordata/prod/json\"},\n" +
      "{\"d\":[{\"bn\":\"urn:dev:mac:784b87a58c3d;temp1\",\"bt\":1485176950.771,\"n\":\"temp\",\"u\":\"Cel\",\"v\":28.1}],\"clientid\":\"edison-1\",\"timestamp\":1485176950820,\"topic\":\"iot/sensordata/prod/json\"},\n" +
      "{\"d\":[{\"bn\":\"urn:dev:mac:784b87a58c3d;temp1\",\"bt\":1485175749.771,\"n\":\"temp\",\"u\":\"Cel\",\"v\":27.5}],\"clientid\":\"edison-1\",\"timestamp\":1485175749814,\"topic\":\"iot/sensordata/prod/json\"},\n" +
      "{\"d\":[{\"bn\":\"urn:dev:mac:784b87a58c3d;temp1\",\"bt\":1485176350.292,\"n\":\"temp\",\"u\":\"Cel\",\"v\":27.8}],\"clientid\":\"edison-1\",\"timestamp\":1485176350342,\"topic\":\"iot/sensordata/prod/json\"},\n" +
      "{\"d\":[{\"bn\":\"urn:dev:mac:784b87a58c3d;temp1\",\"bt\":1485176650.531,\"n\":\"temp\",\"u\":\"Cel\",\"v\":27.8}],\"clientid\":\"edison-1\",\"timestamp\":1485176650569,\"topic\":\"iot/sensordata/prod/json\"},\n" +
      "{\"d\":[{\"bn\":\"urn:dev:mac:784b87a58c3d;temp1\",\"bt\":1485175149.291,\"n\":\"temp\",\"u\":\"Cel\",\"v\":27.5}],\"clientid\":\"edison-1\",\"timestamp\":1485175149349,\"topic\":\"iot/sensordata/prod/json\"},\n" +
      "{\"d\":[{\"bn\":\"urn:dev:mac:784b87a58c3d;temp1\",\"bt\":1485174548.793,\"n\":\"temp\",\"u\":\"Cel\",\"v\":27.3}],\"clientid\":\"edison-1\",\"timestamp\":1485174548893,\"topic\":\"iot/sensordata/prod/json\"}]";

  @Test
  public void testEmptyInput(){
    InputParser inputParser = new InputParser();
    SensorData [] sensorData = inputParser.parseInput("");
    assertNotNull(sensorData);
    assertEquals("Array should be empty",0,sensorData.length);

    sensorData = inputParser.parseInput(null);
    assertNotNull(sensorData);
    assertEquals("Array should be empty",0,sensorData.length);
  }

  @Test(expected = JsonSyntaxException.class)
  public void testInvalidInput(){
    InputParser inputParser = new InputParser();
    SensorData [] sensorData = inputParser.parseInput("abc");
  }

  @Test
  public void readSimpleJson() {
    InputParser inputParser = new InputParser();
    SensorData [] sensorData = inputParser.parseInput(simpleJson);

    assertNotNull(sensorData);
    assertEquals("Array should contain one element",1,sensorData.length);

    assertNotNull(sensorData[0]);
    assertTrue(sensorData[0].getData().length > 0);
    assertEquals("edison-1",sensorData[0].getClient());
    assertEquals("iot/sensordata/prod/json",sensorData[0].getMqttTopic());
    assertEquals(1485869189339l, sensorData[0].getTransferTimeStamp().longValue());

    DataHolder firstDataEntry = sensorData[0].getData()[0];
    assertEquals("urn:dev:mac:784b87a58c3d;temp1",firstDataEntry.getBaseName());
    assertEquals(1485869189.215, firstDataEntry.getBaseTimeStamp());
    assertEquals("temp",firstDataEntry.getName());
    assertEquals("Cel",firstDataEntry.getUnit());
    assertEquals(27.9,firstDataEntry.getValue());
  }


  @Test
  public void readListOfJson() {
    InputParser inputParser = new InputParser();
    SensorData [] sensorData = inputParser.parseInput(listOfJson);

    assertNotNull(sensorData);
    assertTrue(sensorData.length == 9);
  }
}
