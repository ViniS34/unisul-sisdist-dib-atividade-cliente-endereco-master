package br.unisul.aula.mscliente.servico;

import br.unisul.aula.mscliente.dto.EnderecoDTO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@FeignClient("endereco")
public interface EnderecoClient {

    @GetMapping("/end/id/{id}")
    EnderecoDTO buscarPorId(@PathVariable(name = "id")Long id);

    @GetMapping("/end/{cep}")
    EnderecoDTO buscarPorCep(@PathVariable(name = "cep")Integer cep);

    @GetMapping("/end/cidade/{cidade}")
    List<EnderecoDTO> buscarPorCidade(@RequestParam(name = "cidade")String cidade);
}
