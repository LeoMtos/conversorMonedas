package model.mapper;

import com.google.gson.Gson;
import com.google.gson.JsonSyntaxException;
import exception.JsonConversionException;
import model.dto.DivisaDto;

public class ConverteToJson {
    private Gson gson = new Gson();
    private DivisaDto divisaDto;

    public void convertToJson(String json) {
        try {
            this.divisaDto = gson.fromJson(json, DivisaDto.class);
        } catch (JsonSyntaxException e) {
            throw new JsonConversionException("Error al convertir JSON a objeto DivisaDto");
        }
    }

    public DivisaDto getDivisaDto() {
        return divisaDto;
    }
}
