package com.guilherme.example.entities;

public class Aula {

    private Long id;
    private String titulo;
    private String descricao;
    private Integer duracaoMinutos;
    private Integer ordem;
    private String urlVideo;
    private Curso curso;

    public Aula() {}

    public Aula(Long id, String titulo, String descricao, Integer duracaoMinutos, Integer ordem, String urlVideo,
            Curso curso) {
        this.id = id;
        this.titulo = titulo;
        this.descricao = descricao;
        this.duracaoMinutos = duracaoMinutos;
        this.ordem = ordem;
        this.urlVideo = urlVideo;
        this.curso = curso;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public Integer getDuracaoMinutos() {
        return duracaoMinutos;
    }

    public void setDuracaoMinutos(Integer duracaoMinutos) {
        this.duracaoMinutos = duracaoMinutos;
    }

    public Integer getOrdem() {
        return ordem;
    }

    public void setOrdem(Integer ordem) {
        this.ordem = ordem;
    }

    public String getUrlVideo() {
        return urlVideo;
    }

    public void setUrlVideo(String urlVideo) {
        this.urlVideo = urlVideo;
    }

    public Curso getCurso() {
        return curso;
    }

    public void setCurso(Curso curso) {
        this.curso = curso;
    }
}