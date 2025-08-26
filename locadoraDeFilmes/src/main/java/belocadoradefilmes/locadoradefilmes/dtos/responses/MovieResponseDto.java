package belocadoradefilmes.locadoradefilmes.dtos.responses;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class MovieResponseDto
{
    private Long id;
    private String title;
    private String genre;
    private int year;
    private int rating;
}
