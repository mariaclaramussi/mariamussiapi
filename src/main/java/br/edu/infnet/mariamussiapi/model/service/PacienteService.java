package br.edu.infnet.mariamussiapi.model.service;

import br.edu.infnet.mariamussiapi.model.domain.Agendamento;
import br.edu.infnet.mariamussiapi.model.domain.Paciente;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PacienteService implements CrudService<Paciente, Integer>{

    @Override
    public Paciente adicionar(Paciente object) {
        return null;
    }

    @Override
    public Paciente editar(Integer integer, Paciente object) {
        return null;
    }

    @Override
    public void excluir(Integer integer) {

    }

    @Override
    public Paciente obterPorId(Integer integer) {
        return null;
    }

    @Override
    public List<Paciente> obterLista() {
        return List.of();
    }

    public List<Agendamento> verificarConsultas(Integer id) {
        // TODO: verificar se existe consultas para o paciente
        return null;
    }
}
