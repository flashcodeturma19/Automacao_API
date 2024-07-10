package Metodos;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.File;
import java.io.IOException;

public class Leitorjson {

	//caminho da pasta do Json
	private static final String BASE_PATH = "src/test/resources/json/";

	public JsonNode readJsonFile(String fileName) {
		ObjectMapper objectMapper = new ObjectMapper();
		try {
			File file = new File(BASE_PATH + fileName);
			if (!file.exists()) {
				throw new IOException("Arquivo não encontrado: " + file.getAbsolutePath());
			}
			return objectMapper.readTree(file);
		} catch (IOException e) {
			e.printStackTrace();
			return null;
		}
	}

	public String getStringValue(JsonNode jsonNode, String key) {
		return jsonNode.path(key).asText();
	}

	public int getIntValue(JsonNode jsonNode, String key) {
		return jsonNode.path(key).asInt();
	}

	public boolean getBooleanValue(JsonNode jsonNode, String key) {
		return jsonNode.path(key).asBoolean();
	}
}
