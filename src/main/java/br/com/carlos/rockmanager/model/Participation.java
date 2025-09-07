package br.com.carlos.rockmanager.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.IdClass;
import jakarta.persistence.Table;
import lombok.*;

@Entity
@Table(name = "participacao")
@IdClass(Participation.ParticipationId.class)
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Participation {

    @Id
    private int id_banda;
    @Id
    private int id_show;
    private int ordem_apresentacao;
    private int tempo_execucao_min;

    @Getter
    @Setter
    public static class ParticipationId implements java.io.Serializable {

        private int id_banda;
        private int id_show;


        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            ParticipationId  that = (ParticipationId ) o;
            return id_banda == that.id_banda && id_show == that.id_show;
        }

        @Override
        public int hashCode() {
            return java.util.Objects.hash(id_banda, id_show);
        }
    }

}
