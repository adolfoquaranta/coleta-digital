package me.adolfoquaranta.coletadigital.modelos;

/**
 * Created by adolfo on 18/10/16.
 */

public class Tratamento {
    private Long id_Tratamento, idFormulario_Tratamento;
    private Integer tipo_Tratamento;
    private String nome_Tratamento;

    public Tratamento() {
    }

    public Long getId_Tratamento() {
        return id_Tratamento;
    }

    public void setId_Tratamento(Long id_Tratamento) {
        this.id_Tratamento = id_Tratamento;
    }

    public Integer getTipo_Tratamento() {
        return tipo_Tratamento;
    }

    public void setTipo_Tratamento(Integer tipo_Tratamento) {
        this.tipo_Tratamento = tipo_Tratamento;
    }

    public String getNome_Tratamento() {
        return nome_Tratamento;
    }

    public void setNome_Tratamento(String nome_Tratamento) {
        this.nome_Tratamento = nome_Tratamento;
    }

    public Long getIdFormulario_Tratamento() {
        return idFormulario_Tratamento;
    }

    public void setIdFormulario_Tratamento(Long idFormulario_Tratamento) {
        this.idFormulario_Tratamento = idFormulario_Tratamento;
    }

    @Override
    public String toString() {
        return "Tratamento{" +
                "id_Tratamento=" + id_Tratamento +
                ", idFormulario_Tratamento=" + idFormulario_Tratamento +
                ", tipo_Tratamento=" + tipo_Tratamento +
                ", nome_Tratamento='" + nome_Tratamento + '\'' +
                '}';
    }
}
