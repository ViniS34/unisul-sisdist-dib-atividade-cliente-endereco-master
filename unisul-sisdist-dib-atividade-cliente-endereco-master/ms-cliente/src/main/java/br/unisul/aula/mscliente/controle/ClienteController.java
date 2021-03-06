package br.unisul.aula.mscliente.controle;

import br.unisul.aula.mscliente.dto.ClienteDTO;
import br.unisul.aula.mscliente.dto.EnderecoDTO;
import br.unisul.aula.mscliente.dto.ResultadoDTO;
import br.unisul.aula.mscliente.repositorio.ClienteRepository;
import br.unisul.aula.mscliente.servico.ClienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/cli")
public class ClienteController {

    @Autowired
    private ClienteService service;


    @GetMapping("/")
    public List<ClienteDTO> listarTodosClientes(){
        return service.listarTodos();
    }
    @PostMapping("/")
    public void inserirCliente(@RequestBody ClienteDTO dto){
        service.registrarCliente(dto);
    }
    @GetMapping("/cidade")
    public ResultadoDTO findByCidade(String cidade){
        return service.findByCidade(cidade);
    }

}
