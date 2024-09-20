package domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Curso {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long Id;
    private String titulo;

    @ManyToMany(cascade = CascadeType.ALL)
    private Usuario usuario;

    @OneToMany(cascade = CascadeType.ALL)
    private List<Modulo> modulo;

}
