package com.superbodega.negocio.service;

import com.superbodega.negocio.entity.Cliente;
import java.util.List;

public interface ClienteService {
    List<Cliente> getAllClientes();
    Cliente getClienteById(Long id);
    Cliente getClienteByCodigo(String codigo);
    Cliente saveCliente(Cliente cliente);
    Cliente updateCliente(Long id, Cliente cliente);
    void deleteCliente(Long id);
}
