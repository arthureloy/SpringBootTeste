package entidades;

import enumeradores.EnumPerfil;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;
import java.util.List;

public class Funcionario implements Serializable {


    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id_funcionario", nullable = false, length = 2)
    private int idFuncionario;

    @Column(name = "nome_funcionario", nullable = false)
    private String nomeFuncionario;

    @Column(name = "idade_funcionario", nullable = false)
    private int idadeFuncionario;

    @Column(name = "cpf_funcionario", nullable = false)
    private String cpfFuncionario;

    /**a notação enumerator permite qual tipo de gravação fazer para o enumerador no banco, string, inteiro, etc*/
    @Enumerated(EnumType.STRING)
    @Column(name = "perfil_funcionario", nullable = false)
    private EnumPerfil perfilFuncionario;

    @Column(name = "data_atualizacao_func", nullable = false)
    private Date dateUpdateFunc;

    @Column(name = "data_criacao_func", nullable = false)
    private Date dateCreationFunc;

    @ManyToOne(fetch = FetchType.EAGER)
    //@Column(name = "empresa_funcionario", nullable = false)
    private Empresa empresa;

    @OneToMany(mappedBy = "funcionario", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    //@Column(name = "lancamentos_funcionario")
    private List<Lancamento> lancamentos;

    /**no momento de update do objeto, ele sempre vai persistir uma data de atualição*/
    @PreUpdate
    public void preUpdate(){
        dateUpdateFunc = new Date();
    }

    /**no momento da inserção do objeto, ele sempre vai persistir uma data de criação e a data de atualição*/
    @PrePersist
    public void prePersist(){
        Date dateNow = new Date();
        dateCreationFunc = dateNow;
        dateUpdateFunc = dateNow;
    }
}
