package entidades;

import enumeradores.EnumPerfil;
import enumeradores.EnumTipoLancamento;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

public class Lancamento implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id_lancamento", nullable = false, length = 2)
    private int idLancamento;

    @Column(name = "desc_lancamento", nullable = false)
    private String descricaoLancamento;

    @ManyToOne(fetch = FetchType.EAGER)
    //@Column(name = "funcionario_lancamento", nullable = false)
    private Funcionario funcionario;

    @Column(name = "data_atualizacao_lanc", nullable = false)
    private Date dateUpdateLanc;

    @Column(name = "data_criacao_lanc", nullable = false)
    private Date dateCreationLanc;

    /**a notação enumerator permite qual tipo de gravação fazer para o enumerador no banco, string, inteiro, etc*/
    @Enumerated(EnumType.STRING)
    @Column(name = "tipo_lancamento", nullable = false)
    private EnumTipoLancamento tipoLancamento;

    @PreUpdate
    public void preUpdate(){
        dateUpdateLanc = new Date();
    }

    /**no momento da inserção do objeto, ele sempre vai persistir uma data de criação e a data de atualição*/
    @PrePersist
    public void prePersist(){
        Date dateNow = new Date();
        dateCreationLanc = dateNow;
        dateUpdateLanc = dateNow;
    }


}
