package br.com.alura.challenge_forumhub_topicos.topico;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;

import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Table(name = "topicos")
@Entity(name = "Topico")
@Getter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "id")
public class Topico {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String titulo;
    private String mensagem;
    private LocalDateTime data_de_criacao;
    private Boolean estadoDoTopico;
    private String autor;
    private String curso;

    public Topico(DadosCadastroTopico textojson) {
        this.titulo = textojson.titulo();
        this.mensagem = textojson.mensagem();
        this.data_de_criacao = LocalDateTime.now();
        this.estadoDoTopico = true;
        this.autor = textojson.autor();
        this.curso = textojson.curso();
    }

    public void atualizarInformacoes(DadosAtualizacaoTopico dados) {
        if(dados.titulo() != null) {
            this.titulo = dados.titulo();
        }
        if(dados.mensagem() != null) {
            this.mensagem = dados.mensagem();
        }
        if(dados.autor() != null) {
            this.autor = dados.autor();
        }
        if(dados.curso() != null) {
            this.curso = dados.curso();
        }
    }

    public void excluir() {
        this.estadoDoTopico = false;
    }
}
