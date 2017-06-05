package me.adolfoquaranta.coletadigital.modelos;

/**
 * Created by adolfo on 09/11/16.
 */

public class Dado {

    private Long id_Dado, idColeta_Dado, idVariavel_Dado, idTratamento_Dado;
    private String valor_Dado;
    private Integer repeticao_Dado, replicacao_Dado, tratamento_Dado, variavel_Dado, bloco_Dado, fator_Dado, divisao_Dado, nivelFator_Dado, nivelDivisao_Dado;

    public Dado() {
    }

    public Dado(Long id_Dado, Integer tratamento_Dado, Integer variavel_Dado, Long idColeta_Dado, String valor_Dado, Integer repeticao_Dado, Integer replicacao_Dado, Integer bloco_Dado, Integer fator_Dado, Integer divisao_Dado, Integer nivelFator_Dado, Integer nivelDivisao_Dado, Long idVariavel_Dado, Long idTratamento_Dado) {
        this.id_Dado = id_Dado;
        this.tratamento_Dado = tratamento_Dado;
        this.variavel_Dado = variavel_Dado;
        this.idColeta_Dado = idColeta_Dado;
        this.valor_Dado = valor_Dado;
        this.repeticao_Dado = repeticao_Dado;
        this.replicacao_Dado = replicacao_Dado;
        this.bloco_Dado = bloco_Dado;
        this.fator_Dado = fator_Dado;
        this.divisao_Dado = divisao_Dado;
        this.nivelFator_Dado = nivelFator_Dado;
        this.nivelDivisao_Dado = nivelDivisao_Dado;
        this.idVariavel_Dado = idVariavel_Dado;
        this.idTratamento_Dado = idTratamento_Dado;
    }

    public Long getId_Dado() {
        return id_Dado;
    }

    public void setId_Dado(Long id_Dado) {
        this.id_Dado = id_Dado;
    }

    public Integer getTratamento_Dado() {
        return tratamento_Dado;
    }

    public void setTratamento_Dado(Integer tratamento_Dado) {
        this.tratamento_Dado = tratamento_Dado;
    }

    public Long getIdVariavel_Dado() {
        return idVariavel_Dado;
    }

    public void setIdVariavel_Dado(Long idVariavel_Dado) {
        this.idVariavel_Dado = idVariavel_Dado;
    }

    public Long getIdTratamento_Dado() {
        return idTratamento_Dado;
    }

    public void setIdTratamento_Dado(Long idTratamento_Dado) {
        this.idTratamento_Dado = idTratamento_Dado;
    }

    public Integer getVariavel_Dado() {
        return variavel_Dado;
    }

    public void setVariavel_Dado(Integer variavel_Dado) {
        this.variavel_Dado = variavel_Dado;
    }

    public Long getIdColeta_Dado() {
        return idColeta_Dado;
    }

    public void setIdColeta_Dado(Long idColeta_Dado) {
        this.idColeta_Dado = idColeta_Dado;
    }

    public String getValor_Dado() {
        return valor_Dado;
    }

    public void setValor_Dado(String valor_Dado) {
        this.valor_Dado = valor_Dado;
    }

    public Integer getRepeticao_Dado() {
        return repeticao_Dado;
    }

    public void setRepeticao_Dado(Integer repeticao_Dado) {
        this.repeticao_Dado = repeticao_Dado;
    }

    public Integer getReplicacao_Dado() {
        return replicacao_Dado;
    }

    public void setReplicacao_Dado(Integer replicacao_Dado) {
        this.replicacao_Dado = replicacao_Dado;
    }

    public Integer getBloco_Dado() {
        return bloco_Dado;
    }

    public void setBloco_Dado(Integer bloco_Dado) {
        this.bloco_Dado = bloco_Dado;
    }

    public Integer getFator_Dado() {
        return fator_Dado;
    }

    public void setFator_Dado(Integer fator_Dado) {
        this.fator_Dado = fator_Dado;
    }

    public Integer getParcela_Dado() {
        return divisao_Dado;
    }

    public void setParcela_Dado(Integer divisao_Dado) {
        this.divisao_Dado = divisao_Dado;
    }

    public Integer getNivelFator_Dado() {
        return nivelFator_Dado;
    }

    public void setNivelFator_Dado(Integer nivelFator_Dado) {
        this.nivelFator_Dado = nivelFator_Dado;
    }

    public Integer getNivelParcela_Dado() {
        return nivelDivisao_Dado;
    }

    public void setNivelParcela_Dado(Integer nivelDivisao_Dado) {
        this.nivelDivisao_Dado = nivelDivisao_Dado;
    }

    @Override
    public String toString() {
        return "Dado{" +
                "id_Dado=" + id_Dado +
                ", idColeta_Dado=" + idColeta_Dado +
                ", idVariavel_Dado=" + idVariavel_Dado +
                ", idTratamento_Dado=" + idTratamento_Dado +
                ", valor_Dado='" + valor_Dado + '\'' +
                ", repeticao_Dado=" + repeticao_Dado +
                ", replicacao_Dado=" + replicacao_Dado +
                ", tratamento_Dado=" + tratamento_Dado +
                ", variavel_Dado=" + variavel_Dado +
                ", bloco_Dado=" + bloco_Dado +
                ", fator_Dado=" + fator_Dado +
                ", divisao_Dado=" + divisao_Dado +
                ", nivelFator_Dado=" + nivelFator_Dado +
                ", nivelDivisao_Dado=" + nivelDivisao_Dado +
                '}';
    }
}
