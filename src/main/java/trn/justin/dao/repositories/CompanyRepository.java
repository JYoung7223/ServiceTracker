package trn.justin.dao.repositories;

import org.springframework.data.neo4j.repository.Neo4jRepository;
import org.springframework.stereotype.Repository;

import trn.justin.model.nodes.Company;

@Repository
public interface CompanyRepository extends Neo4jRepository<Company, Long> {

}
