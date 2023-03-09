package org.example.model.dto.request;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotNull;
import java.util.UUID;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class VoteRequestDto {
    @NotNull(message = "Field couldn't be null")
    private UUID user_id;
    @NotNull(message = "Field couldn't be null")
    private UUID quote_id;
}
