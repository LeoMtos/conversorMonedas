package model.dto;
import java.util.Map;
public record Divisa(String base_code, String time_last_update_utc, Map<String,Double> converion_rates) {
}
