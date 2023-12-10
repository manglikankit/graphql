package com.manglik.graphql.Repo;

import com.manglik.graphql.Entity.Graph;
import org.springframework.data.jpa.repository.JpaRepository;

public interface GraphRepo extends JpaRepository<Graph, Integer> {

}
