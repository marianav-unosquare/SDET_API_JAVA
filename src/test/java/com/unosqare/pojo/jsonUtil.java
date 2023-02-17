package com.unosqare.pojo;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Reader;

import com.github.cliftonlabs.json_simple.JsonException;
import com.github.cliftonlabs.json_simple.JsonObject;
import com.github.cliftonlabs.json_simple.Jsoner;

import utils.Constants;

public class jsonUtil {

	public static void createJsonFile(Object data, String fileName) throws Exception {
		FileWriter fileWriter = new FileWriter(Constants.FILES_PATH + fileName);
		Jsoner.serialize(data, fileWriter);
	}

	public static String readJsonFile(String fileName) throws Exception {
		String jsonString = "";
		FileReader fileReader = new FileReader(Constants.FILES_PATH + fileName);
		System.out.println(fileReader);
		jsonString = ((JsonObject) Jsoner.deserialize(fileReader)).toJson();
		return jsonString;
	}

}
