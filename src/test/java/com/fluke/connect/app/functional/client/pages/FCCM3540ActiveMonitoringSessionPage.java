package com.fluke.connect.app.functional.client.pages;

import static io.restassured.RestAssured.*;

public class FCCM3540ActiveMonitoringSessionPage 
{
	
	public FCCM3540ActiveMonitoringSessionPage()
	{
		
	}
	
	public void startRemoteMonitoringSessionThroughWebServices()
	{
		given().
		headers("Content-Type", "application/json", "Authenticate", "eyJ1c2VyQWNjb3VudElkIjoiOTkyNWVjMTItM2I1Yy00MzMwLTk4NjktMjI5MzY5ODYzZWMxIiwiZXhwaXJlcyI6MTUyMDY4MDk3MTkwNiwic2lnbmF0dXJlIjoidTFXVDM4bkxMck1UcWhjS3QwMzlWbjJOOGpYdzdtWXRvS2lnMW1EbHBuaz0ifQ==").
		body("{" + 
				" \"gatewayId\": \"100d4bb6-8e41-41e7-aa5a-ef4nctest117\",\n" + 
				" \"instrumentName\": \"FC 3540\",\n" + 
				" \"gatewayDesc\": \"Fluke 3540 FC\",\n" + 
				" \"organizationId\": \"04ffb990-d434-0135-45ad-0277a8d9ab38\",\n" + 
				" \"sessionId\": \"04ffb990-d434-0135-45ad-0277a8d9ab96\",\n" + 
				" \"adminDesc\": \"\",\n" + 
				" \"sessionType\": 1,\n" + 
				" \"sessionStartTime\":1520595195421,\n" + 
				" \"sessionEndTime\": 0,\n" + 
				" \"startRequestorId\": \"9925ec12-3b5c-4330-9869-229369863ec1\",\n" + 
				" \"modelName\": \"Fluke3540FC\",\n" + 
				" \"studyType\": \"1\",\n" + 
				" \"topology\": \"1\",\n" + 
				" \"viewVisualLight\": false,\n" + 
				" \"samplingRate\": 0,\n" + 
				" \"measurementUnit\": \"\",\n" + 
				" \"objectStatusId\": \"5BBB9C16-BC4F-11E2-9678-15B654818C3B\",\n" + 
				" \"sensors\": [\n" + 
				"   {\n" + 
				"     \"sensorId\": \"8e968512-7b03-401d-a552-3c983274579a\",\n" + 
				"     \"adminDesc\": \"Fluke3540FC\",\n" + 
				"     \"model\": \"Fluke3540FC\",\n" + 
				"     \"assetId\": \"85a1af83-0f45-46e9-bd3e-f58df905a070\",\n" + 
				"     \"createdDate\":1520595195421,\n" + 
				"     \"instrumentId\":\"200d4bb6-8e41-41e7-aa5a-ef4nctest116\"\n" + 
				"   }\n" + 
				" ],\n" + 
				" \"operationMode\": \"performance\"\n" + 
				"}").
		when().
		put("/iot-service/session").
		then().assertThat().statusCode(200);
	}
	
