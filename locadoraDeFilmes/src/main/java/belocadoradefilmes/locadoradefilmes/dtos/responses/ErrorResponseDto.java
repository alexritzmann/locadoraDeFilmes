package belocadoradefilmes.locadoradefilmes.dtos.responses;

import lombok.Builder;

import java.util.List;

@Builder
public record ErrorResponseDto(

    String code,
    String message,
    String cause,
    String exceptionClassName,
    List<String> errors
)
{

}
