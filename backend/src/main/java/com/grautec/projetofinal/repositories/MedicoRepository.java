package com.grautec.projetofinal.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.grautec.projetofinal.entities.Medico;

@Repository
public interface MedicoRepository extends JpaRepository<Medico, Integer>{

}
