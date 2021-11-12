package primary;
import java.util.List;
import java.util.Optional;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

/**
 * Copyright 2021 Charles Swires All Rights Reserved
 * @author charl
 *
 */
public interface PrimaryMongoBeanRepository extends MongoRepository<primary.PrimaryMongoBean, String>{

    public List<PrimaryMongoBean> findAll();

	@SuppressWarnings("unchecked")
    public PrimaryMongoBean save(PrimaryMongoBean entity);
	
    public Optional<PrimaryMongoBean> findById(String id);
    public void deleteById(String id);

////	@Query("{ 'firstname' : ?0, 'surname' : ?1 }")
//	public void deleteByFirstnameSurname(String firstname, String surname);
	
    @Query("{ 'firstname' : ?0, 'surname' : ?1 }")
    public PrimaryMongoBean findByFirstnameSurname(String firstname, String surname);
    public List<PrimaryMongoBean> findBySurnameOrderByFirstname(String surname);

    public List<PrimaryMongoBean> findByFirstnameOrderBySurname(String firstname);

	
//	@Query("{ 'name' : { $regex: '?0.*?1.*' } }")
//	public List<MongoBean> findBeansByRegexpFirstSecond(String first, String second);
}
