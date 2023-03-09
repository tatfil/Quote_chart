package org.example.model.dto.request;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.example.model.entity.User;

import javax.validation.constraints.NotNull;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class QuoteRequestDto {
    @NotNull(message = "Field couldn't be null")
    private String text;
    @NotNull(message = "Field couldn't be null")
    private User postedBy;

    private Integer rating;

}
