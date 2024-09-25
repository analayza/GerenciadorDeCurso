package domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.List;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity
@NamedQueries(
        @NamedQuery(name = "curso.getAll", query = "select c from Curso c")
)
public class Curso {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long Id;
    private String titulo;
    private BigDecimal valor;

    @ManyToMany(cascade = CascadeType.ALL)
    private List<Usuario> usuario;

    @OneToMany(cascade = CascadeType.ALL)
    private List<Modulo> modulo;

}
