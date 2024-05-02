package com.example.httpclienttest.dto.external;

import com.fasterxml.jackson.annotation.JsonProperty;
import java.time.LocalDateTime;
import lombok.Data;

@Data
public class CurrencyMetaDataDto {
    @JsonProperty("last_updated_at")
    private LocalDateTime lastUpdatedAt;
}
