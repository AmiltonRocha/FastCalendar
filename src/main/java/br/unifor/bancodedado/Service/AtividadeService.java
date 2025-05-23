package br.unifor.bancodedado.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.unifor.bancodedado.model.Atividade;
import br.unifor.bancodedado.DTO.AtividadeDTO;
import br.unifor.bancodedado.Repository.AtividadeRepository;
import br.unifor.bancodedado.Repository.UsuarioRepository;
import br.unifor.bancodedado.model.Usuario;

import java.util.List;
import java.util.Optional;

@Service
public class AtividadeService {

    @Autowired
    private AtividadeRepository atividadeRepo;

    @Autowired
    private UsuarioRepository usuarioRepo;

    public Atividade salvar(AtividadeDTO dto) {
        Atividade atividade = new Atividade();
        atividade.setNome(dto.nome);
        atividade.setDiasDaSemana(dto.diasDaSemana);
        atividade.setHoraInicio(dto.horaInicio);
        atividade.setHoraFim(dto.horaFim);
        atividade.setRecorrente(dto.recorrente);
        atividade.setDuracaoRecorrencia(dto.duracaoRecorrencia);

        if (dto.responsavelId != null) {
            Optional<Usuario> responsavel = usuarioRepo.findById(dto.responsavelId);
            responsavel.ifPresent(atividade::setResponsavel);
        }

        return atividadeRepo.save(atividade);
    }

    public List<Atividade> listarTodas() {
        return atividadeRepo.findAll();
    }
}
