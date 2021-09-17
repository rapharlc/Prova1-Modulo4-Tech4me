package com.tech4me.prova1.service;

import java.util.InputMismatchException;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import com.tech4me.prova1.model.Musica;
import com.tech4me.prova1.repository.MusicaRepository;
import com.tech4me.prova1.shared.MusicaDTO;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MusicaServiceImpl implements MusicaService{

    @Autowired
    MusicaRepository repositorioMusica;
    
    @Override
    public MusicaDTO adicionar(MusicaDTO musicaDto) {
        musicaDto.setId(null);
        ModelMapper mapper = new ModelMapper();
        Musica musica = mapper.map(musicaDto, Musica.class);
        musica = repositorioMusica.save(musica);
        return mapper.map(musica, MusicaDTO.class);
    }

    @Override
    public List<MusicaDTO> obterTodos() {
        List<Musica> musicas = repositorioMusica.findAll();
        ModelMapper mapper = new ModelMapper();
        List<MusicaDTO> musicasDto = musicas.stream().map(musica -> mapper.map(musica, MusicaDTO.class)).collect(Collectors.toList());
        return musicasDto;
    }

    @Override
    public Optional<MusicaDTO> obterPoId(String id) {
        Optional<Musica> musica = repositorioMusica.findById(id);
            if(musica.isEmpty()){
                throw new InputMismatchException("Musica com ID " + id + " não encontrado");
            }    
        MusicaDTO musicaDto = new ModelMapper().map(musica.get(), MusicaDTO.class);
        return Optional.of(musicaDto);
    }

    @Override
    public MusicaDTO atualizar(String id, MusicaDTO musicaDto) {
        musicaDto.setId(id);
        ModelMapper mapper = new ModelMapper();
        Musica musica = mapper.map(musicaDto, Musica.class);
        musica = repositorioMusica.save(musica);
        return mapper.map(musica, MusicaDTO.class);
    }

    @Override
    public void deletar(String id) {
       Optional<Musica> musica = repositorioMusica.findById(id);
            if(musica.isEmpty()){
                throw new InputMismatchException("Música com id: " + id + "não encontrada - Impossível deletar");
            }
        repositorioMusica.deleteById(id);
    }
    
}
