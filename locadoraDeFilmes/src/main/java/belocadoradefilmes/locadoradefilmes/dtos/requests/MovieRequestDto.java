package belocadoradefilmes.locadoradefilmes.dtos.requests;

import jakarta.validation.constraints.NotBlank;
import lombok.Data;
import jakarta.validation.constraints.*;
import org.hibernate.validator.constraints.Length;


@Data
public class MovieRequestDto
{
    @NotBlank(message = "Título do filme é obrigatório")
    @Size(min = 1, max = 127, message = "Título do filme deve ter entre 1 e 127 caracteres")
    private String title;

    @NotBlank(message = "Genero do filme é obrigatório")
    @Size(min = 1, max = 63, message = "Gênero do filme deve ter entre 1 e 63 caracteres")
    private String genre;

    @NotNull(message = "Ano do filme é obrigatório")
    @Min(value = 1888, message = "Ano do filme deve ser maior ou igual a 1888")
    @Max(value = 2025, message = "Ano do filme deve ser menor ou igual a 2025")
    //ou @Range(min = 1888, max = 2025, message = "Ano do filme deve estar entre 1888 e 2025")
    @Size(min = 4, max = 4, message = "Ano do filme deve ter 4 dígitos")
    private int year;


    @Min(value = 0, message = "Avaliação mínima do filme é 0")
    @Max(value = 10, message = "Avaliação máxima do filme é 10")
    //ou @Range(min = 0, max = 10, message = "Avaliação do filme deve estar entre 0 e 10")
    private int rating;


}
