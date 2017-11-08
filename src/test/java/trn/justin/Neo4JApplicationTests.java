package trn.justin;

import static org.hamcrest.Matchers.is;
import static org.hamcrest.Matchers.hasSize;
import static org.hamcrest.CoreMatchers.notNullValue;
import static org.junit.Assert.assertThat;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;

import trn.justin.dao.repositories.CompanyRepository;
import trn.justin.dao.repositories.PersonRepository;
import trn.justin.model.nodes.Address;
import trn.justin.model.nodes.Company;
import trn.justin.model.nodes.Person;
import trn.justin.model.nodes.Vehicle;
import trn.justin.model.relationships.PersonOwnsVehicle;
import trn.justin.model.relationships.PersonResidesAtAddress;
import trn.justin.model.relationships.CompanyResidesAtAddress;
import trn.justin.model.relationships.CompanyServicesVehicle;

@RunWith(SpringRunner.class)
@SpringBootTest
@Transactional
public class Neo4JApplicationTests {
	
	@Autowired 
	PersonRepository personRepository;
	@Autowired 
	CompanyRepository companyRepository;
	
	@Test
	public void saveAndLoadNodesAndRelations(){
		Person createPerson = new Person("John", "Doe");
		Vehicle createVehicle = new Vehicle("Piece of Crap");
		createPerson.ownsVehicle(createVehicle);
		
		personRepository.save(createPerson); // Should save person, vehicle and relationship
		System.out.println("Person/Vehicle Saved");
		System.out.println("PersonID="+createPerson.getId()+", FirstName="+createPerson.getFirstName()+", LastName="+createPerson.getLastName()+", VehicleID="+createVehicle.getId()+", Description="+createVehicle.getDescription());
		
		Person loadPerson = personRepository.findById(createPerson.getId()).orElse(null);
		assertThat(loadPerson, is(notNullValue()));
		assertThat(loadPerson.getFirstName(), is(createPerson.getFirstName()));
		assertThat(loadPerson.getLastName(), is(createPerson.getLastName()));
		assertThat(loadPerson.getOwns(), hasSize(1));
		System.out.println("Person/Vehicle Loaded");
		System.out.println("PersonID="+loadPerson.getId()+", FirstName="+loadPerson.getFirstName()+", LastName="+loadPerson.getLastName());
		
		PersonOwnsVehicle ownership = loadPerson.getOwns().iterator().next();
		assertThat(ownership, is(notNullValue()));
		assertThat(ownership.getVehicle().getDescription(), is(createVehicle.getDescription()));
		System.out.println("Loaded Ownership");
		System.out.println("RelationshipID="+ownership.getId()+", VehicleID="+ownership.getVehicle().getId()+", Description="+ownership.getVehicle().getDescription());
	}
	
	@Test
	public void saveAndLoadNodeRelationProperties(){
		
		Company createCompany = new Company("Top Mechanic");
		Vehicle createVehicle = new Vehicle("Piece of Crap");
		createCompany.servicesVehicle(createVehicle, "Replace Engine");
		
		companyRepository.save(createCompany); // Should save company, vehicle and relationship
		System.out.println("Company/Vehicle Saved");
		System.out.println("CompanyID="+createCompany.getId()+", Name="+createCompany.getName()+", VehicleID="+createVehicle.getId()+", Description="+createVehicle.getDescription());
		
		Company loadCompany = companyRepository.findById(createCompany.getId()).orElse(null);
		assertThat(loadCompany, is(notNullValue()));
		assertThat(loadCompany.getName(), is(createCompany.getName()));
		assertThat(loadCompany.getServices(), hasSize(1));
		System.out.println("Company Loaded");
		System.out.println("CompanyID="+loadCompany.getId()+", Name="+loadCompany.getName());
		
		CompanyServicesVehicle services = loadCompany.getServices().iterator().next();
		assertThat(services, is(notNullValue()));
		assertThat(services.getServices().getDescription(), is(createCompany.getServices().iterator().next().getServices().getDescription()));
		assertThat(services.getVehicle().getDescription(), is(createVehicle.getDescription()));
		System.out.println("Loaded Service");
		System.out.println("RelationshipID="+services.getId()+", description="+services.getServices().getDescription()+", VehicleID="+services.getVehicle().getId()+", Description="+services.getVehicle().getDescription());
	}
	
	@Test
	public void saveAndLoadMultiTypeNodeRelations(){
		
		Company createCompany = new Company("Top Mechanic");
		Person createPerson = new Person("John", "Doe");
		Address createAddress = new Address("John's Home", "123 Mystery Lane", null, "Salt Lake City", "UT", "84120", null, "Occupied");
		createCompany.residesAt(createAddress, "John's Business Mailing Address");
		createPerson.residesAt(createAddress, "Home Owner");
		
		companyRepository.save(createCompany); 
		personRepository.save(createPerson);
		System.out.println("Company/Person/Address Saved");
		System.out.println("CompanyID="+createCompany.getId()+", Name="+createCompany.getName()+
				"\n, PersonID="+createPerson.getId()+", Description="+createPerson.getLastName()+", "+createPerson.getFirstName()+
				"\n, AddressID="+createAddress.getId()+", Name="+createAddress.getName()+", Street="+createAddress.getStreet1());
		
		Company loadCompany = companyRepository.findById(createCompany.getId()).orElse(null);
		Person loadPerson = personRepository.findById(createPerson.getId()).orElse(null);
		assertThat(loadCompany, is(notNullValue()));
		assertThat(loadPerson, is(notNullValue()));
		assertThat(loadCompany.getResidesAt(), hasSize(1));
		assertThat(loadCompany.getResidesAt(), hasSize(1));
		System.out.println("Company/Person Loaded");
		
		CompanyResidesAtAddress companyRelation = loadCompany.getResidesAt().iterator().next();
		PersonResidesAtAddress personRelation = loadPerson.getResidesAt().iterator().next();
		assertThat(companyRelation.getAddress(), is(personRelation.getAddress()));
		System.out.println("Company Address is same as Person Address");
		
		// Update address in one case and check the other
		personRelation.getAddress().setName("John's Mailing Address");
		personRepository.save(loadPerson);
		assertThat(companyRelation.getAddress().getName(), is("John's Mailing Address"));
		System.out.println("Company Address updated also");
		
	}
	
	@Test
	public void contextLoads() {
	}

}
