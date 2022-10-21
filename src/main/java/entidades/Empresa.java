package entidades;
import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "empresa")
public class Empresa implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id_empresa", nullable = false, length = 2)
    private Long idEmpresa;

    /**-> o cascade remove todos os filhos da empresa junto
     * -> one to many é porque é um vinculo 1 pra muitos
     * -> o fetch está programado para buscar como lazy, pois não quer todos os dados de funcionários e sim apenas a lista de funcionários
     * -> outro tipo de fetch é o EAGER, onde faz um select com join, trazendo todos os dados dos funcionários juntos com a listagem*/
    @OneToMany(mappedBy = "empresa", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    //@Column(name = "funcionarios")
    private List<Funcionario> funcionarios;


    @Column(name = "cnpj", nullable = false)
    private String cnpj;

    @Column(name = "nome", nullable = false)
    private String nome;

    @Column(name = "data_atualizacao_emp", nullable = false)
    private Date dateUpdateEmp;

    @Column(name = "data_criacao_emp", nullable = false)
    private Date dateCreationEmp;

    /**no momento de update do objeto, ele sempre vai persistir uma data de atualição*/
    @PreUpdate
    public void preUpdate(){
        dateUpdateEmp = new Date();
    }

    /**no momento da inserção do objeto, ele sempre vai persistir uma data de criação e a data de atualição*/
    @PrePersist
    public void prePersist(){
        Date dateNow = new Date();
        dateCreationEmp = dateNow;
        dateUpdateEmp = dateNow;
    }

}

