package com.erole.moviErole.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.erole.moviErole.model.Role;
import com.erole.moviErole.repository.RoleRepository;

/**
 * Implemetacion de la interfaz que funciona como capa intermedia entre el controller y repository.
 * @author pepes
 *
 */
@Service
public class RoleService {
	@Autowired
	RoleRepository roleRep;
	
	/**
	 * Busca dentro de la BD si el rol con ese nombre existe.
	 * @param name -> nombre a buscar.
	 * @return -> objeto de la clase Role que se corresponda con el nombre. null si no existe.
	 */
	public Role searchByName(String name) {
		return roleRep.findByName(name);
	}
}