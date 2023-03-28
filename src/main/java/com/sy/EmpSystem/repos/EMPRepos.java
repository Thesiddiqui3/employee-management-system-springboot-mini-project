package com.sy.EmpSystem.repos;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.sy.EmpSystem.dto.EMP;

@Repository
public interface EMPRepos extends JpaRepository<EMP, Integer>{

}
