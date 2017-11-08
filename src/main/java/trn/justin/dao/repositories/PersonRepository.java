package trn.justin.dao.repositories;

import org.springframework.data.neo4j.repository.Neo4jRepository;
import org.springframework.stereotype.Repository;

import trn.justin.model.nodes.Person;

@Repository
public interface PersonRepository extends Neo4jRepository<Person, Long> {

}