	public void addDataToActiveSessionThroughWebServices()
	{
		given().
		header("Authenticate", "eyJ1c2VyQWNjb3VudElkIjoiOTkyNWVjMTItM2I1Yy00MzMwLTk4NjktMjI5MzY5ODYzZWMxIiwiZXhwaXJlcyI6MTUyMDY4MDk3MTkwNiwic2lnbmF0dXJlIjoidTFXVDM4bkxMck1UcWhjS3QwMzlWbjJOOGpYdzdtWXRvS2lnMW1EbHBuaz0ifQ==").
		header("Content-Type", "application/json").
		body("{\n" + 
				"    \"asset_id\": \"85a1af83-0f45-46e9-bd3e-f58df905a070\",\n" + 
				"    \"capture_time\": 1520596371311,\n" + 
				"    \"session_id\": \"04ffb990-d434-0135-45ad-0277a8d9ab96\",\n" + 
				"    \"time_zone\": \"UTC+5:30\",\n" + 
				"    \"timed_data\": [\n" + 
				"      {\n" + 
				"        \"time\": 1520596371311,\n" + 
				"        \"typed_values\": [\n" + 
				"          {\n" + 
				"            \"name\": \"Voltage\",\n" + 
				"            \"unit\": \"V\",\n" + 
				"            \"values\": [\n" + 
				"              {\n" + 
				"                \"channel\": \"A\",\n" + 
				"                \"prefix\": 0,\n" + 
				"                \"prefixed_precision\": 1,\n" + 
				"                \"value\": 210.123\n" + 
				"              },\n" + 
				"              {\n" + 
				"                \"channel\": \"B\",\n" + 
				"                \"prefix\": 0,\n" + 
				"                \"prefixed_precision\": 1,\n" + 
				"                \"value\": 198.61\n" + 
				"              },\n" + 
				"              {\n" + 
				"                \"channel\": \"C\",\n" + 
				"                \"prefix\": 0,\n" + 
				"                \"prefixed_precision\": 1,\n" + 
				"                \"value\": 272.188\n" + 
				"              }\n" + 
				"            ]\n" + 
				"          },\n" + 
				"          {\n" + 
				"            \"name\": \"Current\",\n" + 
				"            \"unit\": \"A\",\n" + 
				"            \"values\": [\n" + 
				"              {\n" + 
				"                \"channel\": \"A\",\n" + 
				"                \"prefix\": 0,\n" + 
				"                \"prefixed_precision\": 2,\n" + 
				"                \"value\": 11.0145\n" + 
				"              },\n" + 
				"              {\n" + 
				"                \"channel\": \"B\",\n" + 
				"                \"prefix\": 0,\n" + 
				"                \"prefixed_precision\": 2,\n" + 
				"                \"value\": 7.27304\n" + 
				"              },\n" + 
				"              {\n" + 
				"                \"channel\": \"C\",\n" + 
				"                \"prefix\": 0,\n" + 
				"                \"prefixed_precision\": 2,\n" + 
				"                \"value\": 9.95267\n" + 
				"              }\n" + 
				"            ]\n" + 
				"          },\n" + 
				"          {\n" + 
				"            \"name\": \"Frequency\",\n" + 
				"            \"unit\": \"Hz\",\n" + 
				"            \"values\": [\n" + 
				"              {\n" + 
				"                \"channel\": \"Freq\",\n" + 
				"                \"prefix\": 0,\n" + 
				"                \"prefixed_precision\": 2,\n" + 
				"                \"value\": 50.0299\n" + 
				"              }\n" + 
				"            ]\n" + 
				"          },\n" + 
				"          {\n" + 
				"            \"name\": \"Active Power\",\n" + 
				"            \"unit\": \"W\",\n" + 
				"            \"values\": [\n" + 
				"              {\n" + 
				"                \"channel\": \"A\",\n" + 
				"                \"prefix\": 3,\n" + 
				"                \"prefixed_precision\": 2,\n" + 
				"                \"value\": 73.2445\n" + 
				"              },\n" + 
				"              {\n" + 
				"                \"channel\": \"B\",\n" + 
				"                \"prefix\": 3,\n" + 
				"                \"prefixed_precision\": 2,\n" + 
				"                \"value\": 583.13\n" + 
				"              },\n" + 
				"              {\n" + 
				"                \"channel\": \"C\",\n" + 
				"                \"prefix\": 3,\n" + 
				"                \"prefixed_precision\": 2,\n" + 
				"                \"value\": 671.922\n" + 
				"              },\n" + 
				"              {\n" + 
				"                \"channel\": \"Total\",\n" + 
				"                \"prefix\": 3,\n" + 
				"                \"prefixed_precision\": 2,\n" + 
				"                \"value\": 1328.29\n" + 
				"              }\n" + 
				"            ]\n" + 
				"          },\n" + 
				"          {\n" + 
				"            \"name\": \"Apparent Power\",\n" + 
				"            \"unit\": \"VA\",\n" + 
				"            \"values\": [\n" + 
				"              {\n" + 
				"                \"channel\": \"A\",\n" + 
				"                \"prefix\": 3,\n" + 
				"                \"prefixed_precision\": 2,\n" + 
				"                \"value\": 1992.51\n" + 
				"              },\n" + 
				"              {\n" + 
				"                \"channel\": \"B\",\n" + 
				"                \"prefix\": 3,\n" + 
				"                \"prefixed_precision\": 2,\n" + 
				"                \"value\": 1444.5\n" + 
				"              },\n" + 
				"              {\n" + 
				"                \"channel\": \"C\",\n" + 
				"                \"prefix\": 3,\n" + 
				"                \"prefixed_precision\": 2,\n" + 
				"                \"value\": 2709\n" + 
				"              },\n" + 
				"              {\n" + 
				"                \"channel\": \"Total\",\n" + 
				"                \"prefix\": 3,\n" + 
				"                \"prefixed_precision\": 2,\n" + 
				"                \"value\": 9883.56\n" + 
				"              }\n" + 
				"            ]\n" + 
				"          },\n" + 
				"          {\n" + 
				"            \"name\": \"Non-Active Power\",\n" + 
				"            \"unit\": \"var\",\n" + 
				"            \"values\": [\n" + 
				"              {\n" + 
				"                \"channel\": \"A\",\n" + 
				"                \"prefix\": 3,\n" + 
				"                \"prefixed_precision\": 2,\n" + 
				"                \"value\": 1991.16\n" + 
				"              },\n" + 
				"              {\n" + 
				"                \"channel\": \"B\",\n" + 
				"                \"prefix\": 3,\n" + 
				"                \"prefixed_precision\": 2,\n" + 
				"                \"value\": 1321.57\n" + 
				"              },\n" + 
				"              {\n" + 
				"                \"channel\": \"C\",\n" + 
				"                \"prefix\": 3,\n" + 
				"                \"prefixed_precision\": 2,\n" + 
				"                \"value\": 2624.35\n" + 
				"              },\n" + 
				"              {\n" + 
				"                \"channel\": \"Total\",\n" + 
				"                \"prefix\": 3,\n" + 
				"                \"prefixed_precision\": 2,\n" + 
				"                \"value\": 9812.65\n" + 
				"              }\n" + 
				"            ]\n" + 
				"          },\n" + 
				"          {\n" + 
				"            \"name\": \"Power Factor\",\n" + 
				"            \"values\": [\n" + 
				"              {\n" + 
				"                \"channel\": \"A\",\n" + 
				"                \"prefix\": 0,\n" + 
				"                \"prefixed_precision\": 2,\n" + 
				"                \"symbol\": \"ind\",\n" + 
				"                \"value\": 0.0367599\n" + 
				"              },\n" + 
				"              {\n" + 
				"                \"channel\": \"B\",\n" + 
				"                \"prefix\": 0,\n" + 
				"                \"prefixed_precision\": 2,\n" + 
				"                \"symbol\": \"cap\",\n" + 
				"                \"value\": 0.40369\n" + 
				"              },\n" + 
				"              {\n" + 
				"                \"channel\": \"C\",\n" + 
				"                \"prefix\": 0,\n" + 
				"                \"prefixed_precision\": 2,\n" + 
				"                \"symbol\": \"ind\",\n" + 
				"                \"value\": 0.248033\n" + 
				"              },\n" + 
				"              {\n" + 
				"                \"channel\": \"Total\",\n" + 
				"                \"prefix\": 0,\n" + 
				"                \"prefixed_precision\": 2,\n" + 
				"                \"symbol\": \"cap\",\n" + 
				"                \"value\": 0.119573\n" + 
				"              }\n" + 
				"            ]\n" + 
				"          },\n" + 
				"          {\n" + 
				"            \"name\": \"THD Voltage\",\n" + 
				"            \"unit\": \"%\",\n" + 
				"            \"values\": [\n" + 
				"              {\n" + 
				"                \"channel\": \"A\",\n" + 
				"                \"prefix\": 0,\n" + 
				"                \"prefixed_precision\": 1,\n" + 
				"                \"value\": 0.594684\n" + 
				"              },\n" + 
				"              {\n" + 
				"                \"channel\": \"B\",\n" + 
				"                \"prefix\": 0,\n" + 
				"                \"prefixed_precision\": 1,\n" + 
				"                \"value\": 0.656592\n" + 
				"              },\n" + 
				"              {\n" + 
				"                \"channel\": \"C\",\n" + 
				"                \"prefix\": 0,\n" + 
				"                \"prefixed_precision\": 1,\n" + 
				"                \"value\": 0.617546\n" + 
				"              }\n" + 
				"            ]\n" + 
				"          },\n" + 
				"          {\n" + 
				"            \"name\": \"THD Current\",\n" + 
				"            \"unit\": \"%\",\n" + 
				"            \"values\": [\n" + 
				"              {\n" + 
				"                \"channel\": \"A\",\n" + 
				"                \"prefix\": 0,\n" + 
				"                \"prefixed_precision\": 1,\n" + 
				"                \"value\": 43.913\n" + 
				"              },\n" + 
				"              {\n" + 
				"                \"channel\": \"B\",\n" + 
				"                \"prefix\": 0,\n" + 
				"                \"prefixed_precision\": 1,\n" + 
				"                \"value\": 88.2905\n" + 
				"              },\n" + 
				"              {\n" + 
				"                \"channel\": \"C\",\n" + 
				"                \"prefix\": 0,\n" + 
				"                \"prefixed_precision\": 1,\n" + 
				"                \"value\": 55.4189\n" + 
				"              }\n" + 
				"            ]\n" + 
				"          },\n" + 
				"          {\n" + 
				"            \"name\": \"Harmonic Content Current\",\n" + 
				"            \"unit\": \"A\",\n" + 
				"            \"values\": [\n" + 
				"              {\n" + 
				"                \"channel\": \"A\",\n" + 
				"                \"prefix\": 0,\n" + 
				"                \"prefixed_precision\": 2,\n" + 
				"                \"value\": 4.42765\n" + 
				"              },\n" + 
				"              {\n" + 
				"                \"channel\": \"B\",\n" + 
				"                \"prefix\": 0,\n" + 
				"                \"prefixed_precision\": 2,\n" + 
				"                \"value\": 4.81436\n" + 
				"              },\n" + 
				"              {\n" + 
				"                \"channel\": \"C\",\n" + 
				"                \"prefix\": 0,\n" + 
				"                \"prefixed_precision\": 2,\n" + 
				"                \"value\": 4.82401\n" + 
				"              }\n" + 
				"            ]\n" + 
				"          }\n" + 
				"        ]\n" + 
				"      }\n" + 
				"    ],\n" + 
				"    \"version\": 1\n" + 
				"}").
		when().
		post("/iot-service/simulate/sensor/fc3540_data").
		then().assertThat().statusCode(200);
	}
	
	public void endActiveSessionThroughWebServices()
	{
		given().
		header("Authenticate", "eyJ1c2VyQWNjb3VudElkIjoiOTkyNWVjMTItM2I1Yy00MzMwLTk4NjktMjI5MzY5ODYzZWMxIiwiZXhwaXJlcyI6MTUyMDY4MDk3MTkwNiwic2lnbmF0dXJlIjoidTFXVDM4bkxMck1UcWhjS3QwMzlWbjJOOGpYdzdtWXRvS2lnMW1EbHBuaz0ifQ==").
		header("Content-Type", "application/json").
		body("{\n" + 
				" \"sessionId\": \"04ffb990-d434-0135-45ad-0277a8d9ab96\",\n" + 
				" \"sessionEndTime\": 1520597064887,\n" + 
				" \"endRequestorId\": \"9925ec12-3b5c-4330-9869-229369863ec1\",\n" + 
				" \"objectStatusId\": \"5BBB9C16-BC4F-11E2-9678-15B654818C3B\",\n" + 
				" \"modelName\": \"PowerMonitor\"\n" + 
				"}").
		when().
		post("/iot-service/session/status").
		then().assertThat().statusCode(200);
	}

}
