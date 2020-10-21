package com.example.ultimateconnect4.Models;

public class Utilizador {
    int m_id;
    int m_vitorias_facil;
    int m_derrotas_facil;
    int m_vitorias_media;
    int m_derrotas_media;
    int m_vitorias_dificil;
    int m_derrotas_dificil;


    public Utilizador() {
    }

    public Utilizador(int m_id) {
        this.m_id = m_id;
        this.m_vitorias_facil = 0;
        this.m_derrotas_facil = 0;
        this.m_vitorias_media = 0;
        this.m_derrotas_media = 0;
        this.m_vitorias_dificil = 0;
        this.m_derrotas_dificil = 0;
    }

    public Utilizador(int m_id, int m_vitorias_facil, int m_derrotas_facil, int m_vitorias_media, int m_derrotas_media, int m_vitorias_dificil, int m_derrotas_dificil) {
        this.m_id = m_id;
        this.m_vitorias_facil = m_vitorias_facil;
        this.m_derrotas_facil = m_derrotas_facil;
        this.m_vitorias_media = m_vitorias_media;
        this.m_derrotas_media = m_derrotas_media;
        this.m_vitorias_dificil = m_vitorias_dificil;
        this.m_derrotas_dificil = m_derrotas_dificil;
    }

    public int getM_id() {
        return m_id;
    }

    public void setM_id(int m_id) {
        this.m_id = m_id;
    }

    public int getM_vitorias_facil() {
        return m_vitorias_facil;
    }

    public void setM_vitorias_facil(int m_vitorias_facil) {
        this.m_vitorias_facil = m_vitorias_facil;
    }

    public int getM_derrotas_facil() {
        return m_derrotas_facil;
    }

    public void setM_derrotas_facil(int m_derrotas_facil) {
        this.m_derrotas_facil = m_derrotas_facil;
    }

    public int getM_vitorias_media() {
        return m_vitorias_media;
    }

    public void setM_vitorias_media(int m_vitorias_media) {
        this.m_vitorias_media = m_vitorias_media;
    }

    public int getM_derrotas_media() {
        return m_derrotas_media;
    }

    public void setM_derrotas_media(int m_derrotas_media) {
        this.m_derrotas_media = m_derrotas_media;
    }

    public int getM_vitorias_dificil() {
        return m_vitorias_dificil;
    }

    public void setM_vitorias_dificil(int m_vitorias_dificil) {
        this.m_vitorias_dificil = m_vitorias_dificil;
    }

    public int getM_derrotas_dificil() {
        return m_derrotas_dificil;
    }

    public void setM_derrotas_dificil(int m_derrotas_dificil) {
        this.m_derrotas_dificil = m_derrotas_dificil;
    }
}
