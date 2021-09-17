package com.tech4me.prova1.service;

import java.util.List;
import java.util.Optional;

import com.tech4me.prova1.shared.MusicaDTO;


public interface MusicaService {
    MusicaDTO adicionar(MusicaDTO musicaDto);
    List<MusicaDTO> obterTodos();
    Optional<MusicaDTO> obterPoId(String id);
    MusicaDTO atualizar(String id, MusicaDTO musicaDtO);
    void deletar(String id);

}
