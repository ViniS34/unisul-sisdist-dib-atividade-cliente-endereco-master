package br.unisul.aula.mscliente.servico;

import br.unisul.aula.mscliente.dto.ClienteCidadeDTO;
import br.unisul.aula.mscliente.dto.ClienteDTO;
import br.unisul.aula.mscliente.dto.EnderecoDTO;
import br.unisul.aula.mscliente.dto.ResultadoDTO;
import br.unisul.aula.mscliente.modelo.Cliente;
import br.unisul.aula.mscliente.repositorio.ClienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.List;

@Service
public class ClienteService {

    @Autowired
    private ClienteRepository clienteRepository;
/*

    @Autowired
    private RestTemplate clienteRaimbow;
*/

    @Autowired
    private EnderecoClient enderecoClient;

    public List<ClienteDTO> listarTodos() {
        List<ClienteDTO> dtos = new ArrayList<>();
        for (Cliente cliente: clienteRepository.findAll()){
            EnderecoDTO enderecoDTO = buscarEnderecoPorID(cliente.getIdEndereco());
            ClienteDTO clienteDTO = new ClienteDTO(cliente, enderecoDTO);
            dtos.add(clienteDTO);
        }
        return dtos;
    }
    private EnderecoDTO buscarEnderecoPorID(Long id){
        return enderecoClient.buscarPorId(id);
    }
    private EnderecoDTO buscarEnderecoPorCep(Integer cep){
        return enderecoClient.buscarPorCep(cep);
    }
    public ResultadoDTO findByCidade(String cidade) {
        //TODO - BUSCAR ENDEREÇOS BASEADO NO NOME DA CIDADE
        List<EnderecoDTO> enderecos = enderecoClient.buscarPorCidade(cidade);
        //TODO - BUSCAR OS CLIENTES DAQUELE ENDEREÇO
        List<ClienteCidadeDTO> clientes = new ArrayList<>();
        for(EnderecoDTO endereco:enderecos) {
            for (Cliente cliente : clienteRepository.findByIdEndereco(endereco.getId())) {
                ClienteCidadeDTO clienteCidadeDTO = new ClienteCidadeDTO(cliente, endereco);
                clientes.add(clienteCidadeDTO);
            }
        }
        //TODO - CRIAR A INSTACIA DE RESULTADO DTO
        ResultadoDTO resultadoDTO = new ResultadoDTO();
        resultadoDTO.setCidade(cidade);
        resultadoDTO.setUf(enderecos.get(0).getUf());
        resultadoDTO.setClientes(clientes);
        //TODO - RETORNAR O RESULTDTO
        return resultadoDTO;
    }
/*

    private EnderecoDTO buscarEnderecoPorID(Long id) {
        ResponseEntity<EnderecoDTO> exchange = clienteRaimbow.exchange("http://endereco/end/id/" + id,
                HttpMethod.GET, null, EnderecoDTO.class);
        return exchange.getBody();
    }
    private EnderecoDTO buscarEnderecoPorCep(Integer cep) {
        ResponseEntity<EnderecoDTO> exchange = clienteRaimbow.exchange("http://endereco/end/" + cep,
                HttpMethod.GET, null, EnderecoDTO.class);
        return exchange.getBody();
    }
*/

    public void registrarCliente(ClienteDTO dto) {
        dto.setEndereco(buscarEnderecoPorCep(dto.getCep()));
        Cliente cliente = dto.converterParaCliente();
        clienteRepository.save(cliente);
    }

}
