package belocadoradefilmes.locadoradefilmes.entities;


import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.*;

@Getter
@Setter
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "movies")
public class Movie
{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    @Setter(AccessLevel.NONE)
    private Long id;

    @NotBlank
    @Column(name = "title", nullable = false, length = 127)
    private String title;

    @NotBlank
    @Column(name = "genre", nullable = false, length = 63)
    private String genre;

    @NotNull
    @Column(name = "year", nullable = false, length = 4)
    private int year;

    @NotNull
    @Column(name = "rating", length = 2)
    private int rating;



}
