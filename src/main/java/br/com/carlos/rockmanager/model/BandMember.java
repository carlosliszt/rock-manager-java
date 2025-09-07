package br.com.carlos.rockmanager.model;

import com.fasterxml.jackson.annotation.JsonInclude;
import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "usuariobanda")
@IdClass(BandMember.BandMemberId.class)
@Data
@AllArgsConstructor
@NoArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)
public class BandMember {

    @Id
    private int id_usuario;

    @Transient
    private String nome_usuario;

    @Id
    private int id_banda;

    @Transient
    private String nome_banda;

    private String funcao;

    @Getter
    @Setter
    public static class BandMemberId implements java.io.Serializable {

        private int id_usuario;
        private int id_banda;


        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            BandMemberId that = (BandMemberId) o;
            return id_usuario == that.id_usuario && id_banda == that.id_banda;
        }

        @Override
        public int hashCode() {
            return java.util.Objects.hash(id_usuario, id_banda);
        }
    }

    @AllArgsConstructor
    @NoArgsConstructor
    @Getter
    @Setter
    public static class BandMemberInfo {

        private int id_usuario;
        private String nome_usuario;
        private int id_banda;
        private String nome_banda;
        private String funcao;

    }


}
